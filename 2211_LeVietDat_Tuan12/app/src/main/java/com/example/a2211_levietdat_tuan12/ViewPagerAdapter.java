package com.example.a2211_levietdat_tuan12;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return position == 0 ? new VerticalFragment() : new GridFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
