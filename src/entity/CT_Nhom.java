package entity;

public class CT_Nhom {
    
    private int id_ctn;
    private int maNhom;
    private String maLopTC;
    private int soLuongTD;
    private int soLuongDK;
    private int MaPNCThucHanh;
    public CT_Nhom() {
    }

    public CT_Nhom(int id_ctn, int maNhom, String maLopTC, int soLuongTD, int soLuongDK) {
        this.id_ctn = id_ctn;
        this.maNhom = maNhom;
        this.maLopTC = maLopTC;
        this.soLuongTD = soLuongTD;
        this.soLuongDK = soLuongDK;
    }

    public CT_Nhom(int id_ctn, int maNhom, String maLopTC, int soLuongTD, int soLuongDK, int MaPNCThucHanh) {
        this.id_ctn = id_ctn;
        this.maNhom = maNhom;
        this.maLopTC = maLopTC;
        this.soLuongTD = soLuongTD;
        this.soLuongDK = soLuongDK;
        this.MaPNCThucHanh = MaPNCThucHanh;
    }
    

    public int getId_ctn() {
        return id_ctn;
    }

    public void setId_ctn(int id_ctn) {
        this.id_ctn = id_ctn;
    }

    public int getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(int maNhom) {
        this.maNhom = maNhom;
    }

    public String getMaLopTC() {
        return maLopTC;
    }

    public void setMaLopTC(String maLopTC) {
        this.maLopTC = maLopTC;
    }

    public int getSoLuongTD() {
        return soLuongTD;
    }

    public void setSoLuongTD(int soLuongTD) {
        this.soLuongTD = soLuongTD;
    }

    public int getSoLuongDK() {
        return soLuongDK;
    }

    public void setSoLuongDK(int soLuongDK) {
        this.soLuongDK = soLuongDK;
    }

    public int getMaPNCThucHanh() {
        return MaPNCThucHanh;
    }

    public void setMaPNCThucHanh(int MaPNCThucHanh) {
        this.MaPNCThucHanh = MaPNCThucHanh;
    }
    
    
}
