package cn.damai.beautiful_article.common.dao;

import java.io.Serializable;

/**
 * 通用dao
 * 
 * @author 樊康康
 * 
 */
public interface Dao {
	/**
	 * 保存数据，返回受影响的行数
	 * 
	 * @param e
	 * @return
	 */
	public <E> int save(E e);

	/**
	 * 根据主键id更新数据，返回受影响的行数
	 * 
	 * @param e
	 * @return
	 */
	public <E> int update(E e);

	/**
	 * 根据主键id删除数据，返回受影响的行数
	 * 
	 * @param id
	 * @return
	 */
	public int deleteById(Serializable id);

	/**
	 * 根据主键id查询数据
	 *
	 * @param id
	 * @param <E>
     * @return
     */
	public <E> E findById(Serializable id);
 

}