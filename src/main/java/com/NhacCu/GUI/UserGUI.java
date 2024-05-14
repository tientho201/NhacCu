package com.NhacCu.GUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.NhacCu.Connect.ConnectJDBC;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.GridLayout;


public class UserGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel labXinChao;
	public JLabel ten;
	private String tenDangNhap;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
							.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							javax.swing.UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
					UserGUI frame = new UserGUI("");
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserGUI(String tenDangNhap) {
		setTitle("Khách hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(197, 251, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(162, 241, 239));
		panel.setBounds(10, 10, 199, 543);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(162, 241, 239));
		panel_2.setBounds(10, 31, 179, 119);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		labXinChao = new JLabel();
		labXinChao.setText("Xin Chào");
		labXinChao.setHorizontalAlignment(SwingConstants.CENTER);
		labXinChao.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2.add(labXinChao);

		ten = new JLabel();
		ten.setBackground(new Color(240, 240, 240));
		ten.setHorizontalAlignment(SwingConstants.CENTER);
		ten.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(ten);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(162, 241, 239));
		panel_3.setBounds(10, 172, 179, 251);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(162, 241, 239));
		panel_6.setBounds(10, 41, 159, 45);
		panel_3.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(UserGUI.class.getResource("/com/NhacCu/item/home.png")));
		panel_6.add(lblNewLabel_1, BorderLayout.WEST);
		
		JLabel lblNewLabel_2 = new JLabel("Trang chủ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_6.add(lblNewLabel_2, BorderLayout.CENTER);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setBackground(new Color(162, 241, 239));
		panel_6_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		panel_6_1.setBounds(10, 105, 159, 45);
		panel_3.add(panel_6_1);
		panel_6_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(UserGUI.class.getResource("/com/NhacCu/item/shopping-cart-black-shape.png")));
		panel_6_1.add(lblNewLabel_3, BorderLayout.WEST);
		
		JLabel lblNewLabel_4 = new JLabel("Giỏ hàng");
		lblNewLabel_4.setBackground(new Color(65, 127, 62));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_6_1.add(lblNewLabel_4, BorderLayout.CENTER);
		
		JPanel panel_6_2 = new JPanel();
		panel_6_2.setBackground(new Color(162, 241, 239));
		panel_6_2.setBounds(10, 169, 159, 45);
		panel_3.add(panel_6_2);
		panel_6_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(UserGUI.class.getResource("/com/NhacCu/item/tool.png")));
		panel_6_2.add(lblNewLabel, BorderLayout.WEST);
		
		JLabel lblNewLabel_9 = new JLabel("Bảo trì");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6_2.add(lblNewLabel_9, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(162, 241, 239));
		panel_4.setBounds(10, 488, 179, 45);
		panel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(UserGUI.class.getResource("/com/NhacCu/item/logout.png")));
		panel_4.add(lblNewLabel_7, BorderLayout.WEST);
		
		JLabel lblNewLabel_8 = new JLabel("Đăng xuất");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_8, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(162, 241, 239));
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		panel_5.setBounds(10, 433, 179, 45);
		panel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(UserGUI.class.getResource("/com/NhacCu/item/information.png")));
		panel_5.add(lblNewLabel_5, BorderLayout.WEST);
		
		JLabel lblNewLabel_6 = new JLabel("Thông tin");
		lblNewLabel_6.setBackground(new Color(65, 127, 62));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_5.add(lblNewLabel_6, BorderLayout.CENTER);
		
		TimKiem timkiem = new TimKiem();
        GioHang giohang = new GioHang(tenDangNhap);
        ThongTin thongtin = new ThongTin(tenDangNhap);	
        BaoTri baotri = new BaoTri(tenDangNhap);
		
		CardLayout cardLayout = new CardLayout();
		JPanel cardPanel = new JPanel(cardLayout);
		cardPanel.setBounds(219, 10, 757, 543);
		getContentPane().add(cardPanel);
		cardPanel.add(timkiem, "Tìm kiếm");
		cardPanel.add(giohang, "Giỏ hàng");
		cardPanel.add(thongtin, "Thông tin");
		cardPanel.add(baotri, "Bảo trì");		
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel, "Tìm kiếm");			
				panel_6.setBackground(new Color(255,254,223));
				panel_6_1.setBackground(new Color(162, 241, 239));
				panel_4.setBackground(new Color(162, 241, 239));
				panel_5.setBackground(new Color(162, 241, 239));
				panel_6_2.setBackground(new Color(162, 241, 239));
				timkiem.reload();
			}
		});
		
		panel_6_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel, "Giỏ hàng");
				panel_6_1.setBackground(new Color(255,254,223));
				panel_4.setBackground(new Color(162, 241, 239));
				panel_5.setBackground(new Color(162, 241, 239));
				panel_6.setBackground(new Color(162, 241, 239));
				panel_6_2.setBackground(new Color(162, 241, 239));
			}
		});
		
		panel_6_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel, "Bảo trì");
				panel_6_2.setBackground(new Color(255,254,223));
				panel_4.setBackground(new Color(162, 241, 239));
				panel_5.setBackground(new Color(162, 241, 239));
				panel_6.setBackground(new Color(162, 241, 239));
				panel_6_1.setBackground(new Color(162, 241, 239));
			}
		});
		
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel, "Thông tin");
				panel_5.setBackground(new Color(255,254,223));
				panel_4.setBackground(new Color(162, 241, 239));
				panel_6.setBackground(new Color(162, 241, 239));
				panel_6_1.setBackground(new Color(162, 241,239));
				panel_6_2.setBackground(new Color(162, 241, 239));
			}
		});

		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_4.setBackground(new Color(255,254,223));
				panel_5.setBackground(new Color(162, 241, 239));
				panel_6.setBackground(new Color(162, 241, 239));
				panel_6_1.setBackground(new Color(162, 241, 239));
				panel_6_2.setBackground(new Color(162, 241, 239));
				int confirmed = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn đăng xuất?", "Xác nhận đăng xuất", JOptionPane.YES_NO_OPTION);
                if (confirmed == JOptionPane.YES_OPTION){
					dispose();
					Login login = new Login();
					login.setVisible(true);
				}
			}
		});
		System.out.println("hello");
		System.out.println(tenDangNhap);
		hienThiTenNguoiDung(tenDangNhap);
	}

	public void hienThiTenNguoiDung(String tenDangNhap) {
    try {
        ConnectJDBC con = new ConnectJDBC();
        Connection connection = con.getConnection();
        
        String query = "SELECT HovaTen FROM userr WHERE TenDangNhap = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, tenDangNhap);
        
        // Thực hiện truy vấn bằng cách sử dụng statement.executeQuery()
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String hoVaTen = resultSet.getString("HovaTen");
            ten.setText(hoVaTen);
        } else {
            ten.setText("Không tìm thấy tên người dùng");
        }
        
        // Đóng ResultSet và PreparedStatement sau khi sử dụng
        resultSet.close();
        statement.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}

