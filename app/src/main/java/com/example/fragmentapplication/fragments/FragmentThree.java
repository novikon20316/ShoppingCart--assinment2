package com.example.fragmentapplication.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragmentapplication.R;
import com.example.fragmentapplication.activities.MainActivity;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentThree#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentThree extends Fragment {

    private TextView tvCart;
    private String Name;
    private TextView[] Amounts;
    private Map<String,Integer>CartItems = new HashMap<>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentThree() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentThree.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentThree newInstance(String param1, String param2) {
        FragmentThree fragment = new FragmentThree();
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
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        TextView[] ItemsName = {
                view.findViewById(R.id.tvItem1),
                view.findViewById(R.id.tvItem2),
                view.findViewById(R.id.tvItem3),
                view.findViewById(R.id.tvItem4),
                view.findViewById(R.id.tvItem5),
                view.findViewById(R.id.tvItem6),
                view.findViewById(R.id.tvItem7),
                view.findViewById(R.id.tvItem8),
                view.findViewById(R.id.tvItem9),
                view.findViewById(R.id.tvItem10),
                view.findViewById(R.id.tvItem11),
                view.findViewById(R.id.tvItem12),
        };
        OrganizeProducts(ItemsName);
        TextView tvName;
        Button Plus1,Plus2,Plus3,Plus4,Plus5,Plus6,Plus7,Plus8,Plus9,Plus10,Plus11,Plus12,Minus1,Minus2,Minus3,Minus4,Minus5,Minus6,Minus7,Minus8,Minus9,Minus10,Minus11,Minus12,Pay;
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.readData();
        String name = "";
        tvName = view.findViewById(R.id.tvShowName);
        tvName.setText("Hello " + name);
        tvCart = view.findViewById(R.id.tvShowCart);
        Amounts = new TextView[]{
                view.findViewById(R.id.tvAmount1),
                view.findViewById(R.id.tvAmount2),
                view.findViewById(R.id.tvAmount3),
                view.findViewById(R.id.tvAmount4),
                view.findViewById(R.id.tvAmount5),
                view.findViewById(R.id.tvAmount6),
                view.findViewById(R.id.tvAmount7),
                view.findViewById(R.id.tvAmount8),
                view.findViewById(R.id.tvAmount9),
                view.findViewById(R.id.tvAmount10),
                view.findViewById(R.id.tvAmount11),
                view.findViewById(R.id.tvAmount12)
        };

        Plus1 = view.findViewById(R.id.btnPlus1);Minus1 = view.findViewById(R.id.btnMinus1);
        Plus2 = view.findViewById(R.id.btnPlus2);Minus2 = view.findViewById(R.id.btnMinus2);
        Plus3 = view.findViewById(R.id.btnPlus3);Minus3 = view.findViewById(R.id.btnMinus3);
        Plus4 = view.findViewById(R.id.btnPlus4);Minus4 = view.findViewById(R.id.btnMinus4);
        Plus5 = view.findViewById(R.id.btnPlus5);Minus5 = view.findViewById(R.id.btnMinus5);
        Plus6 = view.findViewById(R.id.btnPlus6);Minus6 = view.findViewById(R.id.btnMinus6);
        Plus7 = view.findViewById(R.id.btnPlus7);Minus7 = view.findViewById(R.id.btnMinus7);
        Plus8 = view.findViewById(R.id.btnPlus8);Minus8 = view.findViewById(R.id.btnMinus8);
        Plus9 = view.findViewById(R.id.btnPlus9);Minus9 = view.findViewById(R.id.btnMinus9);
        Plus10 = view.findViewById(R.id.btnPlus10);Minus10 = view.findViewById(R.id.btnMinus10);
        Plus11 = view.findViewById(R.id.btnPlus11);Minus11 = view.findViewById(R.id.btnMinus11);
        Plus12 = view.findViewById(R.id.btnPlus12);Minus12 = view.findViewById(R.id.btnMinus12);
        Pay = view.findViewById(R.id.btnPay);
        setupButtonActions(Plus1, Minus1, Amounts[0],ItemsName[0].getText().toString());
        setupButtonActions(Plus2, Minus2, Amounts[1],ItemsName[1].getText().toString());
        setupButtonActions(Plus3, Minus3, Amounts[2],ItemsName[2].getText().toString());
        setupButtonActions(Plus4, Minus4, Amounts[3],ItemsName[3].getText().toString());
        setupButtonActions(Plus5, Minus5, Amounts[4],ItemsName[4].getText().toString());
        setupButtonActions(Plus6, Minus6, Amounts[5],ItemsName[5].getText().toString());
        setupButtonActions(Plus7, Minus7, Amounts[6],ItemsName[6].getText().toString());
        setupButtonActions(Plus8, Minus8, Amounts[7],ItemsName[7].getText().toString());
        setupButtonActions(Plus9, Minus9, Amounts[8],ItemsName[8].getText().toString());
        setupButtonActions(Plus10, Minus10, Amounts[9],ItemsName[9].getText().toString());
        setupButtonActions(Plus11, Minus11, Amounts[10],ItemsName[10].getText().toString());
        setupButtonActions(Plus12, Minus12, Amounts[11],ItemsName[11].getText().toString());
        Pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvCart.getText().toString().contains("None")){
                    Toast.makeText(getContext(), "You cannot pay without selecting items", Toast.LENGTH_SHORT).show();
                }else{


                    ClearScreen();
                }
            }
        });
        return view;
    }
    public void OrganizeProducts(TextView[] tv){
        String[] supermarketItems = {
                "Milk",
                "Eggs",
                "Apples",
                "Bananas",
                "Chicken breast",
                "Ground beef",
                "Bread",
                "Butter",
                "Rice",
                "Pasta",
                "Carrots",
                "Potatoes",
                "Chips",
                "Ice cream",
                "Toothpaste",
                "Detergent"
        };
        int NumOfProd = tv.length;
        for(int i =0; i< NumOfProd;i++){
            tv[i].setText(supermarketItems[i]);
            CartItems.put(supermarketItems[i],0);
        }
    }
    public void setupButtonActions(Button plusButton, Button minusButton, TextView textView,String Item) {
        plusButton.setOnClickListener(v -> updateCounter(true,textView,Item));
        minusButton.setOnClickListener(v -> updateCounter(false,textView,Item));
    }
    public void updateCounter(boolean isIncrement, TextView textView,String item) {
        int currentQuantity = CartItems.get(item);
        if (isIncrement) {
            textView.setText(String.valueOf(currentQuantity + 1));
            CartItems.put(item,currentQuantity+1);
        } else {
            if (currentQuantity > 0) {
                textView.setText(String.valueOf(currentQuantity - 1));
                CartItems.put(item,currentQuantity - 1);
            }
        }
        UpdateCartText();
    }

    public void UpdateCartText(){
        String currentCart = "You Selected: \n";
        boolean cartIsEmpty = true;
        for (Map.Entry<String, Integer> entry : CartItems.entrySet()) {
            String item = entry.getKey();
            int quantity = entry.getValue();

            if (quantity > 0) {
                currentCart += item + " x" + quantity + "\n"; // Concatenate item and quantity
                cartIsEmpty = false; // Mark the cart as non-empty
            }
        }

        // If the cart is empty, show "None"
        if (cartIsEmpty) {
            currentCart += "None";
        }

        // Update the TextView
        tvCart.setText(currentCart);
    }

    public void ClearScreen(){
        Toast.makeText(getContext(), "Thank You For Your Purchase", Toast.LENGTH_SHORT).show();
        for (Map.Entry<String, Integer> entry : CartItems.entrySet()) {
            String item = entry.getKey();
            int quantity = entry.getValue();
            if (quantity > 0) {
                CartItems.put(item,0);
            }
        }
        for(int i= 0; i <Amounts.length;i++){
            Amounts[i].setText("0");
        }
        tvCart.setText("You Selected: None");
    }

}