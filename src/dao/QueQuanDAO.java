/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import entity.QueQuan;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import sqlserver_connection.ConnectionHelper;
import java.sql.Statement;
/**
 *
 * @author PC
 */
public class QueQuanDAO {
    public List<QueQuan> getListQueQuan(){
        List<QueQuan> listQq = new ArrayList<>();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        Statement stmt = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM QueQuan";
            
            stmt = connect.createStatement();
            ResultSet result = stmt.executeQuery(SQL);
                while (result.next()) {
                int maQQ = result.getInt("MaQQ");
                String tenQQ = result.getString("TenQQ");

                QueQuan qq = new QueQuan(maQQ, tenQQ);
                listQq.add(qq);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listQq;
    }
    
        public QueQuan getQueQuanByID(int maQQ){
        QueQuan qq = new QueQuan();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM QueQuan WHERE MaQQ = ?";
            CallableStatement csmt = connect.prepareCall(SQL);
            csmt.setInt(1, maQQ);
            csmt.executeQuery();
            ResultSet result = csmt.getResultSet();
            while (result.next()) {
                int maQuequan = result.getInt("MaQQ");
                String tenQQ = result.getString("TenQQ");
                
                qq = new QueQuan(maQuequan, tenQQ);
            }
            csmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return qq;
    }
}
