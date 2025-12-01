/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author yuhna
 */
import GUI.LoginFrame;
import Service.GiaoDichService;
import Service.NhanVienService;
import Service.QuanTriService;
import Service.GiaoDichServiceImpl;
import Service.NhanVienServiceImpl;
import Service.QuanTriServiceImpl;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}

            var loginFrame = new LoginFrame(
                new GiaoDichServiceImpl(),
                new NhanVienServiceImpl(),
                new QuanTriServiceImpl()
            );
            loginFrame.setVisible(true); 
        });
    }
}
