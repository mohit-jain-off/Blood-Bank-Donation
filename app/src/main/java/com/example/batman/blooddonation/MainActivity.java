package com.example.batman.blooddonation;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public  static CoordinatorLayout coordinatorLayout;
    private SectionsPageAdapter sectionsPageAdapter;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sectionsPageAdapter=new SectionsPageAdapter(getSupportFragmentManager());
        coordinatorLayout=(CoordinatorLayout)findViewById(R.id.main_content);
        viewPager=(ViewPager)findViewById(R.id.container);
        setupViewPager(viewPager);
        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
    public void setupViewPager(ViewPager viewPager)
    {
        SectionsPageAdapter sectionsPageAdapter=new SectionsPageAdapter(getSupportFragmentManager());
        sectionsPageAdapter.addFragment(new LoginFragment(),"LOGIN");
        sectionsPageAdapter.addFragment(new RegisterActivity(),"REGISTER");
        viewPager.setAdapter(sectionsPageAdapter);
    }

}
