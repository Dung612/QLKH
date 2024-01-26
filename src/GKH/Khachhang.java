package GKH;

/**
 *
 * @author thangvb
 */
public class Khachhang extends Person{
    String Diachi;
    double Sodu;

    public Khachhang() {
        super();
        Diachi = "";
        Sodu = 0;
    }

    public Khachhang(String Diachi, double Sodu, String SoTK, String Hoten, String GT) {
        super(SoTK, Hoten, GT);
        this.Diachi = Diachi;
        this.Sodu = Sodu;
    }
    
    @Override
    public String Khuyenmai() {
        if(super.GT.equals("Nu")) return "Khuyen mai";
        return "";
    }
}
