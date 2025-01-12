package com.example.contactphone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private List<Contact> contactList;

    public ContactAdapter(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contactList.get(position);

        // Lấy ký tự đầu tiên của tên liên hệ
        String firstLetter = contact.getName().substring(0, 1).toUpperCase();

        // Gán giá trị vào các TextView
        holder.tvNameLeft.setText(firstLetter); // Chữ cái bên trái
        holder.tvIcon.setText(firstLetter);    // Chữ cái trong vòng tròn
        holder.tvName.setText(contact.getName()); // Tên đầy đủ
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView tvNameLeft, tvIcon, tvName;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameLeft = itemView.findViewById(R.id.tvNameLeft);
            tvIcon = itemView.findViewById(R.id.tvIcon);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }
}
