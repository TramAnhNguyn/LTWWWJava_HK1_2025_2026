package iuh.fit.se.tuan5_22716521_nguyenletramanh.entities;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DienThoai {
    private String maDT;
    private String tenDT;
    private Date namSX;
    private String cauHinh;
    private NhaCungCap maNCC;
    private String hinhAnh;

}
