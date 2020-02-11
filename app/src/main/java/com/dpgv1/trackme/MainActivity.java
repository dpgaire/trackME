package com.dpgv1.trackme;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dpgv1.trackme.BLL.LoginBll;
import com.dpgv1.trackme.ServerResponse.LoginSignUpResponse;
import com.dpgv1.trackme.StrickMode.StrickMode;
import com.dpgv1.trackme.api.UserAPI;
import com.dpgv1.trackme.model.CreateChannel;
import com.dpgv1.trackme.model.UserLogin;
import com.dpgv1.trackme.url.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
private TextView etRegister;
private EditText Username,etPassword;
private Button btnLogin;
    private NotificationManagerCompat notificationManagerCompat;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel channel = new CreateChannel(this);
        channel.createChannel();
        binding();
        validation();
        etRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();

            }
        });
    }
    public void binding(){
        Username=findViewById(R.id.etusernamelogin);
        etPassword=findViewById(R.id.etPasswordLogin);
        btnLogin=findViewById(R.id.btnLogin);
        etRegister=findViewById(R.id.ettRegister);

    }

    public void validation(){
        if (TextUtils.isEmpty(Username.getText().toString())) {
            Username.setError("Please enter username");
            Username.requestFocus();

        }
        if (TextUtils.isEmpty(etPassword.getText().toString())) {
            etPassword.setError("Please enter password");
            etPassword.requestFocus();

        }
    }
    public void login() {
        String username = Username.getText().toString();
        String password = etPassword.getText().toString();

        LoginBll loginBll = new LoginBll();
        StrickMode.StrictMode();
        if(loginBll.checkUser(username,password)){
            Intent intent=new Intent(MainActivity.this,DashboardActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Sucess", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(this, "Fucking error", Toast.LENGTH_SHORT).show();
        }
    }
    int id=1;
    private void DisplayNotification(){
//        Notification notification = new NotificationCompat.Builder(this, CreateChannel.CHANNEL_1)
//                .setSmallIcon(R.drawable.ic_sms_black_24dp)
//                .setContentTitle("First Message")
//                .setContentText("First Message body")
//                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
//                .build();
//
//        notificationManagerCompat.notify(id, notification);
//        id++;
    }

}
