//*****************************************************
// by: Michael Ang
// Current Problems
// Need to clear garbage files when back buttoned
//*****************************************************
package com.example.chemistry;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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

public class QuestionPage extends Activity implements OnCheckedChangeListener,
		OnClickListener {
	TextView question;
	Button submit;

	int position;
	int selectedAnswer = 4;

	String questionId, choiceAId, choiceBId, choiceCId, choiceDId, answerId,
			explanationId, explanation, answer;
	RadioButton choiceA, choiceB, choiceC, choiceD;
	RadioGroup mcGroup;
	int counter = 1;

	MultipleChoiceClass topic;
	Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.questions_activity);

		intent = getIntent();
		position = intent.getIntExtra("questionPosition", 0);

		initialize();
		setValueId();
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

	// Assigns new Values
	private void setValueId() {

		topic = (MultipleChoiceClass) intent.getParcelableExtra("topic");

		// Sets up the string names to be fetches
		question.setText(topic.getQuestion()[position]);
		answer = topic.getAnswer()[position];
		explanation = topic.getExplanation()[position];

		choiceA.setText(topic.getChoiceA()[position]);
		choiceB.setText(topic.getChoiceB()[position]);
		choiceC.setText(topic.getChoiceC()[position]);
		choiceD.setText(topic.getChoiceD()[position]);

	}

	// Changes user choice
	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		switch (arg1) {
		case R.id.rchoice0:
			selectedAnswer = 0;
			break;
		case R.id.rchoice1:
			selectedAnswer = 1;
			break;
		case R.id.rchoice2:
			selectedAnswer = 2;
			break;
		case R.id.rchoice3:
			selectedAnswer = 3;
			break;
		}

	}

	// Handles the selection
	@Override
	public void onClick(View arg0) {

		if (selectedAnswer == 4) {
			new AlertDialog.Builder(this)
					.setTitle("You did not make a selection")
					.setMessage("Please select an option.")
					.setNegativeButton("OK", null).show();
		} else if (selectedAnswer == Integer.parseInt(answer)) {
			new AlertDialog.Builder(this)
					.setTitle("CORRECT")
					.setMessage("Your selection was correct!")
					.setNegativeButton("OK",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface x, int y) {
									position++;
									if (position < topic.getQuestion().length) {
										Log.e("Position",
												Integer.toString(position));
										Log.e("length", Integer.toString(topic
												.getQuestion().length));
										setValueId();
									} else {
										Log.e("Start", "NEW ACTIVITY");
										startActivity(new Intent(
												"com.example.chemistry.Topics"));
									}
								}
							}).show();
		} else {
			new AlertDialog.Builder(this)
					.setTitle("Wrong")
					.setMessage(explanation)
					.setNegativeButton("OK",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface x, int y) {
									position++;
									if (position < topic.getQuestion().length) {
										setValueId();
									} else {
										startActivity(new Intent(
												"com.example.chemistry.Topics"));
									}
								}
							}).show();
		}
	}
}