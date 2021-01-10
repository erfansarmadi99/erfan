package com.example.aparat.Activitis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.aparat.Adapters.FragmentAdapters.TabsAdapter;
import com.example.aparat.Fragments.CategoryFragment;
import com.example.aparat.Fragments.FavoriteFragment;
import com.example.aparat.Fragments.HomeFragment;
import com.example.aparat.R;
import com.example.aparat.dao.AppDatabase;
import com.example.aparat.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    ActivityMainBinding binding;
    TabsAdapter adapter;
    List<Fragment> fragmentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fragmentList = new ArrayList<>();
        binding.bottomMenu.setOnNavigationItemSelectedListener(this);

        fragmentList.add(new HomeFragment());
        fragmentList.add(new CategoryFragment());
        fragmentList.add(new FavoriteFragment());
        adapter = new TabsAdapter(getSupportFragmentManager(),fragmentList);
        binding.pager.setAdapter(adapter);


        binding.pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        binding.bottomMenu.getMenu().findItem(R.id.item_home).setChecked(true);
                    break;
                    case 1:
                        binding.bottomMenu.getMenu().findItem(R.id.item_favorite).setChecked(true);
                        break;
                    case 2:
                        binding.bottomMenu.getMenu().findItem(R.id.item_category).setChecked(true);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.item_home: {
                binding.pager.setCurrentItem(0);
                binding.bottomMenu.getMenu().findItem(R.id.item_home).setChecked(true);

                break;
            }
            case R.id.item_category: {
                binding.pager.setCurrentItem(1);
                binding.bottomMenu.getMenu().findItem(R.id.item_category).setChecked(true);
                break;
            }
            case R.id.item_favorite: {
                binding.pager.setCurrentItem(2);
                binding.bottomMenu.getMenu().findItem(R.id.item_favorite).setChecked(true);
                break;
            }

        }


        return false;
    }
}