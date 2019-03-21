package jsynctech.com.app_demo.DEMO1.FoodOrder.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import jsynctech.com.app_demo.R;

public class CoffeeViewHolder extends RecyclerView.ViewHolder{

    public TextView tvCoffeeName;
    public TextView tvCoffeeDesc;
    public TextView tvCoffeeAmount;
    public CoffeeViewHolder(@NonNull View itemView) {
        super(itemView);
        tvCoffeeName = itemView.findViewById(R.id.tvCoffeeName);
        tvCoffeeDesc = itemView.findViewById(R.id.tvCoffeeDesc);
        tvCoffeeAmount = itemView.findViewById(R.id.tvCoffeeAmount);
    }
}
