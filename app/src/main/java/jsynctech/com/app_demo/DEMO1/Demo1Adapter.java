package jsynctech.com.app_demo.DEMO1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import jsynctech.com.app_demo.DEMO1.Demo1ViewHolder.NextActivityViewHolder;
import jsynctech.com.app_demo.DEMO1.Demo1ViewHolder.TitleViewHolder;
import jsynctech.com.app_demo.DEMO1.Interface.InterfaceNext;
import jsynctech.com.app_demo.DEMO1.ModelItem.NextModel;
import jsynctech.com.app_demo.DEMO1.ModelItem.TitleModel;
import jsynctech.com.app_demo.R;

public class Demo1Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<BaseItem> baseItemList;
    InterfaceNext interfaceNext;
    public Demo1Adapter() {
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
        if (viewType == ItemType.TITLE_TYPE) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.demo1_title_item, viewGroup, false);
            return new TitleViewHolder(view);
        } else if (viewType == ItemType.NEXT_ACTIVITY_TYPE) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.demo1_next_acti_item, viewGroup, false);
            return new NextActivityViewHolder(view);
        }
//        else if (viewType == ItemType.ITEM_TYPE) {
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
            setNextActivity((NextActivityViewHolder)viewHolder, (NextModel) baseItem);
        }

    }
    private void  setTitle(TitleViewHolder holder ,TitleModel title){
        holder.tvTitle.setText(title.getTitle());
    }
    private void  setNextActivity(final NextActivityViewHolder holder , NextModel nextModel){

        holder.tvNextTitle.setText(nextModel.getNextTitle());
        holder.imageView.setImageDrawable(nextModel.getIcons());
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
