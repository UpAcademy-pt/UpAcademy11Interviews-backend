package models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQuery(name=Question.GET_ALL_QUESTIONS_QUERY, query="SELECT q FROM Question q")
@NamedQuery(name=Question.GET_ALL_QUESTIONS_ID_QUERY, query="SELECT q.id FROM Question q")
@NamedQuery(name=Question.GET_QUESTION_BY_NAME_QUERY, query="SELECT q FROM Question q WHERE q.question = :name")

public class Question extends GenericEntity {

	private static final long serialVersionUID = 1L;
	
	public static final String GET_ALL_QUESTIONS_QUERY = "Question.getAllEntity";
	public static final String GET_ALL_QUESTIONS_ID_QUERY = "Question.getAllQuestionsId";
	public static final String GET_QUESTION_BY_NAME_QUERY = "Question.getQuestionByName";

	
	@OneToMany
	private Collection<Attribute> attributes;
	private String question;
	private String answer;

	public Question() {
		
	}
	

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
