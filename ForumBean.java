/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package edu.humber.webforum;

import java.util.List;
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
public class ForumBean implements ForumBeanLocal {
    @PersistenceContext(name = "WebForum-ejbPU")
    
    private String message;
    
    @Override
    public String greetingMessage() {
       message = "Hello! Welcome to my web forum.\n Please enjoy yourself!";
       return message;
    }

    @Override
    public List<ForumPosts> postMessages() {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebForum-ejbPU");
        EntityManager em = emf.createEntityManager();
        List<ForumPosts> posts = em.createNamedQuery("SELECT p FROM ForumPosts p").getResultList();
        return posts;
    }

    @Override
    public String errorMessage() {
        message = "User does not exist please register user";
        return message;
    }

    @Override
    public void createPost(String message) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebForum-ejbPU");
        EntityManager em = emf.createEntityManager();
        ForumPosts post = new ForumPosts();
        post.setPost(message);
        em.persist(post);
        em.close();
        emf.close();
    }

    @Override
    public void deleteMessage(Long postNum) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebForum-ejbPU");
        EntityManager em = emf.createEntityManager();
        ForumPosts posts = new ForumPosts();
        em.createNamedQuery("DELETE object(p) FROM ForumPosts p WHERE p_id = \""+ postNum + "\"");
        em.persist(posts);
    }


}
