package cn.edu.gxust.gxut_news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BottomFragmentActivity extends AppCompatActivity  {
//    private Button newsbtn,videosbtn,findbtn,mebtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottomfragmentactivity);

//        fragment特殊的实例化，也就是注册的作用
        DownFragment downFragment=(DownFragment)getSupportFragmentManager().findFragmentById(R.id.down_fragment);
    }
}
