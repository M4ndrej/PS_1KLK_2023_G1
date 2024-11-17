/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controller.Controller;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import model.Predmet;
import model.Rok;
import model.RokPredmet;

/**
 *
 * @author Andrej
 */
public class DetaljiForma extends javax.swing.JDialog implements ItemListener{
    
    RokoviForma roditelj;
    List<RokPredmet> odrzavanja;
    List<Predmet> predmeti = Controller.getInstance().ucitajPredmet();
    Rok rok;
    /**
     * Creates new form DetaljiForma
     */
    public DetaljiForma(JFrame parent, boolean modal, Rok rok) {
        this.roditelj = (RokoviForma)parent;
        initComponents();
        odrzavanja = Controller.getInstance().ucitajPredmete(rok);
        ModelTabeleOdrzavanja mto = new ModelTabeleOdrzavanja(odrzavanja);
        jTableOdrzavanja.setModel(mto);
        
        jTextFieldNaziv.setText(rok.getNaziv());
        jTextFieldPocetak.setText(String.valueOf(rok.getDatumPocetka()));
        jTextFieldZavrsetak.setText(String.valueOf(rok.getDatumZavrsetka()));
        jTextFieldNaziv.setEnabled(false);
        jTextFieldPocetak.setEnabled(false);
        jTextFieldZavrsetak.setEnabled(false);
        jButtonSacuvaj.setVisible(false);
        this.rok = rok;
        
        JComboBox<Predmet> jComboBoxPredmeti = new JComboBox<>();
        for(Predmet p :predmeti){
            jComboBoxPredmeti.addItem(p);
        }
        
        TableColumn kolona = jTableOdrzavanja.getColumnModel().getColumn(0);
        kolona.setCellEditor(new DefaultCellEditor(jComboBoxPredmeti));
        jComboBoxPredmeti.addItemListener((ItemListener) this);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldNaziv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPocetak = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldZavrsetak = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableOdrzavanja = new javax.swing.JTable();
        jButtonDodaj = new javax.swing.JButton();
        jButtonObrisi = new javax.swing.JButton();
        jButtonSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Naziv");

        jLabel2.setText("Datum pocetka");

        jLabel3.setText("Datum zavrsetka");

        jTableOdrzavanja.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableOdrzavanja);

        jButtonDodaj.setText("Dodaj polaganje");
        jButtonDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDodajActionPerformed(evt);
            }
        });

        jButtonObrisi.setText("Obrisi polaganje");
        jButtonObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonObrisiActionPerformed(evt);
            }
        });

        jButtonSacuvaj.setText("Sacuvaj");
        jButtonSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldZavrsetak, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPocetak, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldNaziv)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonDodaj)
                        .addGap(48, 48, 48)
                        .addComponent(jButtonObrisi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldPocetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldZavrsetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDodaj)
                    .addComponent(jButtonObrisi)
                    .addComponent(jButtonSacuvaj))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDodajActionPerformed

           ModelTabeleOdrzavanja mto = (ModelTabeleOdrzavanja)jTableOdrzavanja.getModel();
           List<RokPredmet> odrzavanja = mto.getOdrzavanja();
           odrzavanja.add(new RokPredmet());
           mto.setOdrzavanja(odrzavanja);
           jButtonDodaj.setEnabled(false);
           jButtonSacuvaj.setVisible(true);
    }//GEN-LAST:event_jButtonDodajActionPerformed

    private void jButtonSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSacuvajActionPerformed
        
        int i = JOptionPane.showConfirmDialog(this, "Da li ste siguni","Potvrda",JOptionPane.YES_NO_OPTION);
        if(i == JOptionPane.NO_OPTION){
            this.dispose();
        }else{
         ModelTabeleOdrzavanja mto = (ModelTabeleOdrzavanja)jTableOdrzavanja.getModel();
        List<RokPredmet> o = mto.getOdrzavanja();
        for(RokPredmet rp: mto.getOdrzavanja()){
            if(rp.getPredmet() == null || rp.getDatum() == null){
                JOptionPane.showMessageDialog(this, "Niste uneli sva polja","Upozorenje",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        RokPredmet rp = o.getLast();
        rp.setRok(rok);
        boolean uspesno = Controller.getInstance().unesiOdrzavanje(rp);
        if(uspesno)
            JOptionPane.showMessageDialog(this, "Uspesno uneto polaganje","Uspeh",JOptionPane.INFORMATION_MESSAGE);
        osvezi();   
        }
    }//GEN-LAST:event_jButtonSacuvajActionPerformed

    private void jButtonObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonObrisiActionPerformed
        
        int i = JOptionPane.showConfirmDialog(this, "Da li ste sigurni","Potrvrda",JOptionPane.YES_NO_OPTION);
        if(i == JOptionPane.NO_OPTION){
            this.dispose();
        }else{
            int red = jTableOdrzavanja.getSelectedRow();
        if(red == -1){
            JOptionPane.showMessageDialog(this, "Niste selektovali red");
            return;
        }
        ModelTabeleOdrzavanja mto = (ModelTabeleOdrzavanja)jTableOdrzavanja.getModel();
        List<RokPredmet> odrzavanja = mto.getOdrzavanja();
        RokPredmet rp = odrzavanja.get(red);
        
        Controller.getInstance().obrisiOdrzavanje(rp);
        osvezi();
        }
    }//GEN-LAST:event_jButtonObrisiActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDodaj;
    private javax.swing.JButton jButtonObrisi;
    private javax.swing.JButton jButtonSacuvaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableOdrzavanja;
    private javax.swing.JTextField jTextFieldNaziv;
    private javax.swing.JTextField jTextFieldPocetak;
    private javax.swing.JTextField jTextFieldZavrsetak;
    // End of variables declaration//GEN-END:variables

    @Override
    public void itemStateChanged(ItemEvent e) {
        ModelTabeleOdrzavanja mto = (ModelTabeleOdrzavanja)jTableOdrzavanja.getModel();
        List<RokPredmet> odrzavanja = mto.getOdrzavanja();
       /* for(Predmet p : predmeti){
            if(e.getItem().equals(p)){
                mto.setValueAt(p.getEspb(),odrzavanja.size()-1 , 1);
            }
        }*/
        Predmet p = (Predmet)e.getItem();
        mto.setValueAt(p, odrzavanja.size()-1, 0);
        
    }

    private void osvezi() {
        ModelTabeleOdrzavanja mto = new ModelTabeleOdrzavanja(Controller.getInstance().ucitajPredmete(rok));
        jTableOdrzavanja.setModel(mto);
    }

  
}
