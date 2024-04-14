package com.hexagonal.tasks.domain.port.in;


import com.hexagonal.tasks.domain.model.Tasks;

public interface CreateTaskUseCase {
    Tasks createTask(Tasks task);

}
