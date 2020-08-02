package system.vtecnifour.fragments;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import system.vtecnifour.R;
import system.vtecnifour.adapters.SeccionesAdapters;
import system.vtecnifour.clases.Utilidades;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContenedorRegistrosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContenedorRegistrosFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ContenedorRegistrosFragment.OnFragmentInteractionListener mListener;

    View vista;
    private AppBarLayout appbar;
    private TabLayout pestañas;
    private ViewPager viewPager;

    public ContenedorRegistrosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContenedorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContenedorRegistrosFragment newInstance(String param1, String param2) {
        ContenedorRegistrosFragment fragment = new ContenedorRegistrosFragment();
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
        vista=inflater.inflate(R.layout.fragment_contenedor, container, false);

        if (Utilidades.rotacion==0){

            View parent = (View) container.getParent();

            if (appbar==null){
                appbar=(AppBarLayout)parent.findViewById(R.id.appbar);
                pestañas=new TabLayout(getActivity());
                pestañas.setTabTextColors(Color.parseColor("#FFFFFF"),Color.parseColor("#FFFFFF"));
                appbar.addView(pestañas);

                viewPager=(ViewPager)vista.findViewById(R.id.idViewPagerInformacion);
                llenarViewPager(viewPager);
                viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                    }
                });
                pestañas.setupWithViewPager(viewPager);
            }
            //pestañas distribuidas
            pestañas.setTabGravity(TabLayout.GRAVITY_FILL);
        }else{
            Utilidades.rotacion=1;
        }

        return vista;
    }

    private void llenarViewPager(ViewPager viewPager) {
        SeccionesAdapters adapters= new SeccionesAdapters(getFragmentManager());
        adapters.addFragmet(new RegistrarUsuarioFragment(),"Cliente");
        adapters.addFragmet(new RegistrarSmartphoneFragment(),"Smartphone");
        adapters.addFragmet(new RegistrarOrdenadorFragment(),"Ordenador");

        viewPager.setAdapter(adapters);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //ELIMINAR pestañas del appbar
        if (Utilidades.rotacion==0){
            appbar.removeView(pestañas);
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
