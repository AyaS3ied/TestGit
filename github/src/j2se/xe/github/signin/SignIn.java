/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2se.xe.github.signin;

import j2se.xe.github.dao.TestEmpsDao;
import j2se.xe.github.dao.UsersDao;
import j2se.xe.github.dto.TestEmps;
import j2se.xe.github.dto.Users;
import j2se.xe.github.exceptions.TestEmpsDaoException;
import j2se.xe.github.exceptions.UsersDaoException;
import j2se.xe.github.factory.TestEmpsDaoFactory;
import j2se.xe.github.factory.UsersDaoFactory;




/**
 *
 * @author hi
 */
public class SignIn
{
    /**
     * 
     * @param userName
     * @param password
     * @return
     * @throws UsersDaoException 
     */
    public Users signIn(String userName,String password) throws UsersDaoException
    {
        
       UsersDao udao= UsersDaoFactory.create();
        Users cuser = udao.findByPrimaryKey(userName, password);
       
       return cuser;
    }
    
    }
  
  


