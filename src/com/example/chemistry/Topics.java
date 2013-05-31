package com.example.chemistry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Topics extends Activity implements View.OnClickListener {

	Button atom, periodic, bonding, formulas;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.topics);

		atom = (Button) findViewById(R.id.atoms);
		periodic = (Button) findViewById(R.id.periodic_table);
		bonding = (Button) findViewById(R.id.bonding);
		formulas = (Button) findViewById(R.id.formulasequations);

		atom.setOnClickListener(this);
		periodic.setOnClickListener(this);
		bonding.setOnClickListener(this);
		formulas.setOnClickListener(this);
		
		
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.atoms:
			startActivity(new Intent("com.example.chemistry.MultiChoiceAtom"));
			break;
		case R.id.periodic_table:
			startActivity(new Intent("com.example.chemistry.PeriodicTable"));
			break;
		case R.id.bonding:
			startActivity(new Intent("com.example.chemistry.Bonding"));
			break;
		case R.id.formulasequations:
			startActivity(new Intent("com.example.chemistry.FormulasEquations"));
			break;
		}
	}
}
