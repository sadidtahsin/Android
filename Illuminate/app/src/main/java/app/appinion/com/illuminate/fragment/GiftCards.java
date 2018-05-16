package app.appinion.com.illuminate.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import app.appinion.com.illuminate.R;

/**
 * Created by ali on 22-Mar-16.
 */
public class GiftCards extends BaseFragment {
    View view;
    private Activity mActivity;
    private Button btnGiftUse,
            btnGiftNotify,
            btnGiftBuy,
            btnGiftSend;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_giftcards, container, false);
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
        //btnGiftUse=(Button)

    }

    private void prepareView() {


    }

    private void setActionListener() {
    }
}
