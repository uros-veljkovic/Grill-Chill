/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.modeli;

import domen.Proizvod;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author urosv
 */
public class ModelTabeleProizvod extends AbstractTableModel{
    
    List<Proizvod> listaProizvoda;
    String[] koloneTabele = {"ID proizvoda", "Naziv", "Cena"};

    @Override
    public int getRowCount() {
        return listaProizvoda.size();
    }

    @Override
    public int getColumnCount() {
        return koloneTabele.length;
    }

    @Override
    public Object getValueAt(int rowNum, int colNum) {
        Proizvod proizvod = listaProizvoda.get(rowNum);
        
        switch(colNum){
            case 0:
                return proizvod.getProizvodID();
            case 1:
                return proizvod.getNaziv();
            case 2:
                return proizvod.getCena();
            default:
                return -1;
        }
    }

    @Override
    public String getColumnName(int colNum) {
        return koloneTabele[colNum];
    }
    
    
    
}
