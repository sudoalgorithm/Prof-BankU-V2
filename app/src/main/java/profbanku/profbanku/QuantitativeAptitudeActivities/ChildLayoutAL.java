package profbanku.profbanku.QuantitativeAptitudeActivities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import profbanku.profbanku.R;
import profbanku.profbanku.TabPagerAdapter;

public class ChildLayoutAL extends FragmentActivity {

    private TabPagerAdapter mTabPageAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_layout_al);

        mTabPageAdapter = new TabPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(mTabPageAdapter);

    }

}
