package com.bawei.chenshuaishuaiyuekaodemo01.model;

import com.bawei.chenshuaishuaiyuekaodemo01.contract.ShopContract;
import com.bawei.chenshuaishuaiyuekaodemo01.model.entity.FlowEntity;
import com.bawei.chenshuaishuaiyuekaodemo01.utils.VolleyUtils;
import com.google.gson.Gson;

public class ShopModel implements ShopContract.IModel {
    @Override
    public void getHome(String url, final ModelCallBack modelCallBack) {
        VolleyUtils.getInstance().doGet(url, new VolleyUtils.VolleyCallBack() {
            @Override
            public void success(String response) {
                FlowEntity flowEntity = new Gson().fromJson(response, FlowEntity.class);
                modelCallBack.success(flowEntity);
            }
            @Override
            public void error(Throwable throwable) {
                modelCallBack.error(throwable);
            }
        });
    }
}
