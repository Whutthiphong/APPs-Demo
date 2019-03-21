package jsynctech.com.app_demo.DEMO1.FoodOrder;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import jsynctech.com.app_demo.DEMO1.FoodOrder.Model.CoffeeModel;
import jsynctech.com.app_demo.DEMO1.FoodOrder.Model.MilkModel;
import jsynctech.com.app_demo.DEMO1.FoodOrder.Model.TeaModel;
import jsynctech.com.app_demo.DEMO1.FoodOrder.Model.TitleModel;
import jsynctech.com.app_demo.R;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class CreateOrderActivity extends AppCompatActivity {
    List<FoodBaseItem> mListOrderItme;
    RecyclerView recycleViewCreateOrder;
    CreateOrderAdapter mCreateOrderAdapter;
    TextView tvTotalPrice;
    Toolbar toobCreateOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);

        setInstance();

        setSupportActionBar(toobCreateOrder);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//set arrow back
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("ListFoods");
        mListOrderItme = createBaseItem();
        recycleViewCreateOrder.setLayoutManager(new LinearLayoutManager(this));
        recycleViewCreateOrder.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));//set เส้นกัน
        recycleViewCreateOrder.setAdapter(mCreateOrderAdapter);
        mCreateOrderAdapter.setList(mListOrderItme);
        setTotalPrice(mListOrderItme);
        mCreateOrderAdapter.setOnItemClickListenner(new CreateOrderAdapter.OnItemClickListenner() {
            @Override
            public void onItemClick(int position) {
                dialogAddVal(CreateOrderActivity.this, position);
            }
        });

    }

    private void setTotalPrice(List<FoodBaseItem> mListOrderItme) {
        int totalPrice = 0;
        totalPrice += GetTotalPriceCoffee(mListOrderItme);
        totalPrice += GetTotalPriceMilk(mListOrderItme);
        totalPrice += GetTotalPriceTea(mListOrderItme);
        tvTotalPrice.setText("฿"+String.valueOf(totalPrice));
    }

    private int GetTotalPriceMilk(List<FoodBaseItem> mListOrderItme) {
        int totalPrice = 0;
        for (int a = 0; a < mListOrderItme.size(); a++) {
            if (mListOrderItme.get(a) instanceof MilkModel) {
                totalPrice+=((MilkModel) mListOrderItme.get(a)).getSalePrice()*((MilkModel) mListOrderItme.get(a)).getAmount();
            }
        }
        return totalPrice;
    }

    private int GetTotalPriceTea(List<FoodBaseItem> mListOrderItme) {
        int totalPrice = 0;
        for (int a = 0; a < mListOrderItme.size(); a++) {
            if (mListOrderItme.get(a) instanceof TeaModel) {
                totalPrice+=((TeaModel) mListOrderItme.get(a)).getSalePrice()*((TeaModel) mListOrderItme.get(a)).getAmount();
            }
        }
        return totalPrice;
    }

    private int GetTotalPriceCoffee(List<FoodBaseItem> mListOrderItme) {
        int totalPrice = 0;
        for (int a = 0; a < mListOrderItme.size(); a++) {
            if (mListOrderItme.get(a) instanceof CoffeeModel) {
                totalPrice+=((CoffeeModel) mListOrderItme.get(a)).getSalePrice()*((CoffeeModel) mListOrderItme.get(a)).getAmount();
            }
        }
        return totalPrice;
    }

    private List<FoodBaseItem> createBaseItem() {
        List<FoodBaseItem> list = new ArrayList<>();
        list.add(createTitle("Coffee", getResources().getDrawable(R.drawable.ic_coffee32)));
        list.addAll(listCoffee());
        list.add(createTitle("Milks", getResources().getDrawable(R.drawable.barista_cappuccino36)));
        list.addAll(listMilk());
        list.add(createTitle("Tea", getResources().getDrawable(R.drawable.ic_tea)));
        list.addAll(listTea());
        return list;
    }

    private List<CoffeeModel> listCoffee() {
        List<CoffeeModel> listCoffee = new ArrayList<>();
        CoffeeModel itemCoffee = new CoffeeModel();
        itemCoffee.setSalePrice(80);
        itemCoffee.setProductName("Espresso");
        itemCoffee.setProductDesc("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        itemCoffee.setAmount(0);
        listCoffee.add(itemCoffee);
        itemCoffee = new CoffeeModel();
        itemCoffee.setSalePrice(85);
        itemCoffee.setProductName("Cappuchino");
        itemCoffee.setProductDesc("Quisque velit nisi, pretium ut lacinia in, elementum id enim.");
        itemCoffee.setAmount(0);
        listCoffee.add(itemCoffee);
        itemCoffee = new CoffeeModel();
        itemCoffee.setSalePrice(75);
        itemCoffee.setProductName("Amaricano");
        itemCoffee.setProductDesc("Pellentesque in ipsum id orci porta dapibus.");
        itemCoffee.setAmount(0);
        listCoffee.add(itemCoffee);
        itemCoffee = new CoffeeModel();
        itemCoffee.setSalePrice(95);
        itemCoffee.setProductName("Amaricano Caramel");
        itemCoffee.setProductDesc("Mauris blandit aliquet elit, eget tincidunt nibh pulvinar a.");
        itemCoffee.setAmount(0);
        listCoffee.add(itemCoffee);
        return listCoffee;
    }

    private List<TeaModel> listTea() {
        List<TeaModel> listTea = new ArrayList<>();
        TeaModel itemTea = new TeaModel();
        itemTea.setSalePrice(50);
        itemTea.setProductName("BlackTea");
        itemTea.setProductDesc("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        itemTea.setAmount(0);
        listTea.add(itemTea);
        itemTea = new TeaModel();
        itemTea.setSalePrice(45);
        itemTea.setProductName("GreenTea");
        itemTea.setProductDesc("Quisque velit nisi, pretium ut lacinia in, elementum id enim.");
        itemTea.setAmount(0);
        listTea.add(itemTea);
        return listTea;
    }

    private List<MilkModel> listMilk() {
        List<MilkModel> listMilk = new ArrayList<>();
        MilkModel itemMilk = new MilkModel();
        itemMilk.setSalePrice(45);
        itemMilk.setProductName("Milk Original");
        itemMilk.setProductDesc("Donec rutrum congue leo eget malesuada.");
        itemMilk.setAmount(0);
        listMilk.add(itemMilk);
        return listMilk;
    }


    private TitleModel createTitle(String s, Drawable drawable) {
        TitleModel item = new TitleModel();
        item.setTitle(s);
        item.setIcons(drawable);
        return item;
    }

    private void dialogAddVal(Context context, final int position) {
        final FoodBaseItem item = mListOrderItme.get(position);
        int salePrice = 0;
        int saleAmount = 0;
        String proName = "";
        if (item instanceof CoffeeModel) {
            salePrice = ((CoffeeModel) item).getSalePrice();
            proName = ((CoffeeModel) item).getProductName();
            saleAmount = ((CoffeeModel) item).getAmount();
        } else if (item instanceof MilkModel) {
            salePrice = ((MilkModel) item).getSalePrice();
            proName = ((MilkModel) item).getProductName();
            saleAmount = ((MilkModel) item).getAmount();
        } else if (item instanceof TeaModel) {
            salePrice = ((TeaModel) item).getSalePrice();
            proName = ((TeaModel) item).getProductName();
            saleAmount = ((TeaModel) item).getAmount();
        }
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_edit_val);
        dialog.setCancelable(false);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(lp);

        TextView tvMenuName;
        final MaterialButton btnMimus, btnPlus, btnSumPrice;
        final TextView tvIncreaseVal;

        tvMenuName = dialog.findViewById(R.id.tvMenuName);
        btnPlus = dialog.findViewById(R.id.btnPlus);
        tvIncreaseVal = dialog.findViewById(R.id.etIncreaseVal);
        btnMimus = dialog.findViewById(R.id.btnMimus);
        btnSumPrice = dialog.findViewById(R.id.btnSumPrice);

        tvMenuName.setText(proName + "->฿" + salePrice);
        tvIncreaseVal.setText(String.valueOf(saleAmount));
        btnSumPrice.setText("฿" + String.valueOf(saleAmount * salePrice));

        // btn decrease value
        final int finalSalePrice = salePrice;
        btnMimus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext()
                        , "Press Decrease", Toast.LENGTH_SHORT);
                tvIncreaseVal.setText(updateVal(Integer.parseInt(tvIncreaseVal.getText().toString()), -1));
                btnSumPrice.setText("฿" + updateSumPrice(finalSalePrice, Integer.parseInt(tvIncreaseVal.getText().toString())));
            }
        });
        // btn increase value
        btnPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext()
                        , "Press Increase ", Toast.LENGTH_SHORT);
                tvIncreaseVal.setText(updateVal(Integer.parseInt(tvIncreaseVal.getText().toString()), 1));
                btnSumPrice.setText("฿" + updateSumPrice(finalSalePrice, Integer.parseInt(tvIncreaseVal.getText().toString())));
            }
        });

        // btn increase value
        btnSumPrice.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext()
                        , "Press Increase ", Toast.LENGTH_SHORT);
                dialog.dismiss();
            }
        });
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                if (item instanceof CoffeeModel) {
                    ((CoffeeModel) item).setAmount(Integer.parseInt(tvIncreaseVal.getText().toString()));
                } else if (item instanceof MilkModel) {
                    ((MilkModel) item).setAmount(Integer.parseInt(tvIncreaseVal.getText().toString()));
                } else if (item instanceof TeaModel) {
                    ((TeaModel) item).setAmount(Integer.parseInt(tvIncreaseVal.getText().toString()));
                }
                mListOrderItme.set(position, item);
                mCreateOrderAdapter.setList(mListOrderItme);
                setTotalPrice(mListOrderItme);
            }
        });

        dialog.show();
    }

    private String updateVal(int oldVal, int newVal) {
        if (oldVal == 0 && newVal < 0) {
            return "0";
        } else {

            oldVal += newVal;

            return String.valueOf(oldVal);
        }
    }

    private String updateSumPrice(int price, int amount) {
        return String.valueOf(price * amount);
    }


    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch ( item.getItemId()) {
            case android.R.id.home: {
//                NavUtils.navigateUpFromSameTask(this);
                onBackPressed();
                return true;
            }
            default: {
                return super.onOptionsItemSelected(item);
            }
        }
    }
    private void setInstance() {
        toobCreateOrder = findViewById(R.id.toobCreateOrder);
        recycleViewCreateOrder = findViewById(R.id.recycleViewCreateOrder);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);
        mListOrderItme = new ArrayList<>();
        mCreateOrderAdapter = new CreateOrderAdapter();

    }
}
