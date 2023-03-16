/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.DayLop;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import sqlserver_connection.ConnectionHelper;

/**
 *
 * @author PC
 */
public class DayLopDAO {
        public List<DayLop> getListDayLopByMaLTC(String maLTC){
        List<DayLop> listdl = new ArrayList<>();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        PreparedStatement csmt = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM DayLop WHERE MaLopTC = ?";
            
            csmt = connect.prepareCall(SQL);
            csmt.setString(1, maLTC);
            csmt.executeQuery();
            ResultSet result = csmt.getResultSet();
                while (result.next()) {
                String maLopTC = result.getString("MaLopTC");
                String maGV = result.getString("MaGV");

                DayLop cv = new DayLop(maLopTC, maGV);
                listdl.add(cv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listdl;
    }    
}
