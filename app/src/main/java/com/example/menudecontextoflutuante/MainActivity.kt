package com.example.menudecontextoflutuante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.widget.PopupMenu

class MainActivity : AppCompatActivity() {

    private var itemList: Array<String> = arrayOf("Item 01", "Item 02", "Item 03",)
    private var listView: ListView? = null
    private var arrayAdapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.context_lisView)
        arrayAdapter = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_expandable_list_item_1,
            itemList
        )
        listView?.adapter = arrayAdapter

        registerForContextMenu(listView)


    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.main_menu, menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_call -> {
                Toast.makeText(applicationContext, "Call Menu", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_message ->{
                Toast.makeText(applicationContext, "Call Chamada", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_phone ->{
                Toast.makeText(applicationContext, "Call Phone", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> return super.onContextItemSelected(item)




        }
    }
}



