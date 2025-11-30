/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parking.dao;

/**
 *
 * @author yuhna
 */
import com.parking.model.KhachHang;
import com.parking.repository.KhachHangRepo;
import config.DBConnectionUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDao implements KhachHangRepo {
    private static final String INSERT_SQL = 
        "INSERT INTO KhachHang (maKhachHang, tenKhachHang) VALUES (?, ?)";
    private static final String SELECT_BY_ID_SQL = 
        "SELECT maKhachHang, tenKhachHang FROM KhachHang WHERE maKhachHang = ?";
    private static final String SELECT_ALL_SQL = 
        "SELECT maKhachHang, tenKhachHang FROM KhachHang";

    @Override
    public boolean save(KhachHang kh) {
        boolean rowInserted = false;
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            
            ps.setString(1, kh.getMaKhachHang());
            ps.setString(2, kh.getTenKhachHang());
            
            rowInserted = ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi thêm Khách Hàng: " + e.getMessage());
        }
        return rowInserted;
    }

    @Override
    public KhachHang findById(String maKhachHang) {
        KhachHang kh = null;
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            
            ps.setString(1, maKhachHang);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    kh = mapResultSetToKhachHang(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi tìm Khách Hàng: " + e.getMessage());
        }
        return kh;
    }

    @Override
    public List<KhachHang> findAll() {
        List<KhachHang> danhSach = new ArrayList<>();
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SQL);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                danhSach.add(mapResultSetToKhachHang(rs));
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi lấy danh sách Khách Hàng: " + e.getMessage());
        }
        return danhSach;
    }

    private KhachHang mapResultSetToKhachHang(ResultSet rs) throws SQLException {
        KhachHang kh = new KhachHang(
            rs.getString("maKhachHang"),
            rs.getString("tenKhachHang")
        );
        return kh;
    }
}
