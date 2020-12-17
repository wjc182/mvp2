package com.example.p7day03work;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.p7day03work.adapter.Myadafel;
import com.example.p7day03work.base.BaseActivity;
import com.example.p7day03work.bean.Bean;
import com.example.p7day03work.contract.MainContract;
import com.example.p7day03work.presenter.PresenterImp;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<PresenterImp> implements MainContract.IViews {

    private RecyclerView rec;
    private ArrayList<Bean.DataDTO> list;
    private Myadafel myadafel;


    @Override
    protected void initView() {
        rec=findViewById(R.id.rew_main);
        rec.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();

        myadafel = new Myadafel(this, list);
        rec.setAdapter(myadafel);
    }

    @Override
    protected void initData() {
        presenter.pre();
    }

    @Override
    protected int getDataId() {
        return R.layout.activity_main;
    }

    @Override
    protected PresenterImp getPresenter() {
        return new PresenterImp();
    }

    @Override
    public void getData(Bean bean) {
        List<Bean.DataDTO> data = bean.getData();
        list.addAll(data);
        myadafel.notifyDataSetChanged();
    }

    @Override
    public void no(String error) {
        Log.e("tag",error);
    }
}