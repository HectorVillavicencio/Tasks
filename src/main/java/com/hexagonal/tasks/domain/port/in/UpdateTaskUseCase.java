package com.hexagonal.tasks.domain.port.in;

import java.util.Optional;



import com.hexagonal.tasks.domain.model.Tasks;

public interface UpdateTaskUseCase {
    Optional<Tasks> updateTask(Long id, Tasks updateTask);

}
