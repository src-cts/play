package controllers;

import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;

import play.mvc.Controller;
import play.mvc.Result;
import services.HelloService;
import views.html.*; 

public class Application extends Controller {

    @Inject
    private HelloService helloService;

    public Result index() {
        return ok(index.render(helloService.sayHello()));
    }

}