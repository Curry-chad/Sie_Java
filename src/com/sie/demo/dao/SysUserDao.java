package com.sie.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sie.demo.entity.SysUser;
/**
 * 接口Dao层
 * @author Administrator
 */
public interface SysUserDao {
	
	public SysUser findOne(Integer id);
	
	public List<SysUser> findAll();
	
	public List<SysUser> getUserInfoForPage(@Param("offset")Integer offset, @Param("max")Integer max);
	
	public Integer save(SysUser sysUser);
	
	public List<SysUser> findOneByName(String loginName);
	
	public List<SysUser> findBySex(String sex);
	
	public List<SysUser> findByName(String name);
	
	public List<SysUser> findByDate(@Param("date1")String date1,@Param("date2")String date2);
	
	public void deleteOneById(Integer id);
	
	public List<SysUser> selectUserListByConditionos(@Param("loginName")String loginName,@Param("name")String name,@Param("sex")String sex,@Param("date1")String date1,@Param("date2")String date2);
	
	public List<SysUser> selectUserListByConditionos1(@Param("loginName")String loginName,@Param("name")String name,@Param("sex")String sex,@Param("date1")String date1,@Param("date2")String date2,@Param("offset")Integer offset,@Param("max")Integer max);
	
	public void modify(SysUser sysUser);
}
