/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;



import com.mycompany.hopital.Main_Secretaire;
import com.raven.datechooser.EventDateChooser;
import com.raven.datechooser.SelectedAction;
import com.raven.datechooser.SelectedDate;
import icon.tableaction;
import icon.tablecelleditor;
import icon.tablecellrender;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import table.TableCustom;

/**
 *
 * @author Trafiquant de Tigbé
 */
public class Form_home_sec extends javax.swing.JPanel {
 private static final String username = "root";
 private static final String password = "primatologue";
 private static final String dataConn = "jdbc:mysql://localhost:3306/hopital";
 
 Connection sqlConn = null;
 Connection sqlSearch = null;
 PreparedStatement pst = null;
 PreparedStatement pst_search = null;
 ResultSet rs = null;
 ResultSet rs_2 = null;
 PreparedStatement pst_tab = null;
 ResultSet rs_tab = null;
 int q, i , id, deleteItem;

    /**
     * Creates new form Jpanel_admin_Medecin
     */
    public Form_home_sec() {
        initComponents();
        setOpaque(false);     
        TableCustom.apply(jScrollPanel_all, TableCustom.TableType.DEFAULT);
//        TableCustom.apply(jScrollPane2, TableCustom.TableType.DEFAULT);
//        TableCustom.apply(jScrollPane3, TableCustom.TableType.DEFAULT);
//        TableCustom.apply(jScrollPane4, TableCustom.TableType.DEFAULT);
//        TableCustom.apply(jScrollPane5, TableCustom.TableType.DEFAULT);
        tab_all_patient();
        //tab_all_dermato();
        //tab_all_ohpto();
        //tab_all_cardio();
        //tab_all_general();
        
        
       // getContentPane().setBackground(new Color(240, 240, 240));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPaneCustom1 = new raven.tabbed.TabbedPaneCustom();
        all_patient = new com.raven.swing.PanelBorder();
        jScrollPanel_all = new javax.swing.JScrollPane();
        JTable = new javax.swing.JTable();
        textsearch1 = new textfield.textsearch();

        setBackground(new java.awt.Color(25, 110, 129));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        tabbedPaneCustom1.setBackground(new java.awt.Color(25, 110, 129));
        tabbedPaneCustom1.setForeground(new java.awt.Color(255, 255, 255));
        tabbedPaneCustom1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabbedPaneCustom1MouseClicked(evt);
            }
        });
        tabbedPaneCustom1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabbedPaneCustom1KeyPressed(evt);
            }
        });

        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nom", "Prenom", "Contact", "Adresse", "Date Enregistrement", "Service", "Analyse"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTable.setRowHeight(40);
        JTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableMouseClicked(evt);
            }
        });
        jScrollPanel_all.setViewportView(JTable);

        javax.swing.GroupLayout all_patientLayout = new javax.swing.GroupLayout(all_patient);
        all_patient.setLayout(all_patientLayout);
        all_patientLayout.setHorizontalGroup(
            all_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(all_patientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPanel_all, javax.swing.GroupLayout.DEFAULT_SIZE, 1036, Short.MAX_VALUE)
                .addContainerGap())
        );
        all_patientLayout.setVerticalGroup(
            all_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, all_patientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPanel_all, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPaneCustom1.addTab("Liste des patient", all_patient);

        textsearch1.setText("Recherche");
        textsearch1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textsearch1MouseClicked(evt);
            }
        });
        textsearch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textsearch1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(tabbedPaneCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(tabbedPaneCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
           tab_all_patient();
        //tab_all_dermato();
        //tab_all_ohpto();
        ////tab_all_cardio();
        //tab_all_general();
    }//GEN-LAST:event_formMouseClicked

    private void textsearch1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textsearch1KeyReleased
        // TODO add your handling code here:
         if (textsearch1.getText().trim().isEmpty() || textsearch1.getText().equalsIgnoreCase("recherche")){
            String id = null;
            id = textsearch1.getText();
          
            
            DefaultTableModel model = (DefaultTableModel) JTable.getModel();
//            DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
//            DefaultTableModel model3 = (DefaultTableModel) jTable3.getModel();
//            DefaultTableModel model4 = (DefaultTableModel) jTable4.getModel();
//            DefaultTableModel model5 = (DefaultTableModel) jTable5.getModel();
            model.setRowCount(0);
////////            model2.setRowCount(0);
////            model3.setRowCount(0);
//            model4.setRowCount(0);
//             model5.setRowCount(0);
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                sqlConn = DriverManager.getConnection(dataConn,username,password);
                pst_tab = sqlConn.prepareStatement("Select * from consultation,service where id_service = id");
                rs_tab = pst_tab.executeQuery () ;
                while (rs_tab.next()) {
                    String column1Data = rs_tab.getString("nomPatient");
                    String column2Data = rs_tab.getString("prenomPatient");
                    String column3Data = rs_tab.getString("telephone");
                    String column4Data = rs_tab.getString("adresse");
                    String column5Data = rs_tab.getString("date_consultation");
                    String column6Data = rs_tab.getString("service_libelle");
                    String column7Data = rs_tab.getString("libelle_analyse");

                    // Ajouter d'autres colonnes si nécessaire

                    model.addRow(new Object[]{column1Data, column2Data, column3Data, column4Data, column5Data, column6Data, column7Data});
//                    model2.addRow(new Object[]{column1Data, column2Data, column3Data, column4Data, column5Data, column7Data});
//                    model3.addRow(new Object[]{column1Data, column2Data, column3Data, column4Data, column5Data, column7Data});
//                    model4.addRow(new Object[]{column1Data, column2Data, column3Data, column4Data, column5Data, column7Data});
//                    model5.addRow(new Object[]{column1Data, column2Data, column3Data, column4Data, column5Data, column7Data});
               }
            }
            
            catch (ClassNotFoundException | SQLException e) {
            }

        }
        else{
            DefaultTableModel model = (DefaultTableModel) JTable.getModel();
//            DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
//            DefaultTableModel model3 = (DefaultTableModel) jTable3.getModel();
//            DefaultTableModel model4 = (DefaultTableModel) jTable4.getModel();
//            DefaultTableModel model5 = (DefaultTableModel) jTable5.getModel();
            model.setRowCount(0);
//            model2.setRowCount(0);
//            model3.setRowCount(0);
//            model4.setRowCount(0);
//             model5.setRowCount(0);
            try {
                Class.forName("com.mysql.jdbc.Driver");
                sqlConn = DriverManager.getConnection(dataConn,username,password);
                String sql = "SELECT * FROM consultation,service,type_analyse WHERE nomPatient LIKE ? and id_service = id and id_serv = id";
                PreparedStatement statement = sqlConn.prepareStatement(sql);
                statement.setString(1, "%" + textsearch1.getText() + "%");
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String column1Data = resultSet.getString("nomPatient");
                    String column2Data = resultSet.getString("prenomPatient");
                    String column3Data = resultSet.getString("telephone");
                    String column4Data = resultSet.getString("adresse");
                    String column5Data = resultSet.getString("date_consultation");
                    String column6Data = resultSet.getString("service_libelle");
                    String column7Data = resultSet.getString("libelle_analyse");

                    // Ajouter d'autres colonnes si nécessaire

                    model.addRow(new Object[]{column1Data, column2Data, column3Data, column4Data, column5Data, column6Data, column7Data});
//                    model2.addRow(new Object[]{column1Data, column2Data, column3Data, column4Data, column5Data, column7Data});
//                    model3.addRow(new Object[]{column1Data, column2Data, column3Data, column4Data, column5Data, column7Data});
//                    model4.addRow(new Object[]{column1Data, column2Data, column3Data, column4Data, column5Data, column7Data});
//                    model5.addRow(new Object[]{column1Data, column2Data, column3Data, column4Data, column5Data, column7Data});
                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_textsearch1KeyReleased

    private void textsearch1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textsearch1MouseClicked
        // TODO add your handling code here:
        textsearch1.setText("");
    }//GEN-LAST:event_textsearch1MouseClicked

    private void tabbedPaneCustom1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabbedPaneCustom1KeyPressed
        // TODO add your handling code here:
        tab_all_patient();
        //tab_all_dermato();
      //  tab_all_ohpto();
       //// tab_all_cardio();
    }//GEN-LAST:event_tabbedPaneCustom1KeyPressed

    private void tabbedPaneCustom1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbedPaneCustom1MouseClicked
        // TODO add your handling code here:
        tab_all_patient();
     //   tab_all_dermato();
       // tab_all_ohpto();
       // tab_all_cardio();
    }//GEN-LAST:event_tabbedPaneCustom1MouseClicked

    private void JTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableMouseClicked
        // TODO add your handling code here:
        tab_all_patient();
        //tab_all_dermato();
        //tab_all_ohpto();
        //tab_all_cardio();
        //tab_all_general();
        // int row = JTable.getSelectedRow();

        // Obtenir la valeur de la première colonne dans la ligne sélectionnée
        //Object value = JTable.getValueAt(row, 0);

        // Faites quelque chose avec la valeur récupérée, par exemple l'afficher dans la console
        //System.out.println("Valeur de la première colonne : " + value);
    }//GEN-LAST:event_JTableMouseClicked

    public void date()
    {
    Date d = new Date();
    SimpleDateFormat dat = new SimpleDateFormat("EEEE-dd-MMM-yyyy");
    
    }
     
     
     public void paiement(String nom , String prenom ,String id)
     {
         Date d = new Date();
             java.sql.Date ladate = new java.sql.Date(d.getTime());
                String montant = "5000"; 
         try {
             Class.forName("com.mysql.jdbc.Driver");
                sqlConn = DriverManager.getConnection(dataConn,username,password);
                pst_search = sqlConn.prepareStatement("insert into factureconsultation(id_consultation,nom,prenoms,prix,date) value(?,?,?,?,?)");
                //pst_search = sqlConn.prepareCall("Select * from consultation,factureconsultation where nomPatient=? and prenomPatient=? and date_consultation=? and etat='Non Payer' and factureconsultation.id_consultation=consultation.idConsultation");
                pst_search.setString(1, id);
                pst_search.setString(2, nom);
                pst_search.setString(3, prenom);
                pst_search.setString(4, montant);
                pst_search.setDate(4, ladate);
                pst_search.executeUpdate();
         } catch (Exception e) {
         }
     
     }
      public void tab_all_patient ()
    {
         try {
          Class.forName("com.mysql.jdbc.Driver");
    sqlConn = DriverManager.getConnection(dataConn,username,password);
     pst_tab = sqlConn.prepareStatement("Select * from consultation,service,type_analyse where id_service = id and id_serv = id");
     rs_tab = pst_tab.executeQuery () ;
    ResultSetMetaData stData = rs_tab.getMetaData () ;
    q = stData. getColumnCount () ;
    DefaultTableModel RecordTable = (DefaultTableModel)JTable.getModel();
    RecordTable.setRowCount(0);
     while(rs_tab.next()){
     Vector columnData= new Vector();
        for (i=1; i<=q ; i++){
            columnData.add(rs_tab.getString("nomPatient"));
            columnData.add(rs_tab.getString("prenomPatient"));
            columnData.add(rs_tab.getString("telephone"));
            columnData.add(rs_tab.getString("adresse"));
            columnData.add(rs_tab.getString("date_consultation"));
            columnData.add(rs_tab.getString("service_libelle"));   
             columnData.add(rs_tab.getString("libelle_analyse"));   
     }
        RecordTable.addRow(columnData);
     }
        } catch (Exception e) {
        }
    }
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTable;
    private com.raven.swing.PanelBorder all_patient;
    private javax.swing.JScrollPane jScrollPanel_all;
    private raven.tabbed.TabbedPaneCustom tabbedPaneCustom1;
    private textfield.textsearch textsearch1;
    // End of variables declaration//GEN-END:variables
}