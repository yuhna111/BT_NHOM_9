package gui;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends javax.swing.JFrame {

    public LoginForm() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ĐĂNG NHẬP HỆ THỐNG BÃI ĐỖ XE");
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("QUẢN LÝ BÃI ĐỖ XE", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0x0057AD));
        titleLabel.setBounds(0, 20, 400, 40);

        JLabel userLabel = new JLabel("Tên đăng nhập:");
        userLabel.setBounds(50, 100, 120, 25);
        txtUsername = new JTextField();
        txtUsername.setBounds(180, 100, 170, 25);
        txtUsername.setBorder(BorderFactory.createLineBorder(new Color(0x0057AD), 1));

        JLabel passLabel = new JLabel("Mật khẩu:");
        passLabel.setBounds(50, 140, 120, 25);
        txtPassword = new JPasswordField();
        txtPassword.setBounds(180, 140, 170, 25);
        txtPassword.setBorder(BorderFactory.createLineBorder(new Color(0x0057AD), 1));

        cmbRole = new JComboBox<>(new String[]{"Nhân viên", "Quản trị viên"});
        cmbRole.setBounds(180, 180, 170, 25);
        cmbRole.setBackground(Color.WHITE);
        cmbRole.setBorder(BorderFactory.createLineBorder(new Color(0x0057AD), 1));

        btnLogin = new JButton("ĐĂNG NHẬP");
        btnLogin.setBounds(80, 230, 120, 35);
        btnLogin.setBackground(new Color(0xFBDA0C));
        btnLogin.setForeground(new Color(0x333333));
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnLogin.setFocusPainted(false);
        btnLogin.setBorderPainted(false);
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogin.addActionListener(evt -> btnLoginActionPerformed(evt));

        btnExit = new JButton("THOÁT");
        btnExit.setBounds(200, 230, 100, 35);
        btnExit.setBackground(new Color(0x0057AD));
        btnExit.setForeground(Color.WHITE);
        btnExit.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnExit.setFocusPainted(false);
        btnExit.setBorderPainted(false);
        btnExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnExit.addActionListener(evt -> btnExitActionPerformed(evt));

        add(titleLabel);
        add(userLabel);
        add(txtUsername);
        add(passLabel);
        add(txtPassword);
        add(cmbRole);
        add(btnLogin);
        add(btnExit);

        setLayout(null);
        setSize(400, 320);
    }

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
        String user = txtUsername.getText().trim();
        String pass = new String(txtPassword.getPassword());
        String role = cmbRole.getSelectedItem().toString();

        if (role.equals("Nhân viên") && "nv1".equals(user) && "123".equals(pass)) {
            new NhanVienForm().setVisible(true);
            this.dispose();
        } else if (role.equals("Quản trị viên") && "admin".equals(user) && "admin".equals(pass)) {
            new QuanTriForm().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Sai tài khoản hoặc mật khẩu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JComboBox<String> cmbRole;
    private JButton btnLogin;
    private JButton btnExit;
}