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

import com.NhacCu.BUS.NhaSanXuatBUS;
import com.NhacCu.DTO.NhaSanXuatDTO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_NSX extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldMaNSX;
	private JTextField textFieldTenNSX;
	private JTable table;
	private NhaSanXuatBUS nsxBUS = new NhaSanXuatBUS();
	/**
	 * Create the panel.
	 */
	public Admin_NSX() {
		initComponents();

		if (nsxBUS.getList() == null)
			nsxBUS.list();
		initTable(nsxBUS.getList());
	}

	public void initComponents(){
		setBounds(0, 0, 1117, 685);
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nhà Sản Xuất");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel_1.setBounds(10, 10, 1097, 60);
		add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setLayout(null);
		panel_2.setBounds(10, 80, 1097, 332);
		add(panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1077, 312);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"M\u00E3 Nh\u00E0 S\u1EA3n Xu\u1EA5t", "T\u00EAn Nh\u00E0 S\u1EA3n Xu\u1EA5t"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setLayout(null);
		panel_3.setBounds(10, 422, 1097, 172);
		add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Mã Nhà Sản Xuất");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(140, 30, 173, 30);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tên Sản Xuất");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(140, 91, 173, 30);
		panel_3.add(lblNewLabel_2_1);
		
		textFieldMaNSX = new JTextField();
		textFieldMaNSX.setColumns(10);
		textFieldMaNSX.setBounds(378, 33, 210, 30);
		panel_3.add(textFieldMaNSX);
		
		textFieldTenNSX = new JTextField();
		textFieldTenNSX.setColumns(10);
		textFieldTenNSX.setBounds(378, 94, 210, 30);
		panel_3.add(textFieldTenNSX);
		
		JLabel lblThongBao = new JLabel("");
		lblThongBao.setForeground(Color.RED);
		lblThongBao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblThongBao.setBounds(206, 131, 305, 31);
		panel_3.add(lblThongBao);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setLayout(null);
		panel_4.setBounds(10, 604, 1097, 51);
		add(panel_4);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				them();
			}
		});
		btnThem.setIcon(new ImageIcon(Admin_NSX.class.getResource("/com/NhacCu/item/plus_24.png")));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThem.setBounds(27, 10, 103, 31);
		panel_4.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sua();
			}
		});
		btnSua.setIcon(new ImageIcon(Admin_NSX.class.getResource("/com/NhacCu/item/pencil_24.png")));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSua.setBounds(326, 10, 103, 31);
		panel_4.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoa();
			}
		});
		btnXoa.setIcon(new ImageIcon(Admin_NSX.class.getResource("/com/NhacCu/item/remove_24.png")));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoa.setBounds(698, 10, 103, 31);
		panel_4.add(btnXoa);
		
		JButton btnReload = new JButton("Reload");
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reload();
			}
		});
		btnReload.setIcon(new ImageIcon(Admin_NSX.class.getResource("/com/NhacCu/item/refresh_24.png")));
		btnReload.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReload.setBounds(964, 10, 123, 31);
		panel_4.add(btnReload);
	}
	public void them() {
		if (kiemtraRong()) {
			if (!nsxBUS.checkMaNSX(textFieldMaNSX.getText())) {
				NhaSanXuatDTO nsxDTO = new NhaSanXuatDTO(textFieldMaNSX.getText(), textFieldTenNSX.getText());
				nsxBUS.add(nsxDTO);
				JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
				initTable(nsxBUS.getList());
				reload();

			} else {
				JOptionPane.showMessageDialog(null, "NSX bị trùng", "Thông báo", JOptionPane.DEFAULT_OPTION);

			}
		}
	}

	public void sua() {
		if (kiemtraRong()) {
			NhaSanXuatDTO nsxDTO = new NhaSanXuatDTO(textFieldMaNSX.getText(), textFieldTenNSX.getText());
			nsxBUS.update(nsxDTO);
			JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
			initTable(nsxBUS.getList());
			reload();
		}
	}

	public void xoa() {
		if (kiemtraRong()) {
			nsxBUS.delete(textFieldMaNSX.getText());
			JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
			initTable(nsxBUS.getList());
			reload();
		}
	}

	public void reload() {
		textFieldMaNSX.setText("");
		textFieldMaNSX.setEditable(true);
		textFieldMaNSX.setEnabled(true);
		textFieldTenNSX.setText("");
	}

	public void initTable(ArrayList<NhaSanXuatDTO> list) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã NSX");
		model.addColumn("Tên NSX");

		// Đổ dữ liệu vào DefaultTableModel
		for (NhaSanXuatDTO nsx : list) {
			model.addRow(new Object[] { nsx.getMaNSX(), nsx.getTenNSX() });

		}

		// Sử dụng DefaultTableModel để tạo JTable
		this.table.setModel(model);
		// Cho phép table sắp xếp
		table.setAutoCreateRowSorter(true);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int index = table.getSelectedRow();
				textFieldMaNSX.setText((String) table.getValueAt(index, 0));
				textFieldMaNSX.setEditable(false);
				textFieldMaNSX.setEnabled(false);
				textFieldTenNSX.setText((String) table.getValueAt(index, 1));
			}
		});
	}

	public boolean kiemtraRong() {
		if (textFieldMaNSX.getText() == null || textFieldMaNSX.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Mã NSX không được trống!", "Thông báo",
					JOptionPane.DEFAULT_OPTION);
			textFieldMaNSX.requestFocus();
			return false;
		}
		if (textFieldTenNSX.getText() == null || textFieldTenNSX.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Tên NSX không được trống!", "Thông báo",
					JOptionPane.DEFAULT_OPTION);
			textFieldTenNSX.requestFocus();
			return false;
		}

		return true;
	}
}
