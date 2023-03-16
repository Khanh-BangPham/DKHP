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
public class GiaTinChi {
    private int idgtc;
    private int giaTien;
   

    public GiaTinChi() {
    }

    public GiaTinChi(int idgtc, int giaTien) {
        this.idgtc = idgtc;
        this.giaTien = giaTien;
        
    }

    public int getIdgtc() {
        return idgtc;
    }

    public void setIdgtc(int idgtc) {
        this.idgtc = idgtc;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    
}
