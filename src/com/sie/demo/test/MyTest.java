package com.sie.demo.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.sie.demo.dao.SysUserDao;
import com.sie.demo.entity.SysUser;

public class MyTest {
	@Test
	public void test()
	{
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		SysUserDao sysUserDao=(SysUserDao) applicationContext.getBean("sysUserDao");
		SysUser sysUser=sysUserDao.findOne(8);
		/*SysUser sysUser=new SysUser();*/
		System.out.println(sysUser);
	}
	@Test
	public void testMd5()
	{
		String name1="chad2123";
		String name2=DigestUtils.md5Hex(name1);
		System.out.println(name2.equals(DigestUtils.md5Hex("chad2123")));
	}
	@Test
	public void testDate()
	{
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
		System.out.println(format.format(new Date()));
		System.out.println(new Date());
	}
	@Test
	public void MathCeil()
	{
		Integer pages=(int) Math.ceil(22/10);
		System.out.println(pages);
		System.out.println(Math.ceil(22/10));
		System.out.println((22/10));
		double a=22/10.0;
		System.out.println(a);
		System.out.println(Math.ceil(a));
		System.out.println(Math.ceil(2.2));
	}

}
