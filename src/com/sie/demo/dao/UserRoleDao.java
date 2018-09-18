package com.sie.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sie.demo.entity.Role;
import com.sie.demo.entity.SysUser;
import com.sie.demo.entity.UserRole;
/**
 * 接口Dao层
 * @author 程炜
 */

public interface UserRoleDao {
	public Integer save(UserRole userRole);
	
	public List<UserRole> findAll();
	
	public List<Role> findRoleByUser(Integer id);
	
	public void UserRolemodify(Integer id);
	
	public void deleteOneById(Integer id);

}
