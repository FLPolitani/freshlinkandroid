package mobile.apps.bi.id.lagipanen.lagipanenapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mobile.apps.bi.id.lagipanen.lagipanenapp.R;
import mobile.apps.bi.id.lagipanen.lagipanenapp.model.Produk;

public class AdapterProduk extends RecyclerView.Adapter<RecyclerViewHolders> {

    private List<Produk> itemList;
    private Context context;

    public AdapterProduk(Context context, List<Produk> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_progress, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.countryPaket.setText(itemList.get(position).getNama());
        holder.countryHarga.setText(itemList.get(position).getHargaJual());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
