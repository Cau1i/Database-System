package �γ̹���ϵͳ;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Search extends Menu {
	private JFrame jf = new JFrame("����ѧ����Ϣ��");
	private JButton jb = new JButton("��ѯ");
	private JLabel jl = new JLabel("��������Ҫ��ѯѧ�����ա�������ѧ�ţ�");
	private JTextField jt = new JTextField();
	private String sql1 = null;
	private JLabel xin = new JLabel("");
	
	public Search() throws Exception {
		super();
		Font fo = new Font("Serief", Font.BOLD, 13);
		jl.setFont(fo);
		jl.setBounds(10, 75, 250, 20);
		jt.setBounds(15, 15, 150, 30);
		jb.setBounds(175, 15, 60, 30);
		xin.setBounds(10, 250, 100, 30);
		jf.add(jl);
		jf.add(jt);
		jf.add(jb);
		jf.add(xin);
		jf.setSize(280, 150);
		jf.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width) / 4) + 330,
				((Toolkit.getDefaultToolkit().getScreenSize().height) / 4 + 150));
		jf.setVisible(true);
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == jb) {
					if (jt.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "�������Ϣ������Ϊ�գ����������룡", "������ʾ��",
								JOptionPane.INFORMATION_MESSAGE);
						f.dispose();
						jf.dispose();
						try {
							new Search();
						} catch (Exception ex) {
						}
					} else {
						try {
							int t = Integer.parseInt(jt.getText().trim());
							sql1 = "select * from student where Sno = '" + t + "' ";
							jf.dispose();
							try {
								show(sql1, 0, "��");
								if (tabmo.getValueAt(0, 0).equals("")) {
									JOptionPane.showMessageDialog(null, "����ҵ�ѧ����Ϣ���������ݿ⣬���������룡", "��ʾ��",
											JOptionPane.INFORMATION_MESSAGE);
									f.dispose();
									new Search();
								}
							} catch (Exception ex) {
							}
						} catch (Exception ex) {
							String s = jt.getText().trim();
							sql1 = "select * from student where Sname regexp '^" + s + "' ";
							jf.dispose();
							try {
								show(sql1, 0, "��");
								if (tabmo.getValueAt(0, 0).equals("")) {
									JOptionPane.showMessageDialog(null, "����ҵ�ѧ����Ϣ���������ݿ⣬���������룡", "��ʾ��",
											JOptionPane.INFORMATION_MESSAGE);
									f.dispose();
									new Search();
								}
							} catch (Exception ex1) {
							}
						}
					}
				}
			}
		});
	}
}

