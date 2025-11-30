/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parking.dao;

/**
 *
 * @author yuhna
 */
import com.parking.model.NhanVien;
import com.parking.model.NguoiDung;
import com.parking.repository.NhanVienRepo;
import config.DBConnectionUtil;
import java.sql.*;

public class NhanVienDao implements NhanVienRepo {
    private final NguoiDungDao nguoiDungDao = new NguoiDungDao(); 
    private static final String SELECT_BY_ID_SQL = 
        "SELECT nv.maNhanVien, nv.caLamViec, nd.maNguoiDung, nd.tenDangNhap, nd.matKhau " +
        "FROM NhanVien nv JOIN NguoiDung nd ON nv.maNguoiDung = nd.maNguoiDung " +
        "WHERE nv.maNhanVien = ?";
        
    private static final String SELECT_BY_LOGIN_SQL = 
        "SELECT nv.maNhanVien, nv.caLamViec, nd.maNguoiDung, nd.tenDangNhap, nd.matKhau " +
        "FROM NhanVien nv JOIN NguoiDung nd ON nv.maNguoiDung = nd.maNguoiDung " +
        "WHERE nd.tenDangNhap = ? AND nd.matKhau = ?";
    
    @Override
    public boolean save(NhanVien nv) {
        return false; 
    }

    @Override
    public NhanVien findById(String maNhanVien) {
        NhanVien nv = null;
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            
            ps.setString(1, maNhanVien);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    nv = mapResultSetToNhanVien(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi tìm Nhân Viên: " + e.getMessage());
        }
        return nv;
    }
    
    @Override
    public NhanVien findByUsernameAndPassword(String tenDangNhap, String matKhau) {
        NhanVien nv = null;
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_LOGIN_SQL)) {
            
            ps.setString(1, tenDangNhap);
            ps.setString(2, matKhau);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    nv = mapResultSetToNhanVien(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi đăng nhập: " + e.getMessage());
        }
        return nv;
    }
    
    private NhanVien mapResultSetToNhanVien(ResultSet rs) throws SQLException {
        String maNguoiDung = rs.getString("maNguoiDung");
        String tenDangNhap = rs.getString("tenDangNhap");
        String matKhau = rs.getString("matKhau");
        String maNhanVien = rs.getString("maNhanVien");
        String caLamViec = rs.getString("caLamViec");

        NhanVien nv = new NhanVien(
            maNguoiDung,      
            tenDangNhap,    
            matKhau,          
            maNhanVien,     
            caLamViec         
        );
        return nv;
    }
}