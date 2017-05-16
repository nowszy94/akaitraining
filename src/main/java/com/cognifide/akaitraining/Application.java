package com.cognifide.akaitraining;

import com.cognifide.akaitraining.blog.BlogOperations;
import org.apache.jackrabbit.commons.JcrUtils;

import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;

public class Application {
    public static void main(String[] args) throws RepositoryException {
        Session connection = createConnection();
        BlogOperations blogOperations = new BlogOperations(connection);
        try {
            blogOperations.init();
            blogOperations.addCategory("java");
            blogOperations.addCategory("math");
            blogOperations.addCategory("science");
            blogOperations.clearContent();
        } finally {
            connection.logout();
        }
    }

    public static Session createConnection() throws RepositoryException {
        Repository repository = JcrUtils.getRepository("http://localhost:8080/server");
        SimpleCredentials adminCredentials = new SimpleCredentials("admin", "admin".toCharArray());
        return repository.login(adminCredentials, "default");
    }
}
