package com.example.chemistry;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MultiChoice extends ListActivity {

	String[] questions;
	String formatedQuestion,topicId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle gotBasket = getIntent().getExtras();
		topicId = gotBasket.getString("topic").replaceAll("\\s","").toLowerCase();
		questions = getResources().getStringArray(getResources().getIdentifier(topicId, "array", getPackageName()));
		setListAdapter(new ArrayAdapter<String>(MultiChoice.this,android.R.layout.simple_list_item_1, questions));	
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		Bundle basket = new Bundle();
		formatedQuestion = topicId + questions[position].replaceAll("\\s",""); 
		basket.putString("question", formatedQuestion.toLowerCase());
		Intent a = new Intent(this,Questions.class);
		a.putExtras(basket); 
		startActivity(a);

	}

}