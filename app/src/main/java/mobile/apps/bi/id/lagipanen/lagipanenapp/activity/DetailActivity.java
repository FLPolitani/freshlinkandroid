package mobile.apps.bi.id.lagipanen.lagipanenapp.activity;

import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.Locale;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;
import mobile.apps.bi.id.lagipanen.lagipanenapp.R;
import mobile.apps.bi.id.lagipanen.lagipanenapp.config.Const;
import mobile.apps.bi.id.lagipanen.lagipanenapp.manager.PrefManager;
import mobile.apps.bi.id.lagipanen.lagipanenapp.model.Produk;
import mobile.apps.bi.id.lagipanen.lagipanenapp.model.ResponseDetailPurchaseOrders;
import mobile.apps.bi.id.lagipanen.lagipanenapp.model.ResponseUser;
import mobile.apps.bi.id.lagipanen.lagipanenapp.service.ApiEndpointService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static mobile.apps.bi.id.lagipanen.lagipanenapp.config.Const.BASE_URL;

public class DetailActivity extends AppCompatActivity {

    Button invest;
    private Retrofit retrofit;
    Produk produk;
    TextView kategori;
    TextView harga;
    TextView satuan;
    TextView quantityTextView;
    TextView hargaTotalProduk;
    String foto;
    ImageView imageView;
    int quantity=1,total=0, jumlah;
    Locale localeID = new Locale("in", "ID");
    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        produk = (Produk) bundle.getSerializable("produk");

        context=this;
        initializeRetrofit();

        imageView = (ImageView) findViewById(R.id.foto_produk);
        Picasso.with(DetailActivity.this)
                .load(BASE_URL+produk.getFoto())
                .error(R.drawable.no_image)
                .into(imageView);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(produk.getNama()+"");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        kategori = (TextView) findViewById(R.id.txt_kategori);
        kategori.setText(produk.getKategori().getNama()+"");

        satuan = (TextView) findViewById(R.id.txt_satuan);
        satuan.setText(produk.getSatuan().getNama()+"");

        harga = (TextView) findViewById(R.id.txt_harga);
        harga.setText(formatRupiah.format((double)produk.getHargaJual()));

        harga = (TextView) findViewById(R.id.txt_total);
        harga.setText(formatRupiah.format((double)produk.getHargaJual()));

        invest = (Button) findViewById(R.id.investasi);
        invest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attempt();
                //Intent intent =  new Intent(DetailActivity.this, MethodPayment.class);
                //startActivity(intent);
            }
        });
    }

    private void initializeRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private void attempt() {
        // Store values at the time of the login attempt.
        int purchaseOrdersId = 1;
        int produkId = produk.getId();
        int jumlah = quantity;
        int satuanId = produk.getSatuanTerkecilId();
        int hargaJual = produk.getHargaJual();

        updateDetailPurchaseOrders(purchaseOrdersId ,produkId,jumlah,satuanId,hargaJual);
    }

    public void updateDetailPurchaseOrders(int purchaseOrdersId, int produkId,
                                           int jumlah, int satuanId, int hargaJual){
        try {
            ApiEndpointService apiService = retrofit.create(ApiEndpointService.class);
            Call<ResponseDetailPurchaseOrders> result = apiService.updateDetailPurchaseOrders(
                    purchaseOrdersId,
                    produkId,
                    jumlah,
                    satuanId,
                    hargaJual);
            result.enqueue(new Callback<ResponseDetailPurchaseOrders>() {
                @Override
                public void onResponse(Call<ResponseDetailPurchaseOrders> call, Response<ResponseDetailPurchaseOrders> response) {
                    //showProgress(false);
                    if(response.isSuccessful() ){
                        if(response.body().getSuccess()){

                            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                            Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                            r.play();

                            new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
                                    .setTitleText("Pesanan Dikonfirmasi")
                                    .setContentText("Silahkan cek di keranjang")
                                    .setConfirmText("Tutup")
                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sDialog) {
                                            Intent intent= new Intent(DetailActivity.this,MethodPayment.class);
                                            startActivity(intent);
                                            finish();
                                            sDialog.dismissWithAnimation();
                                        }
                                    })
                                    .show();
                        }else{
                            new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
                                    .setTitleText("Pesanan gagal")
                                    .setContentText(response.body().getMessage())
                                    .setConfirmText("Tutup")
                                    .show();
                        }
                    }else{
                        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                        Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                        r.play();

                        try {
                            JSONObject jObjError = new JSONObject(response.errorBody().string());

                            if(jObjError.has("error") && jObjError.getString("error").equalsIgnoreCase("token_expired")){
                                new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                                        .setTitleText("Aplikasi Bermasalah")
                                        .setContentText("Login anda telah kadaluarsa. Silahkan Login ulang")
                                        .setConfirmText("Login Ulang")
                                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                            @Override
                                            public void onClick(SweetAlertDialog sDialog) {
                                                PrefManager prf= new PrefManager(context);
                                                prf.remove("token");
                                                Intent intent= new Intent(context,LoginActivity.class);
                                                startActivity(intent);
                                                finish();
                                                sDialog.dismissWithAnimation();
                                            }
                                        })
                                        .show();
                            }else if(jObjError.has("message")){
                                new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                                        .setTitleText("Gagal")
                                        .setContentText(jObjError.getString("message"))
                                        .setConfirmText("Tutup")
                                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                            @Override
                                            public void onClick(SweetAlertDialog sDialog) {
                                                sDialog.dismissWithAnimation();
                                            }
                                        })
                                        .show();
                            }else{
                                new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                                        .setTitleText("Aplikasi Bermasalah")
                                        .setContentText(response.errorBody().string())
                                        .setConfirmText("Tutup")
                                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                            @Override
                                            public void onClick(SweetAlertDialog sDialog) {
                                                //getAccessToken();
                                                sDialog.dismissWithAnimation();
                                            }
                                        })
                                        .show();
                            }
                        } catch (Exception e) {
                            new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                                    .setTitleText("Aplikasi Bermasalah")
                                    .setContentText("Masalah tidak diketahui")
                                    .setConfirmText("Tutup")
                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sDialog) {
                                            //getAccessToken();
                                            sDialog.dismissWithAnimation();
                                        }
                                    })
                                    .show();
                        }
                        //showMessageDialog("Sistem Bermasalah Hubungi Administrator");
                    }
                }

                @Override
                public void onFailure(Call<ResponseDetailPurchaseOrders> call, Throwable t) {
                    //showProgress(false);
                    new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("Pesanan Dikonfirmasi")
                            .setContentText("Silahkan cek di keranjang")
                            .setConfirmText("Tutup")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    Intent intent= new Intent(DetailActivity.this,MethodPayment.class);
                                    startActivity(intent);
                                    finish();
                                    sDialog.dismissWithAnimation();
                                }
                            })
                            .show();
                }
            });

        } catch (Exception e) {
            //showProgress(false);
            new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Aplikasi Bermasalah")
                    .setContentText("Koneksi / Jaringan Internet Kada Karuan")
                    .setConfirmText("Tutup")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            //getListUser();
                            sDialog.dismissWithAnimation();
                        }
                    })
                    .show();
        }
    }

    @OnClick(R.id.tambah)
    public void tambah(){
        if (quantity>=100){
            Toast.makeText(this, "Maksimal Order 100 "+produk.getNama(), Toast.LENGTH_SHORT).show();
            return;
        }

       quantity++;
        display();

    }

    @OnClick(R.id.kurang)
    public void kurang(){
        if (quantity<=1){
            Toast.makeText(this, "Minimal Order 1 "+produk.getNama(), Toast.LENGTH_SHORT).show();
            return;
        }
        quantity--;
        display();
    }

    private void display() {
        quantityTextView = (TextView) findViewById(R.id.txt_jumlah);
        hargaTotalProduk=findViewById(R.id.txt_total);

        quantityTextView.setText("" + quantity);
        total=new Integer(quantity * produk.getHargaJual()) ;
        //hasil = total;
        hargaTotalProduk.setText(total+"");
        harga.setText(formatRupiah.format((double)total));
    }

    @Override
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.shope, menu);
        return true;
    }
}
