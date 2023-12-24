package questionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionClassImple implements QuestionService
{
	
	private QuestionRepository questionRepository;
	
	@Autowired
	public QuestionClassImple(QuestionRepository questionRepository)
	{
		this.questionRepository=questionRepository;
	}
	
	@Override
	public QuestionEntityClass add(QuestionEntityClass ec)
	{
		return questionRepository.save(ec);
	}

	@Override
	public List<QuestionEntityClass> get() 
	{
		return questionRepository.findAll();
	}

	@Override
	public QuestionEntityClass get(Long id) 
	{
		return questionRepository.findById(id).orElseThrow(()->new RuntimeException("Question not found"));
	}

	@Override
	public List<QuestionEntityClass> getQuestionsOfQuiz(Long quizId) 
	{
		return questionRepository.findByQuizId(quizId);
	}

}
