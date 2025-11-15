package com.example.a2211_levietdat_tuan12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.Holder> {

    ArrayList<ItemModel> list;

    public ItemAdapter(ArrayList<ItemModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder h, int i) {
        ItemModel item = list.get(i);
        h.img.setImageResource(item.image);
        h.txt.setText(item.title);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;

        Holder(View v) {
            super(v);
            img = v.findViewById(R.id.img_item);
            txt = v.findViewById(R.id.txt_title);
        }
    }
}

// MODEL GỘP LUÔN TRONG FILE
class ItemModel {
    int image;
    String title;

    ItemModel(int image, String title) {
        this.image = image;
        this.title = title;
    }

    static ArrayList<ItemModel> createSampleData() {
        ArrayList<ItemModel> list = new ArrayList<>();
        list.add(new ItemModel(R.drawable.ic_phone, "Điện thoại"));
        list.add(new ItemModel(R.drawable.ic_laptop, "Laptop"));
        list.add(new ItemModel(R.drawable.ic_headphone, "Tai nghe"));
        list.add(new ItemModel(R.drawable.ic_watch, "Đồng hồ"));
        return list;
    }
}
