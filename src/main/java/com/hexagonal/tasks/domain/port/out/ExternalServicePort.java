package com.hexagonal.tasks.domain.port.out;

import com.hexagonal.tasks.domain.model.AdditionalTaskInfo;

public interface ExternalServicePort {
    AdditionalTaskInfo getAdditionalTaskInfo(Long id);

}
