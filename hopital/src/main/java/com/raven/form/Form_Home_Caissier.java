package com.raven.form;

import com.raven.model.Model_Card;
import com.raven.swing.ScrollBar;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import table.TableCustom;
import java.text.*;
import java.awt.print.*;
import javax.swing.table.TableModel;

public class Form_Home_Caissier extends javax.swing.JPanel {
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
  String prix_total,prix_today,nbre_total,nbre_today;

    public Form_Home_Caissier() {
        
        initComponents();
       
       TableCustom.apply(jScrollPanel_all, TableCustom.TableType.DEFAULT);
       TableCustom.apply(jScrollPanel_all1, TableCustom.TableType.DEFAULT);
        tab_all_patient();
        tab_all_operation ();
       Form_Home_Caissier();
       //prix_total = prix_consultation_total();
       //prix_today = prix_consultation_today();
       //nbre_total = nbre_consultation_total();
       //nbre_today = nbre_consultation_today();
       //String  nbre_dm = "0"; 
      // card_show_personnel1.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "Nombre total du personnel ",nbre_personnel));
       //card_show_service1.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "Nombre de Service hospitalier", nbre));
       //card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "Total de consultation payée Aujourd'hui : "+nbre_today,"Prix Total : " + prix_today+" Fr CFA"));
       //card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "Nombre total de consultation payée : "+nbre_total,"Prix Total : " + prix_total + " Fr CFA"));
       // card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "Nombre de dossier medical ",nbre_dm));
    }
    public void Form_Home_Caissier() {

       prix_total = prix_consultation_total();
      String  prix_op_total = prix_operation_total();
       prix_today = prix_consultation_today();
       String prix_op_today = prix_operation_today();
       nbre_total = nbre_consultation_total();
       String nbre_op_total = nbre_operation_total();
       nbre_today = nbre_consultation_today();
       String nbre_op_today = nbre_operation_today();
       //String  nbre_dm = "0"; 
      // card_show_personnel1.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "Nombre total du personnel ",nbre_personnel));
       //card_show_service1.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "Nombre de Service hospitalier", nbre));
       card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "Nombre de consultation au Total : "+nbre_total,"Somme au Total : " + prix_total+" Fr CFA"));
       card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "Nombre d'operation au Total : "+nbre_op_total,"Somme au Total : " + prix_op_total+" Fr CFA"));
      // card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "Nombre de paiement effectué "+prix_op_total ,"Somme total: " + prix_total + " Fr CFA \n"));
       // card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "Nombre de dossier medical ",nbre_dm));
    }
    
    
    
    public String prix_consultation_total ()
    {
        String prix_total = null;
     try {
            Class.forName("com.mysql.jdbc.Driver");
                 sqlConn = DriverManager.getConnection(dataConn,username,password);
                 pst = sqlConn.prepareCall("SELECT sum(prix) FROM factureconsultation");
                 rs = pst.executeQuery();
                 if (rs.next())
                         
                         {
                              prix_total = rs.getString("sum(prix)");
                       //   nombre.setText(nbre);
                         }
        } catch (Exception e) {
        }
        return prix_total;
    }
    public String prix_operation_total ()
    {
        String prix_total = null;
     try {
            Class.forName("com.mysql.jdbc.Driver");
                 sqlConn = DriverManager.getConnection(dataConn,username,password);
                 pst = sqlConn.prepareCall("SELECT sum(prixOperation) FROM factureoperation");
                 rs = pst.executeQuery();
                 if (rs.next())
                         
                         {
                              prix_total = rs.getString("sum(prixOperation)");
                       //   nombre.setText(nbre);
                         }
        } catch (Exception e) {
        }
        return prix_total;
    }
    
    
     public void prix_consultation_total_recherche ()
    {
        String prix_total_search=null;
        String prix_total_search2=null;
     try {
            Class.forName("com.mysql.jdbc.Driver");
                 sqlConn = DriverManager.getConnection(dataConn,username,password);
                 pst = sqlConn.prepareCall("SELECT sum(prix) FROM factureconsultation WHERE date BETWEEN ? AND ? ");
                 pst.setString(1, textsearch1.getText());
                 pst.setString(2, textsearch2.getText());
                 rs = pst.executeQuery();
                 if (rs.next())
                         
                         {
                             prix_total_search = rs.getString("sum(prix)");
                       //   nombre.setText(nbre);
                         }
                 pst = sqlConn.prepareCall("SELECT COUNT(*) FROM factureconsultation WHERE date BETWEEN ? AND ? ");
                 pst.setString(1, textsearch1.getText());
                 pst.setString(2, textsearch2.getText());
                 rs = pst.executeQuery();
                 if (rs.next())
                         
                         {
                             prix_total_search2 = rs.getString("COUNT(*)");
                       //   nombre.setText(nbre);
                         }
                   card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "Nombre total de consultation du : "+textsearch1.getText()+" au "+textsearch2.getText()+" : "+prix_total_search2  ,"Compte au Total : " + prix_total_search+" Fr CFA"));
        } catch (Exception e) {
        }
       
        
    }
      public void prix_operation_total_recherche ()
    {
        String prix_total_search=null;
        String prix_total_search2=null;
     try {
            Class.forName("com.mysql.jdbc.Driver");
                 sqlConn = DriverManager.getConnection(dataConn,username,password);
                 pst = sqlConn.prepareCall("SELECT sum(prixOperation) FROM factureoperation WHERE date_paiement_op BETWEEN ? AND ? ");
                 pst.setString(1, textsearch1.getText());
                 pst.setString(2, textsearch2.getText());
                 rs = pst.executeQuery();
                 if (rs.next())
                         
                         {
                             prix_total_search = rs.getString("sum(prixOperation)");
                       //   nombre.setText(nbre);
                         }
                 pst = sqlConn.prepareCall("SELECT COUNT(*) FROM factureconsultation WHERE date_paiement_op BETWEEN ? AND ? ");
                 pst.setString(1, textsearch1.getText());
                 pst.setString(2, textsearch2.getText());
                 rs = pst.executeQuery();
                 if (rs.next())
                         
                         {
                             prix_total_search2 = rs.getString("COUNT(*)");
                       //   nombre.setText(nbre);
                         }
                   card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "Nombre total d'operation du : "+textsearch1.getText()+" au "+textsearch2.getText()+" : "+prix_total_search2  ,"Compte au Total : " + prix_total_search+" Fr CFA"));
        } catch (Exception e) {
        }
       
        
    }
    
    public String nbre_consultation_total ()
    {
        String nbre_total = null;
     try {
            Class.forName("com.mysql.jdbc.Driver");
                 sqlConn = DriverManager.getConnection(dataConn,username,password);
                 pst = sqlConn.prepareCall("SELECT COUNT(*) FROM factureconsultation");
                 rs = pst.executeQuery();
                 if (rs.next())
                         
                         {
                              nbre_total = rs.getString("COUNT(*)");
                       //   nombre.setText(nbre);
                         }
        } catch (Exception e) {
        }
        return nbre_total;
    }
    public String nbre_operation_total ()
    {
        String nbre_total = null;
     try {
            Class.forName("com.mysql.jdbc.Driver");
                 sqlConn = DriverManager.getConnection(dataConn,username,password);
                 pst = sqlConn.prepareCall("SELECT COUNT(*) FROM factureoperation");
                 rs = pst.executeQuery();
                 if (rs.next())
                         
                         {
                              nbre_total = rs.getString("COUNT(*)");
                       //   nombre.setText(nbre);
                         }
        } catch (Exception e) {
        }
        return nbre_total;
    }
    
    public String prix_consultation_today ()
    {
         Date d = new Date();
        SimpleDateFormat form = new SimpleDateFormat("dd-MM-yyyy");
        String ladate = form.format(d);
        String prix_today = null;
     try {
            Class.forName("com.mysql.jdbc.Driver");
                 sqlConn = DriverManager.getConnection(dataConn,username,password);
                 pst = sqlConn.prepareCall("SELECT sum(prix) FROM factureconsultation where  date = ?");
                 pst.setString(1, ladate);
                 rs = pst.executeQuery();
                 if (rs.next())
                         
                         {
                             
                              prix_today = rs.getString("sum(prix)");
                              
                       //   nombre.setText(nbre);
                         }
        } catch (Exception e) {
        }
        return prix_today;
    }
    
    public String prix_operation_today ()
    {
         Date d = new Date();
        SimpleDateFormat form = new SimpleDateFormat("dd-MM-yyyy");
        String ladate = form.format(d);
        String prix_today = null;
     try {
            Class.forName("com.mysql.jdbc.Driver");
                 sqlConn = DriverManager.getConnection(dataConn,username,password);
                 pst = sqlConn.prepareCall("SELECT sum(prixOperation) FROM factureoperation where  date_paiement_op = ?");
                 pst.setString(1, ladate);
                 rs = pst.executeQuery();
                 if (rs.next())
                         
                         {
                             
                              prix_today = rs.getString("sum(prixOperation)");
                              
                       //   nombre.setText(nbre);
                         }
        } catch (Exception e) {
        }
        return prix_today;
    }
    
    public String nbre_consultation_today ()
    {
         Date d = new Date();
        SimpleDateFormat form = new SimpleDateFormat("dd-MM-yyyy");
        String ladate = form.format(d);
        String nbre_today = null;
     try {
            Class.forName("com.mysql.jdbc.Driver");
                 sqlConn = DriverManager.getConnection(dataConn,username,password);
                 pst = sqlConn.prepareCall("SELECT COUNT(*) FROM factureconsultation where  date = ?");
                 pst.setString(1, ladate);
                 rs = pst.executeQuery();
                 if (rs.next())
                         
                         {
                             
                              nbre_today = rs.getString("COUNT(*)");
                       //   nombre.setText(nbre);
                         }
        } catch (Exception e) {
        }
        return nbre_today;
    }
    
    public String nbre_operation_today ()
    {
         Date d = new Date();
        SimpleDateFormat form = new SimpleDateFormat("dd-MM-yyyy");
        String ladate = form.format(d);
        String nbre_today = null;
     try {
            Class.forName("com.mysql.jdbc.Driver");
                 sqlConn = DriverManager.getConnection(dataConn,username,password);
                 pst = sqlConn.prepareCall("SELECT COUNT(*) FROM factureoperation where  date_paiement_op = ?");
                 pst.setString(1, ladate);
                 rs = pst.executeQuery();
                 if (rs.next())
                         
                         {
                             
                              nbre_today = rs.getString("COUNT(*)");
                       //   nombre.setText(nbre);
                         }
        } catch (Exception e) {
        }
        return nbre_today;
    }
     
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        dateChooser2 = new com.raven.datechooser.DateChooser();
        panel = new javax.swing.JLayeredPane();
        card1 = new com.raven.component.Card();
        card3 = new com.raven.component.Card();
        textsearch2 = new textfield.textsearch();
        tabbedPaneCustom1 = new raven.tabbed.TabbedPaneCustom();
        all_patient = new com.raven.swing.PanelBorder();
        jScrollPanel_all = new javax.swing.JScrollPane();
        JTable2 = new javax.swing.JTable();
        panelBorder1 = new com.raven.swing.PanelBorder();
        jScrollPanel_all1 = new javax.swing.JScrollPane();
        JTable3 = new javax.swing.JTable();
        textsearch1 = new textfield.textsearch();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        dateChooser1.setTextRefernce(textsearch1);

        dateChooser2.setForeground(new java.awt.Color(38, 120, 113));
        dateChooser2.setTextRefernce(textsearch2);

        setBackground(new java.awt.Color(25, 110, 129));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(25, 110, 129));
        card1.setColor2(new java.awt.Color(54, 182, 211));
        card1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card1MouseClicked(evt);
            }
        });
        panel.add(card1);

        card3.setColor1(new java.awt.Color(25, 110, 129));
        card3.setColor2(new java.awt.Color(54, 182, 211));
        card3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card3MouseClicked(evt);
            }
        });
        card3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                card3KeyPressed(evt);
            }
        });
        panel.add(card3);

        textsearch2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textsearch22MouseClicked(evt);
            }
        });
        textsearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textsearch22ActionPerformed(evt);
            }
        });
        textsearch2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textsearch22KeyReleased(evt);
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

        JTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom", "Prenom", "Contact", "N°Consultation", "Service", "Analyse", "Prix", "Date de Paiement"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTable2.setRowHeight(40);
        JTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable2MouseClicked(evt);
            }
        });
        jScrollPanel_all.setViewportView(JTable2);
        if (JTable2.getColumnModel().getColumnCount() > 0) {
            JTable2.getColumnModel().getColumn(3).setHeaderValue("Traitement");
        }

        javax.swing.GroupLayout all_patientLayout = new javax.swing.GroupLayout(all_patient);
        all_patient.setLayout(all_patientLayout);
        all_patientLayout.setHorizontalGroup(
            all_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(all_patientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPanel_all, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
                .addContainerGap())
        );
        all_patientLayout.setVerticalGroup(
            all_patientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(all_patientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPanel_all, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPaneCustom1.addTab("Liste des paiements consultations", all_patient);

        jScrollPanel_all1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPanel_all1MouseClicked(evt);
            }
        });

        JTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom", "Prenom", "Contact", "Service", "Operation", "Prix", "Date de Paiement"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTable3.setRowHeight(40);
        JTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable3MouseClicked(evt);
            }
        });
        jScrollPanel_all1.setViewportView(JTable3);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPanel_all1, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPanel_all1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPaneCustom1.addTab("Liste des paiements operations", panelBorder1);

        textsearch1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textsearch1MouseClicked(evt);
            }
        });
        textsearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textsearch1ActionPerformed(evt);
            }
        });
        textsearch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textsearch1KeyReleased(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("liste de paiement du :");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("au");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textsearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 919, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tabbedPaneCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textsearch2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textsearch1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(10, 10, 10)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(429, 429, 429))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(255, Short.MAX_VALUE)
                    .addComponent(tabbedPaneCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
      Form_Home_Caissier();
      tab_all_patient();
      tab_all_operation ();
    }//GEN-LAST:event_formMouseClicked

    private void textsearch22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textsearch22MouseClicked
        // TODO add your handling code here:
      //  textsearch2.setText("");
    }//GEN-LAST:event_textsearch22MouseClicked

    private void textsearch22KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textsearch22KeyReleased
        // TODO add your handling code here:
          DefaultTableModel model = (DefaultTableModel) JTable2.getModel();
           DefaultTableModel model2 = (DefaultTableModel) JTable3.getModel();
            model.setRowCount(0);
            model2.setRowCount(0);
            try {
                Class.forName("com.mysql.jdbc.Driver");
                sqlConn = DriverManager.getConnection(dataConn,username,password);
                String sql = "SELECT * FROM  factureconsultation,service,type_analyse WHERE date BETWEEN ? AND ? and idservice = id and type_analyse=idtype_analyse";
                PreparedStatement statement = sqlConn.prepareStatement(sql);
                statement.setString(1, textsearch1.getText() );
                statement.setString(2, textsearch2.getText() );
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String column1Data = resultSet.getString("nom");
                    String column2Data = resultSet.getString("prenoms");
                    String column3Data = resultSet.getString("contact");
                    String column4Data = resultSet.getString("id_consultation");
                    String column5Data = resultSet.getString("service_libelle");
                    String column6Data = resultSet.getString("libelle_analyse");
                     String column7Data = resultSet.getString("prix");
                    String column8Data = resultSet.getString("date");

                    // Ajouter d'autres colonnes si nécessaire

                    model.addRow(new Object[]{column1Data, column2Data, column3Data, column4Data, column5Data, column6Data, column7Data, column8Data});
                    prix_consultation_total_recherche();
                }
            } catch (Exception e) {
            }
            
             try {
                Class.forName("com.mysql.jdbc.Driver");
                sqlSearch = DriverManager.getConnection(dataConn,username,password);
                String sql = "SELECT * FROM  factureoperation,operation,dm,service WHERE date_paiement_op BETWEEN ? AND ? and id_Operation = idOperation and id_fac_dm=idDm and id_fac_op_ser = id ";
                pst= sqlSearch.prepareStatement(sql);
                pst.setString(1, textsearch1.getText() );
                pst.setString(2, textsearch2.getText() );
                rs = pst.executeQuery();
                while (rs.next()) {
                    String column1Data = rs.getString("nom");
                    String column2Data = rs.getString("prenom");
                    String column3Data = rs.getString("contact");
                    String column4Data = rs.getString("service_libelle");
                    String column5Data = rs.getString("libelleOperation");
                    String column6Data = rs.getString("prix_op");
                    String column7Data = rs.getString("date_paiement_op");
                    

                    // Ajouter d'autres colonnes si nécessaire

                    model2.addRow(new Object[]{column1Data, column2Data, column3Data, column4Data, column5Data, column6Data, column7Data});
                    prix_operation_total_recherche();
                }
            } catch (Exception e) {
            }

         
    }//GEN-LAST:event_textsearch22KeyReleased

    private void textsearch22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textsearch22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textsearch22ActionPerformed

    private void textsearch1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textsearch1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_textsearch1MouseClicked

    private void textsearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textsearch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textsearch1ActionPerformed

    private void textsearch1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textsearch1KeyReleased
        // TODO add your handling code here: 
    }//GEN-LAST:event_textsearch1KeyReleased

    private void tabbedPaneCustom1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabbedPaneCustom1KeyPressed
        // TODO add your handling code here:
        tab_all_patient();
        tab_all_operation ();
    }//GEN-LAST:event_tabbedPaneCustom1KeyPressed

    private void tabbedPaneCustom1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbedPaneCustom1MouseClicked
        // TODO add your handling code here:
        tab_all_patient();
        Form_Home_Caissier();
        tab_all_operation ();
    }//GEN-LAST:event_tabbedPaneCustom1MouseClicked

    private void all_patientKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_all_patientKeyPressed
        // TODO add your handling code here:
        tab_all_patient();
        tab_all_operation ();
    }//GEN-LAST:event_all_patientKeyPressed

    private void all_patientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all_patientMouseClicked
        // TODO add your handling code here:
        tab_all_patient();
        tab_all_operation ();
    }//GEN-LAST:event_all_patientMouseClicked

    private void jScrollPanel_allMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPanel_allMouseClicked
        // TODO add your handling code here:
        tab_all_patient();
        tab_all_operation ();
    }//GEN-LAST:event_jScrollPanel_allMouseClicked

    private void JTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable2MouseClicked
        // TODO add your handling code here:
        tab_all_patient();
        Form_Home_Caissier();
        tab_all_operation ();
    }//GEN-LAST:event_JTable2MouseClicked

    private void JTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JTable3MouseClicked

    private void jScrollPanel_all1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPanel_all1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPanel_all1MouseClicked

    private void card1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card1MouseClicked
        // TODO add your handling code here:
         print(JTable2);
    }//GEN-LAST:event_card1MouseClicked

    private void card3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_card3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_card3KeyPressed

    private void card3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card3MouseClicked
        // TODO add your handling code here:
         print(JTable3);
    }//GEN-LAST:event_card3MouseClicked

     public void tab_all_patient ()
    {
        DefaultTableModel model = (DefaultTableModel) JTable2.getModel();
            
            model.setRowCount(0);
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                sqlConn = DriverManager.getConnection(dataConn,username,password);
                pst_tab = sqlConn.prepareStatement("Select * from factureconsultation,service,type_analyse where idservice = id and type_analyse=idtype_analyse");
                rs_tab = pst_tab.executeQuery () ;
                while (rs_tab.next()) {
                    String column1Data = rs_tab.getString("nom");
                    String column2Data = rs_tab.getString("prenoms");
                    String column3Data = rs_tab.getString("contact");
                    String column4Data = rs_tab.getString("id_consultation");
                    String column5Data = rs_tab.getString("service_libelle");
                    String column6Data = rs_tab.getString("libelle_analyse");
                     String column7Data = rs_tab.getString("prix");
                    String column8Data = rs_tab.getString("date");
                    
                     
                 

                    // Ajouter d'autres colonnes si nécessaire

                    model.addRow(new Object[]{column1Data, column2Data, column3Data, column4Data, column5Data, column6Data, column7Data, column8Data});
               }
            }
            
            catch (ClassNotFoundException | SQLException e) {
            }
       
    }
     public void tab_all_operation ()
    {
        DefaultTableModel model = (DefaultTableModel) JTable3.getModel();
            
            model.setRowCount(0);
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                sqlConn = DriverManager.getConnection(dataConn,username,password);
                pst_tab = sqlConn.prepareStatement("Select * from factureoperation,operation,service,dm where id_Operation = idOperation and id_fac_dm = idDm and id_fac_op_ser = id ");
                rs_tab = pst_tab.executeQuery () ;
                while (rs_tab.next()) {
                    String column1Data = rs_tab.getString("nom");
                    String column2Data = rs_tab.getString("prenom");
                    String column3Data = rs_tab.getString("contact");
                    String column4Data = rs_tab.getString("service_libelle");
                    String column5Data = rs_tab.getString("libelleOperation");
                     String column6Data = rs_tab.getString("prixOperation");
                    String column7Data = rs_tab.getString("date_paiement_op");
                    
                     
                 

                    // Ajouter d'autres colonnes si nécessaire

                    model.addRow(new Object[]{column1Data, column2Data, column3Data, column4Data, column5Data, column6Data, column7Data});
               }
            }
            
            catch (ClassNotFoundException | SQLException e) {
            }
       
    }
    public void print(JTable table) {
        Date d = new Date();
        SimpleDateFormat form = new SimpleDateFormat("dd-MM-yyyy");
        String ladate = form.format(d);
        TableModel model = table.getModel();
        MessageFormat header = new MessageFormat("Liste des paiement du "+textsearch1.getText()+" au "+textsearch2.getText());
        MessageFormat footer = new MessageFormat("Page{0, number, integer}");
        if(textsearch1.getText().equalsIgnoreCase(textsearch2.getText()))
        {
            if(textsearch1.getText().equalsIgnoreCase(textsearch2.getText())&& textsearch1.getText().equalsIgnoreCase(ladate))
            {
                header = new MessageFormat("Liste des paiements");
                footer = new MessageFormat("Page{0, number, integer}");
            }
            else if(textsearch1.getText().equalsIgnoreCase(textsearch2.getText()))
            {
                header = new MessageFormat("Liste des paiements du "+textsearch1.getText());
                footer = new MessageFormat("Page{0, number, integer}");
            }
            else
            {
                header = new MessageFormat("Liste des paiements du "+textsearch1.getText()+" au "+textsearch2.getText());
                footer = new MessageFormat("Page{0, number, integer}");
            }
        }
        try {
            boolean complete = table.print(JTable.PrintMode.FIT_WIDTH,header,footer);
            if (complete) {
                System.out.println("Impression terminée !");
            } else {
                System.out.println("Impression annulée.");
            }
        } catch (PrinterException pe) {
            System.out.println("Erreur lors de l'impression : " + pe);
        }
    }
    
    public class TablePrinter implements Printable {

    private JTable table;
    private String header;
    private String footer;

    public TablePrinter(JTable table, String header, String footer) {
        this.table = table;
        this.header = header;
        this.footer = footer;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        // Imprimer l'en-tête
        Font headerFont = new Font("Arial", Font.BOLD, 14);
        FontMetrics headerFontMetrics = g2d.getFontMetrics(headerFont);
        int headerHeight = headerFontMetrics.getHeight();
        g2d.setFont(headerFont);
        g2d.drawString(header, 0, headerHeight);

        // Calculer la hauteur de l'en-tête et du pied de page
        int tableHeaderHeight = table.getTableHeader().getHeight();
        int tableFooterHeight = 20; // Hauteur arbitraire pour le pied de page
        int usableHeight = (int) pageFormat.getImageableHeight() - headerHeight - tableFooterHeight;

        // Calculer le nombre de lignes pouvant être affichées sur une page
        int rowsPerPage = usableHeight / table.getRowHeight();

        // Calculer le numéro de ligne de départ
        int startRow = pageIndex * rowsPerPage;

        // Calculer le numéro de ligne de fin
        int endRow = Math.min(startRow + rowsPerPage, table.getRowCount());

        // Afficher les lignes de la table sur la page
        for (int row = startRow; row < endRow; row++) {
            int rowOffset = (row - startRow) * table.getRowHeight() + headerHeight + tableHeaderHeight;
            for (int column = 0; column < table.getColumnCount(); column++) {
                int columnWidth = table.getColumnModel().getColumn(column).getWidth();
                int cellHeight = table.getRowHeight(row);
                Rectangle cellRect = new Rectangle(columnWidth * column, rowOffset, columnWidth, cellHeight);
                paintCell(g2d, row, column, cellRect);
            }
        }

        // Imprimer le pied de page
        Font footerFont = new Font("Arial", Font.PLAIN, 12);
        FontMetrics footerFontMetrics = g2d.getFontMetrics(footerFont);
        int footerHeight = footerFontMetrics.getHeight();
        g2d.setFont(footerFont);
        g2d.drawString(footer, 0, (int) pageFormat.getImageableHeight() - footerHeight);

        return PAGE_EXISTS;
    }

    private void paintCell(Graphics2D g2d, int row, int column, Rectangle cellRect) {
        Component component = table.getCellRenderer(row, column)
                                  .getTableCellRendererComponent(table, table.getValueAt(row, column), false, false, row, column);
        component.setBounds(cellRect);
        component.validate();
        component.print(g2d);
    }

    public void printTable() {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable(this);
        boolean doPrint = printerJob.printDialog();
        if (doPrint) {
            try {
                printerJob.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable JTable2;
    public javax.swing.JTable JTable3;
    private com.raven.swing.PanelBorder all_patient;
    private com.raven.component.Card card1;
    private com.raven.component.Card card3;
    private com.raven.datechooser.DateChooser dateChooser1;
    private com.raven.datechooser.DateChooser dateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPanel_all;
    private javax.swing.JScrollPane jScrollPanel_all1;
    private javax.swing.JLayeredPane panel;
    private com.raven.swing.PanelBorder panelBorder1;
    public raven.tabbed.TabbedPaneCustom tabbedPaneCustom1;
    private textfield.textsearch textsearch1;
    private textfield.textsearch textsearch2;
    // End of variables declaration//GEN-END:variables
}
