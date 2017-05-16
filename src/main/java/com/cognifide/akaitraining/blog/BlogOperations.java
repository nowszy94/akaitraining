package com.cognifide.akaitraining.blog;

import com.cognifide.akaitraining.jcr.JcrTemplate;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.List;

public class BlogOperations {
    private Session session;

    public BlogOperations(Session session) {
        this.session = session;
    }

    public void init() {
        try {
            Node rootNode = session.getRootNode();
            Node content = rootNode.addNode("content");
            content.addNode("blogs");
            session.save();
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
    }

    public void addCategory(String categoryName) {
        try {
            Node blogsNode = session.getRootNode().getNode("content/blogs");
            blogsNode.addNode(categoryName);
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

    //Remember to switch spaces to underscore
    public void addBlog(String categoryName, String blogName, BlogModel blogModel) {
        //TODO
    }

    public BlogModel getBlogModel(String categoryName, String blogName) {
        //TODO
        return null;
    }

    public List<BlogModel> getAllBlogModels() {
        //TODO
        return null;
    }

    public List<BlogModel> getAllBlogModels(String categoryName) {
        //TODO
        return null;
    }

    public void execute(JcrTemplate jcrTemplate) throws RepositoryException {
        jcrTemplate.doInJcr(session);
    }
}
