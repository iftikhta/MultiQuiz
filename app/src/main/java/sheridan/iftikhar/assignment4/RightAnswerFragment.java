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
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RightAnswerFragment extends Fragment {

    NavController mNavController;
    TextView tvCorrectResult;
    Button btnNewProblem;
    public RightAnswerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_right_answer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mNavController = Navigation.findNavController(view);
        tvCorrectResult = view.findViewById(R.id.tvCorrectResult);
        String result = getArguments().getInt("num1") + " x " +
                getArguments().getInt("num2") + " = " +
                getArguments().getInt("correctAnswer");
        tvCorrectResult.setText(result);
        btnNewProblem = view.findViewById(R.id.btnNewProblem_AwnserPage);

        btnNewProblem.setOnClickListener(v->newProb());

    }

    void newProb(){
        mNavController.navigate(R.id.action_rightAnswerFragment_to_newProblemFragment2);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//
//        String result = getArguments().getInt("num1") + " x " +
//                getArguments().getInt("num2") + " = " +
//                getArguments().getInt("correctResult");
//        tvCorrectResult.setText(result);
    }
}
