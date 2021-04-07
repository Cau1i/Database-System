package 课程管理系统;

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

	// Mysql连接
	public static final String Driver = "com.mysql.cj.jdbc.Driver";// 驱动程序名
	public static final String URL = "jdbc:mysql://localhost:3306/xs";// 数据库连接字符串，student为数据库名
	public static final String NAME = "root";// 登录名
	public static final String PASSWORD = "011023";// 密码

	public static String sql = "select * from xs.Student";// 要执行的语句

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

	// 窗口
	JFrame f = new JFrame("学生成绩管理系统");
	// 添加功能按钮
	JButton main = new JButton("主页");
	JButton display = new JButton("显示");
	JButton search = new JButton("查找");
	JButton searchClass = new JButton("选择的课程");
	JButton average_btn1 = new JButton("课程平均成绩");
	JButton average_btn2 = new JButton("学生平均成绩");
	JButton modify = new JButton("修改");
	JButton adda = new JButton("添加");
	JButton quit = new JButton("退出");

	JTable tab = null;
	DefaultTableModel tabmo = null;
	Connection con = null; // 数据库连接
	Statement sta = null; // 数据库操作
	ResultSet rs = null; // 保存查询结果

	public Menu() throws Exception {
		Class.forName(Driver); // 加载驱动程序
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

	// 控件
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

	// 显示功能
	public void show(String sql, int p, String t) throws Exception {
		// p=0:只显示数据，p=1：update数据再显示
		// con=DriverManager.getConnection(datu,dname,dpass); //s：要显示的sql，t：数据库更新语句
		// sta=con.createStatement();

		if (p == 0) {
			rs = sta.executeQuery(sql); // 存放结果集
		} else {
			sta.executeUpdate(t); // 执行数据库更新操作
			rs = sta.executeQuery(sql);// 存放结果集
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

	public float toTwo(float f) { // 设置float型数据保存两位小数
		BigDecimal b = new BigDecimal(f);
		float f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
		return f1;
	}
}
