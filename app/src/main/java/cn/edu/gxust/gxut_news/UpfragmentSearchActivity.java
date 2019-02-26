package cn.edu.gxust.gxut_news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpfragmentSearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upfragmentsearch);

        UpFragment upFragment=(UpFragment) getSupportFragmentManager().findFragmentById(R.id.upsearch_fragment);

    }
}
