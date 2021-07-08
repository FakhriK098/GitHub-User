package com.example.gbgithubuser

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.Toast
import com.example.gbgithubuser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapters: PersonAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataUsername: Array<String>
    private lateinit var dataFollower: IntArray
    private lateinit var dataFollowing: IntArray
    private lateinit var dataImg: TypedArray
    private lateinit var dataLocation: Array<String>
    private lateinit var dataNmRep: Array<String>
    private lateinit var dataLangRep: Array<String>
    private lateinit var dataCompany: Array<String>
    private var persons = arrayListOf<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapters = PersonAdapter(this)
        binding.lvPerson.adapter = adapters

        prepare()
        addItem()

        binding.lvPerson.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

            val moveDetail = Intent(this,DetailPersonActivity::class.java)
            val person = Person(
                dataName[position],
                dataUsername[position],
                dataImg.getResourceId(position,-1),
                dataFollower[position],
                dataFollowing[position],
                dataLocation[position],
                dataNmRep[position],
                dataLangRep[position],
                dataCompany[position]
            )
            moveDetail.putExtra(DetailPersonActivity.extra_peron, person)
            startActivity(moveDetail)
        }

    }

    private fun prepare() {
        dataUsername = resources.getStringArray(R.array.username)
        dataFollower = resources.getIntArray(R.array.follower)
        dataFollowing = resources.getIntArray(R.array.following)
        dataImg = resources.obtainTypedArray(R.array.data_photo)
        dataName = resources.getStringArray(R.array.name)
        dataLocation = resources.getStringArray(R.array.location)
        dataNmRep = resources.getStringArray(R.array.name_repositori)
        dataLangRep = resources.getStringArray(R.array.lang_repositori)
        dataCompany = resources.getStringArray(R.array.company)
    }
    private fun addItem() {
        for (position in dataUsername.indices){
            val person = Person(
                dataName[position],
                dataUsername[position],
                dataImg.getResourceId(position, -1),
                dataFollower[position],
                dataFollowing[position],
                dataLocation[position],
                dataNmRep[position],
                dataLangRep[position],
                dataCompany[position]
            )
            persons.add(person)
        }
        adapters.person = persons
    }
}