package com.sie.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sie.demo.dao.SysUserDao;
import com.sie.demo.entity.SysUser;
import com.sie.demo.service.SysUserService;
/**
 * 业务实现类
 * @author Administrator
 *
 */
@Service
public class SysUserServiceImpl implements SysUserService{
	
	@Autowired
	private SysUserDao sysUserDao;

	@Override
	public Integer save(SysUser sysUser) {
		return sysUserDao.save(sysUser);
	}

	@Override
	public SysUser findOne(Integer id) {
		return sysUserDao.findOne(id);
	}

	@Override
	public List<SysUser> findAll() {
		return sysUserDao.findAll();
	}

	@Override
	public List<SysUser> findOneByName(String loginName) {
		// TODO Auto-generated method stub
		return sysUserDao.findOneByName(loginName);
	}

	@Override
	public void deleteOneById(Integer id) {
		// TODO Auto-generated method stub
		   sysUserDao.deleteOneById(id);
	}

	@Override
	public List<SysUser> getUserInfoForPage(Integer offset, Integer max) {
		// TODO Auto-generated method stub
		return sysUserDao.getUserInfoForPage(offset, max);
	}

	@Override
	public List<SysUser> findBySex(String sex) {
		// TODO Auto-generated method stub
		return sysUserDao.findBySex(sex);
	}

	@Override
	public List<SysUser> findByName(String name) {
		// TODO Auto-generated method stub
		return sysUserDao.findByName(name);
	}

	@Override
	public List<SysUser> findByDate(String date1, String date2) {
		// TODO Auto-generated method stub
		return sysUserDao.findByDate(date1, date2);
	}

	@Override
	public void modify(SysUser sysUser) {
		// TODO Auto-generated method stub
		sysUserDao.modify(sysUser);
	}

	@Override
	public List<SysUser> selectUserListByConditionos(String loginName, String name, String sex, String date1,
			String date2) {
		// TODO Auto-generated method stub
		return sysUserDao.selectUserListByConditionos(loginName, name, sex, date1, date2);
	}

	@Override
	public List<SysUser> selectUserListByConditionos1(String loginName, String name, String sex, String date1,
			String date2, Integer offset, Integer max) {
		// TODO Auto-generated method stub
		return sysUserDao.selectUserListByConditionos1(loginName, name, sex, date1, date2, offset, max);
	}

	


	
	


}
