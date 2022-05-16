package troels1.com.organisation.mypantry.mainListVIew.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import troels1.com.organisation.mypantry.CommonElements.UserAdapter;
import troels1.com.organisation.mypantry.R;


public class FragmentMain extends Fragment implements UserAdapter.OnClickListener {
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_slector, container, false);
        recyclerView = view.findViewById(R.id.rvMenu);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new UserAdapter(this));
        return view;
    }

    @Override
    public void onClick(int position) {

    }
}
