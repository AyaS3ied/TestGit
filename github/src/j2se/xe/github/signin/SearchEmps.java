/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2se.xe.github.signin;

import com.toedter.calendar.JDateChooser;
import j2se.xe.github.dao.TestEmpsDao;
import j2se.xe.github.dto.TestEmps;
import j2se.xe.github.exceptions.TestEmpsDaoException;
import j2se.xe.github.factory.TestEmpsDaoFactory;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Administrator
 */
public class SearchEmps {

    public static void searchEmp(int Id, JTextField name, JTextField hdate, JTextField salary, JTextArea address, JTextField nid) throws TestEmpsDaoException {
        TestEmpsDao ted = TestEmpsDaoFactory.create();
        TestEmps emp = ted.findByPrimaryKey(Id);
        name.setText(emp.getEmpName());
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        String sdate = df.format(emp.getEmpHireDate());

        hdate.setText(sdate);
        salary.setText(emp.getEmpSalary()+"");
        address.setText(emp.getEmpAddress());
        nid.setText(emp.getEmpNid());
       
    }
        
    /**
     *
     * @throws TestEmpsDaoException
     */
    public static void getId(JComboBox jid) throws TestEmpsDaoException
 {TestEmpsDao ted = TestEmpsDaoFactory.create();
        TestEmps [] emp = ted.findAll();
 int [] ids=new int[emp.length];
 for(int i=0;i<ids.length ; i++){
 
 jid.addItem(emp[i].getEmpId());
 }
 
    }
}


