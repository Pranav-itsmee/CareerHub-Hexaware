package com.java.careerHub.dao;

import com.java.careerHub.model.Applicant;

import java.sql.SQLException;

public interface ApplicantDAO {
    Applicant createProfile(String email, String firstName, String lastName, String phone) throws SQLException, ClassNotFoundException;
    boolean applyForJob(int applicantId, int jobId, String coverLetter) throws SQLException, ClassNotFoundException;
	Applicant getProfile(int applicantId) throws ClassNotFoundException;
}
