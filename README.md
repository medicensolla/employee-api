## API Endpoints

The following API endpoints are available:

### Create Employee

- URL: `POST /api/v1/employee/`
- Request Body: EmployeeDto
- Response: EmployeeDto , CREATED

Creates a new employee with the provided details and returns the created employee in the response body.

### Update Employee

- URL: `PUT /api/v1/employee/{id}`
- Path Variable: id (Integer)
- Request Body: EmployeeDto
- Response: EmployeDto

Updates the employee with the specified ID using the provided employee details and returns the updated employee in the response body.

### Delete Employee

- URL: `DELETE /api/v1/employee/{id}`
- Path Variable: id (Integer)
- Response: OK

Deletes the employee with the specified ID.

### Get All Employees

- URL: `GET /api/v1/employee/`
- Response: List Of EmployeeDto

Retrieves all employees and returns them in the response body as a list of EmployeeDto objects.

## Technologies Used

- Java
- Spring Framework (Spring Boot, Spring MVC)
- Maven
