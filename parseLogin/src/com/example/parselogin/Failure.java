package com.example.parselogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Failure extends Activity implements OnClickListener {
	
	private Button TryAgainButton;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup_failed);		
		
		TryAgainButton = (Button) findViewById(R.id.button1);  
		
		TryAgainButton.setOnClickListener(this);
		
	}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent nextScreen = new Intent(getApplicationContext(), SignUp.class);            	
  		startActivity(nextScreen);
		
	}

}
