/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import db.konstante.Konstante;
import domen.OpstiDomenskiObjekat;
import domen.Zaposleni;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.SettingsLoader;

/**
 *
 * @author urosv
 */
public class DBBroker {

    Connection connection;

    public void ucitajDrajver() {
        try {
            Class.forName(SettingsLoader.getInstance().getValue(Konstante.DRIVER));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Greska prilikom ucitavanja drajvera");
        }
    }

    public void otvoriKonekciju() {
        try {
            String url = SettingsLoader.getInstance().getValue(Konstante.URL);
            String user = SettingsLoader.getInstance().getValue(Konstante.USER);
            String pass = SettingsLoader.getInstance().getValue(Konstante.PASS);
            connection = DriverManager.getConnection(url, user, pass);
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            System.out.println("Greska prilikom uspostavljanja konekcije");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void zatvoriKonekciju() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Greska prilikom zatvaranja konekcije");
        }
    }

    public void commit() {
        try {
            connection.commit();
        } catch (SQLException ex) {
            System.out.println("Greska prilikom commit-a transakcije");
        }
    }

    public void rollback() {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            System.out.println("Greska prilikom rollback-a transakcije");
        }
    }

    public OpstiDomenskiObjekat pronadji(OpstiDomenskiObjekat odo) throws Exception {
        try {
            String upit = odo.dajSelectJedan() + " "
                    + odo.dajFromJedan() + " "
                    + odo.dajWhereJedan();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(upit);
            return odo.ucitajJedan(resultSet);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Greska prilikom ucitavanja objekta " + odo.vratiNazivTabele(), ex);
        }
    }

    public ArrayList<OpstiDomenskiObjekat> pronadjiSve(OpstiDomenskiObjekat odo) throws Exception {
        try {
            String upit = odo.dajSelectSvi() + " "
                    + odo.dajFromSvi() + " "
                    + odo.dajWhereSvi();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(upit);
            return (ArrayList<OpstiDomenskiObjekat>) odo.ucitajSve(resultSet);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Greska prilikom ucitavanja objekta " + odo.vratiNazivTabele(), ex);
        }
    }

    public OpstiDomenskiObjekat kreiraj(OpstiDomenskiObjekat odo) throws Exception {
        String upit = odo.vratiAtributeZaInsert() + " VALUES  " + odo.vratiVrednostiZaInsert();

        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(upit, Statement.RETURN_GENERATED_KEYS);

            if (odo.jesteAutoIncrement()) {
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    odo.postaviObjektaID(rs.getInt(1));
                }
            }
            return odo;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Greska prilikom dodavanja objekta " + odo.vratiNazivTabele(), ex);

        }

    }

    public OpstiDomenskiObjekat obrisi(OpstiDomenskiObjekat odo) throws Exception {
        String upit = odo.vratiParametreDelete() + " " + odo.vratiVrednostiDelete();

        Statement statement = null;
        try {
            statement = connection.createStatement();
            
            if (1 == statement.executeUpdate(upit)) 
                return odo;
            else
                throw new Exception("Sistem nije uspeo da obrise proizvod...");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    //Bukvalno kopirana metoda pronadjiSve(), sta raditi ????
    public ArrayList<OpstiDomenskiObjekat> pronadjiNeke(OpstiDomenskiObjekat odo) throws Exception {
        try {
            String upit = odo.dajSelectSvi() + " " + odo.dajFromSvi() + " " + odo.dajWhereSvi();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(upit);
            return (ArrayList<OpstiDomenskiObjekat>) odo.ucitajSve(resultSet);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Greska prilikom ucitavanja objekta " + odo.vratiNazivTabele(), ex);
        }
    }

    public OpstiDomenskiObjekat izmeni(OpstiDomenskiObjekat odo) {
        String upit = odo.dajUpdate() + " " + odo.dajSet() + " " + odo.dajUslovZaUpdate();

        try {
            Statement statement = connection.createStatement();
            int dobro = statement.executeUpdate(upit);
            if (dobro == 1) {
                return odo;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
