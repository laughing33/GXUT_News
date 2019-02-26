package cn.edu.gxust.gxut_news;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class UpFragment extends Fragment {
    @Nullable
    UpfragmentSearchActivity upfragmentSearchActivity=(UpfragmentSearchActivity)getActivity();
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.up_fragment,container,false);
        return view;
    }
}
