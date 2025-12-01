/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

/**
 *
 * @author yuhna
 */
import Model.TheXe;
import config.DBConnectionUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TheXeRepository {

    public void save(TheXe theXe) {
        String sql = "INSERT INTO thexe (maThe, trangThai, loaiThe, maKhachHang) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, theXe.getMaThe());
            stmt.setString(2, theXe.getTrangThai());
            stmt.setString(3, theXe.getLoaiThe());
            stmt.setString(4, theXe.getMaKhachHang());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public TheXe findByMa(String maThe) {
        String sql = "SELECT * FROM thexe WHERE maThe = ?";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, maThe);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                TheXe tx = new TheXe();
                tx.setMaThe(rs.getString("maThe"));
                tx.setTrangThai(rs.getString("trangThai"));
                tx.setLoaiThe(rs.getString("loaiThe"));
                tx.setMaKhachHang(rs.getString("maKhachHang"));
                return tx;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<TheXe> findAll() {
        List<TheXe> list = new ArrayList<>();
        String sql = "SELECT * FROM thexe";
        try (Connection conn = DBConnectionUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                TheXe tx = new TheXe();
                tx.setMaThe(rs.getString("maThe"));
                tx.setTrangThai(rs.getString("trangThai"));
                tx.setLoaiThe(rs.getString("loaiThe"));
                tx.setMaKhachHang(rs.getString("maKhachHang"));
                list.add(tx);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
