package system.vtecnifour.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SeccionesAdapters extends FragmentStatePagerAdapter {

    private  final List<Fragment> listaFragment=new ArrayList<>();
    private  final List<String> listaTitulos=new ArrayList<>();


    public SeccionesAdapters(FragmentManager fm) {
        super(fm);
    }

    public void addFragmet(Fragment fragment,String titulo){
        listaFragment.add(fragment);
        listaTitulos.add(titulo);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listaTitulos.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return listaFragment.get(position);
    }

    @Override
    public int getCount() {
        return listaFragment.size();
    }
}
