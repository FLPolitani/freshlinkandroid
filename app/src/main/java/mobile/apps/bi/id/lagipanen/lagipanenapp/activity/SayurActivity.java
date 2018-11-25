package mobile.apps.bi.id.lagipanen.lagipanenapp.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import mobile.apps.bi.id.lagipanen.lagipanenapp.R;
import mobile.apps.bi.id.lagipanen.lagipanenapp.adapter.RecyclerViewAdapter;
import mobile.apps.bi.id.lagipanen.lagipanenapp.delete.ItemObject;

public class SayurActivity extends AppCompatActivity {

    private GridLayoutManager lLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sayur_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Sayur");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initial();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.shope, menu);
        return true;
    }

     public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void initial() {
        List<ItemObject> rowListItem = getAllItemList();
        lLayout = new GridLayoutManager(this, 3,GridLayoutManager.VERTICAL,false);

        RecyclerView rView = (RecyclerView) findViewById(R.id.recycler_view);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(this, rowListItem);
        rView.setAdapter(rcAdapter);
    }
    private List<ItemObject> getAllItemList(){

        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("Rp. 8.000","Wortel Segar",R.drawable.b,"kg"));
        allItems.add(new ItemObject("Rp. 35.000","Asparagus Lokal",R.drawable.asparagus,"kg"));
        allItems.add(new ItemObject("Rp. 7.000","Tomat Merah",R.drawable.f,"kg"));
        allItems.add(new ItemObject("Rp. 9.000","Brokoli Hijau",R.drawable.brokoli,"kg"));
        allItems.add(new ItemObject("Rp. 5.500","Buncis",R.drawable.buncis,"kg"));
        allItems.add(new ItemObject("Rp. 1.500","Kol",R.drawable.d,"kg"));
        allItems.add(new ItemObject("Rp. 1.400","Bayam",R.drawable.c,"ikat"));
        allItems.add(new ItemObject("Rp. 4.500","Kacang Panjang",R.drawable.kacang_panjang,"kg"));
        allItems.add(new ItemObject("Rp. 2.000","Kangkung",R.drawable.kangkung,"kg"));
        allItems.add(new ItemObject("Rp. 5.000","Kentang",R.drawable.kentang,"kg"));
        allItems.add(new ItemObject("Rp. 2.000","Labu Siam",R.drawable.labu_siam,"kg"));
        allItems.add(new ItemObject("Rp. 20.000","Paprika Hijau",R.drawable.paprika_hijau,"kg"));
        allItems.add(new ItemObject("Rp. 27.000","Paprika Kuning",R.drawable.paprika_kuning,"kg"));
        allItems.add(new ItemObject("Rp. 32.000","Paprika Merah",R.drawable.paprika_merah,"kg"));

        return allItems;
    }

}
