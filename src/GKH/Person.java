package GKH;

/**
 *
 * @author thangvb
 */
public abstract class Person {
    static int count = 1;
    String SoTK;
    String Hoten;
    String GT;

    public Person() {
        SoTK = String.format("%05d", count++);
        Hoten = "";
        GT = "";
    }

    public Person(String SoTK, String Hoten, String GT) {
        this.SoTK = SoTK;
        this.Hoten = Hoten;
        this.GT = GT;
    }

    public String getSoTK() {
        return SoTK;
    }

    public void setSoTK(String SoTK) {
        this.SoTK = SoTK;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public String getGT() {
        return GT;
    }

    public void setGT(String GT) {
        this.GT = GT;
    }
    
    public abstract String Khuyenmai();
}
