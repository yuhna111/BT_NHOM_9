package GUI;

import Model.NguoiDung;
import Repository.NguoiDungRepository;
import Service.GiaoDichService;
import Service.NhanVienService;
import Service.QuanTriService;
import Service.GiaoDichServiceImpl;
import Service.NhanVienServiceImpl;
import Service.QuanTriServiceImpl;
import Service.TheXeService;
import Service.ViTriDoService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField txtUser;
    private JPasswordField txtPass;
    private JLabel lblError;
    private final GiaoDichService giaoDichService;
    private final NhanVienService nhanVienService;
    private final QuanTriService quanTriService;
    private final ViTriDoService viTriDoService;
    private final TheXeService theXeService;

   public LoginFrame(
        GiaoDichService gds,
        NhanVienService nvs,
        QuanTriService qts,
        ViTriDoService vts,
        TheXeService txs
    ) {
        this.giaoDichService = gds;
        this.nhanVienService = nvs;
        this.quanTriService = qts;
        this.viTriDoService = vts;
        this.theXeService = txs;
        initUI();
    }
  

    private void initUI() {
        setTitle("ÄÄƒng nháº­p Há»‡ Thá»‘ng");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 320);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(248, 249, 250));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblTitle = new JLabel("Há»† THá»NG QUáº¢N LÃ BÃƒI Äá»– XE", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setForeground(new Color(33, 37, 41));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 15));
        formPanel.setBackground(new Color(248, 249, 250));
        formPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));

        JLabel lblUser = new JLabel("TÃ i khoáº£n:");
        lblUser.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtUser = new JTextField(15);
        txtUser.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtUser.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(206, 212, 218)),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

        JLabel lblPass = new JLabel("Máº­t kháº©u:");
        lblPass.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPass = new JPasswordField(15);
        txtPass.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPass.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(206, 212, 218)),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

        lblError = new JLabel("", JLabel.CENTER);
        lblError.setForeground(new Color(220, 53, 69));
        lblError.setFont(new Font("Segoe UI", Font.ITALIC, 12));

        formPanel.add(lblUser);
        formPanel.add(txtUser);
        formPanel.add(lblPass);
        formPanel.add(txtPass);
        formPanel.add(new JLabel());
        formPanel.add(lblError);

        JButton btnLogin = new JButton("ÄÄƒng nháº­p");
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnLogin.setBackground(new Color(40, 167, 69));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setBorderPainted(false);
        btnLogin.setOpaque(true);
        btnLogin.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));

        btnLogin.addActionListener(new LoginHandler());

        JPanel center = new JPanel(new BorderLayout());
        center.add(formPanel, BorderLayout.CENTER);
        center.add(btnLogin, BorderLayout.SOUTH);
        center.setBackground(new Color(248, 249, 250));

        mainPanel.add(lblTitle, BorderLayout.NORTH);
        mainPanel.add(center, BorderLayout.CENTER);

        add(mainPanel);
    }

    private class LoginHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = txtUser.getText().trim();
        String password = new String(txtPass.getPassword()).trim();
        lblError.setText("");

        if (username.isEmpty() || password.isEmpty()) {
            lblError.setText("Vui lÃ²ng nháº­p Ä‘á»§ thÃ´ng tin!");
            return;
        }

        NguoiDungRepository repo = new NguoiDungRepository();
        NguoiDung nd = repo.findByUsername(username);

        if (nd == null || !nd.getMatKhau().equals(password)) {
            lblError.setText("Sai tÃ i khoáº£n hoáº·c máº­t kháº©u!");
            return;
        }

        String maND = nd.getMaNguoiDung();
        if (repo.isQuanTriVien(maND)) {
            dispose();
            new MainFrame("admin", giaoDichService, nhanVienService, quanTriService, viTriDoService, theXeService).setVisible(true);
            } else if (repo.isNhanVien(maND)) {
                dispose();
                new MainFrame("nv1", giaoDichService, nhanVienService, quanTriService, viTriDoService, theXeService).setVisible(true);
            }
        }
    }
}
