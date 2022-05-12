/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schedule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ahmed
 */
abstract public class Db {

    static ArrayList<String> allNotesList = new ArrayList();

    static Connection conn;
    static Statement stat;
    static ResultSet rs;
    static ResultSetMetaData rsmd;

    //Creating a connection between Project and Database.
    public static void initConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheduledb", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Adding student into Database after all the requirements done.
    public static void addStudent(int age, String name, String password, String mail, String smoking, String gender, String department, String grade) throws SQLException {
        boolean exist = false;

        stat = conn.createStatement();

        String studentName = "";
        String studentPass = "";

        rs = stat.executeQuery("SELECT * from students WHERE Name = '" + name + "' AND Password ='" + password + "'"); //Selecting student from Database.

        if (rs.next()) {
            studentName = rs.getString("NAME");
            studentPass = rs.getString("PASSWORD");

            if (name.compareToIgnoreCase(studentName) == 0 && password.compareToIgnoreCase(studentPass) == 0) { //Student should be registered just once.
                exist = true;
            }
        }

        if (exist == false) { //If student is not registered, program inserts all of the informations about the student into Database.
            stat.executeUpdate("INSERT INTO students (age,name,password,mail,smoking,gender,department,grade) "
                    + "VALUES ('" + age + "', '" + name + "', '" + password + "', '" + mail + "', '" + smoking + "', '" + gender + "', '" + department + "', '" + grade + "')");

            JOptionPane.showMessageDialog(null, "You're registered !", "Congrats !", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "This person exists, do you want to try again?", "Warning !", JOptionPane.OK_OPTION);

            Register register = new Register();
            register.setVisible(true);
        }

        stat.close();
    }

    //Deleting student from Database if the all requirements are provided.
    public static void deleteStudent(String name, String password) throws SQLException {

        String studentID = "";

        stat = conn.createStatement();
        rs = stat.executeQuery("SELECT * from students WHERE Name = '" + name + "' AND Password ='" + password + "'"); //Selecting student from Database.

        if (rs.next()) {
            studentID = rs.getString("ID");
        }

        String value = JOptionPane.showInputDialog("If you sure, write your password below");

        if (value.compareTo(password) == 0) { //If the passwords are equal.
            PreparedStatement st = conn.prepareStatement("DELETE FROM students WHERE Name = '" + name + "' AND Password = '" + password + "'"); //Deleting student from students.

            st.executeUpdate();
        }

        if (value.compareTo(password) == 0) { //If the passwords are equal.
            PreparedStatement stNote = conn.prepareStatement("DELETE FROM notetable WHERE StudentID = '" + studentID + "'"); //Deleting student from notetable.

            stNote.executeUpdate();
        } else {
            JOptionPane.showMessageDialog(null, "Wrong Password !", "Warning !", JOptionPane.OK_OPTION);
        }

        stat.close();
    }

    //Selecting student form Database.
    public static boolean selectStudent(String name, String password) throws SQLException {
        boolean isTrue = false;

        stat = conn.createStatement();
        rs = stat.executeQuery("SELECT * from students WHERE Name = '" + name + "' AND Password ='" + password + "'"); //Selecting student form students.

        String studentName;
        String studentPass;

        if (rs.next()) {
            studentName = rs.getString("NAME");
            studentPass = rs.getString("PASSWORD");

            if (name.equals(studentName) && password.equals(studentPass)) { //If student exists on the Database, Both requirement should be provided.
                isTrue = true;
            }

        }

        stat.close();
        rs.close();

        return isTrue;
    }

    //Adding all of the lessons that student choosed at the Lectures Frame.
    public static void addLesson(String studentName, String password, String lessonID) throws SQLException {
        String lesson = "";

        String ids = "";

        int counter = 0;

        String arrayLessons[] = new String[6];

        for (int i = 0; i < lessonID.length(); i++) { //Splitting whole string from '*' joints.
            if (lessonID.charAt(i) != '*') {
                lesson += lessonID.charAt(i);
            } else {
                arrayLessons[counter] = lesson;
                lesson = "";
                counter++;
            }
        }

        stat = conn.createStatement();

        for (int i = 0; i < arrayLessons.length; i++) {
            if (arrayLessons[i] != null) {
                rs = stat.executeQuery("SELECT * from lessons WHERE Name ='" + arrayLessons[i] + "'"); //Getting lessons name form its ID.

                if (rs.next()) {
                    ids += rs.getString("LessonID") + " ";
                }
            }
        }

        //Updating users LessonIDS table.
        stat.executeUpdate("UPDATE students SET LessonIDS = '" + ids + "' WHERE Name = '" + studentName + "' AND Password = '" + password + "'");

        stat.close();
    }

    //Checking for the student have lessons or not.
    public static boolean hasLesson(String studentName, String password) throws SQLException {
        boolean hasLesson = false;

        String lessons;

        stat = conn.createStatement();
        rs = stat.executeQuery("SELECT * from students WHERE Name = '" + studentName + "' AND Password = '" + password + "'");

        if (rs.next()) {
            lessons = rs.getString("LessonIDS");

            if (lessons != null) {
                hasLesson = true; //If lessons are not null, hasLesson equals true.
            }
        }

        stat.close();

        return hasLesson;
    }

    //Getting students department.
    public static String getDepartment(String name, String password) throws SQLException {
        String value = "";

        stat = conn.createStatement();
        rs = stat.executeQuery("SELECT * from students WHERE Name = '" + name + "' AND Password ='" + password + "'");

        if (rs.next()) {
            value = rs.getString("Department"); //Assigning students department to the value variable.
        }

        return value;
    }

    //Getting students grade.
    public static String getGrade(String name, String password) throws SQLException {
        String value = "";

        stat = conn.createStatement();
        rs = stat.executeQuery("SELECT * from students WHERE Name = '" + name + "' AND Password ='" + password + "'");

        if (rs.next()) {
            value = rs.getString("Grade"); //Assigning students grade to the value variable.
        }

        return value;
    }

    //Reseting students password.
    public static void resetMyPassword(String name, String mail, String oldPassword, String newPassword) throws SQLException {

        stat = conn.createStatement();
        rs = stat.executeQuery("SELECT * from students WHERE Name = '" + name + "' AND Password = '" + oldPassword + "' AND Mail = '" + mail + "'");

        String studentName;
        String studentOldPassword;
        String studentMail;

        if (rs.next()) {
            studentName = rs.getString("NAME");
            studentOldPassword = rs.getString("PASSWORD");
            studentMail = rs.getString("Mail");

            if (name.compareTo(studentName) == 0 && oldPassword.compareTo(studentOldPassword) == 0 && mail.compareTo(studentMail) == 0) { //If the user exists on the Database.
                stat.executeUpdate("UPDATE students SET Password = '" + newPassword + "' WHERE Name = '" + name + "'"); //Updating password on the Database.
                updateDB("students", "Password", newPassword, "Name", name);

                JOptionPane.showMessageDialog(null, "Your password is changed", "Congrats !", JOptionPane.OK_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, "No person found !", "Warning !", JOptionPane.OK_OPTION);
            }
        }
    }

    //Showing students password on JOptionPane if all of the informations are true.
    public static void forgotMyPassword(int age, String name, String mail, String smoking, String gender, String department, String grade) throws SQLException {
        boolean isTrue = false;

        stat = conn.createStatement();
        rs = stat.executeQuery("SELECT * from students WHERE Age = '" + age + "' AND Name = '" + name + "' AND Mail = '" + mail + "' ANDSmoking = '"
                + smoking + "' AND Gender = '" + gender + "' AND Department = '" + department + "' AND Grade '" + grade + "'");

        int studentAge;
        String studentName;
        String studentSmoking;
        String studentGender;
        String studentDepartment;
        String studentMail;
        String studentGrade;

        if (rs.next()) {
            studentName = rs.getString("NAME");
            studentAge = rs.getInt("AGE");
            studentSmoking = rs.getString("SMOKING");
            studentGender = rs.getString("GENDER");
            studentDepartment = rs.getString("DEPARTMENT");
            studentMail = rs.getString("Mail");
            studentGrade = rs.getString("Grade");

            if (name.compareTo(studentName) == 0 && age == studentAge && smoking.compareTo(studentSmoking) == 0
                    && gender.compareTo(studentGender) == 0 && department.compareTo(studentDepartment) == 0
                    && mail.compareTo(studentMail) == 0 && grade.compareTo(studentGrade) == 0) { //If all of the informations are true.
                isTrue = true; //Setting isTrue = true.
            }

        }

        if (isTrue) {
            JOptionPane.showMessageDialog(null, "Your password is: " + rs.getString("PASSWORD"), "Warning !", JOptionPane.OK_OPTION);
        } else {
            JOptionPane.showMessageDialog(null, "No person found !", "Warning !", JOptionPane.OK_OPTION);
        }

        stat.close();
    }

    //Selecting lessons from array.
    public static String[] selectLessons(String name, String password) throws SQLException {

        String value = "";

        int counter = 0;

        String[] lessonIDArray = new String[6];
        String[] lessonArray = new String[6];

        stat = conn.createStatement();
        rs = stat.executeQuery("SELECT * from students WHERE Name = '" + name + "' AND Password ='" + password + "'");

        String studentName;
        String studentPass;
        String studentLessons = "";

        if (rs.next()) {
            studentName = rs.getString("NAME");
            studentPass = rs.getString("PASSWORD");

            if (name.equals(studentName) && password.equals(studentPass)) { //If the user exists on the Database.
                studentLessons = rs.getString("LESSONIDS"); //Assinging LessonIDS to the studentLessons variable.
            }

        }

        if (!studentLessons.isEmpty()) { //If studentLessons are not empty.
            for (int i = 0; i < studentLessons.length(); i++) {
                if (studentLessons.charAt(i) != ' ') { //Splitting whole string from ' ' joints.
                    value += studentLessons.charAt(i);
                } else {
                    lessonIDArray[counter] = value;
                    value = "";
                    counter++;
                }
            }
        }

        for (int i = 0; i < lessonIDArray.length; i++) {
            rs = stat.executeQuery("SELECT * from lessons WHERE LessonID = '" + lessonIDArray[i] + "'"); //Geting lessons name from lessons table on Database.

            if (rs.next()) {
                for (int j = 0; j < lessonArray.length; j++) {
                    if (lessonArray[i] == null) { //If lessonarray[i] empty.
                        lessonArray[i] = rs.getString("NAME"); //Assinging lessons name to the lessonArray[i].
                    }
                }
            }
        }

        stat.close();
        rs.close();

        return lessonArray;
    }

    //Getting table datas from Database.
    public static void getDatasFromDB(String name, String password, String selectedDay, DefaultTableModel defTable, JTable table) throws SQLException {

        int counter = 0;

        String value = "";
        String allNotesValue = "";
        String temporaryNote = "";

        String studentID = "";
        String lessonID = "";
        String lessonName = "";

        stat = conn.createStatement();
        rs = stat.executeQuery("SELECT * from students WHERE Name = '" + name + "' AND Password ='" + password + "'");

        if (rs.next()) {
            studentID = rs.getString("ID");
            lessonID = rs.getString("LESSONIDS");
        }

        String[] listLessonNames = new String[defTable.getColumnCount()]; //Creating an array for the lesson names.

        for (int i = 0; i < lessonID.length(); i++) {
            if (lessonID.charAt(i) != ' ') { //Splitting whole string from ' ' joints.
                value += lessonID.charAt(i);
            } else {
                rs = stat.executeQuery("SELECT * from lessons WHERE LessonID = '" + value + "'");

                if (rs.next()) {
                    lessonName = rs.getString("Name"); //Getting lesson names from IDS on the lessons table..
                }

                for (int j = 0; j < listLessonNames.length; j++) {
                    if (listLessonNames[j] == null) { //If listLessonNames[j] empty.
                        listLessonNames[j] = lessonName; //Adding lessonName into listLessonNames list.
                        break;
                    }
                }

                lessonName = "";
                value = "";
            }
        }

        for (int h = 0; h < defTable.getColumnCount(); h++) {

            rs = stat.executeQuery("SELECT * from notetable WHERE StudentID = '" + studentID + "' AND Day = '" + selectedDay + "' AND LessonName = '" + listLessonNames[h] + "'");

            if (rs.next()) {
                temporaryNote = rs.getString("Notes"); //Getting all of the notes from notetable where the lessonNames are equal to ColumnTitle.
            }

            while (counter < defTable.getRowCount()) {
                for (int k = 0; k < temporaryNote.length(); k++) {
                    if (temporaryNote.charAt(k) != '*') { //Splitting whole string from '*' joints.
                        allNotesValue += temporaryNote.charAt(k);
                    } else {
                        if (!allNotesValue.equals("null")) { //If allNotesValue variable is not empty.
                            defTable.setValueAt(allNotesValue, counter, h); //Setting value at counter row and h column to allNotesValue.
                            counter++;
                            allNotesValue = "";
                        } else {
                            defTable.setValueAt("", counter, h);
                            counter++;
                            allNotesValue = "";
                        }
                    }
                }
            }
            counter = 0;
        }

        table.setModel(defTable);

        stat.close();
    }

    //Setting table datas from Schedule table.
    public static void addDatasIntoDB(String name, String password, String selectedDay, DefaultTableModel table) throws SQLException {

        String value = "";

        String studentID = "";
        String lessonID = "";
        String lessonName = "";

        String notetableStudent = "";
        String notetableLesson = "";
        String notetableDay = "";

        String notes = "";

        stat = conn.createStatement();
        rs = stat.executeQuery("SELECT * from students WHERE Name = '" + name + "' AND Password ='" + password + "'");

        if (rs.next()) {
            studentID = rs.getString("ID");
            lessonID = rs.getString("LESSONIDS");
        }

        for (int i = 0; i < lessonID.length(); i++) {
            if (lessonID.charAt(i) != ' ') { //Splitting whole string from ' ' joints.
                value += lessonID.charAt(i);
            } else {
                rs = stat.executeQuery("SELECT * from lessons WHERE LessonID = '" + value + "'");

                if (rs.next()) {
                    lessonName = rs.getString("Name");
                }

                for (int j = 0; j < table.getColumnCount(); j++) {

                    if (table.getColumnName(j).compareTo(lessonName) == 0) { //If Column Title and Lesosn Name equals to each other.
                        for (int k = 0; k < table.getRowCount(); k++) {
                            notes += table.getValueAt(k, j) + "*"; //Adding '*' between all of the table elements and assigning it to notes variable.
                        }

                        rs = stat.executeQuery("SELECT * from notetable WHERE StudentID = '" + studentID + "' AND LessonName = '" + lessonName + "'"
                                + "AND Day = '" + selectedDay + "'");

                        if (rs.next()) {
                            notetableStudent = rs.getString("StudentID");
                            notetableLesson = rs.getString("LessonName");
                            notetableDay = rs.getString("Day");
                        }

                        if (notetableStudent.isEmpty() && notetableLesson.isEmpty() && notetableDay.isEmpty()) { //If the user didnt enter something into Database.
                            //Inserting datas into Database.
                            stat.executeUpdate("INSERT INTO notetable (StudentID, Day, LessonName, Notes) "
                                    + "VALUES ('" + studentID + "', '" + selectedDay + "', '" + lessonName + "', '" + notes + "')");
                        } else {
                            //Updating datas on Database.
                            stat.executeUpdate("UPDATE notetable SET Notes = '" + notes + "' WHERE StudentID = '" + studentID + "' AND LessonName = '" + lessonName + "' AND Day = '" + selectedDay + "'");
                        }

                        notes = "";
                    }

                }

                value = "";
                lessonName = "";
            }
        }

        stat.close();
    }

    //Updating Database.
    public static <T, K> void updateDB(String tableName, String columnName, T value, String conditionName, K conditionValue) throws SQLException {
        stat = conn.createStatement();

        stat.executeUpdate("UPDATE " + tableName + " SET " + columnName + " = '" + value + "' WHERE " + conditionName + " = '" + conditionValue + "'"); //Updating this row.

        stat.close();
    }

}
