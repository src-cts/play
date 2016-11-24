package services;

import javax.inject.Inject;

@org.springframework.stereotype.Service
public class HelloService {

	@Inject
    private HelloServiceImpl helloWorldImpl;

    public String sayHello() {
        return helloWorldImpl.hello();
    }

}