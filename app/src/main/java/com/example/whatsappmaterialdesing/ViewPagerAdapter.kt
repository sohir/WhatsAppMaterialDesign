package com.example.whatsappmaterialdesing

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter (fragmentManager:FragmentManager): FragmentPagerAdapter(fragmentManager) {
   var fragments = ArrayList<Fragment>()
    var tabTitls = ArrayList<String>()
    fun addFragment(fragment: Fragment,title:String){
        this.fragments.add(fragment)
        this.tabTitls.add(title)
    }

    override fun getItem(position: Int): Fragment {
        return this.fragments[position]
    }

    override fun getCount(): Int {
        return this.fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return this.tabTitls[position]
    }
}