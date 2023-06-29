
//libraries that we use
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.jar.Attributes.Name;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class listDoctor extends javax.swing.JFrame {
        public listDoctor() {
        initComponents();
        showdata();
    }
        
        
    private void showdata(){
        try {
            // Establish a database connection
            Connection conn = Config.createConnection();
            // Create a statement object
            Statement stm = conn.createStatement();
            // SQL query to retrieve data from the 'tabel' table
            String sql = "SELECT * FROM tabel";
            // Execute the query
            ResultSet rs = stm.executeQuery(sql);
            // Get the table model of the Doctortable
            DefaultTableModel model = (DefaultTableModel) Doctortable.getModel();
             // Clear existing rows in the table model
            model.setRowCount(0);
            // Iterate over the result set and add rows to the table model
            while (rs.next()) {
                String[] rowData = {
                    rs.getString("ID"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("department"),
                    rs.getString("address"),
                    rs.getString("natid"),
                    rs.getString("phonum"),
                };

                model.addRow(rowData);
            }
        } catch (SQLException e) {
            // Handle any SQL errors
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            e.printStackTrace();
        }
    }
private void updateTable() {
    // Create a new default table model
    DefaultTableModel model = new DefaultTableModel();

    try {
        // SQL query to retrieve data from the 'tabel' table
        String sql = "SELECT * FROM tabel";
        // Establish a database connection
        java.sql.Connection conn = (Connection) Config.createConnection();
        // Prepare the SQL statement
        java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
        // Execute the query and get the result set
        java.sql.ResultSet rs = pstm.executeQuery();

        // Clear the existing data in the table
        model.setRowCount(0);

        // Process the retrieved data
        while (rs.next()) {
            // Get the value of the "department" column from the result set
            String dpart = rs.getString("department");


            // Add each row of data to the table model
            model.addRow(new Object[]{dpart});
        }

        // Close the resources
        rs.close();
        pstm.close();
        conn.close();
    } catch (SQLException e) {
        // Display an error message if a database error occurs
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
        // Call the updateTable() method recursively to retry updating the table
        updateTable();
        e.printStackTrace();
    }
}

public void showData(String patientdpartFilter) {
    // Create a new default table model
        DefaultTableModel model = new DefaultTableModel();
    // Add columns to the table model
        model.addColumn("ID");
        model.addColumn("Doctor Name");
        model.addColumn("Email");
        model.addColumn("Department");
        model.addColumn("Address");
        model.addColumn("National Identity Num");
        model.addColumn("Phone Number");
        
    try {
        // Set up the SQL query
            int num = 1;
            String sql = "SELECT * FROM tabel";
        // Add a filter for doctor department if provided
            if (patientdpartFilter != null && !patientdpartFilter.isEmpty()) {
                sql += " WHERE department = '" + patientdpartFilter + "'";
            }
        // Establish a database connection
            Connection conn = Config.createConnection();
            Statement stm = conn.createStatement();
        // Execute the query and get the result set
            ResultSet res = stm.executeQuery(sql);
        // Process the retrieved data and add rows to the table model
            while (res.next()) {
                model.addRow(new Object[]{
                    res.getString(1), 
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6),
                    res.getString(7)
                });
            
            }
        // Set the table model to the Doctortable
            Doctortable.setModel(model);
        } catch (SQLException e) {
        // Handle any SQL errors
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            e.printStackTrace();
        }
    
    }
private void showData() {
    try {
        // Establish a database connection
        Connection conn = Config.createConnection();
        Statement stm = conn.createStatement();
        // SQL query to retrieve data from the 'tabel' table
        String sql = "SELECT * FROM tabel";
        
        ResultSet rs = stm.executeQuery(sql);
        // Get the table model of the Doctortable
        DefaultTableModel model = (DefaultTableModel) Doctortable.getModel();
        // Clear existing rows in the table model
        model.setRowCount(0);
        // Iterate over the result set and add rows to the table model
        while (rs.next()) {
            String[] rowData = {
                    rs.getString("ID"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("department"),
                    rs.getString("address"),
                    rs.getString("natid"),
                    rs.getString("phonum"),
            };

            model.addRow(rowData);
            
        }
    } catch (SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
        System.out.println("SQLState: " + e.getSQLState());
        System.out.println("VendorError: " + e.getErrorCode());
        e.printStackTrace();
    }}

    public void searchData() {
    
    // Get the patient name from the input field

    String dpart = doctorDpart.getText();

    try {
        // Establish a database connection
        Connection conn = Config.createConnection();
        Statement stm = conn.createStatement();
        // SQL query to retrieve data from the 'tabel' table with the specified Doctor dpart
        String sql = "SELECT * FROM tabel WHERE department='" + doctorDpart + "'";
        // Execute the query and get the result set
        ResultSet rs = stm.executeQuery(sql);
        // Get the table model of the tabeltable
        DefaultTableModel model;
        // Clear existing rows in the table model
        model = (DefaultTableModel) Doctortable.getModel();
        model.setRowCount(0);
        // Iterate over the result set and add rows to the table model
        while (rs.next()) {
            String[] rowData = {
                    rs.getString("ID"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("department"),
                    rs.getString("address"),
                    rs.getString("natid"),
                    rs.getString("phonum"),
            };

            model.addRow(rowData);
        }
        // Display a message if no records were found
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No records found", "Search Result", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException e) {
        // Handle any SQL errors
        System.out.println("SQLException: " + e.getMessage());
        System.out.println("SQLState: " + e.getSQLState());
        System.out.println("VendorError: " + e.getErrorCode());
    }
}


    


    /**
     * Creates new form medicalRecord
     */
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        exitbtn = new javax.swing.JButton();
        minimizebtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        doctorDpart = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Doctortable = new javax.swing.JTable();
        back = new javax.swing.JButton();
        addDoctor = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        print = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(148, 194, 229));

        exitbtn.setBackground(new java.awt.Color(238, 255, 255));
        exitbtn.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        exitbtn.setText("X");
        exitbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 188, 229), 2, true));
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });

        minimizebtn.setBackground(new java.awt.Color(238, 255, 255));
        minimizebtn.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        minimizebtn.setText("-");
        minimizebtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 188, 229), 2, true));
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

        jLabel3.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        jLabel3.setText("List Doctor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 721, Short.MAX_VALUE)
                .addComponent(minimizebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(exitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(exitbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(minimizebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(210, 221, 229));

        jPanel3.setBackground(new java.awt.Color(239, 239, 239));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel1.setText("Doctor Name");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 29, -1, 28));

        doctorDpart.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        doctorDpart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorDpartActionPerformed(evt);
            }
        });
        jPanel3.add(doctorDpart, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 29, 211, -1));

        search.setBackground(new java.awt.Color(186, 215, 255));
        search.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        search.setText("Search");
        search.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(112, 172, 255), 2), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(186, 215, 255))); // NOI18N
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel3.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 30, 71, 27));
        search.getAccessibleContext().setAccessibleDescription("");

        Doctortable.setBackground(new java.awt.Color(221, 221, 221));
        Doctortable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Doctor ID", "Doctor Name", "Email", "Department", "Address", "Nationality ID Number", "Phone Number"
            }
        ));
        jScrollPane1.setViewportView(Doctortable);
        if (Doctortable.getColumnModel().getColumnCount() > 0) {
            Doctortable.getColumnModel().getColumn(5).setHeaderValue("pIdentityNum");
        }

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 75, 816, 275));

        back.setBackground(new java.awt.Color(216, 232, 255));
        back.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        back.setText("Back");
        back.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(186, 215, 255), 2, true));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel3.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 376, 74, 40));

        addDoctor.setBackground(new java.awt.Color(204, 255, 255));
        addDoctor.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        addDoctor.setText("Add Doctor");
        addDoctor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 255, 255), 2, true));
        addDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDoctorActionPerformed(evt);
            }
        });
        jPanel3.add(addDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 130, 40));

        update.setBackground(new java.awt.Color(255, 206, 206));
        update.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        update.setText("Update");
        update.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 183, 183), 2, true));
        update.setPreferredSize(new java.awt.Dimension(57, 25));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel3.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 380, 85, 39));

        delete.setBackground(new java.awt.Color(255, 224, 255));
        delete.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        delete.setText("Delete");
        delete.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 255), 2, true));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel3.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 380, 79, 40));

        print.setBackground(new java.awt.Color(193, 213, 231));
        print.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        print.setText("Print as PDF");
        print.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(122, 179, 231), 2, true));
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        jPanel3.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 380, 140, 40));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 35)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/e704c7e4-d58f-4cd6-9976-ae4d8b453d1f-removebg-preview 200.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Matura MT Script Capitals", 1, 36)); // NOI18N
        jLabel4.setText("Bima Sakti Clinic");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(366, 366, 366))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(301, 301, 301))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 883, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel4)
                .addGap(34, 34, 34)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void doctorDpartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorDpartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doctorDpartActionPerformed
    
   
    
    private void addDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDoctorActionPerformed
    // TODO add your handling code here:
    //to direct the Admin to add doctor page when admin click this button
        this.dispose();
        addDoctor add = new addDoctor();
        add.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_addDoctorActionPerformed
 
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) Doctortable.getModel();
        model.setRowCount(0);
        try {
            showdata();// Refresh the table by calling the showdata() method
            JOptionPane.showMessageDialog(null, "UPDATE DATA SUCCESSFUL");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());}
            
    }//GEN-LAST:event_updateActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
try {
            //used to store the value of the text entered in the doctorDpart field,
                //which is presumably the department name to search for.
            String searchDPT = doctorDpart.getText(); 
            
            //is prepared, with a placeholder ? used for parameter binding.
            String sql = "SELECT * FROM tabel WHERE department = ?";
            
            //method is called to establish a database connection.
            //A prepared statement pstm is created using the connection and the SQL query.
            Connection conn = Config.createConnection();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, searchDPT);//is set as a parameter for the prepared statement
            
            //method is called on the prepared statement pstm to execute the SQL query and retrieve the result set.
            ResultSet rs = pstm.executeQuery();
            
            //This assumes that Doctortable is a JTable component, and its model is of type DefaultTableModel.
            DefaultTableModel model = (DefaultTableModel) Doctortable.getModel();
            model.setRowCount(0);// This method sets the number of rows in the table model to zero,
            //effectively clearing all existing rows in the table.

            // Process the retrieved data
            boolean found = false;
            while (rs.next()){found = true;
                String[] rowData = {
                    rs.getString("ID"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("department"),
                    rs.getString("address"),
                    rs.getString("natid"),
                    rs.getString("phonum"),
                };

                model.addRow(rowData);
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "No record found for the given name", "Not Found", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    
    }//GEN-LAST:event_searchActionPerformed

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
        // TODO add your handling code here:
    // Exit the application
        System.exit(0);
    }//GEN-LAST:event_exitbtnActionPerformed

    private void minimizebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizebtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_minimizebtnMouseClicked

    private void minimizebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizebtnActionPerformed
        // TODO add your handling code here:
        // Minimize the JFrame window
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizebtnActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        
        //direct go back to Admin Panel menu if we click the button
        this.dispose();
        AdminPanel_menu adm = new AdminPanel_menu();
        adm.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_backActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        
        // Get the selected row from the Doctortable
    int row = Doctortable.getSelectedRow();
    if (row != -1) {
        // Get the doctor id from the selected row
        String id = Doctortable.getValueAt(row, 0).toString();
        // Show a confirmation dialog before deleting the record
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Construct the SQL query to delete the record with the specified Doctor id
                String sql = "DELETE FROM tabel WHERE ID='" + id + "'";
                Connection conn = Config.createConnection();
                Statement stm = conn.createStatement();
                // Execute the delete query
                int delete = stm.executeUpdate(sql);
                if (delete > 0) {
                    JOptionPane.showMessageDialog(this, "Record deleted successfully");
                    showData();// Refresh the table after deletion
                }
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a record to delete", "Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_deleteActionPerformed

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
     try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.err.println(ex);
               
    }
             // Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listDoctor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Doctortable;
    private javax.swing.JButton addDoctor;
    private javax.swing.JButton back;
    private javax.swing.JButton delete;
    private javax.swing.JTextField doctorDpart;
    private javax.swing.JButton exitbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton minimizebtn;
    private javax.swing.JButton print;
    private javax.swing.JButton search;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables


}

