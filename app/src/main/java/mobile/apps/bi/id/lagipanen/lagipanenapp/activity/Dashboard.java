package mobile.apps.bi.id.lagipanen.lagipanenapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import cn.pedant.SweetAlert.SweetAlertDialog;
import mobile.apps.bi.id.lagipanen.lagipanenapp.R;
import mobile.apps.bi.id.lagipanen.lagipanenapp.fragment.HomeFragment;
import mobile.apps.bi.id.lagipanen.lagipanenapp.fragment.LoopViewPagerSlideHomeFragment;
import mobile.apps.bi.id.lagipanen.lagipanenapp.manager.PrefManager;

public class Dashboard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment demoFragment = Fragment.instantiate(this, HomeFragment.class.getName());
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, demoFragment);
        fragmentTransaction.commit();

        Fragment demoFragment1 = Fragment.instantiate(this, LoopViewPagerSlideHomeFragment.class.getName());
        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.replace(R.id.frame1, demoFragment1);
        fragmentTransaction1.commit();
        clikListener();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.notification) {
            return true;
        } else if (id == R.id.shop_notification) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void clikListener() {
        findViewById(R.id.d_kategori).setOnClickListener(mClickListener);
        findViewById(R.id.d_pembelian).setOnClickListener(mClickListener);
        findViewById(R.id.d_pengaturan).setOnClickListener(mClickListener);
        findViewById(R.id.d_customerService).setOnClickListener(mClickListener);
        findViewById(R.id.d_help).setOnClickListener(mClickListener);
        findViewById(R.id.d_logout).setOnClickListener(mClickListener);
    }

    final View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.d_kategori:
                    Intent kategori = new Intent(Dashboard.this, Kategori.class);
                    kategori.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(kategori);
                    break;
                case R.id.d_pembelian:
                    Intent pembelian = new Intent(Dashboard.this, Pembelian.class);
                    pembelian.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(pembelian);
                    break;
                case R.id.d_pengaturan:
                    Intent pengaturan = new Intent(Dashboard.this, Pengaturan.class);
                    pengaturan.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(pengaturan);
                    break;
                case R.id.d_customerService:
                    Intent customerService = new Intent(Dashboard.this, CustomerService.class);
                    customerService.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(customerService);
                    break;
                case R.id.d_help:
                    Intent help = new Intent(Dashboard.this, Help.class);
                    help.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(help);
                    break;
                case R.id.d_logout:
                    new SweetAlertDialog(Dashboard.this, SweetAlertDialog.NORMAL_TYPE)
                            .setTitleText("Logout Akun")
                            .setContentText("Apakah anda ingin logout dari aplikasi?")
                            .setConfirmText("Logout")
                            .setCancelText("Batal")
                            .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener(){
                                @Override
                                public void onClick(SweetAlertDialog sweetAlertDialog) {
                                    sweetAlertDialog.dismissWithAnimation();
                                }
                            })
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    PrefManager prf= new PrefManager(Dashboard.this);
                                    prf.remove("token");
                                    Intent i = new Intent(Dashboard.this, LoginActivity.class);
                                    startActivity(i);
                                    finish();
                                    sDialog.dismissWithAnimation();
                                }
                            })
                            .show();
                    break;

            }

        }
    };
}
