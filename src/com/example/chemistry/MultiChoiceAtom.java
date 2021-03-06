package com.example.chemistry;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MultiChoiceAtom extends ListActivity {

	String[] questions;
	String formatedQuestion;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		questions = getResources().getStringArray(R.array.atomquestions);
		setListAdapter(new ArrayAdapter<String>(MultiChoiceAtom.this,
				android.R.layout.simple_list_item_1, questions));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		Bundle basket = new Bundle();
		formatedQuestion = questions[position].replaceAll("\\s",""); 
		basket.putString("question", formatedQuestion.toLowerCase());
		Intent a = new Intent(this,Questions.class);
		a.putExtras(basket); 
		startActivity(a);

	}

}