package com.naura.test.ui.page;

public class HashValue {
    private final String value;
    private final double score;

    public HashValue(String value, double score) {
        System.out.println("value = " + value);
        System.out.println("score = " + score);
        this.value = value;
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public String getValue() {
        return value;
    }
}
