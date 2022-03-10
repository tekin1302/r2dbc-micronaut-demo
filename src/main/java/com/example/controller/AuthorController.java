package com.example.controller;

import com.example.entity.Author;
import com.example.repository.AuthorRepository;
import io.micronaut.data.repository.jpa.criteria.PredicateSpecification;
import io.micronaut.data.repository.jpa.criteria.QuerySpecification;
import io.micronaut.http.annotation.*;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Controller("/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;

    @Get
    public Flux<Author> all() {
        return authorRepository.findAll();
    }

    @Get("/find-predicate")
    public Flux<Author> findWithPredicate() {
        PredicateSpecification<Author> predicateSpec = ((root, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), "John"));
        return authorRepository.findAll(predicateSpec);
    }
    @Get("/find-query")
    public Flux<Author> findWithQuery() {
        QuerySpecification<Author> querySpec = ((root, query, criteriaBuilder) -> query.)
        return authorRepository.findAll(querySpec);
    }

    @Get("/{id}")
    public Mono<Author> get(@PathVariable Long id) {
        return authorRepository.findById(id);
    }

    @Post
    public Mono<Author> save(@Body Author author) {
        return authorRepository.save(author);
    }
}
