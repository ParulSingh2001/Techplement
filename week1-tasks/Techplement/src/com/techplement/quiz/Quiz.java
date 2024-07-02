package com.techplement.quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
	private List<Question> questions;

    public Quiz() {
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void takeQuiz() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ": " + options.get(i));
            }
            System.out.print("Your answer: ");
            int answer = scanner.nextInt();
            if (question.isCorrect(answer - 1)) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong! The correct answer is: " + (question.getCorrectAnswerIndex() + 1));
            }
        }

        System.out.println("Your score is: " + score + "/" + questions.size());
    }

}
