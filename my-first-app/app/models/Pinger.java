/*package models;

import play.*;
import play.mvc.*;
import play.libs.*;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Pinger extends UntypedActor {
    
	 	public static Props props(ActorRef out) {
	        return Props.create(Pinger.class, out);
	    }

	    private final ActorRef out;

	    public Pinger(ActorRef out) {
	        this.out = out;
	    }
	    
	    public void onReceive(Object message) throws Exception {
	    	if (message.equals("Tick")) {
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	            Calendar cal = Calendar.getInstance();
	            out.write(sdf.format(cal.getTime()));
	        } else {
	            unhandled(message);
	        }
	    }
	
	WebSocket.In<String> in;
    WebSocket.Out<String> out;
	
    public Pinger(WebSocket.In<String> in, WebSocket.Out<String> out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public void onReceive(Object message) {
        if (message.equals("Tick")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            out.write(sdf.format(cal.getTime()));
        } else {
            unhandled(message);
        }
    }
}*/