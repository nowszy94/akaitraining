package com.cognifide.akaitraining;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

/**
 * Created by szymon.nowak on 16.05.2017.
 */
public class Utils {

    //JcrUtils.getStringProperty()
    public static String getStringProperty(Node node, String propertyName) throws RepositoryException {
        String value = null;
        if (node.hasProperty(propertyName)) {
            value = node.getProperty(propertyName).getString();
        }
        return value;
    }
}
