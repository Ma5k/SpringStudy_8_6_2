package com.wisely.ch8_6_2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisely.ch8_6_2.dao.Person;
import com.wisely.ch8_6_2.domain.PersonDao;

@RestController
public class DataController {
	
	@Autowired
	PersonDao personDao;
	
	@RequestMapping("/set")	//1、演示设置字符及对象
	public void set() {
		Person person = new Person("1", "mask", 22);
		personDao.save(person);
		personDao.stringRedisTemplateDemo();
	}
	
	@RequestMapping("/getStr")	//2、演示获得字符
	public String getStr() {
		return personDao.getString();
	}
	
	@RequestMapping("/getPerson")	//3、演示获得对象
	public Person getPerson() {
		return personDao.getPerson();
	}
}
