package com.example;

import com.example.entity.Question;

import java.util.*;

public class Main {

    /**
     * Helper method to create and return a list of questions for the quiz.
     *
     * @return A List of Question objects.
     */

    private static List<Question> setupQuestions() {
        // Create a list to hold the Question objects
        List<Question> questionList = new ArrayList<>();

        // --- Question 1 ---
        // Create the HashMap for options
        HashMap<String, String> q1Options = new HashMap<>();
        q1Options.put("A", "java.io");
        q1Options.put("B", "java.util");
        q1Options.put("C", "java.lang");
        q1Options.put("D", "java.system");
        // Create the Question object and add it to the list
        // Correct answer is "A"
        questionList.add(new Question(
                "Which package is imported by default in every Java program?",
                q1Options,
                "C"
        ));

        // --- Question 2 ---
        HashMap<String, String> q2Options = new HashMap<>();
        q2Options.put("A", "A way to store multiple values");
        q2Options.put("B", "A blueprint for creating objects");
        q2Options.put("C", "A single variable");
        q2Options.put("D", "A method");
        // Correct answer is "B"
        questionList.add(new Question(
                "What is a 'class' in Java?",
                q2Options,
                "B"
        ));

        // --- Question 3 ---
        HashMap<String, String> q3Options = new HashMap<>();
        q3Options.put("A", ".exe");
        q3Options.put("B", ".java");
        q3Options.put("C", ".class");
        q3Options.put("D", ".jvm");
        // Correct answer is "C"
        questionList.add(new Question(
                "What file extension does the Java compiler create?",
                q3Options,
                "C"
        ));

        // --- Question 4 ---
        HashMap<String, String> q4Options = new HashMap<>();
        q4Options.put("A", "Object-Oriented");
        q4Options.put("B", "Platform Independent");
        q4Options.put("C", "Robust and Secure");
        q4Options.put("D", "All of the above");
        // Correct answer is "D"
        questionList.add(new Question(
                "Which of these is a feature of Java?",
                q4Options,
                "D"
        ));

        // --- Question 5 ---
        HashMap<String, String> q5Options = new HashMap<>();
        q5Options.put("A", "Connection");
        q5Options.put("B", "Statement");
        q5Options.put("C", "ResultSet");
        q5Options.put("D", "DriverManager");
        // Correct answer is "B"
        questionList.add(new Question(
                "Which interface is the entry point for most JDBC operations?",
                q5Options,
                "A"
        ));

        // --- Question 6 ---
        HashMap<String, String> q6Options = new HashMap<>();
        q6Options.put("A", "Statement");
        q6Options.put("B", "CallableStatement");
        q6Options.put("C", "PreparedStatement");
        q6Options.put("D", "QueryStatement");
        // Correct answer is "B"
        questionList.add(new Question(
                "Which Statement is used to execute parameterized queries in JDBC?",
                q6Options,
                "C"
        ));

        // --- Question 7 ---
        HashMap<String, String> q7Options = new HashMap<>();
        q7Options.put("A", "@SpringBootApplication");
        q7Options.put("B", "@MainApplication");
        q7Options.put("C", "@EnableAutoConfiguration");
        q7Options.put("D", "@ComponentScan");
        // Correct answer is "A"
        questionList.add(new Question(
                "What annotation is used to mark the main class of a Spring Boot application?",
                q7Options,
                "A"
        ));

        // --- Question 8 ---
        HashMap<String, String> q8Options = new HashMap<>();
        q8Options.put("A", "(a, b) -> a + b");
        q8Options.put("B", "function(a, b) { return a + b; }");
        q8Options.put("C", "(a, b) => a + b");
        q8Options.put("D", "def (a, b): a + b");
        // Correct answer is "A"
        questionList.add(new Question(
                "What is the correct syntax for a simple lambda expression in Java?",
                q8Options,
                "A"
        ));

        // --- Question 9 ---
        HashMap<String, String> q9Options = new HashMap<>();
        q9Options.put("A", "filter()");
        q9Options.put("B", "map()");
        q9Options.put("C", "sorted()");
        q9Options.put("D", "collect()");
        // Correct answer is "D"
        questionList.add(new Question(
                "Which of the following is a terminal operation in the Java Stream API?",
                q9Options,
                "D"
        ));

        // --- Question 10 ---
        HashMap<String, String> q10Options = new HashMap<>();
        q10Options.put("A", "filter()");
        q10Options.put("B", "map()");
        q10Options.put("C", "reduce()");
        q10Options.put("D", "forEach()");
        // Correct answer is "B"
        questionList.add(new Question(
                "Which Stream method is used to transform each element into another element?",
                q10Options,
                "B"
        ));

        // Return the complete list of questions
        return questionList;
    }
    static void main() {
        // Initialize the Scanner to read input from the console
        Scanner sc = new Scanner(System.in);

        // This list will hold all our Question objects
        List<Question> questions = setupQuestions();

        // Initialize the user's score
        int score = 0;
        int totalQuestions = questions.size();


        System.out.println("Welcome to the Java Quiz!");
        System.out.println("You must answer all " + totalQuestions + " questions. Let's begin!");
        System.out.println("--------------------------------------------");

        // Loop through each question in the list
        // We use an index `i` to show the question number (i + 1)
        for (int i = 0; i < totalQuestions; i++) {
            Question currentQuestion = questions.get(i);

            // Display the question number and text
            System.out.println("Question " + (i + 1) + ": " + currentQuestion.getQuestionText());

            // Display the options from the HashMap
            // We iterate over the entrySet to get both key and value
            for (Map.Entry<String, String> entry : currentQuestion.getOptions().entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            // Prompt the user for their answer
            System.out.print("Your answer : ");
            String userAnswer = sc.nextLine();

            // --- Logic to check the answer ---

            // We clean the user's input: remove whitespace and convert to uppercase
            // This makes the check case-insensitive (e.g., "a" becomes "A")
            String formattedUserAnswer = userAnswer.trim().toUpperCase();

            // Get the correct answer key from the question object
            String correctAnswer = currentQuestion.getCorrectAnswerKey();

            // Compare the user's formatted answer to the correct answer
           if (formattedUserAnswer.equals(correctAnswer)) {
                // User is correct
                System.out.println("Wohoo!! Correct..");
                score+=2; // Increment the score by 2 for each correct answer
            } else {
                // User is incorrect
                System.out.println("Oopsy!!! The correct option was: " + correctAnswer);
                // We can also show the correct answer text
                System.out.println("Correct Answer: " + currentQuestion.getOptions().get(correctAnswer));
            }

            // Show the user's current score after each question
            System.out.println("Your current score is: " + score + "/" + ((i + 1)*2));
            System.out.println("--------------------------------------------");
        }

        // --- End of Quiz ---
        // The loop is finished, so all questions have been answered.
        System.out.println("Congo!! Quiz completed...");
        System.out.println("Your final score is: " + score + " out of " + (totalQuestions*2));

        // Close the scanner to prevent resource leaks
        sc.close();
    }
}
