package com.sie.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sie.demo.entity.MenuRole;
import com.sie.demo.entity.Role;
import com.sie.demo.entity.SysUser;
import com.sie.demo.entity.UserRole;
/**
 * 接口Dao层
 * @author 程炜
 */

public interface MenuRoleDao {
	public Integer save(MenuRole menuRole);
	
	public List<MenuRole> findAll();
	
	public List<MenuRole> findMenuByRole(Integer rid);
	
	public void deleteOneById(Integer rid);

}
