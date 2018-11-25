package mobile.apps.bi.id.lagipanen.lagipanenapp.adapter.SliderDashboard;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Random;

import mobile.apps.bi.id.lagipanen.lagipanenapp.R;


/**
 * Created by workstation on 6/19/2016.
 */
public class SlideHomeAdapter extends PagerAdapter
{

    private final Random random = new Random();
    private int mSize;
    private Button btn;
    Context context;

    public SlideHomeAdapter(Context context)
    {
        this.context=context;
        mSize = 4;
    }

    public SlideHomeAdapter(int count)
    {
        mSize = count;
    }

    @Override
    public int getCount()
    {
        return mSize;
    }

    @Override
    public boolean isViewFromObject(View view, Object object)
    {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup view, int position, Object object)
    {
        view.removeView((View) object);
    }

    @Override
    public Object instantiateItem(final ViewGroup view, final int position)
    {
        final ImageView imageView = new ImageView(view.getContext());

        final String[] myUrl = new String[]{
                context.getResources().getString(R.string.url_base) + "a.png",
                context.getResources().getString(R.string.url_base) + "b.png",
                context.getResources().getString(R.string.url_base) + "c.png",
                context.getResources().getString(R.string.url_base) + "d.png"};

        Picasso.with(context).load(String.valueOf(myUrl[position])).fit()
                .placeholder(R.drawable.pdam).error(R.drawable.pdam)
                .into(imageView);

        view.addView(imageView);
        return imageView;
    }
    public void addItem()
    {
        mSize++;
        notifyDataSetChanged();
    }

    public void removeItem()
    {
        mSize--;
        mSize = mSize < 0 ? 0 : mSize;

        notifyDataSetChanged();
    }
}
