/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

/**
 *
 * @author yuhna
 */
// src/Java/repository/BangGiaRepository.java
import Model.BangGia;
import config.DBConnectionUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BangGiaRepository {

    public void save(BangGia bangGia) {
        String sql = "INSERT INTO banggia (maMucGia, loaiPhuongTien, giaTienCoBan) VALUES (?, ?, ?)";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, bangGia.getMaMucGia());
            stmt.setString(2, bangGia.getLoaiPhuongTien());
            stmt.setDouble(3, bangGia.getGiaTienCoBan());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public BangGia findByMa(String maMucGia) {
        String sql = "SELECT * FROM banggia WHERE maMucGia = ?";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, maMucGia);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                BangGia bg = new BangGia();
                bg.setMaMucGia(rs.getString("maMucGia"));
                bg.setLoaiPhuongTien(rs.getString("loaiPhuongTien"));
                bg.setGiaTienCoBan(rs.getDouble("giaTienCoBan"));
                return bg;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<BangGia> findAll() {
        List<BangGia> list = new ArrayList<>();
        String sql = "SELECT * FROM banggia";
        try (Connection conn = DBConnectionUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                BangGia bg = new BangGia();
                bg.setMaMucGia(rs.getString("maMucGia"));
                bg.setLoaiPhuongTien(rs.getString("loaiPhuongTien"));
                bg.setGiaTienCoBan(rs.getDouble("giaTienCoBan"));
                list.add(bg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

