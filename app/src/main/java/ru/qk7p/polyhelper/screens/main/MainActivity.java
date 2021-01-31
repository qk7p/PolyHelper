package ru.qk7p.polyhelper.screens.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import ru.qk7p.polyhelper.App;
import ru.qk7p.polyhelper.R;
import ru.qk7p.polyhelper.adapters.MainPagerAdapter;
import ru.qk7p.polyhelper.database.MaterialDao;
import ru.qk7p.polyhelper.database.PolyHelperDatabase;

public class MainActivity extends AppCompatActivity {


    ViewPager2 viewPager2;
   public PolyHelperDatabase db;


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
        db = App.getInstance().getDatabase();
        MaterialDao materialDao = db.materialDao();
    }


}
