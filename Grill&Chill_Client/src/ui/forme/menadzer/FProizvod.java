/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.forme.menadzer;

import domen.MernaJedinica;
import domen.Proizvod;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kontroler.KontrolerGUI;
import ui.forme.mode.ModeForm;

/**
 *
 * @author urosv
 */
public class FProizvod extends javax.swing.JDialog {

    ModeForm mode;
    Proizvod odabraniProizvod;

    /**
     * Creates new form FProizvod
     */
    public FProizvod(java.awt.Frame parent, boolean modal, ModeForm mode) {
        super(parent, modal);
        initComponents();
        popuniComboMernaJedinica();
        pripremiFormu(mode);
        this.pack();
        this.setLocationRelativeTo(null);

    }

    public FProizvod(java.awt.Frame parent, boolean modal, ModeForm mode, Proizvod odabraniProizvod) {
        super(parent, modal);
        initComponents();
        popuniComboMernaJedinica();
        this.odabraniProizvod = odabraniProizvod;
        pripremiFormu(mode);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtxtProizvodID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtxtNazivProizvoda = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtOpis = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jtxtCena = new javax.swing.JTextField();
        jlblNazivGreska = new javax.swing.JLabel();
        jtxtOpisGreska = new javax.swing.JLabel();
        jtxtCenaGreska = new javax.swing.JLabel();
        jlbldGreska = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcmbMernaJedinica = new javax.swing.JComboBox();
        jbtnIzadji = new javax.swing.JButton();
        jbtnIzmeni = new javax.swing.JButton();
        jbtnSacuvaj = new javax.swing.JButton();
        jbtnObrisi = new javax.swing.JButton();
        jbtnOmoguciIzmenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Informacije o proizvodu"));

        jLabel1.setText("ID:");

        jLabel2.setText("Naziv:");

        jLabel3.setText("Opis:");

        jtxtOpis.setColumns(20);
        jtxtOpis.setRows(5);
        jScrollPane1.setViewportView(jtxtOpis);

        jLabel4.setText("Cena:");

        jlbldGreska.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbldGreska.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setText("Merna jedinica: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jtxtProizvodID, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtNazivProizvoda)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtxtCenaGreska)
                                    .addComponent(jtxtOpisGreska, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtxtCena, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jcmbMernaJedinica, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jlblNazivGreska, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jlbldGreska, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtProizvodID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jlbldGreska)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtNazivProizvoda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jlblNazivGreska)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtxtOpisGreska)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jcmbMernaJedinica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtCenaGreska)
                .addContainerGap())
        );

        jbtnIzadji.setText("Izadji");

        jbtnIzmeni.setBackground(new java.awt.Color(255, 255, 153));
        jbtnIzmeni.setForeground(new java.awt.Color(0, 0, 0));
        jbtnIzmeni.setText("IZMENI");
        jbtnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIzmeniActionPerformed(evt);
            }
        });

        jbtnSacuvaj.setBackground(new java.awt.Color(153, 255, 153));
        jbtnSacuvaj.setForeground(new java.awt.Color(0, 0, 0));
        jbtnSacuvaj.setText("SACUVAJ");
        jbtnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSacuvajActionPerformed(evt);
            }
        });

        jbtnObrisi.setBackground(new java.awt.Color(255, 153, 153));
        jbtnObrisi.setForeground(new java.awt.Color(0, 0, 0));
        jbtnObrisi.setText("OBRISI");
        jbtnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnObrisiActionPerformed(evt);
            }
        });

        jbtnOmoguciIzmenu.setBackground(new java.awt.Color(255, 255, 153));
        jbtnOmoguciIzmenu.setForeground(new java.awt.Color(0, 0, 0));
        jbtnOmoguciIzmenu.setText("OMOGUCI IZMENU");
        jbtnOmoguciIzmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOmoguciIzmenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnIzadji, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbtnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(jbtnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jbtnOmoguciIzmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jbtnOmoguciIzmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnSacuvaj, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jbtnIzmeni, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jbtnObrisi, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jbtnIzadji))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnOmoguciIzmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOmoguciIzmenuActionPerformed
        omoguciPopunjavanjePodataka(true);
        omoguciBtnIzmeni(true);
        omoguciBtnOmoguciIzmenu(false);
        this.pack();
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_jbtnOmoguciIzmenuActionPerformed

    private void jbtnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSacuvajActionPerformed
//        String naziv = jtxtNazivProizvoda.getText();
//        String opis = jtxtOpis.getText();
//        double cena = Double.parseDouble(jtxtCena.getText());
//        MernaJedinica mernaJedinica = (MernaJedinica) jcmbMernaJedinica.getSelectedItem();
//        //Umeso -1 staviti odabraniProizvod.getProizvodID();
//        Proizvod noviProizvod = new Proizvod(-1, naziv, opis, cena, mernaJedinica);
//
//        boolean kreiran;
//        try {
//            kreiran = KontrolerGUI.getInstanca().kreirajNoviProizvod(noviProizvod);
//            if (kreiran) {
//                JOptionPane.showMessageDialog(this, "Sistem je kreirao proizvod.");
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(this, "Sistem ne moze da kreira proizvod.");
//        }

    }//GEN-LAST:event_jbtnSacuvajActionPerformed

    //TODO: Implementirati da se nakon brisnja 
    private void jbtnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnObrisiActionPerformed
//        boolean obrisan;
//
//        obrisan = KontrolerGUI.getInstanca().obrisiProizvod(odabraniProizvod);
//        if (obrisan) {
//            JOptionPane.showMessageDialog(this, "Sistem je obrisao proizvod.");
//            obrisiPodatkeSaForme();
//            this.setVisible(false);
//        } else {
//            JOptionPane.showMessageDialog(this, "Sistem nije uspeo da obrise proizvod.");
//        }
//

    }//GEN-LAST:event_jbtnObrisiActionPerformed

    private void jbtnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIzmeniActionPerformed
        String naziv = jtxtNazivProizvoda.getText();
        String opis = jtxtOpis.getText();
        double cena = Double.parseDouble(jtxtCena.getText());
        MernaJedinica mernaJedinica = (MernaJedinica) jcmbMernaJedinica.getSelectedItem();
        int id = Integer.parseInt(jtxtProizvodID.getText());

        Proizvod proizvod = new Proizvod(id, naziv, opis, cena, mernaJedinica);

        boolean izmenjen;
        try {
            izmenjen = KontrolerGUI.getInstanca().izmeniProizvod(proizvod);
            if (izmenjen) {
                JOptionPane.showMessageDialog(this, "Sistem je uspeo da izmeni proizvod.");
            } else {
                JOptionPane.showMessageDialog(this, "Sistem nije uspeo da izmeni proizvod.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }


    }//GEN-LAST:event_jbtnIzmeniActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnIzadji;
    private javax.swing.JButton jbtnIzmeni;
    private javax.swing.JButton jbtnObrisi;
    private javax.swing.JButton jbtnOmoguciIzmenu;
    private javax.swing.JButton jbtnSacuvaj;
    private javax.swing.JComboBox jcmbMernaJedinica;
    private javax.swing.JLabel jlblNazivGreska;
    private javax.swing.JLabel jlbldGreska;
    private javax.swing.JTextField jtxtCena;
    private javax.swing.JLabel jtxtCenaGreska;
    private javax.swing.JTextField jtxtNazivProizvoda;
    private javax.swing.JTextArea jtxtOpis;
    private javax.swing.JLabel jtxtOpisGreska;
    private javax.swing.JTextField jtxtProizvodID;
    // End of variables declaration//GEN-END:variables

    private void popuniComboMernaJedinica() {
        jcmbMernaJedinica.removeAllItems();

        jcmbMernaJedinica.addItem(MernaJedinica.kg);
        jcmbMernaJedinica.addItem(MernaJedinica.kom);
        jcmbMernaJedinica.addItem(MernaJedinica.l);

    }

    private void pripremiFormu(ModeForm mode) {
        this.mode = mode;
        switch (mode) {
            case FORM_KREIRAJ:
                pripremiZaKreiranje();
                break;
            case FORM_IZMENI:
                pripremiZaIzmenu();
                break;
            case FORM_OBRISI:
                pripremiZaBrisanje();
                break;
            case FORM_PRETRAZI:
                pripremiZaPrikaz();
                break;
            default:
                break;
        }
    }

    private void pripremiZaKreiranje() {

        obrisiPodatkeSaForme();
        omoguciPopunjavanjePodataka(true);

        omoguciBtnIzmeni(false);
        omoguciBtnOmoguciIzmenu(false);
        omoguciBtnObrisi(false);

        omoguciBtnSacuvaj(true);
    }

    private void pripremiZaIzmenu() {
        popuniPodatkeProizvoda();
        omoguciPopunjavanjePodataka(true);

        omoguciBtnOmoguciIzmenu(false);
        omoguciBtnObrisi(false);
        omoguciBtnSacuvaj(false);

        omoguciBtnIzmeni(true);
    }

    private void pripremiZaBrisanje() {
        popuniPodatkeProizvoda();

        omoguciIzmenuProizvodID(false);
        omoguciIzmenuNaziv(false);
        omoguciIzmenuOpis(false);
        omoguciIzmenuCena(false);
        omoguciIzmenuMernaJedinica(false);

        omoguciBtnIzmeni(false);
        omoguciBtnOmoguciIzmenu(false);
        omoguciBtnSacuvaj(false);

        omoguciBtnObrisi(true);
    }

    private void pripremiZaPrikaz() {
        popuniPodatkeProizvoda();

        omoguciPopunjavanjePodataka(false);

        omoguciBtnIzmeni(false);
        omoguciBtnSacuvaj(false);
        omoguciBtnObrisi(false);

        omoguciBtnOmoguciIzmenu(true);

    }

    private void omoguciBtnSacuvaj(boolean opcija) {
        jbtnSacuvaj.setVisible(opcija);
    }

    private void omoguciBtnIzmeni(boolean opcija) {
        jbtnIzmeni.setVisible(opcija);
    }

    private void omoguciBtnObrisi(boolean opcija) {
        jbtnObrisi.setVisible(opcija);
    }

    //TODO: setVisible() umesto setEnabled()
    private void omoguciBtnOmoguciIzmenu(boolean opcija) {
        jbtnOmoguciIzmenu.setVisible(opcija);
    }

    private void popuniPodatkeProizvoda() {
        jtxtNazivProizvoda.setText(odabraniProizvod.getNaziv());
        jtxtCena.setText(String.valueOf(odabraniProizvod.getCena()));
        jtxtOpis.setText(odabraniProizvod.getOpis());
        jtxtProizvodID.setText(String.valueOf(odabraniProizvod.getProizvodID()));
        jcmbMernaJedinica.setSelectedItem(odabraniProizvod.getMernaJedinica());

    }

    private void omoguciPopunjavanjePodataka(boolean opcija) {
        //ProizvodID nije promenljiv jer je Autoincrement
        jtxtProizvodID.setEditable(false);
        jtxtNazivProizvoda.setEditable(opcija);
        jtxtCena.setEditable(opcija);
        jcmbMernaJedinica.setEnabled(opcija);
        jtxtOpis.setEditable(opcija);
    }

    private void obrisiPodatkeSaForme() {
        jtxtCena.setText("");
        jtxtOpis.setText("");
        jtxtNazivProizvoda.setText("");
        jtxtProizvodID.setText("");
    }

    private void omoguciIzmenuProizvodID(boolean b) {
        jtxtProizvodID.setEditable(false);
    }

    private void omoguciIzmenuNaziv(boolean b) {
        jtxtNazivProizvoda.setEditable(false);
    }

    private void omoguciIzmenuOpis(boolean b) {
        jtxtOpis.setEditable(false);
    }

    private void omoguciIzmenuCena(boolean b) {
        jtxtCena.setEditable(false);
    }

    private void omoguciIzmenuMernaJedinica(boolean b) {
        jcmbMernaJedinica.setEditable(false);
    }
}
