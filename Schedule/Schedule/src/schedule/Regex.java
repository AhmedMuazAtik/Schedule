
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schedule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author ahmed
 */
public class Regex {

    static Pattern patternUsername = Pattern.compile("[A-Z]+[\\w]+"); //Username should be like this sample "Ahmed"
    static Pattern patternPassword = Pattern.compile("[\\w]+"); //Password should be like this sample "ahmet123"
    static Pattern patternMail = Pattern.compile("[\\w]+(@)[a-z]{1,3}(mail)(\\.)[a-z]{2,3}"); //Mail should be like this sample "Ahmed@hotmail.com"

    static Matcher matcherUsername;
    static Matcher matcherPassword;
    static Matcher matcherMail;

    //Checking the username if its validate.
    public static boolean validateLoginUsername(String username) {

        matcherUsername = patternUsername.matcher(username); //Username should be equal to pattern.

        if (matcherUsername.matches()) { //If username equals to pattern.
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Your username is not validate. First letter should be capital.", "REGEX !", JOptionPane.OK_OPTION);
            return false;
        }
    }

    //Checking the password if its validate.
    public static boolean validateLoginPassword(String password) {

        matcherPassword = patternPassword.matcher(password); //Password should be equal to pattern.

        if (matcherPassword.matches()) { //If password equals to pattern.
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Your password is not validate. Dont use special characters [$^&#?_].", "REGEX !", JOptionPane.OK_OPTION);
            return false;
        }
    }

    //Checking the username if its validate.
    public static boolean validateRegisterUsername(String username) {

        matcherUsername = patternUsername.matcher(username); //Username should be equal to pattern.

        if (matcherUsername.matches()) { //If username equals to pattern.
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Your username is not validate. First letter should be capital.", "REGEX !", JOptionPane.OK_OPTION);
            return false;
        }
    }

    //Checking the password if its validate.
    public static boolean validateRegisterPassword(String password) {

        matcherPassword = patternPassword.matcher(password); //Password should be equal to pattern.

        if (matcherPassword.matches()) { //If password equals to pattern.
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Your password is not validate. Dont use special characters [$^&#?_].", "REGEX !", JOptionPane.OK_OPTION);
            return false;
        }
    }

    //Checking the password again if its validate.
    public static boolean validateRegisterPasswordAgain(String password) {

        matcherPassword = patternPassword.matcher(password); //Password again should be equal to pattern.

        if (matcherPassword.matches()) { //If password again equals to pattern.
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Your password again is not validate. Dont use special characters [$^&#?_].", "REGEX !", JOptionPane.OK_OPTION);
            return false;
        }
    }

    //Checking the mail if its validate.
    public static boolean validateRegisterMail(String mail) {

        matcherMail = patternMail.matcher(mail); //Mail should be equal to pattern.

        if (matcherMail.matches()) { //If mail equals to pattern.
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Your mail is not validate. [blabla@blamail.bla].", "REGEX !", JOptionPane.OK_OPTION);
            return false;
        }
    }

    //Checking the old password if its validate.
    public static boolean validateResetMyPasswordOldPassword(String password) {

        matcherPassword = patternPassword.matcher(password); //Old password should be equal to pattern.

        if (matcherPassword.matches()) { //If old password equals to pattern.
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Your old password is not validate. Dont use special characters [$^&#?_].", "REGEX !", JOptionPane.OK_OPTION);
            return false;
        }
    }

    //Checking the new password if its validate.
    public static boolean validateResetMyPasswordNewPassword(String password) {

        matcherPassword = patternPassword.matcher(password); //New password should be equal to pattern.

        if (matcherPassword.matches()) { //If new password equals to pattern.
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Your old password is not validate. Dont use special characters [$^&#?_].", "REGEX !", JOptionPane.OK_OPTION);
            return false;
        }
    }

    //Checking the username if its validate.
    public static boolean validateResetMyPasswordUsername(String username) {

        matcherUsername = patternUsername.matcher(username); //Username should be equal to pattern.

        if (matcherUsername.matches()) { //If username equals to pattern.
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Your username is not validate. First letter should be capital.", "REGEX !", JOptionPane.OK_OPTION);
            return false;
        }
    }

    //Checking the mail if its validate.
    public static boolean validateResetMyPasswordMail(String mail) {

        matcherMail = patternMail.matcher(mail); //Mail should be equal to pattern.

        if (matcherMail.matches()) { //If mail equals to pattern.
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Your mail is not validate. [blabla@blamail.bla].", "REGEX !", JOptionPane.OK_OPTION);
            return false;
        }
    }

    //Checking the username if its validate.
    public static boolean validateForgotMyPasswordUsername(String username) {

        matcherUsername = patternUsername.matcher(username); //Username should be equal to pattern.

        if (matcherUsername.matches()) { //If username equals to pattern.
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Your username is not validate. First letter should be capital.", "REGEX !", JOptionPane.OK_OPTION);
            return false;
        }
    }

    //Checking the mail if its validate.
    public static boolean validateForgotMyPasswordMail(String mail) {

        matcherMail = patternMail.matcher(mail); //Mail should be equal to pattern.

        if (matcherMail.matches()) { //If mail equals to pattern.
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Your mail is not validate. [blabla@blamail.bla].", "REGEX !", JOptionPane.OK_OPTION);
            return false;
        }
    }
}
