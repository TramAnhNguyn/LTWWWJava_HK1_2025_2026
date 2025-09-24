package iuh.fit.se.tuan5_22716521_nguyenletramanh.daos.impl;

import iuh.fit.se.tuan5_22716521_nguyenletramanh.daos.NhaCungCapDAO;
import iuh.fit.se.tuan5_22716521_nguyenletramanh.entities.NhaCungCap;
import java.sql.Connection;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhaCungCapDAOImpl implements NhaCungCapDAO {
    private final DataSource dataSource;
    public NhaCungCapDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<NhaCungCap> findAll() {
        String sql = "SELECT * FROM NhaCungCap";
        List<NhaCungCap> list = new ArrayList<>();
        try (
                Connection con = this.dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                String maNCC = rs.getString("MANCC");
                String tenNCC = rs.getString("TENNHACC");
                String diaChi = rs.getString("DIACHI");
                String soDienThoai = rs.getString("SODIENTHOAI");
                list.add(new NhaCungCap(maNCC, tenNCC, diaChi, soDienThoai));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public NhaCungCap findById(String maNCC) {
        String sql = "SELECT * FROM NhaCungCap WHERE maNCC = ?";
        try (
                Connection con = (Connection) this.dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, maNCC); // gán giá trị tham số vào câu query
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String tenNCC = rs.getString("tenNCC");
                    String diaChi = rs.getString("diaChi");
                    String soDienThoai = rs.getString("soDienThoai");
                    return new NhaCungCap(maNCC, tenNCC, diaChi, soDienThoai);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // nếu không tìm thấy

    }

}
