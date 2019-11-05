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
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TryAgainFragment extends Fragment {

    Button btnSee, btnSubmit;
    NavController mNavController;
    TextView tvNum1, tvNum2;
    EditText edtAnswer;

    int correctAnswer;


    public TryAgainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_try_again, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mNavController = Navigation.findNavController(view);
        tvNum1 = view.findViewById(R.id.tvNum1);
        tvNum2 = view.findViewById(R.id.tvNum2);
        btnSee = view.findViewById(R.id.btnSee);
        btnSubmit = view.findViewById(R.id.btnSubmit);
        edtAnswer = view.findViewById(R.id.edtAnswer);

        tvNum1.setText(Integer.toString(getArguments().getInt("num1")));
        tvNum2.setText(Integer.toString(getArguments().getInt("num2")));
        correctAnswer= getArguments().getInt("correctAnswer");

        btnSee.setOnClickListener(v-> see());
        btnSubmit.setOnClickListener(v -> submit());

    }

    void see (){
        getArguments().putInt("correctAnswer", correctAnswer);
        getArguments().putInt("num1", Integer.parseInt(tvNum1.getText().toString()));
        getArguments().putInt("num2", Integer.parseInt(tvNum2.getText().toString()));

        mNavController.navigate(R.id.action_tryAgainFragment_to_seeAnswerFragment, getArguments());

    }


    private void submit() {

        getArguments().putInt("correctAnswer", correctAnswer);
        getArguments().putInt("num1", Integer.parseInt(tvNum1.getText().toString()));
        getArguments().putInt("num2", Integer.parseInt(tvNum2.getText().toString()));
        getArguments().putString("userInp", edtAnswer.getText().toString());

        int len = edtAnswer.getText().toString().length();
        Boolean isNum = true;
        for (int i = 0; i < len; i++){
            if(Character.isDigit(edtAnswer.getText().toString().charAt(i)) == false){
                isNum = false;
            }
        }

        if(!isNum){
            invalidInput();
        }
        else if(edtAnswer.getText() == null){
            invalidInput();
        }
        else if (edtAnswer.getText().toString().equals("")){
            invalidInput();
        }
        //if input is valid do this
        else if (Integer.parseInt(edtAnswer.getText().toString()) == correctAnswer){
            mNavController.navigate(R.id.action_tryAgainFragment_to_rightAnswerFragment, getArguments());
        }
        else{
            mNavController.navigate(R.id.action_tryAgainFragment_to_wrongAnswerFragment, getArguments());
        }
    }

    void invalidInput(){
        mNavController.navigate(R.id.action_tryAgainFragment_to_inputErrorFragment, getArguments());
    }
}
