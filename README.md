# Edge-Cloud Computing for Task Offloading and Service Caching

## Abstract
Edge-cloud computing addresses high latency in mobile cloud computing by placing computing resources closer to end devices. This project optimizes task offloading and service caching to improve user satisfaction and resource efficiency. A hybrid heuristic method, LMPSO, integrates Particle Swarm Optimization (PSO) with Lévy flight movement to avoid local optima. 

LMPSO follows a three-stage heuristic approach for task offloading:
1. **Cloud Resource Utilization** - Maximizes cloud resources.
2. **Edge Resource Utilization** - Handles latency-sensitive tasks efficiently.
3. **Performance Optimization** - Re-offloads tasks from cloud to edges for better execution.

Simulations show LMPSO achieves up to **156% better user satisfaction**, **57.9% higher resource efficiency**, and **155% greater processing efficiency** compared to seven other heuristic methods.

## Objectives
- Optimize task offloading and service caching in edge-cloud computing.
- Enhance user satisfaction and resource efficiency.
- Implement a hybrid heuristic method (LMPSO) using Particle Swarm Optimization.
- Improve processing efficiency by integrating Lévy flight movement.
- Implement a three-stage heuristic task offloading approach.

## Software Requirements
### Frontend
- **Technology**: Spring Boot (Spring MVC, Thymeleaf)

### Backend
- **Database**: MySQL 8.0
- **ORM**: Hibernate / JPA

### Development Environment
- **IDE**: Spring Tool Suite (STS) / IntelliJ IDEA
- **Build Tool**: Maven
- **Version Control**: Git, GitHub
- **Operating System**: Windows 10 / Linux

## Setup Instructions
### Prerequisites
- Install **Java 17+**
- Install **Spring Tool Suite (STS) / IntelliJ IDEA**
- Install **MySQL 8.0**
- Install **Maven**

### Steps to Run the Project
1. Clone the repository:
   ```sh
   git clone https://github.com/your-repository.git
   cd your-repository
   ```
2. Configure database connection in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```
3. Build and run the application:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
4. Access the application at `http://localhost:8082`

## Contributing
Feel free to fork this repository, submit issues, and send pull requests!






