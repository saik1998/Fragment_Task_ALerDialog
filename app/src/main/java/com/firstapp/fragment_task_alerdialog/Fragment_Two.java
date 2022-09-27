package com.firstapp.fragment_task_alerdialog;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class Fragment_Two extends Fragment {

    ImageView back;
    AlertDialog alertDialog;
    TextView tempname, tempmail, tempmobile, taddress, tedesignation;
    LinearLayout linearLayout;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment__two, container, false);

        //using back button to navigate to the previous fragment
        back = root.findViewById(R.id.back_arrow);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment_two = new Fragment_One();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment_two);
                fragmentTransaction.attach(fragment_two);
                fragmentTransaction.commit();
            }
        });

        tempname = root.findViewById(R.id.fragment_emp_name);
        tempmobile = root.findViewById(R.id.fragment_emp_mobilr);
        tedesignation = root.findViewById(R.id.fragment_emp_designation);
        tempmail = root.findViewById(R.id.fragment_emp_mail);
        taddress = root.findViewById(R.id.fragment_emp_address);

        //using bundle method to passing the data with help of key
        Bundle bundle = this.getArguments();
        String data = bundle.getString("Name");
        tempname.setText(data);
        String data1 = bundle.getString("Mail");
        tempmail.setText(data1);
        String data2 = bundle.getString("Address");
        taddress.setText(data2);
        String data3 = bundle.getString("Mobile");
        tempmobile.setText(data3);
        String data4 = bundle.getString("Designation");
        tedesignation.setText(data4);

        //clicking linear layout to showing the fragment dialog
        linearLayout = root.findViewById(R.id.alertdialog);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                View root = getLayoutInflater().inflate(R.layout.custom_alertdialog, null);
                TextView alertname=root.findViewById(R.id.AlertName);
                TextView alertmail=root.findViewById(R.id.AlertMail);

                alertname.setText(data);
                alertmail.setText(data1);

                builder.setView(root);
                builder.setCancelable(false);

                Button cancel = root.findViewById(R.id.cancel);
                Button ok = root.findViewById(R.id.ok);

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(v.getContext(), "Thank you", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();

                    }
                });
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(v.getContext(), "Welcome", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                    }

                });

                alertDialog = builder.create();
                alertDialog.show();


            }
        });
        return root;
    }
}




