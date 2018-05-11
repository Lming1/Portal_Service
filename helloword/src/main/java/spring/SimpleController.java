package spring;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@org.springframework.stereotype.Controller("/helloworld")
public class SimpleController implements Controller {


    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("hello", "Hello World!!!");
        return modelAndView;
    }
}
