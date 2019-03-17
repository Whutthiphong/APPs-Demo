package jsynctech.com.app_demo.DEMO1.DemoDetail.BottomAppBar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import jsynctech.com.app_demo.R;

public class BottomAppBarAdapter extends RecyclerView.Adapter<BottomAppBarAdapter.ViewHolder> {
    View view;
    List<ItemBottomBar> list  ;

    public BottomAppBarAdapter() {
        list = new ArrayList<>();
    }
    public void setListItem(ArrayList<ItemBottomBar> list){
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bottom_bar,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if(list!=null){
            return  10;
        }
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
