package com.example.whatsappmaterialdesing

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        whatsToolbar.title = "WhatsApp"
        setSupportActionBar(whatsToolbar)

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(ChatFragment(),"Chats")
        viewPagerAdapter.addFragment(CalsFragment(),"Calls")
        viewPagerAdapter.addFragment(StatusFragment(),"Status")

        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
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
}

