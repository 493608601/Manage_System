package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.sqlite.SQLiteConfig.JournalMode;

import dao.impl.JournalDaoImpl;
import entity.Journal;
import ui.CalendarPanel;
import ui.DateChooserJButton;
import ui.JournalTableModel;
import ui.MyTableModel;
import util.DateUtils;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class QueryJFram extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private List<Journal> journals = new ArrayList<>();
	private String[] type = {"","侵财","扰序","纠纷","猥亵","求助","走失查找","丢手机","黑摩的","其他"};
	private JTable jTable;
	private JScrollPane scrollPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryJFram frame = new QueryJFram();
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
	public QueryJFram() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1140, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		
		JLabel label = new JLabel("\u5F00\u59CB\u65F6\u95F4\uFF1A");
		label.setFont(new Font("宋体",Font.PLAIN, 16));
		label.setBounds(40, 35, 99, 33);
		contentPane.add(label);
		
		
		CalendarPanel startTime = new CalendarPanel("2017-01-01");
		startTime.setFont(new Font("宋体", Font.PLAIN, 16));
		startTime.setBounds(128, 39, 122, 24);
		contentPane.add(startTime);
		
		JLabel lblJieshu = new JLabel("\u7ED3\u675F\u65F6\u95F4\uFF1A");
		lblJieshu.setFont(new Font("宋体", Font.PLAIN, 16));
		lblJieshu.setBounds(270, 35, 99, 33);
		contentPane.add(lblJieshu);
		
		CalendarPanel endTime = new CalendarPanel();
		endTime.setFont(new Font("宋体", Font.PLAIN, 16));
		endTime.setBounds(355, 39, 122, 24);
		contentPane.add(endTime);
		
		JLabel label_1 = new JLabel("\u503C\u73ED\u4E13\u804C\u8F85\u8B66\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setBounds(498, 35, 112, 33);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(620, 41, 105, 24);
		contentPane.add(textField);
		
		JLabel label_2 = new JLabel("\u7C7B\u578B\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		label_2.setBounds(748, 35, 48, 33);
		contentPane.add(label_2);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 16));
		comboBox.setBounds(806, 39, 105, 24);
		for(String t : type){
			comboBox.addItem(t);
		}
		contentPane.add(comboBox);
		
		JButton btnQuery = new JButton("\u67E5\u8BE2");
		btnQuery.setBounds(953, 35, 122, 29);
		contentPane.add(btnQuery);
		
		
		JournalTableModel tableModel = new JournalTableModel(journals);
		jTable = new JTable();
		jTable.setModel(tableModel);

		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(jTable.getModel());
		jTable.setRowSorter(sorter);
        
		//设每一列的宽度
        for(int i=0;i<jTable.getColumnCount();i++){
        	jTable.getColumnModel().getColumn(i).setPreferredWidth(40);
        }
        jTable.setRowHeight(20);//设定每一列的高度
        
        jTable.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		// TODO Auto-generated method stub
        		if(e.getClickCount()==2){
        			
        		}
        	}
		});

        
		scrollPane = new JScrollPane(jTable);
		scrollPane.setBounds(40, 93, 944, 427);
		//超出大小后，JScrollPane自动出现滚动条
        scrollPane.setAutoscrolls(true);
		contentPane.add(scrollPane);
		
		btnQuery.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				long st = DateUtils.parseLong(startTime.getText(),"yyyy-MM-dd");
				long et = DateUtils.parseLong(endTime.getText(),"yyyy-MM-dd") + 86400000;//加一天
				String sql = "select * from journal where fssj BETWEEN "+st+" AND "+et;
				String name = null;
				String type = null;
				if(!textField.getText().equals("")){
					name = textField.getText();
					sql += " and zbfj='"+name+"'";
				}
					 
				if(!comboBox.getSelectedItem().toString().equals("")){
					 type = comboBox.getSelectedItem().toString();
					 sql += " and type='"+type+"'";
				}
					
				journals = new JournalDaoImpl().queryAll(sql);
				
				tableModel.setJournal(journals);
				contentPane.add(scrollPane);
//				contentPane.validate(); 
//				contentPane.repaint(); 
			}
		});
		
		
	}

}
