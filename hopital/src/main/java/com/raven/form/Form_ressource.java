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
import icon2.tableaction;
import icon2.tablecelleditor;
import icon2.tablecellrender;
import java.awt.Color;
import java.awt.Dialog.ModalityType;
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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import sample.message.Message;
import table.TableCustom;

/**
 *
 * @author Trafiquant de Tigbé
 */
public class Form_ressource extends javax.swing.JPanel {
 private static final String username = "root";
 private static final String password = "primatologue";
 private static final String dataConn = "jdbc:mysql://localhost:3306/hopital";
 private static Form_ressource instance;
 Connection sqlConn = null;
 Connection sqlConn2 = null;
 Connection sqlConn3= null;
 Connection sqlConn4 = null;
 Connection sqlConn5 = null;
 Connection sqlConn6 = null;
 Connection sqlSearch = null;
 PreparedStatement pst = null;
 PreparedStatement pst_search = null;
 ResultSet rs = null;
 ResultSet rs_2 = null;
 PreparedStatement pst_tab = null;
 PreparedStatement pst_tab2 = null;
 PreparedStatement pst_tab3 = null;
 PreparedStatement pst_tab4 = null;
 PreparedStatement pst_tab5 = null;
 PreparedStatement pst_tab6 = null;
 ResultSet rs_tab = null;
 int q, i , id, deleteItem;
 Message obj = new Message();

    /**
     * Creates new form Jpanel_admin_Medecin
     */
    public Form_ressource() {
        initComponents();
        setOpaque(false);  
        comboservice();
        
        service.setEditable(false);
        TableCustom.apply(jScrollPanel_all, TableCustom.TableType.DEFAULT);
        tab_all_patient();
        JTable.getColumnModel().getColumn(7).setCellRenderer(new tablecellrender());
         tableaction event = new tableaction() {
            @Override
            public void payer(int row)
            {
                int selectedRowIndex = JTable.getSelectedRow();
                TableModel model = JTable.getModel();
                String etat = model.getValueAt(selectedRowIndex, 6).toString();
                String id = model.getValueAt(selectedRowIndex, 0).toString();
                   if(etat.equalsIgnoreCase("En Service")){
                       try {
            Class.forName("com.mysql.jdbc.Driver");
                 sqlConn = DriverManager.getConnection(dataConn,username,password);
                 pst = sqlConn.prepareCall("Select * from users,service,role where idUser = ? and Role_id=rle_id and Service_id = id ");
                    pst.setString(1, id);
                        rs = pst.executeQuery();
                            if (rs.next())
                            {
                                    String user = rs.getString("nom_users").concat(" ").concat(rs.getString("prenom_users"));
                                    Fram_stop t = new Fram_stop();
                                    t.setVisible(true);
                                    t.pack();
                                    t.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    t.identifiant.setText(rs.getString("identifiant"));
                                    t.users.setText(user);
                                    t.poste.setText(rs.getString("role_libelle"));
                                    t.service.setText(rs.getString("service_libelle")); 
                                   // t.nomm = model.getValueAt(selectedRowIndex, 3).toString();
                                   // t.num_con.setText(numero); //= numero;  
                                 //   t.id_user.setText(rs.getString("idUser"));// = rs.getString("idUser");
                                   
                            }
                               
        } catch (Exception e) {
        }
                   }
                   else
                     {
                         JOptionPane.showMessageDialog(null, "Compte déja mis hors d'utilisation");
                     }
            }
         };
         JTable.getColumnModel().getColumn(7).setCellEditor(new tablecelleditor(event));
      
       
        
       // getContentPane().setBackground(new Color(240, 240, 240));
    }
    
    public void selectab( String identifiant )
        {
                try {
            Class.forName("com.mysql.jdbc.Driver");
                 sqlConn = DriverManager.getConnection(dataConn,username,password);
                 pst = sqlConn.prepareCall("Select * from users,service,role where idUser = ? and Role_id=rle_id and Service_id = id ");
                    pst.setString(1, identifiant);
                        rs = pst.executeQuery();
                            if (rs.next())
                            {
                                    String user = rs.getString("nom_users").concat(" ").concat(rs.getString("prenom_users"));
                                    Fram_stop t = new Fram_stop();
                                    t.setVisible(true);
                                    t.pack();
                                    t.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    t.identifiant.setText(rs.getString("identifiant"));
                                    t.users.setText(user);
                                    t.poste.setText(rs.getString("role_libelle"));
                                    t.service.setText(rs.getString("service_libelle")); 
                                   // t.nomm = model.getValueAt(selectedRowIndex, 3).toString();
                                   // t.num_con.setText(numero); //= numero;  
                                 //   t.id_user.setText(rs.getString("idUser"));// = rs.getString("idUser");
                                   
                            }
                               
        } catch (Exception e) {
        }
               
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
        jLabel8 = new javax.swing.JLabel();
        service = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        nnm.setText("jTextField1");

        setBackground(new java.awt.Color(38, 120, 113));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        tabbedPaneCustom1.setBackground(new java.awt.Color(38, 120, 113));
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
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N°ID", "Nom", "Prénoms", "Contact", "Poste", "Service", "Etat", "Mettre hors d'Utilisation"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
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
        if (JTable.getColumnModel().getColumnCount() > 0) {
            JTable.getColumnModel().getColumn(7).setMinWidth(150);
            JTable.getColumnModel().getColumn(7).setPreferredWidth(150);
            JTable.getColumnModel().getColumn(7).setMaxWidth(150);
        }

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
                .addComponent(jScrollPanel_all, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPaneCustom1.addTab("Membre du personnelle", all_patient);

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

        jLabel8.setBackground(new java.awt.Color(234, 233, 233));
        jLabel8.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Service");

        service.setEditable(true);
        service.setFont(new java.awt.Font("Cambria", 1, 17)); // NOI18N
        service.setForeground(new java.awt.Color(1, 74, 124));
        service.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serviceActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 153, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(service, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tabbedPaneCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(service, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabbedPaneCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                String sql = "SELECT * FROM users,service,role WHERE nom_users LIKE ? and service_libelle != 'Admin' and Role_id = rle_id and Service_id = id";
                PreparedStatement statement = sqlConn.prepareStatement(sql);
                statement.setString(1, "%" + textsearch1.getText() + "%");
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                   String column1Data = resultSet.getString("nom_users");
                    String column2Data = resultSet.getString("prenom_users");
                    String column3Data = resultSet.getString("telephone");
                    String column4Data = resultSet.getString("role_libelle");
                    String column5Data = resultSet.getString("service_libelle");
                    String column6Data = resultSet.getString("date");
                    String column7Data = resultSet.getString("etat");

                    // Ajouter d'autres colonnes si nécessaire

                    model.addRow(new Object[]{column1Data, column2Data, column3Data, column4Data, column5Data, column6Data, column7Data});
                    
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

    private void serviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serviceActionPerformed
        // TODO add your handling code here:
        String serv = service.getSelectedItem().toString();
        membre();
       // JOptionPane.showMessageDialog(null, serv);
           // tab_membre(serv, JTable);
    }//GEN-LAST:event_serviceActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String new_service= JOptionPane.showInputDialog(null, "Entrer le service", "Ajouter un service", HEIGHT);
        add_service(new_service);
    }//GEN-LAST:event_jButton1ActionPerformed
    
   
    
    public void date()
    {
    Date d = new Date();
    SimpleDateFormat dat = new SimpleDateFormat("EEEE-dd-MMM-yyyy");
    
    }
     
     
    
        public void tab_all_patient ()
    {
        DefaultTableModel model = (DefaultTableModel) JTable.getModel();
            
            model.setRowCount(0);
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                sqlConn = DriverManager.getConnection(dataConn,username,password);
                pst_tab = sqlConn.prepareStatement("Select * from users,service,role where Role_id = rle_id and Service_id=id and service_libelle != 'Admin'");
                rs_tab = pst_tab.executeQuery () ;
                while (rs_tab.next()) {
                    String column1Data = rs_tab.getString("idUser");
                    String column2Data = rs_tab.getString("nom_users");
                    String column3Data = rs_tab.getString("prenom_users");
                    String column4Data = rs_tab.getString("telephone");
                    String column5Data = rs_tab.getString("role_libelle");
                    String column6Data = rs_tab.getString("service_libelle");
                    String column7Data = rs_tab.getString("etat");
                     
                     
                    // Ajouter d'autres colonnes si nécessaire

                    model.addRow(new Object[]{column1Data, column2Data, column3Data, column4Data, column5Data, column6Data, column7Data});
               }
            }
            
            catch (ClassNotFoundException | SQLException e) {
            }
       
    }

            public void membre ()
    {
        String serv = service.getSelectedItem().toString();
        DefaultTableModel model = (DefaultTableModel) JTable.getModel();
            
            model.setRowCount(0);
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                sqlConn = DriverManager.getConnection(dataConn,username,password);
                pst_tab = sqlConn.prepareStatement("Select * from users,service,role where service_libelle = ? and Role_id = rle_id and Service_id=id");
                pst_tab.setString(1, serv);
                rs_tab = pst_tab.executeQuery () ;
                while (rs_tab.next()) {
                    String column1Data = rs_tab.getString("idUser");
                    String column2Data = rs_tab.getString("nom_users");
                    String column3Data = rs_tab.getString("prenom_users");
                    String column4Data = rs_tab.getString("telephone");
                    String column5Data = rs_tab.getString("role_libelle");
                    String column6Data = rs_tab.getString("service_libelle");
                    String column7Data = rs_tab.getString("etat");
                     
                     
                    // Ajouter d'autres colonnes si nécessaire

                    model.addRow(new Object[]{column1Data, column2Data, column3Data, column4Data, column5Data, column6Data, column7Data});
               }
            }
            
            catch (ClassNotFoundException | SQLException e) {
            }
       
    }

         public String num()
    {
        String nom = null;
        
        String id = null;
        id = service.getSelectedItem().toString();
          try {
            Class.forName("com.mysql.jdbc.Driver");
                 sqlConn = DriverManager.getConnection(dataConn,username,password);
                 pst = sqlConn.prepareCall("Select * from service where service_libelle = ?");
                    pst.setString(1, id);
                        rs = pst.executeQuery();
                            if (rs.next())
                            {
                               nom = rs.getString("id");
                              
                             
                            }
                               
        } catch (Exception e) {
        }
          return nom;
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
          public void comboservice ()
     {
         try {
              Class.forName("com.mysql.jdbc.Driver");
                sqlConn = DriverManager.getConnection(dataConn,username,password);
                pst = sqlConn.prepareCall("Select * from service where service_libelle != 'Admin'");
                 rs = pst.executeQuery();
                 while(rs.next())
                 {
                  service.addItem(rs.getString("service_libelle"));
                  
                 }
         } catch (ClassNotFoundException | SQLException e) {
         }
     }
          public void comboservice_update ()
     {
         service.removeAllItems();
         try {
              Class.forName("com.mysql.jdbc.Driver");
                sqlConn = DriverManager.getConnection(dataConn,username,password);
                pst = sqlConn.prepareCall("Select * from service where service_libelle != 'Admin'");
                 rs = pst.executeQuery();
                 while(rs.next())
                 {
                  
                  service.addItem(rs.getString("service_libelle"));
                  
                 }
         } catch (ClassNotFoundException | SQLException e) {
         }
     }
         
     public void add_service(String ser)
     {
     
         try {
              Class.forName("com.mysql.jdbc.Driver");
                sqlConn = DriverManager.getConnection(dataConn,username,password);
                
                pst_search = sqlConn.prepareCall("Select * from service where service_libelle =?");
                pst_search.setString(1,ser);
                rs_2 = pst_search.executeQuery();
                if(rs_2.next())
                {
                    JOptionPane.showMessageDialog(null, "Service déja existant");
                }
                else
                {
                    pst = sqlConn.prepareStatement("insert into service(service_libelle) value(?)");
                    ser = ser.substring(0, 1).toUpperCase() + ser.substring(1);
                    pst.setString(1, ser);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Service Ajouter avec succès \n"
                            + "Veillez vous réconnecter pour que cette opération puisse prendre effet");
                    
                }
         } catch (Exception e) {
         }
     }  
         
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable JTable;
    private com.raven.swing.PanelBorder all_patient;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPanel_all;
    public javax.swing.JTextField nnm;
    private javax.swing.JComboBox<String> service;
    public raven.tabbed.TabbedPaneCustom tabbedPaneCustom1;
    private textfield.textsearch textsearch1;
    // End of variables declaration//GEN-END:variables
}
