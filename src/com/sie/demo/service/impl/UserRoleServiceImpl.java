package com.sie.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sie.demo.dao.RoleDao;
import com.sie.demo.dao.SysUserDao;
import com.sie.demo.dao.UserRoleDao;
import com.sie.demo.entity.Role;
import com.sie.demo.entity.SysUser;
import com.sie.demo.entity.UserRole;
import com.sie.demo.service.RoleService;
import com.sie.demo.service.UserRoleService;
/**
 * 业务实现类
 * @author 程炜
 *
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	private UserRoleDao userRoleDao;

	@Override
	public Integer save(UserRole userRole) {
		// TODO Auto-generated method stub
		return userRoleDao.save(userRole);
	}

	@Override
	public List<UserRole> findAll() {
		// TODO Auto-generated method stub
		return userRoleDao.findAll();
	}

	@Override
	public List<Role> findRoleByUser(Integer id) {
		// TODO Auto-generated method stub
		return userRoleDao.findRoleByUser(id);
	}

	@Override
	public void UserRolemodify(Integer id) {
		// TODO Auto-generated method stub
		userRoleDao.UserRolemodify(id);
	}

	@Override
	public void deleteOneById(Integer id) {
		// TODO Auto-generated method stub
		userRoleDao.deleteOneById(id);
	}

		
}
