package �γ̹���ϵͳ;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.AbstractTableModel;
import java.sql.*;

import java.math.BigDecimal;

public class Menu extends AbstractTableModel implements ActionListener {

	// Mysql����
	public static final String Driver = "com.mysql.cj.jdbc.Driver";// ����������
	public static final String URL = "jdbc:mysql://localhost:3306/xs";// ���ݿ������ַ�����studentΪ���ݿ���
	public static final String NAME = "root";// ��¼��
	public static final String PASSWORD = "011023";// ����

	public static String sql = "select * from xs.Student";// Ҫִ�е����

	public String title[] = { "Sno", "Sname", "Ssex", "Sage", "Sdept" };
	public static Object inf[][] = { { "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" },
			{ "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" },
			{ "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" },
			{ "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" },
			{ "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" },
			{ "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" },
			{ "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" },
			{ "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" },
			{ "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" } };

	// ����
	JFrame f = new JFrame("ѧ���ɼ�����ϵͳ");
	// ��ӹ��ܰ�ť
	JButton main = new JButton("��ҳ");
	JButton display = new JButton("��ʾ");
	JButton search = new JButton("����");
	JButton searchClass = new JButton("ѡ��Ŀγ�");
	JButton average_btn1 = new JButton("�γ�ƽ���ɼ�");
	JButton average_btn2 = new JButton("ѧ��ƽ���ɼ�");
	JButton modify = new JButton("�޸�");
	JButton adda = new JButton("���");
	JButton quit = new JButton("�˳�");

	JTable tab = null;
	DefaultTableModel tabmo = null;
	Connection con = null; // ���ݿ�����
	Statement sta = null; // ���ݿ����
	ResultSet rs = null; // �����ѯ���

	public Menu() throws Exception {
		Class.forName(Driver); // ������������
		con = DriverManager.getConnection(URL, NAME, PASSWORD);
		sta = con.createStatement();

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

		f.add(jp, BorderLayout.NORTH);
		f.add(js, BorderLayout.CENTER);
		f.setSize(850, 502);
		f.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width) / 4) + 50,
				((Toolkit.getDefaultToolkit().getScreenSize().height) / 4));
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		main.addActionListener(this);
		display.addActionListener(this);
		search.addActionListener(this);
		searchClass.addActionListener(this);
		average_btn1.addActionListener(this);
		average_btn2.addActionListener(this);
		modify.addActionListener(this);
		adda.addActionListener(this);
		quit.addActionListener(this);
	}

	public int getColumnCount() {
		return title.length;
	}

	public int getRowCount() {
		return inf.length;
	}

	public Object getValueAt(int row, int col) {
		return inf[row][col];
	}

	public String getColumnName(int col) {
		return title[col];
	}

	public Class<?> getColumnClass(int col) {
		return this.getValueAt(0, col).getClass();
	}

	public boolean isCellEditable(int row, int col) {
		return false;
	}

	public void setValueAt(Object newv, int row, int col) {
		this.inf[row][col] = newv;
	}

	// �ؼ�
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == main) {
			try {
				f.dispose();
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
				f.dispose();
				new Search();
			} catch (Exception ex) {
			}
		}
		if (e.getSource() == searchClass) {
			try {
				f.dispose();
				new SearchClass();
			} catch (Exception ex) {
			}
		}
		if (e.getSource() == average_btn1) {
			try {
				f.dispose();
				new AvgClass();
			} catch (Exception ex) {
			}
		}
		if (e.getSource() == average_btn2) {
			try {
				f.dispose();
				new AvgStudent();
			} catch (Exception ex) {
			}
		}
		if (e.getSource() == modify) {
			try {
				f.dispose();
				new Modify();
			} catch (Exception ex) {
			}
		}
		if (e.getSource() == adda) {
			try {
				f.dispose();
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
		// p=0:ֻ��ʾ���ݣ�p=1��update��������ʾ
		// con=DriverManager.getConnection(datu,dname,dpass); //s��Ҫ��ʾ��sql��t�����ݿ�������
		// sta=con.createStatement();

		if (p == 0) {
			rs = sta.executeQuery(sql); // ��Ž����
		} else {
			sta.executeUpdate(t); // ִ�����ݿ���²���
			rs = sta.executeQuery(sql);// ��Ž����
		}

		int i = 0;
		while (rs.next()) {
			String Sno = rs.getString("Sno");
			String Sname = rs.getString("Sname");
			String Ssex = rs.getString("Sex");
			String Sage = rs.getString("Sage");
			String Sdept = rs.getString("Sdept");

			tabmo.setValueAt(Sno, i, 0);
			tabmo.setValueAt(Sname, i, 1);
			tabmo.setValueAt(Ssex, i, 2);
			tabmo.setValueAt(Sage, i, 3);
			tabmo.setValueAt(Sdept, i, 4);

			i++;

			if (i >= tabmo.getRowCount()) {
				tabmo.addRow(new Object[] {});
			}
		}
		// sta.executeUpdate("create table stuce;");
	}

	public float toTwo(float f) { // ����float�����ݱ�����λС��
		BigDecimal b = new BigDecimal(f);
		float f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
		return f1;
	}
}
