package com.NhacCu.GUI;

import javax.swing.table.*;
import com.NhacCu.DTO.NhanVienDTO;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.PatternSyntaxException;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Color;
import com.NhacCu.BUS.NhanVienBUS;
import com.NhacCu.BUS.AccountBUS;
import com.NhacCu.DTO.AccountDTO;
import javax.swing.JTextArea;

public class QuanLyNhanVien extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TextSearch;
	private JTable table;
	public JLabel TextShowName;
	private JTextField textTenDangNhap;
	private JTextField textTenNhanVien;
	private JTextField textNgaySinh;
	private JTextField textDiaChi;
	private JButton btnSua;
	private NhanVienBUS nhanVienBUS = new NhanVienBUS();
	private AccountBUS accountBUS = new AccountBUS();
	private JTextField textGioiTinh;
	private JTextField textSoDienThoai;
	private JTextField textMaNhanVien;
	private JTextArea textAreaGhiChu;
	private JMenuItem menuDoiThongTin;
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
					QuanLyNhanVien frame = new QuanLyNhanVien();
					frame.setVisible(true);
					frame.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							int result = JOptionPane.showConfirmDialog(frame, "Bạn có chắc muốn thoát?", "Xác nhận",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (result == JOptionPane.YES_OPTION) {
								frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							} else {
								frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
							}
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuanLyNhanVien() {
		if (nhanVienBUS.getList() == null)
			nhanVienBUS.listNV();
		if (accountBUS.getList() == null)
			accountBUS.listAcc();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 579);
		
		setTitle("Quản Lý Nhân Viên");
		setResizable(false);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Tùy chọn");
		menuBar.add(mnNewMenu);

		JMenuItem menuQuanLiTaiKhoan = new JMenuItem("Quản Lý Tài Khoản");
		menuQuanLiTaiKhoan.setIcon(
				new ImageIcon(QuanLyNhanVien.class.getResource("/com/NhacCu/item/Pictogrammers-Material-Account-cog.16.png")));
		mnNewMenu.add(menuQuanLiTaiKhoan);
		menuQuanLiTaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyTaiKhoan quanLiTaiKhoan = new QuanLyTaiKhoan();
				quanLiTaiKhoan.setVisible(true);
			}
		});
		
		mnNewMenu.addSeparator();
		
		menuDoiThongTin = new JMenuItem("Đổi thông tin");
		menuDoiThongTin.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/com/NhacCu/item/icon-login.jpg")));
		mnNewMenu.add(menuDoiThongTin);
		menuDoiThongTin.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				DoiThongTinMousePressed(e);
			}

			
		});
		
		JMenuItem LogOut = new JMenuItem("LogOut");
		LogOut.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		LogOut.setHorizontalAlignment(SwingConstants.LEFT);
		LogOut.setIcon(new ImageIcon(
				QuanLyNhanVien.class.getResource("/com/NhacCu/item/Custom-Icon-Design-Pretty-Office-6-Logout.16.png")));
		mnNewMenu.add(LogOut);
		LogOut.addActionListener(new ActionListener() {
			 @Override
	            public void actionPerformed(ActionEvent e) {
	                int result = JOptionPane.showConfirmDialog(null,
	                        "Bạn có chắc chắn đăng xuất không?",
	                        "Xác nhận",
	                        JOptionPane.YES_NO_OPTION,
	                        JOptionPane.QUESTION_MESSAGE);
	                if(result == JOptionPane.YES_OPTION){
	                	dispose(); // Đóng frame hiện tại
	    				Login login = new Login(); // Khởi tạo class mới
	    				login.setVisible(true); //
	                }
	            }
		});
		
		
		JMenuItem menuThoat = new JMenuItem("Thoát");
		menuThoat.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/com/NhacCu/item/exit_16.png")));
		mnNewMenu.add(menuThoat);
		contentPane = new JPanel();
//		menuThoat.setBorder(new EmptyBorder(5, 5, 5, 5));
		menuThoat.addActionListener(new ActionListener() {
			 @Override
	            public void actionPerformed(ActionEvent e) {
	                int result = JOptionPane.showConfirmDialog(null,
	                        "Bạn có chắc chắn thoát không?",
	                        "Xác nhận",
	                        JOptionPane.YES_NO_OPTION,
	                        JOptionPane.QUESTION_MESSAGE);
	                if(result == JOptionPane.YES_OPTION){
	                	dispose(); // Đóng frame hiện tại
	    			
	                }
	            }
		});
		
		
		
		
		setContentPane(contentPane);

		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản Lý Nhân Viên");
		lblNewLabel.setBounds(0, 0, 799, 104);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);

		TextSearch = new JTextField();
		TextSearch.setBounds(631, 34, 129, 35);
		contentPane.add(TextSearch);
		TextSearch.setColumns(10);

		TextSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR)); // Con trỏ tay khi di chuyển vào
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getDefaultCursor()); // Con trỏ mặc định khi rời khỏi
			}
		});

		// Hiển thị dữ liệu trong jtable
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 102, 868, 218);
		contentPane.add(scrollPane);

		ArrayList<NhanVienDTO> list = nhanVienBUS.getList();

		// Tạo DefaultTableModel mới
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã nhân viên");
		model.addColumn("Tên đăng nhập");
		model.addColumn("Tên nhân viên");
		model.addColumn("Giới tính");
		model.addColumn("Ngày sinh");
		model.addColumn("Số điện thoại");
		model.addColumn("Địa chỉ");
		model.addColumn("Ghi chú");
		

		// Đổ dữ liệu vào DefaultTableModel
		for (NhanVienDTO nv : list) {
			if (nv.getEnable() == 1 && nv.getChucVu().equals("NhanVien")) {
				model.addRow(new Object[] {  nv.getMaNhanVien(), nv.getTenDangNhap(), nv.getTenNhanVien(),
						nv.getGioiTinh(), nv.getNgaySinh(), nv.getSDT(), nv.getDiaChi() , nv.getGhiChu() });
			}
		}

		// Sử dụng DefaultTableModel để tạo JTable
		table = new JTable(model);
		scrollPane.setViewportView(table);

		// Cho phép table sắp xếp
		table.setAutoCreateRowSorter(true);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int index = table.getSelectedRow();
				textMaNhanVien.setText((String) table.getValueAt(index, 0));
				textMaNhanVien.setEditable(false);
				textMaNhanVien.setEnabled(false);
				textTenDangNhap.setText((String) table.getValueAt(index, 1));
				textTenDangNhap.setEditable(false);
				textTenDangNhap.setEnabled(false);
				textTenNhanVien.setText((String) table.getValueAt(index, 2));
				textGioiTinh.setText((String) table.getValueAt(index, 3));
				textNgaySinh.setText((String) table.getValueAt(index, 4));
				textSoDienThoai.setText((String) table.getValueAt(index, 5));
				textDiaChi.setText((String) table.getValueAt(index, 6));
				textAreaGhiChu.setText((String) table.getValueAt(index, 7));
			}
		});

		JButton btnSort = new JButton("Tìm Kiếm");
		btnSort.setToolTipText("Tìm kiếm nhân viên");
		btnSort.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/com/NhacCu/item/search_16x16.png")));
		btnSort.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSort.setBounds(770, 34, 108, 35);
		contentPane.add(btnSort);

		JLabel lblNewLabel_1 = new JLabel("Xin chào");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 0, 82, 23);
		contentPane.add(lblNewLabel_1);

		TextShowName = new JLabel("");
		TextShowName.setForeground(new Color(255, 0, 0));
		TextShowName.setFont(new Font("Tahoma", Font.BOLD, 15));
		TextShowName.setBounds(76, 0, 247, 23);
		contentPane.add(TextShowName);

		JLabel lblNewLabel_2 = new JLabel("Tên Đăng Nhập");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(8, 391, 102, 23);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Tên Nhân Viên");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(10, 431, 102, 23);
		contentPane.add(lblNewLabel_2_1);

		textTenDangNhap = new JTextField();
		textTenDangNhap.setBounds(132, 391, 129, 23);
		contentPane.add(textTenDangNhap);
		textTenDangNhap.setColumns(10);

		textTenNhanVien = new JTextField();
		textTenNhanVien.setColumns(10);
		textTenNhanVien.setBounds(132, 433, 129, 23);
		contentPane.add(textTenNhanVien);

		JLabel lblNewLabel_2_2 = new JLabel("Giới Tính");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(322, 351, 105, 23);
		contentPane.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_2_1 = new JLabel("Ngày Sinh");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1.setBounds(322, 391, 102, 23);
		contentPane.add(lblNewLabel_2_2_1);

		textNgaySinh = new JTextField();
		textNgaySinh.setColumns(10);
		textNgaySinh.setBounds(434, 392, 130, 25);
		contentPane.add(textNgaySinh);

		JLabel lblSDT = new JLabel("Số Điện Thoại");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSDT.setBounds(322, 431, 102, 23);
		contentPane.add(lblSDT);

		JLabel labelDiachi = new JLabel("Địa chỉ");
		labelDiachi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelDiachi.setBounds(631, 351, 102, 23);
		contentPane.add(labelDiachi);

		textDiaChi = new JTextField();
		textDiaChi.setColumns(10);
		textDiaChi.setBounds(724, 351, 129, 25);
		contentPane.add(textDiaChi);

		btnSua = new JButton("Sửa");
		btnSua.setToolTipText("Sửa Nhân Viên");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BtnUpdateData();
			}
		});
		btnSua.setIcon(new ImageIcon(
				QuanLyNhanVien.class.getResource("/com/NhacCu/item/Custom-Icon-Design-Flatastic-10-Edit-validated.16.png")));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSua.setBounds(257, 479, 111, 35);
		contentPane.add(btnSua);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/com/NhacCu/item/out.png")));
		btnThoat.setToolTipText("Thoát Chương Trình");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThoat.setBounds(735, 475, 108, 35);
		contentPane.add(btnThoat);

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdd();
			}
		});
		btnThem.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/com/NhacCu/item/Awicons-Vista-Artistic-Add.16.png")));
		btnThem.setToolTipText("Thêm Nhân Viên");
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThem.setBounds(34, 479, 111, 35);
		contentPane.add(btnThem);

		JButton btnResert = new JButton("Resert");
		btnResert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnResert();
			}
		});
		btnResert.setIcon(
				new ImageIcon(QuanLyNhanVien.class.getResource("/com/NhacCu/item/Hopstarter-Button-Button-Reload.16.png")));
		btnResert.setToolTipText("Làm Sạch Text");
		btnResert.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnResert.setBounds(497, 475, 115, 35);
		contentPane.add(btnResert);
		
		textGioiTinh = new JTextField();
		textGioiTinh.setColumns(10);
		textGioiTinh.setBounds(435, 353, 129, 23);
		contentPane.add(textGioiTinh);
		
		textSoDienThoai = new JTextField();
		textSoDienThoai.setColumns(10);
		textSoDienThoai.setBounds(434, 433, 130, 23);
		contentPane.add(textSoDienThoai);
		
		JLabel lblNewLabel_2_3 = new JLabel("Mã Nhân Viên");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(10, 351, 102, 23);
		contentPane.add(lblNewLabel_2_3);
		
		textMaNhanVien = new JTextField();
		textMaNhanVien.setColumns(10);
		textMaNhanVien.setBounds(132, 351, 129, 25);
		contentPane.add(textMaNhanVien);
		
		JLabel lblGhiChus = new JLabel("Ghi Chú");
		lblGhiChus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGhiChus.setBounds(631, 391, 102, 23);
		contentPane.add(lblGhiChus);
		

		
		textAreaGhiChu = new JTextArea();
		textAreaGhiChu.setBounds(564, 46, 85, 112);
		textAreaGhiChu.setLineWrap(true); // Tự động xuống dòng khi văn bản vượt quá kích thước của JTextArea
		textAreaGhiChu.setWrapStyleWord(true); // Tự động cắt từ khi văn bản vượt quá kích thước của JTextArea
		JScrollPane scrollPane1 = new JScrollPane(textAreaGhiChu);
		scrollPane1.setBounds(723, 391, 129, 63);
		scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Hiển thị thanh cuộn theo chiều
																						// dọc
		scrollPane1.setAutoscrolls(true); // Tự động cuộn theo con trỏ chuột
		contentPane.add(scrollPane1);
		
		// Đưa con trỏ chuột vào table đổi thành HAND_CURSOR
		table.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				int row = table.rowAtPoint(e.getPoint());
				int col = table.columnAtPoint(e.getPoint());
				if (row >= 0 && col >= 0) {
					setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				} else {
					setCursor(Cursor.getDefaultCursor());
				}
			}
		});
		// Đưa con chuột ra khỏi table thì con chuột DeauFault
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getDefaultCursor());
			}
		});
		// Thêm sự kiện lọc dữ liệu khi nhấn nút "Tìm Kiếm"
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = TextSearch.getText();
				TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) table.getRowSorter();
				if (text.trim().length() == 0) {
					sorter.setRowFilter(null);
				} else {
					try {
						sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
					} catch (PatternSyntaxException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
	}

	public void BtnUpdateData() {
		String tenDangNhap = textTenDangNhap.getText();
		String tenNhanVien = textTenNhanVien.getText();
		String gioiTinh = textGioiTinh.getText();
		String ngaySinh = textNgaySinh.getText();
		String soDienThoai = textSoDienThoai.getText();
		String diaChi = textDiaChi.getText();
		NhanVienDTO nhanVienDTO = new NhanVienDTO(textMaNhanVien.getText(), tenDangNhap, tenNhanVien, gioiTinh,
				ngaySinh, soDienThoai, diaChi, "NhanVien" ,textAreaGhiChu.getText(),1);
		nhanVienBUS.updateNV(nhanVienDTO);
		JFrame frame = new JFrame("JOptionPane showMessageDialog");
		JOptionPane.showMessageDialog(frame, "Cập nhật nhân viên thành công!", "Thông báo",
				JOptionPane.INFORMATION_MESSAGE);
		btnResert();
	}

	public void btnResert() {
	    // Xóa dữ liệu trong các trường nhập liệu và cho phép chỉnh sửa lại tên đăng nhập
	    textMaNhanVien.setText("");
	    textMaNhanVien.setEditable(true);
	    textMaNhanVien.setEnabled(true);
	    textTenDangNhap.setText("");
	    textTenDangNhap.setEditable(true);
	    textTenDangNhap.setEnabled(true);
	    textTenNhanVien.setText("");
	    textGioiTinh.setText("");
	    textNgaySinh.setText("");
	    textSoDienThoai.setText("");
	    textDiaChi.setText("");
	    nhanVienBUS.listNV();
	    // Cập nhật lại dữ liệu trong bảng
	    updateTableData();
	}

	// Phương thức để cập nhật dữ liệu trong JTable
	public void updateTableData() {
	    // Lấy lại danh sách dữ liệu từ BUS hoặc DAO
	    ArrayList<NhanVienDTO> list = nhanVienBUS.getList();

	    // Tạo DefaultTableModel mới
	    DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã nhân viên");
		model.addColumn("Tên đăng nhập");
		model.addColumn("Tên nhân viên");
		model.addColumn("Giới tính");
		model.addColumn("Ngày sinh");
		model.addColumn("Số điện thoại");
		model.addColumn("Địa chỉ");
		model.addColumn("Ghi chú");
		

		// Đổ dữ liệu vào DefaultTableModel
		for (NhanVienDTO nv : list) {
			if (nv.getEnable() == 1 && nv.getChucVu().equals("NhanVien")) {
				model.addRow(new Object[] {  nv.getMaNhanVien(), nv.getTenDangNhap(), nv.getTenNhanVien(),
						nv.getGioiTinh(), nv.getNgaySinh(), nv.getSDT(), nv.getDiaChi() , nv.getGhiChu() });
			}
			
		}
	    // Cập nhật lại model cho JTable
	    table.setModel(model);
	}
	public void btnAdd() {
		String tenDangNhap = textTenDangNhap.getText();
		String tenNhanVien = textTenNhanVien.getText();
		String gioiTinh = textGioiTinh.getText();
		String ngaySinh = textNgaySinh.getText();
		String soDienThoai = textSoDienThoai.getText();
		String diaChi = textDiaChi.getText();
		if (nhanVienBUS.checkTenDangNhap(textTenDangNhap.getText())
				|| accountBUS.checkTenDangNhap(textTenDangNhap.getText())) {
			JFrame frame = new JFrame("JOptionPane showMessageDialog");
			JOptionPane.showMessageDialog(frame, "Tên Đăng Nhập đã tồn tại!", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			if (tenDangNhap.isEmpty()) {
				JFrame frame = new JFrame("JOptionPane showMessageDialog");
				JOptionPane.showMessageDialog(frame, "Tên đăng nhập không được bỏ trống!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			} else {
				if (tenNhanVien.isEmpty()) {
					JFrame frame = new JFrame("JOptionPane showMessageDialog");
					JOptionPane.showMessageDialog(frame, "Tên nhân viên không được bỏ trống!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				} else {
					if (gioiTinh.isEmpty()) {
						JFrame frame = new JFrame("JOptionPane showMessageDialog");
						JOptionPane.showMessageDialog(frame, "Giới tính không được bỏ trống!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						
					}else {
						if (ngaySinh.isEmpty()) {
							JFrame frame = new JFrame("JOptionPane showMessageDialog");
							JOptionPane.showMessageDialog(frame, "Ngày sinh không được bỏ trống!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						}else {
							if(soDienThoai.isEmpty()) {
								JFrame frame = new JFrame("JOptionPane showMessageDialog");
								JOptionPane.showMessageDialog(frame, "Số điện thoại không được bỏ trống!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
							}else {
								if (diaChi.isEmpty()) {
									JFrame frame = new JFrame("JOptionPane showMessageDialog");
									JOptionPane.showMessageDialog(frame, "Địa chỉ không được bỏ trống!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
								}else {
									AccountDTO accountDTO = new AccountDTO(tenDangNhap, tenDangNhap, "NhanVien", 1);
									accountBUS.addAcc(accountDTO);
									NhanVienDTO nhanVienDTO = new NhanVienDTO(textMaNhanVien.getText(),tenDangNhap, tenNhanVien, gioiTinh, ngaySinh, soDienThoai, diaChi,"NhanVien",textAreaGhiChu.getText(),
											1);
									nhanVienBUS.addNV(nhanVienDTO);
									JFrame frame = new JFrame("JOptionPane showMessageDialog");
									JOptionPane.showMessageDialog(frame, "Thêm nhân viên thành công!", "Thông báo",
											JOptionPane.INFORMATION_MESSAGE);
									btnResert();
								}
							}
						}
					}

				}
			}
			
		}
	}
	public void DoiThongTinMousePressed(MouseEvent evt) {
	
		DoiThongTin doiThongTin = new DoiThongTin();
		doiThongTin.setVisible(true);
	
		nhanVienBUS.listNV();

		String chuoiCon = TextShowName.getText().substring(TextShowName.getText().indexOf(":") + 1).trim();
		doiThongTin.textFieldTenDangNhap.setText(chuoiCon);

		for (NhanVienDTO nvDTO : nhanVienBUS.getList()) {
			if (nvDTO.getTenDangNhap().equals(chuoiCon)) {
				doiThongTin.textFieldMaNguoiDung.setText(nvDTO.getMaNhanVien());
				doiThongTin.textFieldHovaTen.setText(nvDTO.getTenNhanVien());
				doiThongTin.textFieldDiaChi.setText(nvDTO.getDiaChi());
				doiThongTin.textFieldNgaySinh.setText(nvDTO.getNgaySinh());
				doiThongTin.textFieldSoDienThoai.setText(nvDTO.getSDT());
				if (nvDTO.getGioiTinh().equals("Nam")) {
					doiThongTin.rdbtnNam.setSelected(true);
					

				} else {
					doiThongTin.rdbtnNu.setSelected(true);
					
				}
				break;
			}
		}

	}
}
