package dao;

import java.util.List;

import entity.Journal;

public interface IJournalDao {

	/**
	 * 添加
	 * @param tiles
	 * @return
	 */
	void addAll(List<Journal> journals);
	
	/**
	 * 根据sql查询
	 * @param sql
	 * @return 集合
	 */
	List<Journal> queryAll(String sql);
}
