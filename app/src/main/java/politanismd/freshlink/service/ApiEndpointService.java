package politanismd.freshlink.service;

import politanismd.freshlink.model.ResponseToken;
import politanismd.freshlink.model.ResponseUser;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;


public interface ApiEndpointService {
    @FormUrlEncoded
    @POST("token")
    Call<ResponseToken> getAccessToken(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("token_device")
    Call<ResponseUser> setTokenDevice(@Header("Authorization") String token, @Field("token_device") String token_device);

    @FormUrlEncoded
    @POST("register")
    Call<ResponseUser> registerUser(@Field("name") String name, @Field("email") String email, @Field("password") String password,
                                    @Field("password_confirmation") String password_confirmation);


}
