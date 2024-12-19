package com.example.fragmentapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.fragmentapplication.R;
import com.example.fragmentapplication.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentTwo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTwo extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentTwo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTwo.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentTwo newInstance(String param1, String param2) {
        FragmentTwo fragment = new FragmentTwo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_two, container, false);
        EditText name,email,pass,Repass,phone;
        name = view.findViewById(R.id.etName);
        email = view.findViewById(R.id.etEmail);
        pass = view.findViewById(R.id.etPass);
        Repass = view.findViewById(R.id.etRePass);
        phone = view.findViewById(R.id.etPhone);
        Button reg = view.findViewById(R.id.btnReg);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!email.getText().toString().isEmpty() && !pass.getText().toString().isEmpty() && !Repass.getText().toString().isEmpty() && !phone.getText().toString().isEmpty() && !name.getText().toString().isEmpty()){
                    if(pass.getText().toString().equals(Repass.getText().toString())){
                        if(pass.getText().toString().length() >= 6){
                            MainActivity mainActivity = (MainActivity) getActivity();
                            mainActivity.register(view);
                            //Navigation.findNavController(view).navigate(R.id.action_fragmentTwo_to_fragmentOne);
                        }
                    }
                }
            }
        });

        return view;
    }
}