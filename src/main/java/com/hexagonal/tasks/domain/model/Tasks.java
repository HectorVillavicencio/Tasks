package com.hexagonal.tasks.domain.model;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tasks {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private boolean completed;


    public Tasks(Long id, String title, String description, LocalDateTime creationDate, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.completed = completed;
    }


}
