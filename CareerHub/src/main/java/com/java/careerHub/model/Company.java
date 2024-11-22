package com.java.careerHub.model;

import java.util.List;

public class Company {

    
    private int companyId;

    private String companyName;

    private String location;

    private List<Job> jobs;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    @Override
    public String toString() {
        return "Company Details:\n" +
               "--------------------------------------\n" +
               "Company ID   : " + companyId + "\n" +
               "Name         : " + companyName + "\n" +
               "Location     : " + location + "\n" +
               "--------------------------------------";
    }


    
}
