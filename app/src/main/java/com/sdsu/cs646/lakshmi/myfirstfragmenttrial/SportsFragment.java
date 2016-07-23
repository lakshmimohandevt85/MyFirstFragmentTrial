package com.sdsu.cs646.lakshmi.myfirstfragmenttrial;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class SportsFragment extends ListFragment implements AdapterView.OnItemClickListener
{
    TextView textView_view;
    Communicator communicator;
    ListView listView;
   // ArrayAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_sports, container, false);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        getListView().setOnItemClickListener(this);
        communicator = (Communicator) getActivity();
    }

    public void changeSports(String country)
    {
        ArrayAdapter adapter = null;

        if (country.equals(getResources().getString(R.string.country_india)))
        {
            adapter = ArrayAdapter.createFromResource(getActivity(), R.array.India, android.R.layout.simple_list_item_1);
        }
        else if (country.equals(getResources().getString(R.string.country_usa)))
        {
            adapter = ArrayAdapter.createFromResource(getActivity(), R.array.USA, android.R.layout.simple_list_item_1);
        }

        else if (country.equals(getResources().getString(R.string.country_mexico)))
        {
            adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Mexico, android.R.layout.simple_list_item_1);
        }

        setListAdapter(adapter);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {

        Toast.makeText(getActivity(), parent.getItemAtPosition(position) + " Selected", Toast.LENGTH_SHORT).show();
        communicator.respond(""+parent.getItemAtPosition(position));
    }
}
