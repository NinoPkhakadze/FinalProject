package com.example.ninopkhakadze.mychat.tabs;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.example.ninopkhakadze.mychat.Classes.GetContacts;
import com.example.ninopkhakadze.mychat.Classes.LocalDataInitializer;
import com.example.ninopkhakadze.mychat.ContactAdapter;
import com.example.ninopkhakadze.mychat.R;
import com.example.ninopkhakadze.mychat.entity.Contact;

import java.util.ArrayList;

/**
 * Created by NinoPkhakadze on 12/3/2016.
 */

public class TabFragment2 extends android.support.v4.app.Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {



        ArrayList<Contact> contacts = new ArrayList<>();

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.tab_fragment_2, container, false);
        ListView listView = (ListView) viewGroup.findViewById(R.id.list);

        final   ContactAdapter adapter = new ContactAdapter(container.getContext(), R.layout.list_item, contacts );
        listView.setAdapter(adapter);
        new GetContacts(container.getContext(), listView, contacts).execute();

        final EditText searchBar = (EditText) viewGroup.findViewById(R.id.contacts_search_bar);

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
               String text = searchBar.getText().toString();
                adapter.filter(text);
            }
        });


        return viewGroup;

    }


}
