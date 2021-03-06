package com.fgcalarm2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fgcalarm2.model.entities.Line;
import com.fgcalarm2.model.persistence.RepositoryManager;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.AdapterViewHolder>{

    Context ctx;
    Intent intent;

    ArrayList<Line> lines;

    CustomAdapter(Context context) {
        ctx = context;
        intent = new Intent(ctx, SelectorEstacio.class);

        lines = new ArrayList<>();



        for (int i = 0; i < RepositoryManager.getLineRepository().findAll().size(); i++) {
            lines.add(RepositoryManager.getLineRepository().findAll().get(i));
        }
    }


    @Override
    public CustomAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.row_layout, viewGroup, false);
        return new AdapterViewHolder(view);
    }
    /*int getIcon(Line l){
        return 0; //TODO Implement dynamically form resources
    }*/
    @Override
    public void onBindViewHolder(CustomAdapter.AdapterViewHolder adapterViewholder, int position) {
        //int iconLayout = getIcon(lines.get(position));
        int iconLayout = lines.get(position).getIcon();
        switch (iconLayout){
            case 0:
                adapterViewholder.icon.setImageDrawable(adapterViewholder.v.getResources().getDrawable(R.drawable.s1));
                break;
            case 1:
                adapterViewholder.icon.setImageDrawable(adapterViewholder.v.getResources().getDrawable(R.drawable.s2));
                break;
            case 2:
                adapterViewholder.icon.setImageDrawable(adapterViewholder.v.getResources().getDrawable(R.drawable.s5));
                break;
            case 3:
                adapterViewholder.icon.setImageDrawable(adapterViewholder.v.getResources().getDrawable(R.drawable.s55));
                break;
            case 4:
                adapterViewholder.icon.setImageDrawable(adapterViewholder.v.getResources().getDrawable(R.drawable.s33));
                break;
            case 5:
                adapterViewholder.icon.setImageDrawable(adapterViewholder.v.getResources().getDrawable(R.drawable.s4));
                break;
            case 6:
                adapterViewholder.icon.setImageDrawable(adapterViewholder.v.getResources().getDrawable(R.drawable.s8));
                break;
            case 7:
                adapterViewholder.icon.setImageDrawable(adapterViewholder.v.getResources().getDrawable(R.drawable.l6));
                break;
            case 8:
                adapterViewholder.icon.setImageDrawable(adapterViewholder.v.getResources().getDrawable(R.drawable.l7));
                break;
            case 9:
                adapterViewholder.icon.setImageDrawable(adapterViewholder.v.getResources().getDrawable(R.drawable.l8));
                break;
            case 10:
                adapterViewholder.icon.setImageDrawable(adapterViewholder.v.getResources().getDrawable(R.drawable.l12));
                break;
            case 11:
                adapterViewholder.icon.setImageDrawable(adapterViewholder.v.getResources().getDrawable(R.drawable.r5));
                break;
            case 12:
                adapterViewholder.icon.setImageDrawable(adapterViewholder.v.getResources().getDrawable(R.drawable.r50));
                break;
            case 13:
                adapterViewholder.icon.setImageDrawable(adapterViewholder.v.getResources().getDrawable(R.drawable.r6));
                break;
            case 14:
                adapterViewholder.icon.setImageDrawable(adapterViewholder.v.getResources().getDrawable(R.drawable.r60));
                break;
            case 15:
                adapterViewholder.icon.setImageDrawable(adapterViewholder.v.getResources().getDrawable(R.drawable.ca7));

        }
        adapterViewholder.position = position;

    }

    @Override
    public int getItemCount() {
        return lines.size();
    }



    public class AdapterViewHolder extends RecyclerView.ViewHolder {


        public ImageView icon;
        public ImageView icon2;
        public ImageView icon3;
        public int position;
        public View v;
        public AdapterViewHolder(final View itemView) {
            super(itemView);
            final int x = itemView.getVerticalScrollbarPosition();
            this.v = itemView;
            this.icon = (ImageView) itemView.findViewById(R.id.icon);
            this.icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intent.putExtra("linia", lines.get(position).getTag());
                    intent.putExtra("linia_id",position);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ctx.startActivity(intent);
                }
            });
        }

    }
}