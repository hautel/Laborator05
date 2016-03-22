package ro.pub.cs.systems.eim.lab05.boundedserviceactivity.service;

import java.util.Random;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import ro.pub.cs.systems.eim.lab05.boundedserviceactivity.general.Constants;

public class BoundedService extends Service {

	final private IBinder boundedServiceBinder = new BoundedServiceBinder();
	final private Random random = new Random();
	
	  public class BoundedServiceBinder extends Binder {
	    public BoundedService getService() {
	      return BoundedService.this;
	    }
	  }
    // TODO: exercise 9f - override the lifecycle callback methods and log a message
    // of the moment they are invoked
  @Override
    public void onCreate() {
        super.onCreate();
        Log.d(Constants.TAG, "onCreate() method from service was invoked");
    }

	  @Override
	  public boolean onUnbind(Intent intent) {
	      Log.d(Constants.TAG, "onUnbind() method was invoked");
	      return super.onUnbind(intent);
	  }
	
	  @Override
	  public void onDestroy() {
	      Log.d(Constants.TAG, "onDestroy() method from service was invoked");
	      super.onDestroy();
	  }
  
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(Constants.TAG, "onBind() method was invoked");
        return boundedServiceBinder;
    }

    public String getMessage() {
        // TODO: exercise 9b - return a random value from the Constants.MESSAGES array list
        
    	return Constants.MESSAGES.get(random.nextInt(Constants.MESSAGES.size()));
    }
}
