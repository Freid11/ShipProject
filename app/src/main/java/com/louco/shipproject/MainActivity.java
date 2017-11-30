package com.louco.shipproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.WindowManager;

import com.santalu.autoviewpager.AutoViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity{

    @BindView(R.id.avp_stock)
    AutoViewPager autoViewPager;

    @BindView(R.id.rv_recommend)
    RecyclerView rvRecommend;

    @BindView(R.id.rv_sale)
    RecyclerView rvSale;

    @BindView(R.id.rv_new_thing)
    RecyclerView rvnew_thing;

    @BindView(R.id.rv_top)
    RecyclerView rvTop;

    @BindView(R.id.rv_ready)
    RecyclerView rvReady;

    @BindView(R.id.rv_look)
    RecyclerView rvLook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        toolbar.setTitle(R.string.title_bar);
        setSupportActionBar(toolbar);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        autoViewPager.setAdapter(new SamplePagerAdapter(getSupportFragmentManager()));

        RVAdapter adapterRecommend = new RVAdapter(this,new int[]{RVAdapter.VOID_CART
                ,RVAdapter.SALE_CART
                ,RVAdapter.VOID_CART
                ,RVAdapter.SALE_CART});
        rvRecommend.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rvRecommend.setAdapter(adapterRecommend);

        RVAdapter adapterSale = new RVAdapter(this,new int[]{RVAdapter.SALE_CART
                ,RVAdapter.DISCONT_CART
                ,RVAdapter.SALE_CART
                ,RVAdapter.DISCONT_CART});
        rvSale.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rvSale.setAdapter(adapterSale);

        RVAdapter adapterNew_thing= new RVAdapter(this,new int[]{RVAdapter.NEW_CART
                ,RVAdapter.NEW_CART
                ,RVAdapter.NEW_CART
                ,RVAdapter.NEW_CART});
        rvnew_thing.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rvnew_thing.setAdapter(adapterNew_thing);

        RVAdapter adapterTop= new RVAdapter(this,new int[]{RVAdapter.SALE_CART
                ,RVAdapter.COMPLECT_CART
                ,RVAdapter.SALE_CART
                ,RVAdapter.COMPLECT_CART});
        rvTop.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rvTop.setAdapter(adapterTop);

        RVAdapterComplect adapter_complect = new RVAdapterComplect(this);
        rvReady.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rvReady.setAdapter(adapter_complect);

        RVAdapter adapterLook= new RVAdapter(this,new int[]{RVAdapter.NEW_CART
                ,RVAdapter.DISCONT_CART
                ,RVAdapter.NEW_CART
                ,RVAdapter.DISCONT_CART});
        rvLook.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rvLook.setAdapter(adapterLook);

    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
