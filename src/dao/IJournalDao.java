package dao;

import java.util.List;

import entity.Journal;

public interface IJournalDao {

	/**
	 * ���
	 * @param tiles
	 * @return
	 */
	void addAll(List<Journal> journals);
	
	/**
	 * ����sql��ѯ
	 * @param sql
	 * @return ����
	 */
	List<Journal> queryAll(String sql);
	
	/**
	 * ����id��ѯ
	 * @param sql
	 * @return 
	 */
	Journal queryForID(String id);
	
	/**
	 * ����
	 * @param sql
	 */
	void update(Journal journal);
	
	/**
	 * ����idɾ��
	 * @param sql
	 */
	void deleteForID(String id);
}
