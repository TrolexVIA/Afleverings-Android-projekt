package troels1.com.organisation.mypantry.mainListVIew.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import troels1.com.organisation.mypantry.CommonElements.UserAdapter;
import troels1.com.organisation.mypantry.R;

public class FragmentMain extends Fragment {

    public static TextView activUserTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentmain, container, false);
        activUserTextView = view.findViewById(R.id.menu_textfelt_user);
        return view;
    }
}
