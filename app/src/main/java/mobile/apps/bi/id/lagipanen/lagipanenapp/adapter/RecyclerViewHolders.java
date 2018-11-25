package mobile.apps.bi.id.lagipanen.lagipanenapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import mobile.apps.bi.id.lagipanen.lagipanenapp.R;
import mobile.apps.bi.id.lagipanen.lagipanenapp.utility.TypefaceTextView;

public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TypefaceTextView countryPaket;
    public TypefaceTextView countryHarga;

    public RecyclerViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        countryPaket = (TypefaceTextView) itemView.findViewById(R.id.paket);
        countryHarga = (TypefaceTextView) itemView.findViewById(R.id.harga);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Clicked Country Position = " + getPosition(), Toast.LENGTH_SHORT).show();
    }
}