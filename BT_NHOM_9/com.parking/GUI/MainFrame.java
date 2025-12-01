/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author yuhna
 */
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainFrame() {
        setTitle("🚗 Quản lý Bãi đỗ xe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 650);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Thêm các panel
        mainPanel.add(new LoginFrame(this), "login");
        mainPanel.add(new GiaoDichListPanel(this), "list");
        mainPanel.add(new TaoGiaoDichPanel(this), "tao");
        mainPanel.add(new ViTriTrongPanel(this), "vitri");

        add(mainPanel);
        cardLayout.show(mainPanel, "login");
    }

    public void showPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }
}