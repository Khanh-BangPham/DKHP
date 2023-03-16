
package dao;

import entity.CT_HocKy_NamHoc;
import entity.Phien;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sqlserver_connection.ConnectionHelper;

public class PhienDAO {
    
    public List<Phien> getListPhien() {
        List<Phien> phien = new ArrayList<>();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM Phien";
            CallableStatement stmt = connect.prepareCall(SQL);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {

                int maPhien = result.getInt("MaPhien");
                Date ngayBD = result.getDate("NgayBatDau");
                Date ngayKT = result.getDate("NgayKetThuc");
                int idhknh = result.getInt("ID_CTHKNH");
                
                phien.add(new Phien(maPhien, ngayBD, ngayKT, idhknh));
            }
            stmt.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }

        return phien;
    }
    
    public Phien getPhienByCTHKNH(int id_hknh) {
        Phien phien = new Phien();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM Phien WHERE ID_CTHKNH = ?";
            CallableStatement stmt = connect.prepareCall(SQL);
            stmt.setInt(1, id_hknh);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {

                int maPhien = result.getInt("MaPhien");
                Date ngayBD = result.getDate("NgayBatDau");
                Date ngayKT = result.getDate("NgayKetThuc");
                int idhknh = result.getInt("ID_CTHKNH");
                
                phien = new Phien(maPhien, ngayBD, ngayKT, idhknh);
            }
            stmt.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }

        return phien;
    }

    public int addPhienHocToDB(Phien p){

        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        PreparedStatement stmt = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "INSERT INTO Phien (ID_CTHKNH, NgayBatDau, NgayKetThuc) VALUES (?, ?, ?)";
            stmt = connect.prepareStatement(SQL);
            stmt.setInt(1, p.getId_cthknh());
            stmt.setDate(2, new java.sql.Date(p.getNgayBD().getTime()));
            stmt.setDate(3, new java.sql.Date(p.getNgayKT().getTime())); 
            if(stmt.executeUpdate() > 0){
                System.out.println("Insert's successed!");
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
            
        } finally{
            try {
                stmt.close();
                connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    return 1;
    }     
    public int editPhienHocToDB(Phien p){

        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        PreparedStatement stmt = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "UPDATE Phien SET ID_CTHKNH = ?, NgayBatDau = ?, NgayKetThuc = ? WHERE MaPhien = ?";
            stmt = connect.prepareStatement(SQL);
            stmt.setInt(1, p.getId_cthknh());
            stmt.setDate(2, new java.sql.Date(p.getNgayBD().getTime()));
            stmt.setDate(3, new java.sql.Date(p.getNgayKT().getTime())); 
            stmt.setInt(4, p.getMaPhien());
            if(stmt.executeUpdate() > 0){
                System.out.println("Insert's successed!");
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
            
        } finally{
            try {
                stmt.close();
                connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    return 1;
    }      
    public int delPhienToDB(int maPhien){

        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        PreparedStatement stmt = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "DELETE FROM Phien WHERE MaPhien = ?";
            stmt = connect.prepareStatement(SQL);
            stmt.setInt(1, maPhien);
  
            if(stmt.executeUpdate() > 0){
                System.out.println("Insert's successed!");
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
            
        } finally{
            try {
                stmt.close();
                connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    return 1;
    }        
    
}
