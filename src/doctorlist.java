/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Manik Kartika
 */
public class doctorlist extends javax.swing.JFrame {

        // reset/clear the edit field
        
        
        // to set and show table
        private void showdata(){
            DefaultTableModel model = new DefaultTableModel();//creates a new instance
            //adds ten columns with the specified header labels
            model.addColumn("No.");
            model.addColumn("Doctor ID");
            model.addColumn("Doctor Name");
            model.addColumn("Email");
            model.addColumn("Department");
           
            //etrieving data from a database table and populating a DefaultTableModel
            try{
                int num = 1;
                String sql = "Select * From tabel";
                java.sql.Connection conn= (Connection) Koneksi.getKoneksi();
                java.sql.PreparedStatement pstm= conn.prepareStatement(sql);
                java.sql.ResultSet res = pstm.executeQuery(sql);
                
                while (res.next()){
			model.addRow(new Object[]{num++,res.getString(1), res.getString(2),
			res.getString(3),res.getString(4)});
                        
		}
                Doctortable.setModel(model); //To set the model as the model for the tablemanagepatient
            }catch(SQLException e){ //print the exception message in detail
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
                e.printStackTrace();
            }
        }
        
        //function to get the value date from table
            
        //calls method
        public doctorlist() {
        initComponents();
        showdata();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gender = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        minimizebtn = new javax.swing.JButton();
        exitbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        scollpane = new javax.swing.JScrollPane();
        Doctortable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        leftArrow = new javax.swing.JLabel();
        print = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(210, 221, 229));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(148, 194, 229));

        minimizebtn.setBackground(new java.awt.Color(238, 255, 255));
        minimizebtn.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        minimizebtn.setText("-");
        minimizebtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(158, 255, 255), 2, true));
        minimizebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizebtnMouseClicked(evt);
            }
        });
        minimizebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizebtnActionPerformed(evt);
            }
        });

        exitbtn.setBackground(new java.awt.Color(238, 255, 255));
        exitbtn.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        exitbtn.setText("X");
        exitbtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(158, 255, 255), 2));
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        jLabel2.setText("List Doctor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(minimizebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minimizebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(210, 221, 229));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scollpane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scollpaneMouseClicked(evt);
            }
        });

        Doctortable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        Doctortable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DoctortableMouseClicked(evt);
            }
        });
        scollpane.setViewportView(Doctortable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(scollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(scollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 710, 360));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 35)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/e704c7e4-d58f-4cd6-9976-ae4d8b453d1f-removebg-preview 200.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 177, 142));

        jLabel1.setFont(new java.awt.Font("Matura MT Script Capitals", 1, 36)); // NOI18N
        jLabel1.setText("Bima Sakti Clinic");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));

        search.setBackground(new java.awt.Color(232, 232, 232));
        search.setBorder(null);
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        jPanel2.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 190, 20));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/Desain_tanpa_judul-removebg-preview.png"))); // NOI18N
        jLabel14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jLabel14KeyReleased(evt);
            }
        });
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, 67));

        leftArrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/rsz_3leftarrow-removebg-preview.png"))); // NOI18N
        leftArrow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                leftArrowMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                leftArrowMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                leftArrowMousePressed(evt);
            }
        });
        jPanel2.add(leftArrow, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        print.setBackground(new java.awt.Color(243, 215, 215));
        print.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        print.setText("Print as PDF");
        print.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 153), 2, true));
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        jPanel2.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 290, 140, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void minimizebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizebtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_minimizebtnMouseClicked

    private void minimizebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizebtnActionPerformed
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizebtnActionPerformed

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitbtnActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed
  
    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        // TODO add your handling code here:
        // searching and showing data according to the text written
        String field = search.getText().trim();

    // Removing previous rows in the table
    DefaultTableModel model = (DefaultTableModel) Doctortable.getModel();
    model.setRowCount(0);

    if (field.isEmpty()) {
        showdata(); // Show all data if the search field is empty
    } else {
        try {
            // Connect and fetch data from the database
            Connection conn = (Connection) Koneksi.getKoneksi();
            String query = "SELECT * FROM `tabel` WHERE name LIKE ? OR department LIKE ?;";
            PreparedStatement pstm = conn.prepareStatement(query);

            // Set the search parameters
            for (int i = 1; i <= 2; i++) {
                pstm.setString(i, "%" + field + "%");
            }

            ResultSet rs = pstm.executeQuery();

            // Inserting rows while the result set is not empty
            int rowNumber = 1;
            while (rs.next()) {
                Object[] rowData = new Object[5];
                rowData[0] = rowNumber++;
                rowData[1] = rs.getString(1);
                rowData[2] = rs.getString(2);
                rowData[3] = rs.getString(3);
                rowData[4] = rs.getString(4);
             
                
               
                model.addRow(rowData);
            }
        } catch (SQLException e) {//print the exception message dialog
            JOptionPane.showMessageDialog(null, "Database Error!");
            e.printStackTrace();
        }
    }

    }//GEN-LAST:event_searchKeyReleased

    private void leftArrowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftArrowMouseClicked
        // TODO add your handling code here:
        //to close current window
        this.dispose();
        //go to previous page 
        Patient_menu m = new Patient_menu();
        m.setVisible(true);
        this.setVisible(false);
   
    }//GEN-LAST:event_leftArrowMouseClicked

    private void leftArrowMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftArrowMousePressed
        // TODO add your handling code here:
         leftArrow.setBackground(new Color (93,170,229));
    }//GEN-LAST:event_leftArrowMousePressed

    private void leftArrowMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftArrowMouseEntered
        // TODO add your handling code here:
        leftArrow.setBackground(new Color (93,170,229));
    }//GEN-LAST:event_leftArrowMouseEntered

    private void scollpaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scollpaneMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_scollpaneMouseClicked

    private void DoctortableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DoctortableMouseClicked
        // TODO add your handling code here:
       

    }//GEN-LAST:event_DoctortableMouseClicked

    private void jLabel14KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel14KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14KeyReleased

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
       try{
            
            Doctortable.print(JTable.PrintMode.FIT_WIDTH);
            JOptionPane.showMessageDialog(null,"Print as PDF Successful");
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
            
        }

    }//GEN-LAST:event_printActionPerformed

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
            java.util.logging.Logger.getLogger(managepatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(managepatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(managepatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(managepatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new doctorlist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Doctortable;
    private javax.swing.JButton exitbtn;
    private javax.swing.ButtonGroup gender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel leftArrow;
    private javax.swing.JButton minimizebtn;
    private javax.swing.JButton print;
    private javax.swing.JScrollPane scollpane;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables

    private DefaultTableModel DefaultTableModel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private java.util.Date patient_dob(JTable tablemanagepatient, int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}