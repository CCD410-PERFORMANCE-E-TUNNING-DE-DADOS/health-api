package com.healthapi.health_api.domain;

import org.springframework.data.annotation.Id;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class Schedule implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String scheduleId;
    private Date scheduleBeginingDate;
    private Date scheduleEndingDate;

    public Schedule(String scheduleId, Date scheduleBeginingDate, Date scheduleEndingDate) {
        this.scheduleId = scheduleId;
        this.scheduleBeginingDate = scheduleBeginingDate;
        this.scheduleEndingDate = scheduleEndingDate;
    }

    public Schedule() {}

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Date getScheduleBeginingDate() {
        return scheduleBeginingDate;
    }

    public void setScheduleBeginingDate(Date scheduleBeginingDate) {
        this.scheduleBeginingDate = scheduleBeginingDate;
    }

    public Date getScheduleEndingDate() {
        return scheduleEndingDate;
    }

    public void setScheduleEndingDate(Date scheduleEndingDate) {
        this.scheduleEndingDate = scheduleEndingDate;
    }


}
