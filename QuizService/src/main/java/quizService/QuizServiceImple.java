package quizService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImple implements QuizService {

    private  QuizRepository quizRepository;
    
    private QuestionCommunicationFeignClient quesComm;
    
    @Autowired
    public QuizServiceImple(QuizRepository quizRepository, QuestionCommunicationFeignClient quesComm) 
    {
        this.quizRepository = quizRepository;
        this.quesComm=quesComm;
    }

    @Override
    public QuizEntityClass add(QuizEntityClass ec) {
        return quizRepository.save(ec);
    }

//    @Override
//    public List<QuizEntityClass> get()
//    {
//        return quizRepository.findAll();
//    }
    
    public List<QuizEntityClass> get()
    {
    	List<QuizEntityClass> quizzes=quizRepository.findAll();
    	
    	List<QuizEntityClass> newQuizList=quizzes.stream().map(quiz -> 
    	{
    		quiz.setQuestions(quesComm.getQuestionOfQuiz(quiz.getId()));
    		return quiz;
    	}).collect(Collectors.toList());
    	
    	return newQuizList;
    }
    
   

//    @Override
//    public QuizEntityClass get(Long id)
//    {
//       return quizRepository .findById(id).orElseThrow(() -> new RuntimeException("Entity not found with id: " + id));
//    }
    
    public QuizEntityClass get(Long id)
    {
    	QuizEntityClass quiz=quizRepository .findById(id).orElseThrow(() -> new RuntimeException("Entity not found with id: " + id));
    	quiz.setQuestions(quesComm.getQuestionOfQuiz(quiz.getId()));
    	return quiz;
    }

}