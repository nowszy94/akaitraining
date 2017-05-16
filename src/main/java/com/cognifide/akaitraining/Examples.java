package com.cognifide.akaitraining;


import javax.jcr.*;

public class Examples {

    public static void main(String[] args) throws RepositoryException {
        Session session = Application.createConnection();
        try {
            removeDayNode(session, "Monday");
        } finally {
            session.logout();
        }
    }

    public static void firstExercise(Session session) throws RepositoryException {
        Node rootNode = session.getRootNode();
        Node days = rootNode.addNode("days");
        Node monday = days.addNode("Monday");
        monday.setProperty("name", "test");
        monday.setProperty("hello", "world");
        monday.setProperty("message", "Ala ma kota");
        session.save();
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

    public static void removeDayNode(Session session, String dayName) throws RepositoryException {
        Node days = session.getRootNode().getNode("days");
        NodeIterator nodes = days.getNodes();
        while (nodes.hasNext()) {
            Node node = nodes.nextNode();
            if (node.getName().equals(dayName)) {
                node.remove();
                session.save();
                break;
            }
        }

//        try {
//            Node nodeToRemove = session.getRootNode().getNode("days/" + dayName);
//            nodeToRemove.remove();
//            session.save();
//        } catch (RepositoryException e) {
//            //..
//        }
    }

    public static void simpleRemove(Session session) throws RepositoryException {
        Node root = session.getRootNode();
        root.getNode("hello").remove();
        session.save();
    }
}
