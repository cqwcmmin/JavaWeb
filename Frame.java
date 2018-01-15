package chap9;

import java.awt.*;  
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Frame extends JFrame {
	public Frame() {
		this.setLayout(new FlowLayout()); //���ô���Ĳ��ַ�ʽΪ��ʽ����
		this.setTitle("GUI");  //���ô���ı�����Ϣ
		this.setSize(400, 120);  //���ô����С
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JTextField ta = new JTextField("0"); //ʵ�����ı��򣬳�ֵΪ"0"
		ta.setColumns(10);
		final JButton b1 = new JButton("����");
		final JButton b2 = new JButton("��ԭ");
		final JButton b3 = new JButton("����");
		this.add(ta); // ����ı���
		this.add(b1); // ������Ӱ�ť
		this.add(b2); // ��ӻ�ԭ��ť
		this.add(b3); // ��ӱ��水ť
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(b1)) // ������������Ӱ�ť
					ta.setText((Integer.parseInt(ta.getText()) + 1 )+ "");  //�˴������һ�л��߶��д���
				else if (e.getSource().equals(b2)) // ��������˻�ԭ��ť
					ta.setText("0");
				else if (e.getSource().equals(b3)) { // ��������˱��水ť
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
		b1.addActionListener(al);  //�����Ӱ�ťע������¼�
		b2.addActionListener(al);  //����ԭ��ťע������¼�
		b3.addActionListener(al);  //�����水ťע������¼�
		this.setVisible(true);     //���ô���Ŀɼ���
	}
	public static void main(String[] args) {
		new Frame();  //ʵ����Frame����
		//modify
	}
}
