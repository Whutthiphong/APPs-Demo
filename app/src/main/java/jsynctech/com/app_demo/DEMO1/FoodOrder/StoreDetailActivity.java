package jsynctech.com.app_demo.DEMO1.FoodOrder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import jsynctech.com.app_demo.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
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
        setInstances();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//set arrow back
        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        CreateOrderAdapter adapter  = new CreateOrderAdapter();
//        recycleFoodMenu.setLayoutManager(new LinearLayoutManager(this));
//        recycleFoodMenu.setAdapter(adapter);

        btnCreateOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StoreDetailActivity.this, CreateOrderActivity.class));
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home: {
                onBackPressed();
//                NavUtils.navigateUpFromSameTask(this);
                return true;
            }
            default: {
                return super.onOptionsItemSelected(item);
            }
        }
    }

    private void setInstances() {
        toolbar = findViewById(R.id.toolbar);
        mCollapsingToolbarLayout = findViewById(R.id.collapsingToolbarLayout);
        btnCreateOrder = findViewById(R.id.btnCreateOrder);
//        tab1 = findViewById(R.id.tab1);
        mCollapsingToolbarLayout.setTitle(getString(R.string.jsync_coffee));


        // createTab();
    }

    private void createTab() {
        tab1.addTab(tab1.newTab().setText("TAB1"));
        tab1.addTab(tab1.newTab().setText("TAB2"));
        tab1.addTab(tab1.newTab().setText("TAB3"));
        tab1.addTab(tab1.newTab().setText("TAB4"));
        tab1.addTab(tab1.newTab().setText("TAB5"));
        tab1.addTab(tab1.newTab().setText("TAB6"));
        tab1.addTab(tab1.newTab().setText("TAB7"));

    }
}
