/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.modeli;

import domen.Proizvod;
import domen.Racun;
import domen.StavkaRacuna;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author urosv
 */
public class ModelTabeleStavkaRacuna extends AbstractTableModel {

    Racun racun;
    String[] koloneTabele = {"Rb. stavke", "Naziv proizvoda", "Iznos", "Kolicina", "Ukupan iznos"};

    public ModelTabeleStavkaRacuna(Racun racun) {
        this.racun = racun;
    }

    public ModelTabeleStavkaRacuna() {
    }

    @Override
    public int getRowCount() {
        return racun.getStavke().size();
    }

    @Override
    public int getColumnCount() {
        return koloneTabele.length;
    }

    @Override
    public Object getValueAt(int rowNum, int colNum) {
        StavkaRacuna stavkaRacuna = racun.getStavke().get(rowNum);

        switch (colNum) {
            case 0:
                return stavkaRacuna.getStavkaID();
            case 1:
                return stavkaRacuna.getProizvod().getNaziv();
            case 2:
                return stavkaRacuna.getProizvod().getCena();
            case 3:
                return stavkaRacuna.getKolicina();
            case 4:
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

        StavkaRacuna stavkaRacuna = new StavkaRacuna();
        stavkaRacuna.setKolicina(kolicina);
        stavkaRacuna.setProizvod(proizvod);
        stavkaRacuna.setStavkaID(racun.getStavke().size() + 1);
        stavkaRacuna.setUkupanIznos(kolicina * proizvod.getCena());

        racun.getStavke().add(stavkaRacuna);
        racun.setUkupanIznos(racun.getUkupanIznos() + stavkaRacuna.getUkupanIznos());

        fireTableDataChanged();

    }

    public Racun getRacun() {
        return this.racun;
    }

    public void obrisiStavku(int red) {
        double iznosObrisaneStavke = racun.getStavke().get(red).getUkupanIznos();
        racun.getStavke().remove(red);
        racun.setUkupanIznos(racun.getUkupanIznos() - iznosObrisaneStavke);
        srediRedneBrojeve();
        fireTableDataChanged();
    }

    private void srediRedneBrojeve() {
        int rb = 1;
        for (int i = 0; i < racun.getStavke().size(); i++) {
            racun.getStavke().get(i).setStavkaID(rb++);
        }
    }

}
