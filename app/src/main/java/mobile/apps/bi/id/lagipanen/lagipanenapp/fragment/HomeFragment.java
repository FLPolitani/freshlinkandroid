package mobile.apps.bi.id.lagipanen.lagipanenapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import cn.pedant.SweetAlert.SweetAlertDialog;
import mobile.apps.bi.id.lagipanen.lagipanenapp.R;
import mobile.apps.bi.id.lagipanen.lagipanenapp.activity.LoginActivity;
import mobile.apps.bi.id.lagipanen.lagipanenapp.adapter.ProdukAdapter;
import mobile.apps.bi.id.lagipanen.lagipanenapp.config.Const;
import mobile.apps.bi.id.lagipanen.lagipanenapp.manager.PrefManager;
import mobile.apps.bi.id.lagipanen.lagipanenapp.model.ResponseProduk;
import mobile.apps.bi.id.lagipanen.lagipanenapp.service.ApiEndpointService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class HomeFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private GridLayoutManager lLayout;
    Context context;
    private RecyclerView rView;
    private Retrofit retrofit;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.content_sayur, container, false);

        context=getActivity();
        initializeRetrofit();

        lLayout = new GridLayoutManager(getContext(), 2,GridLayoutManager.VERTICAL,false);

        rView = view.findViewById(R.id.recycler_view);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        getProduk(context);

        return view;
    }

    private void initializeRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void getProduk(final Context context){
        //showProgress(true);
        try {
            ApiEndpointService apiService = retrofit.create(ApiEndpointService.class);
            Call<ResponseProduk> result = apiService.getProduk();
            result.enqueue(new Callback<ResponseProduk>() {
                @Override
                public void onResponse(Call<ResponseProduk> call, Response<ResponseProduk> response) {
                    //showProgress(false);
                    if(response.isSuccessful() ){
                        if(response.body().getSuccess()){
                            rView.setAdapter(new ProdukAdapter(context,response.body().getData()));
                        }else{

                        }
                    }else{

                        try {
                            JSONObject jObjError = new JSONObject(response.errorBody().string());

                            if(jObjError.getString("error").equalsIgnoreCase("token_expired")){
                                new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                                        .setTitleText("Aplikasi Bermasalah")
                                        .setContentText("Login anda telah kadaluarsa. Silahkan Login ulang")
                                        .setConfirmText("Login Ulang")
                                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                            @Override
                                            public void onClick(SweetAlertDialog sDialog) {
                                                PrefManager prf= new PrefManager(context);
                                                prf.remove("token");
                                                Intent intent= new Intent(getActivity(),LoginActivity.class);
                                                startActivity(intent);
                                                getActivity().finish();
                                                sDialog.dismissWithAnimation();
                                            }
                                        })
                                        .show();
                            }else{
                                new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                                        .setTitleText("Aplikasi Bermasalah")
                                        .setContentText("Respon server bermasalah")
                                        .setConfirmText("Tutup")
                                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                            @Override
                                            public void onClick(SweetAlertDialog sDialog) {
                                                //getAccessToken();
                                                sDialog.dismissWithAnimation();
                                            }
                                        })
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //showMessageDialog("Sistem Bermasalah Hubungi Administrator");
                    }
                }

                @Override
                public void onFailure(Call<ResponseProduk> call, Throwable t) {
                    //showProgress(false);
                    new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                            .setTitleText("Aplikasi Bermasalah")
                            .setContentText("Koneksi / Jaringan Internet Bermasalah")
                            .setConfirmText("Tutup")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    //getAccessToken();
                                    sDialog.dismissWithAnimation();
                                }
                            })
                            .show();
                }


            });


        } catch (Exception e) {
            //showProgress(false);
            new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Aplikasi Bermasalah")
                    .setContentText("Koneksi / Jaringan Internet Bermasalah")
                    .setConfirmText("Tutup")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            //getListUser();
                            sDialog.dismissWithAnimation();
                        }
                    })
                    .show();
        }
    }

//    private List<ItemObject> getAllItemList(){
//
////        List<ItemObject> allItems = new ArrayList<ItemObject>();
////        allItems.add(new ItemObject("PAKET A", "Rp. 18.000.000"));
////        allItems.add(new ItemObject("PAKET B", "Rp. 20.000.000"));
////        allItems.add(new ItemObject("PAKET C", "Rp. 22.000.000"));
////        allItems.add(new ItemObject("PAKET D", "Rp. 30.000.000"));
////        allItems.add(new ItemObject("PAKET E", "Rp. 50.000.000"));
//
////        return allItems;
//    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    public static HomeFragment newInstance(int index) {
        HomeFragment fragment = new HomeFragment();
        Bundle b = new Bundle();
        b.putInt("index", index);
        fragment.setArguments(b);
        return fragment;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
