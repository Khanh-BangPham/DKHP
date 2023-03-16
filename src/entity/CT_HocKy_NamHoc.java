
package entity;

import java.util.Date;


public class CT_HocKy_NamHoc {
    private int id_cthknh;
    private int maHocKy;
    private int MaNamHoc;
    private int idgtc;
    private Date ngayBatDau;
    private Date ngayKetThuc;

    public CT_HocKy_NamHoc() {
    }

    public CT_HocKy_NamHoc(int id_cthknh, int maHocKy, int maMH, int idgtc, Date ngayBatDau, Date ngayKetThuc) {
        this.id_cthknh = id_cthknh;
        this.maHocKy = maHocKy;
        this.MaNamHoc = maMH;
        this.idgtc = idgtc;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }
    
    
    public int getId_cthknh() {
        return id_cthknh;
    }

    public void setId_cthknh(int id_cthknh) {
        this.id_cthknh = id_cthknh;
    }

    public int getMaHocKy() {
        return maHocKy;
    }

    public void setMaHocKy(int maHocKy) {
        this.maHocKy = maHocKy;
    }

    public int getMaNamHoc() {
        return MaNamHoc;
    }

    public void setMaNamHoc(int MaNamHoc) {
        this.MaNamHoc = MaNamHoc;
    }



    public int getIdgtc() {
        return idgtc;
    }

    public void setIdgtc(int idgtc) {
        this.idgtc = idgtc;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngaeyKetThuc) {
        this.ngayKetThuc = ngaeyKetThuc;
    }

}
