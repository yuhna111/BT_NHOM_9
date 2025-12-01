/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

/**
 *
 * @author yuhna
 */// src/Java/repository/GiaoDichRepository.java

import Model.GiaoDich;
import config.DBConnectionUtil;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GiaoDichRepository {

    public void save(GiaoDich gd) {
        String sql = """
            INSERT INTO giaodich 
            (maGiaoDich, thoiGianVao, thoiGianRa, phiDoXe, trangThaiThanhToan, 
             maMucGiaApDung, maThe, maNhanVien, maViTri) 
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, gd.getMaGiaoDich());
            ps.setTimestamp(2, Timestamp.valueOf(gd.getThoiGianVao()));
            ps.setTimestamp(3, (gd.getThoiGianRa() != null) ? Timestamp.valueOf(gd.getThoiGianRa()) : null);
            ps.setDouble(4, gd.getPhiDoXe());
            ps.setString(5, gd.getTrangThaiThanhToan());
            ps.setString(6, gd.getMaMucGiaApDung());
            ps.setString(7, gd.getMaThe());
            ps.setString(8, gd.getMaNhanVien());
            ps.setString(9, gd.getMaViTri());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<GiaoDich> findAll() {
        List<GiaoDich> list = new ArrayList<>();
        String sql = "SELECT * FROM giaodich";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                GiaoDich gd = new GiaoDich();
                gd.setMaGiaoDich(rs.getString("maGiaoDich"));
                gd.setThoiGianVao(rs.getTimestamp("thoiGianVao").toLocalDateTime());
                if (rs.getTimestamp("thoiGianRa") != null) {
                    gd.setThoiGianRa(rs.getTimestamp("thoiGianRa").toLocalDateTime());
                }
                gd.setPhiDoXe(rs.getDouble("phiDoXe"));
                gd.setTrangThaiThanhToan(rs.getString("trangThaiThanhToan"));
                gd.setMaMucGiaApDung(rs.getString("maMucGiaApDung"));
                gd.setMaThe(rs.getString("maThe"));
                gd.setMaNhanVien(rs.getString("maNhanVien"));
                gd.setMaViTri(rs.getString("maViTri"));
                list.add(gd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
