package com.hexagonal.tasks.infrastructure.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Id;

import com.hexagonal.tasks.domain.model.Tasks;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime creationDate;
    private boolean completed;

    public TaskEntity(){
    }

    public TaskEntity(Long id, String title, String description, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = LocalDateTime.now();
        this.completed = completed;
    }

    public static TaskEntity fromDomianModel(Tasks task){
        return new TaskEntity(task.getId(), task.getTitle(),task.getDescription(),task.isCompleted());
    }

    public Tasks toDomainModel(){
        return new Tasks(id, title, description, creationDate, completed);
    }

    
 

}
