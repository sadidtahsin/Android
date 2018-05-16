package app.appinion.com.illuminate;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.widget.Button;

import app.appinion.com.illuminate.fragment.CouponsFragment;
import app.appinion.com.illuminate.fragment.GiftCards;
import app.appinion.com.illuminate.fragment.HomeFragment;
import app.appinion.com.illuminate.fragment.PromotionsFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    /**
     * Returns the Fragments in the view pager
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new CouponsFragment();
            case 2:
                return new PromotionsFragment();
            case 3:
                return new GiftCards() ;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}