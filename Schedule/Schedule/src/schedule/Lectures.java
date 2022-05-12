/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package schedule;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ahmed
 */
public class Lectures extends javax.swing.JFrame {

    int counter = 0;

    DefaultListModel<String> listLeft = new DefaultListModel<>();

    /**
     * Creates new form Lectures
     */
    public Lectures() throws SQLException {
        super("Lectures");

        initComponents();

        setLocationRelativeTo(null);

        //Adding all of the lessons into listLeft that includes users department. 
        if (Db.getDepartment(Login.nameUser, Login.passUser).equals("Computer Engineering") && Db.getGrade(Login.nameUser, Login.passUser).equals("1")) {
            listLeft.addElement("Java");
            listLeft.addElement("Advanced English I");
            listLeft.addElement("Advanced English II");
            listLeft.addElement("Lineer Algebra");
            listLeft.addElement("Calculus I");
            listLeft.addElement("Calculus II");
            listLeft.addElement("Physics II");
            listLeft.addElement("Physics II");

            list_left.setModel(listLeft);
        } else if (Db.getDepartment(Login.nameUser, Login.passUser).equals("Computer Engineering") && Db.getGrade(Login.nameUser, Login.passUser).equals("2")) {
            listLeft.addElement("C");
            listLeft.addElement("C++");
            listLeft.addElement("Data Structures");

            list_left.setModel(listLeft);
        } else if (Db.getDepartment(Login.nameUser, Login.passUser).equals("Computer Engineering") && Db.getGrade(Login.nameUser, Login.passUser).equals("3")) {
            listLeft.addElement("Java");
            listLeft.addElement("Python");
            listLeft.addElement("Wifi");
            listLeft.addElement("Flutter");

            list_left.setModel(listLeft);
        } else if (Db.getDepartment(Login.nameUser, Login.passUser).equals("Computer Engineering") && Db.getGrade(Login.nameUser, Login.passUser).equals("4")) {
            listLeft.addElement("Arduino");
            listLeft.addElement("Html");
            listLeft.addElement("CSS");

            list_left.setModel(listLeft);
        } else if (Db.getDepartment(Login.nameUser, Login.passUser).equals("Doctor") && Db.getGrade(Login.nameUser, Login.passUser).equals("1")) {
            listLeft.addElement("Doctor I");

            list_left.setModel(listLeft);
        } else if (Db.getDepartment(Login.nameUser, Login.passUser).equals("Doctor") && Db.getGrade(Login.nameUser, Login.passUser).equals("2")) {
            listLeft.addElement("Doctor II");

            list_left.setModel(listLeft);
        } else if (Db.getDepartment(Login.nameUser, Login.passUser).equals("Doctor") && Db.getGrade(Login.nameUser, Login.passUser).equals("3")) {
            listLeft.addElement("Doctor III");

            list_left.setModel(listLeft);
        } else if (Db.getDepartment(Login.nameUser, Login.passUser).equals("Doctor") && Db.getGrade(Login.nameUser, Login.passUser).equals("4")) {
            listLeft.addElement("Doctor IV");

            list_left.setModel(listLeft);
        } else if (Db.getDepartment(Login.nameUser, Login.passUser).equals("Doctor") && Db.getGrade(Login.nameUser, Login.passUser).equals("5")) {
            listLeft.addElement("Doctor V");

            list_left.setModel(listLeft);
        } else if (Db.getDepartment(Login.nameUser, Login.passUser).equals("Doctor") && Db.getGrade(Login.nameUser, Login.passUser).equals("6")) {
            listLeft.addElement("Doctor VI");

            list_left.setModel(listLeft);
        } else if (Db.getDepartment(Login.nameUser, Login.passUser).equals("Economy") && Db.getGrade(Login.nameUser, Login.passUser).equals("1")) {
            listLeft.addElement("Economy I");

            list_left.setModel(listLeft);
        } else if (Db.getDepartment(Login.nameUser, Login.passUser).equals("Economy") && Db.getGrade(Login.nameUser, Login.passUser).equals("2")) {
            listLeft.addElement("Economy II");

            list_left.setModel(listLeft);
        } else if (Db.getDepartment(Login.nameUser, Login.passUser).equals("Economy") && Db.getGrade(Login.nameUser, Login.passUser).equals("3")) {
            listLeft.addElement("Economy III");

            list_left.setModel(listLeft);
        } else if (Db.getDepartment(Login.nameUser, Login.passUser).equals("Economy") && Db.getGrade(Login.nameUser, Login.passUser).equals("4")) {
            listLeft.addElement("Economy IV");

            list_left.setModel(listLeft);
        } else if (Db.getDepartment(Login.nameUser, Login.passUser).equals("Dentist") && Db.getGrade(Login.nameUser, Login.passUser).equals("1")) {
            listLeft.addElement("Dentist I");

            list_left.setModel(listLeft);
        } else if (Db.getDepartment(Login.nameUser, Login.passUser).equals("Dentist") && Db.getGrade(Login.nameUser, Login.passUser).equals("2")) {
            listLeft.addElement("Dentist II");

            list_left.setModel(listLeft);
        } else if (Db.getDepartment(Login.nameUser, Login.passUser).equals("Dentist") && Db.getGrade(Login.nameUser, Login.passUser).equals("3")) {
            listLeft.addElement("Dentist III");

            list_left.setModel(listLeft);
        } else if (Db.getDepartment(Login.nameUser, Login.passUser).equals("Dentist") && Db.getGrade(Login.nameUser, Login.passUser).equals("4")) {
            listLeft.addElement("Dentist IV");

            list_left.setModel(listLeft);
        } else if (Db.getDepartment(Login.nameUser, Login.passUser).equals("Dentist") && Db.getGrade(Login.nameUser, Login.passUser).equals("5")) {
            listLeft.addElement("Dentist V");

            list_left.setModel(listLeft);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_left = new javax.swing.JList<>();
        btn_allDone = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        list_right = new javax.swing.JList<>();
        btn_right = new javax.swing.JButton();
        btn_left = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("All Lectures");

        list_left.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(list_left);

        btn_allDone.setText("All Done");
        btn_allDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_allDoneActionPerformed(evt);
            }
        });

        list_right.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane2.setViewportView(list_right);

        btn_right.setText(">");
        btn_right.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rightActionPerformed(evt);
            }
        });

        btn_left.setText("<");
        btn_left.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_leftActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Your Lectures");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_left, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(btn_right, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(btn_allDone, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(65, 65, 65))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE))
                        .addGap(16, 16, 16)
                        .addComponent(btn_allDone))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(btn_right)
                        .addGap(131, 131, 131)
                        .addComponent(btn_left)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //User completed adding all of his lessons into his list.
    private void btn_allDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_allDoneActionPerformed

        String lessons = "";

        if (Schedule.listRight.getSize() > 0) { //Username should select at least 1 lesson.
            String text = JOptionPane.showInputDialog(rootPane, "If you're sure write (YES) below.", "Warning !", HEIGHT);
            if (text.equalsIgnoreCase("YES")) { //If user writes "yes" inside the JOptionPane.
                try {
                    for (int i = 0; i < Schedule.listRight.getSize(); i++) {
                        lessons += Schedule.listRight.get(i) + "*";
                        try {
                            //All the lessons are added into Database.
                            Db.addLesson(Login.nameUser, Login.passUser, lessons);
                        } catch (SQLException ex) {
                            Logger.getLogger(Lectures.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    Schedule schedule = new Schedule();
                    schedule.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Lectures.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Please try again. [Write (YES)]", "Warning !", JOptionPane.OK_OPTION);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "List is empty", "Warning !", HEIGHT);
        }
    }//GEN-LAST:event_btn_allDoneActionPerformed

    //Passing element in the left list into right list.
    private void btn_rightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rightActionPerformed

        if (list_left.getSelectedIndex() != -1) { //User should select a lesson.
            String value = list_left.getSelectedValue();

            int index = list_left.getSelectedIndex();

            Schedule.listRight.addElement(value);
            listLeft.remove(index);

            list_right.setModel(Schedule.listRight);
            list_left.setModel(listLeft);
        } else {
            JOptionPane.showMessageDialog(rootPane, "You should select a lesson", "Warning !", HEIGHT);
        }
    }//GEN-LAST:event_btn_rightActionPerformed

    //Passing element in the right list into left list.
    private void btn_leftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_leftActionPerformed

        if (list_right.getSelectedIndex() != -1) { //User should select a lesson.
            String value = list_right.getSelectedValue();

            int index = list_right.getSelectedIndex();

            listLeft.addElement(value);
            Schedule.listRight.remove(index);

            list_right.setModel(Schedule.listRight);
            list_left.setModel(listLeft);
        } else {
            JOptionPane.showMessageDialog(rootPane, "You should select a lesson", "Warning !", HEIGHT);
        }
    }//GEN-LAST:event_btn_leftActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_allDone;
    private javax.swing.JButton btn_left;
    private javax.swing.JButton btn_right;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> list_left;
    private javax.swing.JList<String> list_right;
    // End of variables declaration//GEN-END:variables
}
