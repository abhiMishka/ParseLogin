package com.example.parselogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends Activity implements OnClickListener {
	
	
	private Button SignUpButton;
	
	private EditText UserName;
	
	private EditText Password;
	
	private EditText ConfirmPassword;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_up);
		
		UserName = (EditText) findViewById(R.id.editText1);
		
		Password = (EditText) findViewById(R.id.editText2);
		
		ConfirmPassword = (EditText) findViewById(R.id.editText3);
		
		SignUpButton = (Button) findViewById(R.id.button1);  
		
		SignUpButton.setOnClickListener(this);
	}
	

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		if(confirm(Password,ConfirmPassword)||checkEmpty(UserName,Password,ConfirmPassword)){
			  Intent i = new Intent ("android.intent.action.Failure");
              startActivity(i);			
		}
		
	}
	
	public static boolean confirm(EditText pass1,EditText pass2){
		if(pass1.getText().toString().equals(pass1.getText().toString())){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean checkEmpty(EditText username,EditText pass1,EditText pass2){
		if(username.getText().toString().isEmpty()||username.getText().toString().isEmpty()
				||username.getText().toString().isEmpty()){
			return true;
		}
		else{
		return false;
		}
	}

}
