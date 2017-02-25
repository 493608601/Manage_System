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

 * 用以在JTable中显示Journal对象的TableModel实现类

 *@author Administrator

 */
public class JournalTableModel extends AbstractTableModel {

	private List<Journal> journals;
	
	public JournalTableModel(List<Journal> list) {
		this.journals = list;
	}
	
	public void setJournal(List<Journal> list){
		 //此方法应该在应用程序线程需要更新该 GUI 时使用  
        SwingUtilities.invokeLater(new Runnable(){  
  
            public void run() {  
            	journals = list;  
                fireTableDataChanged();  //通知JTable数据对象已更改,重绘界面  
//                System.out.println("更新界面");  
            }  
              
        });  
	}
	
    //得到行数:列表中有几个Journal对象，就显示几行
    public int getRowCount(){
       return journals.size();
    }
	
    //得到列数,Journal对象的每个属性是一列
    public int getColumnCount(){
       return 5;
    }
	
    //指定某列的类型:暂时都是字符串类型，
    public Class<?> getColumnClass(int columnIndex){
    	if(columnIndex==0) return Integer.class;
       return String.class;
    }
	
    //得到指定单元格的值:第几行，就是列表中的第几个Journal对象

    public Object getValueAt(int rowIndex, int columnIndex){
      // 第几行，就是列表中的第几个UserInfo对象
       Journal journal=journals.get(rowIndex);
       if(columnIndex==0){//第一列是Journal对象的序号值
           return rowIndex + 1;
       }else if(columnIndex==1){//第二列是发生时间属性值
           return DateUtils.formatDateForTime(journal.getFssj());
       }else if(columnIndex==2){//第三列是值班辅警值
           return ""+journal.getZbfj();
       }else if(columnIndex==3){//第四列是类型值
           return ""+journal.getType();
       }else if(columnIndex==4){//第五列是摄像头值
           return ""+journal.getSxt();
       }else{//除非设计时逻辑错误，否则不会到这里
           return "出错!";
       }
    }
	
    //指定某单元格是否可编辑:不可编缉;
    public boolean isCellEditable(int rowIndex, int columnIndex){
       return false;
    }
	
	
    //取每一列的列名

    public String getColumnName(int columnIndex){

       if(columnIndex==0){//第一列是Journal对象的序号值
              return "序号";
       	  }else if(columnIndex==1){//第二列是发生时间属性值
              return "发生时间";
          }else if(columnIndex==2){//第三列是值班辅警值
              return "值班专职辅警";
          }else if(columnIndex==3){//第四列是类型值
              return "类型";
          }else if(columnIndex==4){//第五列是摄像头值
              return "摄像头";
          }else{//除非设计时逻辑错误，否则不会到这里
              return "出错!";
          }

    }
	
    //添加和移除监听器的方法暂不用，写为空的

    public void addTableModelListener(TableModelListener l){}

    public void removeTableModelListener(TableModelListener l){}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	
	
}
