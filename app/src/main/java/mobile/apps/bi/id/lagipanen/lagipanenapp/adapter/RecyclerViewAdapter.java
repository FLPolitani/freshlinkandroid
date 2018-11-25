package mobile.apps.bi.id.lagipanen.lagipanenapp.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mobile.apps.bi.id.lagipanen.lagipanenapp.R;
import mobile.apps.bi.id.lagipanen.lagipanenapp.delete.ItemObject;

public class RecyclerViewAdapter extends RecyclerView.Adapter<PaketRecycleViewHolder> {

    private List<ItemObject> itemList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<ItemObject> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public PaketRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_paket, null);
        PaketRecycleViewHolder rcv = new PaketRecycleViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(PaketRecycleViewHolder holder, int position) {
        holder.mGambarPaket.setImageResource(itemList.get(position).getmGambar());
        holder.mHarga.setText(itemList.get(position).getmHarga());
        holder.mNamaPaket.setText(itemList.get(position).getmNama());
        holder.mSatuan.setText(itemList.get(position).getmSatuan());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
