package com.example.chemistry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Topics extends Activity implements View.OnClickListener {

	Button atom, colligative, acid, organic;

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
			startActivity(new Intent("com.example.chemistry.MultiChoiceAtom"));
			break;
		case R.id.colligative:
			startActivity(new Intent("com.example.chemistry.MultiChoiceColl"));
			break;
		case R.id.acid:
			startActivity(new Intent("com.example.chemistry.MultiChoiceAcid"));
			break;
		case R.id.organic:
			startActivity(new Intent("com.example.chemistry.MultiChoiceOrg"));
			break;
		}
	}
}
