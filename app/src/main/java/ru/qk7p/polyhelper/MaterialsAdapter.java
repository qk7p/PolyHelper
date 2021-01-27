package ru.qk7p.polyhelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MaterialsAdapter extends RecyclerView.Adapter<MaterialsAdapter.MaterialViewHolder> {

    private int numberItems;
    private int layoutIdForListItem;

    MaterialsAdapter(int numberOfItems, int layoutId) {
        numberItems = numberOfItems;
        layoutIdForListItem = layoutId;
    }

    public void setNumberItems(int numberItems) {
        this.numberItems = numberItems;
    }

    public void setLayoutIdForListItem(int layoutId) {
        this.layoutIdForListItem = layoutId;
    }

    @NonNull
    @Override
    public MaterialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);

        MaterialViewHolder viewHolder = new MaterialViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MaterialViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return numberItems;
    }

    class MaterialViewHolder extends RecyclerView.ViewHolder {

        TextView listItemMaterialView;

        public MaterialViewHolder(@NonNull View itemView) {
            super(itemView);

            listItemMaterialView = itemView.findViewById(R.id.bt_material_item);
        }

        void bind(int listIndex) {
            listItemMaterialView.setText(String.valueOf(listIndex));
        }
    }
}
