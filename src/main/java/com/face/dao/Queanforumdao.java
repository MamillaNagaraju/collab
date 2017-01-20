package com.face.dao;

import java.util.List;

import com.face.model.Queanforum;

public interface Queanforumdao {
	void addQuestion(Queanforum forum);
	List<Queanforum> viewQuestions();
	void updateQuestion(Queanforum forum);
	void deleteQuestion(int qid);
	Queanforum getQuestion(int qid);

}