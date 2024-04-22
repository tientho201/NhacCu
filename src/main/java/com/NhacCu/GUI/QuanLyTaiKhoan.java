package com.NhacCu.GUI;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.NhacCu.DTO.NhanVienDTO;


import com.NhacCu.DTO.AccountDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import com.NhacCu.BUS.NhanVienBUS;
import com.NhacCu.BUS.AccountBUS;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;


public class QuanLyTaiKhoan extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private NhanVienDTO nhanVienDTO = new NhanVienDTO();
	private NhanVienBUS nhanVienBUS = new NhanVienBUS();
	private AccountDTO accountDTO = new AccountDTO();
	private AccountBUS accountBUS = new AccountBUS();
	private JTable table1;
	private JTextField textTenDangNhap;
	private JPasswordField textMatKhau;
	private JComboBox jComboBox1;

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
					QuanLyTaiKhoan frame = new QuanLyTaiKhoan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuanLyTaiKhoan() {
		if (nhanVienBUS.getList() == null)
			nhanVienBUS.listNV();
		if (accountBUS.getList() == null)
			accountBUS.listAcc();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 555, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblQunLTi = new JLabel("Quản Lí Tài Khoản");
		lblQunLTi.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLTi.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQunLTi.setBounds(10, 0, 521, 53);
		contentPane.add(lblQunLTi);

		jComboBox1 = new JComboBox();
		jComboBox1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jComboBox1.setBounds(374, 324, 121, 30);
		contentPane.add(jComboBox1);

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Làm việc", "Đã nghỉ" }));

		// Hiển thị dữ liệu trong jtable
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 76, 236, 207);
		contentPane.add(scrollPane);

		ArrayList<AccountDTO> list = accountBUS.getList();

		// Tạo DefaultTableModel mới
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Tên đăng nhập");
		model.addColumn("Mật khẩu");
		model.addColumn("Trạng thái");

		// Đổ dữ liệu vào DefaultTableModel
		for (AccountDTO acc : list) {
			if (acc.getEnable() == 1 && acc.getRole().equals("NhanVien")) {
				model.addRow(new Object[] { acc.getTenDangNhap(), acc.getPassword(), "Làm việc" });
			}
		}

		// Sử dụng DefaultTableModel để tạo JTable
		table = new JTable(model);
		table.getColumnModel().getColumn(1).setCellRenderer(new PasswordRenderer());
		table.setAutoCreateRowSorter(true);
		 table.getColumnModel().getColumn(1).setCellEditor(new PasswordEditor(new JPasswordField()));
		scrollPane.setViewportView(table);

		// Cho phép table sắp xếp
		table.setAutoCreateRowSorter(true);

		Chang_Cursor(table);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(279, 76, 236, 207);
		contentPane.add(scrollPane_1);

		// Tạo DefaultTableModel mới
		DefaultTableModel model1 = new DefaultTableModel();
		model1.addColumn("Tên đăng nhập");
		model1.addColumn("Mật khẩu");
		model1.addColumn("Trạng thái");

		// Đổ dữ liệu vào DefaultTableModel
		for (AccountDTO acc : list) {
			if (acc.getEnable() == 0 && acc.getRole().equals("NhanVien")) {
				model1.addRow(new Object[] { acc.getTenDangNhap(), acc.getPassword(), "Đã nghỉ" });
			}
		}

		// Sử dụng DefaultTableModel để tạo JTable
		table1 = new JTable(model1);
		table1.getColumnModel().getColumn(1).setCellRenderer(new PasswordRenderer());
		table1.setAutoCreateRowSorter(true);
		 table1.getColumnModel().getColumn(1).setCellEditor(new PasswordEditor(new JPasswordField()));
		scrollPane_1.setViewportView(table1);

		// Cho phép table sắp xếp
		table1.setAutoCreateRowSorter(true);

		Chang_Cursor(table1);

		JLabel lblNewLabel = new JLabel("Nhân Viên làm việc");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 46, 146, 29);
		contentPane.add(lblNewLabel);

		JLabel lblNhnVin = new JLabel("Nhân Viên đã nghỉ");
		lblNhnVin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNhnVin.setBounds(295, 46, 146, 29);
		contentPane.add(lblNhnVin);

		textTenDangNhap = new JTextField();
		textTenDangNhap.setEnabled(false);
		textTenDangNhap.setEditable(false);
		textTenDangNhap.setBounds(49, 327, 115, 29);
		contentPane.add(textTenDangNhap);
		textTenDangNhap.setColumns(10);

		textMatKhau = new JPasswordField();
		textMatKhau.setEnabled(false);
		textMatKhau.setEditable(false);
		textMatKhau.setColumns(10);
		textMatKhau.setBounds(211, 329, 115, 29);
		contentPane.add(textMatKhau);

		JLabel lblNewLabel_1 = new JLabel("Tên đăng nhập");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(49, 293, 121, 29);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(211, 293, 121, 29);
		contentPane.add(lblNewLabel_1_1);

		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSua();
			}
		});
		btnSua.setIcon(new ImageIcon(
				QuanLyTaiKhoan.class.getResource("/com/NhacCu/item/Custom-Icon-Design-Flatastic-10-Edit-validated.16.png")));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSua.setBounds(49, 377, 115, 33);
		contentPane.add(btnSua);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setIcon(new ImageIcon(QuanLyTaiKhoan.class.getResource("/com/NhacCu/item/out.png")));
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThoat.setBounds(374, 377, 121, 33);
		contentPane.add(btnThoat);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXoa();
			}
		});
		btnXoa.setIcon(new ImageIcon(
				QuanLyTaiKhoan.class.getResource("/com/NhacCu/item/Custom-Icon-Design-Flatastic-1-Delete-1.16.png")));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoa.setBounds(211, 377, 115, 33);
		contentPane.add(btnXoa);
	}

	public void Chang_Cursor(final JTable table) {
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
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int index = table.getSelectedRow();
				textTenDangNhap.setText((String) table.getValueAt(index, 0));
				textMatKhau.setText((String) table.getValueAt(index, 1));
				jComboBox1.setSelectedItem(table.getValueAt(index, 2));

			}
		});
	}

	public void btnXoa() {
		ArrayList<AccountDTO> listnv = accountBUS.getList();
		accountBUS.delete_accNV(textTenDangNhap.getText());
		updateData(); // Cập nhật dữ liệu sau khi xóa
		JFrame frame = new JFrame("JOptionPane showMessageDialog");
		JOptionPane.showMessageDialog(frame, "Xóa nhân viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	}

	public void updateData() {
		// Cập nhật dữ liệu cho bảng nhân viên đang làm việc
		
		// Lấy lại danh sách dữ liệu từ BUS hoặc DAO
		ArrayList<AccountDTO> list = accountBUS.getList();
		// Tạo DefaultTableModel mới
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Tên đăng nhập");
		model.addColumn("Mật khẩu");
		model.addColumn("Trạng thái");

		// Đổ dữ liệu vào DefaultTableModel
		for (AccountDTO acc : list) {
			if (acc.getEnable() == 1 && acc.getRole().equals("NhanVien")) {
				model.addRow(new Object[] { acc.getTenDangNhap(), acc.getPassword(), "Làm việc" });
		
			}
		}
		// Cập nhật lại model cho JTable
		table.setModel(model);
		table.getColumnModel().getColumn(1).setCellRenderer(new PasswordRenderer());
		table.setAutoCreateRowSorter(true);
		 table.getColumnModel().getColumn(1).setCellEditor(new PasswordEditor(new JPasswordField()));
		// Cập nhật dữ liệu cho bảng nhân viên đã nghỉ
	
		DefaultTableModel model1 = new DefaultTableModel();
		model1.addColumn("Tên đăng nhập");
		model1.addColumn("Mật khẩu");
		model1.addColumn("Trạng thái");

		// Đổ dữ liệu vào DefaultTableModel
		for (AccountDTO acc : list) {
			if (acc.getEnable() == 0 && acc.getRole().equals("NhanVien")) {
				model1.addRow(new Object[] { acc.getTenDangNhap(), acc.getPassword(), "Đã nghỉ" });
				
			}
		}
		// Cập nhật lại model cho JTable
		table1.setModel(model1);
		table1.getColumnModel().getColumn(1).setCellRenderer(new PasswordRenderer());
		table1.setAutoCreateRowSorter(true);
		table1.getColumnModel().getColumn(1).setCellEditor(new PasswordEditor(new JPasswordField()));
	}

	public void btnSua() {
		ArrayList<NhanVienDTO> listnv = nhanVienBUS.getList();
		String tenDangNhap = textTenDangNhap.getText();
		String matKhau = textMatKhau.getText();
		String trangThai = (String) jComboBox1.getSelectedItem();
		for (NhanVienDTO nv : listnv) {
			if (nv.getTenDangNhap().equals(tenDangNhap)) {
				String maNhanVienNV = nv.getMaNhanVien();
				String tenDangNhapNV = nv.getTenDangNhap(); 
				String tenNhanVienNV = nv.getTenNhanVien();
				String gioiTinhNV = nv.getGioiTinh();
				String ngaySinhNV = nv.getNgaySinh();
				String sDTNV = nv.getSDT();
				String diaChiNV = nv.getDiaChi();
				String ghiChu = nv.getGhiChu();
				if (trangThai.equals("Làm việc")) {
					AccountDTO accountDTO = new AccountDTO(tenDangNhap, matKhau, "NhanVien", 1);
					accountBUS.updateAcc(accountDTO);
					NhanVienDTO nhanVienDTO = new NhanVienDTO(maNhanVienNV,tenDangNhapNV, tenNhanVienNV, gioiTinhNV, ngaySinhNV,
							sDTNV, diaChiNV, "NhanVien",ghiChu,  1);
					nhanVienBUS.updateNV(nhanVienDTO);
				} else {
					AccountDTO accountDTO = new AccountDTO(tenDangNhap, matKhau, "NhanVien", 0);
					accountBUS.updateAcc(accountDTO);
					NhanVienDTO nhanVienDTO = new NhanVienDTO(maNhanVienNV,tenDangNhapNV, tenNhanVienNV, gioiTinhNV, ngaySinhNV,
							sDTNV, diaChiNV,"NhanVien",ghiChu, 0);
					nhanVienBUS.updateNV(nhanVienDTO);
				}
			}
		}
		updateData();
	}

	// TableCellRenderer để hiển thị mật khẩu dưới dạng dấu "*"
	static class PasswordRenderer extends DefaultTableCellRenderer {
		@Override
		protected void setValue(Object value) {
			if (value instanceof String) {
				String password = (String) value;
				// Chuyển đổi mật khẩu thành chuỗi "*" có cùng độ dài
				StringBuilder maskedPassword = new StringBuilder();
				for (int i = 0; i < password.length(); i++) {
					maskedPassword.append("*");
				}
				value = maskedPassword.toString();
			}
			super.setValue(value);
		}
	}
    
 // TableCellEditor để hiển thị và chỉnh sửa mật khẩu
 	static class PasswordEditor extends DefaultCellEditor {
 	    public PasswordEditor(JPasswordField passwordField) {
 	        super(passwordField);
 	    }

 	    @Override
 	    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
 	        if (value instanceof String) {
 	            ((JPasswordField)editorComponent).setText((String)value);
 	        }
 	        return super.getTableCellEditorComponent(table, value, isSelected, row, column);
 	    }

 	    @Override
 	    public Object getCellEditorValue() {
 	        return new String(((JPasswordField) editorComponent).getPassword());
 	    }
 	}
}
