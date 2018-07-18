package com.greensize.develop.reportgenerator.entity;

import com.greensize.develop.reportgenerator.util.Actividad;
import com.greensize.develop.reportgenerator.util.Cliente;
import com.greensize.develop.reportgenerator.util.TipoHorario;

import java.util.Date;

/**
 * Created by greensize-backend on 18/7/2018.
 */
public class ReportRow {

    private Integer number;
    private String resource;
    private Cliente client;
    private String project;
    private Actividad activity;
    private Date dateBegin;
    private Date dateEnd;
    private Integer activeHours;
    private Date date;
    private String description;
    private TipoHorario scheduleType;

    public ReportRow(Integer number, String resource, Cliente client, String project, Actividad activity, Date dateBegin,
                        Date dateEnd, Integer activeHours, Date date, String description, TipoHorario scheduleType) {
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

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Actividad getActivity() {
        return activity;
    }

    public void setActivity(Actividad activity) {
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

    public TipoHorario getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(TipoHorario scheduleType) {
        this.scheduleType = scheduleType;
    }
}