/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package edu.humber.webforum;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Liam
 */
@Local
public interface ForumBeanLocal {
    public String greetingMessage();
    public String errorMessage();
    public List<ForumPosts> postMessages();
    public void createPost(String message);
    public void deleteMessage(Long postNum);
}
