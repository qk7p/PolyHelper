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
    private static int viewHolderCount;

    MaterialsAdapter(int numberOfItems) {
        numberItems = numberOfItems;
        viewHolderCount = 0;
    }

    @NonNull
    @Override
    public MaterialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.material_list_item;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);

        MaterialViewHolder viewHolder = new MaterialViewHolder(view);
//        viewHolder.viewHolderIndex.setText(viewHolderCount);

        viewHolderCount++;

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
        TextView viewHolderIndex;

        public MaterialViewHolder(@NonNull View itemView) {
            super(itemView);

            listItemMaterialView = itemView.findViewById(R.id.bt_material_item);
//            viewHolderIndex = itemView.findViewById(R.id.bt_view_holder_material);
        }

        void bind(int listIndex) {
            listItemMaterialView.setText(String.valueOf(listIndex));
        }
    }
}
