package com.aplikasi.pintarit

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.viewModels
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.aplikasi.pintarit.databinding.FragmentAccountBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AccountFragment: Fragment() {
    private lateinit var binding: FragmentAccountBinding
    private lateinit var sf: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private lateinit var btn_logout: Button
    private lateinit var btn_change_username: Button
    private lateinit var profileIcon: ImageView
    private lateinit var fabPhoto: FloatingActionButton



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccountBinding.inflate(inflater, container, false)
        val etGantiNama = binding.root.findViewById<EditText>(R.id.etGantiNama)
        val usernameText = binding.root.findViewById<TextView>(R.id.tvNamaKamuSekarang)
        profileIcon = binding.root.findViewById(R.id.iv_profile_user)
        fabPhoto = binding.root.findViewById(R.id.fabPhoto)
        sf = requireActivity().applicationContext.getSharedPreferences("saved_preferences", Context.MODE_PRIVATE)
        editor = sf.edit()

        val username = sf.getString("sf_username", null)
        usernameText.text = username

        btn_logout = binding.root.findViewById(R.id.btnLogOut)
        btn_logout.setOnClickListener{
            val intent = Intent(context, LoginScreen::class.java)
            startActivity(intent)
        }

        btn_change_username = binding.root.findViewById<Button>(R.id.btnChangeUsername)
        btn_change_username.setOnClickListener{
            val i = Intent(activity, MainActivity::class.java)
            val username = etGantiNama.text.toString()
            editor.apply {
                putString("sf_username", username)
                commit()
            }
            startActivity(i)
        }

        fabPhoto.setOnClickListener{
            ImagePicker.with(this)
                .crop()	    			//Crop image(Optional), Check Customization for more option
                .compress(1024)			//Final image size will be less than 1 MB(Optional)
                .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                .start()
        }
        return binding.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        profileIcon.setImageURI(data?.data )
    }
}
