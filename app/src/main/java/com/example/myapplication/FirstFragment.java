package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.client.Client;
import com.example.myapplication.client.ClientData;
import com.example.myapplication.client.ClientShared;
import com.example.myapplication.client.ClientViewModel;
import com.example.myapplication.databinding.FragmentFirstBinding;
import com.google.android.material.textfield.TextInputEditText;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private static final String ARG_NOM= "nom";
    private static final String ARG_PRENOM = "prenom";

    private String mNom;
    private String mPrenom;


    private ClientShared clientShared;

    private OnFragment1InteractionListener mListener;

    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param nom Parameter 1.
     * @param prenom Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String nom, String prenom) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NOM, nom);
        args.putString(ARG_PRENOM, prenom);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            mNom=getArguments().getString(ARG_NOM);
            mPrenom=getArguments().getString(ARG_PRENOM);
        }
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState

    ) {


        setHasOptionsMenu(true);
        //binding = FragmentFirstBinding.inflate(inflater, container, false);
        binding = DataBindingUtil.inflate ( inflater ,
                R.layout.fragment_first,container ,false );
        View view = binding.getRoot ();
        return view ;

    }




    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        /*
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mNom = getArguments().getString(ARG_NOM);
            mPrenom = getArguments().getString(ARG_PRENOM);
        }


        Client c = new Client("Test","Piotr");
        ClientViewModel cvm = new ClientViewModel(c);
        binding.setViewModel(cvm);

        ClientShared cs = new ViewModelProvider(requireActivity()).get(ClientShared.class);
        */
        super.onViewCreated(view, savedInstanceState);
        clientShared = new ViewModelProvider(requireActivity()).get(ClientShared.class);


        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nom = view.findViewById (R.id.nom_A);
                EditText prenom = view.findViewById (R.id.prenom_A);
                EditText birthday = view.findViewById (R.id.birthday_A);
                EditText birthplace = view.findViewById (R.id.birthplace_A);


                String n = nom.getText().toString();
                String p = prenom.getText().toString();
                String bd = birthday.getText().toString();
                String bp = birthplace.getText().toString();
                String total = n+"/"+p+"/"+bd+"/"+bp;

                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);

                Toast.makeText(getActivity().getApplicationContext(),
                        total, Toast.LENGTH_SHORT ).show();

                clientShared.setdata(new ClientData(n,p));


            }
        });

    }

    @Override
    public void onCreateOptionsMenu( Menu menu , MenuInflater inflater) {
    // Inflate the menu ; this adds items to the action bar
    // if it is present .
        inflater.inflate(R.menu.menu_discret , menu );
        super.onCreateOptionsMenu(menu , inflater );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.reinitialiser) {
            binding.nomA.setText("");
            binding.prenomA.setText("");
            binding.birthdayA.setText("");
            binding.birthplaceA.setText("");
            return true;
        }

        if (id == R.id.numTelephone) {
            binding.phone.setVisibility(View.VISIBLE);
            return true;
        }

        if (id == R.id.birthplacewiki) {
            TextInputEditText villeB = binding.birthplaceA;
            String ville = villeB.getText().toString();
            Intent view = new Intent();
            view.setAction(Intent.ACTION_VIEW);
            view.setData(Uri.parse("http://fr.wikipedia.org/wiki/"+ville));
            startActivity(view);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragment1InteractionListener {
        // TODO: Update argument type and name
        void onFragment1Interaction(Uri uri);
    }

}