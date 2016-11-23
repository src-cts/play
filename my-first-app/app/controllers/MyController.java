package controllers;

import play.libs.concurrent.HttpExecutionContext;
import play.libs.ws.WSClient;
import play.libs.ws.WSResponse;
import play.mvc.*;
import play.Logger;

import javax.inject.Inject; 
import java.util.concurrent.CompletionStage;
import java.util.function.Function;

public class MyController extends Controller {
    private HttpExecutionContext ec;
    private WSClient ws;

    @Inject
    public MyController(HttpExecutionContext ec, WSClient ws) {
        this.ec = ec;
        this.ws = ws;
    }

    /*public CompletionStage<Result> index() {
    	Logger.info("Before the Http Call");
        String checkUrl = request().getQueryString("url");
        //System.out.println("checkUrl=="+checkUrl);
        CompletionStage<WSResponse> wsresponse = ws.url(checkUrl).get();
        //System.out.println("response object=="+ok(response.getBody()).as("text/html"));
        Function<WSResponse, Result> toResult = (WSResponse response)-> { 
        		Logger.info("Inside the function Call");
    			return ok(response.getBody()).as("text/html");
    	};
    	Logger.info("After the Http Call");
    	return wsresponse.thenApplyAsync(toResult, ec.current());
        return wsresponse.thenApplyAsync((response) -> {
            //session().put("lastStatus", Integer.toString(response.getStatus()));
            return ok(response.getBody()).as("text/html");
        }, ec.current()); 
    }*/
    
    public CompletionStage<Result> index() {
    	
    	Logger.info("Before the Http Call");
        String checkUrl = request().getQueryString("url");
        //System.out.println("checkUrl=="+checkUrl);
        CompletionStage<WSResponse> wsresponse = ws.url(checkUrl).get();
        //System.out.println("response object=="+ok(response.getBody()).as("text/html"));
        Function<WSResponse, Result> toResult = (WSResponse response)-> { 
        		Logger.info("Inside the function Call");
    			return ok(response.getBody()).as("text/html");
    	};
    	Logger.info("After the Http Call");
    	return wsresponse.thenApplyAsync(toResult, ec.current());
       /* return wsresponse.thenApplyAsync((response) -> {
            //session().put("lastStatus", Integer.toString(response.getStatus()));
            return ok(response.getBody()).as("text/html");
        }, ec.current()); */
    }
    
    public Result testMe() {
    	//writeSessionValue();
    	return readSessionValue();
    }
    private Result readSessionValue() {
        String user = session("connected");
        if(user != null) {
            return ok("Hello " + user);
        } else {
            return unauthorized("Oops, you are not connected");
        }
    }
    
    public Result writeSessionValue() {
        session("connected","user@email.com");
        return ok("Session data Saved");
    }
    
    /*
    public CompletionStage<Result> index() {
        String checkUrl = request().getQueryString("url");
        System.out.println("checkUrl=="+checkUrl);
        CompletionStage<WSResponse> wsresponse = ws.url(checkUrl).get();
        //System.out.println("response object=="+ok(response.getBody()).as("text/html"));
        return wsresponse.thenApplyAsync((response) -> {
            //session().put("lastStatus", Integer.toString(response.getStatus()));
            return ok(response.getBody()).as("text/html");
        }, ec.current());
    }*/
}