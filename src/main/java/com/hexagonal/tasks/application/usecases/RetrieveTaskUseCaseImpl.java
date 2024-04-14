package com.hexagonal.tasks.application.usecases;

import java.util.List;
import java.util.Optional;

import com.hexagonal.tasks.domain.model.Tasks;
import com.hexagonal.tasks.domain.port.in.RetrieveTaskUseCase;
import com.hexagonal.tasks.domain.port.out.TaskRepositoryPort;

public class RetrieveTaskUseCaseImpl implements RetrieveTaskUseCase{

    private final TaskRepositoryPort taskRepositoryPort;

    public RetrieveTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Tasks> getTask(Long id) {
        return taskRepositoryPort.findById(id);
    }

    @Override
    public List<Tasks> getAllTask() {
        return taskRepositoryPort.findAll();
    }

}
