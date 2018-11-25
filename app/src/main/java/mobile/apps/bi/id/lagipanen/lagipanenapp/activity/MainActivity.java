package mobile.apps.bi.id.lagipanen.lagipanenapp.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;

import mobile.apps.bi.id.lagipanen.lagipanenapp.R;
import mobile.apps.bi.id.lagipanen.lagipanenapp.adapter.NavigationBottomViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    AHBottomNavigationAdapter navigationAdapter;
    AHBottomNavigationViewPager viewPager;
    private AHBottomNavigation bottomNavigation;
    private boolean useMenuResource = true;
    private int[] tabColors;
    Fragment currentFragment;
    NavigationBottomViewPagerAdapter adapter;
    FrameLayout fragmentContainer;
    private FloatingActionButton floatingActionButton;
    private AppBarLayout appBarLayout;
    private LayoutInflater inflater;
    public static final String PREF_KEY_FIRST_START = "com.heinrichreimersoftware.materialintro.demo.PREF_KEY_FIRST_START";
    public static final int REQUEST_CODE_INTRO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);

        boolean firstStart = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean(PREF_KEY_FIRST_START, true);

        if (firstStart) {
            Intent intent = new Intent(this, SliderContent.class);
            startActivityForResult(intent, REQUEST_CODE_INTRO);
        }


        action();
        setStatusBarTranslucent(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_INTRO) {
            if (resultCode == RESULT_OK) {
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean(PREF_KEY_FIRST_START, false)
                        .apply();
            } else {
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean(PREF_KEY_FIRST_START, true)
                        .apply();
                //User cancelled the intro so we'll finish this activity too.
                finish();
            }
        }
    }

    public void setStatusBarTranslucent(boolean makeTranslucent) {
        if (makeTranslucent) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
        }
    }

    public void action () {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        }

//        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
//        bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);
//        viewPager = (AHBottomNavigationViewPager) findViewById(R.id.container_layout);
//        AHBottomNavigation.TitleState state = AHBottomNavigation.TitleState.ALWAYS_SHOW;
//        bottomNavigation.setTitleState(state);
//
//        if (useMenuResource) {
//            tabColors = getApplicationContext().getResources().getIntArray(R.array.tab_colors);
//            navigationAdapter = new AHBottomNavigationAdapter(this, R.menu.navigation);
//            navigationAdapter.setupWithBottomNavigation(bottomNavigation, tabColors);
//        }
//
//        bottomNavigation.setTranslucentNavigationEnabled(true);
//        bottomNavigation.setAccentColor(ContextCompat.getColor(this, R.color.colorAccent));
//        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
//            @Override
//            public boolean onTabSelected(int position, boolean wasSelected) {
//                if (currentFragment == null) {
//                    currentFragment = adapter.getCurrentFragment();
//                }
//
//                currentFragment = adapter.getCurrentFragment();
//                viewPager.setCurrentItem(position, false);
//
//                return true;
//            }
//        });
//
//        viewPager.setOffscreenPageLimit(4);
//        adapter = new NavigationBottomViewPagerAdapter(getSupportFragmentManager());
//        viewPager.setAdapter(adapter);
//
//        currentFragment = adapter.getCurrentFragment();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
