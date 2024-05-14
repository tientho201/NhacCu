package com.NhacCu.GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.table.DefaultTableModel;

import com.NhacCu.BUS.SanPhamBUS;
import com.NhacCu.Connect.ConnectJDBC;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TimKiem extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private SanPhamBUS spBUS = new SanPhamBUS();

	/**
	 * Create the panel.
	 */
	public TimKiem() {
		if(spBUS.getList() == null) {
			spBUS.listSP();
		}
		setBackground(new Color(197, 251, 237));
		setLayout(null);
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 169, 222));
		panel_2.setBounds(10, 10, 737, 46);
		add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Trang chủ");
		lblNewLabel.setForeground(new Color(255, 254, 223));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 197, 737, 321);
		add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setBackground(new Color(162, 241, 239));
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã sản phẩm", "Tên sản phẩm", "Giá", "Số lượng trong kho","Ghi chú"
			}
		));
		panel_3.add(table);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		ConnectJDBC connection = new ConnectJDBC();
		connection.Connect();

		try {
			Statement statement = connection.createStatement();;
			ResultSet resultSet = statement.executeQuery("SELECT * FROM sanpham");
			while (resultSet.next()){
			
				String masp=resultSet.getString("MaSP");
				String tensp=resultSet.getString("TenSP");
				int soluong=resultSet.getInt("SoLuong");
				int gia=resultSet.getInt("Gia");
				String ghichu=resultSet.getString("GhiChu");
				model.addRow(new Object[]{ masp, tensp, gia, soluong, ghichu});

			}
			} catch (Exception e) {
			e.printStackTrace();
			connection.disConnect();
		}
		
		JScrollPane scrollPane = new JScrollPane(table);
		panel_3.add(scrollPane);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(162, 241, 239));
		panel_4.setBounds(10, 74, 739, 93);
		add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 10, 211, 79);
		panel_4.add(panel);
		panel.setBackground(new Color(162, 241, 239));
		panel.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String maSP = textField.getText().trim(); // Lấy mã sản phẩm từ trường nhập liệu
		        String tenSP = textField.getText().trim(); // Lấy tên sản phẩm từ trường nhập liệu

		        // Xóa dữ liệu hiện có trong bảng
		        DefaultTableModel model = (DefaultTableModel) table.getModel();
		        model.setRowCount(0);

		        // Kết nối đến cơ sở dữ liệu
		        ConnectJDBC connection = new ConnectJDBC();
		        connection.Connect();

		        try {
		            Statement statement = connection.createStatement();
		            String query = "SELECT * FROM sanpham WHERE MaSP LIKE '%" + maSP + "%' OR TenSP LIKE '%" + tenSP + "%'";
		            ResultSet resultSet = statement.executeQuery(query);
		            while (resultSet.next()) {
		                
		                String masp = resultSet.getString("MaSP");
		                String tensp = resultSet.getString("TenSP");
		                int soluong = resultSet.getInt("SoLuong");
		                int gia = resultSet.getInt("Gia");
						String ghichu=resultSet.getString("GhiChu");
						model.addRow(new Object[]{ masp, tensp, gia, soluong, ghichu});
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        } finally {
		            connection.disConnect();
		        }
			}
		});
		
		
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(10, 26, 191, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(217, 10, 443, 79);
		panel_4.add(panel_1);
		panel_1.setBackground(new Color(162, 241, 239));
		panel_1.setBorder(new TitledBorder(null, "L\u1ECDc", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Theo tên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 10, 64, 26);
		panel_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setBounds(117, 10, 220, 26);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Theo giá:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 46, 74, 23);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Từ");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(92, 46, 27, 23);
		panel_1.add(lblNewLabel_2_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setBounds(117, 46, 114, 23);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Đến");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(252, 46, 36, 23);
		panel_1.add(lblNewLabel_2_1_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(298, 46, 134, 23);
		panel_1.add(textField_3);

		
		JButton btnNewButton_1 = new JButton("Lọc");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenSP = textField_1.getText().trim(); // Lấy tên sản phẩm từ trường nhập liệu
		        String giaTu = textField_2.getText().trim(); // Lấy giá từ trường nhập liệu
		        String giaDen = textField_3.getText().trim(); // Lấy giá đến từ trường nhập liệu

		        // Xóa dữ liệu hiện có trong bảng
		        DefaultTableModel model = (DefaultTableModel) table.getModel();
		        model.setRowCount(0);

		        // Kết nối đến cơ sở dữ liệu
		        ConnectJDBC connection = new ConnectJDBC();
		        connection.Connect();

		        try {
		            Statement statement = connection.createStatement();
		            // Tạo truy vấn SQL dựa trên các điều kiện lọc
		            String query = "SELECT * FROM sanpham WHERE TenSP LIKE '%" + tenSP + "%'";
		            // Nếu có giá từ và giá đến được nhập vào
		            if (!giaTu.isEmpty() && !giaDen.isEmpty()) {
		                query += " AND Gia BETWEEN " + giaTu + " AND " + giaDen;
		            }
		            ResultSet resultSet = statement.executeQuery(query);
		            while (resultSet.next()) {
		                
		                String masp = resultSet.getString("MaSP");
		                String tensp = resultSet.getString("TenSP");
		                int soluong = resultSet.getInt("SoLuong");
		                int gia = resultSet.getInt("Gia");
						String ghichu=resultSet.getString("GhiChu");
						model.addRow(new Object[]{ masp, tensp, gia, soluong, ghichu});
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        } finally {
		            connection.disConnect();
		        }
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(52, 27, 193));
		btnNewButton_1.setIcon(new ImageIcon(TimKiem.class.getResource("/com/NhacCu/item/filter (1).png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(347, 10, 86, 26);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(TimKiem.class.getResource("/com/NhacCu/item/arrow.png")));
		btnNewButton.setBounds(670, 28, 44, 41);
		panel_4.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				
				ConnectJDBC connection = new ConnectJDBC();
				connection.Connect();

				try {
					Statement statement = connection.createStatement();;
					ResultSet resultSet = statement.executeQuery("SELECT * FROM sanpham");
					while (resultSet.next()){
						
						String masp=resultSet.getString("MaSP");
						String tensp=resultSet.getString("TenSP");
						int soluong=resultSet.getInt("SoLuong");
						int gia=resultSet.getInt("Gia");
						String ghichu=resultSet.getString("GhiChu");
						model.addRow(new Object[]{ masp, tensp, gia, soluong, ghichu});
					}
					} catch (Exception ex) {
					ex.printStackTrace();
				}finally{
					connection.disConnect();
				}
				
			}
		});
		
		btnNewButton.setBackground(new Color(52, 27, 193));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		table.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int row = table.rowAtPoint(e.getPoint()); // Lấy chỉ số hàng từ điểm click
		        if (row >= 0) {
		            String masp = (String) model.getValueAt(row, 0); // Lấy MaSP từ hàng được chọn
		            String tensp = (String) model.getValueAt(row, 1); // Lấy TenSP từ hàng được chọn
		            int gia = (int) model.getValueAt(row, 2); // Lấy Gia từ hàng được chọn
		            int soluong = (int) model.getValueAt(row, 3); // Lấy SoLuong từ hàng được chọn
		            String ghichu =(String) model.getValueAt(row, 4);

		            // Mở frame SanPham và truyền dữ liệu
		            EventQueue.invokeLater(() -> {
		                SanPham sanPham = new SanPham(masp, tensp, gia, soluong, ghichu,spBUS.PutOnImage(masp) );
		                sanPham.setVisible(true);
		            });
		        }
		    }
		});
		reload();
	}

	public void reload(){
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		ConnectJDBC connection = new ConnectJDBC();
		connection.Connect();
		try {
			Statement statement = connection.createStatement();;
			ResultSet resultSet = statement.executeQuery("SELECT * FROM sanpham");
			while (resultSet.next()){
				String masp=resultSet.getString("MaSP");
				String tensp=resultSet.getString("TenSP");
				int soluong=resultSet.getInt("SoLuong");
				int gia=resultSet.getInt("Gia");
				String ghichu=resultSet.getString("GhiChu");
				model.addRow(new Object[]{ masp, tensp, gia, soluong, ghichu});
			}
			} catch (Exception e) {
			e.printStackTrace();
		}finally{
			connection.disConnect();
		}
	}
}
