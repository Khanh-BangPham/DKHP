/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import entity.HocVi;
import java.sql.Connection;
import java.sql.ResultSet;
import sqlserver_connection.ConnectionHelper;
import java.sql.Statement;
/**
 *
 * @author PC
 */
public class HocViDAO {
    public List<HocVi> getListHocVi(){
        List<HocVi> listHv = new ArrayList<>();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        Statement stmt = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT MaHocVi, TenHocVi FROM HocVi";
            
            stmt = connect.createStatement();
            ResultSet result = stmt.executeQuery(SQL);
                while (result.next()) {
                String maHocVi = result.getString("MaHocVi");
                String tenHocVi = result.getString("TenHocVi");

                HocVi hv = new HocVi(maHocVi, tenHocVi);
                listHv.add(hv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHv;
    }
}