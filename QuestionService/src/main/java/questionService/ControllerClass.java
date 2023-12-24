package questionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class ControllerClass
{
	private QuestionService questionService;
	
	@Autowired
	public ControllerClass(QuestionService questionService)
	{
		this.questionService=questionService;
	}
	
	@PostMapping
	public QuestionEntityClass create(@RequestBody QuestionEntityClass ec)
	{
		return questionService.add(ec);
	}
	
	@GetMapping
	public List<QuestionEntityClass> get()
	{
		return questionService.get();
	}
	
	@GetMapping("/{id}")
	public QuestionEntityClass getOne(@PathVariable Long id)
	{
		return questionService.get(id);
	}
	
	// get all question of specific quiz
	
	@GetMapping("/quiz/{quizId}")
	public List<QuestionEntityClass> getOuestionsOfQuiz(@PathVariable Long quizId)
	{
		return questionService.getQuestionsOfQuiz(quizId);
	}
	{
		
	}
}
