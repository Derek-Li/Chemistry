//*****************************************************
// by: Michael Ang
// Current Problems
// Need to clear garbage files when back buttoned
//*****************************************************
package com.example.chemistry;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class Questions extends Activity implements OnCheckedChangeListener,
		OnClickListener {
	TextView question;
	Button submit;
	String questionId, choiceAId, choiceBId, choiceCId, choiceDId, answerId,
			explanationId, explanation, answer, setChoice;
	RadioButton choiceA, choiceB, choiceC, choiceD;
	RadioGroup mcGroup;
	int counter = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.questions_activity);
		runProgram();
	}

	private void runProgram() {
		initialize();
		setStringId();
	}

	// Assigns the string with stringId
	private void setStringId() {

		setRootQuestion();
		// Sets up the string names to be fetches
		choiceAId = questionId + "a";
		choiceBId = questionId + "b";
		choiceCId = questionId + "c";
		choiceDId = questionId + "d";
		answerId = questionId + "ans";
		explanationId = questionId + "exp";

		// Retrieves the question, answer, explanation
		question.setText(getResources().getIdentifier(questionId, "string",
				getPackageName()));
		answer = getString(getResources().getIdentifier(answerId, "string",
				getPackageName()));
		explanation = getString(getResources().getIdentifier(explanationId,
				"string", getPackageName()));

		// Fetches the Choices
		choiceA.setText(getResources().getIdentifier(choiceAId, "string",
				getPackageName()));
		choiceB.setText(getResources().getIdentifier(choiceBId, "string",
				getPackageName()));
		choiceC.setText(getResources().getIdentifier(choiceCId, "string",
				getPackageName()));
		choiceD.setText(getResources().getIdentifier(choiceDId, "string",
				getPackageName()));
	}

	private void setRootQuestion() {
		if (questionId == null) {
			Bundle gotBasket = getIntent().getExtras();
			questionId = gotBasket.getString("question");
		} else {
			if (counter <= getResources().getStringArray(R.array.atomquestions).length) {
				questionId = questionId.replaceAll("\\d", "") + counter;
			} else {
				Log.i("TAG", "NEW INTENT");
				// Intent a = new Intent(this,Questions.class);
				// startActivity(a);
			}
		}
		counter++;
	}

	private void initialize() {
		question = (TextView) findViewById(R.id.tvquestion);
		choiceA = (RadioButton) findViewById(R.id.rchoice0);
		choiceB = (RadioButton) findViewById(R.id.rchoice1);
		choiceC = (RadioButton) findViewById(R.id.rchoice2);
		choiceD = (RadioButton) findViewById(R.id.rchoice3);
		mcGroup = (RadioGroup) findViewById(R.id.rgmultichoice);
		mcGroup.setOnCheckedChangeListener(this);
		submit = (Button) findViewById(R.id.bsubmit);
		submit.setOnClickListener(this);
	}

	// Changes user choice
	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		switch (arg1) {
		case R.id.rchoice0:
			setChoice = choiceAId;
			break;
		case R.id.rchoice1:
			setChoice = choiceBId;
			break;
		case R.id.rchoice2:
			setChoice = choiceCId;
			break;
		case R.id.rchoice3:
			setChoice = choiceDId;
			break;
		}

	}

	// Handles the selection
	@Override
	public void onClick(View arg0) {

		if (setChoice == null) {
			new AlertDialog.Builder(this)
					.setTitle("You did not make a selection")
					.setMessage("Please select an option.")
					.setNegativeButton("OK", null).show();

		} else if (answer.equals(setChoice)) {
			new AlertDialog.Builder(this).setTitle("CORRECT")
					.setMessage("Your selection was correct!")
					.setNegativeButton("OK", null).show();
			NextInstance();
		} else {
			new AlertDialog.Builder(this).setTitle("Wrong")
					.setMessage(explanation).setNegativeButton("OK", null)
					.show();
			NextInstance();
		}
	}

	private void NextInstance() {
		// TODO Auto-generated method stub
		runProgram();
	}

}