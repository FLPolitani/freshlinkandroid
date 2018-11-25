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

public class LaukActivity extends AppCompatActivity {

    private GridLayoutManager lLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sayur_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Lauk");
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
        lLayout = new GridLayoutManager(this, 2,GridLayoutManager.VERTICAL,false);

        RecyclerView rView = (RecyclerView) findViewById(R.id.recycler_view);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(this, rowListItem);
        rView.setAdapter(rcAdapter);
    }
    private List<ItemObject> getAllItemList(){

        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("Rp. 45.500","Ayam Potong Kosongan",R.drawable.ayam,"ekor"));
        allItems.add(new ItemObject("Rp. 30.000","Ikan Mas",R.drawable.ikan_mas,"kg"));
        allItems.add(new ItemObject("Rp. 90.000","Ikan Kakap Merah",R.drawable.kakap,"kg"));
        allItems.add(new ItemObject("Rp. 20.000","Ikan Lelel",R.drawable.lele,"kg"));
        allItems.add(new ItemObject("Rp. 28.000","Ikan Mujair",R.drawable.mujair,"kg"));
        allItems.add(new ItemObject("Rp. 6.000","Tahu Putih Mentah",R.drawable.tahu,"10 pcs"));
        allItems.add(new ItemObject("Rp. 4.000","Tempe Daun",R.drawable.tempe,"pack"));
        return allItems;
    }

}
