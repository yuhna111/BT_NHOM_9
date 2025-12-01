/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

/**
 *
 * @author yuhna
 */
// src/Java/repository/KhuVucRepository.java
import Model.KhuVuc;
import config.DBConnectionUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhuVucRepository {

    public void save(KhuVuc khuVuc) {
        String sql = "INSERT INTO khuvuc (maKhuVuc, tenKhuVuc, maBaiDo) VALUES (?, ?, ?)";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, khuVuc.getMaKhuVuc());
            stmt.setString(2, khuVuc.getTenKhuVuc());
            stmt.setString(3, khuVuc.getMaBaiDo());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public KhuVuc findByMa(String maKhuVuc) {
        String sql = "SELECT * FROM khuvuc WHERE maKhuVuc = ?";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, maKhuVuc);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                KhuVuc kv = new KhuVuc();
                kv.setMaKhuVuc(rs.getString("maKhuVuc"));
                kv.setTenKhuVuc(rs.getString("tenKhuVuc"));
                kv.setMaBaiDo(rs.getString("maBaiDo"));
                return kv;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<KhuVuc> findAll() {
        List<KhuVuc> list = new ArrayList<>();
        String sql = "SELECT * FROM khuvuc";
        try (Connection conn = DBConnectionUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                KhuVuc kv = new KhuVuc();
                kv.setMaKhuVuc(rs.getString("maKhuVuc"));
                kv.setTenKhuVuc(rs.getString("tenKhuVuc"));
                kv.setMaBaiDo(rs.getString("maBaiDo"));
                list.add(kv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
