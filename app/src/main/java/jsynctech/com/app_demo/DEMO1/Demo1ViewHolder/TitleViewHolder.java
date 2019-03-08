package jsynctech.com.app_demo.DEMO1.Demo1ViewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import jsynctech.com.app_demo.R;

public class TitleViewHolder extends RecyclerView.ViewHolder {
    public TextView tvTitle;
    public TitleViewHolder(@NonNull View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tvTitle);
    }
}
