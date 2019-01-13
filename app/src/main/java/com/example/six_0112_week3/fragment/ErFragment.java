package com.example.six_0112_week3.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.six_0112_week3.R;
import com.example.six_0112_week3.ZxingActivity;


public class ErFragment extends Fragment {
    private TextView viewById;
    private ImageView sao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.er_fragment, container, false);
         viewById = (TextView) view.findViewById(R.id.text);
        sao = view.findViewById(R.id.sao);
        sao.setOnClickListener(new View.OnClickListener() {
            private Intent intent;
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), ZxingActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
