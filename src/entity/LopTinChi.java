
package entity;

import java.util.Date;

public class LopTinChi {
    private String maLopTinChi;
    private String maMonHoc;
    private int ID_CTHKMH;
    private String hocKy;
    private String namHoc;
    private int maPNCLyThuyet;
    private int tietBatDau;
    private String phong;
    private Date ngayBD;
    private Date ngayKT;
    private int thu;
    private int soNhomTH;
    public LopTinChi() {
    }

    public LopTinChi(String maLopTinChi, String maMonHoc, int ID_CTHKMH) {
        this.maLopTinChi = maLopTinChi;
        this.maMonHoc = maMonHoc;
        this.ID_CTHKMH = ID_CTHKMH;
    }
    
    public LopTinChi(String maLopTinChi, String maMonHoc, int ID_CTHKMH, int maPNCLyThuyet, int soNhomTH) {
        this.maLopTinChi = maLopTinChi;
        this.maMonHoc = maMonHoc;
        this.ID_CTHKMH = ID_CTHKMH;
        this.maPNCLyThuyet = maPNCLyThuyet;
        this.soNhomTH = soNhomTH;
    }

    public LopTinChi(String maLopTinChi, String maMonHoc, String hocKy, String namHoc, int tietBatDau, String phong, Date ngayBD, Date ngayKT, int thu, int soNhomTH) {
        this.maLopTinChi = maLopTinChi;
        this.maMonHoc = maMonHoc;
        this.hocKy = hocKy;
        this.namHoc = namHoc;
        this.tietBatDau = tietBatDau;
        this.phong = phong;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.thu = thu;
        this.soNhomTH = soNhomTH;
    }



    public String getMaLopTinChi() {
        return maLopTinChi;
    }

    public void setMaLopTinChi(String maLopTinChi) {
        this.maLopTinChi = maLopTinChi;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public int getID_CTHKMH() {
        return ID_CTHKMH;
    }

    public void setID_CTHKMH(int ID_CTHKMH) {
        this.ID_CTHKMH = ID_CTHKMH;
    }

    public int getMaPNCLyThuyet() {
        return maPNCLyThuyet;
    }

    public void setMaPNCLyThuyet(int maPNCLyThuyet) {
        this.maPNCLyThuyet = maPNCLyThuyet;
    }

    public int getSoNhomTH() {
        return soNhomTH;
    }

    public void setSoNhomTH(int soNhomTH) {
        this.soNhomTH = soNhomTH;
    }

    public String getHocKy() {
        return hocKy;
    }

    public void setHocKy(String hocKy) {
        this.hocKy = hocKy;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    public int getTietBatDau() {
        return tietBatDau;
    }

    public void setTietBatDau(int tietBatDau) {
        this.tietBatDau = tietBatDau;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    public int getThu() {
        return thu;
    }

    public void setThu(int thu) {
        this.thu = thu;
    }

    
}
