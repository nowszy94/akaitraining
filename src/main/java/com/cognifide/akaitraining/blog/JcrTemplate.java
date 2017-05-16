package com.cognifide.akaitraining.blog;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

public interface JcrTemplate  {
    void doInJcr(Session session) throws RepositoryException;
}
