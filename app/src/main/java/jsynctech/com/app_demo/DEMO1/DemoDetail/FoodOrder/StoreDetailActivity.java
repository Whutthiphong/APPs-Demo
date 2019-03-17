package jsynctech.com.app_demo.DEMO1.DemoDetail.FoodOrder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import jsynctech.com.app_demo.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.widget.Toolbar;

public class StoreDetailActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tab1;
    CollapsingToolbarLayout mCollapsingToolbarLayout;
//    RecyclerView recycleFoodMenu;
    MaterialButton btnCreateOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grab_food_order);
        initInstances();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//set arrow back
        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        CreateOrderAdapter adapter  = new CreateOrderAdapter();
//        recycleFoodMenu.setLayoutManager(new LinearLayoutManager(this));
//        recycleFoodMenu.setAdapter(adapter);

        btnCreateOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StoreDetailActivity.this,CreateOrderActivity.class));
            }
        });

    }

    private void initInstances() {
        toolbar =  findViewById(R.id.toolbar);
        mCollapsingToolbarLayout =  findViewById(R.id.collapsingToolbarLayout);
        btnCreateOrder =  findViewById(R.id.btnCreateOrder);
//        tab1 = findViewById(R.id.tab1);
        mCollapsingToolbarLayout.setTitle(getString(R.string.txt_amazon));


       // createTab();
    }
    private void createTab(){
        tab1.addTab(tab1.newTab().setText("TAB1"));
        tab1.addTab(tab1.newTab().setText("TAB2"));
        tab1.addTab(tab1.newTab().setText("TAB3"));
        tab1.addTab(tab1.newTab().setText("TAB4"));
        tab1.addTab(tab1.newTab().setText("TAB5"));
        tab1.addTab(tab1.newTab().setText("TAB6"));
        tab1.addTab(tab1.newTab().setText("TAB7"));

    }
}
