package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.domain.port.in.DeleteTaskUseCase;
import com.hexagonal.tasks.domain.port.out.TaskRepositoryPort;

public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public DeleteTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public boolean deletTask(Long id) {
        return taskRepositoryPort.deleteById(id);
    } 

}
