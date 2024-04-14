package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.domain.model.Tasks;
import com.hexagonal.tasks.domain.port.in.CreateTaskUseCase;
import com.hexagonal.tasks.domain.port.out.TaskRepositoryPort;

public class CreateTaskUseCaseImpl implements CreateTaskUseCase{

    private final TaskRepositoryPort taskRepositoryPort;

    public CreateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Tasks createTask(Tasks task) {
        return taskRepositoryPort.save(task);
    }

}
