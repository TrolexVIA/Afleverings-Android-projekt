package troels1.com.organisation.mypantry.mainListVIew.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import troels1.com.organisation.mypantry.R;

public class FragmentSelectUser extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_slector, container, false);

    }
}

