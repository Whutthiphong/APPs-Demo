package jsynctech.com.app_demo.DEMO1.Demo1ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

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
