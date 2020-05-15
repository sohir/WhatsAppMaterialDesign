package com.example.whatsappmaterialdesing

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class Pager2Adapter(fragment: FragmentManager,lifecycle: Lifecycle):FragmentStateAdapter (fragment,lifecycle){
    override fun getItemCount(): Int {
        return 3

    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 ->ChatFragment()
            1->CalsFragment()
            2->StatusFragment()
            else ->ChatFragment()
        }
    }
//Mack class extend RecyclerView
//    inner class ViewPagerViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
//       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager,parent,false)
//        return ViewPagerViewHolder(view)
//    }
//
//    override fun getItemCount(): Int {
//        return content.size
//    }
//
//    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
//       holder.itemView.pagerText.text = content[position]
//    }
}