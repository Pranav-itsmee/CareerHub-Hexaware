package com.java.careerHub.main;

import com.java.careerHub.dao.*;
import com.java.careerHub.model.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CareerHubMain {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        JobDAO jobDAO = new JobDAOImpl();
        CompanyDAO companyDAO = new CompanyDAOImpl();
        ApplicantDAO applicantDAO = new ApplicantDAOImpl();

        while (true) {
            System.out.println("\n======================================");
            System.out.println("         Welcome to Career Hub         ");
            System.out.println("======================================");
            System.out.println("1. Apply for a Job (Job)");
            System.out.println("2. View Applicants for a Job (Job)");
            System.out.println("3. Post a Job (Company)");
            System.out.println("4. View Job Listings (Company)");
            System.out.println("5. Create Applicant Profile (Applicant)");
            System.out.println("6. Apply for a Job Listing (Applicant)");
            System.out.println("7. Exit");
            System.out.println("======================================");
            System.out.print("Enter your choice (1-7): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            System.out.println("\n--------------------------------------");

            switch (choice) {
                case 1:
                    System.out.println(">>> Apply for a Job <<<");
                    System.out.print("Enter Applicant ID: ");
                    int applicantId = scanner.nextInt();
                    System.out.print("Enter Job ID: ");
                    int jobId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Cover Letter: ");
                    String coverLetter = scanner.nextLine();
                    if (jobDAO.apply(applicantId, jobId, coverLetter)) {
                        System.out.println("Application submitted successfully!");
                    } else {
                        System.out.println("Invalid Job ID or Application failed.");
                    }
                    break;

                case 2:
                    System.out.println(">>> View Applicants for a Job <<<");
                    System.out.print("Enter Job ID: ");
                    jobId = scanner.nextInt();
                    List<Applicant> applicants = jobDAO.getApplicants(jobId);
                    System.out.println("\nApplicants for Job ID " + jobId + ":");
                    if (applicants.isEmpty()) {
                        System.out.println("No applicants found for this job.");
                    } else {
                        applicants.forEach(applicant -> System.out.println(" - " + applicant));
                    }
                    break;

                case 3:
                    System.out.println("\n--------------------------------------");
                    System.out.println(">>> Post a New Job <<<");
                    System.out.print("Enter Company ID: ");
                    int companyId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Job Title: ");
                    String jobTitle = scanner.nextLine();
                    System.out.print("Enter Job Description: ");
                    String jobDescription = scanner.nextLine();
                    System.out.print("Enter Job Location: ");
                    String jobLocation = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine(); 
                    System.out.print("Enter Job Type: ");
                    String jobType = scanner.nextLine();

                    boolean jobPosted = companyDAO.postJob(companyId, jobTitle, jobDescription, jobLocation, salary, jobType);
                    if (jobPosted) {
                        System.out.println("Job posted successfully!");
                    } else {
                        System.out.println("Failed to post the job. Please try again.");
                    }
                    break;


                case 4:
                    System.out.println(">>> View Job Listings <<<");
                    List<Job> jobs = companyDAO.getJobs();
                    if (jobs.isEmpty()) {
                        System.out.println("No jobs available.");
                    } else {
                        System.out.println("\nAvailable Jobs:");
                        jobs.forEach(job -> System.out.println(" - " + job));
                    }
                    break;

                case 5:
                    System.out.println(">>> Create Applicant Profile <<<");
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = scanner.nextLine();
                    Applicant applicant = applicantDAO.createProfile(email, firstName, lastName, phone);
                    if (applicant != null) {
                        System.out.println("Profile created successfully!");
                        System.out.println("Profile Details: " + applicant);
                    } else {
                        System.out.println("Failed to create profile.");
                    }
                    break;

                case 6:
                    System.out.println("\n--------------------------------------");
                    System.out.println(">>> Apply for a Job Listing <<<");

                    System.out.print("Enter Applicant ID: ");
                    applicantId = scanner.nextInt();  
                    System.out.print("Enter Job ID: ");
                    jobId = scanner.nextInt();       
                    scanner.nextLine();               
                    System.out.print("Enter Cover Letter: ");
                    coverLetter = scanner.nextLine();
                    
                    boolean applicationSuccess = jobDAO.applyForJob(applicantId, jobId, coverLetter);
                    
                    if (applicationSuccess) {
                        System.out.println("You have successfully applied for the job!");
                    } else {
                        System.out.println("Failed to apply for the job. Please try again.");
                    }
                    break;


                case 7:
                    System.out.println("Thank you for using Career Hub. Goodbye!");
                    System.out.println("--------------------------------------");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println("--------------------------------------\n");
        }
    }
}
