package mobile.apps.bi.id.lagipanen.lagipanenapp.service;

import mobile.apps.bi.id.lagipanen.lagipanenapp.model.ResponseDetailPurchaseOrders;
import mobile.apps.bi.id.lagipanen.lagipanenapp.model.ResponseProduk;
import mobile.apps.bi.id.lagipanen.lagipanenapp.model.ResponseResetPassword;
import mobile.apps.bi.id.lagipanen.lagipanenapp.model.ResponseToken;
import mobile.apps.bi.id.lagipanen.lagipanenapp.model.ResponseUser;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by Eko on 12/07/2017.
 */

public interface ApiEndpointService {


    @FormUrlEncoded
    @POST("token")
    Call<ResponseToken> getAccessToken(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("register")
    Call<ResponseUser> registerUser(@Field("name") String name, @Field("email") String email, @Field("password") String password,
                                    @Field("password_confirmation") String password_confirmation);

    @FormUrlEncoded
    @POST("reset_password")
    Call<ResponseResetPassword> resetPassword(@Field("email") String email);

    @GET("users/show")
    Call<ResponseUser> getUser(@Header("Authorization") String token);

    @Multipart
    @POST("users/update")
    Call<ResponseUser> updateUser(@Header("Authorization") String token,
                                  @Part("name") RequestBody name, @Part("email") RequestBody email, @Part("nik") RequestBody kontak,
                                  @Part("no_sambungan") RequestBody no_sambungan, @Part("pekerjaan") RequestBody pekerjaan,
                                  @Part("alamat") RequestBody alamat,
                                  @Part MultipartBody.Part file);

    @FormUrlEncoded
    @POST("users/password")
    Call<ResponseUser> changePassword(@Header("Authorization") String token, @Field("current-password") String current_password,
                                      @Field("password") String password, @Field("password_confirmation") String password_confirmation);

    @FormUrlEncoded
    @POST("token_device")
    Call<ResponseUser> setTokenDevice(@Header("Authorization") String token, @Field("token_device") String token_device);

    @GET("produks")
    Call<ResponseProduk> getProduk();

    @FormUrlEncoded
    @POST("detail_purchase_orders")
    Call<ResponseDetailPurchaseOrders> updateDetailPurchaseOrders(@Field("purchase_orders_id") int purchaseOrdersId, @Field("produk_id") int produkId,
                                                                  @Field("jumlah") int jumlah, @Field("satuan_id") int satuanId, @Field("harga_jual") int hargaJual);
}
