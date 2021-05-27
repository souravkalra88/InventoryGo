package adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inventorygo.R;
import com.example.inventorygo.editData;

import java.io.Serializable;
import java.util.List;

import model.DATA;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
Context context;
List<DATA> ll;

    public RecyclerViewAdapter(Context context, List<DATA> ll) {
        this.context = context;
        this.ll = ll;
    }
    // Where to get the single card as viewholder Object
    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);

        return new ViewHolder(view);
    }
    // What will happen after we create the viewholder object
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
            DATA data = ll.get(position);
            holder.name.setText(data.getName());
            holder.price.setText(data.getPrice());
            holder.amount.setText(data.getAmount());

    }
//        return no. of itmes
    @Override
    public int getItemCount() {
        return ll.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
      public   TextView name;
     public    TextView price;
        public TextView amount;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            amount = itemView.findViewById(R.id.amount);


        }


        @Override
        public void onClick(View v) {
            int pos = getAbsoluteAdapterPosition();
            DATA dd = ll.get(pos);
//            Toast.makeText(context, "View Created " + pos, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, editData.class);
            intent.putExtra("name",dd.getName());
            intent.putExtra("price",dd.getPrice());
            intent.putExtra("amount",dd.getAmount());
            intent.putExtra("supplier",dd.getSupplier());
            intent.putExtra("sContact",dd.getsContact());

            intent.putExtra("iD",dd.getId());
            context.startActivity(intent);
        }
    }

}
