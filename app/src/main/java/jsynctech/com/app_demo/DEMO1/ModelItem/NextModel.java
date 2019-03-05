package jsynctech.com.app_demo.DEMO1.ModelItem;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;

import jsynctech.com.app_demo.DEMO1.BaseItem;
import jsynctech.com.app_demo.DEMO1.ItemType;

public class NextModel extends BaseItem {
    private String nextTitle;
    private String className;
    private Drawable icons;
    private  Class<? extends  AppCompatActivity> activity;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

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

    public NextModel() {
        super(ItemType.NEXT_ACTIVITY_TYPE);
    }
}
