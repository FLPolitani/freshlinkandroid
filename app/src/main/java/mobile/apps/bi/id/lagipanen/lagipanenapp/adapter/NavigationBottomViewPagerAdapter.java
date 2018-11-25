package mobile.apps.bi.id.lagipanen.lagipanenapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import mobile.apps.bi.id.lagipanen.lagipanenapp.fragment.HomeFragment;
import mobile.apps.bi.id.lagipanen.lagipanenapp.fragment.KatalogFragment;
import mobile.apps.bi.id.lagipanen.lagipanenapp.fragment.ProfileFragment;
import mobile.apps.bi.id.lagipanen.lagipanenapp.fragment.SapikuFragment;
/**
 *
 */
public class NavigationBottomViewPagerAdapter extends FragmentPagerAdapter  {

	private ArrayList<Fragment> fragments = new ArrayList<>();
	private HomeFragment currentFragment;

	public NavigationBottomViewPagerAdapter(FragmentManager fm) {
		super(fm);
//
		fragments.clear();
		fragments.add(HomeFragment.newInstance(0));
		fragments.add(SapikuFragment.newInstance(1));
		fragments.add(KatalogFragment.newInstance(2));
		fragments.add(ProfileFragment.newInstance(3));
	}

	@Override
	public Fragment getItem(int position) {
		return fragments.get(position);
	}

	@Override
	public int getCount() {
		return fragments.size();
	}

	/**
	 * Get the current fragment
	 */
	public Fragment getCurrentFragment() {
		return this.currentFragment;
	}
}