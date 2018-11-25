package mobile.apps.bi.id.lagipanen.lagipanenapp.service;

import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by hsn on 01/03/2017.
 */

public class FirebaseIDService extends FirebaseInstanceIdService {
    private static final String TAG = "FirebaseIDService";

    /*@Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        // TODO: Implement this method to send any registration to your app's servers.
        sendRegistrationToServer(refreshedToken);
    }

    *//**
     * Persist token to third-party servers.
     *
     * Modify this method to associate the user's FCM InstanceID token with any server-side account
     * maintained by your application.
     *
     * @param token_device The new token.
     *//*
    private void sendRegistrationToServer(String token_device) {

        PrefManager prf = new PrefManager( getApplicationContext());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
            ApiEndpointService apiService = retrofit.create(ApiEndpointService.class);
        Call<ResponseUser> result = apiService.setTokenDevice("Bearer "+prf.getString("token"),token_device);
        result.enqueue(new Callback<ResponseUser>() {
            @Override
            public void onResponse(Call<ResponseUser> call, Response<ResponseUser> response) {
                if(response.isSuccessful()){
                    Log.v(TAG,"Hassan : "+response.body().getMessage());
                }

            }

            @Override
            public void onFailure(Call<ResponseUser> call, Throwable t) {
                Log.v(TAG,"Hassan : "+ t.getMessage().toString());
            }
        });
    }*/
}