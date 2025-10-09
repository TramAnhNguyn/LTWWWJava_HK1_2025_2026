package iuh.fit.se.tuan7_22716521_nguyenletramanh;

import iuh.fit.se.tuan7_22716521_nguyenletramanh.daos.EmployeeDAO;
import iuh.fit.se.tuan7_22716521_nguyenletramanh.entities.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Tuan722716521NguyenLeTramAnhApplication {

    private EmployeeDAO employeeDAO;

    public static void main(String[] args) {
        SpringApplication.run(Tuan722716521NguyenLeTramAnhApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(EmployeeDAO employeeDAO) {
        return args -> {
            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n===== MENU =====");
                System.out.println("1. Hiển thị tất cả nhân viên");
                System.out.println("2. Thêm nhân viên mới");
                System.out.println("3. Cập nhật nhân viên theo ID");
                System.out.println("4. Xóa nhân viên theo ID");
                System.out.println("5. Tìm nhân viên theo ID");
                System.out.println("0. Thoát");
                System.out.print("Chọn chức năng: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // clear buffer

                switch (choice) {
                    case 1 -> {
                        System.out.println("Danh sách nhân viên:");
                        List<Employee> employees = employeeDAO.getAll();
                        employees.forEach(System.out::println);
                    }
                    case 2 -> {
                        System.out.print("Nhập tên nhân viên: ");
                        String name = scanner.nextLine();
                        System.out.print("Nhập vai trò: ");
                        String role = scanner.nextLine();

                        Employee newEmp = new Employee(0, role, name);
                        employeeDAO.save(newEmp);
                        System.out.println("✅ Đã thêm nhân viên mới!");
                    }
                    case 3 -> {
                        System.out.print("Nhập ID nhân viên cần cập nhật: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // clear buffer

                        Employee empToUpdate = employeeDAO.getById(id);
                        if (empToUpdate == null) {
                            System.out.println("❌ Không tìm thấy nhân viên có ID = " + id);
                        } else {
                            System.out.println("📝 Nhân viên hiện tại: " + empToUpdate);
                            System.out.print("Nhập tên mới: ");
                            String newName = scanner.nextLine();
                            System.out.print("Nhập vai trò mới: ");
                            String newRole = scanner.nextLine();

                            empToUpdate.setName(newName);
                            empToUpdate.setRole(newRole);
                            employeeDAO.update(empToUpdate);
                            System.out.println("✅ Đã cập nhật nhân viên!");
                        }
                    }
                    case 4 -> {
                        System.out.print("Nhập ID nhân viên cần xóa: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // clear buffer

                        employeeDAO.deleteById(id);
                        System.out.println("✅ Đã xóa nhân viên có ID = " + id);
                    }
                    case 5 -> {
                        System.out.print("Nhập ID nhân viên cần tìm: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        Employee found = employeeDAO.getById(id);
                        if (found != null) {
                            System.out.println("🔍 Tìm thấy: " + found);
                        } else {
                            System.out.println("❌ Không tìm thấy nhân viên có ID = " + id);
                        }
                    }
                    case 0 -> System.out.println("👋 Thoát chương trình.");
                    default -> System.out.println("❗ Lựa chọn không hợp lệ.");
                }

            } while (choice != 0);
        };
    }


}
