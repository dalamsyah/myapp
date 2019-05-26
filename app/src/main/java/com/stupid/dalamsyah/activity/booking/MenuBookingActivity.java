package com.stupid.dalamsyah.activity.booking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.stupid.dalamsyah.R;
import com.stupid.dalamsyah.activity.booking.adapter.TabAdapter;
import com.stupid.dalamsyah.activity.booking.fragment.BookingFragment;
import com.stupid.dalamsyah.activity.booking.fragment.HomeFragment;
import com.stupid.dalamsyah.activity.booking.fragment.UserFragment;

public class MenuBookingActivity extends AppCompatActivity {

    public TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_booking);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment(), "Match");
        adapter.addFragment(new BookingFragment(), "Booking");
        adapter.addFragment(new UserFragment(), "Akun");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}
