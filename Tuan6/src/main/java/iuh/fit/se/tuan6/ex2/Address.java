package iuh.fit.se.tuan6.ex2;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {
    private String city;
    private String country;
    private String street;
}
