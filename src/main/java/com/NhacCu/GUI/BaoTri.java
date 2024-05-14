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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.NhacCu.DTO.SanPhamDaMua;

import javax.swing.JTextArea;

public class BaoTri extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;
	private static DefaultTableModel modelSanPhamDaMua;
	

	/**
	 * Create the panel.
	 */
	public BaoTri(String tenDangNhap) {
		setBackground(new Color(197, 251, 237));
		setBounds(0,0,757,543);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 254, 223));
		panel.setBackground(new Color(102, 169, 222));
		panel.setBounds(10, 10, 737, 54);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel labBaoTri = new JLabel("Bảo trì");
		labBaoTri.setForeground(new Color(255, 254, 223));
		labBaoTri.setHorizontalAlignment(SwingConstants.CENTER);
		labBaoTri.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel.add(labBaoTri);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "S\u1EA3n ph\u1EA9m \u0111\u00E3 mua", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 85, 737, 152);
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Mã sản phẩm", "Tên sản phẩm", "Giá", "Số lượng"
			}
		));
		panel_1.add(table, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane(table);
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(491, 290, 251, 110);
		add(textArea);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 268, 471, 232);
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "Ng\u00E0y b\u1EA3o tr\u00EC", "T\u00ECnh tr\u1EA1ng s\u1EA3n ph\u1EA9m"
			}
		));
		table_1.getColumnModel().getColumn(0).setMinWidth(90);
		table_1.getColumnModel().getColumn(0).setMaxWidth(200);
		table_1.getColumnModel().getColumn(1).setMinWidth(110);
		table_1.getColumnModel().getColumn(1).setMaxWidth(200);
		table_1.getColumnModel().getColumn(2).setMinWidth(70);
		table_1.getColumnModel().getColumn(2).setMaxWidth(150);
		panel_2.add(table_1);
		
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		panel_2.add(scrollPane_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Tình trạng sản phẩm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(491, 267, 132, 23);
		add(lblNewLabel_1);
		
		JButton btnBaoTri = new JButton("Bảo trì");
		btnBaoTri.setForeground(new Color(255, 255, 255));
		btnBaoTri.setBackground(new Color(10, 94, 123));
		btnBaoTri.setIcon(new ImageIcon(BaoTri.class.getResource("/com/NhacCu/item/rpa.png")));
		btnBaoTri.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBaoTri.setBounds(491, 465, 251, 33);
		add(btnBaoTri);
		modelSanPhamDaMua = (DefaultTableModel) table.getModel();

		btnBaoTri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Kiểm tra nếu textArea rỗng
				if (textArea.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập tình trạng sản phẩm!");
					return;
				}
		
				// Lấy dữ liệu từ table (sản phẩm đã mua)
				DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
				int selectedRow = table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm cần bảo trì!");
					return;
				}
				String maSP = modelTable.getValueAt(selectedRow, 0).toString();
				String tenSP = modelTable.getValueAt(selectedRow, 1).toString();
		
				// Lấy ngày hiện tại
				java.sql.Date ngayBaoTri = new java.sql.Date(System.currentTimeMillis());
		
				// Lấy tình trạng từ textArea
				String tinhTrang = textArea.getText();
		
				// Truy vấn SQL để lấy mã user từ tên đăng nhập
				String maUser = null;
				String sql = "SELECT MaUser FROM userr WHERE TenDangNhap = ?";
				try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhaccu", "root", "");
					 PreparedStatement pstmt = conn.prepareStatement(sql)) {
					pstmt.setString(1, tenDangNhap);
					ResultSet rs = pstmt.executeQuery();
					if (rs.next()) {
						maUser = rs.getString("MaUser");
					} else {
						JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin người dùng!");
						return;
					}
				} catch (SQLException ex) {
					Logger.getLogger(BaoTri.class.getName()).log(Level.SEVERE, null, ex);
					return;
				}
		
				// Tạo mã bảo trì tự động
				
				String maBaoTri = null;
				boolean daTonTai = true;
				int soThuTu = 1;
				while (daTonTai) {
    			maBaoTri = "BT" + String.format("%04d", soThuTu);
    // Kiểm tra xem mã đã tồn tại trong cơ sở dữ liệu chưa
    			String sqlCheck = "SELECT COUNT(*) AS count FROM PhieuBaoTri WHERE MaBT = ?";
    			try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhaccu", "root", "");
         			PreparedStatement pstmtCheck = conn.prepareStatement(sqlCheck)) {
        			pstmtCheck.setString(1, maBaoTri);
        			ResultSet rsCheck = pstmtCheck.executeQuery();
        			if (rsCheck.next()) {
            		int count = rsCheck.getInt("count");
            		if (count == 0) { // Nếu không tìm thấy mã trong cơ sở dữ liệu, thoát khỏi vòng lặp
                			daTonTai = false;
           			} else { // Nếu mã đã tồn tại, tăng số thứ tự lên 1 và tiếp tục kiểm tra
                			soThuTu++;
           			 }
       			 }
    				} catch (SQLException ex) {
        		Logger.getLogger(BaoTri.class.getName()).log(Level.SEVERE, null, ex);
        		return;
    			}
				}

				// Thêm dữ liệu vào table_1
				DefaultTableModel modelTable1 = (DefaultTableModel) table_1.getModel();
				Object[] rowData = {maSP, tenSP, ngayBaoTri, tinhTrang}; // Thêm các dữ liệu vào một hàng mới
				modelTable1.addRow(rowData);
		
				// Thêm phiếu bảo trì vào cơ sở dữ liệu
				sql = "INSERT INTO PhieuBaoTri (MaBT,MaNhanVien, MaUser,MaHD, NgayLap,Enable) VALUES (?,NULL, ?, NULL, ?, 0)";
				try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhaccu", "root", "");
					 PreparedStatement pstmt = conn.prepareStatement(sql)) {
					pstmt.setString(1, maBaoTri);
					pstmt.setString(2, maUser);
					pstmt.setDate(3, ngayBaoTri);
					pstmt.executeUpdate();
				} catch (SQLException ex) {
					Logger.getLogger(BaoTri.class.getName()).log(Level.SEVERE, null, ex);
					JOptionPane.showMessageDialog(null, "Lỗi khi thêm phiếu bảo trì vào cơ sở dữ liệu!");
					return;
				}
				String sqlChiTiet = "INSERT INTO ChiTietPhieuBaoTri (MaBT, MaSP, GhiChu) VALUES (?, ?, ?)";
				try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhaccu", "root", "");
    			 PreparedStatement pstmtChiTiet = conn.prepareStatement(sqlChiTiet)) {
   				 pstmtChiTiet.setString(1, maBaoTri);
    			pstmtChiTiet.setString(2, maSP);
    			pstmtChiTiet.setString(3, textArea.getText());
    			pstmtChiTiet.executeUpdate();
				} catch (SQLException ex) {
				    Logger.getLogger(BaoTri.class.getName()).log(Level.SEVERE, null, ex);
				    JOptionPane.showMessageDialog(null, "Lỗi khi thêm chi tiết bảo trì vào cơ sở dữ liệu!");
 					   return;
				}
		
				// Hiển thị thông báo khi hoàn thành
				JOptionPane.showMessageDialog(null, "<html><body style='width: 300px; text-align: center;'>"
    		    + "<h3>Yêu cầu bảo trì của bạn đã được tiếp nhận</h3>"
    		    + "<p>Nhân viên bên tôi sẽ sớm liên lạc với bạn</p>"
    		    + "<p>Cảm ơn bạn đã lựa chọn dịch vụ của chúng tôi</p>"
    		    + "<p>Chúc bạn một ngày vui vẻ!!!</p>"
    		    + "</body></html>", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
		});
		

    }
	
	public static void updateSanPhamDaMua(List<SanPhamDaMua> danhSachSanPhamDaMua) {
        for (SanPhamDaMua sp : danhSachSanPhamDaMua) {
            Object[] row = {sp.getMaSP(), sp.getTenSP(), sp.getGia(), sp.getSoLuong()};
            modelSanPhamDaMua.addRow(row);
        }
    }
}
