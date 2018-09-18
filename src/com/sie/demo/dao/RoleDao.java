package com.sie.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sie.demo.entity.Role;
import com.sie.demo.entity.SysUser;
/**
 * 接口Dao层
 * @author 程炜
 */
public interface RoleDao {
	public Integer save(Role role);
	
	public Role findOne(Integer rid); 
	
	public void deleteOneById(Integer rid); 
	
	public List<Role> findAll();
	
	public List<Role> findOneByName(String role);
	
	public void modify(Role role);
	
	public void deleteLogical(Integer rid);
	
	public List<Role> getRoleInfoForPage(@Param("offset")Integer offset, @Param("max")Integer max);
	
	public List<Role> selectRoleListByConditionos(@Param("offset")Integer offset, @Param("max")Integer max,@Param("role")String role);

}
