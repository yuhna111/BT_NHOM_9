/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

/**
 *
 * @author yuhna
 */
import Model.GiaoDich;
import config.DBConnectionUtil;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GiaoDichRepository {
    public void insert(GiaoDich gd) {
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

    public void update(GiaoDich gd) {
        String sql = """
            UPDATE giaodich 
            SET thoiGianRa = ?, phiDoXe = ?, trangThaiThanhToan = ?
            WHERE maGiaoDich = ?
            """;
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setTimestamp(1, Timestamp.valueOf(gd.getThoiGianRa()));
            ps.setDouble(2, gd.getPhiDoXe());
            ps.setString(3, gd.getTrangThaiThanhToan());
            ps.setString(4, gd.getMaGiaoDich());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public GiaoDich findByMa(String maGiaoDich) {
        String sql = "SELECT * FROM giaodich WHERE maGiaoDich = ?";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, maGiaoDich);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                GiaoDich gd = new GiaoDich();
                gd.setMaGiaoDich(rs.getString("maGiaoDich"));
                gd.setThoiGianVao(rs.getTimestamp("thoiGianVao").toLocalDateTime());

                Timestamp tsRa = rs.getTimestamp("thoiGianRa");
                gd.setThoiGianRa(tsRa != null ? tsRa.toLocalDateTime() : null);

                gd.setPhiDoXe(rs.getDouble("phiDoXe"));
                gd.setTrangThaiThanhToan(rs.getString("trangThaiThanhToan"));
                gd.setMaMucGiaApDung(rs.getString("maMucGiaApDung"));
                gd.setMaThe(rs.getString("maThe"));
                gd.setMaNhanVien(rs.getString("maNhanVien"));
                gd.setMaViTri(rs.getString("maViTri"));

                return gd;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<GiaoDich> findAll() {
        List<GiaoDich> list = new ArrayList<>();
        String sql = "SELECT * FROM giaodich";
        try (Connection conn = DBConnectionUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                GiaoDich gd = new GiaoDich();
                gd.setMaGiaoDich(rs.getString("maGiaoDich"));
                gd.setThoiGianVao(rs.getTimestamp("thoiGianVao").toLocalDateTime());

                Timestamp tsRa = rs.getTimestamp("thoiGianRa");
                gd.setThoiGianRa(tsRa != null ? tsRa.toLocalDateTime() : null);

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
