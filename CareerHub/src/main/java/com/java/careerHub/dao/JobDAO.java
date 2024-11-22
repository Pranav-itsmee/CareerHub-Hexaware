package com.java.careerHub.dao;

import com.java.careerHub.model.Applicant;
import java.sql.SQLException;
import java.util.List;

public interface JobDAO {
	boolean apply(int applicantId, int jobId, String coverLetter) throws SQLException, ClassNotFoundException;
    List<Applicant> getApplicants(int jobId) throws SQLException, ClassNotFoundException;
    boolean applyForJob(int applicantId, int jobId, String coverLetter) throws SQLException, ClassNotFoundException;

}
