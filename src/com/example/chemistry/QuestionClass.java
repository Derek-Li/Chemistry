package com.example.chemistry;

import android.os.Parcel;
import android.os.Parcelable;

public class QuestionClass implements Parcelable{
	private String questionTitle;
	private String question;
	private String answer;
	private String explanation;
	private String choiceA;
	private String choiceB;
	private String choiceC;
	private String choiceD;
	
	public QuestionClass(String questionTitle, String question, String answer,
			String explanation, String choiceA, String choiceB, String choiceC,
			String choiceD) {
		super();
		this.questionTitle = questionTitle;
		this.question = question;
		this.answer = answer;
		this.explanation = explanation;
		this.choiceA = choiceA;
		this.choiceB = choiceB;
		this.choiceC = choiceC;
		this.choiceD = choiceD;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}

	public String getExplanation() {
		return explanation;
	}

	public String getChoiceA() {
		return choiceA;
	}

	public String getChoiceB() {
		return choiceB;
	}

	public String getChoiceC() {
		return choiceC;
	}

	public String getChoiceD() {
		return choiceD;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public void setChoiceA(String choiceA) {
		this.choiceA = choiceA;
	}

	public void setChoiceB(String choiceB) {
		this.choiceB = choiceB;
	}

	public void setChoiceC(String choiceC) {
		this.choiceC = choiceC;
	}

	public void setChoiceD(String choiceD) {
		this.choiceD = choiceD;
	}
	
	public static Parcelable.Creator<QuestionClass> getCreator() {
		return CREATOR;
	}

	protected QuestionClass(Parcel in) {
		questionTitle = in.readString();
		question = in.readString();
		answer = in.readString();
		explanation = in.readString();
		choiceA = in.readString();
		choiceB = in.readString();
		choiceC = in.readString();
		choiceD = in.readString();
	}

	public int describeContents() {
		return 0;
	}

	public void readFromParcel(Parcel in) {
		questionTitle = in.readString();
		question = in.readString();
		answer = in.readString();
		explanation = in.readString();
		choiceA = in.readString();
		choiceB = in.readString();
		choiceC = in.readString();
		choiceD = in.readString();
	}
	
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(questionTitle);
		dest.writeString(question);
		dest.writeString(answer);
		dest.writeString(explanation);
		dest.writeString(questionTitle);
		dest.writeString(choiceA);
		dest.writeString(choiceB);
		dest.writeString(choiceC);
		dest.writeString(choiceD);
	}

	public static final Parcelable.Creator<QuestionClass> CREATOR = new Parcelable.Creator<QuestionClass>() {
		public QuestionClass createFromParcel(Parcel in) {
			return new QuestionClass(in);
		}

		public QuestionClass[] newArray(int size) {
			return new QuestionClass[size];
		}
	};
	
	
}
