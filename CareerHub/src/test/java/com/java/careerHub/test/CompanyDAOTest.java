package com.java.careerHub.test;

import com.java.careerHub.dao.CompanyDAO;
import com.java.careerHub.dao.CompanyDAOImpl;
import com.java.careerHub.model.Job;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompanyDAOTest {

    CompanyDAO companyDAO = new CompanyDAOImpl();

    @Test
    void testPostJob() throws ClassNotFoundException, SQLException {
        int companyId = 1;
        String jobTitle = "Java Developer";
        String jobDescription = "Develop and maintain Java applications.";
        String jobLocation = "Chennai, Tamil Nadu";
        double salary = 85000.00;
        String jobType = "Full-time";

        boolean isJobPosted = companyDAO.postJob(companyId, jobTitle, jobDescription, jobLocation, salary, jobType);
        assertTrue(isJobPosted, "Job posting should be successful.");
    }

    @Test
    void testGetJobs() throws ClassNotFoundException, SQLException {
        List<Job> jobs = companyDAO.getJobs();
        assertNotNull(jobs, "Jobs list should not be null.");
        assertFalse(jobs.isEmpty(), "Jobs list should not be empty.");
        assertEquals("Software Developer", jobs.get(0).getJobTitle(), "First job title should be 'Software Developer'.");
    }
}
