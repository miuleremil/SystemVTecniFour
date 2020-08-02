package system.vtecnifour.interfaces;

import system.vtecnifour.fragments.BienvenidaFragment;
import system.vtecnifour.fragments.ContenedorRegistrosFragment;
import system.vtecnifour.fragments.RegistrarUsuarioFragment;
import system.vtecnifour.fragments.RegistrarSmartphoneFragment;
import system.vtecnifour.fragments.RegistrarOrdenadorFragment;

public interface IFragments extends
        BienvenidaFragment.OnFragmentInteractionListener,
        ContenedorRegistrosFragment.OnFragmentInteractionListener,
        RegistrarUsuarioFragment.OnFragmentInteractionListener,
        RegistrarSmartphoneFragment.OnFragmentInteractionListener,
        RegistrarOrdenadorFragment.OnFragmentInteractionListener {
}
