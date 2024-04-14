package com.hexagonal.tasks.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.hexagonal.tasks.domain.model.Tasks;

public interface TaskRepositoryPort {
    Tasks save(Tasks task);
    Optional<Tasks> findById(Long id);
    List<Tasks> findAll();
    Optional<Tasks> update(Tasks task);
    boolean deleteById(Long id);
}
