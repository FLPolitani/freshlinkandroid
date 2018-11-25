package politanismd.freshlink.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

import politanismd.freshlink.R;

public class SliderContent extends IntroActivity {
    private final Handler waitHandler = new Handler();
    private final Runnable waitCallback = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(SliderContent.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    };

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
                .image(R.drawable.ic_008_vegetables_1)
                .background(R.color.colorWhite)
                .backgroundDark(R.color.colorAccent)
                .build());

        addSlide(new SimpleSlide.Builder()
                .title("Murah")
                .description(R.string.stape2)
                .image(R.drawable.ic_get_money)
                .background(R.color.colorWhite)
                .backgroundDark(R.color.colorAccent)
                .build());

        addSlide(new SimpleSlide.Builder()
                .title("Free Ongkir")
                .description(R.string.stape3)
                .image(R.drawable.ic_delivery_truck)
                .background(R.color.colorWhite)
                .backgroundDark(R.color.colorAccent)
                .build());
    }
}
