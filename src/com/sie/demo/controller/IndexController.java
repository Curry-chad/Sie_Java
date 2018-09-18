package com.sie.demo.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.jsoup.Connection.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sie.demo.entity.Menu;
import com.sie.demo.entity.MenuRole;
import com.sie.demo.entity.PageInfo;
import com.sie.demo.entity.Role;
import com.sie.demo.entity.SysUser;
import com.sie.demo.entity.UserRole;
import com.sie.demo.service.MenuRoleService;
import com.sie.demo.service.MenuService;
import com.sie.demo.service.RoleService;
import com.sie.demo.service.SysUserService;
import com.sie.demo.service.UserRoleService;

//将类声明为spring容器中的bean，spring调用时对该类实例化
@Controller
/* @RequestMapping("/cms") */// 声明Controller处理的请求是什么
public class IndexController {
	// 业务接口注入
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private MenuRoleService menuRoleService;
	private int status = 0;
	private int status1 = 0;
	private int status2 = 0;

	@RequestMapping("/index")
	public String index(SysUser sysUser, ModelMap model) {
		System.out.println("开始执行index方法了");
		sysUser.setCreateTime(new Date());
		sysUser.setPassword(DigestUtils.md5Hex(sysUser.getPassword()));
		sysUserService.save(sysUser);
		System.out.println(sysUser);
		model.addAttribute("message", "Successful");
		System.out.println("LoginName" + sysUser.getLoginName());
		return "forward:main.action?now=1&&next=0&&last=0&&flag=0";
	}

	@RequestMapping("/modify")
	public String modify(SysUser sysUser, ModelMap model) {
		System.out.println("进入modify方法了");
		sysUser.setCreateTime(new Date());
		sysUser.setPassword(DigestUtils.md5Hex(sysUser.getPassword()));
		System.out.println("This is a test:" + sysUser);
		sysUserService.modify(sysUser);
		System.out.println(sysUser);
		model.addAttribute("message", "Successful");
		System.out.println("LoginName" + sysUser.getLoginName());
		return "forward:main.action?now=1&&next=0&&last=0&&flag=0";
	}

	@RequestMapping("/edit")
	public ModelAndView edit(SysUser sysUser, ModelMap model) {
		System.out.println("进入edit方法了");
		System.out.println("id+" + sysUser.getId());
		sysUser = sysUserService.findOne(sysUser.getId());
		System.out.println(sysUser);
		model.addAttribute("sysUser", sysUser);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("modify");
		return mav;
	}

	@RequestMapping("/login")
	public String login(String loginName, String password, ModelMap model, HttpSession session) {
		System.out.println(loginName + password);
		List<SysUser> list = sysUserService.findOneByName(loginName);
		model.addAttribute("message", loginName);
		if (list.size() != 0) {
			SysUser sysUser = list.get(0);
			System.out.println(sysUser);
			if (null == sysUser) {
				System.out.println("用户名密码错误");
				return "fail";
			} else {
				if (DigestUtils.md5Hex(password).equals(sysUser.getPassword())) {
					session.setAttribute("msg", sysUser);
					/* session.setMaxInactiveInterval(1*60); */
					return "welcome";
				} else {

					System.out.println("用户名密码错误");
					return "fail";
				}
			}

		} else {
			System.out.println("不存在该用户!");
			return "fail1";
		}

	}

	@RequestMapping("/del")
	public String del(Integer[] id, ModelMap model) {
		System.out.println("进入删除方法了");
		for (int i = 0; i < id.length; i++) {
			System.out.println(id.length);
			System.out.println("id" + id[i]);
		}
		for (int i = 0; i < id.length; i++) {
			System.out.println(id.length);
			sysUserService.deleteOneById(id[i]);
			System.out.println("id" + id);
		}

		model.addAttribute("message", "删除成功");

		return "forward:main.action?now=1&&next=0&&last=0&&flag=0";
	}

	@RequestMapping("/main")
	public String main(Integer now, Integer next, Integer last, Integer flag, String loginName, String name, String sex,
			String createTime, String createTime1, ModelMap model) {

		List<SysUser> list = sysUserService.findAll();
		List<SysUser> list1 = sysUserService.findAll();
		int pages = 1;
		if (flag == 1) {
			// 点击查询时执行
			list1 = sysUserService.selectUserListByConditionos("%" + loginName + "%", "%" + name + "%", sex, createTime,
					createTime1);
			pages = (int) Math.ceil(list1.size() / 10.0);
			if (next == 2) {
				// 点击下一页时执行
				if (now < pages) {
					now++;
				}
			}
			if (last == 2) {
				// 点击上一页时执行
				if (now > 1) {
					now--;
				}
			}
			status1 = 1;
			PageInfo pageInfo = new PageInfo(now);
			list = sysUserService.selectUserListByConditionos1("%" + loginName + "%", "%" + name + "%", sex, createTime,
					createTime1, pageInfo.getOffset(), pageInfo.getMax());
			System.out.println(list);

		} else {
			list1 = sysUserService.findAll();
			pages = (int) Math.ceil(list1.size() / 10.0);
			if (next == 1) {
				// 点击下一页时执行
				if (now < pages) {
					now++;
				}
			}
			if (last == 1) {
				// 点击上一页时执行
				if (now > 1) {
					now--;
				}
			}
			status1 = 0;
			PageInfo pageInfo = new PageInfo(now);
			list = sysUserService.getUserInfoForPage(pageInfo.getOffset(), pageInfo.getMax());
		}

		model.addAttribute("status1", status1);
		model.addAttribute("SysUsers", list);
		model.addAttribute("pages", pages);
		model.addAttribute("now", now);
		model.addAttribute("loginName", loginName);
		model.addAttribute("name", name);
		model.addAttribute("sex", sex);
		model.addAttribute("createTime", createTime);
		model.addAttribute("createTime1", createTime1);
		System.out.println("执行完main方法了");
		return "index";
	}

	//-------------Role逻辑管理-----------------
	                                       
	//-------------Role逻辑管理-----------------
	
	//
	@RequestMapping("/RoleSave")
	public String RoleSave(Role role) {
		System.out.println("进入RoleSave方法了");
		System.out.println(role);
		roleService.save(role);
		System.out.println("执行完RoleSave方法了");
		return "forward:RoleManage.action?now1=1&&next=0&&last=0&&flag=0";
	}

	@RequestMapping("/RoleDelete")
	public String RoleDelete(Integer[] id, ModelMap model) {
		System.out.println("进入RoleDelete方法了");
		for (Integer x : id) {
			System.out.println("前台传过来的id:" + x);
		}
		for (Integer x : id) {
			roleService.deleteOneById(x);
		}
		System.out.println("执行完RoleDelete方法了");
		return "forward:RoleManage.action?now1=1&&next=0&&last=0&&flag=0";

	}

	@RequestMapping("/RoleDeleteLogical")
	public String RoleDeleteLogical(Integer id, ModelMap model) {
		System.out.println("进入RoleDeleteLogical方法了");
		System.out.println("前台传过来的id:" + id);
		roleService.deleteLogical(id);
		System.out.println("执行完RoleDeleteLogical方法了");
		return "forward:RoleManage.action?now1=1&&next=0&&last=0&&flag=0";

	}

	@ResponseBody
	@RequestMapping("/RoleSelectAll")
	public String RoleSelectAll() {
		System.out.println("进入RoleSelectAll方法了");
		List<Role> list = roleService.findAll();
		for (Role role : list) {
			System.out.println(role);
		}
		System.out.println("执行完RoleSelectAll方法了");
		return "SelectAll successfully!";

	}

	// 分页和查询分页
	@RequestMapping("/RoleManage")
	public String RoleManage(Integer now1, Integer next, Integer last, Integer flag, String role, ModelMap model) {

		System.out.println("进入RoleManage方法了");
		System.out.println("--------参数--------");
		System.out.println("now1:" + now1 + "next:" + next + "last:" + last + "flag:" + flag + "role:" + role);
		System.out.println("--------参数--------");

		List<Role> list = roleService.findAll();
		List<Role> list1;
		int pages = 1;
		if (flag == 1) {
			// 点击查询时执行
			list1 = roleService.findOneByName("%" + role + "%");
			pages = (int) Math.ceil(list1.size() / 10.0);
			if (next == 2) {
				// 点击下一页时执行
				if (now1 < pages) {
					now1++;
				}
			}
			if (last == 2) {
				// 点击上一页时执行
				if (now1 > 1) {
					now1--;
				}
			}
			status = 1;
			PageInfo pageInfo = new PageInfo(now1);
			list = roleService.selectRoleListByConditionos(pageInfo.getOffset(), pageInfo.getMax(), "%" + role + "%");
			System.out.println(list);

		} else {
			list1 = roleService.findAll();
			pages = (int) Math.ceil(list1.size() / 10.0);
			if (next == 1) {
				// 点击下一页时执行
				if (now1 < pages) {
					now1++;
				}
			}
			if (last == 1) {
				// 点击上一页时执行
				if (now1 > 1) {
					now1--;
				}
			}
			status = 0;
			PageInfo pageInfo = new PageInfo(now1);
			list = roleService.getRoleInfoForPage(pageInfo.getOffset(), pageInfo.getMax());
		}

		model.addAttribute("status", status);
		model.addAttribute("Role", list);
		model.addAttribute("pages", pages);
		model.addAttribute("now1", now1);
		model.addAttribute("role", role);
		System.out.println("执行完RoleManage方法了");
		return "role";

	}

	@RequestMapping("/RoleSearch")
	public String RoleSearch(String role, ModelMap model) {
		System.out.println("进入RoleSearch方法了");
		List<Role> list = roleService.findOneByName("%" + role + "%");
		model.addAttribute("Role", list);
		System.out.println("执行完RoleSearch方法了");
		return "role";

	}

	@RequestMapping("/RoleModify")
	public String RoleModify(Role role, ModelMap model) {
		System.out.println("进入RoleModify方法了");
		roleService.modify(role);
		System.out.println("执行完RoleModify方法了");
		return "forward:RoleManage.action?now1=1&&next=0&&last=0&&flag=0";

	}

	@RequestMapping("/RoleEdit")
	public String RoleEdit(Integer id, ModelMap model) {
		System.out.println("进入RoleEdit方法了");
		Role role1 = roleService.findOne(id);
		model.addAttribute("role", role1);
		System.out.println("执行完RoleEdit方法了");
		return "roleModify";
	}
		
	//-------------UserRole逻辑管理-----------------
    
	//-------------UserRole逻辑管理-----------------	
	@RequestMapping("/UserRoleEdit")
	public String UserRoleEdit(Integer id, ModelMap model) {
		System.out.println("进入UserRoleEdit方法了");
		SysUser sysUser = sysUserService.findOne(id);
		List<Role> list = roleService.findAll();
		List<Role> list1 = userRoleService.findRoleByUser(id);
		model.addAttribute("sysUser", sysUser);
		model.addAttribute("Role", list);
		model.addAttribute("Role1", list1);
		System.out.println("Role1:" + list1.size());
		System.out.println("执行完UserRoleEdit方法了");
		return "roleSet";
	}

	@RequestMapping("/UserRoleModify")
	public String UserRoleModify(Integer id, Integer[] rid, ModelMap model) {
		System.out.println("进入UserRoleModify方法了");
		UserRole userRole = new UserRole();
		// 此处可能性太多
		userRoleService.deleteOneById(id);
		for (int i = 0; i < rid.length; i++) {
			userRole = new UserRole();
			userRole.setId(id);
			userRole.setRid(rid[i]);
			userRoleService.save(userRole);
		}

		System.out.println("执行完UserRoleModify方法了");
		return "forward:main.action?now=1&&next=0&&last=0&&flag=0";

	}
			//-------------Menu逻辑管理-----------------
		    
			//-------------Menu逻辑管理-----------------	
			
	@RequestMapping("/MenuManage")
	public String MenuManage(Integer now2, Integer next, Integer last, Integer flag, String menuName, ModelMap model) {
		System.out.println("进入MenuManage方法了");
		System.out.println("--------参数--------");
		System.out.println("now1:" + now2 + "next:" + next + "last:" + last + "flag:" + flag + "role:" + menuName);
		System.out.println("--------参数--------");

		List<Menu> list = menuService.findAll();
		List<Menu> list1;
		int pages = 1;
		if (flag == 1) {
			// 点击查询时执行
			list1 = menuService.findOneByName("%" + menuName + "%");
			pages = (int) Math.ceil(list1.size() / 10.0);
			if (next == 2) {
				// 点击下一页时执行
				if (now2 < pages) {
					now2++;
				}
			}
			if (last == 2) {
				// 点击上一页时执行
				if (now2 > 1) {
					now2--;
				}
			}
			status2 = 1;
			PageInfo pageInfo = new PageInfo(now2);
			list = menuService.selectMenuListByConditionos(pageInfo.getOffset(), pageInfo.getMax(),
					"%" + menuName + "%");
			System.out.println(list);

		} else {
			list1 = menuService.findAll();
			pages = (int) Math.ceil(list1.size() / 10.0);
			if (next == 1) {
				// 点击下一页时执行
				if (now2 < pages) {
					now2++;
				}
			}
			if (last == 1) {
				// 点击上一页时执行
				if (now2 > 1) {
					now2--;
				}
			}
			status2 = 0;
			PageInfo pageInfo = new PageInfo(now2);
			list = menuService.getMenuInfoForPage(pageInfo.getOffset(), pageInfo.getMax());
		}

		model.addAttribute("status2", status2);
		model.addAttribute("Menu", list);
		model.addAttribute("pages", pages);
		model.addAttribute("now2", now2);
		model.addAttribute("menuName", menuName);
		System.out.println("执行完MenuManage方法了");
		return "menu";

	}

	@RequestMapping("/MenuSave")
	public String MenuSave(Menu menu, ModelMap model) {
		System.out.println("进入MenuSave方法了");
		System.out.println("前台获取到的menu" + menu);
		menuService.save(menu);

		System.out.println("执行完MenuSave方法了");
		return "forward:MenuManage.action?now2=1&&next=0&&last=0&&flag=0";

	}

	@RequestMapping("/MenuDelete")
	public String MenuDelete(Integer[] mid, ModelMap model) {
		System.out.println("进入MenuDelete方法了");
		for (Integer id : mid) {
			menuService.deleteOneById(id);
		}

		System.out.println("执行完MenuDelete方法了");
		return "forward:MenuManage.action?now2=1&&next=0&&last=0&&flag=0";

	}

	@RequestMapping("/MenuEdit")
	public String MenuEdit(Integer mid, ModelMap model) {
		System.out.println("进入MenuEdit方法了");
		Menu menu = menuService.findOne(mid);
		model.addAttribute("Menu", menu);
		System.out.println("执行完MenuEdit方法了");
		return "menuModify";
	}

	@RequestMapping("/MenuModify")
	public String MenuModify(Menu menu, ModelMap model) {
		System.out.println("进入MenuModify方法了");
		menuService.Menumodify(menu);
		System.out.println("执行完MenuModify方法了");
		return "forward:MenuManage.action?now2=1&&next=0&&last=0&&flag=0";

	}
	//-------------MenuRole逻辑管理-----------------
    
	//-------------MenuRole逻辑管理-----------------	
	
	@RequestMapping("/MenuRoleEdit")
	public String MenuRoleEdit(Integer rid, ModelMap model) {
		System.out.println("进入MenuRoleEdit方法了");
		Role role = roleService.findOne(rid);
		List<Menu> list = menuService.findAll();
		List<MenuRole> list1 = menuRoleService.findMenuByRole(rid);
		model.addAttribute("Role", role);
		model.addAttribute("Menu", list);
		model.addAttribute("Menu1", list1);
		System.out.println("执行完MenuRoleEdit方法了");
		return "authorizationSet";
	}

	@RequestMapping("/MenuRoleModify")
	public String MenuRoleModify(Integer rid, Integer[] mid, ModelMap model) {
		System.out.println("进入MenuRoleModify方法了");
		MenuRole menuRole = new MenuRole();
		// 此处可能性太多
		System.out.println("-=-=-=-=-="+rid);
		System.out.println("-=-=-=-=-="+mid.length);
		menuRoleService.deleteOneById(rid);
		for (int i = 0; i < mid.length; i++) {
			menuRole = new MenuRole();
			menuRole.setRid(rid);
			menuRole.setMid(mid[i]);
			menuRoleService.save(menuRole);
		}

		System.out.println("执行完MenuRoleModify方法了");
		return "forward:RoleManage.action?now1=1&&next=0&&last=0&&flag=0";

	}

}
