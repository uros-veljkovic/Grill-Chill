/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.modeli;

import domen.Proizvod;
import domen.Racun;
import domen.StatusStavke;
import domen.StavkaRacuna;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author urosv
 */
public class ModelTabeleRacun extends AbstractTableModel {

    Racun racun;
    String[] koloneTabele = {"Naziv proizvoda", "Iznos", "Kolicina", "Ukupan iznos"};

    public ModelTabeleRacun(Racun racun) {
        this.racun = racun;
    }
    public ModelTabeleRacun() {
    }

    @Override
    public int getRowCount() {
        return racun.getNeobrisaneStavke().size();
    }

    @Override
    public int getColumnCount() {
        return koloneTabele.length;
    }

    @Override
    public Object getValueAt(int rowNum, int colNum) {
        //Ovde probaj da izvuces samo one stavke koje nisu obrisane
        StavkaRacuna stavkaRacuna = racun.getNeobrisaneStavke().get(rowNum);

        switch (colNum) {
            case 0:
                return stavkaRacuna.getProizvod().getNaziv();
            case 1:
                return stavkaRacuna.getProizvod().getCena();
            case 2:
                return stavkaRacuna.getKolicina();
            case 3:
                return stavkaRacuna.getKolicina() * stavkaRacuna.getProizvod().getCena();
            default:
                return -1;
        }
    }

    @Override
    public String getColumnName(int colNum) {
        return koloneTabele[colNum];
    }

    public void dodajStavku(Proizvod proizvod, int kolicina) {

        if (postojiUListi(proizvod)) {
            povecajKolicinu(proizvod, kolicina);
        } else {
            StavkaRacuna stavkaRacuna = new StavkaRacuna();
            stavkaRacuna.setKolicina(kolicina);
            stavkaRacuna.setProizvod(proizvod);
            stavkaRacuna.setStavkaID(racun.getStavke().size() + 1);
            stavkaRacuna.setUkupanIznos(kolicina * proizvod.getCena());
            stavkaRacuna.setStatus(StatusStavke.NOVA);

            racun.dodajStavku(stavkaRacuna);
        }
        racun.ucitajUkupanIznos();
        //racun.setUkupanIznos(racun.getUkupanIznos() + proizvod.getCena() * kolicina);
        srediRedneBrojeve();
        fireTableDataChanged();

    }

    public Racun getRacun() {
        return this.racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public void obrisiStavku(int red) {
        StavkaRacuna stavka = racun.getStavke().get(red);
        if (stavka.getStatus() == StatusStavke.STARA || stavka.getStatus() == StatusStavke.IZMENJENA) {
            stavka.setStatus(StatusStavke.OBRISANA); //AKO JE STAVKA POSTOJALA U BAZI, PROMENI JOJ STATUS
            stavka.setKolicina(0);                   //POSTAVLJAMO KOLICINU NA 0, JER CEMO OPET MOCI DA POVECAMO KOLICINU TOJ STAVCI I POSTAVIMO JE NA IZMENJENA
            stavka.setUkupanIznos(0);
        } else {
            racun.getStavke().remove(red);          //AKO JE STAVKA TEK UBACENA PRI IZMENI, OBRISI JE
        }
        racun.ucitajUkupanIznos();
        srediRedneBrojeve();
        fireTableDataChanged();
    }

    private void srediRedneBrojeve() {
        int rb = 1;
        for (int i = 0; i < racun.getStavke().size(); i++) {
            if(racun.getStavke().get(i).getStatus() != StatusStavke.NOVA){  //AKO STAVKA NIJE NOVA, NE SMEMO DA JOJ DIRAMO STAVKA_ID
                rb++;
                continue;
            }
            racun.getStavke().get(i).setStavkaID(rb++);
        }
    }

    private boolean postojiUListi(Proizvod proizvod) {
        for (StavkaRacuna stavka : racun.getStavke()) {
            if (stavka.getProizvod().equals(proizvod)) {
                return true;
            }
        }
        return false;
    }

    private void povecajKolicinu(Proizvod proizvod, int kolicina) {
        for (StavkaRacuna stavka : racun.getStavke()) {
            if (stavka.getProizvod().equals(proizvod)) {
                if (stavka.getStatus() != StatusStavke.NOVA) {
                    stavka.setStatus(StatusStavke.IZMENJENA);
                }
                stavka.setKolicina(stavka.getKolicina() + kolicina);
                break;
            }

        }
    }

    public ArrayList<StavkaRacuna> getStavkeRacuna() {
        return (ArrayList<StavkaRacuna>) racun.getStavke();
    }
    
}
