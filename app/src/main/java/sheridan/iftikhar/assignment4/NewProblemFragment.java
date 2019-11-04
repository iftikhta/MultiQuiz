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
public class NewProblemFragment extends Fragment {

    Bundle mBundle = new Bundle();
    Button btnSee, btnSubmit;
    NavController mNavController;
    TextView tvNum1, tvNum2;
    EditText edtAnswer;

    int correctAnswer;

    public NewProblemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vi = inflater.inflate(R.layout.fragment_new_problem, container, false);
        btnSubmit = vi.findViewById(R.id.btnSubmit);
        btnSee = vi.findViewById(R.id.btnSee);
        tvNum1 = vi.findViewById(R.id.tvNum1);
        tvNum2 = vi.findViewById(R.id.tvNum2);
        edtAnswer = vi.findViewById(R.id.edtAnswer);

        setQuestion();

        return vi;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mNavController = Navigation.findNavController(view);

        btnSee.setOnClickListener(v-> see());
        btnSubmit.setOnClickListener(v -> submit());

    }

    void see (){
        mBundle.putInt("correctAnswer", correctAnswer);
        mBundle.putInt("num1", Integer.parseInt(tvNum1.getText().toString()));
        mBundle.putInt("num2", Integer.parseInt(tvNum2.getText().toString()));

        mNavController.navigate(R.id.action_newProblemFragment2_to_seeAnswerFragment, mBundle);

    }


    private void submit() {

        mBundle.putInt("correctAnswer", 5);
        //handle no entry
        if (edtAnswer.getText().toString().equals("")){
           // mNavController.navigate(R.id.action_newProblemFragment2_to_seeAnswerFragment);
        }
        //if input is valid do this
        else if (Integer.parseInt(edtAnswer.getText().toString()) == correctAnswer){
            mNavController.navigate(R.id.action_newProblemFragment2_to_seeAnswerFragment, mBundle);
        }
    }


    void setQuestion(){
        int num1 = (int) generateRand();
        int num2 = (int) generateRand();

        correctAnswer = num1*num2;

        tvNum1.setText(Integer.toString(num1));
        tvNum2.setText(Integer.toString(num2));
    }

    double generateRand(){
        double rand = Math.random();
        rand = rand * 9 +1;
        return rand;
    }

}
