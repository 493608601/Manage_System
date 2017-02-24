package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.Notification;

import dao.IJournalDao;
import entity.Journal;
import util.DBCon;

public class JournalDaoImpl implements IJournalDao {
	DBCon dbCon = new DBCon();
	PreparedStatement pstmt=null;
	
	private StatusLinsenter linsenter;
	public interface StatusLinsenter{
		void onSuccess();
		void onError();
	}
	
	public void setOnStatusLinsenter(StatusLinsenter linsenter){
		this.linsenter = linsenter;
	}

	@Override
	public void addAll(List<Journal> journals) {
		// TODO Auto-generated method stub
		 String strSQL="INSERT INTO journal(id, zbld, zbmj, zbfj, kssj, jssj, bxqk, bz, fssj,"
	        		+ "content, type, sxt) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		 
			try {
				pstmt=dbCon.getConnection().prepareStatement(strSQL);
				dbCon.getConnection().setAutoCommit(false);
				
				for(Journal j : journals){
					pstmt.setString(1, j.getId());
					pstmt.setString(2, j.getZbld());
					pstmt.setString(3, j.getZbmj());
					pstmt.setString(4, j.getZbfj());
					pstmt.setLong(5, j.getKssj());
					pstmt.setLong(6, j.getJssj());
					pstmt.setString(7, j.getBxqk());
					pstmt.setString(8, j.getBz());
					pstmt.setLong(9, j.getFssj());
					pstmt.setString(10, j.getContent());
					pstmt.setString(11, j.getType());
					pstmt.setString(12, j.getSxt());
					pstmt.addBatch();
				}
				 pstmt.executeBatch();
				 dbCon.getConnection().commit();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				if(linsenter!=null) linsenter.onError();
				e.printStackTrace();
			}finally{
				if(linsenter!=null) linsenter.onSuccess();
				try{
					    pstmt.close();
					    dbCon.closeAll();
				   }catch(Exception ex){
					   
				   }
			}
			
	}

	@Override
	public List<Journal> queryAll(String sql) {
		List<Journal> journals = new ArrayList<>();
		try {
			 pstmt = dbCon.getConnection().prepareStatement(sql);
			 ResultSet rs = pstmt.executeQuery();
			 while(rs.next()){//判断是否还有下一行  
				 Journal journal = new Journal();
				 journal.setId(rs.getString("id"));
				 journal.setZbld(rs.getString("zbld"));
				 journal.setZbmj(rs.getString("zbmj"));
				 journal.setZbfj(rs.getString("zbfj"));
				 journal.setKssj(rs.getLong("kssj"));
				 journal.setJssj(rs.getLong("jssj"));
				 journal.setBxqk(rs.getString("bxqk"));
				 journal.setBz(rs.getString("bz"));
				 journal.setFssj(rs.getLong("fssj"));
				 journal.setContent(rs.getString("content"));
				 journal.setType(rs.getString("type"));
				 journal.setSxt(rs.getString("sxt"));
				 journals.add(journal);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return journals;
	}

}
