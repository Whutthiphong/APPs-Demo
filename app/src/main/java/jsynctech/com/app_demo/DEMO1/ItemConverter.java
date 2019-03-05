package jsynctech.com.app_demo.DEMO1;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

import jsynctech.com.app_demo.DEMO1.ModelItem.NextModel;
import jsynctech.com.app_demo.DEMO1.ModelItem.TitleModel;

public class ItemConverter {
    public static TitleModel createTitleModel(String title){
        TitleModel titleModel = new TitleModel();
        titleModel.setTitle(title);
        return titleModel;

    }
    public static List<NextModel> createNextModel(Drawable icon , List<NextModel> list){
        List<NextModel> listItem =new ArrayList<>();
        for(NextModel item : list) {
            NextModel nextModel = new NextModel();
            nextModel.setIcons(icon);
            nextModel.setNextTitle(item.getNextTitle());
            nextModel.setActivity(item.getActivity());
            listItem.add(nextModel);
        }
        return listItem;

    }
}
