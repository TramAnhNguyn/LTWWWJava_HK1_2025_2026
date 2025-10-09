package iuh.fit.se.tuan7_22716521_nguyenletramanh.entities;

import jdk.jshell.Snippet;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    private int id;
    private String role;
    private String name;

}
