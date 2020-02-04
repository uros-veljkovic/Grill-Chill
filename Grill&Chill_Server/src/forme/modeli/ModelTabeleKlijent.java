/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.modeli;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import niti.NitKlijenta;

/**
 *
 * @author urosv
 */
public class ModelTabeleKlijent extends AbstractTableModel {

    List<NitKlijenta> listaKlijenata;
    String[] kolone = {"Redni br.", "Klijent", "Vreme uspostavljanja konekcije"};
    SimpleDateFormat sdf;

    public ModelTabeleKlijent(List<NitKlijenta> listaKlijenata) {
        this.listaKlijenata = listaKlijenata;
        sdf = new SimpleDateFormat("HH:mm:ss");
    }

    public ModelTabeleKlijent() {
        listaKlijenata = new ArrayList<NitKlijenta>();
    }

    @Override
    public int getRowCount() {
        return listaKlijenata.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int red, int kolona) {
        NitKlijenta klijent = listaKlijenata.get(red);

        switch (kolona) {
            case 0:
                return klijent.getRb();
            case 1:
                return klijent.getSocket().getInetAddress().getHostName();
            case 2:
                return sdf.format(klijent.getVreme());
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int kolona) {
        return kolone[kolona];
    }
    
    public void setListaKlijenata(List<NitKlijenta> listaKlijenata){
        this.listaKlijenata = listaKlijenata;
        fireTableDataChanged();
    }
    
    public void srediRedneBrojeve(){
        int brojac = 0;
        for (NitKlijenta nitKlijenta : listaKlijenata) {
            nitKlijenta.setRb(++brojac);
        }
        fireTableDataChanged();
    }

    public void dodajKlijentaUTabelu(NitKlijenta nitKlijenta){
        listaKlijenata.add(nitKlijenta);
        fireTableDataChanged();
    }
}
