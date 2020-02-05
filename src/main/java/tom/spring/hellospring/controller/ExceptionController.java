package tom.spring.hellospring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tom.spring.hellospring.domain.MyException;
import tom.spring.hellospring.domain.User;

@RestController
public class ExceptionController {

    @RequestMapping("/v1/test_ext")
    public Object index() {
        int a = 1/0;
        return new User("xiapmi", 19, 1);
    }

    @RequestMapping("/v1/myext")
    public Object myexc() {
        throw new MyException("500", "my ext 异常");
    }
}
