/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.forme.menadzer;

import domen.Mesto;
import domen.Zaposleni;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kontroler.KontrolerGUI;
import ui.forme.glavna.FGlavnaForma;
import ui.forme.mode.ModeForm;
import ui.forme.prijava.FPrijava;

/**
 *
 * @author urosv
 */
public class FZaposleni extends javax.swing.JDialog {

    Zaposleni ulogovanZaposleni;
    ModeForm mode;

    /**
     * Creates new form FZaposleni
     */
    public FZaposleni(java.awt.Frame parent, boolean modal, ModeForm mode) {
        super(parent, modal);
        initComponents();
        postaviUlogovanogZaposlenog(); //dobro
        postaviLabeluZaposleni(); //
        popuniComboZaposleni(); //
        popuniComboMesto(); //
        postaviOmogucenostElemenataForme(mode);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxtIme = new javax.swing.JTextField();
        jtxtPrezime = new javax.swing.JTextField();
        jtxtKorisnickoIme = new javax.swing.JTextField();
        jtxtLozinka = new javax.swing.JTextField();
        jbtnKreirajZaposlenog = new javax.swing.JButton();
        jtxtZaposleniID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jcmbMesto = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jlblUlogovaniMenadzer = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jcmbZaposleni = new javax.swing.JComboBox();
        jbtnObrisiZaposlenog = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Kreiranje zaposlenog"));

        jLabel1.setText("ID:");

        jLabel3.setText("Ime:");

        jLabel4.setText("Prezime:");

        jLabel5.setText("Korisnicko ime:");

        jLabel6.setText("Lozinka:");

        jbtnKreirajZaposlenog.setText("KREIRAJ ZAPOSLENOG");
        jbtnKreirajZaposlenog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnKreirajZaposlenogActionPerformed(evt);
            }
        });

        jLabel2.setText("Mesto: ");

        jcmbMesto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(274, 274, 274)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtZaposleniID, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(212, 212, 212)
                                .addComponent(jbtnKreirajZaposlenog, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxtIme)
                                    .addComponent(jtxtPrezime, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxtKorisnickoIme)
                                    .addComponent(jtxtLozinka, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(63, 63, 63)
                                .addComponent(jcmbMesto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtZaposleniID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtxtKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtxtLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcmbMesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jbtnKreirajZaposlenog, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel7.setText("Nadlezni: ");

        jlblUlogovaniMenadzer.setText("[imeUlogovanogMenadzera]");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Brisanje zaposlenog"));

        jcmbZaposleni.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jbtnObrisiZaposlenog.setText("OBRISI ZAPOSLENOG");
        jbtnObrisiZaposlenog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnObrisiZaposlenogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcmbZaposleni, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jbtnObrisiZaposlenog, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtnObrisiZaposlenog, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jcmbZaposleni))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlblUlogovaniMenadzer)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jlblUlogovaniMenadzer))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnKreirajZaposlenogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnKreirajZaposlenogActionPerformed
        //zaposleniID = -1 jer u svakom slucaju je autoIncrement u bazi. Promeniti ?
        int zaposleniID = -1;
        String ime = jtxtIme.getText();
        String prezime = jtxtPrezime.getText();
        String username = jtxtKorisnickoIme.getText();
        String password = jtxtLozinka.getText();
        Mesto mesto = (Mesto) jcmbMesto.getSelectedItem();

        Zaposleni noviZaposleni = new Zaposleni(zaposleniID, ime + " " + prezime, username, password, false, mesto);
        try {
            Zaposleni provera = KontrolerGUI.getInstanca().kreirajNovogZaposlenog(noviZaposleni);
            if (provera == null) {
                JOptionPane.showMessageDialog(this, "Sistem ne moze da kreira novog zaposlenog");
            } else {
                jtxtZaposleniID.setText(String.valueOf(provera.getZaposleniID()));
                JOptionPane.showMessageDialog(this, "Sistem je kreirao novog zaposlenog");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da kreira novog zaposlenog /n" + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jbtnKreirajZaposlenogActionPerformed

    private void jbtnObrisiZaposlenogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnObrisiZaposlenogActionPerformed
        Zaposleni zaposleni = (Zaposleni) jcmbZaposleni.getSelectedItem();
        try {
            boolean uspesno = KontrolerGUI.getInstanca().obrisiZaposlenog(zaposleni);
            if (uspesno) {
                JOptionPane.showMessageDialog(this, "Sistem je obrisao zaposlenog");
                osveziComboZaposleni();
            } else {
                JOptionPane.showMessageDialog(this, "Sistem ne moze da obrise zaposlenog");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da obrise zaposlenog");
            ex.printStackTrace();
        }
//        
    }//GEN-LAST:event_jbtnObrisiZaposlenogActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbtnKreirajZaposlenog;
    private javax.swing.JButton jbtnObrisiZaposlenog;
    private javax.swing.JComboBox jcmbMesto;
    private javax.swing.JComboBox jcmbZaposleni;
    private javax.swing.JLabel jlblUlogovaniMenadzer;
    private javax.swing.JTextField jtxtIme;
    private javax.swing.JTextField jtxtKorisnickoIme;
    private javax.swing.JTextField jtxtLozinka;
    private javax.swing.JTextField jtxtPrezime;
    private javax.swing.JTextField jtxtZaposleniID;
    // End of variables declaration//GEN-END:variables

    private void postaviLabeluZaposleni() {
        jlblUlogovaniMenadzer.setText(ulogovanZaposleni.toString());
    }

    private void postaviUlogovanogZaposlenog() {
        ulogovanZaposleni = KontrolerGUI.getInstanca().getUlogovaniZaposleni();
    }

    private void postaviOmogucenostElemenataForme(ModeForm mode) {
        this.mode = mode;

        switch (mode) {
            case FORM_OBRISI:
                postaviZaBrisanje();
                break;
            case FORM_KREIRAJ:
                postaviZaKreiranje();
                break;
            default:
                return;
        }
    }

    private void popuniComboZaposleni() {
        jcmbZaposleni.removeAllItems();
//
        ArrayList<Zaposleni> listaZaposlenih = null;
        try {
            listaZaposlenih = KontrolerGUI.getInstanca().vratiSveZaposlene();
            for (Zaposleni zaposleni : listaZaposlenih) {
                jcmbZaposleni.addItem(zaposleni);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Sistem nije uspeo da ucita zaposlene iz baze.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }

    private void popuniComboMesto() {
        jcmbMesto.removeAllItems();

        ArrayList<Mesto> listaMesta = null;
        try {
            listaMesta = KontrolerGUI.getInstanca().vratiSvaMesta();
            for (Mesto mesto : listaMesta) {
                jcmbMesto.addItem(mesto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Sistem nije uspeo da ucita mesta iz baze.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void postaviZaBrisanje() {
        jbtnKreirajZaposlenog.setEnabled(false);
        jcmbMesto.setEnabled(false);
        jtxtZaposleniID.setEnabled(false);
        jtxtKorisnickoIme.setEnabled(false);
        jtxtLozinka.setEnabled(false);
        jtxtIme.setEnabled(false);
        jtxtPrezime.setEnabled(false);
    }

    private void postaviZaKreiranje() {
        jtxtZaposleniID.setEnabled(false);
        jcmbZaposleni.setEnabled(false);
        jbtnObrisiZaposlenog.setEnabled(false);
    }

    private void osveziComboZaposleni() {
        popuniComboZaposleni();
    }

}
