CREATE DATABASE IF NOT EXISTS CareerHub;

USE CareerHub;

CREATE TABLE IF NOT EXISTS Companies (
    CompanyID INT AUTO_INCREMENT PRIMARY KEY,
    CompanyName VARCHAR(255) NOT NULL,
    Location VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Jobs (
    JobID INT AUTO_INCREMENT PRIMARY KEY,
    CompanyID INT NOT NULL,
    JobTitle VARCHAR(255) NOT NULL,
    JobDescription TEXT,
    JobLocation VARCHAR(255),
    Salary DECIMAL(10, 2),
    JobType VARCHAR(50),
    PostedDate DATETIME NOT NULL,
    FOREIGN KEY (CompanyID) REFERENCES Companies(CompanyID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Applicants (
    ApplicantID INT AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(100) NOT NULL,
    LastName VARCHAR(100) NOT NULL,
    Email VARCHAR(255) NOT NULL UNIQUE,
    Phone VARCHAR(20),
    Resume TEXT
);

CREATE TABLE IF NOT EXISTS Applications (
    ApplicationID INT AUTO_INCREMENT PRIMARY KEY,
    JobID INT NOT NULL,
    ApplicantID INT NOT NULL,
    ApplicationDate DATETIME NOT NULL,
    CoverLetter TEXT,
    FOREIGN KEY (JobID) REFERENCES Jobs(JobID) ON DELETE CASCADE,
    FOREIGN KEY (ApplicantID) REFERENCES Applicants(ApplicantID) ON DELETE CASCADE
);

-- Step 1: Insert sample data into the Companies table (South India-related companies)
INSERT INTO Companies (CompanyName, Location) VALUES
('CoconutSoft Solutions', 'Chennai, Tamil Nadu'),
('AyurVeda Health', 'Bangalore, Karnataka'),
('Sitar Enterprises', 'Hyderabad, Telangana'),
('Green Fields Agro', 'Coimbatore, Tamil Nadu'),
('Tamarind Studios', 'Trivandrum, Kerala');

-- Step 2: Insert sample data into the Jobs table (South India-related job listings)
INSERT INTO Jobs (CompanyID, JobTitle, JobDescription, JobLocation, Salary, JobType, PostedDate) VALUES
(1, 'Software Developer', 'Develop innovative software solutions for clients in the agriculture and healthcare sectors', 'Chennai, Tamil Nadu', 75000.00, 'Full-time', '2024-11-01 09:00:00'),
(2, 'Ayurvedic Doctor', 'Provide holistic healthcare using Ayurvedic treatments and therapies', 'Bangalore, Karnataka', 65000.00, 'Full-time', '2024-10-20 10:00:00'),
(3, 'Marketing Manager', 'Create and implement marketing strategies for agricultural products and services', 'Hyderabad, Telangana', 80000.00, 'Full-time', '2024-10-18 08:30:00'),
(4, 'Agronomist', 'Research and develop innovative agricultural solutions for the organic farming industry', 'Coimbatore, Tamil Nadu', 70000.00, 'Full-time', '2024-10-25 14:00:00'),
(5, '3D Artist', 'Design 3D models and animation for film and media projects', 'Trivandrum, Kerala', 60000.00, 'Contract', '2024-10-30 12:00:00');

-- Step 3: Insert sample data into the Applicants table (South Indian applicants)
INSERT INTO Applicants (FirstName, LastName, Email, Phone, Resume) VALUES
('Arun', 'Rajendran', 'arun.rajendran@email.com', '9876543210', 'Resume: Arun Rajendran - Software developer with 4 years of experience in building scalable applications for healthcare and agriculture industries.'),
('Priya', 'Nair', 'priya.nair@email.com', '9876543211', 'Resume: Priya Nair - Ayurvedic doctor with a focus on traditional therapies and holistic healing.'),
('Sandeep', 'Reddy', 'sandeep.reddy@email.com', '9876543212', 'Resume: Sandeep Reddy - Experienced marketing manager specializing in agricultural products in South India.'),
('Lakshmi', 'Krishnan', 'lakshmi.krishnan@email.com', '9876543213', 'Resume: Lakshmi Krishnan - Agronomist with expertise in organic farming and sustainable agriculture practices.'),
('Kiran', 'Suresh', 'kiran.suresh@email.com', '9876543214', 'Resume: Kiran Suresh - 3D artist with experience in designing animation and models for South Indian cinema and advertisements.');

-- Step 4: Insert sample data into the Applications table (South Indian applicants applying for jobs)
INSERT INTO Applications (JobID, ApplicantID, ApplicationDate, CoverLetter) VALUES
(1, 1, '2024-11-01 10:30:00', 'I am passionate about creating innovative software solutions and would be thrilled to contribute my skills to CoconutSoft Solutions in enhancing agricultural technology.'),
(2, 2, '2024-10-20 11:00:00', 'With a deep understanding of Ayurvedic healing and a commitment to holistic health, I believe I can make a valuable contribution to AyruVeda Health in Bangalore.'),
(3, 3, '2024-10-18 09:00:00', 'I have extensive experience in agricultural marketing and would love to help Sitar Enterprises expand its reach in Telangana and across South India.'),
(4, 4, '2024-10-25 15:30:00', 'I am an agronomist with a passion for organic farming and sustainable agricultural practices. I believe I can help Green Fields Agro with its innovative research and development.'),
(5, 5, '2024-10-30 13:00:00', 'I am a creative 3D artist with a passion for film and media in South Indian cinema. I would love to contribute my skills to the creative team at Tamarind Studios.');
