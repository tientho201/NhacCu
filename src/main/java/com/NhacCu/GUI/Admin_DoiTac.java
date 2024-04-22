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
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.NhacCu.BUS.NhaCungCapBUS;
import com.NhacCu.BUS.SanPhamBUS;
import com.NhacCu.DTO.NhaCungCapDTO;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_DoiTac extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldMaNCC;
	private JTextField textFieldTenNCC;
	private JTextField textFieldDiaChiNCC;
	private JTextField textFieldSDTNCC;
	private JTable table;
	private NhaCungCapBUS NCCBUS = new NhaCungCapBUS();
	private SanPhamBUS spBUS = new SanPhamBUS();
	private JTextArea textAreaMoTa;
	private JLabel lblThongBao;
	/**
	 * Create the panel.
	 */
	public Admin_DoiTac() {
		initComponents();
		if (NCCBUS.getList() == null) {
			NCCBUS.listNCC();
		}
		
		if (spBUS.getList() == null)
			spBUS.listSP();
		initTable(NCCBUS.getList());
	}

	public void initComponents() {
		setBounds(0, 0, 1117, 685);
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nhà Cung Cấp");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblNewLabel_1.setBounds(10, 10, 1097, 61);
		add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 82, 619, 502);
		add(panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 599, 482);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 Nh\u00E0 Cung C\u1EA5p", "T\u00EAn Nh\u00E0 Cung C\u1EA5p", "\u0110\u1ECBa Ch\u1EC9", "S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i", "M\u00F4 T\u1EA3"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(661, 81, 413, 503);
		add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Mã NCC");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 22, 55, 28);
		panel_3.add(lblNewLabel_2);
		
		textFieldMaNCC = new JTextField();
		textFieldMaNCC.setColumns(10);
		textFieldMaNCC.setBounds(148, 24, 243, 28);
		panel_3.add(textFieldMaNCC);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tên NCC");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(10, 113, 95, 28);
		panel_3.add(lblNewLabel_2_1);
		
		textFieldTenNCC = new JTextField();
		textFieldTenNCC.setColumns(10);
		textFieldTenNCC.setBounds(148, 115, 243, 28);
		panel_3.add(textFieldTenNCC);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Địa Chỉ NCC");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_1.setBounds(10, 209, 95, 28);
		panel_3.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("SĐT NCC");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_1_1.setBounds(10, 304, 95, 28);
		panel_3.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Mô tả");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_1_1_1_1.setBounds(10, 377, 95, 28);
		panel_3.add(lblNewLabel_2_1_1_1_1);
		
		textFieldDiaChiNCC = new JTextField();
		textFieldDiaChiNCC.setColumns(10);
		textFieldDiaChiNCC.setBounds(148, 211, 243, 28);
		panel_3.add(textFieldDiaChiNCC);
		
		textFieldSDTNCC = new JTextField();
		textFieldSDTNCC.setColumns(10);
		textFieldSDTNCC.setBounds(148, 306, 243, 28);
		panel_3.add(textFieldSDTNCC);
		
		JScrollPane scrollPane1 = new JScrollPane((Component) null);
		scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane1.setAutoscrolls(true);
		scrollPane1.setBounds(148, 381, 243, 79);
		panel_3.add(scrollPane1);
		
		 textAreaMoTa = new JTextArea();
		scrollPane1.setViewportView(textAreaMoTa);
		
		lblThongBao = new JLabel("");
		lblThongBao.setForeground(new Color(255, 0, 0));
		lblThongBao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThongBao.setBounds(28, 465, 375, 38);
		panel_3.add(lblThongBao);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(10, 600, 1064, 58);
		add(panel_4);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				them();
			}
		});
		btnThem.setIcon(new ImageIcon(Admin_DoiTac.class.getResource("/com/NhacCu/item/plus_24.png")));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThem.setBounds(10, 10, 111, 38);
		panel_4.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sua();
			}
		});
		btnSua.setIcon(new ImageIcon(Admin_DoiTac.class.getResource("/com/NhacCu/item/pencil_24.png")));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSua.setBounds(297, 10, 111, 38);
		panel_4.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoa();
			}
		});
		btnXoa.setIcon(new ImageIcon(Admin_DoiTac.class.getResource("/com/NhacCu/item/remove_24.png")));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoa.setBounds(647, 10, 111, 38);
		panel_4.add(btnXoa);
		
		JButton btnReload = new JButton("Reload");
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reload();
			}
		});
		btnReload.setIcon(new ImageIcon(Admin_DoiTac.class.getResource("/com/NhacCu/item/refresh_24.png")));
		btnReload.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReload.setBounds(934, 10, 120, 38);
		panel_4.add(btnReload);
	}
	public void initTable(ArrayList<NhaCungCapDTO> listNCC) {
		// Tạo DefaultTableModel mới
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã NCC");
		model.addColumn("Tên NCC");
		model.addColumn("Địa Chỉ");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Mô Tả");

		// Đổ dữ liệu vào DefaultTableModel
		for (NhaCungCapDTO ncc : listNCC) {
			model.addRow(new Object[] { ncc.getMaNCC(), ncc.getTenNCC(), ncc.getDiaChiNCC(), ncc.getSDTNCC(),
					ncc.getGhiChu() });

		}

		// Sử dụng DefaultTableModel để tạo JTable
		this.table.setModel(model);

		// Cho phép table sắp xếp
		table.setAutoCreateRowSorter(true);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int index = table.getSelectedRow();
				textFieldMaNCC.setText((String) table.getValueAt(index, 0));
				textFieldMaNCC.setEditable(false);
				textFieldMaNCC.setEnabled(false);
				textFieldTenNCC.setText((String) table.getValueAt(index, 1));
				textFieldDiaChiNCC.setText((String) table.getValueAt(index, 2));
				textFieldSDTNCC.setText((String) table.getValueAt(index, 3));
				textAreaMoTa.setText((String) table.getValueAt(index, 4));

			}
		});
	}
	public boolean kiemtraRong() {
		if (textFieldMaNCC.getText() == null || textFieldMaNCC.getText().equals("")) {
			lblThongBao.setText("Mã Nhà Cung Cấp không được trống!");
			textFieldMaNCC.requestFocus();
			return false;
		}
		if (textFieldTenNCC.getText() == null || textFieldTenNCC.getText().equals("")) {
			lblThongBao.setText("Tên Nhà Cung Cấp không được trống!");
			textFieldTenNCC.requestFocus();
			return false;
		}
		if (textFieldDiaChiNCC.getText() == null || textFieldDiaChiNCC.getText().equals("")) {
			lblThongBao.setText("Địa Chỉ Nhà Cung Cấp không được trống!");
			textFieldTenNCC.requestFocus();
			return false;
		}
		if (textFieldSDTNCC.getText() == null || textFieldSDTNCC.getText().equals("")) {
			lblThongBao.setText("Số Điện Thoại không được trống!");
			textFieldSDTNCC.requestFocus();
			return false;
		}
		return true;
	}
	public void them() {
		if(kiemtraRong() ) {
			if ( !NCCBUS.checkMaNCC(textFieldMaNCC.getText())){
				NhaCungCapDTO nccDTO = new NhaCungCapDTO(textFieldMaNCC.getText() , textFieldTenNCC.getText() , textFieldDiaChiNCC.getText() , textFieldSDTNCC.getText() , textAreaMoTa.getText());
				NCCBUS.addSP(nccDTO);
				JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
				initTable( NCCBUS.getList());
				Reload();
				
			}else {

				JOptionPane.showMessageDialog(null, "Nhà Cung Cấp bị trùng", "Thông báo", JOptionPane.DEFAULT_OPTION);
			}
		}
	}
	public void sua() {
		if(kiemtraRong()) {
			NhaCungCapDTO nccDTO = new NhaCungCapDTO(textFieldMaNCC.getText() , textFieldTenNCC.getText() , textFieldDiaChiNCC.getText() , textFieldSDTNCC.getText() , textAreaMoTa.getText());
			NCCBUS.updateSP(nccDTO);
			JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
			initTable(NCCBUS.getList());
			Reload();
		}
	}
	public void xoa() {
		if (kiemtraRong()) {
			NCCBUS.delete(textFieldMaNCC.getText());
			JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
			initTable( NCCBUS.getList());
			Reload();
		}
	}
	public void Reload() {
		textFieldMaNCC.setText("");
		textFieldMaNCC.setEditable(true);
		textFieldMaNCC.setEnabled(true);
		textFieldDiaChiNCC.setText("");
		textFieldSDTNCC.setText("");
		textAreaMoTa.setText("");
		textFieldTenNCC.setText("");
		lblThongBao.setText("");
	}
}
