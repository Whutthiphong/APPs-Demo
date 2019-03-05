package jsynctech.com.app_demo.DEMO1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import jsynctech.com.app_demo.DEMO1.Interface.InterfaceNext;
import jsynctech.com.app_demo.DEMO1.ModelItem.NextModel;
import jsynctech.com.app_demo.R;

import static jsynctech.com.app_demo.DEMO1.ItemConverter.createNextModel;
import static jsynctech.com.app_demo.DEMO1.ItemConverter.createTitleModel;

public class MainDemo1Activity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<NextModel> nextModelList;
    List<BaseItem> mListBaseItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_demo1);
        //set instant nextModel
        nextModelList = new ArrayList<>();

        //create dumy data
        try {
            NextModel item = new NextModel();
            item.setNextTitle("OneActivity");
            item.setActivity((Class<? extends AppCompatActivity>) Class.forName("jsynctech.com.app_demo.DEMO1.ViewNextActivity.OneActivity"));
            nextModelList.add(item);
            item = new NextModel();
            item.setNextTitle("TwoActivity");
            item.setActivity((Class<? extends AppCompatActivity>) Class.forName("jsynctech.com.app_demo.DEMO1.ViewNextActivity.TwoActivity"));
            nextModelList.add(item);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        mListBaseItem = createBaseItem();
        mRecyclerView = findViewById(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        Demo1Adapter demo1Adapter = new Demo1Adapter();
        mRecyclerView.setAdapter(demo1Adapter);
        demo1Adapter.setListItem(mListBaseItem);
        demo1Adapter.setOnItemClickListenerNextActivity(new InterfaceNext() {
            @Override
            public void setOnClickListener(int position) {
                NextModel item = (NextModel) mListBaseItem.get(position);
                getApplicationContext().startActivity(new Intent(getApplicationContext(),item .getActivity()));
            }
        });
    }

    private List<BaseItem> createBaseItem() {
        List<BaseItem> mListItem = new ArrayList<>();
        mListItem.add(createTitleModel("SECTION1"));
        mListItem.addAll(createNextModel(getResources().getDrawable(R.drawable.ic_keyboard_arrow_right_black_24dp), nextModelList));
        mListItem.add(createTitleModel("SECTION3"));
        return mListItem;
    }
}
