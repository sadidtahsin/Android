package android.example.com.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CustomAdapter extends ArrayAdapter<DataModel> implements View.OnClickListener{
 
    private ArrayList<DataModel> dataSet;
    Context mContext;
 
    // View lookup cache
    private static class ViewHolder {
        TextView co2;
        TextView humidity;
        TextView temperature;
        TextView feels;
        TextView date;
        TextView time;
    }
 
    public CustomAdapter(ArrayList<DataModel> data, Context context) {
        super(context, R.layout.row_item, data);
        Comparator comparator = Collections.reverseOrder();
        this.dataSet = data;
        Collections.reverse(dataSet);
        this.mContext=context;
 
    }
 
    @Override
    public void onClick(View v) {
 
        int position=(Integer) v.getTag();
        Object object= getItem(position);
        DataModel dataModel=(DataModel)object;
 
        switch (v.getId())
        {

        }
    }
 
    private int lastPosition = -1;
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        DataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
 
        final View result;
 
        if (convertView == null) {
 
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            viewHolder.co2 = (TextView) convertView.findViewById(R.id.co2);
            viewHolder.humidity = (TextView) convertView.findViewById(R.id.humidity);
            viewHolder.temperature = (TextView) convertView.findViewById(R.id.temperature);
            viewHolder.feels = (TextView) convertView.findViewById(R.id.feels);
            viewHolder.date = (TextView) convertView.findViewById(R.id.date);
            viewHolder.time = (TextView) convertView.findViewById(R.id.time);
            result=convertView;
 
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }
 
//        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
//        result.startAnimation(animation);
        lastPosition = position;
 
        viewHolder.co2.setText(dataModel.getCo2()+"");
        viewHolder.feels.setText(dataModel.getFeels()+"");
        viewHolder.time.setText(dataModel.getTime());
        viewHolder.humidity.setText(dataModel.getHumidity()+"");
        viewHolder.temperature.setText(dataModel.getTemperature()+"");
        viewHolder.date.setText(dataModel.getDate());
        // Return the completed view to render on screen
        return convertView;
    }
}