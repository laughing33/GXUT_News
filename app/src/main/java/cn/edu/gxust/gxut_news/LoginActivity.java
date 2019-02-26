package cn.edu.gxust.gxut_news;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginActivity extends BaseActivity {
    private EditText accountEdit;
    private EditText passwordEdit;
    //    private TextView logintext;
    private Button login, register, guest;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private CheckBox rememberPass;
    private LinearLayout loading;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d("my", "登陆界面启动");
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("科大新闻");
        setSupportActionBar(toolbar);
//        Intent intent=new Intent(this,GetNews.class);
//        startActivity(intent);
//        GetNews getNews=new

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        accountEdit = findViewById(R.id.account);
        passwordEdit = findViewById(R.id.password);
        progressBar = findViewById(R.id.progress_bar);
//        logintext=findViewById(R.id.login_text);
        rememberPass = findViewById(R.id.remember_pass);
        loading = findViewById(R.id.loading);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        guest = findViewById(R.id.guest);
        boolean isRemember = pref.getBoolean("remember_password", false);
        if (isRemember) {
            String account = pref.getString("account", "");
            String password = pref.getString("password", "");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {//把用户数据添加到litepal数据库中,
//                List<UserMessage> userMessage=DataSupport.select("account","password").find(UserMessage.class);
//                for (UserMessage userMessage1:userMessage){
//                    logintext.setText(userMessage1.getAccount());
//                }
//            }
//        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (accountEdit.getText() != null && passwordEdit.getText() != null) {
                    if (loading.getVisibility() == v.GONE) {
                        loading.setVisibility(v.VISIBLE);
                    } else {
                        loading.setVisibility(v.GONE);
                    }
                    String account = accountEdit.getText().toString();
                    String password = passwordEdit.getText().toString();
                    if (account.equals("admin") && password.equals("123456")) {
//                    logintext.setText("login succeed");

                        Intent intent = new Intent(LoginActivity.this, StartNews.class);
                        startActivity(intent);
                        finish();
                        editor = pref.edit();
                        if (rememberPass.isChecked()) {
                            editor.putBoolean("remember_password", true);
                            editor.putString("account", account);
                            editor.putString("password", password);
                        } else {
                            editor.clear();
                        }
                        editor.apply();
//                    Intent intent =new Intent(LoginActivity.this,OkhttpMainActivity.class);
//                    startActivity(intent);
//                    finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "用户名或者密码错误", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "请输入有效的信息", Toast.LENGTH_SHORT).show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (accountEdit.getText().toString() != null && passwordEdit.getText().toString() != null) {
                    if (loading.getVisibility() == v.GONE) {
                        loading.setVisibility(v.VISIBLE);
                    } else {
                        loading.setVisibility(v.GONE);
                    }
                    LitePal.getDatabase();
                    UserMessage userMessage = new UserMessage();
                    userMessage.setAccount(accountEdit.getText().toString());
                    userMessage.setPassword(Integer.valueOf(passwordEdit.getText().toString()));
                    userMessage.save();
//                logintext.setText("register succeed");
                    if (accountEdit.getText().toString().equals("admin")) {
//                    logintext.setText("该帐户名已经被注册");
                        Toast.makeText(LoginActivity.this, "该帐户名已经被注册", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "请输入有效的信息", Toast.LENGTH_SHORT).show();
                }
            }

        });

        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, StartNews.class);
                startActivity(intent);
                finish();
                Toast.makeText(LoginActivity.this, "游客登陆成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void sendRequestWithOkHttp() {//请求数据
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url("http://10.0.2.2:8008/get_data.json").build();//数据的地址
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    parseJSONWithGSON(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void parseJSONWithGSON(String jsonData) {
        Gson gson = new Gson();
        List<News> newsList = gson.fromJson(jsonData, new TypeToken<List<News>>() {
        }.getType());

        Intent intent = new Intent(LoginActivity.this, NewsTitleFragment.class);
        intent.putExtra("newsList", (Serializable) newsList);
        startActivity(intent);
//        Intent intent = new Intent(LoginActivity.this, NewsTitleFragment.class);
//        Bundle args = new Bundle();
//        args.putSerializable("dataList",(Serializable)newsList);
//        intent.putExtra("BUNDLE",args);
//        startActivity(intent);

        for (News newsFromjson : newsList) {
            Log.d("mylog", "title is " + newsFromjson.getTitle());
            Log.d("mylog", "content is " + newsFromjson.getContent());
//            newsContentFragment.refresh(newsFromjson.getTitle(),newsFromjson.getContent());
//            news.setTitle(newsFromjson.getTitle());
//            news.setContent(newsFromjson.getContent());
        }

    }
}
