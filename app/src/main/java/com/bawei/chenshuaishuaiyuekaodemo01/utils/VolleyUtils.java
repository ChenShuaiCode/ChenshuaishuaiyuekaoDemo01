package com.bawei.chenshuaishuaiyuekaodemo01.utils;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.chenshuaishuaiyuekaodemo01.app.App;

public class VolleyUtils {
    private RequestQueue requestQueue;
    private static VolleyUtils volleyUtils;
    private VolleyUtils(){
        requestQueue=Volley.newRequestQueue(App.getContext());
    }
    public static VolleyUtils getInstance(){
        if (volleyUtils==null){
            synchronized (VolleyUtils.class){
                if (volleyUtils==null){
                    volleyUtils=new VolleyUtils();
                }
            }
        }
        return volleyUtils;
    }
    public void doGet(String url, final VolleyCallBack volleyCallBack){
        StringRequest stringRequest=new StringRequest(StringRequest.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (volleyCallBack!=null){
                    volleyCallBack.success(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (volleyCallBack!=null){
                    volleyCallBack.error(error);
                }
            }
        });
        requestQueue.add(stringRequest);
    }
    public interface VolleyCallBack{
        void success(String response);
        void error(Throwable throwable);
    }
}