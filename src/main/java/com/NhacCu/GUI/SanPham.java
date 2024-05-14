package com.NhacCu.GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SanPham extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JLabel iImage;
    private JLabel labMaSP;
    private JLabel labTen;
    private JLabel labGia;
    private JLabel labSLKho;
    private JLabel labGhiChu;

    public SanPham( String masp, String tensp, int gia, int soluong, String ghichu , String Image) {
        setTitle("Chi tiết sản phẩm");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 675, 690);
        setLocationRelativeTo(null);


        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(197, 251, 237));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        iImage = new JLabel("");
        iImage.setHorizontalAlignment(SwingConstants.CENTER);
        iImage.setIcon(new ImageIcon(SanPham.class.getResource("/com/NhacCu/item/123-2.jpg")));
        iImage.setBounds(10, 10, 651, 250);
        contentPane.add(iImage);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(197, 251, 237));
        panel.setBounds(10, 270, 651, 323);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Tên sản phẩm");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_1.setBounds(160, 35, 115, 37);
        panel.add(lblNewLabel_1);

        labTen = new JLabel(); // Initialize labTen
        labTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
        labTen.setBounds(337, 35, 314, 37);
        panel.add(labTen);

        JLabel lblNewLabel_1_1 = new JLabel("Giá");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_1_1.setBounds(160, 63, 115, 37);
        panel.add(lblNewLabel_1_1);

        labGia = new JLabel(); // Initialize labGia
        labGia.setHorizontalAlignment(SwingConstants.CENTER);
        labGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
        labGia.setBounds(337, 63, 115, 37);
        panel.add(labGia);

        JLabel lblVnd = new JLabel();
        lblVnd.setText("VND");
        lblVnd.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblVnd.setBounds(455, 63, 51, 37);
        panel.add(lblVnd);

        JLabel lblNewLabel_1_2 = new JLabel("Số lượng trong kho");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_1_2.setBounds(160, 93, 167, 37);
        panel.add(lblNewLabel_1_2);

        labSLKho = new JLabel(); // Initialize labSLKho
        labSLKho.setHorizontalAlignment(SwingConstants.CENTER);
        labSLKho.setFont(new Font("Tahoma", Font.PLAIN, 15));
        labSLKho.setBounds(337, 93, 115, 37);
        panel.add(labSLKho);

        JLabel lblNewLabel_1_2_1 = new JLabel("Số lượng");
        lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_1_2_1.setBounds(160, 124, 115, 37);
        panel.add(lblNewLabel_1_2_1);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField.setText("1");
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBounds(337, 129, 69, 28);
        panel.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Thêm vào giỏ hàng");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(57, 27, 193));
        btnNewButton.setIcon(new ImageIcon(SanPham.class.getResource("/com/NhacCu/item/add-to-basket.png")));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int soLuongNhap = Integer.parseInt(textField.getText().trim());

                // Lấy số lượng sản phẩm trong kho từ label
                int soLuongTrongKho = Integer.parseInt(labSLKho.getText());

                // Kiểm tra số lượng sản phẩm trong kho có đủ để thêm vào giỏ hàng không
                if (soLuongNhap <= soLuongTrongKho) {
                    // Thêm sản phẩm vào giỏ hàng
                 GioHang.addToCart(labMaSP.getText(),labTen.getText(), Integer.parseInt(labGia.getText()), soLuongNhap);
                    
                    // Hiển thị thông báo đặt hàng thành công
                    JOptionPane.showMessageDialog(SanPham.this, "Thêm vào giỏ hàng thành công!");
                    dispose();
                } else {
                    // Hiển thị thông báo lỗi nếu số lượng trong kho không đủ
                    JOptionPane.showMessageDialog(SanPham.this, "Số lượng trong kho không đủ!");
                }
            }
        });
        
       
        
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnNewButton.setBounds(125, 601, 432, 42);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel_1_3 = new JLabel("Mã sản phẩm");
        lblNewLabel_1_3.setBounds(160, 6, 115, 37);
        panel.add(lblNewLabel_1_3);
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
        
        labMaSP = new JLabel();
        labMaSP.setHorizontalAlignment(SwingConstants.CENTER);
        labMaSP.setText("<dynamic>");
        labMaSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
        labMaSP.setBounds(337, 6, 115, 37);
        panel.add(labMaSP);

        // Set the text of JLabels with data passed from the constructor
        iImage.setText("");
        labMaSP.setText(masp);
        labTen.setText(tensp);
        labGia.setText(String.valueOf(gia));
        labSLKho.setText(String.valueOf(soluong));
        iImage.setIcon(setIC(Image));
        
        JLabel lblNewLabel_1_2_1_1 = new JLabel("Ghi chú");
        lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_1_2_1_1.setBounds(160, 188, 115, 37);
        panel.add(lblNewLabel_1_2_1_1);
        
        labGhiChu = new JLabel("<html>" + ghichu.replaceAll("\n", "<br>") + "</html>");
        labGhiChu.setVerticalAlignment(SwingConstants.TOP);
        labGhiChu.setFont(new Font("Tahoma", Font.PLAIN, 15));
        labGhiChu.setBounds(337, 172, 304, 141);
        panel.add(labGhiChu);
        
        
        
    }
    public ImageIcon setIC(String path) {
		ImageIcon imgs = new ImageIcon(path);
		Image ig = imgs.getImage().getScaledInstance(iImage.getWidth() + 15, iImage.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ic = new ImageIcon(ig);
		return ic;
	}
}
