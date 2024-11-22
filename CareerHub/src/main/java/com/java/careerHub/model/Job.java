package com.java.careerHub.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;


public class Job {

   
    private int jobId;


    private Company company;

    private String jobTitle;

    private String jobDescription;

    private String jobLocation;

    private Double salary;

    private String jobType;

    private Date postedDate;

    private List<Application> applications;

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(double d) {
        this.salary = d;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    @Override
    public String toString() {
        return "Job Details:\n" +
               "--------------------------------------\n" +
               "Job ID         : " + jobId + "\n" +
               "Company        : " + company + "\n" +
               "Title          : " + jobTitle + "\n" +
               "Description    : " + (jobDescription != null ? jobDescription : "N/A") + "\n" +
               "Location       : " + (jobLocation != null ? jobLocation : "N/A") + "\n" +
               "Salary         : " + (salary != null ? salary : "N/A") + "\n" +
               "Type           : " + (jobType != null ? jobType : "N/A") + "\n" +
               "Posted Date    : " + postedDate + "\n" +
               "--------------------------------------";
    }



	
    
}
