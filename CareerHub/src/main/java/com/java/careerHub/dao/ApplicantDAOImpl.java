package com.java.careerHub.dao;

import com.java.careerHub.dao.ApplicantDAO;
import com.java.careerHub.model.Applicant;
import com.java.careerHub.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplicantDAOImpl implements ApplicantDAO {

    @Override
    public Applicant createProfile(String email, String firstName, String lastName, String phone) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO Applicants (Email, FirstName, LastName, Phone) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, phone);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    Applicant applicant = new Applicant();
                    applicant.setApplicantId(generatedKeys.getInt(1));
                    applicant.setEmail(email);
                    applicant.setFirstName(firstName);
                    applicant.setLastName(lastName);
                    applicant.setPhone(phone);
                    return applicant;
                }
            }
        }
        return null;
    }

    @Override
    public boolean applyForJob(int applicantId, int jobId, String coverLetter) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO Applications (JobID, ApplicantID, CoverLetter, ApplicationDate) VALUES (?, ?, ?, NOW())";
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, jobId);
            preparedStatement.setInt(2, applicantId);
            preparedStatement.setString(3, coverLetter);

            return preparedStatement.executeUpdate() > 0;
        }
    }

    @Override
    public Applicant getProfile(int applicantId) throws ClassNotFoundException {
        String query = "SELECT * FROM Applicants WHERE ApplicantID = ?";
        Applicant applicant = null;

        try (Connection connection = ConnectionHelper.getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, applicantId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                applicant = new Applicant();
                applicant.setApplicantId(resultSet.getInt("ApplicantID"));
                applicant.setFirstName(resultSet.getString("FirstName"));
                applicant.setLastName(resultSet.getString("LastName"));
                applicant.setEmail(resultSet.getString("Email"));
                applicant.setPhone(resultSet.getString("Phone"));
                applicant.setResume(resultSet.getString("Resume"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return applicant;
    }

}
