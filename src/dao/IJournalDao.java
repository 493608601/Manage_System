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
}
