package �γ̹���ϵͳ;

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

//��¼����
public class Sign {
	private JFrame frame = new JFrame("ѧ���ɼ�����ϵͳ");
	private JButton submit = new JButton("����");
	private JButton reset = new JButton("����");
	private JLabel nameLab = new JLabel("�û���:");
	private JLabel passLab = new JLabel("��	 ��:");
	private JLabel infoLab = new JLabel("�û���¼(root,java)");
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
							JOptionPane.showMessageDialog(null, "������ȷ����������ϵͳ��", "������ʾ��",
									JOptionPane.INFORMATION_MESSAGE);
							Thread.sleep(3000);
							frame.dispose();
							new Menu();
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					} else {
						try {
							JOptionPane.showMessageDialog(null, "�û������ڻ����������������д��", "������ʾ��",
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
					infoLab.setText("�û���¼(root,java)");
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
