package mobile.apps.bi.id.lagipanen.lagipanenapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import mobile.apps.bi.id.lagipanen.lagipanenapp.R;
import mobile.apps.bi.id.lagipanen.lagipanenapp.activity.DetailActivity;
import mobile.apps.bi.id.lagipanen.lagipanenapp.utility.TypefaceTextView;

/**
 * Created by mrx on 2/3/2018.
 */

public class PaketRecycleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView mNamaPaket;
    public ImageView mGambarPaket;
    public TextView mHarga;
    public TextView mSatuan;
    public Context context;

    public PaketRecycleViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        mNamaPaket = (TextView) itemView.findViewById(R.id.mNama);
        mGambarPaket = (ImageView) itemView.findViewById(R.id.mGambar);
        mHarga = (TextView) itemView.findViewById(R.id.mHarga);
        mSatuan = (TextView) itemView.findViewById(R.id.mSatuan);
    }

    @Override
    public void onClick(View view) {
        view.getContext().startActivity(new Intent(view.getContext(), DetailActivity.class));
    }
}
