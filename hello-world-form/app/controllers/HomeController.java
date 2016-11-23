package controllers;

import javax.inject.Inject;

import models.Employee;
import play.data.Form;
import play.data.FormFactory;


import play.mvc.*;
import views.html.*;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
	
	@Inject
	private FormFactory factory;
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        //return ok(index.render("Your new application is ready."));
    	return ok(views.html.formtest.render("User Form"));
    }
    
    public Result showParam(String name,String age){
    	return ok(views.html.show.render(name,age));
    }
    
    public Result parseEmployee(){
    	Form<Employee> form = factory.form(Employee.class);
    	Employee employee = form.bindFromRequest().get();
    	return redirect(routes.HomeController.showParam(employee.getName(),employee.getAge()));
    	
    }
}
