/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2se.xe.github.signup;

import com.toedter.calendar.JDateChooser;
import j2se.xe.github.dao.TestUsersDao;
import j2se.xe.github.dto.TestUsers;
import j2se.xe.github.dto.TestUsersPk;
import j2se.xe.github.dto.Users;
import j2se.xe.github.dto.UsersPk;
import j2se.xe.github.exceptions.TestUsersDaoException;
import j2se.xe.github.exceptions.UsersDaoException;
import j2se.xe.github.factory.TestUsersDaoFactory;
import j2se.xe.github.jdbc.TestUsersDaoImpl;
import j2se.xe.github.jdbc.UsersDaoImpl;

import j2se.xe.github.signin.SignInForm;
import java.math.BigDecimal;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author hi
 */
public class SignUp extends TestUsersDaoImpl {

    public static void signUp(JTextField fullName, JTextField description, JTextField userName, JTextField mobile, JPasswordField password,
            JDateChooser hdate, JTextArea address) throws TestUsersDaoException, UsersDaoException {
        String fname = fullName.getText();
        String uname = userName.getText();
        String mob = mobile.getText();
        String desc = description.getText();
        char[] pw = password.getPassword();

        String addrs = address.getText();
        try {
            TestUsersDaoImpl temp = new TestUsersDaoImpl();

            TestUsers newUser = new TestUsers();
            newUser.setUserAddress(addrs);
            newUser.setUserMobile(mob);
            newUser.setUserName(uname);
            newUser.setUserDescription(desc);

            java.util.Date utilDate = (java.util.Date) hdate.getDate();

            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            newUser.setUserHireDate(sqlDate);

            TestUsersPk udp = new TestUsersDaoImpl().insert(newUser);

            String pass = new String(pw);
            Users exUser = new Users();
            exUser.setUserName(uname);
            exUser.setPassword(pass);
            UsersPk udp1 = new UsersDaoImpl().insert(exUser);
            JOptionPane.showMessageDialog(null, "welcome " + uname);
        } catch (Exception ex) {
            System.out.println("Error");
        }
    }

    public static boolean chkMob(JTextField mobile) throws TestUsersDaoException {

        TestUsersDao ted = TestUsersDaoFactory.create();
        TestUsers[] user = ted.findAll();
        String mob = mobile.getText();
        boolean flag=false;
        for (int i = 0; i < user.length; i++) {
            if (mob.equals(user[i].getUserMobile()) ) {
                flag=true;
                int x = JOptionPane.showConfirmDialog(null, "user Already Exists ,Sign In Instead ? ",
                        "Confirm", JOptionPane.YES_NO_OPTION);
                
                if (x == 0) {
                    new SignInForm().setVisible(true);
                    
                } else {
                    mobile.setText("");
                    mobile.requestFocus();
                }
            }
        }  return flag;
    }
  
   
}

