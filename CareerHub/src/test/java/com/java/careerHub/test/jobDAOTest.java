package com.java.careerHub.test;

import com.java.careerHub.dao.JobDAO;
import com.java.careerHub.dao.JobDAOImpl;
import com.java.careerHub.model.Applicant;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JobDAOTest {

    JobDAO jobDAO = new JobDAOImpl();

    @Test
    void testApplyForJob() throws ClassNotFoundException, SQLException {
        int applicantId = 1;
        int jobId = 1;
        String coverLetter = "I am excited to contribute to your team.";

        boolean isApplied = jobDAO.apply(applicantId, jobId, coverLetter);
        assertTrue(isApplied, "Job application should be successful.");
    }

    @Test
    void testGetApplicants() throws ClassNotFoundException, SQLException {
        int jobId = 1;

        List<Applicant> applicants = jobDAO.getApplicants(jobId);
        assertNotNull(applicants, "Applicants list should not be null.");
        assertFalse(applicants.isEmpty(), "Applicants list should not be empty.");
        assertEquals("Arun", applicants.get(0).getFirstName(), "First applicant should be Arun.");
    }
}
