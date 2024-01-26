package GKH;

import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;


public class GUI extends JFrame {
    private JLabel lbTitle, lbDc, lbGt;
    private JTextField tfDc, tfGt;
    private JButton btnTim;
    private JTable table;
    private DefaultTableModel dfModel;
    
    public GUI() {
        setTitle("Quản lý khách hàng");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        init();
    }
    
    private void init() {
        Box box = Box.createVerticalBox();
        Box bTitle = Box.createHorizontalBox();
        Box bDc = Box.createHorizontalBox();
        Box bGt = Box.createHorizontalBox();
        Box bBtn = Box.createHorizontalBox();
        bTitle.add(lbTitle = new JLabel("Quản lý khách hàng"), JLabel.CENTER);
        
        bDc.add(lbDc = new JLabel("Địa chỉ : "));
        bDc.add(tfDc = new JTextField(12));
        
        bGt.add(lbGt = new JLabel("Giới tính : "));
        bGt.add(tfGt = new JTextField(12));
        
        lbDc.setPreferredSize(lbGt.getPreferredSize());
        
        bBtn.add(btnTim = new JButton("Tìm"), JButton.CENTER);
        
        btnTim.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String dc = tfDc.getText();
                String gt = tfGt.getText();
                dfModel.setRowCount(0);
                List<Khachhang> l = new XLKH().getKH1(dc, gt);
                for (Khachhang kh : l) {
                    dfModel.addRow(new String[] {kh.SoTK, kh.Hoten, kh.GT, kh.Diachi, String.valueOf(kh.Sodu), kh.Khuyenmai()});
                }
            }
        });
        
        String []headers = {"Số tk", "Họ tên", "Giới tính", "Địa chỉ", "Số dư", "Khuyến mại"};
        dfModel = new DefaultTableModel(headers, 0);
        table = new JTable(dfModel);
        
        JScrollPane sp = new JScrollPane(table);
        
        box.add(bTitle);
        box.add(Box.createVerticalStrut(20));
        box.add(bDc);
        box.add(Box.createVerticalStrut(20));
        box.add(bGt);
        box.add(Box.createVerticalStrut(20));
        box.add(bBtn);
        box.add(Box.createVerticalStrut(20));
        box.add(sp);
        box.add(Box.createVerticalStrut(20));
        add(box);
        
        
    }
    
    public static void main(String[] args) {
        new GUI().setVisible(true);
    }
}
