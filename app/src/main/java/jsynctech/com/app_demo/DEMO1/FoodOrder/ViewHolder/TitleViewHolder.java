package jsynctech.com.app_demo.DEMO1.FoodOrder.ViewHolder;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import jsynctech.com.app_demo.R;

public class TitleViewHolder extends RecyclerView.ViewHolder {
    public TextView tvTitle;
    public ImageView imvTitle;
    public TitleViewHolder(@NonNull View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        imvTitle = itemView.findViewById(R.id.imvTitle);
    }
}
