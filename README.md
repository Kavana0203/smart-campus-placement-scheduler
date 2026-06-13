🎓 SMART CAMPUS PLACEMENT SCHEDULER AND ANALYTICS

A full-stack web application to manage campus placement drives, student registrations, and provide real-time analytics.

 🚀 Features

-  Student Registration with profile management
-  Company management with eligibility criteria
-  Placement drive scheduling with conflict detection
-  Dynamic eligibility filtering based on CGPA, branch & backlogs
-  Real-time analytics dashboard with charts
-  Role-based access control (Student & Admin)

 
 🛠️ Tech Stack

| Layer           | Technology                       |
|-----------------|----------------------------------|
| Backend         | Java, Spring Boot 3.x            |
| Database        | MySQL 8.0                        |
| Frontend        | HTML, CSS, JavaScript, Thymeleaf |
| Charts          | Chart.js                         |
| Security        | Spring Security                  |
| ORM             | Spring Data JPA, Hibernate       |
| Build Tool      | Maven                            |

 📁 Project Structure
 src/main/java/com/placement/scheduler/

├── controller/    → Handles web requests

├── model/         → Database entities

├── repository/    → Database queries

├── service/       → Business logic

└── security/      → Authentication & authorization


 ⚙️ Setup Instructions

* Prerequisites
- JDK 17+
- MySQL 8.0
- Maven

 Steps :
1. Clone the repository
```bash
git clone https://github.com/Kavana0203/smart-campus-placement-scheduler.git
```

2. Create MySQL database
```sql
CREATE DATABASE placement_db;
```

3. Update `application.properties`
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/placement_db
spring.datasource.username=root
spring.datasource.password=your_password
```

4. Run the application
```bash
./mvnw spring-boot:run
```

5. Open browser
http://localhost:8080/admin/dashboard

🔗 Key URLs

Page                          |     URL
------------------------------------------------------------------------
🏠 Dashboardhttp:             | //localhost:8080/admin/dashboard
👤 Student Registration       | http://localhost:8080/student/register
👥 All Students               | http://localhost:8080/admin/students
🏢 Add Company                | http://localhost:8080/admin/company/add
🏢 All Companies              | http://localhost:8080/admin/companies
📅 Schedule Drive             | http://localhost:8080/admin/drive/schedule
📅 All Drives                 | http://localhost:8080/admin/drives
✅ Eligible Drives            | http://localhost:8080/student/drives/eligible/1

Note:
Replace 1 in eligible drives URL with actual student ID

👩‍💻 Developer
- Kavana
- GitHub: [@Kavana0203](https://github.com/Kavana0203) 
- Email: kavanapatgar02@gmail.com

