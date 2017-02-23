package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import entity.Journal;
import ui.DateChooserJButton;

import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class AddJFram extends JFrame {

	private JPanel contentPane;
	private JTextField textZbld;
	private JTextField textZbmj;
	private JTextField textZbfj;
	private JLabel label_3;
	private JLabel label_4;
	private DateChooserJButton startTime;
	private DateChooserJButton endTime;
	private JLabel label_5;
	private JTextArea textGzqk;
	private JLabel label_6;
	private JLabel label_7;
	private JTextArea textBz;
	private JTextArea textBxqk;
	private JButton btnSave;
	private JLabel label_8;
	private String[] type = {"侵财","扰序","纠纷","猥亵","求助","走失查找","丢手机","黑摩的","其他"};
	private int count = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddJFram frame = new AddJFram();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddJFram() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 989, 648);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u503C\u73ED\u9886\u5BFC\uFF1A");
		label.setFont(new Font("宋体",Font.PLAIN, 16));
		label.setBounds(40, 35, 99, 33);
		contentPane.add(label);
		
		textZbld = new JTextField();
		textZbld.setBounds(156, 39, 136, 24);
		textZbld.setFont(new Font("宋体", Font.PLAIN, 16));
		contentPane.add(textZbld);
		
		JLabel label_1 = new JLabel("\u503C\u73ED\u6C11\u8B66\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setBounds(352, 35, 99, 33);
		contentPane.add(label_1);
		
		textZbmj = new JTextField();
		textZbmj.setColumns(10);
		textZbmj.setBounds(451, 40, 136, 24);
		textZbld.setFont(new Font("宋体", Font.PLAIN, 16));

		contentPane.add(textZbmj);
		
		JLabel label_2 = new JLabel("\u503C\u73ED\u4E13\u5C5E\u8F85\u8B66\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		label_2.setBounds(631, 35, 136, 33);
		contentPane.add(label_2);
		
		textZbfj = new JTextField();
		textZbfj.setColumns(10);
		textZbfj.setBounds(766, 40, 149, 24);
		textZbld.setFont(new Font("宋体", Font.PLAIN, 16));
		contentPane.add(textZbfj);
		
		label_3 = new JLabel("\u503C\u73ED\u5F00\u59CB\u65F6\u95F4\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setBounds(40, 97, 136, 33);
		contentPane.add(label_3);
		
		label_4 = new JLabel("\u503C\u73ED\u7ED3\u675F\u65F6\u95F4\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 16));
		label_4.setBounds(522, 97, 136, 33);
		contentPane.add(label_4);
		
		startTime = new DateChooserJButton();
		startTime.setFont(new Font("宋体", Font.PLAIN, 16));
		startTime.setBounds(206, 101, 182, 24);
		contentPane.add(startTime);
		
		endTime = new DateChooserJButton();
		endTime.setFont(new Font("宋体", Font.PLAIN, 16));
		endTime.setBounds(672, 101, 182, 24);
		contentPane.add(endTime);
		
		label_5 = new JLabel("\u5F53\u73ED\u5DE5\u4F5C\u60C5\u51B5\uFF1A");
		label_5.setFont(new Font("宋体", Font.PLAIN, 16));
		label_5.setBounds(40, 167, 136, 33);
		contentPane.add(label_5);
		
		textGzqk = new JTextArea();
		textGzqk.setFont(new Font("宋体", Font.PLAIN, 16));
		textGzqk.setBounds(206, 161, 483, 52);
		contentPane.add(textGzqk);
		
		label_6 = new JLabel("\u8BBE\u5907\u8FD0\u884C\u62A5\u4FEE\u60C5\u51B5\uFF1A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 16));
		label_6.setBounds(40, 349, 175, 33);
		contentPane.add(label_6);
		
		label_7 = new JLabel("\u5907\u6CE8\uFF1A");
		label_7.setFont(new Font("宋体", Font.PLAIN, 16));
		label_7.setBounds(79, 447, 76, 33);
		contentPane.add(label_7);
		
		textBz = new JTextArea();
		textBz.setFont(new Font("宋体", Font.PLAIN, 16));
		textBz.setBounds(206, 438, 709, 52);
		contentPane.add(textBz);
		
		textBxqk = new JTextArea();
		textBxqk.setFont(new Font("宋体", Font.PLAIN, 16));
		textBxqk.setBounds(206, 337, 709, 52);
		contentPane.add(textBxqk);
		
		btnSave = new JButton("\u4FDD\u5B58");
		btnSave.setBounds(407, 527, 239, 44);
		btnSave.setFont(new Font("宋体", Font.PLAIN, 16));
		contentPane.add(btnSave);
		
		label_8 = new JLabel("\u7C7B\u578B\uFF1A");
		label_8.setFont(new Font("宋体", Font.PLAIN, 16));
		label_8.setBounds(727, 167, 99, 33);
		contentPane.add(label_8);
		
		JComboBox cbType = new JComboBox();
		cbType.setBounds(783, 171, 105, 24);
		cbType.setFont(new Font("宋体", Font.PLAIN, 16));
		for(String t : type){
			cbType.addItem(t);
		}
		contentPane.add(cbType);
	
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Journal journal  = new Journal();
				journal.setZbld(textZbld.getText());
				journal.setZbmj(textZbmj.getText());
				journal.setZbfj(textZbfj.getText());
				journal.setKssj(startTime.getText());
				journal.setJssj(endTime.getText());
				journal.setGzqk(textGzqk.getText());
				journal.setBxqk(textBxqk.getText());
				journal.setBz(textBz.getText());
				journal.setType((String)cbType.getSelectedItem());
				addLayout();
			}
		});
		
	}
	
	
	private void addLayout(){
		count++;
		JLabel la = new JLabel("\u5F53\u73ED\u5DE5\u4F5C\u60C5\u51B5\uFF1A");
		la.setFont(new Font("宋体", Font.PLAIN, 16));
		la.setBounds(40, 167+count*20, 136, 33);
		contentPane.add(la);
		
		JTextArea te = new JTextArea();
		te.setFont(new Font("宋体", Font.PLAIN, 16));
		te.setBounds(206, 161+count*20, 483, 52);
		contentPane.add(te);
		
		JLabel lab = new JLabel("\u7C7B\u578B\uFF1A");
		lab.setFont(new Font("宋体", Font.PLAIN, 16));
		lab.setBounds(727, 167+count*20, 99, 33);
		contentPane.add(lab);
		
		JComboBox cb = new JComboBox();
		cb.setBounds(783, 171+count*20, 105, 24);
		cb.setFont(new Font("宋体", Font.PLAIN, 16));
		for(String t : type){
			cb.addItem(t);
		}
		contentPane.add(cb);
		contentPane.revalidate();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
