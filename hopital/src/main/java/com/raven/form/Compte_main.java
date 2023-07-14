package com.raven.form;

import com.raven.model.Model_Card;
import com.raven.swing.ScrollBar;
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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import com.mycompany.hopital.Login_form;

public class Compte_main extends javax.swing.JPanel {
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
  String nbre,nbre_personnel;

    public Compte_main() {
        initComponents();
        date();
        affichage();
        ldate.setEditable(false);
       
        
    }
    
    
  
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.raven.swing.PanelBorder();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        inf_nom = new javax.swing.JLabel();
        inf_prenom = new javax.swing.JLabel();
        inf_numero = new javax.swing.JLabel();
        identifiant = new textfield.TextField();
        numero = new textfield.TextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        ldate = new textfield.TextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        mdp = new textfield.PasswordField();
        nmdp = new textfield.PasswordField();

        setBackground(new java.awt.Color(38, 120, 113));

        panelBorder1.setBackground(new java.awt.Color(38, 120, 113));

        jLabel4.setBackground(new java.awt.Color(234, 233, 233));
        jLabel4.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Identifiant");

        jLabel2.setBackground(new java.awt.Color(234, 233, 233));
        jLabel2.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Mot de passe");

        jLabel3.setBackground(new java.awt.Color(234, 233, 233));
        jLabel3.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Telephone");

        jButton1.setBackground(new java.awt.Color(242, 242, 242));
        jButton1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(17, 115, 168));
        jButton1.setText("Modifier");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(0, 102, 102));
        jLabel7.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Mon Compte");

        inf_nom.setBackground(new java.awt.Color(234, 233, 233));
        inf_nom.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        inf_nom.setForeground(new java.awt.Color(255, 255, 255));
        inf_nom.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        inf_prenom.setBackground(new java.awt.Color(234, 233, 233));
        inf_prenom.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        inf_prenom.setForeground(new java.awt.Color(255, 255, 255));
        inf_prenom.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        inf_numero.setBackground(new java.awt.Color(234, 233, 233));
        inf_numero.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        inf_numero.setForeground(new java.awt.Color(255, 255, 255));
        inf_numero.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        identifiant.setLabelText("Identifiant");
        identifiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identifiantActionPerformed(evt);
            }
        });
        identifiant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                identifiantKeyTyped(evt);
            }
        });

        numero.setLabelText("Numero");
        numero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numeroKeyTyped(evt);
            }
        });

        ldate.setLabelText("Mot de passe");
        ldate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ldateActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(234, 233, 233));
        jLabel8.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Ancien Mot de passe");

        jLabel13.setBackground(new java.awt.Color(234, 233, 233));
        jLabel13.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Date");

        mdp.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        mdp.setLabelText("Votre ancien mot de Passe");
        mdp.setShowAndHide(true);
        mdp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mdpActionPerformed(evt);
            }
        });

        nmdp.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        nmdp.setLabelText("Votre nouveau mot de Passe");
        nmdp.setShowAndHide(true);
        nmdp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nmdpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(inf_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inf_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inf_prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(panelBorder1Layout.createSequentialGroup()
                                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(64, 64, 64)
                                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(numero, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                                        .addComponent(identifiant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator2)
                                .addGroup(panelBorder1Layout.createSequentialGroup()
                                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(panelBorder1Layout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(28, 28, 28))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBorder1Layout.createSequentialGroup()
                                            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBorder1Layout.createSequentialGroup()
                                                    .addGap(4, 4, 4)
                                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ldate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(mdp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nmdp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)))
                                .addComponent(jSeparator4))
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(152, 152, 152))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(340, 340, 340))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(335, 335, 335))))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(identifiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nmdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                        .addGap(8, 8, 8)))
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(117, 117, 117))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(ldate, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inf_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inf_prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(inf_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int taille_mdp = nmdp.getText().length();
        int taille_identifiant = identifiant.getText().length();
        int taille_numero = numero.getText().length();
        String name = Login_form.txtid.getText();
        Date d = new Date();
        
        java.sql.Date ladate = new java.sql.Date(d.getTime());
        
       if (mdp.getText().trim().isEmpty())
        {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Mot de passe requise pour toute modification de vos informations personnelle");
        }

        else if (taille_mdp < 8)
        {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Mot de passe Invalide \n"
                    + "Minimum 8 caratères");
        }

        else if (taille_identifiant <8 )
        {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Identifiant Invalide \n"
                    + "Minimum 8 caractères");
        }
        else if (taille_numero < 8)
        {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Numero Invalide");
        }
         

        else
        {

            try {

                Class.forName("com.mysql.jdbc.Driver");
                sqlConn = DriverManager.getConnection(dataConn,username,password);
                pst = sqlConn.prepareCall("Select * from users where mdp=?");
                pst.setString(1, mdp.getText());
                rs_2 = pst.executeQuery();

                if(rs_2.next())
                {
                    sqlSearch = DriverManager.getConnection(dataConn,username,password);
                    String nom_doc = rs_2.getString("nom_users");
                    String prenom_doc = rs_2.getString("prenom_users");
                    String mdp_doc = rs_2.getString("mdp");
                    pst_search = sqlSearch.prepareStatement("Update users set telephone = ? , identifiant = ? , mdp = ? where nom_users = ? and prenom_users = ? ");
                    pst_search.setString(1, numero.getText());
                    pst_search.setString(2, identifiant.getText());
                    pst_search.setString(3, nmdp.getText());
                    pst_search.setString(4, nom_doc);
                    pst_search.setString(5, prenom_doc);
                   
                    pst_search.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Enrégistrement éffectué");
                   // affichage();
                    numero.setText("");
                    identifiant.setText("");
                    mdp.setText("");
                    nmdp.setText("");
                   
                }
                else 
                {
                  JOptionPane.showMessageDialog(null,"Erreur de mot de passe \n"
                          + "Echec de modification");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Jpanel_admin_medecin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Jpanel_admin_medecin.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void identifiantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identifiantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_identifiantActionPerformed

    private void identifiantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_identifiantKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_identifiantKeyTyped

    private void ldateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ldateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ldateActionPerformed

    private void numeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE)|| c== KeyEvent.VK_DELETE))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Saisir uniquement que le numero de telephone");
        }
    }//GEN-LAST:event_numeroKeyTyped

    private void mdpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mdpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mdpActionPerformed

    private void nmdpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nmdpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nmdpActionPerformed

    public void date()
    {
    Date d = new Date();
    SimpleDateFormat dat = new SimpleDateFormat("EEEE-dd-MMM-yyyy");
    ldate.setText(dat.format(d));
    }
    
    public void affichage()
    {
          try {
            Class.forName("com.mysql.jdbc.Driver");
                 sqlConn = DriverManager.getConnection(dataConn,username,password);
                 pst = sqlConn.prepareCall("Select * from users,role,service where identifiant = ? and users.Role_id = role.rle_id and users.Service_id = service.id");
                    pst.setString(1, identifiant.getText());
                        rs = pst.executeQuery();
                            if (rs.next())
                            {
                              //    pst = sqlConn.prepareCall("Select * from users,role,service where identifiant = ? and users.Role_id = role.id and users.Service_id = service.id");
                                identifiant.setText(rs.getString("identifiant"));
                                numero.setText(rs.getString("telephone"));
                                inf_nom.setText(rs.getString("nom_users"));
                                inf_prenom.setText(rs.getString("prenom_users"));
                                inf_numero.setText(rs.getString("telephone"));
                                //inf_poste.setText(rs.getString("role_libelle"));
                              //  service.setText(rs.getString("service_libelle"));
                                
                            }
        } catch (Exception e) {
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public textfield.TextField identifiant;
    private javax.swing.JLabel inf_nom;
    private javax.swing.JLabel inf_numero;
    private javax.swing.JLabel inf_prenom;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private textfield.TextField ldate;
    public static textfield.PasswordField mdp;
    public static textfield.PasswordField nmdp;
    private textfield.TextField numero;
    private com.raven.swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
