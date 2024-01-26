package GKH;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author thangvb
 */
public class Test_findKH {
    public static void dogetKH(String dc, String gt) {
        try {
//            ResultSet rs = new XLKH().getKH(dc, gt);
//            if(rs != null) {
//                while(rs.next()) {
//                    String sotk = rs.getString(1);
//                    String hoten = rs.getString(2);
//                    double sodu = Double.parseDouble(rs.getString(5));
//                    Khachhang kh = new Khachhang(dc, sodu, sotk, hoten, gt);
////                    System.out.println("");
//                    System.out.println(kh.SoTK + " " + kh.Hoten + " " + kh.Diachi + " " + kh.GT + " " + kh.Sodu + " " + kh.Khuyenmai());
//                }    
//            }  
              List<Khachhang> l = new XLKH().getKH1(dc, gt);
              if(!l.isEmpty()) {
                  for (Khachhang kh : l) {
                    System.out.println(kh.SoTK + " " + kh.Hoten + " " + kh.Diachi + " " + kh.GT + " " + kh.Sodu + " " + kh.Khuyenmai());
                  }
              }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String dc = input.nextLine();
        String gt = input.nextLine();
        dogetKH(dc, gt);
    }
}
