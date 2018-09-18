package com.sie.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sie.demo.entity.Role;
import com.sie.demo.entity.SysUser;
/**
 * 业务处理逻辑接口
 * @author Administrator
 *
 */
public interface RoleService {
	
	Integer save(Role role);
	Role findOne(Integer rid); 
	void deleteOneById(Integer rid); 
	List<Role> findAll();
	List<Role> findOneByName(String role);
	void modify(Role role);
	void deleteLogical(Integer rid);
	List<Role> getRoleInfoForPage(Integer offset, Integer max);
	List<Role> selectRoleListByConditionos(Integer offset,Integer max,String role);

	
}
