package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.libs.concurrent.HttpExecutionContext;
import play.libs.ws.WSClient;
import play.libs.ws.WSResponse;
import play.mvc.*;
import play.Logger;
import java.util.List;
import play.libs.concurrent.Futures;
import play.libs.Json;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;

public class Parallel extends Controller {

	private HttpExecutionContext ec;
	private WSClient ws;

	@Inject
	public Parallel(HttpExecutionContext ec, WSClient ws) {
		this.ec = ec;
		this.ws = ws;
	}
	
	public CompletionStage<Result> index(){
		final CompletionStage<Timing> yahoo = timed("http://www.yahoo.com");
		final CompletionStage<Timing> google = timed("http://www.google.com");
		final CompletionStage<Timing> bling = timed("http://www.bing.com");
		
		
		CompletionStage<List<Timing>> all = Futures.sequence(yahoo,google,bling);
		
		
		Function<List<Timing>, Result> toResult = (List<Timing> timings)-> { 
			return ok(Json.toJson(timings));
		};
		return all.thenApplyAsync(toResult, ec.current()); 
		
	}
	
	private CompletionStage<Timing> timed(String url){
		final long start = System.currentTimeMillis();
		CompletionStage<WSResponse> wsresponse = ws.url(url).get();
        //System.out.println("response object=="+ok(response.getBody()).as("text/html"));
        Function<WSResponse, Timing> toResult = (WSResponse response)-> { 
    			return new Timing(url, System.currentTimeMillis()- start);
    	};
    	return wsresponse.thenApplyAsync(toResult, ec.current());  
		
	}
	
	
}
