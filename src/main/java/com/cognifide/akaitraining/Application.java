package com.cognifide.akaitraining;

import org.apache.jackrabbit.commons.JcrUtils;

import javax.jcr.*;

public class Application {
    public static void main(String[] args) throws RepositoryException {
        Session session = createConnection();
        try {
            simpleSave(session);
            simpleRead(session);
            simpleRemove(session);
        } finally {
            session.logout();
        }
    }

    public static Session createConnection() throws RepositoryException {
        //Ustawiamy polaczenie z dzialajacym serwerem
        Repository repository = JcrUtils.getRepository("http://localhost:8080/server");
        //Podajemy dane do logowania
        SimpleCredentials adminCredentials = new SimpleCredentials("admin", "admin".toCharArray());
        //Logujemy się do repozytorium, workspace default
        return repository.login(adminCredentials, "default");
    }

    public static void simpleSave(Session session) throws RepositoryException {
        Node root = session.getRootNode();
        Node hello = root.addNode("hello");
        Node world = hello.addNode("world");
        world.setProperty("message", "hello world");
        session.save();
    }

    public static void simpleRead(Session session) throws RepositoryException {
        Node root = session.getRootNode();
        Node node = root.getNode("hello/world");
        System.out.println(node.getPath());
        System.out.println(node.getProperty("message").getString());
    }

    public static void simpleRemove(Session session) throws RepositoryException {
        Node root = session.getRootNode();
        root.getNode("hello").remove();
    }
}
