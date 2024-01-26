package GKH;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author thangvb
 */
public class XLKH {
    Connection cn;
    public void getCon() {
        try {
            String url = "jdbc:sqlserver://THANGVB-LAPTOP\\SQLEXPRESS; databasename=DLKH; integratedsecurity=true; encrypt=false"; 
            cn = DriverManager.getConnection(url);
            System.out.println("Thanh cong");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ResultSet getKH(String dc, String gt) {
        try {
            getCon();
            String query = "SELECT * FROM tbKhachhang WHERE Diachi = '"+dc+"' AND GT = '"+gt+"'";
            PreparedStatement ps = cn.prepareStatement(query);
            return ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Khachhang> getKH1(String dc, String gt) {
        List<Khachhang> l = new ArrayList<Khachhang>();
        try {
            
            getCon();
            String query = "SELECT * FROM tbKhachhang WHERE Diachi = '"+dc+"' AND GT = '"+gt+"'";
            PreparedStatement ps = cn.prepareStatement(query);
//            return ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            if(rs != null) {
                while(rs.next()) {
                    String sotk = rs.getString(1);
                    String hoten = rs.getString(2);
                    double sodu = Double.parseDouble(rs.getString(5));
                    Khachhang kh = new Khachhang(dc, sodu, sotk, hoten, gt);
                    l.add(kh);
//                    System.out.println("");
//                    System.out.println(kh.SoTK + " " + kh.Hoten + " " + kh.Diachi + " " + kh.GT + " " + kh.Sodu + " " + kh.Khuyenmai());
                }    
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }
    public static void main(String[] args) {
        new XLKH().getKH("Hue", "Nu");
    }
}
