/*package controllers;

import play.libs.F;
import play.libs.ws.WS;
import play.mvc.Controller;
import play.mvc.Http.Response;
import play.mvc.Result;
import akka.japi.Function;

public class Proxy extends Controller {

	public Result index(String url) {

		F.Promise<Response> response = WS.url(url).get();
		F.Promise<Result> result = response.map();
		return async(result); 

	}

	private static Function<Response, Result> toResult = new Function<Response, Result>() {
		public Result apply(Response response) {
			return ok(response.getBody()).as("test/html");
		}
	};

}
*/