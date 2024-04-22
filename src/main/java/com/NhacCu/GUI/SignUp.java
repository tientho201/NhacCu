package com.NhacCu.GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.NhacCu.BUS.AccountBUS;
import com.NhacCu.BUS.UserBUS;
import java.awt.Color;
import com.NhacCu.DTO.AccountDTO;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

import com.NhacCu.DTO.*;

public class SignUp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField XacNhanMatKhauValue;
	private JTextField TenDangNhapValue;
	private JButton BtnDangNhap;
	private JButton    BtnDangKi;
	private JPasswordField MatKhauValue;
	private JLabel NotifiError;
	private AccountBUS accBUS = new AccountBUS();
	private UserBUS userBUS = new UserBUS();
	private JLabel lblMtKhu;
	private JLabel lblXcNhnMt;
	private JTextField textFieldHovaTen;
	private JTextField textFieldNgaySinh;
	private JTextField textFieldSDT;
	private JTextField textFieldDiaChi;
	private ButtonGroup buttonGroup;
	private JRadioButton rdbtnNu;
	private JRadioButton rdbtnNam;
	private JLabel lblNewLabel;
	
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
					SignUp frame = new SignUp();
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
	public SignUp() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 579);
		setTitle("Đăng Kí");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel TenDangNhap = new JLabel("Tên Đăng Nhập");
		TenDangNhap.setForeground(new Color(255, 255, 255));
		TenDangNhap.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		TenDangNhap.setBounds(10, 148, 189, 26);
		contentPane.add(TenDangNhap);

		TenDangNhapValue = new JTextField();
		TenDangNhapValue.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		TenDangNhapValue.setBounds(195, 148, 176, 26);
		contentPane.add(TenDangNhapValue);
		TenDangNhapValue.setToolTipText("Điền tên đăng nhập");
		TenDangNhapValue.setColumns(10);

		BtnDangNhap = new JButton("Đăng Nhập");
		BtnDangNhap.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		BtnDangNhap.setBounds(566, 440, 189, 51);
		BtnDangNhap.setIcon(new ImageIcon(getClass().getResource("/com/NhacCu/item/Chuyen_Huong.png")));
		BtnDangNhap.setToolTipText("Chuyển hướng sang đăng nhập");
		contentPane.add(BtnDangNhap);

	    BtnDangKi = new JButton("Đăng Kí");
		BtnDangKi.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		BtnDangKi.setBounds(87, 440, 189, 51);
		BtnDangKi.setIcon(new ImageIcon(getClass().getResource("/com/NhacCu/item/icon-login.jpg")));
		BtnDangKi.setToolTipText("Đăng kí vào hệ thống");
		contentPane.add(BtnDangKi);

		JLabel lblNewLabel_2 = new JLabel("Đăng Kí");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 37));
		lblNewLabel_2.setBounds(246, 2, 420, 147);

		contentPane.add(lblNewLabel_2);

		MatKhauValue = new JPasswordField();
		MatKhauValue.setBounds(195, 203, 176, 26);
		MatKhauValue.setToolTipText("Điền mật khẩu");
		contentPane.add(MatKhauValue);

		XacNhanMatKhauValue = new JPasswordField();
		XacNhanMatKhauValue.setBounds(195, 258, 176, 26);
		XacNhanMatKhauValue.setToolTipText("Điền xác nhận mật khẩu");
		contentPane.add(XacNhanMatKhauValue);

		NotifiError = new JLabel("");
		NotifiError.setForeground(new Color(255, 0, 0));
		NotifiError.setFont(new Font("Tahoma", Font.PLAIN, 17));
		NotifiError.setBounds(273, 390, 523, 40);
		contentPane.add(NotifiError);
		
		lblMtKhu = new JLabel("Mật Khẩu");
		lblMtKhu.setForeground(new Color(255, 255, 255));
		lblMtKhu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMtKhu.setBounds(10, 207, 189, 22);
		contentPane.add(lblMtKhu);
		
		lblXcNhnMt = new JLabel("Xác Nhận Mật Khẩu");
		lblXcNhnMt.setForeground(new Color(255, 255, 255));
		lblXcNhnMt.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblXcNhnMt.setBounds(10, 269, 189, 22);
		contentPane.add(lblXcNhnMt);
		
		buttonGroup = new ButtonGroup();
		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setBackground(UIManager.getColor("CheckBox.background"));
		rdbtnNam.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		rdbtnNam.setSelected(true);
		rdbtnNam.setBounds(195, 325, 103, 21);
		buttonGroup.add(rdbtnNam);
		contentPane.add(rdbtnNam);
		
		 rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		rdbtnNu.setBounds(310, 325, 103, 21);
		buttonGroup.add(rdbtnNu);
		contentPane.add(rdbtnNu);
		
		JLabel lblGiiTnh = new JLabel("Giới Tính");
		lblGiiTnh.setForeground(new Color(255, 255, 255));
		lblGiiTnh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblGiiTnh.setBounds(10, 324, 189, 22);
		contentPane.add(lblGiiTnh);
		
		JLabel lblHVTn = new JLabel("Họ và Tên");
		lblHVTn.setForeground(new Color(255, 255, 255));
		lblHVTn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblHVTn.setBounds(432, 148, 189, 26);
		contentPane.add(lblHVTn);
		
		JLabel lblNgySinh = new JLabel("Ngày Sinh");
		lblNgySinh.setForeground(new Color(255, 255, 255));
		lblNgySinh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNgySinh.setBounds(432, 203, 189, 26);
		contentPane.add(lblNgySinh);
		
		JLabel lblHVTn_1_1 = new JLabel("Số Điện Thoại");
		lblHVTn_1_1.setForeground(new Color(255, 255, 255));
		lblHVTn_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblHVTn_1_1.setBounds(432, 258, 189, 26);
		contentPane.add(lblHVTn_1_1);
		
		JLabel lblHVTn_1_1_1 = new JLabel("Địa Chỉ");
		lblHVTn_1_1_1.setForeground(new Color(255, 255, 255));
		lblHVTn_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblHVTn_1_1_1.setBounds(432, 320, 189, 26);
		contentPane.add(lblHVTn_1_1_1);
		
		textFieldHovaTen = new JTextField();
		textFieldHovaTen.setToolTipText("Điền tên đăng nhập");
		textFieldHovaTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldHovaTen.setColumns(10);
		textFieldHovaTen.setBounds(594, 148, 176, 26);
		contentPane.add(textFieldHovaTen);
		
		textFieldNgaySinh = new JTextField();
		textFieldNgaySinh.setToolTipText("Điền tên đăng nhập");
		textFieldNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldNgaySinh.setColumns(10);
		textFieldNgaySinh.setBounds(594, 203, 176, 26);
		contentPane.add(textFieldNgaySinh);
		
		textFieldSDT = new JTextField();
		textFieldSDT.setToolTipText("Điền tên đăng nhập");
		textFieldSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldSDT.setColumns(10);
		textFieldSDT.setBounds(594, 261, 176, 26);
		contentPane.add(textFieldSDT);
		
		textFieldDiaChi = new JTextField();
		textFieldDiaChi.setToolTipText("Điền tên đăng nhập");
		textFieldDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFieldDiaChi.setColumns(10);
		textFieldDiaChi.setBounds(594, 320, 176, 26);
		contentPane.add(textFieldDiaChi);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SignUp.class.getResource("/com/NhacCu/item/Anh_Nen.jpg")));
		lblNewLabel.setBounds(0, 2, 888, 540);
		contentPane.add(lblNewLabel);

		BtnDangNhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Login login = new Login();
				login.setVisible(true);
				setVisible(false);
			}
		});
		TenDangNhapValue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MatKhauValue.requestFocusInWindow(); // Di chuyển focus đến textField2
			}
		});
		MatKhauValue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				XacNhanMatKhauValue.requestFocusInWindow(); // Di chuyển focus đến textField2
			}
		});
		BtnDangKi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Lấy dữ liệu từ các trường nhập liệu
				BtnSignUp();
			}
		});
        // Thiết lập phím tắt Enter cho nút "Enter Button"
		BtnDangKi.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		BtnDangKi.getActionMap().put("enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Thực hiện hành động tương tự khi nhấn nút "Enter Button"
            	BtnSignUp();
            }
        });
	}
	public void BtnSignUp() {
		String tenDangNhapValue = TenDangNhapValue.getText();
		String matKhauValue = new String(MatKhauValue.getPassword());
		String xacNhanMatKhauValue = new String(XacNhanMatKhauValue.getPassword());
		  if (accBUS.getList() == null)
		        accBUS.listAcc();
		    if(userBUS.getList() == null) {
		    	userBUS.listUs();
		    }
		
			if (tenDangNhapValue.isEmpty()) {
				System.out.println("Vui lòng nhập tên đăng nhập!");
				NotifiError.setText("Vui lòng nhập tên đăng nhập!");
			} else {
				if(matKhauValue.isEmpty()) {
					System.out.println("Vui lòng nhập mật khẩu!");
					NotifiError.setText("Vui lòng nhập mật khẩu!");
				}else {
					if(xacNhanMatKhauValue.isEmpty()){
						System.out.println("Vui lòng nhập xác nhận mật khẩu!");
						NotifiError.setText("Vui lòng nhập xác nhận mật khẩu!");
					}else {
						if(matKhauValue.equals(xacNhanMatKhauValue)== false) {
							System.out.println("Xác nhận mật khẩu không giống nhau!");
							NotifiError.setText("Xác nhận mật khẩu không giống nhau!");
						}else {
							
							if(!accBUS.checkTenDangNhap(tenDangNhapValue)) {
								System.out.println("");
								NotifiError.setText("");
								AccountDTO accDTO = new AccountDTO(tenDangNhapValue,matKhauValue,"User" , 1);
								accBUS.addAcc(accDTO);
								if (rdbtnNam.isSelected()) {
									UserDTO userDTO = new UserDTO(userBUS.increaseMaUser(),tenDangNhapValue,textFieldHovaTen.getText(), "Nam" , textFieldNgaySinh.getText() , textFieldSDT.getText() , textFieldDiaChi.getText(),"" , 1);
									userBUS.addUs(userDTO);
								}else {
									UserDTO userDTO = new UserDTO(userBUS.increaseMaUser(),tenDangNhapValue,textFieldHovaTen.getText(), "Nữ" , textFieldNgaySinh.getText() , textFieldSDT.getText() , textFieldDiaChi.getText() ,"", 1);
									userBUS.addUs(userDTO);
								}
								JFrame frame = new JFrame("JOptionPane showMessageDialog");
								JOptionPane.showMessageDialog(frame, "Xin chào " + tenDangNhapValue + " !", "",
										JOptionPane.INFORMATION_MESSAGE);
								
								this.hide();
								
							}else {
								System.out.println("Tên đăng nhập đã tồn tại!");
								NotifiError.setText("Tên đăng nhập đã tồn tại!");
							}
						}
					}
				}
			}
	}
}
