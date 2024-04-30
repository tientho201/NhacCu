package com.NhacCu.GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.NhacCu.BUS.*;
import com.NhacCu.DTO.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_DsTaiKhoan extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldMaNguoiDung;
	private JTextField textFieldHovaTen;
	private JTextField textFieldNgaySinh;
	private JTextField textFieldDiaChi;
	private JTable table;
	private NhanVienBUS nvBUS = new NhanVienBUS();
	private UserBUS usBUS = new UserBUS();
	private AccountBUS accBUS = new AccountBUS();
	private JComboBox comboBoxGioiTinh;
	private JTextField textFieldSoDienThoai;
	private JComboBox comboBoxTrangThai;
	private JTextArea textAreaMoTa;
	private JComboBox comboBoxVaiTro;
	private JTextField textFieldTenDangNhap;

	/**
	 * Create the panel.
	 */
	public Admin_DsTaiKhoan() {
		if (nvBUS.getList() == null) {
			nvBUS.listNV();
		}
		if (accBUS.getList() == null) {
			accBUS.listAcc();
		}
		if (usBUS.getList() == null)
			usBUS.listUs();
		initComponents();
		initTable(nvBUS.getList(), usBUS.getList());
		setcomboBoxGioiTinh();
		setcomboBoxVaitro();
		setcomboBoxTrangThai();
	}

	public void initComponents() {
		setBounds(0, 0, 1117, 685);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("DANH SÁCH TÀI KHOẢN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 0, 1117, 70);
		add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 80, 1097, 280);
		add(panel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1077, 259);
		panel.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null }, },
				new String[] { "M\u00E3 Ng\u01B0\u1EDDi D\u00F9ng", "H\u1ECD v\u00E0 T\u00EAn", "Gi\u1EDBi T\u00EDnh",
						"Ng\u00E0y Sinh", "S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i", "\u0110\u1ECBa Ch\u1EC9", "Vai Tr\u00F2",
						"Ghi Ch\u00FA", "Tr\u1EA1ng Th\u00E1i" }));
		scrollPane.setViewportView(table);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setLayout(null);
		panel_1.setBounds(10, 370, 1097, 245);
		add(panel_1);

		JLabel lblNewLabel_1 = new JLabel("Mã Người Dùng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 10, 107, 35);
		panel_1.add(lblNewLabel_1);

		textFieldMaNguoiDung = new JTextField();
		textFieldMaNguoiDung.setColumns(10);
		textFieldMaNguoiDung.setBounds(143, 12, 149, 35);
		panel_1.add(textFieldMaNguoiDung);

		JLabel lblNewLabel_1_1 = new JLabel("Vai Trò");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(337, 190, 107, 35);
		panel_1.add(lblNewLabel_1_1);

		textFieldHovaTen = new JTextField();
		textFieldHovaTen.setColumns(10);
		textFieldHovaTen.setBounds(143, 134, 149, 35);
		panel_1.add(textFieldHovaTen);

		JLabel lblNewLabel_1_1_1 = new JLabel("Họ và Tên");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(10, 134, 107, 35);
		panel_1.add(lblNewLabel_1_1_1);

		textFieldNgaySinh = new JTextField();
		textFieldNgaySinh.setColumns(10);
		textFieldNgaySinh.setBounds(143, 192, 149, 35);
		panel_1.add(textFieldNgaySinh);

		JLabel lblNewLabel_1_1_2 = new JLabel("Giới Tính");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(337, 10, 107, 35);
		panel_1.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Địa Chỉ");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_1.setBounds(337, 134, 107, 35);
		panel_1.add(lblNewLabel_1_1_2_1);

		JLabel lblNewLabel_1_1_2_2 = new JLabel("Ghi Chú");
		lblNewLabel_1_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_2.setBounds(705, 69, 107, 35);
		panel_1.add(lblNewLabel_1_1_2_2);

		comboBoxGioiTinh = new JComboBox();
		comboBoxGioiTinh.setBounds(464, 12, 149, 35);
		panel_1.add(comboBoxGioiTinh);

		textFieldSoDienThoai = new JTextField();
		textFieldSoDienThoai.setColumns(10);
		textFieldSoDienThoai.setBounds(464, 71, 149, 35);
		panel_1.add(textFieldSoDienThoai);

		JLabel lblNewLabel_1_1_2_3 = new JLabel("Ngày Sinh");
		lblNewLabel_1_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_3.setBounds(10, 190, 107, 35);
		panel_1.add(lblNewLabel_1_1_2_3);

		JLabel lblNewLabel_1_1_2_3_1 = new JLabel("Số Điện Thoại");
		lblNewLabel_1_1_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_3_1.setBounds(337, 69, 107, 35);
		panel_1.add(lblNewLabel_1_1_2_3_1);

		textFieldDiaChi = new JTextField();
		textFieldDiaChi.setColumns(10);
		textFieldDiaChi.setBounds(464, 134, 149, 35);
		panel_1.add(textFieldDiaChi);

		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Trạng Thái");
		lblNewLabel_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_1_1.setBounds(705, 12, 107, 35);
		panel_1.add(lblNewLabel_1_1_2_1_1);

		comboBoxTrangThai = new JComboBox();
		comboBoxTrangThai.setBounds(822, 12, 198, 35);
		panel_1.add(comboBoxTrangThai);

		JScrollPane scrollPane1 = new JScrollPane((Component) null);
		scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane1.setAutoscrolls(true);
		scrollPane1.setBounds(822, 75, 198, 150);
		panel_1.add(scrollPane1);

		textAreaMoTa = new JTextArea();
		scrollPane1.setViewportView(textAreaMoTa);

		comboBoxVaiTro = new JComboBox();
		comboBoxVaiTro.setBounds(464, 192, 149, 35);
		panel_1.add(comboBoxVaiTro);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Tên Đăng Nhập");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(10, 69, 107, 35);
		panel_1.add(lblNewLabel_1_1_1_1);

		textFieldTenDangNhap = new JTextField();
		textFieldTenDangNhap.setColumns(10);
		textFieldTenDangNhap.setBounds(143, 69, 149, 35);
		panel_1.add(textFieldTenDangNhap);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setLayout(null);
		panel_2.setBounds(10, 625, 1097, 56);
		add(panel_2);

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				them();
			}
		});
		btnThem.setIcon(new ImageIcon(Admin_DsTaiKhoan.class.getResource("/com/NhacCu/item/plus_24.png")));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThem.setBounds(10, 10, 144, 36);
		panel_2.add(btnThem);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoa();
			}
		});
		btnXoa.setIcon(new ImageIcon(Admin_DsTaiKhoan.class.getResource("/com/NhacCu/item/remove_24.png")));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXoa.setBounds(289, 10, 144, 36);
		panel_2.add(btnXoa);

		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sua();
			}
		});
		btnSua.setIcon(new ImageIcon(Admin_DsTaiKhoan.class.getResource("/com/NhacCu/item/pencil_24.png")));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSua.setBounds(654, 10, 144, 36);
		panel_2.add(btnSua);

		JButton btnReload = new JButton("Reload");
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reload();
			}
		});
		btnReload.setIcon(new ImageIcon(Admin_DsTaiKhoan.class.getResource("/com/NhacCu/item/refresh_24.png")));
		btnReload.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReload.setBounds(943, 10, 144, 36);
		panel_2.add(btnReload);
	}

	public void initTable(ArrayList<NhanVienDTO> listNV, ArrayList<UserDTO> listUS) {
		// Tạo DefaultTableModel mới
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã Người Dùng");
		model.addColumn("Tên Đăng Nhập");
		model.addColumn("Họ và Tên");
		model.addColumn("Giới Tính");
		model.addColumn("Ngày Sinh");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Địa Chỉ");
		model.addColumn("Vai Trò");
		model.addColumn("Ghi Chú");
		model.addColumn("Trạng Thái");

//		 Đổ dữ liệu vào DefaultTableModel
		for (NhanVienDTO nv : listNV) {
			if (nv.getEnable() == 1) {
				model.addRow(new Object[] { nv.getMaNhanVien(), nv.getTenDangNhap(), nv.getTenNhanVien(),
						nv.getGioiTinh(), nv.getNgaySinh(), nv.getSDT(), nv.getDiaChi(), nv.getChucVu(), nv.getGhiChu(),
						"Hoạt Động" });
			} else {
				model.addRow(new Object[] { nv.getMaNhanVien(), nv.getTenDangNhap(), nv.getTenNhanVien(),
						nv.getGioiTinh(), nv.getNgaySinh(), nv.getSDT(), nv.getDiaChi(), nv.getChucVu(), nv.getGhiChu(),
						"Tạm Dừng" });
			}

		}
		for (UserDTO us : listUS) {
			if (us.getEnable() == 1) {
				model.addRow(new Object[] { us.getMaUser(), us.getTenDangNhap(), us.getHovaTen(), us.getGioiTinh(),
						us.getNgaySinh(), us.getSDT(), us.getDiaChi(), "KhachHang", us.getGhiChu(), "Hoạt Động" });
			} else {
				model.addRow(new Object[] { us.getMaUser(), us.getTenDangNhap(), us.getHovaTen(), us.getGioiTinh(),
						us.getNgaySinh(), us.getSDT(), us.getDiaChi(), "KhachHang", us.getGhiChu(), "Tạm Dừng" });
			}

		}

//		// Sử dụng DefaultTableModel để tạo JTable
		this.table.setModel(model);
//
//		// Cho phép table sắp xếp
		table.setAutoCreateRowSorter(true);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int index = table.getSelectedRow();
				textFieldMaNguoiDung.setText((String) table.getValueAt(index, 0));
				textFieldMaNguoiDung.setEditable(false);
				textFieldMaNguoiDung.setEnabled(false);
				textFieldTenDangNhap.setText((String) table.getValueAt(index, 1));
				textFieldTenDangNhap.setEditable(false);
				textFieldTenDangNhap.setEnabled(false);
				textFieldHovaTen.setText((String) table.getValueAt(index, 2));

				String selectedGioiTinh = String.valueOf(table.getValueAt(index, 3));
				comboBoxGioiTinh.setSelectedItem(selectedGioiTinh);

				textFieldNgaySinh.setText((String) table.getValueAt(index, 4));
				textFieldSoDienThoai.setText((String) table.getValueAt(index, 5));
				textFieldDiaChi.setText((String) table.getValueAt(index, 6));

				String selectedVaiTro = String.valueOf(table.getValueAt(index, 7));
				comboBoxVaiTro.setSelectedItem(selectedVaiTro);

				textAreaMoTa.setText((String) table.getValueAt(index, 8));

				String selectedTrangThai = String.valueOf(table.getValueAt(index, 9));
				comboBoxTrangThai.setSelectedItem(selectedTrangThai);

			}
		});
	}

	public void setcomboBoxGioiTinh() {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.addElement("Nam");
		model.addElement("Nữ");
		comboBoxGioiTinh.setModel(model);
	}

	public void setcomboBoxVaitro() {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.addElement("ChuDoanhNghiep");
		model.addElement("Admin");
		model.addElement("NhanVien");
		model.addElement("QLK");
		model.addElement("KhachHang");
		comboBoxVaiTro.setModel(model);
	}

	public void setcomboBoxTrangThai() {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.addElement("Hoạt Động");
		model.addElement("Tạm Dừng");
		comboBoxTrangThai.setModel(model);
	}

	public boolean kiemtraRong() {
		if (textFieldMaNguoiDung.getText() == null || textFieldMaNguoiDung.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Mã Người Dùng không được trống!", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			textFieldMaNguoiDung.requestFocus();
			return false;
		}
		if (textFieldDiaChi.getText() == null || textFieldDiaChi.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Địa Chỉ không được trống!", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			textFieldDiaChi.requestFocus();
			return false;
		}
		if (textFieldHovaTen.getText() == null || textFieldHovaTen.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Họ và Tên không được trống!", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			textFieldHovaTen.requestFocus();
			return false;
		}
		if (textFieldNgaySinh.getText() == null || textFieldNgaySinh.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Ngày Sinh không được trống!", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			textFieldNgaySinh.requestFocus();
			return false;
		}
		if (textFieldSoDienThoai.getText() == null || textFieldSoDienThoai.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Số Điện Thoại không được trống!", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			textFieldSoDienThoai.requestFocus();
			return false;
		}
		if (textFieldTenDangNhap.getText() == null || textFieldTenDangNhap.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Tên Đăng Nhập không được trống!", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			textFieldTenDangNhap.requestFocus();
			return false;
		}
		return true;
	}

	public void Reload() {
		textFieldMaNguoiDung.setText("");
		textFieldMaNguoiDung.setEditable(true);
		textFieldMaNguoiDung.setEnabled(true);

		textFieldSoDienThoai.setText("");
		textFieldTenDangNhap.setText("");
		textFieldTenDangNhap.setEditable(true);
		textFieldTenDangNhap.setEnabled(true);

		textFieldDiaChi.setText("");
		textFieldHovaTen.setText("");
		textFieldNgaySinh.setText("");
		textAreaMoTa.setText("");

		comboBoxTrangThai.setSelectedIndex(0);
		comboBoxGioiTinh.setSelectedIndex(0);
		comboBoxVaiTro.setSelectedIndex(0);

		NhanVienBUS nvBUSreload = new NhanVienBUS();
		UserBUS usBUSreload = new UserBUS();
		if (nvBUSreload.getList() == null)
			nvBUSreload.listNV();
		if (usBUSreload.getList() == null)
			usBUSreload.listUs();

		setcomboBoxGioiTinh();
		setcomboBoxTrangThai();
		setcomboBoxVaitro();
		initTable(nvBUSreload.getList(), usBUSreload.getList());

	}

	public void them() {
		if (kiemtraRong()) {
			if (!nvBUS.checkMaNV(textFieldMaNguoiDung.getText())
					&& !usBUS.checkMaUser(textFieldMaNguoiDung.getText())) {
				if (!accBUS.checkTenDangNhap(textFieldTenDangNhap.getText())) {
					if (comboBoxVaiTro.getSelectedItem().equals("KhachHang")) {
						if (comboBoxTrangThai.getSelectedItem().equals("Hoạt Động")) {
							AccountDTO accDTO = new AccountDTO(textFieldTenDangNhap.getText(),
									textFieldTenDangNhap.getText(), "KhachHang", 1);
							accBUS.addAcc(accDTO);
							UserDTO usDTO = new UserDTO(textFieldMaNguoiDung.getText(), textFieldTenDangNhap.getText(),
									textFieldHovaTen.getText(), comboBoxGioiTinh.getSelectedItem().toString(),
									textFieldNgaySinh.getText(), textFieldSoDienThoai.getText(),
									textFieldDiaChi.getText(), textAreaMoTa.getText(), 1);
							usBUS.addUs(usDTO);
						} else {
							AccountDTO accDTO = new AccountDTO(textFieldTenDangNhap.getText(),
									textFieldTenDangNhap.getText(), "KhachHang", 0);
							accBUS.addAcc(accDTO);
							UserDTO usDTO = new UserDTO(textFieldMaNguoiDung.getText(), textFieldTenDangNhap.getText(),
									textFieldHovaTen.getText(), comboBoxGioiTinh.getSelectedItem().toString(),
									textFieldNgaySinh.getText(), textFieldSoDienThoai.getText(),
									textFieldDiaChi.getText(), textAreaMoTa.getText(), 0);
							usBUS.addUs(usDTO);
						}
					} else {
						if (comboBoxTrangThai.getSelectedItem().equals("Hoạt Động")) {
							AccountDTO accDTO = new AccountDTO(textFieldTenDangNhap.getText(),
									textFieldTenDangNhap.getText(), comboBoxVaiTro.getSelectedItem().toString(), 1);
							accBUS.addAcc(accDTO);
							NhanVienDTO nvDTO = new NhanVienDTO(textFieldMaNguoiDung.getText(),
									textFieldTenDangNhap.getText(), textFieldHovaTen.getText(),
									comboBoxGioiTinh.getSelectedItem().toString(), textFieldNgaySinh.getText(),
									textFieldSoDienThoai.getText(), textFieldDiaChi.getText(),
									comboBoxVaiTro.getSelectedItem().toString(), textAreaMoTa.getText(), 1);
							nvBUS.addNV(nvDTO);
						} else {
							AccountDTO accDTO = new AccountDTO(textFieldTenDangNhap.getText(),
									textFieldTenDangNhap.getText(), comboBoxVaiTro.getSelectedItem().toString(), 0);
							accBUS.addAcc(accDTO);
							NhanVienDTO nvDTO = new NhanVienDTO(textFieldMaNguoiDung.getText(),
									textFieldTenDangNhap.getText(), textFieldHovaTen.getText(),
									comboBoxGioiTinh.getSelectedItem().toString(), textFieldNgaySinh.getText(),
									textFieldSoDienThoai.getText(), textFieldDiaChi.getText(),
									comboBoxVaiTro.getSelectedItem().toString(), textAreaMoTa.getText(), 0);
							nvBUS.addNV(nvDTO);
						}
					}
					JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
					Reload();
				} else {
					JOptionPane.showMessageDialog(null, "Tên Đăng Nhập bị trùng", "Thông báo",
							JOptionPane.DEFAULT_OPTION);
				}

			} else {

				JOptionPane.showMessageDialog(null, "Tài Khoản bị trùng", "Thông báo", JOptionPane.DEFAULT_OPTION);
			}
		}
	}

	public void sua() {
		if (kiemtraRong()) {

			if (comboBoxVaiTro.getSelectedItem().equals("KhachHang")) {
				if (comboBoxTrangThai.getSelectedItem().equals("Hoạt Động")) {
					AccountDTO accDTO = new AccountDTO(textFieldTenDangNhap.getText(), textFieldTenDangNhap.getText(),
							"KhachHang", 1);
					accBUS.updateAcc(accDTO);
					UserDTO usDTO = new UserDTO(textFieldMaNguoiDung.getText(), textFieldTenDangNhap.getText(),
							textFieldHovaTen.getText(), comboBoxGioiTinh.getSelectedItem().toString(),
							textFieldNgaySinh.getText(), textFieldSoDienThoai.getText(), textFieldDiaChi.getText(),
							textAreaMoTa.getText(), 1);
					usBUS.updateUs(usDTO);
				} else {
					AccountDTO accDTO = new AccountDTO(textFieldTenDangNhap.getText(), textFieldTenDangNhap.getText(),
							"KhachHang", 0);
					accBUS.updateAcc(accDTO);
					UserDTO usDTO = new UserDTO(textFieldMaNguoiDung.getText(), textFieldTenDangNhap.getText(),
							textFieldHovaTen.getText(), comboBoxGioiTinh.getSelectedItem().toString(),
							textFieldNgaySinh.getText(), textFieldSoDienThoai.getText(), textFieldDiaChi.getText(),
							textAreaMoTa.getText(), 0);
					usBUS.updateUs(usDTO);
				}
			} else {
				if (comboBoxTrangThai.getSelectedItem().equals("Hoạt Động")) {
					AccountDTO accDTO = new AccountDTO(textFieldTenDangNhap.getText(), textFieldTenDangNhap.getText(),
							comboBoxVaiTro.getSelectedItem().toString(), 1);
					accBUS.updateAcc(accDTO);
					NhanVienDTO nvDTO = new NhanVienDTO(textFieldMaNguoiDung.getText(), textFieldTenDangNhap.getText(),
							textFieldHovaTen.getText(), comboBoxGioiTinh.getSelectedItem().toString(),
							textFieldNgaySinh.getText(), textFieldSoDienThoai.getText(), textFieldDiaChi.getText(),
							comboBoxVaiTro.getSelectedItem().toString(), textAreaMoTa.getText(), 1);
					nvBUS.updateNV(nvDTO);
				} else {
					AccountDTO accDTO = new AccountDTO(textFieldTenDangNhap.getText(), textFieldTenDangNhap.getText(),
							comboBoxVaiTro.getSelectedItem().toString(), 0);
					accBUS.updateAcc(accDTO);
					NhanVienDTO nvDTO = new NhanVienDTO(textFieldMaNguoiDung.getText(), textFieldTenDangNhap.getText(),
							textFieldHovaTen.getText(), comboBoxGioiTinh.getSelectedItem().toString(),
							textFieldNgaySinh.getText(), textFieldSoDienThoai.getText(), textFieldDiaChi.getText(),
							comboBoxVaiTro.getSelectedItem().toString(), textAreaMoTa.getText(), 0);
					nvBUS.updateNV(nvDTO);
				}
			}
			JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
			Reload();

		}
	}

	public void xoa() {
		if (kiemtraRong()) {
			if (comboBoxVaiTro.getSelectedItem().equals("KhachHang")) {
				accBUS.delete_accUS(textFieldTenDangNhap.getText());
			} else {
				accBUS.delete_accNV(textFieldTenDangNhap.getText());
			}
			JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
			Reload();
		}
	}
}
