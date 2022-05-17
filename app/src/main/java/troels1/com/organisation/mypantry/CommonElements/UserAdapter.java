package troels1.com.organisation.mypantry.CommonElements;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.List;

import troels1.com.organisation.mypantry.R;
import troels1.com.organisation.mypantry.localDatabase.Entity.Userinformation;
import troels1.com.organisation.mypantry.repository.Repository;
import troels1.com.organisation.mypantry.repository.interfaces.UserAdapterRepositoryInterface;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolderUser> {

    private List<Userinformation> users;
    private View.OnLongClickListener onClickListener;
    private final UserAdapterRepositoryInterface repository;

    public UserAdapter(View.OnLongClickListener onClickListener) {
        repository = Repository.getInstance(null);
        this.users = repository.getListUserinformation();
        this.onClickListener = onClickListener;
        repository.addPropertyChangeListener("eventUser", (PropertyChangeEvent event) ->  this.setUsers());
    }

    public void setUsers() {
        users = repository.getListUserinformation();
        this.notifyDataSetChanged();
    }

    public int getItemCount() {
        return users.size();
    }


    public UserAdapter.ViewHolderUser onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recyclerview, parent, false);
        return new UserAdapter.ViewHolderUser(view, onClickListener);
    }


    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolderUser viewholder, int position) {
        viewholder.productName.setText("Username: " + users.get(position).getFirstName() + " " + users.get(position).getLastName());
    }


    class ViewHolderUser extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        private TextView productName;
        private View.OnLongClickListener onClickListener;

        ViewHolderUser(View itemView,View.OnLongClickListener onClickListener) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            this.onClickListener = onClickListener;
            itemView.setOnLongClickListener(this);
        }

        @Override
        public boolean onLongClick(View view) {
            onClickListener.onLongClick(view);
            return false;
        }
    }
}
