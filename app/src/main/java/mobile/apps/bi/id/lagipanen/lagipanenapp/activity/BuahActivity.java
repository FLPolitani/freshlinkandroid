package mobile.apps.bi.id.lagipanen.lagipanenapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import mobile.apps.bi.id.lagipanen.lagipanenapp.R;
import mobile.apps.bi.id.lagipanen.lagipanenapp.adapter.RecyclerViewAdapter;
import mobile.apps.bi.id.lagipanen.lagipanenapp.delete.ItemObject;

public class BuahActivity extends AppCompatActivity {

    private GridLayoutManager lLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sayur_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Buah");
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
        allItems.add(new ItemObject("Rp. 15.000","Pisang Ambon Lokal",R.drawable.ambon,"sisir"));
        allItems.add(new ItemObject("Rp. 41.300","Anggur Red Import",R.drawable.anggur,"kg"));
        allItems.add(new ItemObject("Rp. 31.450","Apel Hijau Import",R.drawable.apel_hijau,"kg"));
        allItems.add(new ItemObject("Rp. 31.350","Apel Merah",R.drawable.apel_merah,"kg"));
        allItems.add(new ItemObject("Rp. 22.000","Apel Malang",R.drawable.apel_hijau,"kg"));
        allItems.add(new ItemObject("Rp. 10.000","Jambu Air",R.drawable.jambu_air,"kg"));
        allItems.add(new ItemObject("Rp. 6.700","Jambu Biji Daging Merah",R.drawable.jambu_merah,"kg"));
        allItems.add(new ItemObject("Rp. 15.000","Jeruk Pontianak",R.drawable.jeruk_pontianak,"kg"));
        allItems.add(new ItemObject("Rp. 24.000","Jeruk Sankist",R.drawable.jeruk_sunkis,"kg"));
        allItems.add(new ItemObject("Rp. 3.000","Mangga Golek Buah Lokal",R.drawable.mangga_golek,"kg"));
        allItems.add(new ItemObject("Rp. 8.000","Mangga Madu",R.drawable.mangga_madu,"kg"));
        allItems.add(new ItemObject("Rp. 20.000","Pisang Raja",R.drawable.raja,"sisir"));
        allItems.add(new ItemObject("Rp. 20.000","Srikaya",R.drawable.srikaya,"kg"));
        allItems.add(new ItemObject("Rp. 2.000","Pisang Ulin",R.drawable.ulin,"sisir"));

        return allItems;
    }

}
