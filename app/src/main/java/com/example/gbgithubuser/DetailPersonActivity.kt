package com.example.gbgithubuser

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.gbgithubuser.databinding.ActivityDetailPersonBinding
import com.example.gbgithubuser.databinding.ActivityMainBinding

class DetailPersonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailPersonBinding

    companion object{
        const val extra_peron = "extra_person"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPersonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitle("Detail User")

        val peron = intent.getParcelableExtra<Person>(extra_peron) as Person

        binding.tvName.text = peron.name.toString()
        binding.tvNameUser.text = peron.username.toString()
        binding.tvFollower.text = peron.followers.toString()
        binding.tvFollowing.text = peron.following.toString()
        binding.tvCompany.text = peron.company.toString()
        binding.tvNameRepositori.text = peron.name_repositori.toString()
        binding.tvLangRepository.text = peron.language_repositori.toString()
        binding.tvLocation.text = peron.location.toString()

        Glide.with(baseContext)
            .load(peron.img)
            .override(150,150)
            .into(binding.imgItemPhoto)

        binding.btnFollow.setOnClickListener {
            binding.btnFollow.text = "Following"
            binding.btnFollow.setBackgroundColor(Color.GRAY)
            Toast.makeText(this,"You Add "+peron.username.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}


