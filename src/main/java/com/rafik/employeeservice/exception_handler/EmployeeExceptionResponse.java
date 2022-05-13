package com.rafik.employeeservice.exception_handler;

import java.util.Date;

public class EmployeeExceptionResponse {
    private String errorMessage,description;
    private Date dateAndTime;

    public EmployeeExceptionResponse(String errorMessage, String description, Date dateAndTime) {
        this.errorMessage = errorMessage;
        this.description = description;
        this.dateAndTime = dateAndTime;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    @Override
    public String toString() {
        return "EmployeeExceptionResponse{" +
                "errorMessage='" + errorMessage + '\'' +
                ", description='" + description + '\'' +
                ", dateAndTime=" + dateAndTime +
                '}';
    }
}
