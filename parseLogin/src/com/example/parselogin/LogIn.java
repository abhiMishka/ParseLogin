package com.example.parselogin;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LogIn extends Activity implements OnClickListener {
	
	
	private Button LoginButton;
	
	private EditText UserName;
	
	private EditText Password;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.log_in);
		
		LoginButton = (Button) findViewById(R.id.button1);  
		
		LoginButton.setOnClickListener(this);
	}
	

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}

}
