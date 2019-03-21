package jsynctech.com.app_demo.DEMO1.Main.MainModelItem;

import android.graphics.drawable.Drawable;
import androidx.appcompat.app.AppCompatActivity;

import jsynctech.com.app_demo.DEMO1.Main.BaseItem;
import jsynctech.com.app_demo.DEMO1.Main.ViewType;

public class ViewDetailModel extends BaseItem {
    private String nextTitle;
    private Drawable icons;
    private  Class<? extends  AppCompatActivity> activity;


    public  Class<? extends AppCompatActivity> getActivity() {
        return activity;
    }

    public void setActivity( Class<? extends AppCompatActivity> activity) {
        this.activity = activity;
    }

    public Drawable getIcons() {
        return icons;
    }

    public void setIcons(Drawable icons) {
        this.icons = icons;
    }

    public String getNextTitle() {
        return nextTitle;
    }

    public void setNextTitle(String nextTitle) {
        this.nextTitle = nextTitle;
    }

    public ViewDetailModel() {
        super(ViewType.NEXT_ACTIVITY_TYPE);
    }
}
