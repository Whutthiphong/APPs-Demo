package jsynctech.com.app_demo.DEMO1.DemoDetailActivity.BottomAppBar;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import jsynctech.com.app_demo.R;

public class BottomSheetNavigationFragment extends BottomSheetDialogFragment {

    private ImageView closeButton;

    public static BottomSheetNavigationFragment newInstance() {
        Bundle args = new Bundle();
        BottomSheetNavigationFragment fragment = new BottomSheetNavigationFragment();
        fragment.setArguments(args);
        return fragment;

    }

    private BottomSheetBehavior.BottomSheetCallback mBottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() {
        @Override
        public void onStateChanged(@NonNull View view, int stat) {
            if (stat == BottomSheetBehavior.STATE_HIDDEN) {
                dismiss();
            }
        }

        @Override
        public void onSlide(@NonNull View view, float v) {
            Log.e("Time", v + "");
//            if (v >0.3) {
//                closeButton.setVisibility(View.VISIBLE);
//            } else {
//                closeButton.setVisibility(View.GONE);
//            }
//            if (v == 1) {
//                closeButton.setVisibility(View.VISIBLE);
//            }
        }
    };

    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(final Dialog dialog, int style) {
        super.setupDialog(dialog, style);
//         get context View
        View contentView = View.inflate(getContext(), R.layout.bottom_navigation_drawer, null);
        dialog.setContentView(contentView);
        NavigationView navigationView = contentView.findViewById(R.id.navigation_view);

        //implement navigation menu item click event
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_item_delete_selected:
                        break;
                }
                return false;
            }
        });
        closeButton = contentView.findViewById(R.id.imvClose);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dismiss bottom sheet
                dialog.dismiss();
            }
        });
        //Set the coordinator layout behavior
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) ((View) contentView.getParent()).getLayoutParams();
        CoordinatorLayout.Behavior behavior = params.getBehavior();

        //Set callback
        if (behavior instanceof BottomSheetBehavior) {
            ((BottomSheetBehavior) behavior).setBottomSheetCallback(mBottomSheetCallback);
        }
    }
}
