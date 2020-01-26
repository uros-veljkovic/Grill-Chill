/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste.impl;

import baza.konekcija.FabrikaKonekcija;
import domen.MernaJedinica;
import domen.Proizvod;
import domen.Racun;
import domen.StavkaRacuna;
import domen.Zaposleni;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontroler.KontrolerGUI;
import skladiste.SkladisteRacun;

/**
 *
 * @author urosv
 */
public class SkladisteRacunImpl implements SkladisteRacun {

    @Override
    public Racun kreirajNoviRacun(Racun racun) throws SQLException {

        try {
            Connection konekcija = FabrikaKonekcija.getInstance().getKonekcija();
            String upit = "INSERT INTO racun (UkupanIznos, Obradjen, Storniran, KreiraoZaposleni, DatumIzrade) VALUES (?,?,?,?,?)";
            PreparedStatement ps = konekcija.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, racun.getUkupanIznos());
            ps.setBoolean(2, racun.isObradjen());
            ps.setBoolean(3, racun.isStorniran());
            ps.setInt(4, racun.getKreiraoZaposleni().getZaposleniID());
            ps.setDate(5, new Date(racun.getDatumIzrade().getTime()));

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                System.out.println(rs.getInt(1));
                racun.setRacunID(rs.getInt(1));
                upit = "INSERT INTO stavkaracuna (StavkaID, RacunID, Kolicina, Proizvod, UkupanIznos) VALUES (?,?,?,?,?)";
                ps = konekcija.prepareStatement(upit);
                for (StavkaRacuna stavka : racun.getStavke()) {

                    ps.setInt(1, stavka.getStavkaID());
                    ps.setInt(2, racun.getRacunID());
                    ps.setInt(3, stavka.getKolicina());
                    ps.setInt(4, stavka.getProizvod().getProizvodID());
                    ps.setDouble(5, stavka.getUkupanIznos());

                    ps.executeUpdate();
                }
            }
        } catch (SQLException sqex) {
            throw new SQLException(sqex.getMessage());
        }

        return racun;
    }

    @Override
    public Racun zapamtiRacun(Racun racun) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Racun obradiRacun(Racun racun) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Racun> pretraziRacune(Zaposleni zaposleni) throws SQLException{
        ArrayList<Racun> listaRacuna = null;

        try {
            Connection konekcija = FabrikaKonekcija.getInstance().getKonekcija();

            String upit = "SELECT * FROM racun WHERE KreiraoZaposleni = " + zaposleni.getZaposleniID();
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);

            listaRacuna = new ArrayList<>();
            
            while (rs.next()) {
                int racunID = rs.getInt("RacunID");
                ArrayList<StavkaRacuna> listaStavki = pretraziStavkeRacuna(racunID);

                listaRacuna.add(new Racun(rs.getInt("RacunID"),
                        zaposleni,
                        rs.getDate("DatumIzrade"),
                        rs.getDouble("UkupanIznos"),
                        rs.getBoolean("Obradjen"),
                        rs.getBoolean("Storniran"),
                        listaStavki));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        }

        return listaRacuna;
    }

    @Override
    public Racun stornirajRacun(Racun racun) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private ArrayList<StavkaRacuna> pretraziStavkeRacuna(int racunID) {
        ArrayList<StavkaRacuna> listaStavki = null;
        String upit = "SELECT * FROM stavkaracuna WHERE RacunID = " + racunID;

        try {
            Connection konekcija = FabrikaKonekcija.getInstance().getKonekcija();
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);

            listaStavki = new ArrayList<>();

            while (rs.next()) {
                int proizvodID = rs.getInt("Proizvod");
                Proizvod proizvod = pretraziProizvod(proizvodID);

                listaStavki.add(new StavkaRacuna(rs.getInt("StavkaID"), rs.getInt("RacunID"), rs.getInt("Kolicina"), proizvod));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SkladisteRacunImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaStavki;

    }

    private Proizvod pretraziProizvod(int proizvodID) {
        String upit = "SELECT * FROM proizvod WHERE ProizvodID = " + proizvodID;
        Proizvod proizvod = null;

        Connection konekcija;
        try {
            konekcija = FabrikaKonekcija.getInstance().getKonekcija();
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            
            while(rs.next()){
            proizvod = new Proizvod(proizvodID,
                                    rs.getString("Naziv"), 
                                    rs.getString("Opis"), 
                                    rs.getDouble("Cena"), 
                                    MernaJedinica.valueOf(rs.getString("MernaJedinica")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SkladisteRacunImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return proizvod;
    }

}
