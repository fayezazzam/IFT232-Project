/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courses;

import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author Fayez
 */
public class Course extends javax.swing.JDialog {
    private Connection con;
    private  int courseid;
    /**
     * Creates new form Course
     */
    public Course(java.awt.Frame parent, boolean modal, Connection con, int courseid) {
        super(parent, modal);
        initComponents();
        this.setTitle("Course");
        this.setLocationRelativeTo(this);
        this.con = con;
        this.courseid= courseid;
        cbxNbofCredits.setSelectedItem("3");
        rbMajor.setSelected(true);
        chkLab.setSelected(false);
        populate();
    }
    
     
    private void populate() {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs
                    = stmt.executeQuery("Select * "
                            + "From tbl_courses Where course_id = " + courseid);
            if (rs.next()) {  
                txtCode.setText(rs.getString("course_code"));
                txtName.setText(rs.getString("course_name"));
                if(rs.getString("type").equals("Major")){
                    rbMajor.setSelected(true);
                }else{
                    rbElective.setSelected(false);
                }
                if(rs.getString("lab").equals("Yes")){
                    chkLab.setSelected(true);
                }else{
                    chkLab.setSelected(false);
                }
                cbxNbofCredits.setSelectedItem(rs.getString("nb_of_credits"));
                txtDescription.setText(rs.getString("description"));
            }
        }
            catch (SQLException ex) {
            System.err.println(ex.getMessage());
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblCode = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        txtCode = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        lblNofCredits = new javax.swing.JLabel();
        cbxNbofCredits = new javax.swing.JComboBox();
        lblType = new javax.swing.JLabel();
        lblLab = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        rbMajor = new javax.swing.JRadioButton();
        rbElective = new javax.swing.JRadioButton();
        chkLab = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblCode.setText("Course Code");

        lblName.setText("Course Name");

        lblDescription.setText("Description");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        txtCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodeActionPerformed(evt);
            }
        });

        lblNofCredits.setText("Nb of Credits");

        cbxNbofCredits.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3" }));
        cbxNbofCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNbofCreditsActionPerformed(evt);
            }
        });

        lblType.setText("Type");

        lblLab.setText("Lab");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbMajor);
        rbMajor.setText("Major");

        buttonGroup1.add(rbElective);
        rbElective.setText("Elective");

        chkLab.setText("Lab");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblLab)
                        .addGap(18, 18, 18)
                        .addComponent(chkLab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCode)
                                    .addComponent(lblName)
                                    .addComponent(lblDescription))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCode, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(txtName)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNofCredits)
                                .addGap(26, 26, 26)
                                .addComponent(cbxNbofCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblType)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbMajor)
                                .addGap(12, 12, 12)
                                .addComponent(rbElective)))
                        .addGap(0, 198, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCode)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNofCredits)
                    .addComponent(cbxNbofCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblType)
                    .addComponent(rbMajor)
                    .addComponent(rbElective))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(lblLab)
                    .addComponent(chkLab))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
         if (txtCode.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Enter a Course_Code", "Warning",
                    JOptionPane.WARNING_MESSAGE);
        } else if (txtName.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Enter a Course_Name", "Warning",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            String Code = txtCode.getText();
            String Name = txtName.getText();
            String Description = txtDescription.getText();
            int nbofcredits
                    = Integer.parseInt(
                            cbxNbofCredits.
                            getSelectedItem().toString());
            String Lab;
            if (chkLab.isSelected()) {
                Lab = "Yes";
            } else {
                Lab = "No";
            }
               
            String Type;
            if (rbMajor.isSelected()) {
                Type = "Major";
            } else {
                Type = "Elective";
            }
            try {
                PreparedStatement pstmt;
                if(courseid==0){
                       pstmt = con.prepareStatement("Insert Into "
                                + "tbl_courses (course_code,"
                                + "course_name,description,"
                                + "type, nb_of_credits,"
                                + "lab)"
                                + "Values ( '" + Code + "',"
                                + "'" + Name + "' ,'" + Description +"','"
                                + Type+ "',"+ nbofcredits + ", '" 
                                + Lab  + "')");
                }else{
                    pstmt = con.prepareStatement("Update tbl_courses "
                            + "Set course_code = '" + Code + "',"
                            + "course_name = '" + Name + "',"
                            + "description = '" + Description + "',"
                            + "type = '" + Type + "',"
                            + "nb_of_credits = " + nbofcredits + ","
                            + "lab = '" + Lab + "'"
                            + "Where course_id = " + courseid);
                }
                pstmt.execute();
                this.dispose();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cbxNbofCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNbofCreditsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxNbofCreditsActionPerformed

    private void txtCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodeActionPerformed

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
            java.util.logging.Logger.getLogger(Course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Course dialog = new Course(new javax.swing.JFrame(), true,null,0);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbxNbofCredits;
    private javax.swing.JCheckBox chkLab;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblLab;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNofCredits;
    private javax.swing.JLabel lblType;
    private javax.swing.JRadioButton rbElective;
    private javax.swing.JRadioButton rbMajor;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
