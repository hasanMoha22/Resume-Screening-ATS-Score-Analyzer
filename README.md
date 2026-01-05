📄 Resume Screening & ATS Score Analyzer

A full-stack Resume Screening Web Application built using Spring Boot (Backend) and React (Frontend) that analyzes resumes against required skills, calculates an ATS (Applicant Tracking System) match score, extracts email & phone number, and maintains a resume analysis history.
This project demonstrates real-world backend development, REST APIs, PDF processing, database integration, and frontend-backend communication.

🚀 Features

🔹 Resume Upload & Analysis

->Upload resume in PDF format
->Extracts text content from the resume
->Detects Email ID and Phone Number
->Compares resume skills with selected job requirements

🔹 ATS Match Score

Calculates an ATS score (0–100%)

Based on:

1.Skill coverage
2.Skill frequency
3.Shows Matched Skills and Missing Skills

🔹 Resume Analysis History

->Stores analysis results in the database

Displays:

->Resume filename
->Email & phone number
->ATS score
->Matched & missing skills
->Date of analysis

🔹 User-Friendly UI

...Responsive React interface
...Skill selection using dropdown
...Clean result visualization
...History displayed in tabular format

🛠️ Tech Stack
-->Backend

1.Java

2.Spring Boot

3.Spring Data JPA

4.Hibernate

5.PostgreSQL / MySQL

6.REST APIs

7.PDF Processing

8.Regex (Email & Phone Detection)

-->Frontend

1.React.js

2.Axios

3.CSS

4.React Select

📐 System Architecture

React Frontend
      |
      | REST API (JSON)
      ↓
Spring Boot Backend
      |
      | JPA / Hibernate
      ↓
Relational Database

📂 API Endpoints
🔹 Analyze Resume
POST /api/upload-file

Request:

-->PDF file
-->Selected skills
-->Response:

{
  "filename": "resume.pdf",
  "email": "example@gmail.com",
  "phone": "+91XXXXXXXXXX",
  "score": 76,
  "analysis": {
    "matchedSkills": ["java", "sql"],
    "missingSkills": ["react"]
  },
  "historyId": 5
}

🔹 Fetch Resume History
GET /api/history
Returns all previously analyzed resumes.

🗃️ Database Design

analysis_history Table
Column Name	Type
id	Long (PK)
filename	String
email	String
phone	String
score	Double
matched_skills	List<String>
missing_skills	List<String>
created_at	Timestamp

⚙️ How to Run the Project

1.Backend (Spring Boot)
2.Clone the repository
3.Open in IDE (IntelliJ / Eclipse)
4.Configure database in application.properties

Run:
->mvn spring-boot:run

->Backend runs on:
http://localhost:8080

->Frontend (React)

->Navigate to frontend folder

->Install dependencies:

---npm install


---Start app:

---npm start


Frontend runs on:

http://localhost:8081

🎯 Use Cases

1.Resume screening for HR teams
2.Skill gap analysis for job seekers
3.ATS score estimation before job application
4.Resume optimization guidance

📈 Future Enhancements (Optional)
1.Job Description matching
2.Authentication (Admin/User)
3.Resume ranking system
4.Downloadable analysis report (PDF)
5.Cloud deployment (AWS / Render)

👨‍💻 Author

Hasan Mohamed

B.E.Computer Science Engineer

Spring Boot & Java Developer

⭐ Why This Project Matters

This project demonstrates:

->End-to-end full-stack development.
->Practical use of Spring Boot REST APIs.
->Database design & persistence.
->Frontend-backend integration.
->Real-world resume screening logic.
->Perfect for beginner-to-intermediate Spring Boot developers.
