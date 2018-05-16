package android.tamim.com.retrofittest.adapters;

import android.support.v7.widget.RecyclerView;
import android.tamim.com.retrofittest.R;
import android.tamim.com.retrofittest.models.Posts;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;


public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {

    private List<Posts> posts;

    public  RecycleAdapter(List<Posts> posts){
        this.posts=posts;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_items,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.userId.setText(posts.get(position).getUserId()+"");
        holder.idNo.setText(posts.get(position).getId()+"");
        holder.title.setText(posts.get(position).getTitle());
        holder.body.setText(posts.get(position).getBody());
    }



    @Override
    public int getItemCount() {
        return posts.size();
    }


    public  class MyViewHolder extends RecyclerView.ViewHolder{

        TextView userId;
        TextView idNo;
        TextView title;
        TextView body;
        public MyViewHolder(View itemView) {
            super(itemView);

            userId = (TextView) itemView.findViewById(R.id.user_id);
            idNo = (TextView) itemView.findViewById(R.id.id_no);
            title = (TextView) itemView.findViewById(R.id.title);
            body = (TextView) itemView.findViewById(R.id.body);

        }
    }
}
