package com.sie.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sie.demo.entity.Menu;
import com.sie.demo.entity.Role;
import com.sie.demo.entity.SysUser;
/**
 * 接口Dao层
 * @author 程炜
 */
public interface MenuDao {
	public Integer save(Menu menu);
	
	public List<Menu> findAll();
	
	public void deleteOneById(Integer mid);
	
	public Menu findOne(Integer mid); 
	
	public void Menumodify(Menu menu);
	
	public List<Menu> getMenuInfoForPage(@Param("offset")Integer offset, @Param("max")Integer max);
	
	public List<Menu> findOneByName(String menuName);
	
	public List<Menu> selectMenuListByConditionos(@Param("offset")Integer offset, @Param("max")Integer max,@Param("menuName")String menuName);
	
	
	

}
