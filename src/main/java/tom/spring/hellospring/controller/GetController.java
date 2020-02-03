package tom.spring.hellospring.controller;


import org.springframework.web.bind.annotation.*;
import tom.spring.hellospring.domain.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class GetController {
    private Map<String, Object> params = new HashMap<>();

//    @GetMapping(path = "/{city_id}/{user_id}")
//    public Object findUser(@PathVariable("city_id") String cityId, @PathVariable("user_id") String userId) {
//        params.clear();
//        params.put("cityId", cityId);
//        params.put("userId", userId);
//        return params;
//    }

    @GetMapping(path = "/v1/page_user")
    public Object findUser(int from, int to) {
        params.clear();
        params.put("from", from);
        params.put("to", to);
        return params;
    }

    @GetMapping(path = "/v2/page_user")
    public Object page_from(@RequestParam(defaultValue = "0", name="key") int from, int to) {
        params.clear();
        params.put("from", from);
        params.put("to", to);
        return params;
    }

    /*
    *  使用bean对象传参
    *  使用body传输数据
    */
    @PostMapping("/v2/save_user")
    public Object save_user(@RequestBody User user) {
        params.clear();
        params.put("user", user);
        return params;
    }

    @GetMapping("/v2/get_header")
    public Object save_user(@RequestHeader("access_token") String accessToken, String id) {
        params.clear();
        params.put("accessToken", accessToken);
        params.put("id", id);
        return params;
    }

    // 使用servlet方式获取参数
    @GetMapping("/v2/test_header")
    public Object test_user(HttpServletRequest request) {
        params.clear();
        String id = request.getParameter("id");
        params.put("id", id);
        return params;
    }
}
