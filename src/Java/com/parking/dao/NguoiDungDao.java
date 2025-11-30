/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parking.dao;

/**
 *
 * @author yuhna
 */
import com.parking.model.NguoiDung;
import com.parking.repository.NguoiDungRepo;
import config.DBConnectionUtil;
import java.sql.*;

public class NguoiDungDao implements NguoiDungRepo {
    private static final String INSERT_OR_UPDATE_SQL = 
        "INSERT INTO NguoiDung (maNguoiDung, tenDangNhap, matKhau) VALUES (?, ?, ?) " +
        "ON DUPLICATE KEY UPDATE tenDangNhap = VALUES(tenDangNhap), matKhau = VALUES(matKhau)";
    private static final String SELECT_BY_ID_SQL = 
        "SELECT maNguoiDung, tenDangNhap, matKhau FROM NguoiDung WHERE maNguoiDung = ?";
    private static final String SELECT_BY_LOGIN_SQL = 
        "SELECT maNguoiDung, tenDangNhap, matKhau FROM NguoiDung WHERE tenDangNhap = ? AND matKhau = ?";

    @Override
    public boolean save(NguoiDung nd) {
        boolean rowAffected = false;
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_OR_UPDATE_SQL)) {
            
            ps.setString(1, nd.getMaNguoiDung());
            ps.setString(2, nd.getTenDangNhap());
            ps.setString(3, nd.getMatKhau());
            
            rowAffected = ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi lưu/cập nhật Người Dùng: " + e.getMessage());
        }
        return rowAffected;
    }

    @Override
    public NguoiDung findById(String maNguoiDung) {
        NguoiDung nd = null;
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            
            ps.setString(1, maNguoiDung);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    nd = mapResultSetToNguoiDung(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi tìm Người Dùng theo ID: " + e.getMessage());
        }
        return nd;
    }

    @Override
    public NguoiDung findByUsernameAndPassword(String tenDangNhap, String matKhau) {
        NguoiDung nd = null;
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_LOGIN_SQL)) {
            
            ps.setString(1, tenDangNhap);
            ps.setString(2, matKhau);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    nd = mapResultSetToNguoiDung(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi xác thực Người Dùng: " + e.getMessage());
        }
        return nd;
    }
    
    private NguoiDung mapResultSetToNguoiDung(ResultSet rs) throws SQLException {
        NguoiDung nd = new NguoiDung(
            rs.getString("maNguoiDung"),
            rs.getString("tenDangNhap"),
            rs.getString("matKhau")
        );
        return nd;
    }
}
