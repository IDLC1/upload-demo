package tom.spring.hellospring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tom.spring.hellospring.domain.ResponseData;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class fileController {
//    private static final String filePath = "E:/study/Java/hello-spring/src/main/resources/static/images/";
    private static final String filePath = "/usr/local/sample_demo01/upload/";

    @RequestMapping("/upload")
    public ResponseData upload(@RequestParam("head_img")MultipartFile file, HttpServletRequest request) {
        String name = request.getParameter("name");
        System.out.println("用户名： " + name);

        // 获取文件名
        String fileName = file.getOriginalFilename();
        System.out.println("上传的文件名为： " + fileName);

        // 获取文件名的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传的后缀名为： " + suffixName);

        // 获取文件上传的路径
        fileName = UUID.randomUUID() + suffixName;
        System.out.println("转换后的名称为： " + fileName);
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            return new ResponseData(0, "/upload/" + fileName);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseData(-1, null, "上传失败");
    }
}
