package com.sie.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sie.demo.entity.SysUser;
/**
 * 业务处理逻辑接口
 * @author Administrator
 *
 */
public interface SysUserService {
	
	SysUser findOne(Integer id);
	
	List<SysUser> findAll();
	
	List<SysUser> getUserInfoForPage(Integer offset, Integer max);
	
	Integer save(SysUser sysUser);
	
	List<SysUser> findOneByName(String loginName);
	
	List<SysUser> findBySex(String sex);
    
	List<SysUser> findByName(String name);
	
	List<SysUser> findByDate(String date1,String date2);
	 
    void deleteOneById(Integer id);
    
    List<SysUser> selectUserListByConditionos(@Param("loginName")String loginName,@Param("name")String name,@Param("sex")String sex,@Param("date1")String date1,@Param("date2")String date2);
    
    List<SysUser> selectUserListByConditionos1(@Param("loginName")String loginName,@Param("name")String name,@Param("sex")String sex,@Param("date1")String date1,@Param("date2")String date2,@Param("offset")Integer offset,@Param("max")Integer max);
    
    void modify(SysUser sysUser);
	
}
