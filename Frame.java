package chap9;

import java.awt.*;  
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Frame extends JFrame {
	public Frame() {
		this.setLayout(new FlowLayout()); //设置窗体的布局方式为流式布局
		this.setTitle("GUI");  //设置窗体的标题信息
		this.setSize(400, 120);  //设置窗体大小
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JTextField ta = new JTextField("0"); //实例化文本框，初值为"0"
		ta.setColumns(10);
		final JButton b1 = new JButton("增加");
		final JButton b2 = new JButton("还原");
		final JButton b3 = new JButton("保存");
		this.add(ta); // 添加文本框
		this.add(b1); // 添加增加按钮
		this.add(b2); // 添加还原按钮
		this.add(b3); // 添加保存按钮
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(b1)) // 如果单击了增加按钮
					ta.setText((Integer.parseInt(ta.getText()) + 1 )+ "");  //此处可添加一行或者多行代码
				else if (e.getSource().equals(b2)) // 如果单击了还原按钮
					ta.setText("0");
				else if (e.getSource().equals(b3)) { // 如果单击了保存按钮
					try {
						FileWriter fw = new FileWriter("Result.txt");
						fw.write(ta.getText());
						fw.close();   
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		};
		b1.addActionListener(al);  //给增加按钮注册监听事件
		b2.addActionListener(al);  //给还原按钮注册监听事件
		b3.addActionListener(al);  //给保存按钮注册监听事件
		this.setVisible(true);     //设置窗体的可见性
	}
	public static void main(String[] args) {
		new Frame();  //实例化Frame对象
		//modify
	}
}
