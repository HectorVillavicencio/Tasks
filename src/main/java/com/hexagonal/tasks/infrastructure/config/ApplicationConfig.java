package com.hexagonal.tasks.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hexagonal.tasks.application.service.TaskService;
import com.hexagonal.tasks.application.usecases.CreateTaskUseCaseImpl;
import com.hexagonal.tasks.application.usecases.DeleteTaskUseCaseImpl;
import com.hexagonal.tasks.application.usecases.GetAdditionalTaskInfoUseCaseImpl;
import com.hexagonal.tasks.application.usecases.RetrieveTaskUseCaseImpl;
import com.hexagonal.tasks.application.usecases.UpdateTaskCaseImpl;
import com.hexagonal.tasks.domain.port.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.tasks.domain.port.out.ExternalServicePort;
import com.hexagonal.tasks.domain.port.out.TaskRepositoryPort;
import com.hexagonal.tasks.infrastructure.adapter.ExternalServiceAdapter;
import com.hexagonal.tasks.infrastructure.repository.JpaTaskRepositoryAdapter;

@Configuration
public class ApplicationConfig {

    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase){
        return new TaskService(
            new CreateTaskUseCaseImpl(taskRepositoryPort),
            new DeleteTaskUseCaseImpl(taskRepositoryPort),
            new UpdateTaskCaseImpl(taskRepositoryPort),
            new RetrieveTaskUseCaseImpl(taskRepositoryPort),
            getAdditionalTaskInfoUseCase
        );

    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter){
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort){
        return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort(){
        return new ExternalServiceAdapter();
    }

}
