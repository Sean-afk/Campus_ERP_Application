package com.example.xavierscollege.Quiz.QuizHome;

public class Category {

    private String docId,name;
    private int noOfTests;

    public Category(String docId, String name, int noOfTests) {
        this.docId = docId;
        this.name = name;
        this.noOfTests = noOfTests;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfTests() {
        return noOfTests;
    }

    public void setNoOfTests(int noOfTests) {
        this.noOfTests = noOfTests;
    }
}
