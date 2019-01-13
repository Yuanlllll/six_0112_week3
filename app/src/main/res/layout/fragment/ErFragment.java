package com.example.six_0111_week3.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.six_0111_week3.R;


public class ErFragment extends Fragment {
    private TextView viewById;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.er_fragment, container, false);
         viewById = (TextView) view.findViewById(R.id.text);

        return view;
    }
}
