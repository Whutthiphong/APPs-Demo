package jsynctech.com.app_demo.DEMO1.Main;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import jsynctech.com.app_demo.DEMO1.Main.MainViewHolder.NextActivityViewHolder;
import jsynctech.com.app_demo.DEMO1.Main.MainViewHolder.TitleViewHolder;
import jsynctech.com.app_demo.DEMO1.Main.Interface.InterfaceNext;
import jsynctech.com.app_demo.DEMO1.Main.MainModelItem.ViewDetailModel;
import jsynctech.com.app_demo.DEMO1.Main.MainModelItem.TitleModel;
import jsynctech.com.app_demo.R;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<BaseItem> baseItemList;
    InterfaceNext interfaceNext;
    public MainAdapter() {
        //set instant list
        baseItemList = new ArrayList<>();

    }

    public void setListItem(List<BaseItem> baseItems) {
        this.baseItemList = baseItems;
        notifyDataSetChanged();
    }

    public void setOnItemClickListenerNextActivity(InterfaceNext interfaceNext){
        this.interfaceNext = interfaceNext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view;
        if (viewType == ViewType.TITLE_TYPE) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.demo1_title_item, viewGroup, false);
            return new TitleViewHolder(view);
        } else if (viewType == ViewType.NEXT_ACTIVITY_TYPE) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.demo1_acti_detail_item, viewGroup, false);
            return new NextActivityViewHolder(view);
        }
//        else if (viewType == ViewType.ITEM_TYPE) {
//            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.demo1_title_item, viewGroup, false);
//            return new TitleViewHolder(view);
//        }
        throw new NullPointerException("View Type " + viewType + " doesn't match with any existing order detail type");
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        BaseItem baseItem = baseItemList.get(position);
        if(viewHolder instanceof TitleViewHolder){
            setTitle((TitleViewHolder) viewHolder,(TitleModel) baseItem);
        }else if(viewHolder instanceof NextActivityViewHolder ){
            setNextActivity((NextActivityViewHolder)viewHolder, (ViewDetailModel) baseItem);
        }

    }
    private void  setTitle(TitleViewHolder holder ,TitleModel title){
        holder.tvTitle.setText(title.getTitle());
    }
    private void  setNextActivity(final NextActivityViewHolder holder , ViewDetailModel viewDetailModel){

        holder.tvNextTitle.setText(viewDetailModel.getNextTitle());
        holder.imageView.setImageDrawable(viewDetailModel.getIcons());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                interfaceNext.setOnClickListener(position);
            }
        });
    }
    @Override
    public int getItemCount() {
        if(baseItemList!=null)
            return baseItemList.size();
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return  baseItemList.get(position).getType();
    }
}
