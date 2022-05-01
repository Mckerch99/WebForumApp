/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package edu.humber.webforum;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Liam
 */
@Stateless
public class UserBean implements UserBeanLocal {

    @PersistenceContext(name = "WebForum-ejbPU")
    private EntityManager em;
    
    
    @Override
    public void saveUser(String username, String password) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebForum-ejbPU");
        em = emf.createEntityManager();
        ForumUsers user = new ForumUsers();
        user.setUsername(username);
        user.setPassword(password);
        em.persist(user);
        em.close();
        emf.close();
    }

    @Override
    public Boolean checkUser(String username, String password) {
      return true;
    }
    
}
