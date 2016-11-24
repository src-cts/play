package services;

import org.springframework.stereotype.Repository;

@Repository
public class HelloServiceImpl {

	public String hello() {
		return "Hello world!";
	}

}
