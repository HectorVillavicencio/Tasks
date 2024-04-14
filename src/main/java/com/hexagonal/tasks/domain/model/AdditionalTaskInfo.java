package com.hexagonal.tasks.domain.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AdditionalTaskInfo {
    private final Long userId;
    private final String userName;
    private final String userEmail;


    public AdditionalTaskInfo(Long userId, String userName, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
    }
}
