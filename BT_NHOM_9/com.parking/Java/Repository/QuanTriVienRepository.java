/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

/**
 *
 * @author yuhna
 */
import Model.QuanTriVien;
import config.DBConnectionUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuanTriVienRepository {

    public void save(QuanTriVien quanTriVien) {
        String sql = "INSERT INTO quantrivien (maNguoiDung, viTri) VALUES (?, ?)";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, quanTriVien.getMaNguoiDung());
            stmt.setString(2, quanTriVien.getViTri());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public QuanTriVien findByMaNguoiDung(String maNguoiDung) {
        String sql = "SELECT * FROM quantrivien WHERE maNguoiDung = ?";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, maNguoiDung);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                QuanTriVien qtv = new QuanTriVien();
                qtv.setMaNguoiDung(rs.getString("maNguoiDung"));
                qtv.setViTri(rs.getString("viTri"));
                return qtv;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<QuanTriVien> findAll() {
        List<QuanTriVien> list = new ArrayList<>();
        String sql = "SELECT * FROM quantrivien";
        try (Connection conn = DBConnectionUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                QuanTriVien qtv = new QuanTriVien();
                qtv.setMaNguoiDung(rs.getString("maNguoiDung"));
                qtv.setViTri(rs.getString("viTri"));
                list.add(qtv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}