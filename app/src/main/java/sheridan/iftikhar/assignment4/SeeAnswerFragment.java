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
public class SeeAnswerFragment extends Fragment {

    Button btnNewProblem;
    NavController mNavController;
    TextView tvCorrectAnswer;
    int correctAnswer, num1, num2;

    public SeeAnswerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_see_answer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnNewProblem = view.findViewById(R.id.btnSubmit);
        mNavController = Navigation.findNavController(view);
        tvCorrectAnswer = view.findViewById(R.id.tvCorrectAnswer);
        tvCorrectAnswer
                .setText( num1 + " x " + num2 +" = " + correctAnswer);

        btnNewProblem.setOnClickListener(v->newProb());

    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        correctAnswer = getArguments().getInt("correctAnswer");
        num1 = getArguments().getInt("num1");
        num2 = getArguments().getInt("num2");

    }
}
