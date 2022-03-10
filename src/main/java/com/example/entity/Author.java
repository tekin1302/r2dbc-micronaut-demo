package com.example.entity;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import lombok.Data;

@Data
@MappedEntity
public class Author {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

}
