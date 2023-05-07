package com.prasant.employeeaddress.services;

import com.prasant.employeeaddress.models.Employee;
import com.prasant.employeeaddress.repositories.IAddressRepository;
import com.prasant.employeeaddress.repositories.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private IAddressRepository addressRepository;

    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public String addEmployee(Employee employee) {
        addressRepository.save(employee.getAddress());
        employeeRepository.save(employee);
        return "Employee created!";
    }

    public String updateEmployee(Long id, Employee employee) {
        Employee oldEmployee = employeeRepository.findById(id).orElse(null);
        if(oldEmployee != null){
            oldEmployee.setFirstName(employee.getFirstName());
            oldEmployee.setLastName(employee.getLastName());
            oldEmployee.setAddress(employee.getAddress());
            employeeRepository.save(oldEmployee);
            return "Employee updated!";
        }
        else return "Employee Id is invalid!";
    }

    public String deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return "Employee deleted!";
    }
}
