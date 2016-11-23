package controllers;

public class Timing {
	
	
	public String url;
	public long latency;
	
	Timing(String url, long latency){
		this.url = url;
		this.latency = latency;
	}
}
