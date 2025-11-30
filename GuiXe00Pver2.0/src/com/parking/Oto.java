package com.parking;

public class Oto extends PhuongTien {
    private int soChoNgoi;
    private String dungTichDongCo;

    public Oto(String bienSo, String mauSac, String hangXe, int soCho, String dungTich) {
        super(bienSo, mauSac, hangXe);
        this.soChoNgoi = soCho;
        this.dungTichDongCo = dungTich;
    }

    public double tinhThueTruocBa() {
        return 0;
    }

    @Override
    public double tinhKhauHao(long minutes) {
        double hours = Math.ceil(minutes / 60.0);
        return 1.5 * hours;
    }

    // Getters
    public int getSoChoNgoi() { return soChoNgoi; }
    public String getDungTichDongCo() { return dungTichDongCo; }
}