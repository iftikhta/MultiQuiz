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
public class WrongAnswerFragment extends Fragment {

    NavController mNavController;
    TextView tvQuestion, tvWrong;
    Button btnTryAgain, btnSeeAnswer;

    public WrongAnswerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wrong_answer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mNavController = Navigation.findNavController(view);
        tvQuestion = view.findViewById(R.id.tvQuestion);
        tvWrong = view.findViewById(R.id.tvWrong);

        tvQuestion.setText(getArguments().getInt("num1") + " x " +
                getArguments().getInt("num2") + " = ?");

        tvWrong.setText(getArguments().getString("userInp"));

        btnTryAgain = view.findViewById(R.id.btnTryAgain);
        btnSeeAnswer = view.findViewById(R.id.btnSeeAnswer);

        btnSeeAnswer.setOnClickListener(v-> see());

        btnTryAgain.setOnClickListener(v-> tryAgain());
    }

    void see(){


        mNavController.navigate(R.id.action_wrongAnswerFragment_to_seeAnswerFragment, getArguments());
    }

    void tryAgain(){
        mNavController.navigate(R.id.action_wrongAnswerFragment_to_tryAgainFragment,getArguments());

    }
}
