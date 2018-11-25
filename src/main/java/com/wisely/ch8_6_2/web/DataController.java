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
	
	@RequestMapping("/set")	//1����ʾ�����ַ�������
	public void set() {
		Person person = new Person("1", "mask", 22);
		personDao.save(person);
		personDao.stringRedisTemplateDemo();
	}
	
	@RequestMapping("/getStr")	//2����ʾ����ַ�
	public String getStr() {
		return personDao.getString();
	}
	
	@RequestMapping("/getPerson")	//3����ʾ��ö���
	public Person getPerson() {
		return personDao.getPerson();
	}
}
