package 课程管理系统;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AvgClass extends Menu {

	public static String title[] = { "Cno", "Cname", "avg(Grade)" };
	public static String sql = "select sc.Cno,course.Cname,avg(sc.Grade) from sc,course where course.Cno=sc.Cno group by(Cname)";// 要执行的语句
	JFrame jf = new JFrame("每门课程平均成绩");

	public AvgClass() throws Exception {
		f.setVisible(false);

		tabmo = new DefaultTableModel(inf, title);
		tab = new JTable(tabmo);
		JScrollPane js = new JScrollPane(tab);
		JPanel jp = new JPanel();

		jp.add(main);
		jp.add(display);
		jp.add(search);
		jp.add(searchClass);
		jp.add(average_btn1);
		jp.add(average_btn2);
		jp.add(modify);
		jp.add(adda);
		jp.add(quit);

		jf.add(jp, BorderLayout.NORTH);
		jf.add(js, BorderLayout.CENTER);
		jf.setSize(850, 502);
		jf.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width) / 4) + 50,
				((Toolkit.getDefaultToolkit().getScreenSize().height) / 4));
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	// 控件
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == main) {
				try {
					jf.dispose();
					new Menu();
				} catch (Exception ex) {
				}
			}
			if (e.getSource() == display) {
				try {
					this.show(sql, 0, "");
				} catch (Exception ex) {
				}
			}
			if (e.getSource() == search) {
				try {
					jf.dispose();
					new Search();
				} catch (Exception ex) {
				}
			}
			if (e.getSource() == searchClass) {
				try {
					jf.dispose();
					new SearchClass();
				} catch (Exception ex) {
				}
			}
			if (e.getSource() == average_btn1) {
				try {
					jf.dispose();
					new AvgClass();
				} catch (Exception ex) {
				}
			}
			if (e.getSource() == average_btn2) {
				try {
					jf.dispose();
					new AvgStudent();
				} catch (Exception ex) {
				}
			}
			if (e.getSource() == modify) {
				try {
					jf.dispose();
					new Modify();
				} catch (Exception ex) {
				}
			}
			if (e.getSource() == adda) {
				try {
					jf.dispose();
					new Adda();
				} catch (Exception ex) {
				}
			}
			if (e.getSource() == quit) {
				try {
					sta.close();
					con.close();
					System.exit(1);
				} catch (Exception ex) {
				}
			}
		}
		
	// 显示功能
	public void show(String sql, int p, String t) throws Exception {
		rs = sta.executeQuery(sql); // 存放结果集

		int i = 0;
		while (rs.next()) {
			String Cno = rs.getString("Cno");
			String Cname = rs.getString("Cname");
			float avg_Grade = rs.getFloat("avg(sc.Grade)");

			tabmo.setValueAt(Cno, i, 0);
			tabmo.setValueAt(Cname, i, 1);
			tabmo.setValueAt(avg_Grade, i, 2);

			i++;

			if (i >= tabmo.getRowCount()) {
				tabmo.addRow(new Object[] {});
			}
		}
	}

}

