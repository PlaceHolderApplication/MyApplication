package com.xterstar.www.placeholder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


public class Login extends AppCompatActivity {
    //LoginButton loginButton;
    //TextView textView;
    //CallbackManager callbackManager;

    CallbackManager callbackManager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.facebook_login);
        callbackManager = CallbackManager.Factory.create();
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);

        if (isLoggedIn()) {
            Intent intent = new Intent(Login.this, TTest.class);
            Login.this.startActivity(intent);
        }



        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent intent = new Intent(Login.this, TTest.class);

                //startActivity(intent);
                Login.this.startActivity(intent);

            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }




        });


        //Link to Register
        final EditText editUsername = (EditText) findViewById(R.id.editUsername);
        final EditText editPassword = (EditText) findViewById(R.id.editPassword);

        final Button editLogin = (Button) findViewById(R.id.editLogin);
        final TextView registerLink = (TextView) findViewById(R.id.textRegisterhere);

        registerLink.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                Intent registerIntent = new Intent(Login.this, Register.class);
                Login.this.startActivity(registerIntent);


            }


        });

        //Link from login to Home page
        editLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent registerIntent = new Intent(Login.this, TTest.class);
                Login.this.startActivity(registerIntent);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public boolean isLoggedIn() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        return accessToken != null;
    }
}

/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.facebook_login);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        textView = (TextView) findViewById(R.id.textView);
        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onActivityResult(int requestCode, int resultCode, Intent data) {
                super.onActivityResult(requestCode, resultCode, data);
                callbackManager.onActivityResult(requestCode, resultCode, data);
            }

            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent intent = new Intent(Login.this, TTest.class);
                startActivity(intent);
                Login.this.startActivity(intent);


                //textView.setText("Login Success \n" + loginResult.getAccessToken().getUserId() +
                //"\n"+loginResult.getAccessToken().getToken());
            }

            @Override
            public void onCancel() {
                textView.setText("Login Cancelled");
            }

            @Override
            public void onError(FacebookException error) {

            }

        });

    }
}
*/
/*

        final EditText editUsername = (EditText) findViewById(R.id.editUsername);
        final EditText editPassword = (EditText) findViewById(R.id.editPassword);

        final Button editLogin = (Button) findViewById(R.id.editLogin);
        final TextView registerLink = (TextView) findViewById(R.id.textRegisterhere);

        registerLink.setOnClickListener(new View.OnClickListener()
                                        {
                                            public void onClick(View v){
                                                Intent registerIntent = new Intent(Login.this, Register.class);
                                                Login.this.startActivity(registerIntent);


                                            }


                                        }




        );


        editLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent registerIntent = new Intent(Login.this,TTest.class);
                Login.this.startActivity(registerIntent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

}

super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        final EditText editUsername = (EditText) findViewById(R.id.editUsername);
        final EditText editPassword = (EditText) findViewById(R.id.editPassword);

        final Button editLogin = (Button) findViewById(R.id.editLogin);
        final TextView registerLink = (TextView) findViewById(R.id.textRegisterhere);

        registerLink.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                Intent registerIntent = new Intent(Login.this, Register.class);
                Login.this.startActivity(registerIntent);


            }


        }




        );


        editLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent registerIntent = new Intent(Login.this, test.class);
                Login.this.startActivity(registerIntent);
            }
        });

*/