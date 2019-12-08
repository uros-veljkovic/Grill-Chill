/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.modeli;

import domen.Racun;
import domen.StavkaRacuna;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author urosv
 */
public class ModelTabeleStavkaRacuna extends AbstractTableModel{
    
    Racun racun;
    String[] koloneTabele = {"Rb. stavke", "Naziv proizvoda", "Iznos", "Kolicina", "Ukupan iznos"};

    public ModelTabeleStavkaRacuna(Racun racun) {
        this.racun = racun;
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
        
        switch(colNum){
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
    
    
    
}
