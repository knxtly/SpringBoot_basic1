package com.practice.basic1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/*
http://localhost:8080/home/addPerson?name=홍길동&age=11
http://localhost:8080/home/addPerson?name=홍길순&age=22
http://localhost:8080/home/addPerson?name=임꺽정&age=33
http://localhost:8080/home/people
http://localhost:8080/home/removePerson?id=2
http://localhost:8080/home/people
 */


@Controller
public class HomeController {
    private static List<Person> people = new ArrayList<>();
    private static int peopleCnt;
    static {
        peopleCnt = 0;
    }
    @AllArgsConstructor
    @ToString
    @Getter
    @Setter
    class Person {
        private int id;
        private String name;
        private int age;
    }

    @GetMapping("/home/addPerson")
    @ResponseBody
    public String showAddPerson(@RequestParam String name, @RequestParam int age) {
        Person p = new Person(peopleCnt, name, age);
        System.out.println(p);
        peopleCnt++;
        people.add(p);
        return peopleCnt + "번 사람이 추가되었습니다.";
    }

    @GetMapping("/home/people")
    @ResponseBody
    public List<Person> showPeople() {
        return people;
    }

    @GetMapping("/home/removePerson")
    @ResponseBody
    public String removePerson(@RequestParam int id) {
        boolean removed = people.removeIf(person -> person.getId() == id);
        if (removed) {
            return id + "번 사람이 삭제되었습니다.";
        }
        else return id + "번 사람이 없습니다.";
    }
}
