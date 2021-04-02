package com.example.xavierscollege.Ebook;

public class EbookData {
    private String fileUrl,noteTitle;

    public EbookData(String fileUrl, String noteTitle) {
        this.fileUrl = fileUrl;
        this.noteTitle = noteTitle;
    }

    public EbookData() {
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }
}
