package com.practice.basic1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;


@Controller
public class HomeController {
    private static List<Person> people = new ArrayList<>();

    @AllArgsConstructor
    @Getter
    @Setter
    class Person {
        private static int peopleCnt;
        private int id;
        private String name;
        private int age;

        static {
            peopleCnt = 0;
        }
    }

    @GetMapping("/home/addPerson")
    @ResponseBody
    public String showAddPerson(@RequestParam String name, @RequestParam int age) {
        Person.peopleCnt++;
        people.add(new Person(Person.peopleCnt, name, age));
        System.out.println(Person.peopleCnt);
        return Person.peopleCnt + "번 사람이 추가되었습니다.";
    }

    @GetMapping("/home/people")
    @ResponseBody
    public List<Person> showPeople() {
        return people;
    }
}
