package iuh.fit.se.tuan5_22716521_nguyenletramanh.daos;

import iuh.fit.se.tuan5_22716521_nguyenletramanh.entities.NhaCungCap;

import java.util.List;

public interface NhaCungCapDAO {
    public List<NhaCungCap> findAll();
    public NhaCungCap findById(String maNCC);


}
