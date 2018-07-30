package com.greensize.develop.reportgenerator.entity;

import com.greensize.develop.reportgenerator.util.enums.Activity;
import com.greensize.develop.reportgenerator.util.enums.Client;
import com.greensize.develop.reportgenerator.util.enums.ScheduleType;

import java.util.Date;

/**
 * Created by greensize-backend on 18/7/2018.
 */
public class ReportRow {

    private Integer number;
    private String resource;
    private Client client;
    private String project;
    private Activity activity;
    private Date dateBegin;
    private Date dateEnd;
    private Integer activeHours;
    private Date date;
    private String description;
    private ScheduleType scheduleType;
    private String fortnightNumber;

    public ReportRow(Integer number, String resource, Client client, String project, Activity activity, Date dateBegin,
                     Date dateEnd, Integer activeHours, Date date, String description, ScheduleType scheduleType, String fortnightNumber) {
        this.number = number;
        this.resource = resource;
        this.client = client;
        this.project = project;
        this.activity = activity;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.activeHours = activeHours;
        this.date = date;
        this.description = description;
        this.scheduleType = scheduleType;
        this.fortnightNumber = fortnightNumber;
    }

    public ReportRow() {
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Integer getActiveHours() {
        return activeHours;
    }

    public void setActiveHours(Integer activeHours) {
        this.activeHours = activeHours;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ScheduleType getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(ScheduleType scheduleType) {
        this.scheduleType = scheduleType;
    }

    public String getFortnightNumber() {
        return fortnightNumber;
    }

    public void setFortnightNumber(String fortnightNumber) {
        this.fortnightNumber = fortnightNumber;
    }
}