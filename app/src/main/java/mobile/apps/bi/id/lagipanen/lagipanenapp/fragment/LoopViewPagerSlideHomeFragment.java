package mobile.apps.bi.id.lagipanen.lagipanenapp.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mobile.apps.bi.id.lagipanen.lagipanenapp.R;
import mobile.apps.bi.id.lagipanen.lagipanenapp.adapter.SliderDashboard.CycleIndicatorSlideImageHome;
import mobile.apps.bi.id.lagipanen.lagipanenapp.adapter.SliderDashboard.LoopViewPagerHome;
import mobile.apps.bi.id.lagipanen.lagipanenapp.adapter.SliderDashboard.SlideHomeAdapter;

public class LoopViewPagerSlideHomeFragment extends Fragment {

    private LoopViewPagerHome viewpager;
    Handler handler;
    Runnable update;

    public LoopViewPagerHome getViewpager() {
        return viewpager;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment_sample_loop_viewpager, container, false);




    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        viewpager = view.findViewById(R.id.viewpager);
        CycleIndicatorSlideImageHome indicator = view.findViewById(R.id.indicator);
        viewpager.setAdapter(new SlideHomeAdapter(this.getContext()));
        indicator.setViewPager(viewpager);

        handler = new Handler();

        update = new Runnable() {
            public void run() {
                int currentPage=viewpager.getCurrentItem();
                if (currentPage == 4) {
                    currentPage = -1;
                }
                viewpager.setCurrentItem(currentPage+1, true);

                handler.postDelayed(update,4000);
            }
        };

        update.run();
        /*new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(update);
            }
        }, 3000);*/
    }
}
