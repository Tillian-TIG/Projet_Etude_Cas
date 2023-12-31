/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hopital;

import com.raven.event.EventMenuSelected;

import com.raven.form.Form_Home_Caissier;


import com.raven.form.Compte_secretaire;
import com.raven.form.Form_dash_infirmier;
import com.raven.form.Form_list_patient_consultation;
import com.raven.form.Form_list_patient_operation;


import java.awt.Color;
import javaswingdev.message.MessageDialog;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author RAVEN
 */
public class Main_Caissier extends javax.swing.JFrame {

    /**
     * 
     * 
     * 
     * 
     * 
     * 
     * Creates new form Main
     */
     private Login_form lg;
    private Form_Home_Caissier home;
    private Compte_secretaire form1;
    private Form_list_patient_consultation form2;
   private Form_list_patient_operation form3;     
    private JFrame frame;
    public Main_Caissier() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        home = new Form_Home_Caissier();
        form1 = new Compte_secretaire();
        form2 = new Form_list_patient_consultation();
        form3 = new Form_list_patient_operation();       
        menu_cai1.initMoving(Main_Caissier.this);
        menu_cai1.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                    setForm(home);
                } else if (index == 1) {
                    setForm(form2);
                } else if (index == 2) {
                    setForm(form3);
                } else if (index == 3) {
                    setForm(form1);
                } else if (index == 4) {
                    MessageDialog obj = new MessageDialog(Main_Caissier.this);
        obj.showMessage("Avertissement", "Êtes vous sûre de quitter la session?\nToute opération non sauvegardé sera éffacé.");
        if (obj.getMessageType() == MessageDialog.MessageType.OK) {
            //System.out.println("User click ok");
            
                lg = new Login_form();
                 lg.setVisible(true); 
                  setVisible(false);
        } else {
           // System.out.println("User click cancel");
           obj.setVisible(false);
        }
                } 
            }
        });
        //  set when system open start with home form
        setForm(new Form_Home_Caissier());
    }

    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.raven.swing.PanelBorder();
        mainPanel = new javax.swing.JPanel();
        menu_cai1 = new com.raven.component.Menu_cai();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(25, 110, 129));

        mainPanel.setBackground(new java.awt.Color(25, 110, 129));
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu_cai1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE))
            .addComponent(menu_cai1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_Caissier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Caissier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Caissier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Caissier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Caissier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    private com.raven.component.Menu_cai menu_cai1;
    private com.raven.swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
