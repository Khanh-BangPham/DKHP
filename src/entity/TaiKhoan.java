/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author PC
 */
public class TaiKhoan {
    private String TenTaiKhoan;
    private String MatKhau;
    private boolean TrangThai;
    private String MaChucVu;

    public TaiKhoan(String TenTaiKhoan, String MatKhau, boolean TrangThai, String MaChucVu) {
        this.TenTaiKhoan = TenTaiKhoan;
        this.MatKhau = MatKhau;
        this.TrangThai = TrangThai;
        this.MaChucVu = MaChucVu;
    }

    public String getTenTaiKhoan() {
        return TenTaiKhoan;
    }

    public void setTenTaiKhoan(String TaiKhoan) {
        this.TenTaiKhoan = TaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getMaChucVu() {
        return MaChucVu;
    }

    public void setMaChucVu(String MaChucVu) {
        this.MaChucVu = MaChucVu;
    }
    
}
