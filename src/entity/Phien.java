
package entity;

import java.util.Date;

public class Phien {
    
    private int maPhien;
    private Date ngayBD;
    private Date ngayKT;
    private int id_cthknh;
    public Phien() {
    }

    public Phien(int maPhien, Date ngayBD, Date ngayKT, int id_cthknh) {
        this.maPhien = maPhien;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.id_cthknh = id_cthknh;
    }

    
    
    public int getMaPhien() {
        return maPhien;
    }

    public void setMaPhien(int maPhien) {
        this.maPhien = maPhien;
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

    public int getId_cthknh() {
        return id_cthknh;
    }

    public void setId_cthknh(int id_cthknh) {
        this.id_cthknh = id_cthknh;
    }
    
    
    
}
