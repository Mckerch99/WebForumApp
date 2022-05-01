/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package edu.humber.webforum;

import javax.ejb.Local;

/**
 *
 * @author Liam
 */
@Local
public interface UserBeanLocal {
    public void saveUser(String username, String password);
    public Boolean checkUser(String username, String password);
}
