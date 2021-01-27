package ru.qk7p.polyhelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private Cursor mainCursor;
    ViewPager2 viewPager2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewPager);
        viewPager2.setAdapter(new MainPagerAdapter(this));
        viewPager2.setUserInputEnabled(false);


        TabLayout tabLayout = findViewById(R.id.tabLayout);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, viewPager2, (tab, position) -> {

                    switch (position) {
                        case 0:
                           tab.setText("составить");
                           tab.setIcon(R.drawable.ic_create);
                           break;
                        case 1: {
                            tab.setText("отправить");
                            tab.setIcon(R.drawable.ic_send);
                            break;
                        }
                        case 2: {
                            tab.setText("посчитать");
                            tab.setIcon(R.drawable.ic_calculate);
                            break;
                        }
                    }
                }
        );
        tabLayoutMediator.attach();
    }



}
