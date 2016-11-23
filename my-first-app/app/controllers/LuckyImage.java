package controllers;

import javax.inject.Inject;

import play.Logger;
import play.libs.concurrent.HttpExecutionContext;
import play.libs.ws.WSClient;
import play.libs.ws.WSResponse;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.concurrent.CompletionStage; 
import java.util.function.Function;


public class LuckyImage extends Controller {

	private HttpExecutionContext ec;
	private WSClient ws;

	@Inject
	public LuckyImage(HttpExecutionContext ec, WSClient ws) {
		this.ec = ec;
		this.ws = ws;
	}

	public CompletionStage<Result> index(String query) {
    	
        String checkUrl = "http://duckduckgo.com";
        //System.out.println("checkUrl=="+checkUrl);
        CompletionStage<WSResponse> wsresponse = ws.url(checkUrl).setQueryParameter("q",query).setQueryParameter("format","json").get();
        
        //System.out.println("response object=="+ok(response.getBody()).as("text/html"));
        Function<WSResponse, Result> toResult = (WSResponse response)-> { 
    			return ok(response.getBodyAsStream()).as(response.getHeader("Content-Type"));
    	};
    	return wsresponse.thenApplyAsync(toResult, ec.current());
       /* return wsresponse.thenApplyAsync((response) -> {
            //session().put("lastStatus", Integer.toString(response.getStatus()));
            return ok(response.getBody()).as("text/html");
        }, ec.current()); */
    }
}
