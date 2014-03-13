package com.github.tcking.wheelprogress;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.todddavies.components.progressbar.ProgressWheel;

public class WheelProgressDialog extends AlertDialog{
	private ProgressWheel mWheelView;
	private TextView mMessageView;
	private String message;
	private int progress;

	public WheelProgressDialog(Context context) {
		super(context);
	}
	
	public WheelProgressDialog(Context context,int theme) {
		super(context,theme);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		LayoutInflater inflater = LayoutInflater.from(getContext());
		View v = inflater.inflate(R.layout.wheel_progress_dialog, null);
		mWheelView=(ProgressWheel) v.findViewById(R.id.progress);
		mMessageView=(TextView)v.findViewById(R.id.message);
		setView(v);
		mWheelView.setText("0%");
		super.onCreate(savedInstanceState);
	}
	
	
	public int getProgress(){
		return progress;
	}
	
	
	public WheelProgressDialog message(String message){
		this.message=message;
		if(mMessageView!=null){
			mMessageView.setText(message);
		}
		return this;
	}
	
	public WheelProgressDialog title(String title){
		setTitle(title);
		return this;
	}

	@Override
	public void show() {
		super.show();
		mWheelView.setProgress(progress);
		mMessageView.setText(message);
	}

	public WheelProgressDialog progress(int value) {
		if(value<0){
			value=0;
		}
		if(value>100){
			value=100;
		}
		this.progress=value*360/100;
		if(mWheelView!=null){
			mWheelView.setProgress(progress);
			mWheelView.setText(value+"%");
		}
		return this;
	}
	
	

}
