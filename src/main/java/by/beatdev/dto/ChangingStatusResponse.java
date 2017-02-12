package by.beatdev.dto;

import by.beatdev.entity.UserStatus;

import java.io.Serializable;

/**
 * Copyright © 2015-2017 JLife Systems. All rights reserved.
 *
 * @author Andrei Mozgo
 */
public class ChangingStatusResponse implements Serializable {
    private Integer id;
    private UserStatus previousStatus;
    private UserStatus newStatus;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserStatus getPreviousStatus() {
        return previousStatus;
    }

    public void setPreviousStatus(UserStatus previousStatus) {
        this.previousStatus = previousStatus;
    }

    public UserStatus getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(UserStatus newStatus) {
        this.newStatus = newStatus;
    }
}
