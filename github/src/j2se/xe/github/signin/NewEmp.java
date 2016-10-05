/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2se.xe.github.signin;

import com.toedter.calendar.JDateChooser;
import j2se.xe.github.dao.TestEmpsDao;
import j2se.xe.github.dto.TestEmps;
import j2se.xe.github.dto.TestEmpsPk;
import j2se.xe.github.exceptions.TestEmpsDaoException;
import j2se.xe.github.factory.TestEmpsDaoFactory;
import j2se.xe.github.jdbc.TestEmpsDaoImpl;
import java.awt.Component;
import java.awt.Container;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Administrator
 */
public class NewEmp {
    public static void newEmp(JTextField name,JDateChooser hdate,JTextField salary, JTextArea address ,JTextField nid) throws TestEmpsDaoException{
        TestEmps newEmp= new TestEmps() ;
        String fname=name.getText();
      
       
       String addrs=address.getText();
       String sala=salary.getText();
       
       String nash=nid.getText();
       
      int sal = Integer.parseInt(sala);
       newEmp.setEmpAddress(addrs);
       newEmp.setEmpName(fname);
      newEmp.setEmpNid(nash);
       newEmp.setEmpSalary(sal);
    
       java.util.Date utilDate = (java.util.Date) hdate.getDate();

java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
newEmp.setEmpHireDate(sqlDate);

TestEmpsPk tep=new  TestEmpsDaoImpl().insert(newEmp);

    }
  
       
 
}
  
