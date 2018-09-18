package com.sie.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sie.demo.entity.Role;
import com.sie.demo.entity.SysUser;
import com.sie.demo.entity.UserRole;
/**
 * 业务处理逻辑接口
 * @author Administrator
 *
 */
public interface UserRoleService {
	
	Integer save(UserRole userRole);
	
	List<UserRole> findAll();
	
	List<Role> findRoleByUser(Integer id);
	
	void UserRolemodify(Integer id);
	
	void deleteOneById(Integer id);

	
}
