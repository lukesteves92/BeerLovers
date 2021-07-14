package com.lucasesteves.beerloversapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.lucasesteves.beerloversapp.R
import com.lucasesteves.beerloversapp.databinding.FragmentHomeBinding


class homeFragment : Fragment() {
    private var binding: FragmentHomeBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root





//        binding?.deslogar?.setOnClickListener{
//
//            startActivity(Intent(activity, LoginActivity::class.java))
//
//        }



//        val bundle = Bundle()
//        with(bundle) {
//
//            var user = getString("KEY_USER")
//            var password = getString("KEY_PASSWORD")
//
//        }


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val usuario = arguments?.getString(KEY_USER)
        Log.i("TAG02", "$usuario")

        val bemvindo = "Olá, $usuario"

        binding?.textHello?.text = bemvindo
        binding?.textHello?.isVisible = true


        binding?.AcessarPerfil?.setOnClickListener{
            findNavController().navigate(
                R.id.action_homeFragment_to_perfilFragment
            )

        }

        binding?.BuscarCervejas?.setOnClickListener{
            findNavController().navigate(
                R.id.action_homeFragment_to_buscarFragment
            )

        }

        binding?.deslogar?.setOnClickListener{
            signOut()
            Toast.makeText(context, "Logout efetuado com sucesso", Toast.LENGTH_LONG).show()
            startActivity(Intent(activity, LoginActivity::class.java))

        }




    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun signOut() {
        Firebase.auth.signOut()

    }

    companion object {
        const val KEY_USER = "user"
        const val KEY_PASSWORD = "password"
    }
}