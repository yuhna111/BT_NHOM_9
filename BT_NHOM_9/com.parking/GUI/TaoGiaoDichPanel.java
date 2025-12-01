/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author yuhna
 */
import Model.GiaoDich;
import Service.GiaoDichService;
import Service.NhanVienService;
import javax.swing.*;
import java.awt.*;

public class TaoGiaoDichPanel extends JPanel {
    private final GiaoDichService giaoDichService;
    private final NhanVienService nhanVienService;
    private final MainFrame parent;

    private JTextField txtMaThe = new JTextField(20);
    private JTextField txtMaNhanVien = new JTextField(20);
    private JTextField txtMaViTri = new JTextField(20);

    public TaoGiaoDichPanel(
        MainFrame parent,
        GiaoDichService giaoDichService,
        NhanVienService nhanVienService
    ) {
        this.parent = parent;
        this.giaoDichService = giaoDichService;
        this.nhanVienService = nhanVienService;
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JPanel form = new JPanel(new GridLayout(4, 2, 10, 15));
        form.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        form.setBackground(Color.WHITE);

        form.add(new JLabel("Mã thẻ xe:"));
        form.add(txtMaThe);
        form.add(new JLabel("Mã nhân viên:"));
        form.add(txtMaNhanVien);
        form.add(new JLabel("Mã vị trí đỗ:"));
        form.add(txtMaViTri);

        JButton btnTao = new JButton("Tạo giao dịch");
        btnTao.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnTao.setBackground(new Color(0, 123, 255));
        btnTao.setForeground(Color.WHITE);
        btnTao.setFocusPainted(false);
        btnTao.setBorderPainted(false);
        btnTao.setOpaque(true);
        btnTao.addActionListener(e -> taoGiaoDich());

        JPanel center = new JPanel(new BorderLayout());
        center.add(form, BorderLayout.NORTH);
        center.add(btnTao, BorderLayout.SOUTH);
        center.setBackground(Color.WHITE);

        add(center);
    }

    private void taoGiaoDich() {
        String maThe = txtMaThe.getText().trim();
        String maNV = txtMaNhanVien.getText().trim();
        String maVT = txtMaViTri.getText().trim();

        if (maThe.isEmpty() || maNV.isEmpty() || maVT.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin!", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            GiaoDich gd = giaoDichService.taoGiaoDichMoi(maThe, maNV, maVT);
            JOptionPane.showMessageDialog(
                this,
                "Tạo giao dịch thành công!\nMã: " + gd.getMaGiaoDich(),
                "Thành công",
                JOptionPane.INFORMATION_MESSAGE
            );
            parent.showPanel("list");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(
                this,
                "Lỗi: " + ex.getMessage(),
                "Lỗi hệ thống",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}

