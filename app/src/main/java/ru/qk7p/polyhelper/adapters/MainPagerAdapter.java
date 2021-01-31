package ru.qk7p.polyhelper.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import ru.qk7p.polyhelper.screens.fragments.toplevel.CalculateOrderFragment;
import ru.qk7p.polyhelper.screens.fragments.toplevel.CreateMailFragment;
import ru.qk7p.polyhelper.screens.fragments.toplevel.SendMailFragment;

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
