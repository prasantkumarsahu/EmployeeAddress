# Employee Address Management System
This is a API project for insert, read, update, and delete Employees and Addresses using **`MySQL` Database** and `CrudRepository`.

![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot "Spring Boot") ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white "Java") ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white "Postman") ![Google Chrome](https://img.shields.io/badge/Google%20Chrome-4285F4?style=for-the-badge&logo=GoogleChrome&logoColor=white "Google Chrome")

## Frameworks and Languages
![Java v17](https://img.shields.io/badge/Java-v17-green "Java 17") ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-v3.0.6-brightgreen "Spring Boot v3.0.6")
---

## Browser / Tools

## ![Google Chrome](https://img.shields.io/badge/Google%20Chrome-v112.0.5615.138-yellow "Google Chrome") ![Postman](https://img.shields.io/badge/Postman-v10.13.0-orange "Postman")

## Model

- ### Employee Properties
  - ```java
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    ```
  - ```java
    private String firstName;
    ```
  - ```java
    private String lastName;
    ```
  - ```java
    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;
    ```
- ### Address Properties
  - ```java
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    ```
  - ```java
    private String street;
    ```
  - ```java
    private String City;
    ```
  - ```java
    private String state;
    ```
  - ```java
    private String zipcode;
    ```
  - ```java
    @OneToOne(mappedBy = "address", cascade = CascadeType.REMOVE)
    private Employee employee;
    ```
---

## Dataflow

- ### End Points / Controllers
  - _Employee_
    - `@GetMapping(value = "/")`
    - `@GetMapping(value = "/{id}")`
    - `@PostMapping(value = "/")`
    - `@PutMapping(value = "/{id}")`
    - `@DeleteMapping(value = "/{id}")`
  - _Address_
    - `@GetMapping(value = "/")`
    - `@GetMapping(value = "/{id}")`
    - `@PostMapping(value = "/")`
    - `@PutMapping(value = "/{id}")`
    - `@DeleteMapping("/{id}")`
- ### Services
  - _Employee_
    ```java
    public List<Employee> getAllEmployees()
    ```
    ```java
    public Employee getEmployeeById(Long id)
    ```
    ```java
    public String addEmployee(Employee employee)
    ```
    ```java
    public String updateEmployee(Long id, Employee employee)
    ```
    ```java
    public String deleteEmployee(Long id)
    ```
  - _Address_
    ```java
    public List<Address> getAllAddresses()
    ```java
    public Address getAddressById(Long id)
    ```
    ```java
    public String addAddress(Address address)
    ```
    ```java
    public String updateAddress(Long id, Address address)
    ```
    ```java
    public String deleteAddress(Long id)
    ```
- ### Repository
  - _Employee_
    ```java
    @Repository
    public interface IEmployeeRepository extends CrudRepository<Employee, Long> {
    }
    ```
  - _Address_
    ```java
    @Repository
    public interface IAddressRepository extends CrudRepository<Address, Long> {
    }
    ```
- ### Database
  In this project for datasource I've used **`MySQL` Database** with `SpringDataJPA`.

---

## Datastructures

- `List<>`/`Iterable<>`

---

## Summary

This API is a `Spring Boot` project that is about managing Employees and Addresses. We can create, read, update, and delete Employees and Addresses. In this project request is sent from the client on HTTP in JSON format or from path variable and stored in object then response is sent back from the server by JSON format to the client.
