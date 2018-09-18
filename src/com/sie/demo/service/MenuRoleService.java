package com.sie.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sie.demo.entity.MenuRole;
import com.sie.demo.entity.Role;
import com.sie.demo.entity.SysUser;
import com.sie.demo.entity.UserRole;

/**
 * 业务处理逻辑接口
 * 
 * @author Administrator
 *
 */
public interface MenuRoleService {

	Integer save(MenuRole menuRole);

	List<MenuRole> findAll();

	List<MenuRole> findMenuByRole(Integer rid);

	void deleteOneById(Integer rid);

}
