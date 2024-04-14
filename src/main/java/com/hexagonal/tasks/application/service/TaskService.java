package com.hexagonal.tasks.application.service;

import java.util.List;
import java.util.Optional;

import com.hexagonal.tasks.domain.model.AdditionalTaskInfo;
import com.hexagonal.tasks.domain.model.Tasks;
import com.hexagonal.tasks.domain.port.in.CreateTaskUseCase;
import com.hexagonal.tasks.domain.port.in.DeleteTaskUseCase;
import com.hexagonal.tasks.domain.port.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.tasks.domain.port.in.RetrieveTaskUseCase;
import com.hexagonal.tasks.domain.port.in.UpdateTaskUseCase;

public class TaskService implements CreateTaskUseCase, DeleteTaskUseCase,UpdateTaskUseCase,RetrieveTaskUseCase,GetAdditionalTaskInfoUseCase{


    private final CreateTaskUseCase createTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final RetrieveTaskUseCase retrieveTaskUseCase;
    private final GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;


    public TaskService(CreateTaskUseCase createTaskUseCase, DeleteTaskUseCase deleteTaskUseCase,
            UpdateTaskUseCase updateTaskUseCase, RetrieveTaskUseCase retrieveTaskUseCase,
            GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
        this.retrieveTaskUseCase = retrieveTaskUseCase;
        this.getAdditionalTaskInfoUseCase = getAdditionalTaskInfoUseCase;
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return getAdditionalTaskInfoUseCase.getAdditionalTaskInfo(id);
    }

    @Override
    public Optional<Tasks> getTask(Long id) {
        return retrieveTaskUseCase.getTask(id);
    }

    @Override
    public List<Tasks> getAllTask() {
        return retrieveTaskUseCase.getAllTask();
    }

    @Override
    public Optional<Tasks> updateTask(Long id, Tasks updateTask) {
        return updateTaskUseCase.updateTask(id, updateTask);
    }

    @Override
    public boolean deletTask(Long id) {
        return deleteTaskUseCase.deletTask(id);
    }

    @Override
    public Tasks createTask(Tasks task) {
        return createTaskUseCase.createTask(task);
    }


}
