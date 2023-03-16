/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author PC
 */
public class GiangVien {
    private String maGV;
    private String ho;
    private String tenDem;
    private String ten;
    private Date ngaySinh;
    private String maHocVi;
    private boolean nghiLam;
    private String soDienThoai1;
    private String soDienThoai2;
    private String email1;
    private String email2;
    private String ghiChu;
    private int maQQ;
    public GiangVien() {
    }

    public GiangVien(String maGV, String ho, String tenDem, String ten, Date ngaySinh, String maHocVi, boolean nghiLam, String soDienThoai1, String soDienThoai2, String email1, String email2, String ghiChu, int maQQ) {
        this.maGV = maGV;
        this.ho = ho;
        this.tenDem = tenDem;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.maHocVi = maHocVi;
        this.nghiLam = nghiLam;
        this.soDienThoai1 = soDienThoai1;
        this.soDienThoai2 = soDienThoai2;
        this.email1 = email1;
        this.email2 = email2;
        this.ghiChu = ghiChu;
        this.maQQ = maQQ;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTenDem() {
        return tenDem;
    }

    public void setTenDem(String tenDem) {
        this.tenDem = tenDem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getMaHocVi() {
        return maHocVi;
    }

    public void setMaHocVi(String maHocVi) {
        this.maHocVi = maHocVi;
    }

    public boolean isNghiLam() {
        return nghiLam;
    }

    public void setNghiLam(boolean nghiLam) {
        this.nghiLam = nghiLam;
    }

    public String getSoDienThoai1() {
        return soDienThoai1;
    }

    public void setSoDienThoai1(String soDienThoai1) {
        this.soDienThoai1 = soDienThoai1;
    }

    public String getSoDienThoai2() {
        return soDienThoai2;
    }

    public void setSoDienThoai2(String soDienThoai2) {
        this.soDienThoai2 = soDienThoai2;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getmaQQ() {
        return maQQ;
    }

    public void setmaQQ(int maQQ) {
        this.maQQ = maQQ;
    }
    
}
