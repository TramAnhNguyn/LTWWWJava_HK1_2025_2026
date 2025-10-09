package iuh.fit.se.tuan7_22716521_nguyenletramanh.daos.impls;

import iuh.fit.se.tuan7_22716521_nguyenletramanh.daos.EmployeeDAO;
import iuh.fit.se.tuan7_22716521_nguyenletramanh.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDAOImpl  implements EmployeeDAO {
    private DataSource dataSource;

    public EmployeeDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employee";

        try (Connection conn = this.dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Employee employee = mapRowToEmployee(rs);
                employees.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving employees", e);
        }

        return employees;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error deleting employee with id: " + id, e);
        }

    }

    @Override
    public void save(Employee employee) {
        String sql = "INSERT INTO employee (id, role, name) VALUES (?,?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getRole());
            ps.setString(3, employee.getName());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Employee employee) {
        String sql = "UPDATE employee SET role = ?, name = ? WHERE id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, employee.getRole());
            ps.setString(2, employee.getName());
            ps.setInt(3, employee.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Employee getById(int id) {
        String sql = "SELECT * FROM employee WHERE id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Employee.builder()
                            .id(rs.getInt("id"))
                            .role(rs.getString("role"))
                            .name(rs.getString("name"))
                            .build();
                } else {
                    return null;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error getting employee with id: " + id, e);
        }
    }

    private Employee mapRowToEmployee(ResultSet rs) throws SQLException {
        return Employee.builder()
                .id(rs.getInt("id"))
                .role(rs.getString("role"))
                .name(rs.getString("name"))
                .build();
    }
}
