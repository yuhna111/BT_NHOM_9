/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author yuhna
 */
public abstract class PhuongTien {
    protected String bienSo;
    protected String mauSac;
    protected String hangXe;
    protected String maThe;

    public TheXe layTheLienKet() {
        return new TheXe(maThe, "Hoạt động", "Xe máy");
    }

    // Getters & Setters
    public String getBienSo() { return bienSo; }
    public void setBienSo(String bienSo) { this.bienSo = bienSo; }
    public String getMauSac() { return mauSac; }
    public void setMauSac(String mauSac) { this.mauSac = mauSac; }
    public String getHangXe() { return hangXe; }
    public void setHangXe(String hangXe) { this.hangXe = hangXe; }
    public String getMaThe() { return maThe; }
    public void setMaThe(String maThe) { this.maThe = maThe; }
}
