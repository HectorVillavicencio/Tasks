package com.hexagonal.tasks.domain.port.in;

import java.util.List;
import java.util.Optional;


import com.hexagonal.tasks.domain.model.Tasks;

public interface RetrieveTaskUseCase {
    Optional<Tasks> getTask(Long id);
    List<Tasks> getAllTask();
}
