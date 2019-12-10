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
public class ModelTabeleRacun extends AbstractTableModel{

    List<Racun> listaRacuna;
    String[] kolone = {"Racun ID", "Datum izrade", "Ukupan iznos", "Kreirao"};

    public ModelTabeleRacun() {
        listaRacuna = new ArrayList<>();
    }

    public ModelTabeleRacun(List<Racun> listaRacuna) {
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
                return r.getKreiraoZaposleni();
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
    }
    
    
}
