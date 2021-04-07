package �γ̹���ϵͳ;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SearchClass extends Menu {

	public static String title[] = { "Sname", "Cname" };
	public static String sql = "select student.Sname,course.Cname from course,sc,student where course.Cno=sc.Cno and sc.Sno=student.Sno";// Ҫִ�е����
	JFrame jf = new JFrame("ÿ��ѧ����ѡ�޵Ŀγ�");

	public SearchClass() throws Exception {
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

	// �ؼ�
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

	// ��ʾ����
	public void show(String sql, int p, String t) throws Exception {
		rs = sta.executeQuery(sql); // ��Ž����

		int i = 0;
		while (rs.next()) {
			String Sname = rs.getString("Sname");
			String Cname = rs.getString("Cname");			

			tabmo.setValueAt(Sname, i, 0);
			tabmo.setValueAt(Cname, i, 1);
			
			i++;

			if (i >= tabmo.getRowCount()) {
				tabmo.addRow(new Object[] {});
			}
		}
	}

}
