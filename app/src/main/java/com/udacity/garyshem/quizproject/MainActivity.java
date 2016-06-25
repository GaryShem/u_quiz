package com.udacity.garyshem.quizproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkResults(View view) {
        int correctAnswers = 0;
        if (checkQuestion1()) {
            correctAnswers += 1;
        }
        if (checkQuestion2()) {
            correctAnswers += 1;
        }
        if (checkQuestion3()) {
            correctAnswers += 1;
        }
        if (checkQuestion4()) {
            correctAnswers += 1;
        }
        if (checkQuestion5()) {
            correctAnswers += 1;
        }

        // give the result on the button, so it is immediately obvious
        Button submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setTextSize(14);
        submitButton.setText(String.format(Locale.getDefault(), "%s %d %s", getString(R.string.result_report_string_part_1), correctAnswers, getString(R.string.result_report_string_part_2)));
    }

    public boolean checkQuestion1() {
        CheckBox answer1 = (CheckBox) findViewById(R.id.question_1_answer_1);
        CheckBox answer2 = (CheckBox) findViewById(R.id.question_1_answer_2);
        CheckBox answer3 = (CheckBox) findViewById(R.id.question_1_answer_3);
        int correctAnswers = 0;
        boolean isAnswerCorrect;
        // first, let's check if all the correct answers are checked
        isAnswerCorrect = checkCheckBoxAnswer(answer1, true);
        if (isAnswerCorrect){
            correctAnswers += 1;
        }
        isAnswerCorrect = checkCheckBoxAnswer(answer2, true);
        if (isAnswerCorrect){
            correctAnswers += 1;
        }
        isAnswerCorrect = checkCheckBoxAnswer(answer3, false);
        if (isAnswerCorrect){
            correctAnswers += 1;
        }
        //
        return correctAnswers == 3;
    }

    public boolean checkQuestion2() {     CheckBox answer1 = (CheckBox) findViewById(R.id.question_2_answer_1);
        CheckBox answer2 = (CheckBox) findViewById(R.id.question_2_answer_2);
        CheckBox answer3 = (CheckBox) findViewById(R.id.question_2_answer_3);
        CheckBox answer4 = (CheckBox) findViewById(R.id.question_2_answer_4);
        int correctAnswers = 0;
        boolean isAnswerCorrect;
        // first, let's check if all the correct answers are checked
        isAnswerCorrect = checkCheckBoxAnswer(answer2, true);
        if (isAnswerCorrect){
            correctAnswers += 1;
        }
        isAnswerCorrect = checkCheckBoxAnswer(answer4, true);
        if (isAnswerCorrect){
            correctAnswers += 1;
        }
        isAnswerCorrect = checkCheckBoxAnswer(answer1, false);
        if (isAnswerCorrect){
            correctAnswers += 1;
        }
        isAnswerCorrect = checkCheckBoxAnswer(answer3, false);
        if (isAnswerCorrect){
            correctAnswers += 1;
        }
        //
        return correctAnswers == 4;
    }

    public boolean checkQuestion3() {
        RadioButton answer1 = (RadioButton) findViewById(R.id.question_3_answer_1);
        RadioButton answer2 = (RadioButton) findViewById(R.id.question_3_answer_2);
        RadioButton answer3 = (RadioButton) findViewById(R.id.question_3_answer_3);
        // since we have these answers in RadioGroup, let's just check them 1 by 1
        int correctAnswers = 0;
        boolean isAnswerCorrect;
        // first, let's check if all the correct answers are checked
        isAnswerCorrect = checkRadioButtonAnswer(answer1, true);
        if (isAnswerCorrect){
            correctAnswers += 1;
        }
        isAnswerCorrect = checkRadioButtonAnswer(answer2, false);
        if (isAnswerCorrect){
            correctAnswers += 1;
        }
        isAnswerCorrect = checkRadioButtonAnswer(answer3, false);
        if (isAnswerCorrect){
            correctAnswers += 1;
        }
        return correctAnswers == 3;
    }

    public boolean checkQuestion4() {
        CheckBox answer1 = (CheckBox) findViewById(R.id.question_4_answer_1);
        CheckBox answer2 = (CheckBox) findViewById(R.id.question_4_answer_2);
        CheckBox answer3 = (CheckBox) findViewById(R.id.question_4_answer_3);
        CheckBox answer4 = (CheckBox) findViewById(R.id.question_4_answer_4);
        int correctAnswers = 0;
        boolean isAnswerCorrect;
        // first, let's check if all the correct answers are checked
        isAnswerCorrect = checkCheckBoxAnswer(answer2, true);
        if (isAnswerCorrect){
            correctAnswers += 1;
        }
        isAnswerCorrect = checkCheckBoxAnswer(answer3, true);
        if (isAnswerCorrect){
            correctAnswers += 1;
        }
        isAnswerCorrect = checkCheckBoxAnswer(answer1, false);
        if (isAnswerCorrect){
            correctAnswers += 1;
        }
        isAnswerCorrect = checkCheckBoxAnswer(answer4, false);
        if (isAnswerCorrect){
            correctAnswers += 1;
        }
        //
        return correctAnswers == 4;
    }

    public boolean checkQuestion5() {
        EditText answerBox = (EditText) findViewById(R.id.question_5_answer_edit_text);
        String answer = answerBox.getText().toString();

        if (answer.equals("String")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks a single answer for correctness and paints its background accordingly
     * @param answer - an answer to check
     * @param shouldBeChecked - shows whether the answer should be checked
     * @return correctness of answer
     */
    private boolean checkCheckBoxAnswer(CheckBox answer, boolean shouldBeChecked) {
        boolean result = answer.isChecked() == shouldBeChecked;
        if (answer.isChecked() && shouldBeChecked) {
            answer.setBackgroundColor(getResources().getColor(R.color.correctAnswer));
        } else if (answer.isChecked() && shouldBeChecked == false) {
            answer.setBackgroundColor(getResources().getColor(R.color.wrongAnswer));
        } else {
            answer.setBackgroundColor(getResources().getColor(R.color.transparent));
        }

        return result;
    }

    private boolean checkRadioButtonAnswer(RadioButton answer, boolean shouldBeChecked) {
        boolean result = answer.isChecked() == shouldBeChecked;
        if (answer.isChecked() && shouldBeChecked) {
            answer.setBackgroundColor(getResources().getColor(R.color.correctAnswer));
        } else if (answer.isChecked() && shouldBeChecked == false) {
            answer.setBackgroundColor(getResources().getColor(R.color.wrongAnswer));
        } else {
            answer.setBackgroundColor(getResources().getColor(R.color.transparent));
        }

        return result;
    }
}
