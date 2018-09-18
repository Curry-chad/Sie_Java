package com.sie.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sie.demo.entity.SysUser;
import com.sie.demo.service.SysUserService;


@Controller
@RequestMapping("/cms/user")
public class SysUserController {
	
	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping(value="/{id}",method =RequestMethod.GET)
	@ResponseBody
	public SysUser get(@PathVariable("id") Integer id) {
		SysUser user = sysUserService.findOne(id);
		return user;
	}
	
	@RequestMapping(value="/findAll",method = RequestMethod.GET)
	@ResponseBody
	public List<SysUser> findAll(){
		return sysUserService.findAll();
	}
	
	@RequestMapping(value = "",method = RequestMethod.POST)
	@ResponseBody
	public void save(SysUser sysUser) {
		sysUserService.save(sysUser);
	}
	
	@RequestMapping(value = "",method = RequestMethod.PUT)
	@ResponseBody
	public void update() {
	}
	
	
	
	

}
