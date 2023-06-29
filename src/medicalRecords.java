

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

public class medicalRecords extends javax.swing.JFrame {
        public medicalRecords() {
        initComponents();
        showdata();
    }
    private void showdata(){
        try {
            // Establish a database connection
            Connection conn = Config.createConnection();
            // Create a statement object
            Statement stm = conn.createStatement();
            // SQL query to retrieve data from the 'patient' table
            String sql = "SELECT * FROM patient";
            // Execute the query
            ResultSet rs = stm.executeQuery(sql);
            // Get the table model of the patienttable
            DefaultTableModel model = (DefaultTableModel) patienttable.getModel();
             // Clear existing rows in the table model
            model.setRowCount(0);
            // Iterate over the result set and add rows to the table model
            while (rs.next()) {
                String[] rowData = {
                    rs.getString("pName"),
                    rs.getString("pGender"),
                    rs.getString("pEmail"),
                    rs.getString("pPlaceofBirth"),
                    rs.getString("pDoB"),
                    rs.getString("pIdentityNum"),
                    rs.getString("p_PhoneNum"),
                    rs.getString("pAddress"),
                    rs.getString("pProfession"),
                    rs.getString("checkdate"),
                    rs.getString("serviceList"),
                    rs.getString("pConsulTime"),
                    rs.getString("pDisease"),
                    rs.getString("checkup")
                };

                model.addRow(rowData);
            }
        } catch (SQLException e) {
            // Handle any SQL errors
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }
private void updateTable() {
    // Create a new default table model
    DefaultTableModel model = new DefaultTableModel();

    try {
        // SQL query to retrieve data from the 'patient' table
        String sql = "SELECT * FROM patient";
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
            // Get the value of the "pName" column from the result set
            String pName = rs.getString("pName");


            // Add each row of data to the table model
            model.addRow(new Object[]{pName});
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
    }
}

public void showData(String patientNameFilter) {
    // Create a new default table model
        DefaultTableModel model = new DefaultTableModel();
    // Add columns to the table model
        model.addColumn("Name");
        model.addColumn("Gender");
        model.addColumn("Email");
        model.addColumn("Place of Birth");
        model.addColumn("Date of Birth");
        model.addColumn("National Identity Number");
        model.addColumn("PhoneNum");
        model.addColumn("Address");
        model.addColumn("Profession");
        model.addColumn("Check Date");
        model.addColumn("Service");
        model.addColumn("Consul Time");
        model.addColumn("Disease");
        model.addColumn("Check up");
        
    try {
        // Set up the SQL query
            int num = 1;
            String sql = "SELECT * FROM patient";
        // Add a filter for patient name if provided
            if (patientNameFilter != null && !patientNameFilter.isEmpty()) {
                sql += " WHERE pName = '" + patientNameFilter + "'";
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
                    res.getString(7),
                    res.getString(8),
                    res.getString(9),
                    res.getString(10),
                    res.getString(11),
                    res.getString(12),
                    res.getString(13),
                    res.getString(14)
                });
            
            }
        // Set the table model to the patienttable
            patienttable.setModel(model);
        } catch (SQLException e) {
        // Handle any SQL errors
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    
    }
private void showData() {
    try {
        // Establish a database connection
        Connection conn = Config.createConnection();
        Statement stm = conn.createStatement();
        // SQL query to retrieve data from the 'patient' table
        String sql = "SELECT * FROM patient";
        
        ResultSet rs = stm.executeQuery(sql);
        // Get the table model of the patienttable
        DefaultTableModel model = (DefaultTableModel) patienttable.getModel();
        // Clear existing rows in the table model
        model.setRowCount(0);
        // Iterate over the result set and add rows to the table model
        while (rs.next()) {
            String[] rowData = {
                rs.getString("pName"),
                rs.getString("pGender"),
                rs.getString("pEmail"),
                rs.getString("pPlaceofBirth"),
                rs.getString("pDoB"),
                rs.getString("pIdentityNum"),
                rs.getString("p_PhoneNum"),
                rs.getString("pAddress"),
                rs.getString("pProfession"),
                rs.getString("checkdate"),
                rs.getString("serviceList"),
                rs.getString("pConsulTime"),
                rs.getString("pDisease"),
                rs.getString("checkup")
            };

            model.addRow(rowData);
        }
    } catch (SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
        System.out.println("SQLState: " + e.getSQLState());
        System.out.println("VendorError: " + e.getErrorCode());
    }}

    public void searchData() {
    
    // Get the patient name from the input field

    String pName = patientName.getText();

    try {
        // Establish a database connection
        Connection conn = Config.createConnection();
        Statement stm = conn.createStatement();
        // SQL query to retrieve data from the 'patient' table with the specified patient name
        String sql = "SELECT * FROM patient WHERE pName='" + patientName + "'";
        // Execute the query and get the result set
        ResultSet rs = stm.executeQuery(sql);
        // Get the table model of the patienttable
        DefaultTableModel model;
        // Clear existing rows in the table model
        model = (DefaultTableModel) patienttable.getModel();
        model.setRowCount(0);
        // Iterate over the result set and add rows to the table model
        while (rs.next()) {
            String[] rowData = {
                rs.getString("pName"),
                rs.getString("pGender"),
                rs.getString("pEmail"),
                rs.getString("pPlaceofBirth"),
                rs.getString("pDoB"),
                rs.getString("pIdentityNum"),
                rs.getString("p_PhoneNum"),
                rs.getString("pAddress"),
                rs.getString("pProfession"),
                rs.getString("checkdate"),
                rs.getString("serviceList"),
                rs.getString("pConsulTime"),
                rs.getString("pDisease"),
                rs.getString("checkup")
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
        patientName = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        patienttable = new javax.swing.JTable();
        back = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        update = new javax.swing.JButton();
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
        jLabel3.setText("Medical Records");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(minimizebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(exitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(minimizebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(210, 221, 229));

        jPanel3.setBackground(new java.awt.Color(239, 239, 239));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel1.setText("Patient Name");

        patientName.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        patientName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientNameActionPerformed(evt);
            }
        });

        search.setBackground(new java.awt.Color(186, 215, 255));
        search.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        search.setText("Search");
        search.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(112, 172, 255), 2), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(186, 215, 255))); // NOI18N
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        patienttable.setBackground(new java.awt.Color(221, 221, 221));
        patienttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Gender", "Email", "Place of Birth", "Date of Birth", "Identity Number", "Phone Number", "Address", "Profession", "Check Date", "Service", "Consul Time", "Disease", "Check up"
            }
        ));
        jScrollPane1.setViewportView(patienttable);
        if (patienttable.getColumnModel().getColumnCount() > 0) {
            patienttable.getColumnModel().getColumn(5).setHeaderValue("pIdentityNum");
        }

        back.setBackground(new java.awt.Color(216, 232, 255));
        back.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        back.setText("Back");
        back.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(186, 215, 255), 2, true));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(255, 224, 255));
        delete.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        delete.setText("Delete");
        delete.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 255), 2, true));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

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

        print.setBackground(new java.awt.Color(243, 215, 215));
        print.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        print.setText("Print as PDF");
        print.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 153), 2, true));
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(202, 202, 202)
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(patientName, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(161, 161, 161)
                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(patientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(back, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        search.getAccessibleContext().setAccessibleDescription("");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 35)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/e704c7e4-d58f-4cd6-9976-ae4d8b453d1f-removebg-preview 200.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Matura MT Script Capitals", 1, 36)); // NOI18N
        jLabel4.setText("Bima Sakti Clinic");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(320, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(366, 366, 366))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(310, 310, 310))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel4)
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void patientNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientNameActionPerformed
    
   
    
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
    // Get the selected row from the patienttable
    int row = patienttable.getSelectedRow();
    if (row != -1) {
        // Get the patient name from the selected row
        String patientName = patienttable.getValueAt(row, 0).toString();
        // Show a confirmation dialog before deleting the record
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Construct the SQL query to delete the record with the specified patient name
                String sql = "DELETE FROM patient WHERE pName='" + patientName + "'";
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
 
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) patienttable.getModel();
        model.setRowCount(0);
        try {
            showdata();// Refresh the table by calling the showdata() method
            JOptionPane.showMessageDialog(null, "UPDATE DATA SUCCESSFUL");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());}
            
    }//GEN-LAST:event_updateActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
try {
            String searchName = patientName.getText();
            String sql = "SELECT * FROM patient WHERE pName = ?";
            Connection conn = Config.createConnection();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, searchName);
            ResultSet rs = pstm.executeQuery();

            DefaultTableModel model = (DefaultTableModel) patienttable.getModel();
            model.setRowCount(0);

            // Process the retrieved data
            boolean found = false;
            while (rs.next()){found = true;
                String[] rowData = {
                    rs.getString("pName"),
                    rs.getString("pGender"),
                    rs.getString("pEmail"),
                    rs.getString("pPlaceofBirth"),
                    rs.getString("pDoB"),
                    rs.getString("pIdentityNum"),
                    rs.getString("p_PhoneNum"),
                    rs.getString("pAddress"),
                    rs.getString("pProfession"),
                    rs.getString("checkdate"),
                    rs.getString("serviceList"),
                    rs.getString("pConsulTime"),
                    rs.getString("pDisease"),
                    rs.getString("checkup")
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
        this.dispose();
        AdminPanel_menu adm = new AdminPanel_menu();
        adm.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_backActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
        try{

            patienttable.print(JTable.PrintMode.FIT_WIDTH);
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
                new medicalRecords().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton delete;
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
    private javax.swing.JTextField patientName;
    private javax.swing.JTable patienttable;
    private javax.swing.JButton print;
    private javax.swing.JButton search;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables


}

