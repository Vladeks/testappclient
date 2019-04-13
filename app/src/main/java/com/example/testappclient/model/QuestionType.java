package com.example.testappclient.model;

import java.util.Arrays;

public enum QuestionType {
    SINGLE_CHOICE,
    MULTI_CHOICE;

    public static String[] names() {
        return Arrays.toString(QuestionType.values()).replaceAll("^.|.$", "").split(", ");
    }
}
