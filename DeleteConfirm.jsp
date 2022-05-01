<%-- 
    Document   : DeleteConfirm
    Created on : Apr. 23, 2022, 3:22:58 p.m.
    Author     : Liam
--%>

<%@page import="edu.humber.webforum.*"%>
<%@page import="javax.naming.Context"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--[java:global/WebForum/WebForum-ejb/ForumBean!edu.humber.webforum.ForumBeanLocal, java:global/WebForum/WebForum-ejb/ForumBean]]]-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Confirmation</title>
        
    </head>
    <body>
        <h1>Message Deleted!</h1>
        <div>
            <a href="Home.html">Return To Home Page</a>
        </div>
        <% 
            //  Portable JNDI names for EJB InfoSessionBean: [java:global/Lab6EJBDemoWebApp/InfoSessionBean, java:global/Lab6EJBDemoWebApp/InfoSessionBean!edu.humber.lab6.InfoSessionBeanLocal]]]
            String lookupUrl = "java:global/WebForum/WebForum-ejb/ForumBean!edu.humber.webforum.ForumBeanLocal";
            Context ctx = new javax.naming.InitialContext();
            ForumBeanLocal forumBean = (ForumBeanLocal) ctx.lookup(lookupUrl);
            Long postnum = Long.parseLong(request.getParameter("txtDelete"));
            forumBean.deleteMessage(postnum);
            
        %>
    </body>
</html>
