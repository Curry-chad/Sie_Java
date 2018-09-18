package com.sie.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sie.demo.dao.MenuDao;
import com.sie.demo.entity.Menu;
import com.sie.demo.service.MenuService;
/**
 * 业务实现类
 * @author 程炜
 *
 */
@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDao menuDao;
	@Override
	public Integer save(Menu menu) {
		// TODO Auto-generated method stub
		return menuDao.save(menu);
	}
	@Override
	public List<Menu> findAll() {
		// TODO Auto-generated method stub
		return menuDao.findAll();
	}
	@Override
	public void deleteOneById(Integer mid) {
		// TODO Auto-generated method stub
		menuDao.deleteOneById(mid);
	}
	@Override
	public Menu findOne(Integer mid) {
		// TODO Auto-generated method stub
		return menuDao.findOne(mid);
	}
	@Override
	public void Menumodify(Menu menu) {
		// TODO Auto-generated method stub
		menuDao.Menumodify(menu);
	}
	@Override
	public List<Menu> getMenuInfoForPage(Integer offset, Integer max) {
		// TODO Auto-generated method stub
		return menuDao.getMenuInfoForPage(offset, max);
	}
	@Override
	public List<Menu> findOneByName(String menuName) {
		// TODO Auto-generated method stub
		return menuDao.findOneByName(menuName);
	}
	@Override
	public List<Menu> selectMenuListByConditionos(Integer offset, Integer max, String menuName) {
		// TODO Auto-generated method stub
		return menuDao.selectMenuListByConditionos(offset, max, menuName);
	}
	

}
