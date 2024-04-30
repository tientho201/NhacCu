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
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.NhacCu.BUS.LoaiBUS;
import com.NhacCu.DTO.LoaiDTO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_PhanLoai extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldMaLoai;
	private JTextField textFieldTenLoai;
	private JTable table;
	private LoaiBUS loaiBUS = new LoaiBUS();
	/**
	 * Create the panel.
	 */
	public Admin_PhanLoai() {
		initComponents();
		if (loaiBUS.getList() == null)
			loaiBUS.listLoai();
		initTable(loaiBUS.getList());
	}

	public void initComponents() {
		setBounds(0, 0, 1117, 685);
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Phân Loại");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_1.setBounds(10, 10, 1097, 79);
		add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 99, 1097, 274);
		add(panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1077, 254);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"M\u00E3 Lo\u1EA1i", "T\u00EAn Lo\u1EA1i"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 383, 1097, 169);
		add(panel_3);
		
		JLabel lblMaLoai = new JLabel("Mã Loại");
		lblMaLoai.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMaLoai.setBounds(159, 23, 100, 28);
		panel_3.add(lblMaLoai);
		
		textFieldMaLoai = new JTextField();
		textFieldMaLoai.setColumns(10);
		textFieldMaLoai.setBounds(376, 26, 221, 30);
		panel_3.add(textFieldMaLoai);
		
		JLabel lblTenLoai = new JLabel("Tên Loại");
		lblTenLoai.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTenLoai.setBounds(164, 93, 95, 28);
		panel_3.add(lblTenLoai);
		
		textFieldTenLoai = new JTextField();
		textFieldTenLoai.setColumns(10);
		textFieldTenLoai.setBounds(376, 97, 221, 28);
		panel_3.add(textFieldTenLoai);
		
		JLabel lblThongBao = new JLabel("");
		lblThongBao.setBounds(151, 131, 296, 28);
		panel_3.add(lblThongBao);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(10, 592, 1097, 58);
		add(panel_4);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				them();
			}
		});
		btnThem.setIcon(new ImageIcon(Admin_PhanLoai.class.getResource("/com/NhacCu/item/plus_24.png")));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThem.setBounds(10, 10, 111, 38);
		panel_4.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sua();
			}
		});
		btnSua.setIcon(new ImageIcon(Admin_PhanLoai.class.getResource("/com/NhacCu/item/pencil_24.png")));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSua.setBounds(333, 10, 111, 38);
		panel_4.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoa();
			}
		});
		btnXoa.setIcon(new ImageIcon(Admin_PhanLoai.class.getResource("/com/NhacCu/item/remove_24.png")));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoa.setBounds(684, 10, 111, 38);
		panel_4.add(btnXoa);
		
		JButton btnReload = new JButton("Reload");
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reload();
			}
		});
		btnReload.setIcon(new ImageIcon(Admin_PhanLoai.class.getResource("/com/NhacCu/item/refresh_24.png")));
		btnReload.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReload.setBounds(956, 10, 119, 38);
		panel_4.add(btnReload);
	}
	public void them() {
		if (kiemtraRong()) {
			if (!loaiBUS.checkMaLoai(textFieldMaLoai.getText())) {
				LoaiDTO loaiDTO = new LoaiDTO(textFieldMaLoai.getText(), textFieldTenLoai.getText());
				loaiBUS.add(loaiDTO);
				JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
				initTable(loaiBUS.getList());
				reload();

			} else {
				JOptionPane.showMessageDialog(null, "Loại bị trùng", "Thông báo", JOptionPane.DEFAULT_OPTION);

			}
		}
	}

	public void sua() {
		if (kiemtraRong()) {
			LoaiDTO loaiDTO = new LoaiDTO(textFieldMaLoai.getText(), textFieldTenLoai.getText());
			loaiBUS.update(loaiDTO);
			JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
			initTable(loaiBUS.getList());
			reload();
		}
	}

	public void xoa() {
		if (kiemtraRong()) {
			loaiBUS.delete(textFieldMaLoai.getText());
			JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
			initTable(loaiBUS.getList());
			reload();
		}
	}

	public void reload() {
		textFieldMaLoai.setText("");
		textFieldMaLoai.setEditable(true);
		textFieldMaLoai.setEnabled(true);
		textFieldTenLoai.setText("");
	}

	public void initTable(ArrayList<LoaiDTO> listLoai) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã Loại");
		model.addColumn("Tên Loại");

		// Đổ dữ liệu vào DefaultTableModel
		for (LoaiDTO loai : listLoai) {
			model.addRow(new Object[] { loai.getMaLoai(), loai.getTenLoai() });

		}

		// Sử dụng DefaultTableModel để tạo JTable
		this.table.setModel(model);
		// Cho phép table sắp xếp
		table.setAutoCreateRowSorter(true);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int index = table.getSelectedRow();
				textFieldMaLoai.setText((String) table.getValueAt(index, 0));
				textFieldMaLoai.setEditable(false);
				textFieldMaLoai.setEnabled(false);
				textFieldTenLoai.setText((String) table.getValueAt(index, 1));
			}
		});
	}

	public boolean kiemtraRong() {
		if (textFieldMaLoai.getText() == null || textFieldMaLoai.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Mã Loại không được trống!", "Thông báo",
					JOptionPane.DEFAULT_OPTION);
			textFieldMaLoai.requestFocus();
			return false;
		}
		if (textFieldTenLoai.getText() == null || textFieldTenLoai.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Tên Loại không được trống!", "Thông báo",
					JOptionPane.DEFAULT_OPTION);
			textFieldTenLoai.requestFocus();
			return false;
		}

		return true;
	}
}
