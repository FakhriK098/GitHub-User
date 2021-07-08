package com.example.gbgithubuser

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PersonAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var person = arrayListOf<Person>()


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var itemView = convertView
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val person = getItem(position) as Person
        viewHolder.bind(person)
        return itemView

    }

    private inner class ViewHolder internal constructor(view: View) {
        private val txtUsername: TextView = view.findViewById(R.id.tv_name_user)
        private val txtFollower: TextView = view.findViewById(R.id.tv_follower)
        private val txtFollowing: TextView = view.findViewById(R.id.tv_following)
        private val imgPerson: ImageView = view.findViewById(R.id.img_item_photo)

        internal fun bind(person: Person){
            txtUsername.text = person.username
            txtFollower.text = person.followers.toString()
            txtFollowing.text = person.following.toString()
            Glide.with(context)
                .load(person.img)
                .override(55,55)
                .into(imgPerson)
        }
    }

    override fun getItem(position: Int): Any {
        return person[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return person.size
    }

}