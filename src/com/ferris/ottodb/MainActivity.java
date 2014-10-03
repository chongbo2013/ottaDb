package com.ferris.ottodb;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.ferris.otto.Produce;
import com.ferris.otto.app.BusProvider;


public class MainActivity extends FragmentActivity {
	private Button button1,button2;
	private int index=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=(Button) findViewById(R.id.button1);
        button2=(Button) findViewById(R.id.button2);
        button1.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 index=0;
				 BusProvider.getInstance().post(new DataBaseClear());

			}
		});
        button2.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 index+=1;
				 BusProvider.getInstance().post(produceLocationEvent());
			}
		});
    }
    @Override 
    protected void onResume() {
        super.onResume();
        // Register ourselves so that we can provide the initial value.
        BusProvider.getInstance().register(this);
      }

      @Override 
      protected void onPause() {
        super.onPause();

        // Always unregister when an object no longer should be on the bus.
        BusProvider.getInstance().unregister(this);
      }
      
      @Produce 
      public DataBaseChange produceLocationEvent() {
    	    // Provide an initial value for location based on the last known position.
    	    return new DataBaseChange("name"+index, "age"+index);
    	  }
  
}
