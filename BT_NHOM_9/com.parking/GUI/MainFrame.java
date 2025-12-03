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
import Service.TheXeService;
import Service.ViTriDoService; 
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private final GiaoDichService giaoDichService;
    private final NhanVienService nhanVienService;
    private final QuanTriService quanTriService;
    private final ViTriDoService viTriDoService; 
    private final TheXeService theXeService;
    private final String role;

    public MainFrame(
    String role,
    GiaoDichService gds,
    NhanVienService nvs,
    QuanTriService qts,
    ViTriDoService vts,
    TheXeService txs
) {
    this.role = role;
    this.giaoDichService = gds;
    this.nhanVienService = nvs;
    this.quanTriService = qts;
    this.viTriDoService = vts;
    this.theXeService = txs;
    initUI();
}

    private void initUI() {
        String title = "Quản lý Bãi đỗ xe - " + ("admin".equals(role) ? "Quản trị viên" : "Nhân viên");
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(950, 650);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(Color.WHITE);


        GiaoDichListPanel listPanel = new GiaoDichListPanel(this, giaoDichService, nhanVienService);
        TaoGiaoDichPanel taoPanel = new TaoGiaoDichPanel(this, giaoDichService, nhanVienService, theXeService);
        ViTriTrongPanel vitriPanel = new ViTriTrongPanel(this, viTriDoService); 

        mainPanel.add(listPanel, "list");
        mainPanel.add(taoPanel, "tao");
        mainPanel.add(vitriPanel, "vitri");

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Chức năng");
        JMenuItem menuItem1 = new JMenuItem("Danh sách giao dịch");
        JMenuItem menuItem2 = new JMenuItem("Tạo giao dịch mới");
        JMenuItem menuItem3 = new JMenuItem("Vị trí trống");

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
