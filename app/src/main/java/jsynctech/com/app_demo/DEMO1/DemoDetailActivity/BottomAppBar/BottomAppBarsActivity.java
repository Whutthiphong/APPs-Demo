package jsynctech.com.app_demo.DEMO1.DemoDetailActivity.BottomAppBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import jsynctech.com.app_demo.R;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BottomAppBarsActivity extends AppCompatActivity {

    FloatingActionButton fab;
    BottomAppBar bottomAppBar;
    RecyclerView mRecyclerView ;
    BottomAppBarAdapter bottomAppBarAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.bottom_bar_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_app_bars);
        fab = findViewById(R.id.fab);
        mRecyclerView = findViewById(R.id.mRecyclerView);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialogFragment bottomSheetDialogFragment = BottomSheetNavigationFragment.newInstance();
                bottomSheetDialogFragment.show(getSupportFragmentManager(), "Bottom Sheet Dialog Fragment");
            }
        });
//        BottomAppBar bar =   findViewById(R.id.bar);
//        setSupportActionBar(bar);
//        bar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                return true;
//            }
//        });
//        ActionBar actionBar = getSupportActionBar();
////        actionBar.setDisplayHomeAsUpEnabled(true);
////        actionBar.setTitle("Buttons");
////        actionBar.hide();
        setUpBottomAppBar();

        bottomAppBarAdapter = new BottomAppBarAdapter();
        mRecyclerView.setLayoutManager( new LinearLayoutManager(this));
        mRecyclerView.setAdapter(bottomAppBarAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));//set เส้นกัน
    }

    private void setUpBottomAppBar() {
        //find id
        bottomAppBar = findViewById(R.id.bar);

        //set bottom bar to Action bar as it is similar like Toolbar
       setSupportActionBar(bottomAppBar);

        //click event over Bottom bar menu item
//        bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item1:
                        Toast.makeText(BottomAppBarsActivity.this, "Notification clicked.", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

    }
}
