package jsynctech.com.app_demo.DEMO1.Demo1ViewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import jsynctech.com.app_demo.R;

public class NextActivityViewHolder extends RecyclerView.ViewHolder {
    public TextView tvNextTitle;
    public ImageView imageView;
    public NextActivityViewHolder(@NonNull View itemView) {
        super(itemView);
        tvNextTitle = itemView.findViewById(R.id.tvNextTitle);
        imageView = itemView.findViewById(R.id.imageView);
    }
}
