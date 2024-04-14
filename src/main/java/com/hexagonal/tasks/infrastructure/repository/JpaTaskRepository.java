package com.hexagonal.tasks.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexagonal.tasks.infrastructure.entity.TaskEntity;

@Repository
public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long>{

}
