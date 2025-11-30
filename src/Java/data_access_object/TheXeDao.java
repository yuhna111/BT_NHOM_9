package com.parking.dao;

import com.parking.model.TheXe;
import com.parking.model.KhachHang; 
import com.parking.repository.TheXeRepo;
import com.parking.repository.KhachHangRepo; 
import config.DBConnectionUtil;
import java.sql.*;

public class TheXeDao implements TheXeRepo {
    private final KhachHangRepo khachHangRepo = new KhachHangDao(); 
    private static final String INSERT_SQL = 
        "INSERT INTO TheXe (maThe, trangThai, loaiThe, maKhachHang) VALUES (?, ?, ?, ?)";
    private static final String SELECT_BY_ID_SQL = 
        "SELECT maThe, trangThai, loaiThe, maKhachHang FROM TheXe WHERE maThe = ?";
    private static final String UPDATE_STATUS_SQL = 
        "UPDATE TheXe SET trangThai = ? WHERE maThe = ?";

    @Override
    public boolean save(TheXe theXe) {
        boolean rowInserted = false;
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            
            ps.setString(1, theXe.getMaThe());
            ps.setString(2, theXe.getTrangThai());
            ps.setString(3, theXe.getLoaiThe());
            ps.setString(4, theXe.getChuSoHuu().getMaKhachHang()); 
            rowInserted = ps.executeUpdate() > 0;        
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi thêm thẻ xe: " + e.getMessage());
        }
        return rowInserted;
    }
    
    @Override
    public TheXe findByMaThe(String maThe) {
        TheXe theXe = null;
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            
            ps.setString(1, maThe);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    theXe = mapResultSetToTheXe(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi tìm thẻ xe: " + e.getMessage());
        }
        return theXe;
    }
    
    @Override
    public boolean updateTrangThai(String maThe, String trangThai) {
        boolean rowUpdated = false;
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(UPDATE_STATUS_SQL)) {
            
            ps.setString(1, trangThai);
            ps.setString(2, maThe);
            rowUpdated = ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi cập nhật trạng thái thẻ: " + e.getMessage());
        }
        return rowUpdated;
    }
   
    private TheXe mapResultSetToTheXe(ResultSet rs) throws SQLException {
        String maKhachHang = rs.getString("maKhachHang");
        KhachHang chuSoHuu = khachHangRepo.findById(maKhachHang);
        TheXe theXe = new TheXe(
            rs.getString("maThe"),
            chuSoHuu
        );
        theXe.setTrangThai(rs.getString("trangThai"));
        theXe.setLoaiThe(rs.getString("loaiThe"));       
        return theXe;
    }
}