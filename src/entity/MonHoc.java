
package entity;


public class MonHoc {
    private String maMonHoc;
    private String tenMonhoc;
    private int soTicChi;
    public MonHoc() {
    }

    public MonHoc(String maMonHoc, String tenMonhoc, int soTicChi) {
        this.maMonHoc = maMonHoc;
        this.tenMonhoc = tenMonhoc;
        this.soTicChi = soTicChi;
    }
    
    

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getTenMonhoc() {
        return tenMonhoc;
    }

    public void setTenMonhoc(String tenMonhoc) {
        this.tenMonhoc = tenMonhoc;
    }

    public int getSoTicChi() {
        return soTicChi;
    }

    public void setSoTicChi(int soTicChi) {
        this.soTicChi = soTicChi;
    }

}
