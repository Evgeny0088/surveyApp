package com.example.surveyapp.service;

import com.example.surveyapp.Models.Author;
import com.example.surveyapp.Models.Survey;
import com.example.surveyapp.repositories.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class authorService {

    @Autowired
    private AuthorRepo authorRepo;

    public Author saveAuthor(String authorname){
        Author author = new Author();
        author.setAuthorname(authorname);
        authorRepo.save(author);
        return author;
    }
    public Optional<Author> findAuthor(Long authorId){
        return authorRepo.findById(authorId);
    }
}
