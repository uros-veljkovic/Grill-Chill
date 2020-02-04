/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.forme.prijava;

import domen.Zaposleni;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kontroler.KontrolerGUI;
import ui.forme.glavna.FGlavnaForma;

/**
 *
 * @author urosv
 */
public class FPrijava extends javax.swing.JFrame {

    Zaposleni ulogovaniZaposleni;

    /**
     * Creates new form FPrijava
     */
    public FPrijava() {
        initComponents();
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
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtKorisnickoIme = new javax.swing.JTextField();
        jpswLozinka = new javax.swing.JPasswordField();
        jbtnPrijava = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Prijava");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Korisnicko ime:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(72, 69, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Lozinka:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 73;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 69, 0, 0);
        getContentPane().add(jLabel3, gridBagConstraints);

        jtxtKorisnickoIme.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 342;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(63, 29, 0, 62);
        getContentPane().add(jtxtKorisnickoIme, gridBagConstraints);

        jpswLozinka.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 342;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 29, 0, 62);
        getContentPane().add(jpswLozinka, gridBagConstraints);

        jbtnPrijava.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jbtnPrijava.setText("PRIJAVA");
        jbtnPrijava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPrijavaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 126;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(43, 209, 52, 0);
        getContentPane().add(jbtnPrijava, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnPrijavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPrijavaActionPerformed
        String username = jtxtKorisnickoIme.getText();
        String password = String.valueOf(jpswLozinka.getPassword());

        try {
            ulogovaniZaposleni = KontrolerGUI.getInstanca().prijaviZaposlenog(username, password);
            FGlavnaForma glavnaForma = new FGlavnaForma(this);
            glavnaForma.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da pronadje zaposlenog na osnovu unetih vrednosti za prijavljivanje");
            ex.printStackTrace();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da pronadje zaposlenog na osnovu unetih vrednosti za prijavljivanje");
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jbtnPrijavaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbtnPrijava;
    private javax.swing.JPasswordField jpswLozinka;
    private javax.swing.JTextField jtxtKorisnickoIme;
    // End of variables declaration//GEN-END:variables

    public Zaposleni getUlogovaniZaposleni() {
        return ulogovaniZaposleni;
    }
}
