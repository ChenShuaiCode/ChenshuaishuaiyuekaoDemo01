package com.bawei.chenshuaishuaiyuekaodemo01.contract;

import com.bawei.chenshuaishuaiyuekaodemo01.model.entity.FlowEntity;

public interface ShopContract {
    interface IModel{
        void getHome(String url,ModelCallBack modelCallBack);
        interface ModelCallBack{
            void success(FlowEntity flowEntity);
            void error(Throwable throwable);
        }
    }
    interface IView{
        void success(FlowEntity flowEntity);
        void error(Throwable throwable);

    }
    interface IPresenter{
        void getHome(String url);

    }

}
