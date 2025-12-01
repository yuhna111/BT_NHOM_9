/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author yuhna
 */
import Model.NguoiDung;
import Repository.NguoiDungRepository;
import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JPanel {
    private JTextField txtUser = new JTextField(15);
    private JPasswordField txtPass = new JPasswordField(15);
    private JButton btnLogin = new JButton("Đăng nhập");
    private MainFrame parent;

    public LoginFrame(MainFrame parent) {
        this.parent = parent;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Tài khoản:"), gbc);
        gbc.gridx = 1;
        add(txtUser, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Mật khẩu:"), gbc);
        gbc.gridx = 1;
        add(txtPass, gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        add(btnLogin, gbc);

        btnLogin.addActionListener(e -> handleLogin());
    }

    private void handleLogin() {
        String u = txtUser.getText().trim();
        String p = new String(txtPass.getPassword()).trim();
        if (u.isEmpty() || p.isEmpty()) return;

        NguoiDung nd = new NguoiDungRepository().findByUsername(u);
        if (nd != null && p.equals(nd.getMatKhau())) {
            parent.showPanel("list");
        } else {
            JOptionPane.showMessageDialog(this, "Sai tài khoản/mật khẩu!");
        }
    }
}
