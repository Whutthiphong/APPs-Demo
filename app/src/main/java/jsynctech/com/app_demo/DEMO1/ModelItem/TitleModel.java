package jsynctech.com.app_demo.DEMO1.ModelItem;

import jsynctech.com.app_demo.DEMO1.BaseItem;
import jsynctech.com.app_demo.DEMO1.ItemType;

public class TitleModel extends BaseItem {
    public String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TitleModel() {
        super(ItemType.TITLE_TYPE);
    }
}
