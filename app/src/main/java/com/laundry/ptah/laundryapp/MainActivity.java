package com.laundry.ptah.laundryapp;

/**
 * Created by Ptah on 6/25/16.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.laundry.ptah.laundryapp.fragment.RecyclerViewFragment;

public class MainActivity extends DrawerActivity {

    private MaterialViewPager mViewPager;
    private Toolbar toolbar;
    public TextView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = (TextView)findViewById(R.id.logo_title);

        setTitle("");

        mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);

        toolbar = mViewPager.getToolbar();

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position % 11) {
                    case 0:
                        return RecyclerViewFragment.newInstance("Shirts/Tops");
                    case 1:
                        return RecyclerViewFragment.newInstance("Suits");
                    case 2:
                        return RecyclerViewFragment.newInstance("Dress/Skirts");
                    case 3:
                        return RecyclerViewFragment.newInstance("Outdoor");
                    case 4:
                        return RecyclerViewFragment.newInstance("Trousers");
                    case 5:
                        return RecyclerViewFragment.newInstance("Knitwear");
                    case 6:
                        return RecyclerViewFragment.newInstance("Accessories");
                    case 7:
                        return RecyclerViewFragment.newInstance("Towels");
                    case 8:
                        return RecyclerViewFragment.newInstance("Beddings");
                    case 9:
                        return RecyclerViewFragment.newInstance("Home");
                    case 10:
                        return RecyclerViewFragment.newInstance("Others");
                    default:
                        return RecyclerViewFragment.newInstance("Shirts/Tops");
                }
            }

            @Override
            public int getCount() {
                return 11;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 11) {
                    case 0:
                        return "Shirts/Tops";
                    case 1:
                        return "Suits";
                    case 2:
                        return "Dress/Skirts";
                    case 3:
                        return "Outdoor";
                    case 4:
                        return "Trousers";
                    case 5:
                        return "Knitwear";
                    case 6:
                        return "Accessories";
                    case 7:
                        return "Towels";
                    case 8:
                        return "Beddings";
                    case 9:
                        return "Home";
                    case 10:
                        return "Others";
                }
                return "";
            }
        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        logo.setText("Shirts/Tops");
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.green,
                                "http://www.crcracewear.com/images/t-shirt%20color.png");
                    case 1:
                        logo.setText("Suits");
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.black,
                                "http://images.askmen.com/1200x600/video/fashion/fashion-sense-three-piece-suit-1105859-TwoByOne.jpg");
                    case 2:
                        logo.setText("Dress/Skirts");
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.cyan,
                                "http://www.droid-life.com/wp-content/uploads/2014/10/lollipop-wallpapers10.jpg");
                    case 3:
                        logo.setText("Outdoor");
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.red,
                                "http://www.chinaimportal.com/wp-content/uploads/2016/02/outdoor-wear-suppliers.jpg");
                    case 4:
                        logo.setText("Trousers");
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.green,
                                "http://static6.shop.indiatimes.com/images/products/additional/original/B2678535_View_1/fashion/trousers-chinos/gwalior-suitings-men-trousers-combo-of-three-502.jpg");
                    case 5:
                        logo.setText("Knitwear");
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.blue,
                                "http://www.paulsmith.co.uk/sites/default/files/styles/psw_article_collaboration__desktop/public/JEANSKNIT.jpg");
                    case 6:
                        logo.setText("Accessories");
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.cyan,
                                "http://www.droid-life.com/wp-content/uploads/2014/10/lollipop-wallpapers10.jpg");
                    case 7:
                        logo.setText("Towels");
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.red,
                                "http://www.tothemobile.com/wp-content/uploads/2014/07/original.jpg");
                    case 8:
                        logo.setText("Beddings");
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.green,
                                "https://fs01.androidpit.info/a/63/0e/android-l-wallpapers-630ea6-h900.jpg");
                    case 9:
                        logo.setText("Home");
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.blue,
                                "http://cdn1.tnwcdn.com/wp-content/blogs.dir/1/files/2014/06/wallpaper_51.jpg");
                    case 10:
                        logo.setText("Others");
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.cyan,
                                "http://www.droid-life.com/wp-content/uploads/2014/10/lollipop-wallpapers10.jpg");
                }

                return null;
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());
    }
}