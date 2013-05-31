package com.example.chemistry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
		
		Bundle basket = new Bundle();
		Intent a;	
		switch (v.getId()) {
		case R.id.atoms:
			basket.putString("topic", atom.getText().toString());
			break;
		case R.id.colligative:
			basket.putString("topic", getString(R.id.colligative));
			break;
		case R.id.acid:
			basket.putString("topic", getString( R.id.acid));
			break;
		case R.id.organic:
			basket.putString("topic", getString(R.id.organic));
			break;
		}
		a = new Intent(this,MultiChoice.class);
		a.putExtras(basket); 
		startActivity(a);
	}
}
