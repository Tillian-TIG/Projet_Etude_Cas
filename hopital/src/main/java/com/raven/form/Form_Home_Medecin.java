package com.raven.form;

import com.raven.model.Model_Card;
import com.raven.swing.ScrollBar;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Form_Home_Medecin extends javax.swing.JPanel {
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
  String nbre,nbre_consultation;

    public Form_Home_Medecin() {
        initComponents();
        jScrollPane2.setVerticalScrollBar(new ScrollBar());
        jScrollPane2.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPane2.getViewport().setBackground(Color.WHITE);
       tab();
       nbre_consultation = nbre_consultation();
       card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "Consultation en attente",nbre_consultation));
       // card_show_dm1.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "Liste des dossiers medicaux",nbre_consultation));
    }
    
    
   public String nbre_consultation ()
    {
        String nbre_service = null;
     try {
            Class.forName("com.mysql.jdbc.Driver");
                 sqlConn = DriverManager.getConnection(dataConn,username,password);
                 pst = sqlConn.prepareCall("SELECT COUNT(etat) FROM consultation where etat = 'Non traité'");
                 rs = pst.executeQuery();
                 if (rs.next())
                         
                         {
                              nbre_service = rs.getString("COUNT(etat)");
                       //   nombre.setText(nbre);
                         }
        } catch (Exception e) {
        }
        return nbre_service;
    }
   
    public String dm ()
    {
        String dm = null;
     try {
            Class.forName("com.mysql.jdbc.Driver");
                 sqlConn = DriverManager.getConnection(dataConn,username,password);
                 pst = sqlConn.prepareCall("SELECT COUNT(*) FROM dm ");
                 rs = pst.executeQuery();
                 if (rs.next())
                         
                         {
                              dm = rs.getString("COUNT(*)");
                       //   nombre.setText(nbre);
                         }
        } catch (Exception e) {
        }
        return dm;
    }
   
  
      public void tab ()
    {
         try {
          Class.forName("com.mysql.jdbc.Driver");
    sqlConn = DriverManager.getConnection(dataConn,username,password);
     pst_tab = sqlConn.prepareStatement("Select * from consultation");
     rs_tab = pst_tab.executeQuery () ;
    ResultSetMetaData stData = rs_tab.getMetaData () ;
    q = stData. getColumnCount () ;
    DefaultTableModel RecordTable = (DefaultTableModel)table2.getModel();
    RecordTable.setRowCount(0);
     while(rs_tab.next()){
     Vector columnData= new Vector();
        for (i=1; i<=q ; i++){
            columnData.add(rs_tab.getString("idconsultation"));
            columnData.add(rs_tab.getString("nom"));
            columnData.add(rs_tab.getString("prenoms"));
            columnData.add(rs_tab.getString("etat"));
            columnData.add(rs_tab.getString("facture"));
            
            
                
     }
        RecordTable.addRow(columnData);
     }
        } catch (Exception e) {
        }
    }
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        card1 = new com.raven.component.Card();
        panelBorder1 = new com.raven.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new com.raven.swing.Table();

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(23, 109, 132));
        card1.setColor2(new java.awt.Color(23, 109, 132));
        panel.add(card1);

        panelBorder1.setBackground(new java.awt.Color(23, 109, 132));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Liste des demandes de consultation");

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Consultation", "Nom", "Prenoms", "Etat", "Facture"
            }
        ));
        jScrollPane2.setViewportView(table2);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(591, Short.MAX_VALUE))
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 927, Short.MAX_VALUE)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.Card card1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLayeredPane panel;
    private com.raven.swing.PanelBorder panelBorder1;
    private com.raven.swing.Table table2;
    // End of variables declaration//GEN-END:variables
}
