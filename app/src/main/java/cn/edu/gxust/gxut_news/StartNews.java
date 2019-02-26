package cn.edu.gxust.gxut_news;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import okhttp.MainActivity;

public class StartNews extends AppCompatActivity  {
    private Button newsbtn,videosbtn,findbtn,mebtn;
    private EditText searchet;
    private Button searchbtn;
    @Override
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startnews);
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("科大新闻");
        setSupportActionBar(toolbar);
//        replaceFragment(R.id.center_layout,new NewsTitleFragment());//
        newsbtn=findViewById(R.id.navigation_news_btn);
        videosbtn=findViewById(R.id.navigation_videos_btn);
        findbtn=findViewById(R.id.navigation_find_btn);
        mebtn=findViewById(R.id.navigation_me_btn);

        searchet=findViewById(R.id.search_et);
        searchbtn=findViewById(R.id.search_btn);

        newsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(StartNews.this,"世界之窗",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(StartNews.this, MainActivity.class);
                startActivity(intent);

            }
        });
        videosbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(StartNews.this,"视频新闻时代",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(StartNews.this, videoplayer.MainActivity.class));
            }
        });
        findbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StartNews.this, findmore.MainActivity.class);
                startActivity(intent);
                Toast.makeText(StartNews.this,"科大看点",Toast.LENGTH_SHORT).show();
            }
        });
        mebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(StartNews.this,"官网在这里",Toast.LENGTH_SHORT).show();
//                replaceFragment(R.id.center_layout,new MeFragment());
                Intent intent =new Intent(StartNews.this,MeActivity.class);
                startActivity(intent);
//                finish();
            }
        });
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(StartNews.this,"正在搜索...",Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void replaceFragment(Integer fragmentid,Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(fragmentid,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.backup:
                Toast.makeText(this,"backup",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(this,"delete",Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(this,"settings",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
