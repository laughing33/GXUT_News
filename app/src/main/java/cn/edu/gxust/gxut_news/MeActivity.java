package cn.edu.gxust.gxut_news;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MeActivity extends AppCompatActivity {
    private Button exit,contact;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me);
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("科大新闻");
        setSupportActionBar(toolbar);
        exit=findViewById(R.id.me_switch_btn);
        contact=findViewById(R.id.me_contact_btn);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MeActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent=new Intent(MeActivity.this,ContactUs.class);
            startActivity(intent);
            }
        });
//        MeFragment meFragment=(MeFragment) getSupportFragmentManager().findFragmentById(R.id.me_fragment_activity);

    }
}
