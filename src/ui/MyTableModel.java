package ui;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class MyTableModel implements TableModel {
	
	  //������:

    public int getRowCount(){

           return 10;

    }

  //������

    public int getColumnCount(){

           return 5;

    }

//ȡ������   

    public String getColumnName(int columnIndex){

           return " ��"+columnIndex+"����";

    }

    //ÿһ�е���������:����������ʾ�Ķ���String��

    public Class<?>getColumnClass(int columnIndex){

            return String.class;

    }

   //ָ���ĵ�Ԫ���Ƿ�ɴӽ����ϱ༭

    public boolean isCellEditable(int rowIndex, int columnIndex){

           if(columnIndex==0){

                  return false;

           }

          return true;

    }

    //ȡ��ָ����Ԫ���ֵ

    public Object getValueAt(int rowIndex, int columnIndex){

           return rowIndex+"--"+columnIndex;

    }

   //�ӱ������ϸı���ĳ����Ԫ���ֵ�������������

   public void setValueAt(Object aValue, int rowIndex, int columnIndex){

        String s="Change at: "+rowIndex+"--- "+columnIndex+" newValue: "+aValue;

        System.out.println(s);

    }

   @Override
   public void addTableModelListener(TableModelListener l) {
	   // TODO Auto-generated method stub
	
   }

   @Override
   public void removeTableModelListener(TableModelListener l) {
	   // TODO Auto-generated method stub
	
   }


}
