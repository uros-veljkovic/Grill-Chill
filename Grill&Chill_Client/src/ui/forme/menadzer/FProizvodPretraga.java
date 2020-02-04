/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.forme.menadzer;

import domen.Proizvod;
import java.awt.Frame;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import kontroler.KontrolerGUI;
import ui.forme.mode.ModeForm;
import ui.modeli.ModelTabeleProizvod;

/**
 *
 * @author urosv
 */
public class FProizvodPretraga extends javax.swing.JDialog {
    ModeForm mode;
    ArrayList<Proizvod> listaProizvoda;
    Proizvod odabranProizvod;
    /**
     * Creates new form FProizvodPretraga
     */
    public FProizvodPretraga(java.awt.Frame parent, boolean modal, ModeForm mode) {
        super(parent, modal);
        initComponents();
        pripremiFormu(mode);
        
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
        jLabel2 = new javax.swing.JLabel();
        jtxtVrednostZaPretragu = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblPronadjeniProizvodi = new javax.swing.JTable();
        jbtnPrikaziDetalje = new javax.swing.JButton();
        jbtnPretrazi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Naziv proizvoda:");

        jtblPronadjeniProizvodi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtblPronadjeniProizvodi);

        jbtnPrikaziDetalje.setText("PRIKAZI DETALJE");
        jbtnPrikaziDetalje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPrikaziDetaljeActionPerformed(evt);
            }
        });

        jbtnPretrazi.setText("PRETRAZI");
        jbtnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPretraziActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jbtnPrikaziDetalje, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 51, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtVrednostZaPretragu))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(jbtnPretrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtVrednostZaPretragu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbtnPretrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnPrikaziDetalje, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnPrikaziDetaljeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPrikaziDetaljeActionPerformed
        //Da li sam u liniji ispod morao da kazem da je parent null ?
        ModelTabeleProizvod mtp = (ModelTabeleProizvod) jtblPronadjeniProizvodi.getModel();
        odabranProizvod = mtp.vratiOdabraniProizvod(jtblPronadjeniProizvodi.getSelectedRow());
        
        FProizvod formaProizvod = new FProizvod((Frame)SwingUtilities.getWindowAncestor(this), true, mode, odabranProizvod);
        this.dispose();
        formaProizvod.setVisible(true);
    }//GEN-LAST:event_jbtnPrikaziDetaljeActionPerformed

    private void jbtnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPretraziActionPerformed
        String nazivProizvoda = jtxtVrednostZaPretragu.getText();
        
        try {
            listaProizvoda = KontrolerGUI.getInstanca().pretraziProizvode(nazivProizvoda);
            ModelTabeleProizvod mtp = (ModelTabeleProizvod) jtblPronadjeniProizvodi.getModel();
            mtp.postaviProizvode(listaProizvoda);
            
            JOptionPane.showMessageDialog(this, "Sistem je uspeo da pronadje proizvode po zadatom kriterijumu.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        ModelTabeleProizvod mtp = (ModelTabeleProizvod) jtblPronadjeniProizvodi.getModel();
        mtp.postaviProizvode(listaProizvoda);
        
    }//GEN-LAST:event_jbtnPretraziActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnPretrazi;
    private javax.swing.JButton jbtnPrikaziDetalje;
    private javax.swing.JTable jtblPronadjeniProizvodi;
    private javax.swing.JTextField jtxtVrednostZaPretragu;
    // End of variables declaration//GEN-END:variables

    private void pripremiFormu(ModeForm mode) {
        this.mode = mode;
        this.pack();
        this.setLocationRelativeTo(null);
        listaProizvoda = new ArrayList<>();
        ModelTabeleProizvod modelTabeleProizvod = new ModelTabeleProizvod();
        jtblPronadjeniProizvodi.setModel(modelTabeleProizvod);
    }

    Proizvod getOdabraniProizvod() {
        return odabranProizvod;
    }
}
