package jsynctech.com.app_demo.DEMO1.FoodOrder.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import jsynctech.com.app_demo.R;

public class TeaViewHolder extends RecyclerView.ViewHolder {

    public TextView tvTeaName;
    public TextView tvTeaDesc;
    public TextView tvTeaAmount;
    public TeaViewHolder(@NonNull View itemView) {
        super(itemView);
        tvTeaName = itemView.findViewById(R.id.tvTeaName);
        tvTeaDesc = itemView.findViewById(R.id.tvTeaDesc);
        tvTeaAmount = itemView.findViewById(R.id.tvTeaAmount);
    }
}
