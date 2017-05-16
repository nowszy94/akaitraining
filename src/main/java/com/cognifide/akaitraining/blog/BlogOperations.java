package com.cognifide.akaitraining.blog;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.List;

/**
 * Created by szymon.nowak on 16.05.2017.
 */
public class BlogOperations {
    private Session session;

    public BlogOperations(Session session) {
        this.session = session;
    }

    public void init() {
        try {
            Node rootNode = session.getRootNode();
            Node content = rootNode.addNode("content");
            Node blogs = content.addNode("blogs");
            session.save();
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
    }

    public void clearContent() {
        try {
            Node rootNode = session.getRootNode();
            Node contentNode = rootNode.getNode("content");
            contentNode.remove();
            session.save();
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
    }

    //Remember to switch
    public void addBlog(String relativePath, BlogModel blogModel) {
        //TODO
    }

    public BlogModel readBlogModel(String relativePath) {
        //TODO
        return null;
    }

    public List<BlogModel> getAllBlogModels() {
        //TODO
        return null;
    }

    public void execute(JcrTemplate jcrTemplate) throws RepositoryException {
        jcrTemplate.doInJcr(session);
    }
}
