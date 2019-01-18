package com.trial.kk.trial;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

public class Hedefler extends Fragment {

    private TabHost tabHost;
    private TabHost.TabSpec pt,sa,cr,pr,cu,ct,pz;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hedefler, container, false);

        tabHost = view.findViewById(R.id.tabhost);
        tabHost.setup();

        pt = tabHost.newTabSpec("Pt");
        pt.setIndicator("Pt");
        pt.setContent(R.id.Pt);
        tabHost.addTab(pt);

        sa = tabHost.newTabSpec("Sa");
        sa.setIndicator("Sa");
        sa.setContent(R.id.Sa);
        tabHost.addTab(sa);

        cr = tabHost.newTabSpec("Cr");
        cr.setIndicator("Cr");
        cr.setContent(R.id.Çr);
        tabHost.addTab(cr);

        pr = tabHost.newTabSpec("Pr");
        pr.setIndicator("Pr");
        pr.setContent(R.id.Pr);
        tabHost.addTab(pr);

        cu = tabHost.newTabSpec("Cu");
        cu.setIndicator("Cm");
        cu.setContent(R.id.Cm);
        tabHost.addTab(cu);

        ct = tabHost.newTabSpec("Ct");
        ct.setIndicator("Ct");
        ct.setContent(R.id.Ct);
        tabHost.addTab(ct);

        pr = tabHost.newTabSpec("Pr");
        pr.setIndicator("Pr");
        pr.setContent(R.id.Pr);
        tabHost.addTab(pr);

        return view;

    }

}
