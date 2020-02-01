/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.modeli;

import domen.Racun;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author urosv
 */
public class ModelTabeleRacunPretraga extends AbstractTableModel{

    List<Racun> listaRacuna;
    String[] kolone = {"Racun ID", "Datum izrade", "Ukupan iznos", "Zaposleni ID"};

    public ModelTabeleRacunPretraga() {
        listaRacuna = new ArrayList<>();
    }

    public ModelTabeleRacunPretraga(List<Racun> listaRacuna) {
        this.listaRacuna = listaRacuna;
    }
    
    @Override
    public int getRowCount() {
        return listaRacuna.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowNum, int colNum) {
        Racun r = listaRacuna.get(rowNum);
        
        switch(colNum){
            case 0:
                return r.getRacunID();
            case 1:
                return r.getDatumIzrade();
            case 2:
                return r.getUkupanIznos();
            case 3:
                return r.getKreiraoZaposleni().getZaposleniID();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int colNum) {
        return kolone[colNum];
    }

    public List<Racun> getListaRacuna() {
        return listaRacuna;
    }

    public void setListaRacuna(List<Racun> listaRacuna) {
        this.listaRacuna = listaRacuna;
        this.fireTableDataChanged();
    }

    public void postaviRacune(ArrayList<Racun> racuni) {
        listaRacuna = racuni;
        fireTableDataChanged();
    }
    
    public Racun getRacun(int row){
        return listaRacuna.get(row);
    }
    
}
