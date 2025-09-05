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

    @GetMapping("/home/plus")
    @ResponseBody
    // @ResponseBody: 아래 메서드 실행 후 리턴값을 body에 반응해줘
    public int showPlus(
            // @RequestParam: int a는 쿼리스트링에서 a값을 얻은 후 정수화한 값이다
            @RequestParam(required = false, defaultValue = "1") int a,
            @RequestParam(defaultValue = "0") int b){
        return a * b;
    }

    @GetMapping("/home/returnBoolean")
    @ResponseBody
    public boolean showBoolean(){
        return true;
    }

    @GetMapping("/home/returnDouble")
    @ResponseBody
    public double showDouble(){
        return Math.PI;
    }

    @GetMapping("/home/returnIntList")
    @ResponseBody
    public List<Integer> showIntArray(){
        List<Integer> list = new ArrayList<>() {{
            add(10);
            add(20);
            add(30);
        }};
        return list;
    }

    @GetMapping("/home/returnMap")
    @ResponseBody
    public Map<String, Object> showReturnMap(){
        Map<String, Object> map = new LinkedHashMap<>() {{
            put("id", 1);
            put("speed", 100);
            put("name", "아반떼");
            put("relateIds", new ArrayList<>() {{
                add(1);
                add(2);
                add(3);
            }});
        }};
        return map;
    }

    class Car {
        private final int id;
        private final int speed;
        private final String name;
        private final List<Integer> relatedIds;

        public Car(int id, int speed, String name, List<Integer> relatedIds) {
            this.id = id;
            this.speed = speed;
            this.name = name;
            this.relatedIds = relatedIds;
        }

        public int getId() {
            return id;
        }

        public int getSpeed() {
            return speed;
        }

        public String getName() {
            return name;
        }

        public List<Integer> getRelatedIds() {
            return relatedIds;
        }
    }

    @GetMapping("/home/returnCar")
    @ResponseBody
    public Car showReturnCar(){
        Car car = new Car(1, 100, "아반떼", new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
        }});

        return car;
    }

    /* lombok 사용: @AllArgsConstructor, @Getter, @Setter */
    @AllArgsConstructor
    @Getter
    class Car2 {
        private int id;
        private int speed;
        @Setter
        private String name;
        private List<Integer> relatedIds;
    }

    @GetMapping("/home/returnCar2wLombok")
    @ResponseBody
    public Car2 showReturnCar2(){
        Car2 car2 = new Car2(1, 100, "아반떼", new ArrayList<>() {{
            add(10);
            add(2);
            add(3);
        }});

        car2.setName(car2.getName() + "v2");

        return car2;
    }

    @GetMapping("/home/returnMapList")
    @ResponseBody
    public List<Map<String, Object>> showReturnMapList(){

        Map<String, Object> Map1 = new LinkedHashMap<>() {{
            put("id", 1);
            put("speed", 100);
            put("name", "산타페");
            put("relateIds", new ArrayList<>() {{
                add(1);
                add(2);
                add(3);
            }});
        }};

        Map<String, Object> Map2 = new LinkedHashMap<>() {{
            put("id", 2);
            put("speed", 200);
            put("name", "산타페");
            put("relateIds", new ArrayList<>() {{
                add(4);
                add(5);
                add(6);
            }});
        }};

        List<Map<String, Object>> list = new ArrayList<>();
        list.add(Map1);
        list.add(Map2);

        return list;
    }

}
