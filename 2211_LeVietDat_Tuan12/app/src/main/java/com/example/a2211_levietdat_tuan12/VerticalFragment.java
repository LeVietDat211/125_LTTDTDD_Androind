package com.example.a2211_levietdat_tuan12;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class VerticalFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_vertical, container, false);

        RecyclerView rcv = v.findViewById(R.id.recycler_vertical);
        rcv.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<ItemModel> list = ItemModel.createSampleData();
        rcv.setAdapter(new ItemAdapter(list));

        return v;
    }
}
