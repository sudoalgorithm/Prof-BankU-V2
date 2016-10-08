package profbanku.profbanku;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import profbanku.profbanku.Fragments.FactsheetFragment;
import profbanku.profbanku.Fragments.QuestionFragment;
import profbanku.profbanku.Fragments.VideoFragment;


/**
 * Created by kunalmalhotra on 10/4/16.
 */

public class TabPagerAdapter extends FragmentPagerAdapter {

    private String[] titles = {"Factsheet", "Videos", "Questions" };

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Top Rated fragment activity
                return new FactsheetFragment();
            case 1:
                // Games fragment activity
                return new VideoFragment();
            case 2:
                // Movies fragment activity
                return new QuestionFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return titles[position];
    }

}
