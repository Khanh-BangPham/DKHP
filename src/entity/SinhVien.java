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
public class SinhVien {
    private String MaSV;
    private String Ho;
    private String TenDem;
    private String Ten;
    private boolean Phai;
    private Date NgaySinh;
    private String LopKhoaHoc;
    private String ChuongTrinhDaoTao;
    private String SoDienThoai1;
    private String SoDienThoai2;  
    private String Email1;
    private String Email2;
    private boolean NghiHoc;
    private int MaNganh;
    private int MaQQ;

    public SinhVien() {
    }
    
    public SinhVien(String MaSV, String Ho, String TenDem, String Ten, boolean Phai, Date NgaySinh, String LopKhoaHoc, String ChuongTrinhDaoTao, String SoDienThoai1, String SoDienThoai2, String Email1, String Email2, boolean NghiHoc, int MaNganh, int MaQQ) {
        this.MaSV = MaSV;
        this.Ho = Ho;
        this.TenDem = TenDem;
        this.Ten = Ten;
        this.Phai = Phai;
        this.NgaySinh = NgaySinh;
        this.LopKhoaHoc = LopKhoaHoc;
        this.ChuongTrinhDaoTao = ChuongTrinhDaoTao;
        this.SoDienThoai1 = SoDienThoai1;
        this.SoDienThoai2 = SoDienThoai2;
        this.Email1 = Email1;
        this.Email2 = Email2;
        this.NghiHoc = NghiHoc;
        this.MaNganh = MaNganh;
        this.MaQQ = MaQQ;
    }

    public SinhVien(String Ho, String TenDem, String Ten, Date NgaySinh, String LopKhoaHoc, String ChuongTrinhDaoTao, String SoDienThoai1, String SoDienThoai2, String Email1, String Email2, boolean NghiHoc, int MaNganh, int MaQQ) {
        this.Ho = Ho;
        this.TenDem = TenDem;
        this.Ten = Ten;
        this.NgaySinh = NgaySinh;
        this.LopKhoaHoc = LopKhoaHoc;
        this.ChuongTrinhDaoTao = ChuongTrinhDaoTao;
        this.SoDienThoai1 = SoDienThoai1;
        this.SoDienThoai2 = SoDienThoai2;
        this.Email1 = Email1;
        this.Email2 = Email2;
        this.NghiHoc = NghiHoc;
        this.MaNganh = MaNganh;
        this.MaQQ = MaQQ;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getHo() {
        return Ho;
    }

    public void setHo(String Ho) {
        this.Ho = Ho;
    }

    public String getTenDem() {
        return TenDem;
    }

    public void setTenDem(String TenDem) {
        this.TenDem = TenDem;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public boolean isPhai() {
        return Phai;
    }

    public void setPhai(boolean Phai) {
        this.Phai = Phai;
    }


    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getLopKhoaHoc() {
        return LopKhoaHoc;
    }

    public void setLopKhoaHoc(String LopKhoaHoc) {
        this.LopKhoaHoc = LopKhoaHoc;
    }

    public String getChuongTrinhDaoTao() {
        return ChuongTrinhDaoTao;
    }

    public void setChuongTrinhDaoTao(String ChuongTrinhDaoTao) {
        this.ChuongTrinhDaoTao = ChuongTrinhDaoTao;
    }

    public String getSoDienThoai1() {
        return SoDienThoai1;
    }

    public void setSoDienThoai1(String SoDienThoai1) {
        this.SoDienThoai1 = SoDienThoai1;
    }

    public String getSoDienThoai2() {
        return SoDienThoai2;
    }

    public void setSoDienThoai2(String SoDienThoai2) {
        this.SoDienThoai2 = SoDienThoai2;
    }

    public String getEmail1() {
        return Email1;
    }

    public void setEmail1(String Email1) {
        this.Email1 = Email1;
    }

    public String getEmail2() {
        return Email2;
    }

    public void setEmail2(String Email2) {
        this.Email2 = Email2;
    }

    public boolean isNghiHoc() {
        return NghiHoc;
    }

    public void setNghiHoc(boolean NghiHoc) {
        this.NghiHoc = NghiHoc;
    }

    public int getMaNganh() {
        return MaNganh;
    }

    public void setMaNganh(int MaNganh) {
        this.MaNganh = MaNganh;
    }

    public int getMaQQ() {
        return MaQQ;
    }

    public void setMaQQ(int MaQQ) {
        this.MaQQ = MaQQ;
    }
    
    
}
