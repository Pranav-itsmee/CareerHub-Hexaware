package com.java.careerHub.dao;


import java.sql.SQLException;
import java.util.List;

import com.java.careerHub.model.Job;

public interface CompanyDAO {
    List<Job> getJobs() throws SQLException, ClassNotFoundException;
	boolean postJob(int companyId, String jobTitle, String jobDescription, String jobLocation, double salary,
			String jobType) throws SQLException, ClassNotFoundException;
}
