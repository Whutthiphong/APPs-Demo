package jsynctech.com.app_demo.DEMO1;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

import jsynctech.com.app_demo.DEMO1.ModelItem.ViewDetailModel;
import jsynctech.com.app_demo.DEMO1.ModelItem.TitleModel;

public class ItemConverter {
    public static TitleModel createTitleModel(String title) {
        TitleModel titleModel = new TitleModel();
        titleModel.setTitle(title);
        return titleModel;
    }

    public static List<ViewDetailModel> createNextModel(Drawable icon, List<ViewDetailModel> list) {
        List<ViewDetailModel> listItem = new ArrayList<>();
        for (ViewDetailModel item : list) {
            ViewDetailModel viewDetailModel = new ViewDetailModel();
            if (item.getIcons() == null)
                viewDetailModel.setIcons(icon);
            else
                viewDetailModel.setIcons(item.getIcons());
            viewDetailModel.setNextTitle(item.getNextTitle());
            viewDetailModel.setActivity(item.getActivity());
            listItem.add(viewDetailModel);
        }
        return listItem;

    }
}
