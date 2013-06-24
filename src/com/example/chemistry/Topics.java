package com.example.chemistry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Topics extends Activity implements View.OnClickListener {

	Button atom, colligative, acid, organic;
	Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.topics);

		atom = (Button) findViewById(R.id.atoms);
		colligative = (Button) findViewById(R.id.colligative);
		acid = (Button) findViewById(R.id.acid);
		organic = (Button) findViewById(R.id.organic);

		atom.setOnClickListener(this);
		colligative.setOnClickListener(this);
		acid.setOnClickListener(this);
		organic.setOnClickListener(this);
	
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.atoms:
			MultipleChoiceClass atom = new MultipleChoiceClass(
					"atoms",
					getResources().getStringArray(R.array.atomTitleQuestion),
					getResources().getStringArray(R.array.atomQuestion),
					getResources().getStringArray(R.array.atomAnswer),
					getResources().getStringArray(R.array.atomExplaination),	
					getResources().getStringArray(R.array.atomChoiceA),
					getResources().getStringArray(R.array.atomChoiceB),
					getResources().getStringArray(R.array.atomChoiceC),
					getResources().getStringArray(R.array.atomChoiceD));
	
			//Sets up intent to pass MultipleChoiceClass to next Activity
			intent = new Intent(this,QuestionList.class);
			intent.putExtra("topic", atom);
			startActivity(intent);
			break;
		case R.id.colligative:
			MultipleChoiceClass colligative = new MultipleChoiceClass(
					"colligative",
					getResources().getStringArray(R.array.collTitleQuestion),
					getResources().getStringArray(R.array.collQuestion),
					getResources().getStringArray(R.array.collAnswer),
					getResources().getStringArray(R.array.collExplaination),	
					getResources().getStringArray(R.array.collChoiceA),
					getResources().getStringArray(R.array.collChoiceB),
					getResources().getStringArray(R.array.collChoiceC),
					getResources().getStringArray(R.array.collChoiceD));
	
			//Sets up intent to pass MultipleChoiceClass to next Activity
			intent = new Intent(this,QuestionList.class);
			intent.putExtra("topic", colligative);
			startActivity(intent);
			break;
		case R.id.acid:
			MultipleChoiceClass acid = new MultipleChoiceClass(
					"acid",
					getResources().getStringArray(R.array.acidTitleQuestion),
					getResources().getStringArray(R.array.acidQuestion),
					getResources().getStringArray(R.array.acidAnswer),
					getResources().getStringArray(R.array.acidExplaination),	
					getResources().getStringArray(R.array.acidChoiceA),
					getResources().getStringArray(R.array.acidChoiceB),
					getResources().getStringArray(R.array.acidChoiceC),
					getResources().getStringArray(R.array.acidChoiceD));
	
			//Sets up intent to pass MultipleChoiceClass to next Activity
			intent = new Intent(this,QuestionList.class);
			intent.putExtra("topic", acid);
			startActivity(intent);
			break;
		case R.id.organic:
			MultipleChoiceClass organic = new MultipleChoiceClass(
					"organic",
					getResources().getStringArray(R.array.orgTitleQuestion),
					getResources().getStringArray(R.array.orgQuestion),
					getResources().getStringArray(R.array.orgAnswer),
					getResources().getStringArray(R.array.orgExplaination),	
					getResources().getStringArray(R.array.orgChoiceA),
					getResources().getStringArray(R.array.orgChoiceB),
					getResources().getStringArray(R.array.orgChoiceC),
					getResources().getStringArray(R.array.orgChoiceD));
	
			//Sets up intent to pass MultipleChoiceClass to next Activity
			intent = new Intent(this,QuestionList.class);
			intent.putExtra("topic", organic);
			startActivity(intent);
			break;
		}
	}
}
