package com.firstapp.fragment_task_alerdialog;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class Fragment_One extends Fragment {
    DataModel dataModel;
    RecyclerView recyclerView;
    DataAdapter dataAdapter;
    List<DataModel> dataModelArrayList=new ArrayList<>();

    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__one, container, false);


        }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.reccylerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setHasFixedSize(true);


        dataAdapter=new DataAdapter(getContext(),dataModelArrayList);
        recyclerView.setAdapter(dataAdapter);
        //loading the data with help of data model class
        DataModel dataModel=new DataModel("sai","sai@gmail.com","kakinada","8764321234","Trainee");
        dataModelArrayList.add(dataModel);

        DataModel dataModel1=new DataModel("sanjay","sanjay@gmail.com","telengana","8764321234","AndroidTrainee");
        dataModelArrayList.add(dataModel1);

        DataModel dataModel2=new DataModel("RK","RK@gmail.com","Mysore","8764321234","DotnetTrainee");
        dataModelArrayList.add(dataModel2);

        DataModel dataModel3=new DataModel("Harish","Harish@gmail.com","Vizag","8764321234","TestingTrainee");
        dataModelArrayList.add(dataModel3);

        DataModel dataModel4=new DataModel("Avinash","Avinash@gmail.com","kerala","8764321234","IOSTrainee");
        dataModelArrayList.add(dataModel4);

        DataModel dataModel5=new DataModel("Raju","Raju@gmail.com","Bengaluru","8764321234","SAPTrainee");
        dataModelArrayList.add(dataModel5);







//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
////                fragment=new View_List_Fragment();
//                Bundle bundle=new Bundle();
//
//
//                String templist= arrayAdapter.getItem(position).toString();
//                bundle.putString("key",templist);
//                View_List_Fragment view_list_fragment=new View_List_Fragment();
//                view_list_fragment.setArguments(bundle);
//
//
//                getFragmentManager().beginTransaction().replace(R.id.main_container,view_list_fragment).commit();
//
//
//                fragmentManager=getActivity().getSupportFragmentManager();
//                fragmentTransaction=fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.main_container,fragment);
//                fragmentTransaction.commit();
//            }
//        });
    }
}