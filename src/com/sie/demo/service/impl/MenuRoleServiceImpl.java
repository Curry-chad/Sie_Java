package com.sie.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sie.demo.dao.MenuRoleDao;
import com.sie.demo.dao.RoleDao;
import com.sie.demo.dao.SysUserDao;
import com.sie.demo.dao.UserRoleDao;
import com.sie.demo.entity.MenuRole;
import com.sie.demo.entity.Role;
import com.sie.demo.entity.SysUser;
import com.sie.demo.entity.UserRole;
import com.sie.demo.service.MenuRoleService;
import com.sie.demo.service.RoleService;
import com.sie.demo.service.UserRoleService;
/**
 * 业务实现类
 * @author 程炜
 *
 */
@Service
public class MenuRoleServiceImpl implements MenuRoleService {
	@Autowired
	private MenuRoleDao menuRoleDao;

	@Override
	public Integer save(MenuRole menuRole) {
		// TODO Auto-generated method stub
		return menuRoleDao.save(menuRole);
	}

	@Override
	public List<MenuRole> findAll() {
		// TODO Auto-generated method stub
		return menuRoleDao.findAll();
	}

	@Override
	public List<MenuRole> findMenuByRole(Integer rid) {
		// TODO Auto-generated method stub
		return menuRoleDao.findMenuByRole(rid);
	}

	@Override
	public void deleteOneById(Integer rid) {
		// TODO Auto-generated method stub
		menuRoleDao.deleteOneById(rid);
	}

	
		
}
