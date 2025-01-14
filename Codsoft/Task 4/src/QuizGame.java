import java.util.ArrayList;  
import java.util.List;  
import java.util.Scanner;  
import java.util.Timer;  
import java.util.TimerTask;  

class Question {  
    String question;  
    String[] options;  
    int correctAnswerIndex;  

    public Question(String question, String[] options, int correctAnswerIndex) {  
        this.question = question;  
        this.options = options;  
        this.correctAnswerIndex = correctAnswerIndex;  
    }  
}  

public class QuizGame {  
    private static final int TIME_LIMIT = 10; // Time limit for each question in seconds  
    private static int score = 0;  
    private static List<Question> questions = new ArrayList<>();  

    public static void main(String[] args) {  
        setupQuestions();  
        playQuiz();  
        displayResults();  
    }  

    private static void setupQuestions() {  
        questions.add(new Question("What is the capital of France?", new String[]{"1. Berlin", "2. Madrid", "3. Paris", "4. Rome"}, 2));  
        questions.add(new Question("Which planet is known as the Red Planet?", new String[]{"1. Earth", "2. Mars", "3. Jupiter", "4. Venus"}, 1));  
        questions.add(new Question("What is the largest ocean on Earth?", new String[]{"1. Atlantic Ocean", "2. Indian Ocean", "3. Arctic Ocean", "4. Pacific Ocean"}, 3));  
         
    }  

    private static void playQuiz() {  
        Scanner scanner = new Scanner(System.in);  
        for (Question q : questions) {  
            System.out.println(q.question);  
            for (String option : q.options) {  
                System.out.println(option);  
            }  


            Timer timer = new Timer();  
            TimerTask task = new TimerTask() {  
                @Override  
                public void run() {  
                    System.out.println("\nTime's up! Moving to the next question.\n");  
                }  
            };  
            timer.schedule(task, TIME_LIMIT * 1000); // Schedule the task  

          
            System.out.print("Your answer (1-4): ");  
            int userAnswer = scanner.nextInt() - 1;   
            timer.cancel();  

            if (userAnswer == q.correctAnswerIndex) {  
                System.out.println("Correct!");  
                score++;  
            } else {  
                System.out.println("Incorrect! The correct answer was: " + q.options[q.correctAnswerIndex]);  
            }  
            System.out.println();  
        }  
        scanner.close();  
    }  

    private static void displayResults() {  
        System.out.println("Quiz Finished!");  
        System.out.println("Your final score: " + score + "/" + questions.size());  
    }  
}