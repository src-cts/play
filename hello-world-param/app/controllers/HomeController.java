package controllers;

import play.Play;
import play.mvc.*;
import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    //Pass one param as String
    public Result helloName(String name){
    	
    	return ok(views.html.name.render(name));
    	
    }
    
    //pass two params as String and Int
    public Result helloNameAge(String name, int age){
    	
    	return ok(views.html.nameage.render(name,age));
    }
    
    //retrieve application config param
    public Result getConfig(){
    	String propertyconfig= Play.application().configuration().getString("play.expertise.level");
    	return ok(views.html.config.render(propertyconfig));
    }
}
