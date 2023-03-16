/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author PC
 */
public class Nhom {
    private int maNhom;
    private String tenNhom;

    public Nhom() {
    }

    public Nhom(int maNhom, String tenNhom) {
        this.maNhom = maNhom;
        this.tenNhom = tenNhom;
    }

    public int getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(int maNhom) {
        this.maNhom = maNhom;
    }

    public String getTenNhom() {
        return tenNhom;
    }

    public void setTenNhom(String tenNhom) {
        this.tenNhom = tenNhom;
    }
    
}
