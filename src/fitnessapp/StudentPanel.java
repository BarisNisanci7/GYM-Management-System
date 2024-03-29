/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fitnessapp;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Deder
 */
public class StudentPanel extends javax.swing.JFrame {

    /**
     * Creates new form StudentPanel
     */
    public StudentPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        allStudentButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        trainerNameForStudents = new javax.swing.JTextField();
        getStudentsWithTrainerName = new javax.swing.JButton();
        setTrainerForStudent = new javax.swing.JButton();
        setProgramForStudent = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        addStudentButton = new javax.swing.JButton();
        deleteStudentButton = new javax.swing.JButton();
        deleteStudentField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Students");

        allStudentButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        allStudentButton.setText("All Students");
        allStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allStudentButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Surname", "Birth Date", "Membership (Month)", "Gender", "Trainer", "Program"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Enter A Trainer");

        getStudentsWithTrainerName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getStudentsWithTrainerName.setText("Get Students");
        getStudentsWithTrainerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getStudentsWithTrainerNameActionPerformed(evt);
            }
        });

        setTrainerForStudent.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        setTrainerForStudent.setText("Set Trainer");
        setTrainerForStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setTrainerForStudentActionPerformed(evt);
            }
        });

        setProgramForStudent.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        setProgramForStudent.setText("Set Program");
        setProgramForStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setProgramForStudentActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        addStudentButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addStudentButton.setText("Add Student");
        addStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentButtonActionPerformed(evt);
            }
        });

        deleteStudentButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        deleteStudentButton.setText("Delete Student");
        deleteStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteStudentButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Student Name For Delete");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addGap(419, 419, 419)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(trainerNameForStudents)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel2))
                                    .addComponent(getStudentsWithTrainerName, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(allStudentButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(setTrainerForStudent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(setProgramForStudent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deleteStudentField, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(addStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 18, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 862, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(deleteStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(backButton))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(allStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(trainerNameForStudents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(getStudentsWithTrainerName)
                        .addGap(36, 36, 36)
                        .addComponent(addStudentButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(setTrainerForStudent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(setProgramForStudent))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteStudentField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteStudentButton))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void allStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allStudentButtonActionPerformed
        
        DatabaseConnection database = new DatabaseConnection();
        database.DataBaseConnection();
    
        List<Student> students = database.getStudentsWithTrainerNames();
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        for (Student student : students) {
            Object[] row = {student.getStudentName(), student.getStudentSurname(),
                            student.getBirthDate(), student.getStudentMembership(), student.getStudentGender(), database.getTrainerNameByTrainerID(student.getTrainerID()), database.getProgramNameByProgramID(student.getProgramID())};
            model.addRow(row);
        }
    }//GEN-LAST:event_allStudentButtonActionPerformed

    private void getStudentsWithTrainerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getStudentsWithTrainerNameActionPerformed
        
        DatabaseConnection database = new DatabaseConnection();
        database.DataBaseConnection();
    
        List<Student> students = database.getStudentsByTrainerName(trainerNameForStudents.getText());
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        for (Student student : students) {
            Object[] row = {student.getStudentID(), student.getStudentName(), student.getStudentSurname(),
                            student.getBirthDate(), student.getStudentMembership(), student.getStudentGender(), database.getTrainerNameByTrainerID(student.getTrainerID()), student.getProgramID()};
            model.addRow(row);
        }
    }//GEN-LAST:event_getStudentsWithTrainerNameActionPerformed

    private void setProgramForStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setProgramForStudentActionPerformed
        SetProgramPanel setProgram = new SetProgramPanel();
        setProgram.setVisible(true);
    }//GEN-LAST:event_setProgramForStudentActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        AdminControlPanel controlPanel = new AdminControlPanel();
        controlPanel.setVisible(true);
        dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void setTrainerForStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setTrainerForStudentActionPerformed
        SetTrainerPanel setTrainer = new SetTrainerPanel();
        setTrainer.setVisible(true);
    }//GEN-LAST:event_setTrainerForStudentActionPerformed

    private void addStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentButtonActionPerformed
        AddStudentPanel studentPanel = new AddStudentPanel();
        studentPanel.setVisible(true);
    }//GEN-LAST:event_addStudentButtonActionPerformed

    private void deleteStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteStudentButtonActionPerformed
        DatabaseConnection database = new DatabaseConnection();
        database.DataBaseConnection();
        
        database.deleteStudentByName(deleteStudentField.getText());
        JOptionPane.showMessageDialog(null, "Student Succesfully Deleted");
    }//GEN-LAST:event_deleteStudentButtonActionPerformed

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
            java.util.logging.Logger.getLogger(StudentPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addStudentButton;
    private javax.swing.JButton allStudentButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton deleteStudentButton;
    private javax.swing.JTextField deleteStudentField;
    private javax.swing.JButton getStudentsWithTrainerName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton setProgramForStudent;
    private javax.swing.JButton setTrainerForStudent;
    private javax.swing.JTextField trainerNameForStudents;
    // End of variables declaration//GEN-END:variables
}
