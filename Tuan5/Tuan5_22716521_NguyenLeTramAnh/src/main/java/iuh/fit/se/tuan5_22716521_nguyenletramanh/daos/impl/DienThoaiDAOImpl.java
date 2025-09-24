package iuh.fit.se.tuan5_22716521_nguyenletramanh.daos.impl;

import iuh.fit.se.tuan5_22716521_nguyenletramanh.daos.DienThoaiDAO;
import iuh.fit.se.tuan5_22716521_nguyenletramanh.entities.DienThoai;
import iuh.fit.se.tuan5_22716521_nguyenletramanh.entities.NhaCungCap;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DienThoaiDAOImpl implements DienThoaiDAO {
    private final DataSource dataSource;
    public DienThoaiDAOImpl(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public List<DienThoai> getDienThoai(String tenNCC) {
        String sql = "SELECT d.MADT, d.TENDT, d.NAMSANXUAT, d.CAUHINH, d.MANCC, d.HINHANH " +
                "FROM DienThoai d JOIN NhaCungCap n ON d.maNCC = n.maNCC " +
                "WHERE n.tenNCC = ?";
        List<DienThoai> list = new ArrayList<>();
        try (Connection con = this.dataSource.getConnection();
             PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, tenNCC);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    String maDT = rs.getString("MADT");
                    String tenDT = rs.getString("TENDT");
                    Date namSX = rs.getDate("NAMSANXUAT");
                    String cauHinh = rs.getString("CAUHINH");

                    // Chỉ lấy mã NCC
                    NhaCungCap ncc = new NhaCungCap();
                    ncc.setMaNCC(rs.getString("MANCC"));

                    String hinhAnh = rs.getString("HINHANH");

                    list.add(new DienThoai(maDT, tenDT, namSX, cauHinh, ncc, hinhAnh));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public List<DienThoai> findAll() {
        String sql = "SELECT MADT, TENDT, NAMSANXUAT, CAUHINH, MANCC, HINHANH FROM DienThoai";
        List<DienThoai> list = new ArrayList<>();
        try (Connection con = this.dataSource.getConnection();
             PreparedStatement stm = con.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                String maDT = rs.getString("MADT");
                String tenDT = rs.getString("TENDT");
                Date namSX = rs.getDate("NAMSANXUAT");
                String cauHinh = rs.getString("CAUHINH");

                // Chỉ lấy mã NCC
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNCC(rs.getString("MANCC"));

                String hinhAnh = rs.getString("HINHANH");

                list.add(new DienThoai(maDT, tenDT, namSX, cauHinh, ncc, hinhAnh));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public void addDienThoai(DienThoai dt) {
        String sql = "INSERT INTO DienThoai(maDT, tenDT, namSX, cauHinh, maNCC, hinhAnh) VALUES(?, ?, ?, ?, ?, ?)";
        try (Connection con = this.dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, dt.getMaDT());
            ps.setString(2, dt.getTenDT());
            ps.setDate(3, new java.sql.Date(dt.getNamSX().getTime()));
            ps.setString(4, dt.getCauHinh());
            ps.setString(5, dt.getMaNCC().getMaNCC());
            ps.setString(6, dt.getHinhAnh());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteDienThoai(String maDT) {
        String sql = "DELETE FROM DienThoai WHERE maDT = ?";
        try (Connection con = this.dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maDT);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
