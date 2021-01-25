package ru.qk7p.polyhelper;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MainPagerAdapter extends FragmentStateAdapter {

    public MainPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new CreateMailFragment();
            case 1:
                return new SendMailFragment();
            default:
                return new CalculateOrderFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
