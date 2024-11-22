package com.java.careerHub.model;

import java.time.LocalDateTime;


public class Application {


    private int applicationId;

    private Job job;

    private Applicant applicant;

    private LocalDateTime applicationDate;

    private String coverLetter;

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public LocalDateTime getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDateTime applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

	
    @Override
    public String toString() {
        return "Application Details:\n" +
               "--------------------------------------\n" +
               "Application ID : " + applicationId + "\n" +
               "Job            : " + job + "\n" +
               "Applicant ID   : " + applicant + "\n" +
               "Application Date : " + applicationDate + "\n" +
               "Cover Letter   : " + (coverLetter != null ? coverLetter : "N/A") + "\n" +
               "--------------------------------------";
    }


    
}
