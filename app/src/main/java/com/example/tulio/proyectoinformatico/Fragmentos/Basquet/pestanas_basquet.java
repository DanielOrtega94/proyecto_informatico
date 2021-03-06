package com.example.tulio.proyectoinformatico.Fragmentos.Basquet;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tulio.proyectoinformatico.Adaptadores.TabViewPagerAdapter;
import com.example.tulio.proyectoinformatico.R;

public class pestanas_basquet extends Fragment {
    private ViewPager mViewPager;
    private TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView= inflater.inflate(R.layout.activity_pestanas_basquet, container, false);
        setHasOptionsMenu(true);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) rootView.findViewById(R.id.container);


        tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        setupViewPage(mViewPager);


        return rootView;
    }

    private View setupViewPage(ViewPager viewPager) {
        TabViewPagerAdapter adapter= new TabViewPagerAdapter(getChildFragmentManager());

        adapter.addFragment(new Tab_Tabla_Basquet(), "Tabla");
        adapter.addFragment(new Tab_Programacion_Basquet(), "Programacion");
        adapter.addFragment(new Tab_Sancionados_Basquet(), "Sancionados");
        adapter.addFragment(new Tab_Goleadores_Basquet(), "Goleadores");

        viewPager.setAdapter(adapter);
        return viewPager;

    }

}

