package com.vmware.springboot.modle;

import java.io.Serializable;

public class Supplier implements Serializable {

    private int id;

    private String projectName;

    private String bu;

    private String skillset;

    private String feedback;

    private int overall;

    private int performance;

    private int addedValue;

    private int usd;

    private String comments;

    private int onbordingTime;

    private String location;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getBu() {
        return bu;
    }

    public void setBu(String bu) {
        this.bu = bu;
    }

    public String getSkillset() {
        return skillset;
    }

    public void setSkillset(String skillset) {
        this.skillset = skillset;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getOverall() {
        return overall;
    }

    public void setOverall(int overall) {
        this.overall = overall;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public int getAddedValue() {
        return addedValue;
    }

    public void setAddedValue(int addedValue) {
        this.addedValue = addedValue;
    }

    public int getUsd() {
        return usd;
    }

    public void setUsd(int usd) {
        this.usd = usd;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getOnbordingTime() {
        return onbordingTime;
    }

    public void setOnbordingTime(int onbordingTime) {
        this.onbordingTime = onbordingTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
