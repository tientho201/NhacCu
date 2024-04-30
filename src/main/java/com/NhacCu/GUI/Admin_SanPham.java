package com.NhacCu.GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.NhacCu.BUS.LoaiBUS;
import com.NhacCu.BUS.NhaSanXuatBUS;
import com.NhacCu.BUS.SanPhamBUS;
import com.NhacCu.DTO.LoaiDTO;
import com.NhacCu.DTO.NhaSanXuatDTO;
import com.NhacCu.DTO.SanPhamDTO;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_SanPham extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldMaSP;
	private JTextField textFieldGia;
	private JTextField textFieldSoLuong;
	private JTextField textFieldTenSP;
	private JTable table;
	private SanPhamBUS spBUS = new SanPhamBUS();
	private LoaiBUS loaiBUS = new LoaiBUS();
	private NhaSanXuatBUS nsxBUS = new NhaSanXuatBUS();
	private JComboBox comboBoxMaLoai;
	private JComboBox comboBoxNSX;
	private JTextArea textAreaMoTa;
	private JLabel lblImg;

	/**
	 * Create the panel.
	 */
	public Admin_SanPham() {
		if (spBUS.getList() == null)
			spBUS.listSP();
		if (loaiBUS.getList() == null)
			loaiBUS.listLoai();
		if (nsxBUS.getList() == null)
			nsxBUS.list();
		initComponents();
		setcomboBoxMaLoai(loaiBUS.getList());
		setcomboBoxNSX(nsxBUS.getList());
		initTable(spBUS.getList(), loaiBUS.getList(), nsxBUS.getList());
	}

	public void initComponents() {
		setBounds(0, 0, 1117, 685);
		setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("BẢNG SẢN PHẨM");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(6, 3, 1099, 53);
		add(lblNewLabel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setForeground(Color.WHITE);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 65, 1092, 254);
		add(panel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1069, 233);
		panel_2.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, },
				new String[] { "M\u00E3 S\u1EA3n Ph\u1EA9m", "M\u00E3 Lo\u1EA1i", "T\u00EAn S\u1EA3n Ph\u1EA9m",
						"S\u1ED1 L\u01B0\u1EE3ng", "Gi\u00E1", "Nh\u00E0 S\u1EA3n Xu\u1EA5t", "\u1EA2nh",
						"M\u00F4 T\u1EA3" }));
		scrollPane.setViewportView(table);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setLayout(null);
		panel_3.setBounds(6, 334, 1103, 328);
		add(panel_3);

		JLabel lblNewLabel_2 = new JLabel("Mã SP");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(13, 10, 74, 31);
		panel_3.add(lblNewLabel_2);

		textFieldMaSP = new JTextField();
		textFieldMaSP.setColumns(10);
		textFieldMaSP.setBounds(129, 10, 146, 32);
		panel_3.add(textFieldMaSP);

		JLabel lblNewLabel_2_1 = new JLabel("Mã Loại");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(13, 65, 74, 31);
		panel_3.add(lblNewLabel_2_1);

		comboBoxMaLoai = new JComboBox();
		comboBoxMaLoai.setBounds(128, 66, 146, 31);
		panel_3.add(comboBoxMaLoai);

		JLabel lblNewLabel_2_1_1 = new JLabel("Nhà SX");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(13, 127, 85, 31);
		panel_3.add(lblNewLabel_2_1_1);

		comboBoxNSX = new JComboBox();
		comboBoxNSX.setBounds(129, 125, 146, 31);
		panel_3.add(comboBoxNSX);

		JLabel lblNewLabel_2_2 = new JLabel("Giá");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(365, 8, 74, 31);
		panel_3.add(lblNewLabel_2_2);

		textFieldGia = new JTextField();
		textFieldGia.setColumns(10);
		textFieldGia.setBounds(540, 11, 146, 32);
		panel_3.add(textFieldGia);

		JLabel lblNewLabel_2_2_1 = new JLabel("Tên SP");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_1.setBounds(364, 64, 74, 31);
		panel_3.add(lblNewLabel_2_2_1);

		JLabel lblNewLabel_2_2_1_1 = new JLabel("Số Lượng");
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_1_1.setBounds(369, 131, 74, 31);
		panel_3.add(lblNewLabel_2_2_1_1);

		textFieldSoLuong = new JTextField();
		textFieldSoLuong.setColumns(10);
		textFieldSoLuong.setBounds(543, 127, 146, 32);
		panel_3.add(textFieldSoLuong);

		textFieldTenSP = new JTextField();
		textFieldTenSP.setColumns(10);
		textFieldTenSP.setBounds(541, 65, 146, 32);
		panel_3.add(textFieldTenSP);

		JLabel lblNewLabel_2_2_2 = new JLabel("Mô Tả");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_2.setBounds(908, 10, 85, 31);
		panel_3.add(lblNewLabel_2_2_2);


		
		textAreaMoTa = new JTextArea();
		textAreaMoTa.setBounds(564, 46, 85, 112);
		textAreaMoTa.setLineWrap(true); // Tự động xuống dòng khi văn bản vượt quá kích thước của JTextArea
		textAreaMoTa.setWrapStyleWord(true); // Tự động cắt từ khi văn bản vượt quá kích thước của JTextArea
		
		JScrollPane scrollPane1 = new JScrollPane(textAreaMoTa);
		scrollPane1.setBounds(908, 56, 146, 120);
		scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Hiển thị thanh cuộn theo chiều
																						// dọc
		scrollPane1.setAutoscrolls(true); // Tự động cuộn theo con trỏ chuột
		panel_3.add(scrollPane1);

		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themSanPham();
			}
		});
		btnNewButton.setIcon(new ImageIcon(Admin_SanPham.class.getResource("/com/NhacCu/item/plus_24.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(23, 284, 103, 31);
		panel_3.add(btnNewButton);

		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sửa();
			}
		});
		btnSua.setIcon(new ImageIcon(Admin_SanPham.class.getResource("/com/NhacCu/item/pencil_24.png")));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSua.setBounds(308, 283, 95, 31);
		panel_3.add(btnSua);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Xoa();
			}
		});
		btnXoa.setIcon(new ImageIcon(Admin_SanPham.class.getResource("/com/NhacCu/item/remove_24.png")));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoa.setBounds(613, 281, 95, 31);
		panel_3.add(btnXoa);

		JButton btnReload = new JButton("Reload");
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reload();
			}
		});
		btnReload.setIcon(new ImageIcon(Admin_SanPham.class.getResource("/com/NhacCu/item/refresh_24.png")));
		btnReload.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReload.setBounds(908, 278, 124, 31);
		panel_3.add(btnReload);

		JLabel lblThongBaoLoi = new JLabel("");
		lblThongBaoLoi.setForeground(Color.RED);
		lblThongBaoLoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThongBaoLoi.setBounds(97, 168, 327, 27);
		panel_3.add(lblThongBaoLoi);

		JButton btnAddImg = new JButton("Chọn ảnh");
		btnAddImg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addImage();
			}
		});
		btnAddImg.setIcon(new ImageIcon(Admin_SanPham.class.getResource("/com/NhacCu/item/add-image_16.png")));
		btnAddImg.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAddImg.setBounds(170, 224, 146, 31);
		panel_3.add(btnAddImg);

		lblImg = new JLabel("Hình Ảnh");
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblImg.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblImg.setBounds(713, 176, 131, 82);
		panel_3.add(lblImg);
	}

	private void initTable(final ArrayList<SanPhamDTO> list, final ArrayList<LoaiDTO> listLoai,
			final ArrayList<NhaSanXuatDTO> listNSX) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã Sản Phẩm");
		model.addColumn("Mã Loại");
		model.addColumn("Tên Sản Phẩm");
		model.addColumn("Số Lượng");
		model.addColumn("Giá");
		model.addColumn("Nhà Sản Xuất");
		model.addColumn("Ảnh");
		model.addColumn("Mô tả");

		for (SanPhamDTO sp : list) {
			model.addRow(new Object[] { sp.getMaSanPham(), sp.getMaLoai(), sp.getTenSanPham(), sp.getSoLuong(),
					sp.getGia(), sp.getMaNSX(), sp.getImage(), sp.getGhiChu() });
		}

		this.table.setModel(model);

		table.setAutoCreateRowSorter(true);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int index = table.getSelectedRow();
				textFieldMaSP.setText((String) table.getValueAt(index, 0));
				textFieldMaSP.setEditable(false);
				textFieldMaSP.setEnabled(false);
				String selectedMaLoai = String.valueOf(table.getValueAt(index, 1));
				int count = 0;
				for (LoaiDTO loai : listLoai) {
					if (selectedMaLoai.equals(loai.getMaLoai())) {
						comboBoxMaLoai.setSelectedIndex(count);
						break;
					}
					count++;
				}
				textFieldTenSP.setText(String.valueOf(table.getValueAt(index, 2)));
				textFieldSoLuong.setText(String.valueOf(table.getValueAt(index, 3)));
				textFieldGia.setText(String.valueOf(table.getValueAt(index, 4)));
				String selectedNSX = String.valueOf(table.getValueAt(index, 5));
				int count1 = 0;
				for (NhaSanXuatDTO nsx : listNSX) {
					if (selectedNSX.equals(nsx.getMaNSX())) {
						comboBoxNSX.setSelectedIndex(count1);
						break;
					}
					count1++;
				}
				lblImg.setName(String.valueOf(table.getValueAt(index, 6)));
				lblImg.setIcon(setIC(String.valueOf(table.getValueAt(index, 6))));
				textAreaMoTa.setText(String.valueOf(table.getValueAt(index, 7))); // Set text for textAreaMoTa
			}
		});
	}

	public void setcomboBoxMaLoai(ArrayList<LoaiDTO> listLoai) {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		for (LoaiDTO loai : listLoai) {
			model.addElement(loai.getMaLoai() + "   " + loai.getTenLoai());
		}
		comboBoxMaLoai.setModel(model);
	}

	public void setcomboBoxNSX(ArrayList<NhaSanXuatDTO> listNSX) {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		for (NhaSanXuatDTO nsx : listNSX) {
			model.addElement(nsx.getMaNSX() + "   " + nsx.getTenNSX());
		}
		comboBoxNSX.setModel(model);
	}

	private void themSanPham() {
		if (KiemTraTrong() && !spBUS.checkMaSP(textFieldMaSP.getText())) {
			String loai = (String) comboBoxMaLoai.getSelectedItem();
			String[] maLoai = loai.split(" ");
			String nsx = (String) comboBoxNSX.getSelectedItem();
			String[] maNSX = nsx.split(" ");

			// Kiểm tra định dạng số cho Số lượng và Giá
			try {
				int soLuong = Integer.parseInt(textFieldSoLuong.getText());
				int gia = Integer.parseInt(textFieldGia.getText());
				SanPhamDTO spDTO = new SanPhamDTO(textFieldMaSP.getText(), textFieldTenSP.getText(), soLuong, gia,
						maLoai[0], maNSX[0], lblImg.getName(), textAreaMoTa.getText());
				spBUS.addSP(spDTO);

				// Thông báo thành công và cập nhật bảng
				JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
				initTable(spBUS.getList(), loaiBUS.getList(), nsxBUS.getList());
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Số lượng và giá phải là số nguyên dương!", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
			}
			Reload();
		} else {
			JOptionPane.showMessageDialog(null, "Sản phẩm bị trùng", "Thông báo", JOptionPane.DEFAULT_OPTION);
		}
	}

	private boolean KiemTraTrong() {
		if (textFieldMaSP.getText() == null || textFieldMaSP.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "Mã sản phẩm không được trống!", "Thông báo",
					JOptionPane.DEFAULT_OPTION);
			textFieldMaSP.requestFocus();
			return false;
		}
		if (textFieldTenSP.getText() == null || textFieldTenSP.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "Tên sản phẩm không được trống!", "Thông báo",
					JOptionPane.DEFAULT_OPTION);
			textFieldTenSP.requestFocus();
			return false;
		}
		if (textFieldSoLuong.getText() == null || textFieldSoLuong.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "Số lượng không được trống!", "Thông báo", JOptionPane.DEFAULT_OPTION);
			textFieldSoLuong.requestFocus();
			return false;
		}
		if (textFieldGia.getText() == null || textFieldGia.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "Giá không được trống!", "Thông báo", JOptionPane.DEFAULT_OPTION);
			textFieldGia.requestFocus();
			return false;
		}
		return true;
	}

	private void Sửa() {
		if (KiemTraTrong()) {
			String loai = (String) comboBoxMaLoai.getSelectedItem();
			String[] maLoai = loai.split(" ");
			String nsx = (String) comboBoxNSX.getSelectedItem();
			String[] maNSX = nsx.split(" ");
			try {
				int soLuong = Integer.parseInt(textFieldSoLuong.getText());
				int gia = Integer.parseInt(textFieldGia.getText());

				SanPhamDTO spDTO = new SanPhamDTO(textFieldMaSP.getText(), textFieldTenSP.getText(), soLuong, gia,
						maLoai[0], maNSX[0], lblImg.getName(), textAreaMoTa.getText());
				spBUS.updateSP(spDTO);
				JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
				initTable(spBUS.getList(), loaiBUS.getList(), nsxBUS.getList());
				Reload();
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Số lượng và giá phải là số nguyên dương!", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	private void Xoa() {
		if (KiemTraTrong()) {
			spBUS.delete(textFieldMaSP.getText());
			JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
			initTable(spBUS.getList(), loaiBUS.getList(), nsxBUS.getList());
		}
	}

	private void Reload() {
		textFieldMaSP.setText("");
		textFieldMaSP.setEditable(true);
		textFieldMaSP.setEnabled(true);
		textFieldTenSP.setText("");
		textFieldSoLuong.setText("");
		textFieldGia.setText("");
		textAreaMoTa.setText("");
		lblImg.setName("Hình Ảnh");
		lblImg.setIcon(setIC(""));
		comboBoxMaLoai.setSelectedIndex(0);
		comboBoxNSX.setSelectedIndex(0);
		NhaSanXuatBUS nsxBUStest = new NhaSanXuatBUS();
		SanPhamBUS spBUStest = new SanPhamBUS();
		LoaiBUS loaiBUStest = new LoaiBUS();
		if (nsxBUStest.getList() == null)
			nsxBUStest.list();
		if (spBUStest.getList() == null)
			spBUStest.listSP();
		if (loaiBUStest.getList() == null)
			loaiBUStest.listLoai();
		setcomboBoxNSX(nsxBUStest.getList());
		setcomboBoxMaLoai(loaiBUStest.getList());
		initTable(spBUStest.getList(), loaiBUStest.getList(), nsxBUStest.getList());

	}

	public ImageIcon setIC(String path) {
		ImageIcon imgs = new ImageIcon(path);
		Image ig = imgs.getImage().getScaledInstance(lblImg.getWidth() + 15, lblImg.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ic = new ImageIcon(ig);
		return ic;
	}

	private void addImage() {
		try {
			JFileChooser chooser = new JFileChooser();
			int returnVal = chooser.showOpenDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				java.io.File file = chooser.getSelectedFile();
				String filePath = file.getPath();
				filePath = filePath.replace("\\", "\\\\");
				// Kiểm tra nếu tệp là hình ảnh hợp lệ
				if (filePath.toLowerCase().endsWith(".jpg") || filePath.toLowerCase().endsWith(".jpeg")
						|| filePath.toLowerCase().endsWith(".png") || filePath.toLowerCase().endsWith(".gif")
						|| filePath.toLowerCase().endsWith(".bmp")) {
					// Đặt hình ảnh vào lblImg
					lblImg.setIcon(setIC(filePath));

					lblImg.setName(filePath);
				} else {
					// Nếu tệp không phải là hình ảnh hợp lệ, hiển thị thông báo
					JOptionPane.showMessageDialog(this, "Chỉ chấp nhận các định dạng ảnh: JPG, JPEG, PNG, GIF, BMP",
							"Lỗi", JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
