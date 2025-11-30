import gui.LoginForm;

public class MainApp {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            // 🔁 RESET TOÀN BỘ DOANH THU KHI KHỞI ĐỘNG LẠI ỨNG DỤNG
            gui.QuanTriForm.tongDoanhThu = 0.0;
            gui.QuanTriForm.tongSoXeDaXuLy = 0;
            
            new LoginForm().setVisible(true);
        });
    }
}