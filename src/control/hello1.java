package control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.lang.annotation.Annotation;

@Controller
public class hello1 implements Controller {
    @Override
    @RequestMapping("/hello")
    public String value() {
        //model.addAttribute("msg","hello");
        System.out.println("fdfg");
        return "hello";
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
