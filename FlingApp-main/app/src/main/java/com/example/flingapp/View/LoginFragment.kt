package com.example.flingapp.View

import android.content.ContentProviderClient
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.flingapp.R
import com.example.flingapp.databinding.FragmentLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    private lateinit var googleSignInClient: GoogleSignInClient
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        auth = FirebaseAuth.getInstance()


        binding.signUpButton.setOnClickListener{

            findNavController().navigate(R.id.action_loginFragment_to_registerFragment, null)
        }
        val google = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("287932615132-j1o0lq2ngv6q1r1d4euu35rqeir9rr2e.apps.googleusercontent.com")
            .requestEmail()
            .build()
        val googleSignInClient = GoogleSignIn.getClienr

        binding.loginButton.setOnClickListener {
            val email = binding.emailAddress.text.toString()
            val password = binding.password.text.toString()
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this.requireActivity(), OnCompleteListener { task ->
                if(task.isSuccessful){
                    Toast.makeText(context, "Successfully Logged In", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_loginFragment_to_screenFragment, null)
                }
                else{
                    Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
                }
            })
        }
        return binding.root
    }


}