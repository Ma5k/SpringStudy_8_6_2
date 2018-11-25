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
	StringRedisTemplate stringRedisTemplate;	//1、SpringBoot已为我们配置StringRedisTemplate，在此处可以直接注入
	
	@Autowired
	RedisTemplate<Object, Object> redisTemplate;	//2、SpringBoot已为我们配置RedisTemplate，在此处可以直接注入
	
	@Resource(name="stringRedisTemplate")
	ValueOperations<String, String> valOpsStr;	//3、可以使用@Resource注解指定stringRedisTemplate,可注入基于字符串的简单属性操作方法。
	
	@Resource(name="redisTemplate")
	ValueOperations<Object, Object> valOps;		//4、可以使用@Resource注解指定redisTemplate，可注入基于对象的简单属性操作方法
	
	public void stringRedisTemplateDemo() {	//5、通过set方法，存储字符串类型。
		valOpsStr.set("xx", "yy");
	}
	
	public void save(Person person) {
		valOps.set(person.getId(), person);	//6、通过set方法，存储对象类型。
	}
	
	public String getString() {
		return valOpsStr.get("xx");	//7、通过get方法，获得字符串。
	}
	
	public Person getPerson() {
		return (Person) valOps.get("1");	//8、通过get方法，获得对象。
	}
}
