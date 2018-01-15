package chap9;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ChatFrame extends JFrame {
	// ��Ա����������
	private JTextArea chatContent;
	// private JLabel jl; //��ǩ��"������Ϣ"
	private JTextField inputField; // �ı��������������ݵ�
	private JButton sendBt; // ��ť�������͡�
	
	// ���췽��
	public ChatFrame(String title) throws HeadlessException {
		super(title); // ���ù��췽�������ñ�����Ϣ

		this.setSize(800, 500); // ���ô�С
		this.setLocation(200, 200); // ����λ��
		this.setBackground(Color.blue);

		// ��ʼ�����е��������ӵ��ô�����
		chatContent = new JTextArea();
		chatContent.setBackground(Color.cyan);
		this.add(chatContent, "Center");

		// ��װ���
		final JPanel inputPanel = new JPanel();//Ĭ�ϵĲ��ֲ��ֹ���ʽ����ʽ����
		// inputPanel.setBackground(Color.blue);
		// ���������ӣ�(1)��ǩ��"������Ϣ"
		final JLabel jl = new JLabel("������Ϣ");
		inputPanel.add(jl);

		// ���������ӣ�(2)�ı��������������ݵ�
		inputField = new JTextField(55);
		inputPanel.add(inputField);

		// ���������ӣ�(3)��ť�������͡�
		sendBt = new JButton("����");
		//1.ע���¼�����
		sendBt.addActionListener(new MyActionListener());
		inputPanel.add(sendBt);
  
		this.add(inputPanel, "South");// ��inputPanel��ӵ��ϲ�

		this.setVisible(true); // ���ÿɼ���
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);// ���ùرղ���

	}

	public static void main(String[] args) {
		new ChatFrame("���촰��");
	}
	
	class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println("����˷��Ͱ�ť");
			String str=inputField.getText();
			chatContent.append("��˵��"+str+"\n");
			inputField.setText(null);
		}
		
	}
}
