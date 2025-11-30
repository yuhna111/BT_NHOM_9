/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

/**
 *
 * @author yuhna
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/QuanLyBaiDoXe"; 
    private static final String USER = "root"; 
    private static final String PASS = "123456"; 

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.err.println("Lỗi: Không tìm thấy Driver JDBC. Hãy kiểm tra lại file JAR.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Lỗi SQL: Không thể kết nối DB. Kiểm tra DB có đang chạy không, Tên DB, User/Pass.");
            e.printStackTrace();
        }
        return conn;
    }
}
