package cn.edu.gxust.gxut_news;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class DownFragment extends Fragment  {
    private Button newsbtn,videosbtn,findbtn,mebtn;
    @Nullable
    BottomFragmentActivity bottomFragmentActivity=(BottomFragmentActivity)getActivity();
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.down_fragment,container,false);
        return view;
    }
}
