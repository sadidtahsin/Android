package app.appinion.com.illuminate.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.EnumMap;
import java.util.Map;

import app.appinion.com.illuminate.R;

public class CouponsFragment extends BaseFragment {
    View view;
    View view1;
    private GridView mCouponsGrid;
    CustomAdapter mAdapter;
    private Dialog mCouponDetailDialog;
    private TextView mCouponCodeTv;
    private Button mCloseBtn;
    private ImageView mBarCodeIv;

    private static final int WHITE = 0xFFFFFFFF;
    private static final int BLACK = 0xFF000000;
    private String couponCode = "1236352372537";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_coupons, container, false);
        //view1= inflater.inflate(R.layout.listitemscoupons, container, false);
        try {
            initComponenets();
            prepareView();
           // setActionListener();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }
    private void initComponenets() {
//        mCouponsGrid = (GridView) view.findViewById(R.id.frag_coupons_gridview);
//        mCouponDetailDialog = new Dialog(getActivity());
//        mCouponDetailDialog.setContentView(R.layout.dialog_coupondetail);
//        mCloseBtn = (Button) mCouponDetailDialog.findViewById(R.id.dialog_coupon_btn_close);
//        mBarCodeIv = (ImageView) mCouponDetailDialog.findViewById(R.id.dialog_coupon_iv_barcode);
//        mCouponCodeTv = (TextView) mCouponDetailDialog.findViewById(R.id.dialog_coupon_iv_barcodenumber);
//        mAdapter = new CustomAdapter(getActivity(), R.layout.listitemscoupons);
//        mCouponsGrid.setAdapter(mAdapter);
//        mCloseBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mCouponDetailDialog.dismiss();
//            }
//        });




    }

    private void prepareView() {
    }

    private void setActionListener() {
        mCouponsGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                try {
//                    mCouponCodeTv.setText(couponCode);
//                    mBarCodeIv.setImageBitmap(encodeAsBitmap(couponCode, BarcodeFormat.CODE_128, 600, 300));
//                } catch (WriterException e) {
//                    e.printStackTrace();
//                }
//                mCouponDetailDialog.show();
            }
        });

//        mCloseBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mCouponDetailDialog.dismiss();
//            }
//        });

    }


    public class CustomAdapter extends ArrayAdapter<String> {

        public CustomAdapter(Context context, int resource) {
            super(context, resource);
        }

        @Override
        public int getCount() {
            return 31;
            //use save and send
        }

        /**
         * Appinion webservice goes here.
         * We will need a coupon webservice for this GridView. It should have a unique coupon id, title, full image url and thumb url.
         * <p/>
         * Using the Holder pattern reduces the overload on a scrollable view as it reduces the cell recreation by recycling the cells which go out of the view.
         *
         * @param position
         * @param convertView
         * @param parent
         * @return
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder = null;
            if (convertView == null) {
                holder = new Holder();
//                convertView = getActivity().getLayoutInflater().inflate(R.layout.listitemscoupons, parent, false);
//                holder.mTextTv = (TextView) convertView.findViewById(R.id.listitemscoupons_tv_title);
//                holder.buttonUse=(Button)convertView.findViewById(R.id.button_Use);
//                holder.imgCoupon=(ImageView)convertView.findViewById(R.id.imageViewCoupon);
                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }

            holder.mTextTv.setText("Coupon " + position);

            holder.buttonUse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // Toast toast=Toast.makeText(getContext(),"Hello",Toast.LENGTH_LONG);
                    //toast.show();
//                    try {
//                        mCouponCodeTv.setText(couponCode);
//                        mBarCodeIv.setImageBitmap(encodeAsBitmap(couponCode, BarcodeFormat.CODE_128, 600, 300));
//                    } catch (WriterException e) {
//                        e.printStackTrace();
//                    }
//                    mCouponDetailDialog.show();
                }
            });

            //holder.imgCoupon.setImageResource(R.mipmap.name);

            return convertView;
        }

        public class Holder {
            TextView mTextTv;
            Button buttonUse;
            ImageView imgCoupon;
        }
    }



    private static String guessAppropriateEncoding(CharSequence contents) {
        // Very crude at the moment
        for (int i = 0; i < contents.length(); i++) {
            if (contents.charAt(i) > 0xFF) {
                return "UTF-8";
            }
        }
        return null;
    }
}
