package com.wisely.ch8_6_2.domain;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import com.wisely.ch8_6_2.dao.Person;

@Repository
public class PersonDao {
	@Autowired 
	StringRedisTemplate stringRedisTemplate;	//1��SpringBoot��Ϊ��������StringRedisTemplate���ڴ˴�����ֱ��ע��
	
	@Autowired
	RedisTemplate<Object, Object> redisTemplate;	//2��SpringBoot��Ϊ��������RedisTemplate���ڴ˴�����ֱ��ע��
	
	@Resource(name="stringRedisTemplate")
	ValueOperations<String, String> valOpsStr;	//3������ʹ��@Resourceע��ָ��stringRedisTemplate,��ע������ַ����ļ����Բ���������
	
	@Resource(name="redisTemplate")
	ValueOperations<Object, Object> valOps;		//4������ʹ��@Resourceע��ָ��redisTemplate����ע����ڶ���ļ����Բ�������
	
	public void stringRedisTemplateDemo() {	//5��ͨ��set�������洢�ַ������͡�
		valOpsStr.set("xx", "yy");
	}
	
	public void save(Person person) {
		valOps.set(person.getId(), person);	//6��ͨ��set�������洢�������͡�
	}
	
	public String getString() {
		return valOpsStr.get("xx");	//7��ͨ��get����������ַ�����
	}
	
	public Person getPerson() {
		return (Person) valOps.get("1");	//8��ͨ��get��������ö���
	}
}
