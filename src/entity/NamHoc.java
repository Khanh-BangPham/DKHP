
package entity;


public class NamHoc {
    private int maNamHoc;
    private String tenNamHoc;

    public NamHoc() {
    }

    public NamHoc(int maNamHoc, String tenNamHoc) {
        this.maNamHoc = maNamHoc;
        this.tenNamHoc = tenNamHoc;
    }
    
    

    public int getMaNamHoc() {
        return maNamHoc;
    }

    public void setMaNamHoc(int maNamHoc) {
        this.maNamHoc = maNamHoc;
    }

    public String getTenNamHoc() {
        return tenNamHoc;
    }

    public void setTenNamHoc(String tenNamHoc) {
        this.tenNamHoc = tenNamHoc;
    }
    
    
    
}
