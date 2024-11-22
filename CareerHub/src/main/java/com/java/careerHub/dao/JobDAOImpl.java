package com.java.careerHub.dao;

import com.java.careerHub.dao.JobDAO;
import com.java.careerHub.model.Applicant;
import com.java.careerHub.util.ConnectionHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobDAOImpl implements JobDAO {

	@Override
	public boolean apply(int applicantId, int jobId, String coverLetter) throws SQLException, ClassNotFoundException {
	    String query = "INSERT INTO Applications (ApplicantID, JobID, CoverLetter, ApplicationDate) VALUES (?, ?, ?, NOW())";
	    try (Connection connection = ConnectionHelper.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	        preparedStatement.setInt(1, applicantId);
	        preparedStatement.setInt(2, jobId);
	        preparedStatement.setString(3, coverLetter);

	        return preparedStatement.executeUpdate() > 0;
	    }
	}


    @Override
    public List<Applicant> getApplicants(int jobId) throws SQLException, ClassNotFoundException {
        String query = "SELECT a.ApplicantID, a.FirstName, a.LastName, a.Email, a.Phone FROM Applicants a " +
                "JOIN Applications ap ON a.ApplicantID = ap.ApplicantID WHERE ap.JobID = ?";
        List<Applicant> applicants = new ArrayList<>();
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, jobId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Applicant applicant = new Applicant();
                applicant.setApplicantId(resultSet.getInt("ApplicantID"));
                applicant.setFirstName(resultSet.getString("FirstName"));
                applicant.setLastName(resultSet.getString("LastName"));
                applicant.setEmail(resultSet.getString("Email"));
                applicant.setPhone(resultSet.getString("Phone"));
                applicants.add(applicant);
            }
        }
        return applicants;
    }
    
    @Override
    public boolean applyForJob(int applicantId, int jobId, String coverLetter) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Applications (JobID, ApplicantID, ApplicationDate, CoverLetter) VALUES (?, ?, NOW(), ?)";
        
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, jobId);
            statement.setInt(2, applicantId);
            statement.setString(3, coverLetter);
            
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        }
    }

}
