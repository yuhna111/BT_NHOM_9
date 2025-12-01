/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

/**
 *
 * @author yuhna
 */
import Model.NguoiDung;
import config.DBConnectionUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NguoiDungRepository {

    public void save(NguoiDung nguoiDung) {
        String sql = "INSERT INTO nguoidung (maNguoiDung, tenDangNhap, matKhau) VALUES (?, ?, ?)";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nguoiDung.getMaNguoiDung());
            stmt.setString(2, nguoiDung.getTenDangNhap());
            stmt.setString(3, nguoiDung.getMatKhau());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public NguoiDung findByMa(String maNguoiDung) {
        String sql = "SELECT * FROM nguoidung WHERE maNguoiDung = ?";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, maNguoiDung);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                NguoiDung nd = new NguoiDung();
                nd.setMaNguoiDung(rs.getString("maNguoiDung"));
                nd.setTenDangNhap(rs.getString("tenDangNhap"));
                nd.setMatKhau(rs.getString("matKhau"));
                return nd;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public NguoiDung findByUsername(String username) {
        String sql = "SELECT * FROM nguoidung WHERE tenDangNhap = ?";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                NguoiDung nd = new NguoiDung();
                nd.setMaNguoiDung(rs.getString("maNguoiDung"));
                nd.setTenDangNhap(rs.getString("tenDangNhap"));
                nd.setMatKhau(rs.getString("matKhau"));
                return nd;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<NguoiDung> findAll() {
        List<NguoiDung> list = new ArrayList<>();
        String sql = "SELECT * FROM nguoidung";
        try (Connection conn = DBConnectionUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                NguoiDung nd = new NguoiDung();
                nd.setMaNguoiDung(rs.getString("maNguoiDung"));
                nd.setTenDangNhap(rs.getString("tenDangNhap"));
                nd.setMatKhau(rs.getString("matKhau"));
                list.add(nd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}