package net.project.utils;

import java.io.File;

/**
 * @author learnercys on 10/09/15.
 */
public class CFile extends File {

    public CFile(String path) {
        super(path);
    }

    public CFile(File f) {
        this(f.getAbsolutePath());
    }
}
