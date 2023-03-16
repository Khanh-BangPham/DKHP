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
public class Phong_Ngay_Ca {
    private int maPNC;
    private int tietBD;
    private Date ngayBD;
    private Date ngayKT;
    private String Phong;
    private int thu;

    public Phong_Ngay_Ca() {
    }

    public Phong_Ngay_Ca(int maPNC, int tietBD, Date ngayBD, Date ngayKT, String Phong, int thu) {
        this.maPNC = maPNC;
        this.tietBD = tietBD;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.Phong = Phong;
        this.thu = thu;
    }

    public int getMaPNC() {
        return maPNC;
    }

    public void setMaPNC(int maPNC) {
        this.maPNC = maPNC;
    }

    public int getTietBD() {
        return tietBD;
    }

    public void setTietBD(int tietBD) {
        this.tietBD = tietBD;
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

    public String getPhong() {
        return Phong;
    }

    public void setPhong(String Phong) {
        this.Phong = Phong;
    }

    public int getThu() {
        return thu;
    }

    public void setThu(int thu) {
        this.thu = thu;
    }
    
}
