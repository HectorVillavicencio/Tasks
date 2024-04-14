package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.domain.model.AdditionalTaskInfo;
import com.hexagonal.tasks.domain.port.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.tasks.domain.port.out.ExternalServicePort;

public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase{

    private final ExternalServicePort externalServicePort;

    public GetAdditionalTaskInfoUseCaseImpl(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return externalServicePort.getAdditionalTaskInfo(id);
    }


}
