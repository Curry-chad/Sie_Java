package com.sie.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sie.demo.dao.RoleDao;
import com.sie.demo.dao.SysUserDao;
import com.sie.demo.entity.Role;
import com.sie.demo.entity.SysUser;
import com.sie.demo.service.RoleService;
/**
 * 业务实现类
 * @author 程炜
 *
 */
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;

	@Override
	public Integer save(Role role) {
		// TODO Auto-generated method stub
		return roleDao.save(role);
	}

	@Override
	public Role findOne(Integer rid) {
		// TODO Auto-generated method stub
		return roleDao.findOne(rid);
	}

	@Override
	public void deleteOneById(Integer rid) {
		// TODO Auto-generated method stub
		roleDao.deleteOneById(rid);
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleDao.findAll();
	}

	@Override
	public List<Role> findOneByName(String role) {
		// TODO Auto-generated method stub
		return roleDao.findOneByName(role);
	}

	@Override
	public void modify(Role role) {
		// TODO Auto-generated method stub
		roleDao.modify(role);
	}

	@Override
	public void deleteLogical(Integer rid) {
		// TODO Auto-generated method stub
		roleDao.deleteLogical(rid);
	}

	@Override
	public List<Role> getRoleInfoForPage(Integer offset, Integer max) {
		// TODO Auto-generated method stub
		return roleDao.getRoleInfoForPage(offset, max);
	}

	@Override
	public List<Role> selectRoleListByConditionos(Integer offset, Integer max,String role) {
		// TODO Auto-generated method stub
		return roleDao.selectRoleListByConditionos(offset, max,role);
	}

}
