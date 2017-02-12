package by.beatdev.model;

/**
 * Copyright © 2015-2017 JLife Systems. All rights reserved.
 *
 * @author Andrei Mozgo
 */
public class ChangeStatusResponse {
    private Integer id;
    private String previousSatus;
    private String status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPreviousSatus() {
        return previousSatus;
    }

    public void setPreviousSatus(String previousSatus) {
        this.previousSatus = previousSatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
