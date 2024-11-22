package com.java.careerHub.test;

import com.java.careerHub.dao.ApplicantDAO;
import com.java.careerHub.dao.ApplicantDAOImpl;
import com.java.careerHub.model.Applicant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

class ApplicantDAOTest {

    ApplicantDAO applicantDAO = new ApplicantDAOImpl();

    @Test
    void testCreateProfile() throws ClassNotFoundException, SQLException {
        String email = "test.user@email.com";
        String firstName = "Test";
        String lastName = "User";
        String phone = "1234567890";

        Applicant applicant = applicantDAO.createProfile(email, firstName, lastName, phone);
        assertNotNull(applicant, "Applicant should not be null.");
        assertEquals(firstName, applicant.getFirstName(), "First name should match.");
        assertEquals(email, applicant.getEmail(), "Email should match.");
    }

    @Test
    void testGetProfile() throws ClassNotFoundException {
        int applicantId = 1;

        Applicant applicant = applicantDAO.getProfile(applicantId);
        assertNotNull(applicant, "Applicant should not be null.");
        assertEquals("Arun", applicant.getFirstName(), "First name should be Arun.");
        assertEquals("Rajendran", applicant.getLastName(), "Last name should be Rajendran.");
    }
}
