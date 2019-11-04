package sheridan.iftikhar.assignment4;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewProblemFragment extends Fragment {

    Button btnSee;
    NavController mNavController;
    public NewProblemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vi = inflater.inflate(R.layout.fragment_new_problem, container, false);
        btnSee = vi.findViewById(R.id.btnSee);
//        mNavController = Navigation.findNavController(vi);
//
//        btnSee.setOnClickListener(v-> see());
        // Inflate the layout for this fragment
        return vi;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mNavController = Navigation.findNavController(view);

        btnSee.setOnClickListener(v-> see());
    }

    void see (){
        mNavController.navigate(R.id.action_newProblemFragment2_to_seeAnswerFragment);
    }


}
