/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author yuhna
 */
import Service.GiaoDichService;
import Service.NhanVienService;
import Service.QuanTriService;
import Service.ViTriDoServiceImpl;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    private final GiaoDichService giaoDichService;
    private final NhanVienService nhanVienService;
    private final QuanTriService quanTriService;
    private final String role; 

    public MainFrame(
        String role,
        GiaoDichService giaoDichService,
        NhanVienService nhanVienService,
        QuanTriService quanTriService
    ) {
        this.role = role;
        this.giaoDichService = giaoDichService;
        this.nhanVienService = nhanVienService;
        this.quanTriService = quanTriService;

        initUI();
    }

    private void initUI() {
        String title = "Quan Ly Bai Do Xe - " + ("admin".equals(role) ? "Quản Trị Viên" : "Nhân Viên");
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(950, 650);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(Color.WHITE);

        GiaoDichListPanel listPanel = new GiaoDichListPanel(this, giaoDichService, nhanVienService);
        TaoGiaoDichPanel taoPanel = new TaoGiaoDichPanel(this, giaoDichService, nhanVienService);
        ViTriTrongPanel vitriPanel = new ViTriTrongPanel(this, new ViTriDoServiceImpl());

        mainPanel.add(listPanel, "list");
        mainPanel.add(taoPanel, "tao");
        mainPanel.add(vitriPanel, "vitri");

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Chức năng");
        
        JMenuItem menuItem1 = new JMenuItem("Danh Sách Giao Dịch");
        JMenuItem menuItem2 = new JMenuItem("Tạo giao dịch mới");
        JMenuItem menuItem3 = new JMenuItem("Vị Trí Trống");

        menuItem1.addActionListener(e -> showPanel("list"));
        menuItem2.addActionListener(e -> showPanel("tao"));
        menuItem3.addActionListener(e -> showPanel("vitri"));

        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        add(mainPanel);
        showPanel("list");
    }

    public void showPanel(String name) {
        cardLayout.show(mainPanel, name);
    }

    public String getRole() {
        return role;
    }
}
