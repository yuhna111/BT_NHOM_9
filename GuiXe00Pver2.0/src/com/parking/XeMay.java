package com.parking;

public class XeMay extends PhuongTien {
    private int dungTichXiLanh;
    private boolean coHopSoTuDong;

    public XeMay(String bienSo, String mauSac, String hangXe, int dungTich, boolean tuDong) {
        super(bienSo, mauSac, hangXe);
        this.dungTichXiLanh = dungTich;
        this.coHopSoTuDong = tuDong;
    }

    @Override
    public double tinhKhauHao(long minutes) {
        double hours = Math.ceil(minutes / 60.0);
        return 0.5 * hours;
    }

    // Getters
    public int getDungTichXiLanh() { return dungTichXiLanh; }
    public boolean isCoHopSoTuDong() { return coHopSoTuDong; }
}