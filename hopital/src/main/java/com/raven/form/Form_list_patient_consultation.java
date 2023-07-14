/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;



import com.mycompany.hopital.Login_form;
import com.mycompany.hopital.Main_Caissier;
import com.raven.datechooser.EventDateChooser;
import com.raven.datechooser.SelectedAction;
import com.raven.datechooser.SelectedDate;
import static com.raven.form.Form_enregistrement.showPopup;
import icon.tableaction;
import icon.tablecelleditor;
import icon.tablecellrender;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import sample.message.Message;
import table.TableCustom;

/**
 *
 * @author Trafiquant de Tigbé
 */
public class Form_list_patient_consultation extends javax.swing.JPanel {
 private static final String username = "root";
 private static final String password = "primatologue";
 private static final String dataConn = "jdbc:mysql://localhost:3306/hopital";
 private static Form_list_patient_consultation instance;
 Connection sqlConn = null;
 Connection sqlSearch = null;
 PreparedStatement pst = null;
 PreparedStatement pst_search = null;
 ResultSet rs = null;
 ResultSet rs_2 = null;
 PreparedStatement pst_tab = null;
 ResultSet rs_tab = null;
 int q, i , id, deleteItem;
 Message obj = new Message();

    /**
     * Creates new form Jpanel_admin_Medecin
     */
    public Form_list_patient_consultation() {
        initComponents();
        setOpaque(false);     
        TableCustom.apply(jScrollPanel_all, TableCustom.TableType.DEFAULT);
        tab_all_patient();
        JTable.getColumnModel().getColumn(9).setCellRenderer(new tablecellrender());
         tableaction event = new tableaction() {
            @Override
            public void payer(int row)
            {
                int selectedRowIndex = JTable.getSelectedRow();
                TableModel model = JTable.getModel();
                String etat = model.getValueAt(selectedRowIndex, 8).toString();
                   if(etat.equalsIgnoreCase("Non Payer")){
                    test panel2 = new test();
                     panel2.setVisible(true);

                     if(panel2.isShowing())
                     {
                      String nom = model.getValueAt(selectedRowIndex, 0).toString();
                     String prenom = model.getValueAt(selectedRowIndex, 1).toString();
                     String contact = model.getValueAt(selectedRowIndex, 2).toString();
                     String prix = model.getValueAt(selectedRowIndex, 7).toString();
                     String service = model.getValueAt(selectedRowIndex, 5).toString();
                     String analyse = model.getValueAt(selectedRowIndex, 6).toString();
                     String n_consultation = model.getValueAt(selectedRowIndex, 3).toString();
                     
                    panel2.pack();
                    panel2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    panel2.txt.setText(nom);
                    panel2.prenom.setText(prenom);
                    panel2.contact.setText(contact);
                    panel2.service.setText(service);
                    panel2.analyse.setText(analyse);
                    panel2.prix.setText(prix.concat(" Fr CFA"));
                    panel2.n_consultation.setText(n_consultation);
                     }
                 else
                     {
                         tab_all_patient();
                     }
                    
                   
                   }
                  
                   else
                   {
                         obj.message.setText("Frais de consultation déja régler \n"
                               + "Appuyer sur l'icone Imprimer pour l'impression du reçu ");
                                 showPopup(obj);
                     
                   }
             

            
            }
            @Override           
            public void imprimer(int row)
            {
            int selectedRowIndex = JTable.getSelectedRow();
                TableModel model = JTable.getModel();
                String etat = model.getValueAt(selectedRowIndex, 8).toString();
                   if(etat.equalsIgnoreCase("Payer")){
                    test panel2 = new test();
                     

                     
                      String nom = model.getValueAt(selectedRowIndex, 0).toString();
                     String prenom = model.getValueAt(selectedRowIndex, 1).toString();
                     String contact = model.getValueAt(selectedRowIndex, 2).toString();
                     String prix = model.getValueAt(selectedRowIndex, 7).toString();
                     String service = model.getValueAt(selectedRowIndex, 5).toString();
                     String analyse = model.getValueAt(selectedRowIndex, 6).toString();
                     String n_consultation = model.getValueAt(selectedRowIndex, 3).toString();
                     
                    panel2.pack();
                    panel2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    panel2.txt.setText(nom);
                    panel2.prenom.setText(prenom);
                    panel2.contact.setText(contact);
                    panel2.service.setText(service);
                    panel2.analyse.setText(analyse);
                    panel2.prix.setText(prix.concat(" Fr CFA"));
                    panel2.n_consultation.setText(n_consultation);
                    
                    panel2.date();
                    panel2.numero_recu();
                    panel2.impression();
                 
                       // tab_all_patient();
                     
                    
                   
                   }
                  
                   else
                   {
                        obj.message.setText("Payer les frais de consultation avant toute impression de reçu du paiement");
                         showPopup(obj);
                       
                   }
             
            
            };
         };
         JTable.getColumnModel().getColumn(9).setCellEditor(new tablecelleditor(event));
      
       
        
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

        nnm = new javax.swing.JTextField();
        tabbedPaneCustom1 = new raven.tabbed.TabbedPaneCustom();
        all_patient = new com.raven.swing.PanelBorder();
        jScrollPanel_all = new javax.swing.JScrollPane();
        JTable = new javax.swing.JTable();
        textsearch1 = new textfield.textsearch();

        nnm.setText("jTextField1");

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

        all_patient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                all_patientMouseClicked(evt);
            }
        });
        all_patient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                all_patientKeyPressed(evt);
            }
        });

        jScrollPanel_all.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPanel_allMouseClicked(evt);
            }
        });

        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nom", "Prenom", "Contact", "N°Consultation", "Date Enregistrement", "Service", "Analyse", "Prix", "Etat", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true
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
                .addComponent(jScrollPanel_all, javax.swing.GroupLayout.DEFAULT_SIZE, 1057, Short.MAX_VALUE)
                .addContainerGap())
        );
        all_patientLayout.setVerticalGroup(
            all_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, all_patientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPanel_all, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
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
                .addComponent(textsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPaneCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
           tab_all_patient();
        
    }//GEN-LAST:event_formMouseClicked

    private void textsearch1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textsearch1KeyReleased
        // TODO add your handling code here:
           if (textsearch1.getText().trim().isEmpty() || textsearch1.getText().equalsIgnoreCase("recherche")){
            String id = null;
            id = textsearch1.getText();
          
           tab_all_patient();

        }
        else{
            DefaultTableModel model = (DefaultTableModel) JTable.getModel();
            
            model.setRowCount(0);
            
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
                    String column4Data = resultSet.getString("idconsultation");
                    String column5Data = resultSet.getString("date_consultation");
                    String column6Data = resultSet.getString("service_libelle");
                     String column7Data = resultSet.getString("libelle_analyse");
                     String column8Data = resultSet.getString("prix");
                     String column9Data = resultSet.getString("etat");

                    // Ajouter d'autres colonnes si nécessaire

                    model.addRow(new Object[]{column1Data, column2Data, column3Data, column4Data, column5Data, column6Data, column7Data, column8Data, column9Data});
                    
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
       
    }//GEN-LAST:event_tabbedPaneCustom1KeyPressed

    private void tabbedPaneCustom1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbedPaneCustom1MouseClicked
        // TODO add your handling code here:
        tab_all_patient();
      
    }//GEN-LAST:event_tabbedPaneCustom1MouseClicked

    private void JTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableMouseClicked
        // TODO add your handling code here:
        tab_all_patient();
        //tab_all_patient();
       
        
                     // Form_Home_Users panel2 = new Form_Home_Users();
                   
// Configurer le contenu du JPanel2 (ajouter des étiquettes, des boutons, etc.)
                   
                    //int option = JOptionPane.showOptionDialog(null, panel2, "Titre du popup", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
                      
               //  int result = JOptionPane.showOptionDialog(null, panel2, "Titre du popup", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
                    
                     
                   
                      
                    
                    //Object value = JTable.getValueAt(selectedRowIndex, 0);
                   //txt.setT
                   // String nom = value.toString();
                     //System.out.println(nom);
                       // nnm.setText(nom);
                     
                        
                       //panel2.txt.setText(nom);
                        
                       
                    //Object selectedValue = JTable.getValueAt(selectedRowIndex, 0);
                    //String nom = selectedValue.toString();
                    //Form_Home_Users use = new Form_Home_Users();
                    //use.setVisible(true);
                    //DefaultTableModel table = (DefaultTableModel)JTable.getModel();
                    //int select = JTable.getSelectedRow();
                    //String nn = table.getValueAt(select, 1).toString();
                    //nnm.setText(nn);
                    
                   // use.nom = table.getValueAt(select, 0).toString();
                    
                    
    }//GEN-LAST:event_JTableMouseClicked

    private void all_patientKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_all_patientKeyPressed
        // TODO add your handling code here:
        tab_all_patient();
    }//GEN-LAST:event_all_patientKeyPressed

    private void all_patientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all_patientMouseClicked
        // TODO add your handling code here:
        tab_all_patient();
    }//GEN-LAST:event_all_patientMouseClicked

    private void jScrollPanel_allMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPanel_allMouseClicked
        // TODO add your handling code here:
        tab_all_patient();
    }//GEN-LAST:event_jScrollPanel_allMouseClicked

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
        DefaultTableModel model = (DefaultTableModel) JTable.getModel();
            
            model.setRowCount(0);
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                sqlConn = DriverManager.getConnection(dataConn,username,password);
                pst_tab = sqlConn.prepareStatement("Select * from consultation,service,type_analyse where id_service = id and id_serv=id");
                rs_tab = pst_tab.executeQuery () ;
                while (rs_tab.next()) {
                    String column1Data = rs_tab.getString("nomPatient");
                    String column2Data = rs_tab.getString("prenomPatient");
                    String column3Data = rs_tab.getString("telephone");
                    String column4Data = rs_tab.getString("idconsultation");
                    String column5Data = rs_tab.getString("date_consultation");
                    String column6Data = rs_tab.getString("service_libelle");
                    String column7Data = rs_tab.getString("libelle_analyse");
                     String column8Data = rs_tab.getString("prix");
                     String column9Data = rs_tab.getString("etat");

                    // Ajouter d'autres colonnes si nécessaire

                    model.addRow(new Object[]{column1Data, column2Data, column3Data, column4Data, column5Data, column6Data, column7Data, column8Data, column9Data});
               }
            }
            
            catch (ClassNotFoundException | SQLException e) {
            }
       
    }


    
       
    
         public String numero_consultation()
    {
        String nom = null;
        String name = null;
        String id = null;
        id = Login_form.txtid.getText();
          try {
            Class.forName("com.mysql.jdbc.Driver");
                 sqlConn = DriverManager.getConnection(dataConn,username,password);
                 pst = sqlConn.prepareCall("Select * from users where identifiant = ?");
                    pst.setString(1, id);
                        rs = pst.executeQuery();
                            if (rs.next())
                            {
                               nom = rs.getString("nom");
                              
                               name = nom.concat(" ");
                            }
                               
        } catch (Exception e) {
        }
          return name;
    }
         
         public String service_inf()
    {
        String nom = null;
        
        String id = null;
        id = Login_form.txtid.getText();
          try {
            Class.forName("com.mysql.jdbc.Driver");
                 sqlConn = DriverManager.getConnection(dataConn,username,password);
                 pst = sqlConn.prepareCall("Select * from users,service where identifiant = ? and Service_id = id");
                    pst.setString(1, id);
                        rs = pst.executeQuery();
                            if (rs.next())
                            {
                               nom = rs.getString("service_libelle");
                              
                            }
                               
        } catch (Exception e) {
        }
          return nom;
    }
         public static void showPopup(JPanel panel) {
     JDialog dialog = new JDialog();
    dialog.setUndecorated(true); // Supprimer les bordures de la fenêtre
    dialog.getContentPane().add(panel);
    
    dialog.pack();
    dialog.setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran
    
    dialog.setVisible(true);
}
         
         
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable JTable;
    private com.raven.swing.PanelBorder all_patient;
    private javax.swing.JScrollPane jScrollPanel_all;
    public javax.swing.JTextField nnm;
    public raven.tabbed.TabbedPaneCustom tabbedPaneCustom1;
    private textfield.textsearch textsearch1;
    // End of variables declaration//GEN-END:variables
}
