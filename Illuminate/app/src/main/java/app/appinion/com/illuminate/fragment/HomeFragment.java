package app.appinion.com.illuminate.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;

import java.util.zip.Inflater;

import app.appinion.com.illuminate.R;


/**
 * Created by Rishabh Srivastava on 13-Jan-16.
 */
public class HomeFragment extends BaseFragment {
    View view;
    private ImageView mUserBarcodeIV;
    private String userBarcode="aliahmed";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        try {
            initComponenets();
            prepareView();
            setActionListener();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    private void initComponenets() {

    }

    private void prepareView() {
        try {

        }
        catch (Exception e){}

    }

    private void setActionListener() {
    }
}
