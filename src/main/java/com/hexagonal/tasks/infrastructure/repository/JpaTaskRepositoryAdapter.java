package com.hexagonal.tasks.infrastructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.hexagonal.tasks.domain.model.Tasks;
import com.hexagonal.tasks.domain.port.out.TaskRepositoryPort;
import com.hexagonal.tasks.infrastructure.entity.TaskEntity;

@Component
public class JpaTaskRepositoryAdapter implements TaskRepositoryPort{
    
    private final JpaTaskRepository jpaTaskRepository;

    public JpaTaskRepositoryAdapter(JpaTaskRepository jpaTaskRepository) {
        this.jpaTaskRepository = jpaTaskRepository;
    }

    @Override
    public Tasks save(Tasks task) {
       TaskEntity taskEntity = TaskEntity.fromDomianModel(task);
       TaskEntity savedTaskEntity = jpaTaskRepository.save(taskEntity);
       return savedTaskEntity.toDomainModel();
    }

    @Override
    public Optional<Tasks> findById(Long id) {
        return jpaTaskRepository.findById(id).map(TaskEntity::toDomainModel);
    }

    @Override
    public List<Tasks> findAll() {
       return  jpaTaskRepository.findAll().stream()
                .map(TaskEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Tasks> update(Tasks task) {
        if(jpaTaskRepository.existsById(task.getId())){
            TaskEntity taskEntity = TaskEntity.fromDomianModel(task);
            TaskEntity updateTaskEntity = jpaTaskRepository.save(taskEntity);
            return Optional.of(updateTaskEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if(jpaTaskRepository.existsById(id)){
            jpaTaskRepository.deleteById(id);
            return true;
        }
        return false;
    }


  


}
