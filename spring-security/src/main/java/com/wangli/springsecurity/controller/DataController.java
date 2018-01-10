package com.wangli.springsecurity.controller;

import com.wangli.springsecurity.dao.PersonRepository;
import com.wangli.springsecurity.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangli
 */
@RestController
public class DataController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/save")
    public Person save(String name, String address, Integer age) {
        Person person = personRepository.save(new Person(null, name, age, address));
        return person;
    }

    @RequestMapping("/q1")
    public List<Person> q1(String address) {
        List<Person> list = personRepository.findByAddress(address);
        return list;
    }


}
