package gui;

import com.parking.BangGia;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuanTriForm extends javax.swing.JFrame {

    public static double tongDoanhThu = 0.0;
    public static int tongSoXeDaXuLy = 0;

    public QuanTriForm() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setTitle("QUẢN TRỊ VIÊN");
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("QUẢN TRỊ HỆ THỐNG", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(new Color(0x0057AD));
        titleLabel.setBounds(0, 20, 400, 30);

        btnXemDoanhThu = new JButton("Xem báo cáo doanh thu");
        btnXemDoanhThu.setBounds(100, 80, 200, 35);
        btnXemDoanhThu.setBackground(new Color(0x0057AD));
        btnXemDoanhThu.setForeground(Color.WHITE);
        btnXemDoanhThu.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnXemDoanhThu.setFocusPainted(false);
        btnXemDoanhThu.setBorderPainted(false);
        btnXemDoanhThu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnXemDoanhThu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String report = String.format(
                    "Doanh thu hôm nay: %,.0f VNĐ\nTổng xe đã xử lý: %d lượt",
                    tongDoanhThu, tongSoXeDaXuLy
                );
                showCustomMessage(report);
            }
        });

        JLabel lblLoaiGia = new JLabel("Loại phương tiện:");
        lblLoaiGia.setBounds(80, 140, 130, 25);
        cmbLoaiGia = new JComboBox<>(new String[]{"XEMAY", "OTO"});
        cmbLoaiGia.setBounds(220, 140, 100, 25);
        cmbLoaiGia.setBorder(BorderFactory.createLineBorder(new Color(0x0057AD), 1));

        JLabel lblGiaMoi = new JLabel("Giá mới (VNĐ/giờ):");
        lblGiaMoi.setBounds(80, 180, 150, 25);
        txtGiaMoi = new JTextField();
        txtGiaMoi.setBounds(220, 180, 100, 25);
        txtGiaMoi.setBorder(BorderFactory.createLineBorder(new Color(0x0057AD), 1));

        btnCapNhat = new JButton("Cập nhật");
        btnCapNhat.setBounds(150, 220, 100, 30);
        btnCapNhat.setBackground(new Color(0xFBDA0C));
        btnCapNhat.setForeground(new Color(0x333333));
        btnCapNhat.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnCapNhat.setFocusPainted(false);
        btnCapNhat.setBorderPainted(false);
        btnCapNhat.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCapNhat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String loai = cmbLoaiGia.getSelectedItem().toString();
                try {
                    double gia = Double.parseDouble(txtGiaMoi.getText().trim());
                    if (gia <= 0) throw new NumberFormatException();
                    
                    BangGia.capNhatGiaTheoLoai(loai, gia);
                    
                    showCustomMessage("Đã cập nhật giá cho " + loai + ": " + (int) gia + " VNĐ/giờ");
                } catch (NumberFormatException ex) {
                    showCustomMessage("Vui lòng nhập giá hợp lệ!");
                }
            }
        });

        btnDangXuat = new JButton("Đăng xuất");
        btnDangXuat.setBounds(150, 280, 100, 30);
        btnDangXuat.setBackground(new Color(0x0057AD));
        btnDangXuat.setForeground(Color.WHITE);
        btnDangXuat.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnDangXuat.setFocusPainted(false);
        btnDangXuat.setBorderPainted(false);
        btnDangXuat.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnDangXuat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new LoginForm().setVisible(true);
                QuanTriForm.this.dispose();
            }
        });

        add(titleLabel);
        add(btnXemDoanhThu);
        add(lblLoaiGia);
        add(cmbLoaiGia);
        add(lblGiaMoi);
        add(txtGiaMoi);
        add(btnCapNhat);
        add(btnDangXuat);

        setLayout(null);
        setSize(400, 350);
    }

    
    private void showCustomMessage(String message) {
        JDialog dialog = new JDialog(this, "Thông báo", true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel(new BorderLayout(10, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        panel.setBackground(Color.WHITE);
        
       
        JTextArea lblMessage = new JTextArea(message);
        lblMessage.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblMessage.setForeground(new Color(0x333333));
        lblMessage.setEditable(false);
        lblMessage.setLineWrap(true); // TỰ ĐỘNG XUỐNG DÒNG
        lblMessage.setWrapStyleWord(true); // NGẮT TỪ
        lblMessage.setOpaque(false);
        lblMessage.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        
        
        lblMessage.setCaretPosition(0);
        Dimension preferredSize = lblMessage.getPreferredSize();
        int width = Math.min(400, preferredSize.width + 40);
        int height = Math.min(200, preferredSize.height + 50);
        
        lblMessage.setPreferredSize(new Dimension(width, height));
        
        JButton btnOK = new JButton("OK");
        btnOK.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnOK.setBackground(new Color(0x0057AD));
        btnOK.setForeground(Color.WHITE);
        btnOK.setFocusPainted(false);
        btnOK.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        btnOK.setBorderPainted(false);
        btnOK.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnOK.setPreferredSize(new Dimension(80, 30));
        btnOK.addActionListener(e -> dialog.dispose());
        
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPanel.setBackground(Color.WHITE);
        btnPanel.add(btnOK);
        
        panel.add(lblMessage, BorderLayout.CENTER);
        panel.add(btnPanel, BorderLayout.SOUTH);
        
        dialog.add(panel);
        dialog.pack();  
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private JButton btnXemDoanhThu;
    private JComboBox<String> cmbLoaiGia;
    private JTextField txtGiaMoi;
    private JButton btnCapNhat;
    private JButton btnDangXuat;
}