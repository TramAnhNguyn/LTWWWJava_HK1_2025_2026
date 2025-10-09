package iuh.fit.se.tuan7_22716521_nguyenletramanh.daos;

import iuh.fit.se.tuan7_22716521_nguyenletramanh.entities.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAll();
    void deleteById(int id);
    void save(Employee employee);
    void update(Employee employee);
    Employee getById(int id);
}
