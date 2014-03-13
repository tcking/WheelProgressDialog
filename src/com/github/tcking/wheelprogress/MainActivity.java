package com.github.tcking.wheelprogress;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	private Handler handler;
	private WheelProgressDialog wheelProgressDialog;
	int progress=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		handler=new Handler();
		wheelProgressDialog=new WheelProgressDialog(this);
		wheelProgressDialog.message("game on !").show();
		test();
	}
	
	private void test(){
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				wheelProgressDialog.progress(++progress).message(progress>=100?"mission complete":"processing:"+progress);
				if(progress<=100){
					test();
				}
			}
		}, 100);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
