package tom.spring.hellospring.controller;

import org.springframework.web.bind.annotation.*;
import tom.spring.hellospring.domain.User;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OtherHttpController {
    private Map<String, Object> params = new HashMap<>();

    // 提交
    @PostMapping("/post/testUser")
    public Object test_user_post(@RequestBody User user) {
        params.clear();
        params.put("user", user);

        return params;
    }

    // 更新
    @PutMapping("/put/testUser")
    public Object test_user_put(@RequestBody User user) {
        params.clear();
        params.put("user", user);
        return params;
    }

    // 删除
    @DeleteMapping("/del/testUser")
    public Object test_user_del(@RequestBody User user) {
        params.clear();
        params.put("user", user);
        return params;
    }
}
