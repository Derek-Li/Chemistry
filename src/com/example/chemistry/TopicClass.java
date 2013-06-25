package com.example.chemistry;

import android.os.Parcel;
import android.os.Parcelable;

public class TopicClass implements Parcelable {

	private String[] topic;
	private QuestionClass[] question;

	public TopicClass() {
	}

	public void setTopic(String[] topic) {
		this.topic = topic;
	}
	
	public void setQuestion(QuestionClass[] question) {
		this.question = question;
	}
	
	public String[] getTopic() {
		return topic;
	}

	public QuestionClass[] getQuestion() {
		return question;
	}

	public static Parcelable.Creator<TopicClass> getCreator() {
		return CREATOR;
	}

	protected TopicClass(Parcel in) {
		topic = in.createStringArray();
	}

	public int describeContents() {
		return 0;
	}

	public void writeToParcel(Parcel dest, int flags) {
		dest.writeStringArray(topic);
	}

	public static final Parcelable.Creator<TopicClass> CREATOR = new Parcelable.Creator<TopicClass>() {
		public TopicClass createFromParcel(Parcel in) {
			return new TopicClass(in);
		}

		public TopicClass[] newArray(int size) {
			return new TopicClass[size];
		}
	};
	
	
}