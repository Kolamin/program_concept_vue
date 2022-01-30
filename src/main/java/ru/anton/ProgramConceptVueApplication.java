package ru.anton;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.anton.entity.IQuestion;
import ru.anton.repository.IQuestionRepo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class ProgramConceptVueApplication  {

    public static void main(String[] args) {
        SpringApplication.run( ProgramConceptVueApplication.class, args );
    }

    @Bean

    public CommandLineRunner demo(IQuestionRepo iQuestionRepo) {

       return (args -> {
           ProgramConceptVueApplication obj = new ProgramConceptVueApplication();

           InputStream inputIndustrialQuestions = obj
                   .getClass()
                   .getClassLoader()
                   .getResourceAsStream( "static/A_1_tests.txt" );

           String[] temp = getArray( inputIndustrialQuestions );
           String[] arrayQuestion = Arrays.copyOfRange( temp, 1, temp.length );

            for (String s : arrayQuestion) {
                String[] split = s.split( "\\n" );
                int length = split.length;
                log.info( "Preload industrial question database " +
                        iQuestionRepo.save( new IQuestion( split[0],
                                Arrays.asList( Arrays.copyOfRange( split, 1, length ) ) ) ) );
            }
       });

    }

    private String[] getArray(InputStream inputStream) throws IOException {
        StringBuilder content;
        try (BufferedReader br = new BufferedReader( new InputStreamReader( inputStream ) )) {
            content = new StringBuilder();

            String st;

            while ((st = br.readLine()) != null) {
                content.append( st )
                        .append( "\n" );
            }
        }
        return content.toString()
                .split( "(\\d+\\.\\s)|(Вопрос \\d+)" );
    }
}
