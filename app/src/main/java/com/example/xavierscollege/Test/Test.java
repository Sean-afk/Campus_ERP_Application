package com.example.xavierscollege.Test;

public class Test {

    private String testId;
    private int topScore,time;

    public Test(String testId, int topScore, int time) {
        this.testId = testId;
        this.topScore = topScore;
        this.time = time;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public int getTopScore() {
        return topScore;
    }

    public void setTopScore(int topScore) {
        this.topScore = topScore;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
