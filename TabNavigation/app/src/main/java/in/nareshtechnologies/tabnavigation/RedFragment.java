package in.nareshtechnologies.tabnavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class RedFragment extends Fragment implements View.OnClickListener {

    EditText num1,num2;
    Button add, sub, mul,div;
    TextView textView;
    public RedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_red, container, false);

        // We shall initialize the views and perform the logic related operations
        initalizeViews(v);

        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);

        return v;
    }

    private void initalizeViews(View v) {
        num1 = v.findViewById(R.id.editTextNumber);
        num2 = v.findViewById(R.id.editTextNumber2);
        add = v.findViewById(R.id.button);
        sub = v.findViewById(R.id.button2);
        mul = v.findViewById(R.id.button4);
        div = v.findViewById(R.id.button3);
        textView = v.findViewById(R.id.textView);
    }

    @Override
    public void onClick(View view) {
        int n1 = Integer.parseInt(num1.getText().toString());
        int n2 = Integer.parseInt(num2.getText().toString());
        int r = 0;
        switch (view.getId()){
            case R.id.button:
                r = n1+n2;
                break;
            case R.id.button2:
                r = n1-n2;
                break;
            case R.id.button3:
                r = n1/n2;
                break;
            case R.id.button4:
                r = n1*n2;
                break;
        }
        textView.setText(String.valueOf(r));
    }
}