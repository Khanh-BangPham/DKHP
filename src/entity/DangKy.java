package entity;

public class DangKy {
    
    private String maSV;
    private int id_ctn;

    public DangKy() {
    }

    public DangKy(String maSV, int id_ctn) {
        this.maSV = maSV;
        this.id_ctn = id_ctn;
    }
    
    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public int getId_ctn() {
        return id_ctn;
    }

    public void setId_ctn(int id_ctn) {
        this.id_ctn = id_ctn;
    }
    
    
    
    
}
