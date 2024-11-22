package com.java.careerHub.dao;

import com.java.careerHub.dao.CompanyDAO;
import com.java.careerHub.model.Job;
import com.java.careerHub.util.ConnectionHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAOImpl implements CompanyDAO {

	@Override
	public boolean postJob(int companyId, String jobTitle, String jobDescription, String jobLocation, double salary, String jobType) throws SQLException, ClassNotFoundException {
	    String sql = "INSERT INTO Jobs (CompanyID, JobTitle, JobDescription, JobLocation, Salary, JobType, PostedDate) " +
	                 "VALUES (?, ?, ?, ?, ?, ?, NOW())";
	    try (Connection connection = ConnectionHelper.getConnection();
	         PreparedStatement statement = connection.prepareStatement(sql)) {
	        statement.setInt(1, companyId);
	        statement.setString(2, jobTitle);
	        statement.setString(3, jobDescription);
	        statement.setString(4, jobLocation);
	        statement.setDouble(5, salary);
	        statement.setString(6, jobType);
	        
	        int rowsInserted = statement.executeUpdate();
	        return rowsInserted > 0;
	    }
	}


    @Override
    public List<Job> getJobs() throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM Jobs";
        List<Job> Jobs = new ArrayList<>();
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Job job = new Job();
                job.setJobId(resultSet.getInt("JobID"));
                job.setJobTitle(resultSet.getString("JobTitle"));
                job.setJobDescription(resultSet.getString("JobDescription"));
                job.setJobLocation(resultSet.getString("JobLocation"));
                job.setSalary(resultSet.getDouble("Salary"));
                job.setJobType(resultSet.getString("JobType"));
                job.setPostedDate(resultSet.getDate("PostedDate"));
                Jobs.add(job);
            }
        }
        return Jobs;
    }
}
