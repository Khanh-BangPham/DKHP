/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import entity.Nhom;
import java.util.ArrayList;
import sqlserver_connection.ConnectionHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author PC
 */
public class NhomDAO {
    public List<Nhom> getListNhom(){
        List<Nhom> listnhom = new ArrayList<>();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        Statement stmt = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT MaNhom, TenNhom FROM Nhom";
            
            stmt = connect.createStatement();
            ResultSet result = stmt.executeQuery(SQL);
                while (result.next()) {
                int maNhom = result.getInt("MaNhom");
                String tenNhom = result.getString("TenNhom");

                Nhom nhom = new Nhom(maNhom, tenNhom);
                listnhom.add(nhom);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listnhom;
    }
}
