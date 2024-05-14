package com.NhacCu.GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.NhacCu.Connect.ConnectJDBC;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ThongTin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textTen;
	private JTextField textHoten;
	private JTextField textGioiTinh;
	private JTextField textNgaySinh;
	private JTextField textSDT;
	private JTextField textDC;
	private JPasswordField pass;
	

	/**
	 * Create the panel.
	 */
	public ThongTin(String tenDangNhap) {
		setBackground(new Color(197, 251, 237));
		setBounds(0,0,757,543);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 254, 223));
		panel.setBackground(new Color(102, 169, 222));
		panel.setBounds(10, 10, 737, 54);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Thông tin khách hàng");
		lblNewLabel.setForeground(new Color(255, 254, 223));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(197, 251, 237));
		panel_1.setBounds(10, 109, 737, 356);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tên đăng nhập");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(105, 24, 181, 36);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Họ và tên");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(105, 70, 181, 36);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mật khẩu");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(105, 116, 181, 36);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Giới tính");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(105, 162, 181, 36);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Ngày sinh");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(105, 208, 181, 36);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Số điện thoại");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_5.setBounds(105, 260, 181, 36);
		panel_1.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Địa chỉ");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_6.setBounds(105, 306, 181, 36);
		panel_1.add(lblNewLabel_1_6);
		
		textTen= new JTextField();
		textTen.setEditable(false);
		textTen.setEnabled(false);
		textTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textTen.setBounds(350, 24, 327, 36);
		panel_1.add(textTen);
		
		textHoten = new JTextField();
		textHoten.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textHoten.setColumns(10);
		textHoten.setBounds(350, 70, 327, 36);
		panel_1.add(textHoten);
		
		textGioiTinh = new JTextField();
		textGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textGioiTinh.setColumns(10);
		textGioiTinh.setBounds(350, 162, 327, 36);
		panel_1.add(textGioiTinh);
		
		textNgaySinh = new JTextField();
		textNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textNgaySinh.setColumns(10);
		textNgaySinh.setBounds(350, 208, 327, 36);
		panel_1.add(textNgaySinh);
		
		textSDT = new JTextField();
		textSDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textSDT.setColumns(10);
		textSDT.setBounds(350, 260, 327, 36);
		panel_1.add(textSDT);
		
		textDC = new JTextField();
		textDC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textDC.setColumns(10);
		textDC.setBounds(350, 306, 327, 36);
		panel_1.add(textDC);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pass.setBounds(350, 116, 275, 36);
		panel_1.add(pass);
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char matkhau = pass.getEchoChar();
				if (matkhau == 0) {
					pass.setEchoChar('*'); // Hiển thị dấu sao
					btnNewButton.setIcon(new ImageIcon(ThongTin.class.getResource("/com/NhacCu/item/view.png")));
				} else {
					pass.setEchoChar((char) 0); // Hiển thị văn bản thực sự
					btnNewButton.setIcon(new ImageIcon(ThongTin.class.getResource("/com/NhacCu/item/hide.png")));
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(ThongTin.class.getResource("/com/NhacCu/item/view.png")));
		btnNewButton.setBounds(635, 116, 43, 36);
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(197, 251, 237));
		panel_2.setBounds(10, 478, 737, 55);
		add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Lưu");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setIcon(new ImageIcon(ThongTin.class.getResource("/com/NhacCu/item/floppy-disk.png")));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textTen.getText();
		        String hoTen = textHoten.getText();
		        String gioiTinh = textGioiTinh.getText();
		        String ngaySinh = textNgaySinh.getText();
		        String sdt = textSDT.getText();
		        String diaChi = textDC.getText();

		        try {
		            // Tạo câu lệnh SQL để cập nhật dữ liệu vào cơ sở dữ liệu
					ConnectJDBC connection = new ConnectJDBC();
		            String query = "UPDATE Userr SET HovaTen=?, GioiTinh=?, NgaySinh=?, SDT=?, DiaChi=? WHERE TenDangNhap=?";
		            PreparedStatement statement = connection.getConnection().prepareStatement(query);
		            statement.setString(1, hoTen);
		            statement.setString(2, gioiTinh);
		            statement.setString(3, ngaySinh);
		            statement.setString(4, sdt);
		            statement.setString(5, diaChi);
		            statement.setString(6, username);
		            int rowsUpdated = statement.executeUpdate();
		            if (rowsUpdated > 0) {
		            	JOptionPane.showMessageDialog(null, "Dữ liệu đã được cập nhật thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);		                
						btnNewButton_1.setEnabled(false);
					}
		        } catch (SQLException ea) {
		            ea.printStackTrace();
		        }
				btnNewButton_1.setEnabled(false);
			}
			
		});
		btnNewButton_1.setBackground(new Color(52, 27, 193));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(141, 0, 453, 45);
		panel_2.add(btnNewButton_1);
		
		ConnectJDBC connection = new ConnectJDBC();
		connection.Connect();
		
		try {
			PreparedStatement statement = connection.getConnection().prepareStatement("SELECT * FROM Userr Where TenDangNhap =?");
			statement.setString(1, tenDangNhap);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				textTen.setText(rs.getString("TenDangNhap"));
				textHoten.setText(rs.getString("HovaTen"));
				textGioiTinh.setText(rs.getString("GioiTinh"));
				textNgaySinh.setText(rs.getString("NgaySinh"));
				textSDT.setText(rs.getString("SDT"));
				textDC.setText(rs.getString("DiaChi"));
				
			}
		} catch (Exception ez) {
			ez.printStackTrace();
		}finally{
			connection.disConnect(); // Đóng kết nối sau khi sử dụng xong
		}
		
		try {
			PreparedStatement statement = connection.getConnection().prepareStatement("SELECT password FROM Account WHERE TenDangNhap = ?");
			statement.setString(1, tenDangNhap);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				pass.setText(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.disConnect(); // Đóng kết nối sau khi sử dụng xong
		}
		
		textHoten.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				btnNewButton_1.setEnabled(true);
			}
		});
		
		pass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				btnNewButton_1.setEnabled(true);
			}
		});
		textGioiTinh.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				btnNewButton_1.setEnabled(true);
			}
		});
		
		textNgaySinh.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				btnNewButton_1.setEnabled(true);
			}
		});
		
		textSDT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				btnNewButton_1.setEnabled(true);
			}
		});
		
		textDC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				btnNewButton_1.setEnabled(true);
			}
		});

	}
}
