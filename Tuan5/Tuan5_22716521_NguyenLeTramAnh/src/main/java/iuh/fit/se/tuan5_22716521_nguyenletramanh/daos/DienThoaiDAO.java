package iuh.fit.se.tuan5_22716521_nguyenletramanh.daos;

import iuh.fit.se.tuan5_22716521_nguyenletramanh.entities.DienThoai;

import java.util.List;

public interface DienThoaiDAO {
    public List<DienThoai> getDienThoai(String tenNCC);

    public List<DienThoai> findAll();

    public void addDienThoai(DienThoai dt);

    public void deleteDienThoai(String maDT);
}
