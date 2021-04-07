package 课程管理系统;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Modify extends Menu {
	private JFrame jf = new JFrame("修改学生信息！");
	private JLabel jl0 = new JLabel("请输入信息：");
	private JLabel jl1 = new JLabel("对应学号:");
	private JTextField jt1 = new JTextField();
	private JLabel jl2 = new JLabel("姓  名:");
	private JTextField jt2 = new JTextField();
	private JButton bt1 = new JButton("提交");
	private JButton bt2 = new JButton("退出");
	private JLabel xin = new JLabel("");

	private String Sno = null;
	private String Sname = null;
	private String sq = null;

	public Modify() throws Exception {
		super();
		jl0.setBounds(10, 10, 120, 30);
		jl1.setBounds(10, 50, 60, 30);
		jt1.setBounds(80, 50, 180, 30);
		jl2.setBounds(10, 90, 60, 30);
		jt2.setBounds(80, 90, 180, 30);
		bt1.setBounds(20, 150, 60, 30);
		bt2.setBounds(90, 150, 60, 30);
		xin.setBounds(10, 300, 100, 30);
		jf.add(jl0);
		jf.add(jl1);
		jf.add(jt1);
		jf.add(jl2);
		jf.add(jt2);
		jf.add(bt1);
		jf.add(bt2);
		jf.add(xin);
		jf.setSize(300, 250);
		jf.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width) / 4) + 300,
				((Toolkit.getDefaultToolkit().getScreenSize().height) / 4 + 100));
		jf.setVisible(true);

		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == bt1) {
					if (jt1.getText().trim().equals("") || jt2.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "输入的信息不可以为空，请重新输入！", "错误提示！",
								JOptionPane.INFORMATION_MESSAGE);
						f.dispose();
						jf.dispose();
						try {
							new Modify();
						} catch (Exception ex) {
						}
					} else {
						Sno = jt1.getText().trim();
						Sname = jt2.getText().trim();
						sq = "update student set Sname='" + Sname + "' where Sno=" + Sno;
						try {
							jf.dispose();
							show(sql, 1, sq);
						} catch (Exception ex) {
						}
					}
				}
			}
		});
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == bt2) {
					jf.dispose();
				}
			}
		});
	}
}
