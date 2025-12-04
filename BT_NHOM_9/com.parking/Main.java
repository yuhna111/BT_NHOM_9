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
import Service.BangGiaService;
import Service.BangGiaServiceImpl;
import Service.GiaoDichService;
import Service.GiaoDichServiceImpl;
import Service.NhanVienService;
import Service.NhanVienServiceImpl;
import Service.QuanTriService;
import Service.QuanTriServiceImpl;
import Service.TheXeService;
import Service.TheXeServiceImpl;
import Service.ViTriDoService;
import Service.ViTriDoServiceImpl;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            BangGiaService bangGiaService = new BangGiaServiceImpl();
            GiaoDichService gds = new GiaoDichServiceImpl(bangGiaService);
            NhanVienService nvs = new NhanVienServiceImpl();
            QuanTriService qts = new QuanTriServiceImpl();
            ViTriDoService vts = new ViTriDoServiceImpl();
            TheXeService txs = new TheXeServiceImpl();

            LoginFrame loginFrame = new LoginFrame(gds, nvs, qts, vts, txs);
            loginFrame.setVisible(true);
        });
    }
}


