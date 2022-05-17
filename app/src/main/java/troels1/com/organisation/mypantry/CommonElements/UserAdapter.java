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
    private UserAdapter.OnClickListener pOnClickListener;
    private UserAdapterRepositoryInterface repository;
    private PropertyChangeSupport propertyChangeSupport;

    public UserAdapter(OnClickListener onClickListener) {
        repository = Repository.getInstance(null);
        this.users = repository.getListUserinformation();
        this.pOnClickListener = onClickListener;
        repository.addPropertyChangeListener("eventUser", (PropertyChangeEvent event) ->  this.setUsers());
    }

    public void setUsers() {
        users = repository.getListUserinformation();
        Log.d("call", "Useradapter: userupdate " + users.size());
        this.notifyDataSetChanged();
    }

    public int getItemCount() {
        return users.size();
    }


    public UserAdapter.ViewHolderUser onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recyclerview, parent, false);
        return new UserAdapter.ViewHolderUser(view, pOnClickListener);
    }


    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolderUser viewholder, int position) {
        viewholder.productName.setText(R.string.prefix_user + users.get(position).getFirstName() + " " + users.get(position).getLastName());
    }


    class ViewHolderUser extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView productName;
        UserAdapter.OnClickListener OnClickListener;

        ViewHolderUser(View itemView,UserAdapter.OnClickListener onClickListener) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            this.OnClickListener = onClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            pOnClickListener.onClick(getAdapterPosition());
        }
    }

    public interface OnClickListener {
        void onClick(int position);
    }
}
