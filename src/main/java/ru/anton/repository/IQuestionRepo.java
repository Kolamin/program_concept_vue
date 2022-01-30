package ru.anton.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anton.entity.IQuestion;

public interface IQuestionRepo extends JpaRepository  <IQuestion, Long>{
    IQuestion findById(long id);
}
