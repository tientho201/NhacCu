package com.NhacCu.GUI;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.NhacCu.DTO.SanPhamDaMua;
import com.NhacCu.Connect.ConnectJDBC;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class GioHang extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JTable table;
	private static JLabel labTongTien;
	
	private ConnectJDBC connectJDBC = new ConnectJDBC();

	/**
	 * Create the panel.
	 */
	public GioHang(String tenDangNhap) {
		
		setBackground(new Color(197, 251, 237));
		setBounds(0, 0, 757, 543);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 169, 222));
		panel.setBounds(10, 10, 737, 68);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Giỏ hàng");
		lblNewLabel.setForeground(new Color(255, 254, 223));
		lblNewLabel.setBackground(new Color(255, 254, 223));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 127, 737, 316);
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setBackground(new Color(162, 241, 239));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Mã sản phẩm", "Tên sản phẩm", "Giá", "Số lượng"
			}
		));
		panel_1.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		panel_1.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(197, 251, 237));
		panel_2.setBounds(10, 489, 737, 44);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Thành tiền:");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(252, 10, 91, 24);
		panel_2.add(lblNewLabel_1);
		
		labTongTien = new JLabel("0");
		labTongTien.setForeground(new Color(255, 0, 0));
		labTongTien.setHorizontalAlignment(SwingConstants.CENTER);
		labTongTien.setFont(new Font("Tahoma", Font.BOLD, 14));
		labTongTien.setBounds(338, 10, 149, 24);
		panel_2.add(labTongTien);

		JLabel lblNewLabel_1_1 = new JLabel("VND");
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(498, 10, 40, 24);
		panel_2.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Đặt hàng");
		btnNewButton.setIcon(new ImageIcon(GioHang.class.getResource("/com/NhacCu/item/received.png")));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(52, 27, 193));
		btnNewButton.setBounds(588, 7, 149, 34);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Xóa");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setIcon(new ImageIcon(GioHang.class.getResource("/com/NhacCu/item/delete.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lấy chỉ số hàng được chọn
		        int selectedRow = table.getSelectedRow();
		        
		        // Kiểm tra nếu có hàng được chọn
		        if (selectedRow != -1) {
		            // Xóa hàng được chọn khỏi mô hình của bảng
		            DefaultTableModel model = (DefaultTableModel) table.getModel();
		            model.removeRow(selectedRow);
		        }
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(648, 453, 99, 30);
		add(btnNewButton_1);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    updateTotalPrice(); // Gọi phương thức để tính toán và cập nhật tổng giá
                }
            }
        });

		// btnNewButton.addActionListener(new ActionListener() {
		// 	public void actionPerformed(ActionEvent e) {
		// 		// Kiểm tra xem có hàng nào được chọn không
		// 		if (table.getSelectedRowCount() == 0) {
		// 			JOptionPane.showMessageDialog(null, "Bạn chưa chọn hàng nào!");
		// 			return; // Không thực hiện các bước tiếp theo nếu không có hàng được chọn
		// 		}
				
		// 		// Hiển thị hộp thoại xác nhận
		// 		int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn đặt hàng?", "Xác nhận đặt hàng", JOptionPane.YES_NO_OPTION);
				
		// 		// Nếu người dùng chọn Yes (có)
		// 		if (choice == JOptionPane.YES_OPTION) {
		// 			// Thực hiện đặt hàng (gọi phương thức để trừ số lượng vào CSDL)
		// 			int[] selectedRows = table.getSelectedRows();
		// 			for (int i = selectedRows.length - 1; i >= 0; i--) {
		// 				String maSP = table.getValueAt(selectedRows[i], 0).toString(); 
		// 				int soLuong = Integer.parseInt(table.getValueAt(selectedRows[i], 3).toString());
		// 				truSoLuongVaoCSDL(maSP, soLuong);
						
		// 				// Xóa hàng được chọn khỏi bảng
		// 				DefaultTableModel model = (DefaultTableModel) table.getModel();
		// 				model.removeRow(selectedRows[i]);
		// 			}
		// 			JOptionPane.showMessageDialog(null, "Đơn hàng đã được đặt thành công!");
		// 			updateTotalPrice();
		// 		}
		// 	}
		// });
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Kiểm tra xem có hàng nào được chọn không
				if (table.getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn hàng nào!");
					return; // Không thực hiện các bước tiếp theo nếu không có hàng được chọn
				}
		
				// Hiển thị hộp thoại xác nhận
				int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn đặt hàng?", "Xác nhận đặt hàng", JOptionPane.YES_NO_OPTION);
		
				// Nếu người dùng chọn Yes (có)
				if (choice == JOptionPane.YES_OPTION) {
					// Lấy dữ liệu các hàng được chọn
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					List<SanPhamDaMua> danhSachSanPhamDaMua = new ArrayList<>();
					int[] selectedRows = table.getSelectedRows();
					for (int row : selectedRows) {
						String maSP = model.getValueAt(row, 0).toString();
						String tenSP = model.getValueAt(row, 1).toString();
						int gia = Integer.parseInt(model.getValueAt(row, 2).toString());
						int soLuong = Integer.parseInt(model.getValueAt(row, 3).toString());
						danhSachSanPhamDaMua.add(new SanPhamDaMua(maSP, tenSP, gia, soLuong));
		
						// Trừ số lượng vào CSDL
						truSoLuongVaoCSDL(maSP, soLuong);
						taoHoaDon(tenDangNhap, maSP, soLuong, gia);
					}
		
					// Chuyển danh sách sản phẩm đã mua vào lớp BaoTri
					BaoTri.updateSanPhamDaMua(danhSachSanPhamDaMua);
		
					// Xóa các hàng đã chọn khỏi bảng
					for (int i = selectedRows.length - 1; i >= 0; i--) {
						model.removeRow(selectedRows[i]);
					}
					
					JOptionPane.showMessageDialog(null, "Đơn hàng đã được đặt thành công!");
					updateTotalPrice();
				}
			}
		});
		
		
	}

	public void taoHoaDon(String tenDangNhap1,String MaSP, int soLuong, int gia) {
        try {
            String tenDangNhap = tenDangNhap1; 
            String maUser = getMaUser(tenDangNhap);
            int tongTien = Integer.parseInt(labTongTien.getText()); 

            String maHD = taoMaHoaDon();
            LocalDate ngayLap = LocalDate.now();
            String sql = "INSERT INTO HoaDon (MaHD, MaNhanVien, MaUser, NgayLap, TongTien, Enable, ThanhToan) VALUES (?, ?, ?, ?, ?, 0, 0)";
            try (Connection connection = connectJDBC.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, maHD);
                statement.setString(2, null); // Mã nhân viên bỏ trống
                statement.setString(3, maUser);
                statement.setDate(4, java.sql.Date.valueOf(ngayLap));
                statement.setInt(5, tongTien);
                statement.executeUpdate();
            }
			themChiTietHoaDon(maHD, MaSP, soLuong, gia);

            System.out.println("Đã tạo hóa đơn mới có mã: " + maHD);
        } catch (SQLException ex) {
            Logger.getLogger(GioHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

	private String getMaUser(String tenDangNhap) {
		String maUser = "";
		try {
			Connection conn = connectJDBC.getConnection(); 
			String query = "SELECT MaUser FROM Userr WHERE TenDangNhap = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, tenDangNhap);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				maUser = rs.getString("MaUser");
			}
			conn.close(); // Đóng kết nối sau khi sử dụng
		} catch (SQLException ex) {
			Logger.getLogger(GioHang.class.getName()).log(Level.SEVERE, null, ex);
		}
		return maUser;
	}
    private String taoMaHoaDon() {
		String maHD = "";
		try {
			Connection connection = connectJDBC.getConnection();
			String sql = "SELECT MAX(MaHD) AS MaxMaHD FROM HoaDon";
			try (PreparedStatement statement = connection.prepareStatement(sql);
				 ResultSet rs = statement.executeQuery()) {
				if (rs.next()) {
					String maxMaHD = rs.getString("MaxMaHD");
					if (maxMaHD != null) {
						int maxSo = Integer.parseInt(maxMaHD.substring(2)); // Lấy số từ mã hóa đơn hiện tại
						maxSo++; // Tăng số lên 1 để tạo mã mới
						String newMaHD;
						do {
							newMaHD = String.format("HD%04d", maxSo); // Tạo mã mới dựa trên số vừa tăng
							maxSo++;
						} while (kiemTraTonTaiMaHD(newMaHD)); // Kiểm tra xem mã mới đã tồn tại chưa
						maHD = newMaHD;
					} else {
						maHD = "HD0001";
					}
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(GioHang.class.getName()).log(Level.SEVERE, null, ex);
		}
		return maHD;
	}
	
	// Phương thức kiểm tra xem mã hóa đơn đã tồn tại trong bảng hay chưa
	private boolean kiemTraTonTaiMaHD(String maHD) {
		boolean tonTai = false;
		try {
			Connection connection = connectJDBC.getConnection();
			String sql = "SELECT COUNT(*) AS count FROM HoaDon WHERE MaHD = ?";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, maHD);
				try (ResultSet rs = statement.executeQuery()) {
					if (rs.next()) {
						int count = rs.getInt("count");
						tonTai = (count > 0); // Nếu có ít nhất một hóa đơn có mã trùng khớp, trả về true
					}
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(GioHang.class.getName()).log(Level.SEVERE, null, ex);
		}
		return tonTai;
	}
	private void themChiTietHoaDon(String maHD, String maSP, int soLuong, int gia) {
		try {
			Connection connection = connectJDBC.getConnection();
			String sql = "INSERT INTO ChiTietHD (MaSP, MaHD, SoLuong, Gia,ThoiGianBaoHanh, GhiChu) VALUES (?, ?, ?,?, ?, '')";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(2, maHD);
				statement.setString(1, maSP);
				statement.setInt(3, soLuong);
				statement.setInt(4, gia);
				statement.setInt(5, 2); // Giả sử thời gian bảo hành là 2
				statement.executeUpdate();
			}
		} catch (SQLException ex) {
			Logger.getLogger(GioHang.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	private void truSoLuongVaoCSDL(String maSP, int soLuong) {
		try (
			Connection conn = DriverManager.getConnection("jdbc:mySQL://localhost:3306/nhaccu", "root", "")) {
            String sql = "UPDATE SanPham SET SoLuong = SoLuong - ? WHERE MaSP = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, soLuong);
                pstmt.setString(2, maSP);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý ngoại lệ khi thao tác với CSDL
        }
    }

	public static void addToCart(String masp,String productName, int price, int quantity) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[]{masp,productName, price, quantity});
	}

	private static void updateTotalPrice() {
		int tongtien = 0;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int[] selectedRows = table.getSelectedRows();
		for (int row : selectedRows) {
			int gia = (int) model.getValueAt(row, 2);
			int soLuong = (int) model.getValueAt(row, 3);
			tongtien += gia * soLuong;
		}
		labTongTien.setText(String.valueOf(tongtien));
	}
	
}
