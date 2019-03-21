package jsynctech.com.app_demo.DEMO1.Main.MainModelItem;

import jsynctech.com.app_demo.DEMO1.Main.BaseItem;
import jsynctech.com.app_demo.DEMO1.Main.ViewType;

public class TitleModel extends BaseItem {
    public String title;

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
