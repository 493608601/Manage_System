package ui;

import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import entity.Journal;
import util.DateUtils;

/**

 * ������JTable����ʾJournal�����TableModelʵ����

 *@author Administrator

 */
public class JournalTableModel extends AbstractTableModel {

	private List<Journal> journals;
	
	public JournalTableModel(List<Journal> list) {
		this.journals = list;
	}
	
	public void setJournal(List<Journal> list){
		 //�˷���Ӧ����Ӧ�ó����߳���Ҫ���¸� GUI ʱʹ��  
        SwingUtilities.invokeLater(new Runnable(){  
  
            public void run() {  
            	journals = list;  
                fireTableDataChanged();  //֪ͨJTable���ݶ����Ѹ���,�ػ����  
//                System.out.println("���½���");  
            }  
              
        });  
	}
	
    //�õ�����:�б����м���Journal���󣬾���ʾ����
    public int getRowCount(){
       return journals.size();
    }
	
    //�õ�����,Journal�����ÿ��������һ��
    public int getColumnCount(){
       return 5;
    }
	
    //ָ��ĳ�е�����:��ʱ�����ַ������ͣ�
    public Class<?> getColumnClass(int columnIndex){
    	if(columnIndex==0) return Integer.class;
       return String.class;
    }
	
    //�õ�ָ����Ԫ���ֵ:�ڼ��У������б��еĵڼ���Journal����

    public Object getValueAt(int rowIndex, int columnIndex){
      // �ڼ��У������б��еĵڼ���UserInfo����
       Journal journal=journals.get(rowIndex);
       if(columnIndex==0){//��һ����Journal��������ֵ
           return rowIndex + 1;
       }else if(columnIndex==1){//�ڶ����Ƿ���ʱ������ֵ
           return DateUtils.formatDateForTime(journal.getFssj());
       }else if(columnIndex==2){//��������ֵ�ศ��ֵ
           return ""+journal.getZbfj();
       }else if(columnIndex==3){//������������ֵ
           return ""+journal.getType();
       }else if(columnIndex==4){//������������ͷֵ
           return ""+journal.getSxt();
       }else{//�������ʱ�߼����󣬷��򲻻ᵽ����
           return "����!";
       }
    }
	
    //ָ��ĳ��Ԫ���Ƿ�ɱ༭:���ɱ༩;
    public boolean isCellEditable(int rowIndex, int columnIndex){
       return false;
    }
	
	
    //ȡÿһ�е�����

    public String getColumnName(int columnIndex){

       if(columnIndex==0){//��һ����Journal��������ֵ
              return "���";
       	  }else if(columnIndex==1){//�ڶ����Ƿ���ʱ������ֵ
              return "����ʱ��";
          }else if(columnIndex==2){//��������ֵ�ศ��ֵ
              return "ֵ��רְ����";
          }else if(columnIndex==3){//������������ֵ
              return "����";
          }else if(columnIndex==4){//������������ͷֵ
              return "����ͷ";
          }else{//�������ʱ�߼����󣬷��򲻻ᵽ����
              return "����!";
          }

    }
	
    //��Ӻ��Ƴ��������ķ����ݲ��ã�дΪ�յ�

    public void addTableModelListener(TableModelListener l){}

    public void removeTableModelListener(TableModelListener l){}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	
	
}
