package com.example.whatsappmaterialdesing

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
/*If we working on navigation components and framgent use this
https://developer.android.com/guide/navigation/navigation-swipe-view-2#kotlin
https://developer.android.com/training/animation/screen-slide-2*/
class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        whatsToolbar.title = "WhatsApp"
        setSupportActionBar(whatsToolbar)
        val actionToggle = ActionBarDrawerToggle(this,
        mDrawerLayout,
        whatsToolbar,
        R.string.drawer_open,
        R.string.drawer_close)
        mDrawerLayout.addDrawerListener(actionToggle)
        actionToggle.syncState()
        mNavigationView.setNavigationItemSelectedListener ( this )
        val adapter = Pager2Adapter(supportFragmentManager,lifecycle)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout,viewPager){
            tab, position ->
           tab.text =  when(position){
               0 -> "Chats"
               1->"Calls"
               2->"Status"
               else -> "Chats"
            }
        }.attach()
        
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity,"Reselected ${tab?.text}",Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity,"unselected ${tab?.text}",Toast.LENGTH_SHORT).show()
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity,"selected ${tab?.text}",Toast.LENGTH_SHORT).show()

            }
        })
//        viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
//        viewPager.beginFakeDrag()
//        viewPager.fakeDragBy(-10f)
//        viewPager.endFakeDrag()


        tabLayout.setTabTextColors(Color.parseColor("#84AFAB"),Color.parseColor("#FFFFFF"))
        showContextual.setOnClickListener {
             startSupportActionMode(ContextualMenu())
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       menuInflater.inflate(R.menu.menu_whatsapp,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       var id = item.itemId
        when(id){
            R.id.search-> Toast.makeText(this, "Search", Toast.LENGTH_LONG).show()
            R.id.newGroup-> Toast.makeText(this, "New Group", Toast.LENGTH_LONG).show()
            R.id.newBroadcast-> Toast.makeText(this, "New Broadcast", Toast.LENGTH_LONG).show()
        }
        return true
    }
    inner class ContextualMenu :androidx.appcompat.view.ActionMode.Callback {

        override fun onActionItemClicked(
            mode: androidx.appcompat.view.ActionMode?,
            item: MenuItem?
        ): Boolean {
            TODO("Not yet implemented")
        }

        override fun onCreateActionMode(
            mode: androidx.appcompat.view.ActionMode?,
            menu: Menu?
        ): Boolean {
            mode?.menuInflater?.inflate(R.menu.contextual_menu,menu)
            return true
        }

        override fun onPrepareActionMode(
            mode: androidx.appcompat.view.ActionMode?,
            menu: Menu?
        ): Boolean {
            mode?.title = "Contextual"
            return true
        }

        override fun onDestroyActionMode(mode: androidx.appcompat.view.ActionMode?) {
            mode?.finish()
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
      //After clicked on any item show its name then close the navigationDrawer
        Toast.makeText(this,"${item.title} Clicked",Toast.LENGTH_SHORT).show()
        closeDrawer()
        return true
    }
    private fun  closeDrawer(){
        mDrawerLayout.closeDrawer(GravityCompat.START)
    }

    override fun onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START))
            closeDrawer()
        else
        super.onBackPressed()
    }
}

