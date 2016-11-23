package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class HelloWorld extends Controller {
	
	public Result index(String name,int age) {
        return ok(views.html.hello.render(name,age));
    }
	
}
