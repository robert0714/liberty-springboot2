package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
	@Autowired
    private ApplicationContext context ;
	
    @RequestMapping("/hello")
    public String hello() {
    	String id = session() .getId();
    	System.out.println("id: "+id);
        return "Greetings from Spring Boot!";
    }
    public static HttpSession session() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(true); // true == allow create
    }
}
