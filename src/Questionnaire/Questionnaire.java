package Questionnaire;

import Question.Question;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Questionnaire {
    private int id;
    private Date createdAt;
    private List<Question> questions;

    public Questionnaire(int id) {
        this.id = id;
        this.createdAt = new Date();
        questions = new ArrayList<>();
    }

    public void addQuestion(Question question){
//        questions.add(question);
        questions.add(question);

    }


    public void  removeQuestion(Question question){
        questions.remove(question);
    }
    public  List<Question> getQuestions(){
        return questions;
    }
}
