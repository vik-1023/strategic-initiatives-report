# Strategic Initiatives Reporting Application

## Overview
This Spring Boot web application generates a summary report of strategic initiatives, grouped by Category and Subcategory, showing counts by status, total budget variance, schedule delays, and estimated revenue lost.

The report data is retrieved from a relational database using a custom SQL query with complex joins and aggregations. The report is displayed on a single web page as an HTML table.

---

## Project Structure

- **Entity Layer:** JPA entities mapped to database tables (category, subcategory, initiative, etc.)  
- **Repository Layer:** Spring Data JPA repository with a native query to fetch report data  
- **Projection Interface:** `ReportProjection` interface defines the report columns  
- **Service Layer:** Business logic to fetch and process the report  
- **Controller Layer:** Exposes `/report` endpoint returning a Thymeleaf view  
- **View Layer:** Thymeleaf template renders the report in a clean HTML table

---

## Prerequisites

- Java 17+ (or compatible JDK)  
- Maven 3.6+  
- MySQL / MariaDB (or compatible relational DB)  
- Optional: IDE such as IntelliJ IDEA or Eclipse

---

## Database Configuration

- Database connection properties are set in `src/main/resources/application.properties`:



## How to Run

1. Clone the repository


2. Build the project with Maven


3. Run the application


4. Open your browser and access the report at:


---

## Report Page

- The report page displays initiatives grouped by category and subcategory with columns for:
- Total Count  
- Completed, Dropped, In Draft, In Progress, On Hold counts  
- Variance Sum  
- Delay (days)  
- Revenue Lost

- The data is dynamically fetched from the DB using your custom native SQL query with proper joins and grouping.

---

## Screenshot

![Report Page Screenshot](docs/report_page_screenshot.png)








