package controllers;

import static java.util.concurrent.TimeUnit.SECONDS;
import models.MyWebSocketActor;
import play.libs.Akka;
import play.libs.F.*;
import play.mvc.Controller;
import play.mvc.LegacyWebSocket;
import play.mvc.Result;
import play.mvc.WebSocket;
import scala.concurrent.duration.Duration;
import views.html.index;
import akka.actor.ActorRef;
import akka.actor.Cancellable; 
import akka.actor.Props;

public class Application extends Controller {
	 
	
	public  LegacyWebSocket<String> socket() {
	    return WebSocket.withActor(MyWebSocketActor::props);
	}
    /*public  LegacyWebSocket<String> pingWs() {
        return WebSocket.whenReady((WebSocket.In<String> in, WebSocket.Out<String> out)-> {
                final ActorRef pingActor = Akka.system().actorOf(Props.create(Pinger.class, in, out));
                final Cancellable cancellable = Akka.system().scheduler().schedule(Duration.create(1, SECONDS),
                                                   Duration.create(1, SECONDS),
                                                   pingActor,
                                                   "Tick",
                                                   Akka.system().dispatcher(),
                                                   null
                                                   );
                
                	in.onClose(new Callback() {
                	
                	@Override
                	public void invoke() throws Throwable {
                		cancellable.cancel();
                	}
                });
        });
    }

    public  Result pingJs() {
        return ok(views.js.ping.render());
    }

    public  Result index() {
        return ok(index.render());
    }*/
}