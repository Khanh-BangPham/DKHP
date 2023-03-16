/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.GiaTinChi;
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
public class GiaTinChiDAO {
        public List<GiaTinChi> getListGiaTinChi(){
        List<GiaTinChi> listGtc = new ArrayList<>();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        Statement stmt = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM GiaTinChi";
            
            stmt = connect.createStatement();
            ResultSet result = stmt.executeQuery(SQL);
                while (result.next()) {
                int idgtc = result.getInt("IDGTC");
                int giaTinChi = result.getInt("GiaTien");
                GiaTinChi gtc = new GiaTinChi(idgtc, giaTinChi);
                listGtc.add(gtc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listGtc;
    }    
    public GiaTinChi getGiaTinChiByID(int maGTC){
        GiaTinChi gtc = null;
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM GiaTinChi WHERE IDGTC = ?";
            CallableStatement csmt = connect.prepareCall(SQL);
            csmt.setInt(1, maGTC);
            csmt.executeQuery();
            ResultSet result = csmt.getResultSet();
            while (result.next()) {
                int idgtc = result.getInt("IDGTC");
                int giaTinChi = result.getInt("GiaTien");
                gtc = new GiaTinChi(idgtc, giaTinChi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gtc;
    }       
    public int mergeGiaTinChiByGiaTien(int giaTien){
        GiaTinChi gtc = null;
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        int idgtc = -1;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "DECLARE @IDGTC INT " +
            "EXEC @IDGTC = MergeGiaTinChi @GiaTien = ? " +
            "SELECT RS = @IDGTC";
            CallableStatement csmt = connect.prepareCall(SQL);
            csmt.setInt(1, giaTien);
            csmt.executeQuery();
            ResultSet result = csmt.getResultSet();

            while (result.next()) {
                idgtc = result.getInt("RS");
                return idgtc;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idgtc;
    }    
}
