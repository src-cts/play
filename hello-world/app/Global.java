import org.springframework.context.*;
import org.springframework.context.support.*;

import play.*;

@SuppressWarnings("deprecation")
public class Global extends GlobalSettings{

	private static final String APPLICATION_CONTEXT_XML = "application-context.xml";
	private ConfigurableApplicationContext applicationContext;
     
      @Override
      public void beforeStart(Application application) {      
    	    super.beforeStart(application);
    	}

    	@Override
    	public void onStart(Application application) {      
    	    super.onStart(application);     
    	    applicationContext = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML);           
    	}

    	@Override
    	public void onStop(Application application) {       
    	    super.onStop(application);
    	    if(applicationContext != null) {
    	        applicationContext.close();
    	    }
    	}
}