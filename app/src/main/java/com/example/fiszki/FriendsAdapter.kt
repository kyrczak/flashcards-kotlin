package com.example.fiszki

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row_friend.view.*
import java.text.FieldPosition

class FriendsAdapter(private val fiszki: MutableList<Fiszka>) : RecyclerView.Adapter<FriendsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.row_friend,p0,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = fiszki.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.PLWord.text = fiszki[position].polishWord
        holder.ENGWord.text = fiszki[position].englishWord
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ENGWord = view.englishWord
        val PLWord = view.polishWord
    }
}
