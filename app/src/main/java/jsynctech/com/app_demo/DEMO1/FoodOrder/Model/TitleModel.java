package jsynctech.com.app_demo.DEMO1.FoodOrder.Model;

import android.graphics.drawable.Drawable;

import jsynctech.com.app_demo.DEMO1.FoodOrder.FoodBaseItem;
import jsynctech.com.app_demo.DEMO1.FoodOrder.ViewType;
import jsynctech.com.app_demo.DEMO1.Main.BaseItem;

public class TitleModel extends FoodBaseItem {
    public String title;

    private Drawable icons;

    public Drawable getIcons() {
        return icons;
    }

    public void setIcons(Drawable icons) {
        this.icons = icons;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TitleModel() {
        super(ViewType.TITLE_TYPE);
    }
}
