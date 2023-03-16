/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.TaiKhoanDAO;
import views.DangNhap;

/**
 *
 * @author PC
 */
public class DangNhapController {
    private DangNhap dangNhapView;
    private TaiKhoanDAO taiKhoanDAO; 

    public DangNhapController(DangNhap dangNhapView) {
        this.dangNhapView = dangNhapView;
        taiKhoanDAO = new TaiKhoanDAO();
    }
    
    public void showDangNhapView(){
        dangNhapView.setLocationRelativeTo(null);
        dangNhapView.setVisible(true);
    }
    
}
