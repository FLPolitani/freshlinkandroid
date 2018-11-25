package mobile.apps.bi.id.lagipanen.lagipanenapp.delete;


import android.media.Image;
import android.widget.ImageView;

public class ItemObject {

    private int mGambar;
    private String mHarga;
    private String mNama;
    private String mSatuan;

    public ItemObject(String mHarga, String mNama, int mGambar, String mSatuan) {
        this.mHarga = mHarga;
        this.mGambar = mGambar;
        this.mNama = mNama;
        this.mSatuan = mSatuan;
    }

    public String getmHarga() {
        return mHarga;
    }

    public void setmHarga(String mHarga) {
        this.mHarga = mHarga;
    }

    public String getmNama() {
        return mNama;
    }

    public void setmNama(String mNama) {
        this.mNama = mNama;
    }

    public int getmGambar() {
        return mGambar;
    }

    public void setmGambar(int mGambar) {
        this.mGambar = mGambar;
    }

    public String getmSatuan() {
        return mSatuan;
    }

    public  void setmSatuan (String mSatuan) {
        this.mSatuan = mSatuan;
    }
}
