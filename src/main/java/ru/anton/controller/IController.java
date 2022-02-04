package ru.anton.controller;

import org.springframework.web.bind.annotation.*;
import ru.anton.entity.IQuestion;
import ru.anton.repository.IQuestionRepo;

import java.util.List;

@RestController
@RequestMapping("/iquestion")
@CrossOrigin(origins = "http://localhost:8082/")
public class IController {
    private final IQuestionRepo iQuestionRepo;

    public IController(IQuestionRepo iQuestionRepo) {
        this.iQuestionRepo = iQuestionRepo;
    }

    @GetMapping
    public List<IQuestion> questions(){
        return iQuestionRepo.findAll();
    }

    @GetMapping("/{id}")
    public IQuestion getOne(@PathVariable("id") long id){
        return iQuestionRepo.findById(id);
    }
}
