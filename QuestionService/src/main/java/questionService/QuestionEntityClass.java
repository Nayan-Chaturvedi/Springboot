package questionService;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class QuestionEntityClass 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long questionId;
	private String question;
	private Long quizId;
	
	public Long getQuizId()
	{
		return quizId;
	}



	public void setQuizId(Long quizId) 
	{
		this.quizId = quizId;
	}

	public Long getQuestionId() 
	{
		return questionId;
	}
	
	public void setQuestionId(Long questionId) 
	{
		this.questionId = questionId;
	}
	
	public String getQuestion() 
	{
		return question;
	}
	
	public void setQuestion(String question)
	{
		this.question = question;
	}

	public QuestionEntityClass() 
	{
		super();
	}

	public QuestionEntityClass(Long questionId, String question, Long quizId) 
	{
		super();
		this.questionId = questionId;
		this.question = question;
		this.quizId = quizId;
	}
	
	
	
}
