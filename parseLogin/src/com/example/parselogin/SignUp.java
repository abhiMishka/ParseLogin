package com.example.parselogin;



import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends Activity implements OnClickListener {
	
	
	private Button SignUpButton;
	
	private EditText UserName;
	
	private EditText Password;
	
	private EditText ConfirmPassword;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_up);
		
		Parse.initialize(this, "uFwoSCU42NKWz1hxvQHqPjrCxxJdkXcREOYsAEyu", "KjJIMTP5UY32FVo6yTw1ONk9Icl40DO7fSIuEPVk");

		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();
			
		defaultACL.setPublicReadAccess(true);

		ParseACL.setDefaultACL(defaultACL, true);
		
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
			Intent nextScreen = new Intent(getApplicationContext(), Failure.class);            	
      		startActivity(nextScreen);		
		}
		
		else{
			 final ProgressDialog dialog = new ProgressDialog(SignUp.this);
		        dialog.setTitle("Connecting you !!!");
		        dialog.setMessage("Have patience...signing up :)");
		        dialog.show();
		        
		   
		        ParseUser user = new ParseUser();
		        user.setUsername(UserName.getText().toString());
		        user.setPassword(Password.getText().toString());
		        
		        user.signUpInBackground(new SignUpCallback() {

		            @Override
		            public void done(ParseException e) {
		              dialog.dismiss();
		              if (e != null) {
		                // Show the error message
		                Toast.makeText(SignUp.this, e.getMessage(), Toast.LENGTH_LONG).show();
		              } else {
		                // Start an intent for the dispatch activity
		                Intent intent = new Intent(SignUp.this, Welcome.class);
		                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
		                startActivity(intent);
		              }
		            }
		        });


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
