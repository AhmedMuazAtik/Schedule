/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package schedule;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ahmed
 */
public class Schedule extends javax.swing.JFrame {

    static DefaultListModel<String> listRight = new DefaultListModel<>();

    DefaultListModel<String> defListWeeks = new DefaultListModel<>();

    DefaultTableModel listTableMonday = new DefaultTableModel();
    DefaultTableModel listTableTuesday = new DefaultTableModel();
    DefaultTableModel listTableWednesday = new DefaultTableModel();
    DefaultTableModel listTableThursday = new DefaultTableModel();
    DefaultTableModel listTableFriday = new DefaultTableModel();
    DefaultTableModel listTableSaturday = new DefaultTableModel();
    DefaultTableModel listTableSunday = new DefaultTableModel();

    JTable tMonday = new JTable();
    JTable tTuesday = new JTable();
    JTable tWednesday = new JTable();
    JTable tThursday = new JTable();
    JTable tFriday = new JTable();
    JTable tSaturday = new JTable();
    JTable tSunday = new JTable();

    JPanel pMonday = new JPanel();
    JPanel pTuesday = new JPanel();
    JPanel pWednesday = new JPanel();
    JPanel pThursday = new JPanel();
    JPanel pFriday = new JPanel();
    JPanel pSaturday = new JPanel();
    JPanel pSunday = new JPanel();

    ArrayList<Object> tableList = new ArrayList();

    /**
     * Creates new form Schedule
     *
     * @throws java.sql.SQLException
     */
    public Schedule() throws SQLException {
        super("Schedule");

        initComponents();

        setLocationRelativeTo(null);

        lb_username.setText("Welcome, " + Login.nameUser);

        pMonday.setName("Monday");
        pTuesday.setName("Tuesday");
        pWednesday.setName("Wednesday");
        pThursday.setName("Thursday");
        pFriday.setName("Friday");
        pSaturday.setName("Saturday");
        pSunday.setName("Sunday");

        pMonday.add(new JScrollPane(tMonday));
        pTuesday.add(new JScrollPane(tTuesday));
        pWednesday.add(new JScrollPane(tWednesday));
        pThursday.add(new JScrollPane(tThursday));
        pFriday.add(new JScrollPane(tFriday));
        pSaturday.add(new JScrollPane(tSaturday));
        pSunday.add(new JScrollPane(tSunday));
        
        pMonday.setBackground(Color.black);
        pTuesday.setBackground(Color.black);
        pWednesday.setBackground(Color.black);
        pThursday.setBackground(Color.black);
        pFriday.setBackground(Color.black);
        pSaturday.setBackground(Color.black);
        pSunday.setBackground(Color.black);

        tp_days.add(pMonday);
        tp_days.add(pTuesday);
        tp_days.add(pWednesday);
        tp_days.add(pThursday);
        tp_days.add(pFriday);
        tp_days.add(pSaturday);
        tp_days.add(pSunday);

        String[] lessonNames = Db.selectLessons(Login.nameUser, Login.passUser);

        int counter = 0;

        //Counting all lessons inside the lessonNames.
        for (int i = 0; i < lessonNames.length; i++) {
            if (lessonNames[i] != null) {
                counter++;
            }
        }

        //Adding all of the lessons into all tables.
        for (int i = 0; i < counter; i++) {
            listTableMonday.addColumn(lessonNames[i]);
            listTableTuesday.addColumn(lessonNames[i]);
            listTableWednesday.addColumn(lessonNames[i]);
            listTableThursday.addColumn(lessonNames[i]);
            listTableFriday.addColumn(lessonNames[i]);
            listTableSaturday.addColumn(lessonNames[i]);
            listTableSunday.addColumn(lessonNames[i]);
        }

        String[] rowData = {};

        //Adding empty string into all tables.
        for (int i = 1; i <= 10; i++) {
            listTableMonday.addRow(rowData);
            listTableTuesday.addRow(rowData);
            listTableWednesday.addRow(rowData);
            listTableThursday.addRow(rowData);
            listTableFriday.addRow(rowData);
            listTableSaturday.addRow(rowData);
            listTableSunday.addRow(rowData);
        }

        tMonday.setModel(listTableMonday);
        tTuesday.setModel(listTableTuesday);
        tWednesday.setModel(listTableWednesday);
        tThursday.setModel(listTableThursday);
        tFriday.setModel(listTableFriday);
        tSaturday.setModel(listTableSaturday);
        tSunday.setModel(listTableSunday);
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
        lb_username = new javax.swing.JLabel();
        btn_deleteaccount = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        tp_days = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });

        lb_username.setFont(new java.awt.Font("Linux Libertine G", 1, 18)); // NOI18N

        btn_deleteaccount.setText("Delete Account");
        btn_deleteaccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteaccountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tp_days.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_username, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_deleteaccount, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(tp_days, javax.swing.GroupLayout.PREFERRED_SIZE, 929, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_deleteaccount, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tp_days, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseReleased

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    //User deletes his account.
    private void btn_deleteaccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteaccountActionPerformed
        try {
            //Deleting student from Database.
            Db.deleteStudent(Login.nameUser, Login.passUser);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_deleteaccountActionPerformed

    //Saving all of the table elements when user closes program.
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        try {
            //Adding all of the table elements into Database.
            Db.addDatasIntoDB(Login.nameUser, Login.passUser, tp_days.getTitleAt(0), listTableMonday);
            Db.addDatasIntoDB(Login.nameUser, Login.passUser, tp_days.getTitleAt(1), listTableTuesday);
            Db.addDatasIntoDB(Login.nameUser, Login.passUser, tp_days.getTitleAt(2), listTableWednesday);
            Db.addDatasIntoDB(Login.nameUser, Login.passUser, tp_days.getTitleAt(3), listTableThursday);
            Db.addDatasIntoDB(Login.nameUser, Login.passUser, tp_days.getTitleAt(4), listTableFriday);
            Db.addDatasIntoDB(Login.nameUser, Login.passUser, tp_days.getTitleAt(5), listTableSaturday);
            Db.addDatasIntoDB(Login.nameUser, Login.passUser, tp_days.getTitleAt(6), listTableSunday);
        } catch (SQLException ex) {
            Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_deleteaccount;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lb_username;
    public javax.swing.JTabbedPane tp_days;
    // End of variables declaration//GEN-END:variables
}
