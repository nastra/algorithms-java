package com.nastra.systemdesign.filesystem;

import java.sql.Timestamp;

/**
 *
 * @author nastra
 */
public abstract class FileEntry {

    protected String fileName;
    protected FileEntry parent;
    protected Timestamp createdAt;
    protected Timestamp updatedAt;

    public FileEntry(String fileName, FileEntry parent) {
        this.fileName = fileName;
        this.parent = parent;
        createdAt = new Timestamp(System.currentTimeMillis());
        updatedAt = createdAt;
    }

    public abstract boolean delete(FileEntry entry);

    public abstract int size();

    public boolean delete() {
        if (null == parent) {
            return false;
        }
        return parent.delete(this);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        if (null == parent) {
            return fileName;
        }
        return parent.getPath() + "/" + fileName;
    }

    public FileEntry getParent() {
        return parent;
    }

    public void setParent(FileEntry parent) {
        this.parent = parent;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
