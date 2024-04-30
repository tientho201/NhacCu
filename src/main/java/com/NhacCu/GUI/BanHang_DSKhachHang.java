package com.NhacCu.GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.NhacCu.BUS.AccountBUS;
import com.NhacCu.BUS.NhanVienBUS;
import com.NhacCu.BUS.UserBUS;
import com.NhacCu.DTO.AccountDTO;
import com.NhacCu.DTO.NhanVienDTO;
import com.NhacCu.DTO.UserDTO;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BanHang_DSKhachHang extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textFieldMaKH;
	private JTextField textFieldTenDangNhap;
	private JTextField textFieldNgaySinh;
	private JTextField textFieldSDT;
	private JTextField textFieldDiaChi;
	private JTextArea textAreaMoTa;
	private UserBUS usBUS = new UserBUS();
	private AccountBUS accBUS = new AccountBUS();
	private JComboBox comboBoxTrangThai;
	private JComboBox comboBoxGioiTinh;
	private JTextField textFieldHovaTen;

	/**
	 * Create the panel.
	 */
	public BanHang_DSKhachHang() {
		initComponents();

		if (usBUS.getList() == null)
			usBUS.listUs();
		initTable(usBUS.getList());
		setcomboBoxGioiTinh();
		setcomboBoxTrangThai();
	}

	public void initComponents() {
		setBackground(new Color(0, 128, 255));
		setBounds(0, 0, 1336, 691);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("DANH SÁCH KHÁCH HÀNG");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 0, 1326, 78);
		add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 80, 1315, 280);
		add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1296, 259);
		panel.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null }, },
				new String[] { "M\u00E3 Kh\u00E1ch H\u00E0ng", "T\u00EAn \u0110\u0103ng Nh\u1EADp",
						"H\u1ECD v\u00E0 T\u00EAn", "Gi\u1EDBi T\u00EDnh", "Ng\u00E0y Sinh",
						"S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i", "\u0110\u1ECBa Ch\u1EC9", "Ghi Ch\u00FA",
						"Tr\u1EA1ng Th\u00E1i" }));
		scrollPane.setViewportView(table);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 370, 1316, 245);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Mã Khách Hàng");
		lblNewLabel_1.setBounds(10, 10, 107, 35);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		textFieldMaKH = new JTextField();
		textFieldMaKH.setBounds(143, 12, 149, 35);
		panel_1.add(textFieldMaKH);
		textFieldMaKH.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Tên Đăng Nhập");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 105, 107, 35);
		panel_1.add(lblNewLabel_1_1);

		textFieldTenDangNhap = new JTextField();
		textFieldTenDangNhap.setColumns(10);
		textFieldTenDangNhap.setBounds(143, 107, 149, 35);
		panel_1.add(textFieldTenDangNhap);

		JLabel lblNewLabel_1_1_1 = new JLabel("Họ và Tên");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(10, 190, 107, 35);
		panel_1.add(lblNewLabel_1_1_1);

		textFieldHovaTen = new JTextField();
		textFieldHovaTen.setColumns(10);
		textFieldHovaTen.setBounds(143, 192, 149, 35);
		panel_1.add(textFieldHovaTen);

		JLabel lblNewLabel_1_1_2 = new JLabel("Giới Tính");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(337, 10, 107, 35);
		panel_1.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Địa Chỉ");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_1.setBounds(705, 10, 107, 35);
		panel_1.add(lblNewLabel_1_1_2_1);

		JLabel lblNewLabel_1_1_2_2 = new JLabel("Ghi Chú");
		lblNewLabel_1_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_2.setBounds(1049, 10, 107, 35);
		panel_1.add(lblNewLabel_1_1_2_2);

		comboBoxGioiTinh = new JComboBox();
		comboBoxGioiTinh.setBounds(464, 12, 149, 35);
		panel_1.add(comboBoxGioiTinh);

		textFieldNgaySinh = new JTextField();
		textFieldNgaySinh.setColumns(10);
		textFieldNgaySinh.setBounds(464, 107, 149, 35);
		panel_1.add(textFieldNgaySinh);

		JLabel lblNewLabel_1_1_2_3 = new JLabel("Ngày Sinh");
		lblNewLabel_1_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_3.setBounds(337, 105, 107, 35);
		panel_1.add(lblNewLabel_1_1_2_3);

		JLabel lblNewLabel_1_1_2_3_1 = new JLabel("Số Điện Thoại");
		lblNewLabel_1_1_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_3_1.setBounds(337, 190, 107, 35);
		panel_1.add(lblNewLabel_1_1_2_3_1);

		textFieldSDT = new JTextField();
		textFieldSDT.setColumns(10);
		textFieldSDT.setBounds(464, 192, 149, 35);
		panel_1.add(textFieldSDT);

		textFieldDiaChi = new JTextField();
		textFieldDiaChi.setColumns(10);
		textFieldDiaChi.setBounds(822, 10, 149, 35);
		panel_1.add(textFieldDiaChi);

		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Trạng Thái");
		lblNewLabel_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_1_1.setBounds(705, 105, 107, 35);
		panel_1.add(lblNewLabel_1_1_2_1_1);

		comboBoxTrangThai = new JComboBox();
		comboBoxTrangThai.setBounds(822, 105, 149, 35);
		panel_1.add(comboBoxTrangThai);

		textAreaMoTa = new JTextArea();
		textAreaMoTa.setBounds(564, 46, 85, 112);
		textAreaMoTa.setLineWrap(true); // Tự động xuống dòng khi văn bản vượt quá kích thước của JTextArea
		textAreaMoTa.setWrapStyleWord(true); // Tự động cắt từ khi văn bản vượt quá kích thước của JTextArea
		JScrollPane scrollPane1 = new JScrollPane(textAreaMoTa);
		scrollPane1.setBounds(1049, 62, 257, 163);
		panel_1.add(scrollPane1);
		scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		// dọc
		scrollPane1.setAutoscrolls(true);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 625, 1316, 56);
		add(panel_2);
		panel_2.setLayout(null);

		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				them();
			}
		});
		btnNewButton.setIcon(new ImageIcon(BanHang_DSKhachHang.class.getResource("/com/NhacCu/item/plus_24.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(10, 10, 144, 36);
		panel_2.add(btnNewButton);

		JButton btnXa = new JButton("Xóa");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoa();
			}
		});
		btnXa.setIcon(new ImageIcon(BanHang_DSKhachHang.class.getResource("/com/NhacCu/item/remove_24.png")));
		btnXa.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXa.setBounds(361, 10, 144, 36);
		panel_2.add(btnXa);

		JButton btnNewButton_1_1 = new JButton("Sửa");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sua();
			}
		});
		btnNewButton_1_1
				.setIcon(new ImageIcon(BanHang_DSKhachHang.class.getResource("/com/NhacCu/item/pencil_24.png")));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1_1.setBounds(779, 10, 144, 36);
		panel_2.add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("Reload");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reload();
			}
		});
		btnNewButton_1_2
				.setIcon(new ImageIcon(BanHang_DSKhachHang.class.getResource("/com/NhacCu/item/refresh_24.png")));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1_2.setBounds(1162, 10, 144, 36);
		panel_2.add(btnNewButton_1_2);
	}

	public void initTable(ArrayList<UserDTO> listUS) {
		// Tạo DefaultTableModel mới
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã Người Dùng");
		model.addColumn("Tên Đăng Nhập");
		model.addColumn("Họ và Tên");
		model.addColumn("Giới Tính");
		model.addColumn("Ngày Sinh");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Địa Chỉ");
		model.addColumn("Ghi Chú");
		model.addColumn("Trạng Thái");

		for (UserDTO us : listUS) {
			if (us.getEnable() == 1) {
				model.addRow(new Object[] { us.getMaUser(), us.getTenDangNhap(), us.getHovaTen(), us.getGioiTinh(),
						us.getNgaySinh(), us.getSDT(), us.getDiaChi(), us.getGhiChu(), "Hoạt Động" });
			} else {
				model.addRow(new Object[] { us.getMaUser(), us.getTenDangNhap(), us.getHovaTen(), us.getGioiTinh(),
						us.getNgaySinh(), us.getSDT(), us.getDiaChi(), us.getGhiChu(), "Tạm Dừng" });
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
				textFieldMaKH.setText((String) table.getValueAt(index, 0));
				textFieldMaKH.setEditable(false);
				textFieldMaKH.setEnabled(false);
				textFieldTenDangNhap.setText((String) table.getValueAt(index, 1));
				textFieldTenDangNhap.setEditable(false);
				textFieldTenDangNhap.setEnabled(false);
				textFieldHovaTen.setText((String) table.getValueAt(index, 2));

				String selectedGioiTinh = String.valueOf(table.getValueAt(index, 3));
				comboBoxGioiTinh.setSelectedItem(selectedGioiTinh);

				textFieldNgaySinh.setText((String) table.getValueAt(index, 4));
				textFieldSDT.setText((String) table.getValueAt(index, 5));
				textFieldDiaChi.setText((String) table.getValueAt(index, 6));

				textAreaMoTa.setText((String) table.getValueAt(index, 7));

				String selectedTrangThai = String.valueOf(table.getValueAt(index, 8));
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

	public void setcomboBoxTrangThai() {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.addElement("Hoạt Động");
		model.addElement("Tạm Dừng");
		comboBoxTrangThai.setModel(model);
	}

	public boolean kiemtraRong() {
		if (textFieldMaKH.getText() == null || textFieldMaKH.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Mã Khách Hàng không được trống!", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			textFieldMaKH.requestFocus();
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
		if (textFieldSDT.getText() == null || textFieldSDT.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Số Điện Thoại không được trống!", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			textFieldSDT.requestFocus();
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
		textFieldMaKH.setText("");
		textFieldMaKH.setEditable(true);
		textFieldMaKH.setEnabled(true);

		textFieldSDT.setText("");
		textFieldTenDangNhap.setText("");
		textFieldTenDangNhap.setEditable(true);
		textFieldTenDangNhap.setEnabled(true);

		textFieldDiaChi.setText("");
		textFieldHovaTen.setText("");
		textFieldNgaySinh.setText("");
		textAreaMoTa.setText("");

		comboBoxTrangThai.setSelectedIndex(0);
		comboBoxGioiTinh.setSelectedIndex(0);

		UserBUS usBUSreload = new UserBUS();

		if (usBUSreload.getList() == null)
			usBUSreload.listUs();

		setcomboBoxGioiTinh();
		setcomboBoxTrangThai();

		initTable(usBUSreload.getList());

	}

	public void them() {
		if (kiemtraRong()) {
			if (!usBUS.checkMaUser(textFieldMaKH.getText())) {
				if (!accBUS.checkTenDangNhap(textFieldTenDangNhap.getText())) {

					if (comboBoxTrangThai.getSelectedItem().equals("Hoạt Động")) {
						AccountDTO accDTO = new AccountDTO(textFieldTenDangNhap.getText(),
								textFieldTenDangNhap.getText(), "KhachHang", 1);
						accBUS.addAcc(accDTO);
						UserDTO usDTO = new UserDTO(textFieldMaKH.getText(), textFieldTenDangNhap.getText(),
								textFieldHovaTen.getText(), comboBoxGioiTinh.getSelectedItem().toString(),
								textFieldNgaySinh.getText(), textFieldSDT.getText(), textFieldDiaChi.getText(),
								textAreaMoTa.getText(), 1);
						usBUS.addUs(usDTO);
					} else {
						AccountDTO accDTO = new AccountDTO(textFieldTenDangNhap.getText(),
								textFieldTenDangNhap.getText(), "KhachHang", 0);
						accBUS.addAcc(accDTO);
						UserDTO usDTO = new UserDTO(textFieldMaKH.getText(), textFieldTenDangNhap.getText(),
								textFieldHovaTen.getText(), comboBoxGioiTinh.getSelectedItem().toString(),
								textFieldNgaySinh.getText(), textFieldSDT.getText(), textFieldDiaChi.getText(),
								textAreaMoTa.getText(), 0);
						usBUS.addUs(usDTO);
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
			if (!usBUS.checkMaUser(textFieldMaKH.getText())) {
				if (!accBUS.checkTenDangNhap(textFieldTenDangNhap.getText())) {
					if (comboBoxTrangThai.getSelectedItem().equals("Hoạt Động")) {
						AccountDTO accDTO = new AccountDTO(textFieldTenDangNhap.getText(),
								textFieldTenDangNhap.getText(), "KhachHang", 1);
						accBUS.updateAcc(accDTO);
						UserDTO usDTO = new UserDTO(textFieldMaKH.getText(), textFieldTenDangNhap.getText(),
								textFieldHovaTen.getText(), comboBoxGioiTinh.getSelectedItem().toString(),
								textFieldNgaySinh.getText(), textFieldSDT.getText(), textFieldDiaChi.getText(),
								textAreaMoTa.getText(), 1);
						usBUS.updateUs(usDTO);
					} else {
						AccountDTO accDTO = new AccountDTO(textFieldTenDangNhap.getText(),
								textFieldTenDangNhap.getText(), "KhachHang", 0);
						accBUS.updateAcc(accDTO);
						UserDTO usDTO = new UserDTO(textFieldMaKH.getText(), textFieldTenDangNhap.getText(),
								textFieldHovaTen.getText(), comboBoxGioiTinh.getSelectedItem().toString(),
								textFieldNgaySinh.getText(), textFieldSDT.getText(), textFieldDiaChi.getText(),
								textAreaMoTa.getText(), 0);
						usBUS.updateUs(usDTO);
					}

				}
				JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
				Reload();
			} else {
				JOptionPane.showMessageDialog(null, "Tên Đăng Nhập bị trùng", "Thông báo", JOptionPane.DEFAULT_OPTION);
			}

		} else {

			JOptionPane.showMessageDialog(null, "Tài Khoản bị trùng", "Thông báo", JOptionPane.DEFAULT_OPTION);
		}
	}


	public void xoa() {
		if (kiemtraRong()) {
			accBUS.delete_accUS(textFieldTenDangNhap.getText());
			JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
			Reload();
		}
	}
}
