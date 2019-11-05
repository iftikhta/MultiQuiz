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
public class InputErrorFragment extends Fragment {

    NavController mNavController;
    TextView tvErrorMessage, tvUserINP;
    Button btnTryAgain;

    public InputErrorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_error, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mNavController = Navigation.findNavController(view);
        tvErrorMessage = view.findViewById(R.id.tvErrorMessage);
        tvUserINP = view.findViewById(R.id.tvUserINP);
        btnTryAgain = view.findViewById(R.id.btnTryAgain);
        String userInput = getArguments().getString("userInp");
        if (userInput.equals("")){
            userInput = "empty";
        }
        String message = getArguments().getInt("num1") + " x " +
                getArguments().getInt("num2") + " = " ;
        tvErrorMessage.setText(message);
        tvUserINP.setText(userInput + "?");

        btnTryAgain.setOnClickListener(v-> tryAgain());

    }

    void tryAgain(){
        mNavController.navigate(R.id.action_inputErrorFragment_to_tryAgainFragment, getArguments());
    }
}
