package com.example.flingapp.View

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.flingapp.R
import com.example.flingapp.databinding.FragmentRegisterBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth


class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        auth = FirebaseAuth.getInstance()

        binding.signupButton.setOnClickListener{
            val name = binding.newName.text.toString()
            val email = binding.newEmail.text.toString()
            val password = binding.newPassword.text.toString()
            val repassword = binding.rePassword.text.toString()
            if(TextUtils.isEmpty(password)){
                binding.newPassword.setError("Enter password")
            }
            if(!repassword.equals(password)){
                binding.rePassword.setError("Password do not match")
            }
            else if (password.length < 6){
                binding.newPassword.setError("Password must have more than 6 characters long ")
            }
            else {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this.requireActivity(), OnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(context, "Successful", Toast.LENGTH_SHORT).show()
                            findNavController().navigate(
                                R.id.action_registerFragment_to_loginFragment,
                                null
                            )

                        } else {
                            Toast.makeText(context, "Registration Failed", Toast.LENGTH_SHORT)
                                .show()
                        }
                    })
            }
        }
        return binding.root
    }



}