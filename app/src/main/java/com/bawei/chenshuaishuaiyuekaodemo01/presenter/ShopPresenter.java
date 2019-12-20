package com.bawei.chenshuaishuaiyuekaodemo01.presenter;

import com.bawei.chenshuaishuaiyuekaodemo01.contract.ShopContract;
import com.bawei.chenshuaishuaiyuekaodemo01.model.ShopModel;
import com.bawei.chenshuaishuaiyuekaodemo01.model.entity.FlowEntity;

public class ShopPresenter implements ShopContract.IPresenter {
    private ShopContract.IView iView;
    private ShopModel model;

    public ShopPresenter(ShopContract.IView iView) {
        this.iView = iView;
        model=new ShopModel();
    }

    @Override
    public void getHome(String url) {
        model.getHome(url, new ShopContract.IModel.ModelCallBack() {
            @Override
            public void success(FlowEntity flowEntity) {
                iView.success(flowEntity);
            }
            @Override
            public void error(Throwable throwable) {
                iView.error(throwable);
            }
        });

    }
}
