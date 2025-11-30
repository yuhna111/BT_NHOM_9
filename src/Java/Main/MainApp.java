package Main; // ⚠️ Đảm bảo package này đúng với cấu trúc thư mục của bạn

import gui.LoginForm;
import service.MockGiaoDichService;
import service.MockQuanTriService;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class MainApp {

    public static void main(String[] args) {
        MockGiaoDichService mockGiaoDich = new MockGiaoDichService();
        MockQuanTriService mockQuanTri = new MockQuanTriService();
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            LoginForm loginForm = new LoginForm(mockGiaoDich, mockQuanTri);
            loginForm.setVisible(true);
        });
    }
}