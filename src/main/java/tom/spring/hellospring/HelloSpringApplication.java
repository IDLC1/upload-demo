package tom.spring.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;
import org.springframework.web.bind.annotation.*;
import tom.spring.hellospring.domain.Person;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@RestController
@ServletComponentScan
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

	@RequestMapping(value = "/hello", method= RequestMethod.POST)
	public String hello(Person p) {
		return "name = " + p.name + " age = " + p.age;
	}

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		// 设置单个文件最大
		factory.setMaxFileSize(DataSize.parse("1024KB"));
		// 设置总上传数据总大小
		factory.setMaxRequestSize(DataSize.parse("10240KB"));
		return factory.createMultipartConfig();
	}
}
