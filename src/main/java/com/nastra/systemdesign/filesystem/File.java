package com.nastra.systemdesign.filesystem;

/**
 * 
 * @author nastra
 */
public class File extends FileEntry {

    @Override
    public boolean delete(FileEntry entry) {
        return delete();
    }

    @Override
    public int size() {
        return 1;
    }

    public File(String fileName, FileEntry parent) {
        super(fileName, parent);
    }
}
