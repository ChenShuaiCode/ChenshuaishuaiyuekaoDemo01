package com.bawei.chenshuaishuaiyuekaodemo01.view.fragment;



import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.chenshuaishuaiyuekaodemo01.R;
import com.bawei.chenshuaishuaiyuekaodemo01.base.BaseFragment;
import com.bawei.chenshuaishuaiyuekaodemo01.contract.ShopContract;
import com.bawei.chenshuaishuaiyuekaodemo01.model.entity.FlowEntity;
import com.bawei.chenshuaishuaiyuekaodemo01.model.entity.GridEntity;
import com.bawei.chenshuaishuaiyuekaodemo01.presenter.ShopPresenter;
import com.bawei.chenshuaishuaiyuekaodemo01.utils.VolleyUtils;
import com.bawei.chenshuaishuaiyuekaodemo01.view.adapter.MyAdapter;
import com.bawei.chenshuaishuaiyuekaodemo01.view.wedgit.FlowLayout;
import com.google.gson.Gson;

import java.net.URLEncoder;
import java.util.List;


public class HomekFragment extends BaseFragment implements ShopContract.IView {
    private FlowLayout flo;
    private RecyclerView recy;
    private EditText ed_keyword;
    private Button btn_sou;


    @Override
    protected void initview(View inflate) {
        flo = (FlowLayout)inflate.findViewById(R.id.flo);
        recy = (RecyclerView)inflate. findViewById(R.id.recy);
        ed_keyword = (EditText)inflate. findViewById(R.id.ed_keyword);
        btn_sou = (Button)inflate. findViewById(R.id.btn_sou);

        flo.setClickflow(new FlowLayout.Clickflow() {
            @Override
            public void clc(String keyword) {
                String encode = URLEncoder.encode(keyword);
                String url="http://172.17.8.100/small/commodity/v1/findCommodityByKeyword/?keyword="+encode+"&count=5&page=1";
                VolleyUtils.getInstance().doGet(url, new VolleyUtils.VolleyCallBack() {
                    @Override
                    public void success(String response) {
                        GridEntity gridEntity = new Gson().fromJson(response, GridEntity.class);
                        List<GridEntity.ResultBean> result = gridEntity.result;
                        MyAdapter myAdapter = new MyAdapter(getActivity(), result);
                        recy.setAdapter(myAdapter);
                    }
                    @Override
                    public void error(Throwable throwable) {

                    }
                });
            }
        });





        btn_sou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(ed_keyword.getText())){
                    Toast.makeText(getActivity(),"不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                String text = ed_keyword.getText().toString();
                flo.addd(text);
                String encode = URLEncoder.encode(text);
                String url="http://172.17.8.100/small/commodity/v1/findCommodityByKeyword/?keyword="+encode+"&count=5&page=1";
                VolleyUtils.getInstance().doGet(url, new VolleyUtils.VolleyCallBack() {
                    @Override
                    public void success(String response) {
                        GridEntity gridEntity = new Gson().fromJson(response, GridEntity.class);
                        List<GridEntity.ResultBean> result = gridEntity.result;
                        MyAdapter myAdapter = new MyAdapter(getActivity(), result);
                        recy.setAdapter(myAdapter);
                    }
                    @Override
                    public void error(Throwable throwable) {

                    }
                });

            }
        });



    }
    @Override
    protected int layoutid() {
        return R.layout.fragment_homek;
    }
    @Override
    protected void initdata() {
        recy.setLayoutManager(new GridLayoutManager(getActivity(),2));
        ShopPresenter shopPresenter = new ShopPresenter(this);
        String s="http://blog.zhaoliang5156.cn/baweiapi/"+ URLEncoder.encode("手机");
        shopPresenter.getHome(s);



    }

    @Override
    public void success(FlowEntity flowEntity) {
        List<String> tags = flowEntity.getTags();

        flo.addView(tags);

    }

    @Override
    public void error(Throwable throwable) {

    }

}
