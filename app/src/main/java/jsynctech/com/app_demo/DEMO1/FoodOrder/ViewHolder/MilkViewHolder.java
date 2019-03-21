package jsynctech.com.app_demo.DEMO1.FoodOrder.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import jsynctech.com.app_demo.R;

public class MilkViewHolder extends RecyclerView.ViewHolder {
    public TextView tvMilkName;
    public TextView tvMilkDesc;
    public TextView tvMilkAmount;

    public MilkViewHolder(@NonNull View itemView) {
        super(itemView);
        tvMilkName = itemView.findViewById(R.id.tvMilkName);
        tvMilkDesc = itemView.findViewById(R.id.tvMilkDesc);
        tvMilkAmount = itemView.findViewById(R.id.tvMilkAmount);
    }
}
