package ru.anton.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.anton.entity.IQuestion;
import ru.anton.repository.IQuestionRepo;

import java.util.List;

@RestController
@RequestMapping("/iquestion")
public class IController {
    private final IQuestionRepo iQuestionRepo;

    public IController(IQuestionRepo iQuestionRepo) {
        this.iQuestionRepo = iQuestionRepo;
    }

    @GetMapping
    public List<IQuestion> questions(){
        return iQuestionRepo.findAll();
    }
}
