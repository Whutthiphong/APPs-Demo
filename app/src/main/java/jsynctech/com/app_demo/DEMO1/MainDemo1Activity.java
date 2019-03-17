package jsynctech.com.app_demo.DEMO1;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import jsynctech.com.app_demo.DEMO1.Interface.InterfaceNext;
import jsynctech.com.app_demo.DEMO1.ModelItem.ViewDetailModel;
import jsynctech.com.app_demo.R;

import static jsynctech.com.app_demo.DEMO1.ItemConverter.createNextModel;
import static jsynctech.com.app_demo.DEMO1.ItemConverter.createTitleModel;

public class MainDemo1Activity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<ViewDetailModel> viewDetailModelList;
    List<BaseItem> mListBaseItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_demo1);
        //set instant nextModel
        viewDetailModelList = new ArrayList<>();
        //create dumy data
        try {
            ViewDetailModel item = new ViewDetailModel();
            item.setNextTitle("Form");
            //class อะไรก็ได้ที่ extends AppCompatActivity
            //ที่ get class -> Class.forName("") เพราะว่าจะส่ง path class มาจาก service
            item.setIcons(getResources().getDrawable(R.drawable.ic_event_note_black_24dp));
            item.setActivity((Class<? extends AppCompatActivity>) Class.forName("jsynctech.com.app_demo.DEMO1.DemoDetail.FormActivity"));
            viewDetailModelList.add(item);
            item = new ViewDetailModel();
            item.setNextTitle("Buttons");
            item.setIcons(getResources().getDrawable(R.drawable.ic_dns_black_24dp));
            item.setActivity((Class<? extends AppCompatActivity>) Class.forName("jsynctech.com.app_demo.DEMO1.DemoDetail.BottomAppBar.BottomAppBarsActivity"));
            viewDetailModelList.add(item);
            item = new ViewDetailModel();
            item.setNextTitle("Notification");
            item.setIcons(getResources().getDrawable(R.drawable.ic_notifications_active_black_24dp));
            item.setActivity((Class<? extends AppCompatActivity>) Class.forName("jsynctech.com.app_demo.DEMO1.DemoDetail.NotifiActivity"));
            viewDetailModelList.add(item);
            item = new ViewDetailModel();
            item.setNextTitle("Notification");
            item.setIcons(getResources().getDrawable(R.drawable.ic_notifications_active_black_24dp));
            item.setActivity((Class<? extends AppCompatActivity>) Class.forName("jsynctech.com.app_demo.DEMO1.DemoDetail.StoreDetailActivity"));
            viewDetailModelList.add(item);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            ViewDetailModel item = new ViewDetailModel();
            item.setNextTitle(e.getMessage());
            item.setIcons(getResources().getDrawable(R.drawable.ic_warning_black_24dp));
            viewDetailModelList.add(item);        }

        mListBaseItem = createBaseItem();
        mRecyclerView = findViewById(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));//set เส้นกัน
        Demo1Adapter demo1Adapter = new Demo1Adapter();
        mRecyclerView.setAdapter(demo1Adapter);
        demo1Adapter.setListItem(mListBaseItem);
        demo1Adapter.setOnItemClickListenerNextActivity(new InterfaceNext() {
            @Override
            public void setOnClickListener(int position) {
                ViewDetailModel item = (ViewDetailModel) mListBaseItem.get(position);
                getApplicationContext().startActivity(new Intent(getApplicationContext(),item .getActivity()));
            }
        });
    }

    private List<BaseItem> createBaseItem() {
        List<BaseItem> mListItem = new ArrayList<>();
        mListItem.add(createTitleModel("SECTION1"));
        mListItem.addAll(createNextModel(getResources().getDrawable(R.drawable.ic_keyboard_arrow_right_black_24dp), viewDetailModelList));
        mListItem.add(createTitleModel("SECTION3"));
        return mListItem;
    }
}
