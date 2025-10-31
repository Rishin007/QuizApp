package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.HashMap;

/**
 * Represents a single quiz question.
 * This class holds the question text, a map of options, and the key
 * of the correct answer.
 */

@AllArgsConstructor
@Getter
public class Question {

    // The text of the question itself
    private String questionText;

    // A HashMap to store the options.
    // The key is the option letter (e.g., "A", "B")
    // The value is the option text (e.g., "Paris")
    private HashMap<String, String> options;

    // The key (e.g., "A") that corresponds to the correct answer in the options map.
    private String correctAnswerKey;


}