package jsynctech.com.app_demo.DEMO1.FoodOrder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import jsynctech.com.app_demo.DEMO1.FoodOrder.Model.CoffeeModel;
import jsynctech.com.app_demo.DEMO1.FoodOrder.Model.MilkModel;
import jsynctech.com.app_demo.DEMO1.FoodOrder.Model.TeaModel;
import jsynctech.com.app_demo.DEMO1.FoodOrder.Model.TitleModel;
import jsynctech.com.app_demo.DEMO1.FoodOrder.ViewHolder.CoffeeViewHolder;
import jsynctech.com.app_demo.DEMO1.FoodOrder.ViewHolder.MilkViewHolder;
import jsynctech.com.app_demo.DEMO1.FoodOrder.ViewHolder.TeaViewHolder;
import jsynctech.com.app_demo.DEMO1.FoodOrder.ViewHolder.TitleViewHolder;
import jsynctech.com.app_demo.R;

public class CreateOrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private View view;
    List<FoodBaseItem> mListFoodBaseItem;
    OnItemClickListenner itemClickListenner;

    public CreateOrderAdapter() {
        mListFoodBaseItem = new ArrayList<>();
    }

    public void setList(List<FoodBaseItem> mListFoodBaseItem ) {
        this.mListFoodBaseItem = mListFoodBaseItem;
        notifyDataSetChanged();
    }

    public void setOnItemClickListenner(OnItemClickListenner itemClickListenner) {
        this.itemClickListenner = itemClickListenner;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ViewType.COFFEE_TYPE) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food_coffee, parent, false);
            return new CoffeeViewHolder(view);
        } else if (viewType == ViewType.MILK_TYPE) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food_milk, parent, false);
            return new MilkViewHolder(view);
        } else if (viewType == ViewType.TEA_TYPE) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food_tea, parent, false);
            return new TeaViewHolder(view);
        } else if (viewType == ViewType.TITLE_TYPE) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food_title, parent, false);
            return new TitleViewHolder(view);
        }
        throw new NullPointerException("View Type " + viewType + " doesn't match with any existing order detail type");
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        FoodBaseItem item = mListFoodBaseItem.get(position);
        if (holder instanceof CoffeeViewHolder) {
            setDataCoffee((CoffeeViewHolder) holder, (CoffeeModel) item);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListenner.onItemClick(position);
                }
            });
        } else if (holder instanceof TeaViewHolder) {
            setDataTea((TeaViewHolder) holder, (TeaModel) item);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListenner.onItemClick(position);
                }
            });
        } else if (holder instanceof TitleViewHolder) {
            setDataTitle((TitleViewHolder) holder, (TitleModel) item);

        } else if (holder instanceof MilkViewHolder) {
            setDataMilk((MilkViewHolder) holder, (MilkModel) item);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListenner.onItemClick(position);
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mListFoodBaseItem.get(position).getType();
    }

    @Override
    public int getItemCount() {
        if (mListFoodBaseItem != null)
            return mListFoodBaseItem.size();
        return 0;
    }

    private void setDataMilk(MilkViewHolder holder, MilkModel item) {
        holder.tvMilkName.setText(item.getProductName());
        holder.tvMilkDesc.setText(item.getProductDesc());
        if (item.getAmount() > 0)
            holder.tvMilkAmount.setText("x" + String.valueOf(item.getAmount()));
        else
            holder.tvMilkAmount.setText("");

    }

    private void setDataTitle(TitleViewHolder holder, TitleModel item) {

        holder.tvTitle.setText(item.getTitle());
        holder.imvTitle.setImageDrawable(item.getIcons());
    }

    private void setDataTea(TeaViewHolder holder, TeaModel item) {
        holder.tvTeaName.setText(item.getProductName());
        holder.tvTeaDesc.setText(item.getProductDesc());
        if (item.getAmount() > 0)
            holder.tvTeaAmount.setText("x" + String.valueOf(item.getAmount()));
        else
            holder.tvTeaAmount.setText("");

    }

    private void setDataCoffee(CoffeeViewHolder holder, CoffeeModel item) {

        holder.tvCoffeeName.setText(item.getProductName());
        holder.tvCoffeeDesc.setText(item.getProductDesc());
        if (item.getAmount() > 0)
            holder.tvCoffeeAmount.setText("x" + String.valueOf(item.getAmount()));
        else
            holder.tvCoffeeAmount.setText("");

    }

    interface OnItemClickListenner {
        void onItemClick(int position);
    }

}
