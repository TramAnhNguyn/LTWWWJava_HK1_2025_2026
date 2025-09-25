package iuh.fit.se.tuan6.ex2;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Person {
    private int age;
    private List<Address> addresses;
    private List<String> emails;
    private String name;
}
