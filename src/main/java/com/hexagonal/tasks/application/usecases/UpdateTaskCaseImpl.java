package com.hexagonal.tasks.application.usecases;

import java.util.Optional;

import com.hexagonal.tasks.domain.model.Tasks;
import com.hexagonal.tasks.domain.port.in.UpdateTaskUseCase;
import com.hexagonal.tasks.domain.port.out.TaskRepositoryPort;

public class UpdateTaskCaseImpl implements UpdateTaskUseCase{

    private TaskRepositoryPort taskRepositoryPort;

    public UpdateTaskCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Tasks> updateTask(Long id, Tasks updateTask) {
        return taskRepositoryPort.update(updateTask);
    }

}
