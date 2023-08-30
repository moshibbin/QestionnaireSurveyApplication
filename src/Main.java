import Person.Person;
import Question.Question;
import Questionnaire.Questionnaire;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // create a Questionnaire with id
        Questionnaire questionnaire = new Questionnaire(1234);

        // store Questions
        questionnaire.addQuestion(new Question("Where are you located?"));
        questionnaire.addQuestion(new Question("What is your zip code?"));
        questionnaire.addQuestion(new Question("What is your job title?"));

        Scanner scanner = new Scanner(System.in);

        // Get user data from Input
        System.out.println("Enter your Frist Name");
        String fristName = scanner.nextLine();

        System.out.println("Enter your Last Name");
        String lastName = scanner.nextLine();

        System.out.println("Enter your Email");
        String email = scanner.nextLine();

        // create a Person Object with user details
        Person person = new Person(fristName,lastName,email);


        // Answer the Questions
        String[] asnwers = new String[questionnaire.getQuestions().size()];
        for (int i = 0; i < asnwers.length; i++) {
            System.out.println(questionnaire.getQuestions().get(i).getQuestionText());
            asnwers[i]= scanner.nextLine();
        }

        // store quetion in a new Array
        String[] quetions = new String[questionnaire.getQuestions().size()];
        for (int i = 0; i <quetions.length ; i++) {
            quetions[i]=questionnaire.getQuestions().get(i).getQuestionText();
        }

        // save perosn and answers the file
        saveAnswersToFile(quetions , person , asnwers);

        // close the scanner
        scanner.close();

    }

    // method save answers from the user input  to file
    private static void saveAnswersToFile(
            String[] quetions,
            Person person,
            String[] asnwers) {

        // file path
        String fileName = "src/survey_answers.txt";

        try {

            // write the file user details
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            bufferedWriter.write("Person Frist Name : " + person.getFirstName() + "\n");
            bufferedWriter.write("Person Last Name : " + person.getLastName() + "\n");
            bufferedWriter.write("Person Last Email : " + person.getEmail() + "\n");

            // write the file user answers with a questions
            for (int i = 0; i < asnwers.length; i++) {
                bufferedWriter.write("Question" + "  " + (i+1) + quetions[i] +" : " + asnwers[i] + "\n");
            }

            bufferedWriter.write("\n");
            bufferedWriter.close();
            System.out.println("Survey answers saved to " + fileName);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


}}