package mobile.apps.bi.id.lagipanen.lagipanenapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import mobile.apps.bi.id.lagipanen.lagipanenapp.R;
import mobile.apps.bi.id.lagipanen.lagipanenapp.activity.DetailActivity;
import mobile.apps.bi.id.lagipanen.lagipanenapp.model.Produk;

import static mobile.apps.bi.id.lagipanen.lagipanenapp.config.Const.BASE_URL;

public class ProdukAdapter extends RecyclerView.Adapter<ProdukAdapter.ProdukRecyclerViewHolder> {

    private Context context;
    private List<Produk> itemList;
    Locale localeID = new Locale("in", "ID");
    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

    public ProdukAdapter(Context context, List<Produk> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public ProdukRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_paket, null);
        ProdukRecyclerViewHolder rcv = new ProdukRecyclerViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(ProdukRecyclerViewHolder holder, int position) {
        holder.mNamaProduk.setText(itemList.get(position).getNama()+"");
        holder.mHarga.setText(formatRupiah.format((double)itemList.get(position).getHargaJual())+"");
        holder.mSatuan.setText(itemList.get(position).getSatuan().getNama());
        Picasso.with(context)
                .load(BASE_URL+itemList.get(position).getFoto())
                .error(R.drawable.no_image)
                .into(holder.mGambarPaket);
        holder.produk = itemList.get(position);
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public class ProdukRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView mNamaProduk;
        public ImageView mGambarPaket;
        public TextView mHarga;
        public TextView mSatuan;
        public Produk produk;

        Context context;

        public ProdukRecyclerViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            itemView.setOnClickListener(this);
            mNamaProduk = (TextView) itemView.findViewById(R.id.mNama);
            mGambarPaket = (ImageView) itemView.findViewById(R.id.mGambar);
            mHarga = (TextView) itemView.findViewById(R.id.mHarga);
            mSatuan = (TextView) itemView.findViewById(R.id.mSatuan);
        }

        @Override
        public void onClick(View view) {
            Intent intent= new Intent(context ,DetailActivity.class);
            intent.putExtra("produk", (Serializable) produk);
            context.startActivity (intent);
        }
    }
}
