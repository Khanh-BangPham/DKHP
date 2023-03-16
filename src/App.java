
import controller.DangNhapController;
import dao.GiangVienDAO;
import entity.GiangVien;
import java.util.List;
import views.DangNhap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class App {
    private static DangNhap dangNhapView = new DangNhap();
    private static DangNhapController dangNhapController = new DangNhapController(dangNhapView); 
    private static GiangVienDAO gvdao = new GiangVienDAO();
    private static List<GiangVien> listgv = gvdao.getListGiangVien();
    public static void main(String args[]) {
        /* Create and display the form */
            dangNhapController.showDangNhapView();
    }
}


