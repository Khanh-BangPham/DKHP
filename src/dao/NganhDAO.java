/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Nganh;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sqlserver_connection.ConnectionHelper;

/**
 *
 * @author PC
 */
public class NganhDAO {
    public List<Nganh> getListNganh() {
        List<Nganh> listNganh = new ArrayList<>();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM Nganh";
            Statement stmt = connect.createStatement();
            ResultSet result = stmt.executeQuery(SQL);
            while (result.next()) {
                int maNganh = result.getInt("MaNganh");
                String tenNganh = result.getString("TenNganh");
                
                Nganh nganh = new Nganh(maNganh, tenNganh);
                listNganh.add(nganh);
            }
            stmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }
        
        return listNganh;
    }
    public Nganh getNganhByName(String TenNganh) {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        Nganh nganh = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM Nganh WHERE TenNganh = ?";
            CallableStatement csmt = connect.prepareCall(SQL);
            csmt.setString(1, TenNganh);
            csmt.executeQuery();
            ResultSet result = csmt.getResultSet();
            while (result.next()) {
                int maNganh = result.getInt("MaNganh");
                String tenNganh = result.getString("TenNganh");
                
                nganh = new Nganh(maNganh, tenNganh);
                return nganh;
            }
            csmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }
        return nganh;
    }
}
