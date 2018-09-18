package com.sie.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sie.demo.entity.Menu;
import com.sie.demo.entity.Role;
import com.sie.demo.entity.SysUser;
/**
 * 业务处理逻辑接口
 * @author Administrator
 *
 */
public interface MenuService {
	
	Integer save(Menu menu);
	
	List<Menu> findAll();
	
	void deleteOneById(Integer mid);
	
	Menu findOne(Integer mid); 
	
	void Menumodify(Menu menu);
	
	List<Menu> getMenuInfoForPage(Integer offset,Integer max);
	
	List<Menu> findOneByName(String menuName);
	
	List<Menu> selectMenuListByConditionos(Integer offset,Integer max,String menuName);
	

	
}
