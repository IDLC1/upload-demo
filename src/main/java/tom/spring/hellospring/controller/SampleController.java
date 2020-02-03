package tom.spring.hellospring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tom.spring.hellospring.domain.Student;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
//@Controller
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World";
    }

    @RequestMapping("/test")
    public Map<String,String> testMap() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "xiaozhang");
        map.put("age", "18");
        return map;
    }

    @RequestMapping("/testjson")
    public Object testJson() {
        return new Student(18, "xiaoding", "1802013213", new Date());
    }
}
