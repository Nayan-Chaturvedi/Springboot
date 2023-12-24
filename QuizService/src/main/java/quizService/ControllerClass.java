package quizService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class ControllerClass {

    private final QuizService quizService;

    @Autowired
    public ControllerClass(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public String create(@RequestBody QuizEntityClass ec) {
        quizService.add(ec);
        return "True";
    }

    @GetMapping
    public List<QuizEntityClass> get() {
        return quizService.get();
    }

    @GetMapping("/{id}")
    public QuizEntityClass getById(@PathVariable Long id) {
        return quizService.get(id);
    }
}