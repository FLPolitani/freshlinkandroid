package mobile.apps.bi.id.lagipanen.lagipanenapp.activity;

import android.os.Bundle;
import android.view.WindowManager;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

import mobile.apps.bi.id.lagipanen.lagipanenapp.R;

public class SliderContent extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setButtonBackVisible(false);
        setButtonNextVisible(true);
        setButtonCtaTintMode(BUTTON_CTA_TINT_MODE_TEXT);

        addSlide(new SimpleSlide.Builder()
                .title("Investasi mudah")
                .description(R.string.stape1)
                .image(R.drawable.img_steap_1)
                .background(R.color.colorWhite)
                .backgroundDark(R.color.colorAccent)
                .build());

        addSlide(new SimpleSlide.Builder()
                .title("Keuntungan didapat")
                .description(R.string.stape2)
                .image(R.drawable.img_steap_2)
                .background(R.color.colorWhite)
                .backgroundDark(R.color.colorAccent)
                .build());

        addSlide(new SimpleSlide.Builder()
                .title("Mulai berinvestasi")
                .description(R.string.stape3)
                .image(R.drawable.img_steap_3)
                .background(R.color.colorWhite)
                .backgroundDark(R.color.colorAccent)
                .build());
    }
}
