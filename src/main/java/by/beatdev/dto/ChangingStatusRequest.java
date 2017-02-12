package by.beatdev.dto;

import by.beatdev.entity.UserStatus;

import java.io.Serializable;

/**
 * Copyright © 2015-2017 JLife Systems. All rights reserved.
 *
 * @author Andrei Mozgo
 */
public class ChangingStatusRequest implements Serializable {
    private Integer id;
    private UserStatus newStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserStatus getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(UserStatus newStatus) {
        this.newStatus = newStatus;
    }
}
