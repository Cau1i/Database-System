package 课程管理系统;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//登录界面
public class Sign {
	private JFrame frame = new JFrame("学生成绩管理系统");
	private JButton submit = new JButton("登入");
	private JButton reset = new JButton("重置");
	private JLabel nameLab = new JLabel("用户名:");
	private JLabel passLab = new JLabel("密	 码:");
	private JLabel infoLab = new JLabel("用户登录(root,java)");
	private JTextField nameText = new JTextField(10);
	private JPasswordField passText = new JPasswordField();

	public Sign() throws Exception {
		Font fnt = new Font("Serief", Font.ITALIC + Font.BOLD, 12);
		infoLab.setFont(fnt);

		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == submit) {
					String tname = nameText.getText();
					String tpass = new String(passText.getPassword());
					LoginCheck log = new LoginCheck(tname, tpass);
					if (log.validate()) {
						try {
							JOptionPane.showMessageDialog(null, "密码正确，即将进入系统！", "登入提示！",
									JOptionPane.INFORMATION_MESSAGE);
							Thread.sleep(3000);
							frame.dispose();
							new Menu();
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					} else {
						try {
							JOptionPane.showMessageDialog(null, "用户不存在或密码错误，请重新填写！", "登入提示！",
									JOptionPane.INFORMATION_MESSAGE);
							frame.dispose();
							new Sign();
						} catch (Exception ex) {
						}
					}
				}
			}
		});

		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == reset) {
					nameText.setText("");
					passText.setText("");
					infoLab.setText("用户登录(root,java)");
				}
			}
		});

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});
		frame.setLayout(null);
		nameLab.setBounds(5, 5, 60, 20);
		passLab.setBounds(5, 30, 60, 20);
		infoLab.setBounds(5, 65, 220, 30);
		nameText.setBounds(65, 5, 100, 20);
		passText.setBounds(65, 30, 100, 20);
		submit.setBounds(170, 5, 60, 20);
		reset.setBounds(170, 30, 60, 20);
		frame.add(nameLab);
		frame.add(passLab);
		frame.add(infoLab);
		frame.add(nameText);
		frame.add(passText);
		frame.add(submit);
		frame.add(reset);
		frame.setSize(280, 130);
		frame.setBackground(Color.WHITE);
		frame.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width) / 2) - 200,
				((Toolkit.getDefaultToolkit().getScreenSize().height) / 2) - 100);
		frame.setVisible(true);

	}
}
