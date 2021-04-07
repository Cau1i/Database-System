package 课程管理系统;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Adda extends Menu {

	private JFrame jf = new JFrame("添加新的课程！");

	private JLabel jl0 = new JLabel("请输入新添加课程信息：");
	private JLabel jl1 = new JLabel("Cno:");
	private JTextField jt1 = new JTextField();
	private JLabel jl2 = new JLabel("Cname:");
	private JTextField jt2 = new JTextField();
	private JLabel jl3 = new JLabel("Cpno:");
	private JTextField jt3 = new JTextField();
	private JLabel jl4 = new JLabel("Ccredit:");
	private JTextField jt4 = new JTextField();
	private JButton bt1 = new JButton("提交");
	private JButton bt2 = new JButton("退出");
	private JLabel xin = new JLabel("");

	private String sq = null;
	private int Cno;
	private String Cname = null;
	private String Cpno = null;
	private int Ccredit;

	public Adda() throws Exception {
		super();
		jl0.setBounds(10, 10, 170, 30);
		jl1.setBounds(10, 50, 60, 30);
		jt1.setBounds(80, 50, 180, 30);
		jl2.setBounds(10, 90, 60, 30);
		jt2.setBounds(80, 90, 180, 30);
		jl3.setBounds(10, 130, 60, 30);
		jt3.setBounds(80, 130, 180, 30);
		jl4.setBounds(10, 170, 60, 30);
		jt4.setBounds(80, 170, 180, 30);
		bt1.setBounds(20, 230, 60, 30);
		bt2.setBounds(90, 230, 60, 30);
		xin.setBounds(10, 260, 100, 30);
		jf.add(jl0);
		jf.add(jl1);
		jf.add(jt1);
		jf.add(jl2);
		jf.add(jt2);
		jf.add(jl3);
		jf.add(jt3);
		jf.add(jl4);
		jf.add(jt4);
		jf.add(bt1);
		jf.add(bt2);
		jf.add(xin);
		jf.setSize(300, 350);
		jf.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width) / 4) + 300,
				((Toolkit.getDefaultToolkit().getScreenSize().height) / 4 + 80));
		jf.setVisible(true);

		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == bt1) {
					if (jt1.getText().trim().equals("") || jt2.getText().trim().equals("")
							|| jt4.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "输入的信息不可以为空，请重新输入！", "错误提示！",
								JOptionPane.INFORMATION_MESSAGE);
						f.dispose();
						jf.dispose();
						try {
							new Adda();
						} catch (Exception ex) {
						}
					} else if (Integer.parseInt(jt1.getText()) < 0 || Integer.parseInt(jt4.getText()) < 0) {
						JOptionPane.showMessageDialog(null, "输入的数字不可以有负数，请重新输入！", "错误提示！",
								JOptionPane.INFORMATION_MESSAGE);
						f.dispose();
						jf.dispose();
						try {
							new Adda();
						} catch (Exception ex) {
						}
					} else {
						Cno = Integer.parseInt(jt1.getText().trim());
						Cname = jt2.getText().trim();
						// Cpno = Integer.parseInt(jt3.getText().trim());
						Cpno = jt3.getText().trim();
						System.out.println(Cpno);
						Ccredit = Integer.parseInt(jt4.getText().trim());
						
						if((Cpno).equals("")) {//Cpno为空
							sq = "insert into course(Cno,Cname,Cpno,Ccredit)" + " values ( "+ Cno + ",'" + Cname + "'," + null + "," + Ccredit + ")";
						}else {//Cpno不为空
							sq = "insert into course(Cno,Cname,Cpno,Ccredit)" + " values ( "+ Cno + ",'" + Cname + "'," + Cpno + "," + Ccredit + ")";
						}
						      
						try {
							jf.dispose();
							sta.executeUpdate(sq);
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

