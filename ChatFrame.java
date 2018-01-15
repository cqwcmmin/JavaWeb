package chap9;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ChatFrame extends JFrame {
	// 成员变量的申明
	private JTextArea chatContent;
	// private JLabel jl; //标签，"聊天信息"
	private JTextField inputField; // 文本域，输入聊天内容的
	private JButton sendBt; // 按钮，“发送”
	
	// 构造方法
	public ChatFrame(String title) throws HeadlessException {
		super(title); // 调用构造方法，设置标题信息

		this.setSize(800, 500); // 设置大小
		this.setLocation(200, 200); // 设置位置
		this.setBackground(Color.blue);

		// 初始化所有的组件，添加到该窗口中
		chatContent = new JTextArea();
		chatContent.setBackground(Color.cyan);
		this.add(chatContent, "Center");

		// 封装面板
		final JPanel inputPanel = new JPanel();//默认的布局布局管理方式是流式布局
		// inputPanel.setBackground(Color.blue);
		// 在面板上添加：(1)标签，"聊天信息"
		final JLabel jl = new JLabel("聊天信息");
		inputPanel.add(jl);

		// 在面板上添加：(2)文本域，输入聊天内容的
		inputField = new JTextField(55);
		inputPanel.add(inputField);

		// 在面板上添加：(3)按钮，“发送”
		sendBt = new JButton("发送");
		//1.注册事件监听
		sendBt.addActionListener(new MyActionListener());
		inputPanel.add(sendBt);
  
		this.add(inputPanel, "South");// 把inputPanel添加到南部

		this.setVisible(true); // 设置可见性
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);// 设置关闭操作

	}

	public static void main(String[] args) {
		new ChatFrame("聊天窗口");
	}
	
	class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println("你点了发送按钮");
			String str=inputField.getText();
			chatContent.append("我说："+str+"\n");
			inputField.setText(null);
		}
		
	}
}
