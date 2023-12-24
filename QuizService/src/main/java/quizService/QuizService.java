package quizService;


import java.util.List;

public interface QuizService 
{
    QuizEntityClass add(QuizEntityClass ec);
    
    List<QuizEntityClass> get();
    
    QuizEntityClass get(Long id);
    
}
