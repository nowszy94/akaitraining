package com.cognifide.akaitraining;

import com.cognifide.akaitraining.blog.BlogOperations;
import org.apache.jackrabbit.commons.JcrUtils;

import javax.jcr.*;

public class Application {
    public static void main(String[] args) throws RepositoryException {
        Session session = createConnection();
        BlogOperations blogOperations = new BlogOperations(session);
        try {
            blogOperations.init();

            blogOperations.clearContent();
        } finally {
            session.logout();
        }
    }

    public static Session createConnection() throws RepositoryException {
        Repository repository = JcrUtils.getRepository("http://localhost:8080/server");
        SimpleCredentials adminCredentials = new SimpleCredentials("admin", "admin".toCharArray());
        return repository.login(adminCredentials, "default");
    }
}
