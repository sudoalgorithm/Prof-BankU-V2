package profbanku.profbanku.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import profbanku.profbanku.R;

public class DashboardFragment extends Fragment {

    private View rootView;
    public static TabLayout mTabLayout;
    public static ViewPager mViewPager;
    public static int int_items = 4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_dashboard_fragment, null);
        mTabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
        mViewPager = (ViewPager) rootView.findViewById(R.id.view_pager);
        mViewPager.setAdapter(new dashboardAdapter(getChildFragmentManager()));
        mTabLayout.post(new Runnable() {
            @Override
            public void run() {
                mTabLayout.setupWithViewPager(mViewPager);
            }
        });
        return rootView;
    }

    private class dashboardAdapter extends FragmentPagerAdapter {
        public dashboardAdapter(FragmentManager childFragmentManager) {
            super(childFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new TutorialFragment();
                case 1:
                    return new UpcomingExamFragment();
                case 2:
                    return new CoachingCenterFragment();
                case 3:
                    return new HaveADoubtFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return int_items;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "Tutorial";
                case 1:
                    return "Upcoming Exam";
                case 2:
                    return "Coaching Center";
                case 3:
                    return "Have A Doubt?";

            }
            return null;
        }
    }
}
