package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.IMP_LIMIT;

import dao.impl.JournalDaoImpl;
import dao.impl.JournalDaoImpl.StatusLinsenter;
import entity.Journal;
import ui.DateChooserJButton;
import util.DateUtils;

import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

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
	private JLabel label_6;
	private JLabel label_7;
	private JTextArea textBz;
	private JTextArea textBxqk;
	private JButton btnSave;
	private JLabel label_8;
	private String[] type = {"侵财","扰序","纠纷","猥亵","求助","走失查找","丢手机","黑摩的","其他"};
	private int count = 1;
	private final int intemHeight = 120;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private List<DateChooserJButton> dateChooserJButtons = new ArrayList<>();
	private List<JTextArea> jTextAreasContent = new ArrayList<>();
	private List<JComboBox<String>>  jCBTypes = new ArrayList<>();
	private List<JTextField> JTextCameras = new ArrayList<>();

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

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1140, 590);
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
		label_5.setBounds(40, 287, 136, 33);
		contentPane.add(label_5);
		
		label_6 = new JLabel("\u8BBE\u5907\u8FD0\u884C\u62A5\u4FEE\u60C5\u51B5\uFF1A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 16));
		label_6.setBounds(40, 159, 149, 33);
		contentPane.add(label_6);
		
		label_7 = new JLabel("\u5907\u6CE8\uFF1A");
		label_7.setFont(new Font("宋体", Font.PLAIN, 16));
		label_7.setBounds(40, 229, 76, 33);
		contentPane.add(label_7);
		
		textBz = new JTextArea();
		textBz.setFont(new Font("宋体", Font.PLAIN, 16));
		textBz.setBounds(206, 217, 709, 52);
		contentPane.add(textBz);
		
		textBxqk = new JTextArea();
		textBxqk.setFont(new Font("宋体", Font.PLAIN, 16));
		textBxqk.setBounds(206, 140, 709, 52);
		contentPane.add(textBxqk);
		
		btnSave = new JButton("\u4FDD\u5B58");
		btnSave.setBounds(998, 71, 76, 161);
		btnSave.setFont(new Font("宋体", Font.PLAIN, 16));
		contentPane.add(btnSave);
		
		label_8 = new JLabel("\u7C7B\u578B\uFF1A");
		label_8.setFont(new Font("宋体", Font.PLAIN, 16));
		label_8.setBounds(735, 345, 83, 33);
		contentPane.add(label_8);
		

		
		
		label_9 = new JLabel("\u65F6\u95F4\uFF1A");
		label_9.setFont(new Font("宋体", Font.PLAIN, 16));
		label_9.setBounds(40, 345, 56, 33);
		contentPane.add(label_9);
		
		label_10 = new JLabel("\u5185\u5BB9\uFF1A");
		label_10.setFont(new Font("宋体", Font.PLAIN, 16));
		label_10.setBounds(254, 345, 56, 33);
		contentPane.add(label_10);
		
		label_11 = new JLabel("\u6444\u50CF\u5934\uFF1A");
		label_11.setFont(new Font("宋体", Font.PLAIN, 16));
		label_11.setBounds(865, 345, 83, 33);
		contentPane.add(label_11);
		
		DateChooserJButton dateNow = new DateChooserJButton();
		dateNow.setFont(new Font("宋体", Font.PLAIN, 16));
		dateNow.setBounds(40, 423, 182, 24);
		contentPane.add(dateNow);
		dateChooserJButtons.add(dateNow);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(254, 392, 450, 100);
		contentPane.add(scrollPane);
		
		JTextArea tAContent = new JTextArea();
		scrollPane.setViewportView(tAContent);
		jTextAreasContent.add(tAContent);
		
		
		JComboBox<String> cbType = new JComboBox<String>();
		cbType.setBounds(735, 423, 105, 24);
		cbType.setFont(new Font("宋体", Font.PLAIN, 16));
		for(String t : type){
			cbType.addItem(t);
		}
		contentPane.add(cbType);
		jCBTypes.add(cbType);
		
		JTextField tFCamera = new JTextField();
		tFCamera.setBounds(865, 425, 116, 24);
		contentPane.add(tFCamera);
		tFCamera.setColumns(10);
		JTextCameras.add(tFCamera);
		
		
		JButton btnAddItem = new JButton("\u6DFB\u52A0");
		btnAddItem.setBounds(998, 348, 93, 29);
		contentPane.add(btnAddItem);
		
		btnAddItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addLayout();
			}
		});
	
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				List<Journal> journals = new ArrayList<>();
				Journal journal  = new Journal();
				journal.setZbld(textZbld.getText());
				journal.setZbmj(textZbmj.getText());
				journal.setZbfj(textZbfj.getText());
				journal.setKssj(DateUtils.parseLong(startTime.getText()));
				journal.setJssj(DateUtils.parseLong(endTime.getText()));
				journal.setBxqk(textBxqk.getText());
				journal.setBz(textBz.getText());
				
				for(int i = 0;i< jTextAreasContent.size();i++ ){
					if(jTextAreasContent.get(i).getText().trim().equals("")){
						continue;
					}
					
					Journal j = journal.clone();
					j.setId(UUID.randomUUID().toString());
					String time = dateChooserJButtons.get(i).getText();
					long ms = DateUtils.parseLong(time);
					j.setFssj(ms);
					j.setContent(jTextAreasContent.get(i).getText());
					j.setType(jCBTypes.get(i).getSelectedItem().toString());
					j.setSxt(JTextCameras.get(i).getText());
					journals.add(j);
				}
				
				JournalDaoImpl imp = new JournalDaoImpl();
				imp.setOnStatusLinsenter(new StatusLinsenter() {
					
					@Override
					public void onSuccess() {
						// TODO Auto-generated method stub
						showDialog("保存成功");
					}
					
					@Override
					public void onError() {
						// TODO Auto-generated method stub
						showDialog("保存失败");
					}
				});
				
				imp.addAll(journals);
				
			}
		});
		
	}
	
	private void showDialog(String message){
		int result = JOptionPane.showConfirmDialog(null,message , "Message", JOptionPane.PLAIN_MESSAGE);
		if(result == JOptionPane.OK_OPTION){
		    setVisible(false);
		}
	}
	
	private void addLayout(){
		
		DateChooserJButton dateNow = new DateChooserJButton();
		dateNow.setFont(new Font("宋体", Font.PLAIN, 16));
		dateNow.setBounds(40, 423 + intemHeight * count, 182, 24);
		contentPane.add(dateNow);
		dateChooserJButtons.add(dateNow);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(254, 392 + intemHeight * count, 450, 100);
		contentPane.add(scrollPane);
		
		JTextArea tAContent = new JTextArea();
		scrollPane.setViewportView(tAContent);
		jTextAreasContent.add(tAContent);
		
		
		JComboBox<String> cbType = new JComboBox<String>();
		cbType.setBounds(735, 423 + intemHeight * count, 105, 24);
		cbType.setFont(new Font("宋体", Font.PLAIN, 16));
		for(String t : type){
			cbType.addItem(t);
		}
		contentPane.add(cbType);
		jCBTypes.add(cbType);
		
		JTextField tFCamera = new JTextField();
		tFCamera.setBounds(865, 425 + intemHeight * count, 116, 24);
		contentPane.add(tFCamera);
		tFCamera.setColumns(10);
		JTextCameras.add(tFCamera);
		
		setBounds(100, 100, 1140, 590 + intemHeight * count);
		
		count++;
		
		contentPane.validate(); 
		contentPane.repaint(); 
	}
}
