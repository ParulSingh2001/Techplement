package com.techplement.quiz;

import java.util.Arrays;
import java.util.Scanner;

public class QuizGenerator {
	private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        boolean running = true;

        while (running) {
            System.out.println("Welcome to the quiz generator application!");
            System.out.println("\t 1. Add a new question");
            System.out.println("\t 2. Take the quiz");
            System.out.println("\t 3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addQuestionToQuiz(quiz);
                    break;
                case 2:
                    quiz.takeQuiz();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addQuestionToQuiz(Quiz quiz) {
        System.out.print("Enter the question: ");
        String questionText = scanner.nextLine();

        System.out.print("Enter the number of options: ");
        int numOptions = scanner.nextInt();
        scanner.nextLine(); 

        String[] options = new String[numOptions];
        for (int i = 0; i < numOptions; i++) {
            System.out.print("Enter option " + (i + 1) + ": ");
            options[i] = scanner.nextLine();
        }

        System.out.print("Enter the index of the correct answer (1-" + numOptions + "): ");
        int correctAnswerIndex = scanner.nextInt() - 1;

        Question question = new Question(questionText, Arrays.asList(options), correctAnswerIndex);
        quiz.addQuestion(question);
        System.out.println("Question added successfully!");
    }

}
