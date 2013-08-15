package com.nastra.systemdesign.filesystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author nastra
 */
public class Directory extends FileEntry {

    private List<FileEntry> children = new ArrayList<FileEntry>();

    public Directory(String fileName, FileEntry parent) {
        super(fileName, parent);
    }

    @Override
    public boolean delete(FileEntry entry) {
        updatedAt.setTime(System.currentTimeMillis());
        return children.remove(entry);
    }

    public boolean addEntry(FileEntry entry) {
        updatedAt.setTime(System.currentTimeMillis());
        return children.add(entry);
    }

    @Override
    public int size() {
        int count = 0;
        for (FileEntry entry : children) {
            count += entry.size();
        }
        return count + 1;
    }

    public List<FileEntry> getFilesAndFolders() {
        return Collections.unmodifiableList(children);
    }

    public List<FileEntry> getFiles() {
        List<FileEntry> result = new ArrayList<FileEntry>();
        for (FileEntry entry : children) {
            if (entry instanceof File) {
                result.add(entry);
            }
        }
        return result;
    }
}
