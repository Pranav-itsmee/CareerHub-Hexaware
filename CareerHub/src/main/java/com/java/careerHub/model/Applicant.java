package com.java.careerHub.model;

import java.util.List;


public class Applicant {

   
    private int applicantId;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String resume;

    private List<Application> applications;

    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

	
    @Override
    public String toString() {
        return "Applicant Profile:\n" +
               "--------------------------------------\n" +
               "Applicant ID : " + applicantId + "\n" +
               "First Name   : " + firstName + "\n" +
               "Last Name    : " + lastName + "\n" +
               "Email        : " + email + "\n" +
               "Phone        : " + (phone != null ? phone : "N/A") + "\n" +
               "Resume       : " + (resume != null ? "Available" : "Not Uploaded") + "\n" +
               "--------------------------------------";
    }


    
}
