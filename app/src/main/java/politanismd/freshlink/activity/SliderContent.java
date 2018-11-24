package politanismd.freshlink.activity;

import android.os.Bundle;
import android.view.WindowManager;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

import politanismd.freshlink.R;

public class SliderContent extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setButtonBackVisible(false);
        setButtonNextVisible(true);
        setButtonCtaTintMode(BUTTON_CTA_TINT_MODE_TEXT);

        addSlide(new SimpleSlide.Builder()
                .title("Sehat dan Segar")
                .description(R.string.stape1)
                .image(R.drawable.img_steap_1)
                .background(R.color.colorWhite)
                .backgroundDark(R.color.colorAccent)
                .build());

        addSlide(new SimpleSlide.Builder()
                .title("Murah")
                .description(R.string.stape2)
                .image(R.drawable.img_steap_2)
                .background(R.color.colorWhite)
                .backgroundDark(R.color.colorAccent)
                .build());

        addSlide(new SimpleSlide.Builder()
                .title("Free Ongkir")
                .description(R.string.stape3)
                .image(R.drawable.img_steap_3)
                .background(R.color.colorWhite)
                .backgroundDark(R.color.colorAccent)
                .build());
    }
}
