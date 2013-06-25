package com.example.chemistry;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class QuestionList extends ListActivity {
	QuestionClass topic; 
	int topicPosition;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Gets the extra data from previous activity
		Intent intent = getIntent();
		
		topic = (QuestionClass) intent
				.getParcelableExtra("topic");
		topicPosition = intent.getIntExtra("topicPosition", 0);
		
		
		
		//Creates a list adapter of questions
		setListAdapter(new ArrayAdapter<String>(QuestionList.this,
				android.R.layout.simple_list_item_1, topic.getQuestionTitleArray()));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
	
		Intent intentToOpenQuestionPage = new Intent(this,QuestionPage.class);
		intentToOpenQuestionPage.putExtra("topic", topic);
		intentToOpenQuestionPage.putExtra("questionPosition", position);
		startActivity(intentToOpenQuestionPage);
	}

}