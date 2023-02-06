package com.example.crud_listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var floatingActionButton: FloatingActionButton
    lateinit var listuser:ListView
    lateinit var adapter: UserAdapter
    var useradd = mutableListOf<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        floatingActionButton=findViewById(R.id.floatingActionButton)
        listuser=findViewById(R.id.listView)
        adapter= UserAdapter(this,R.layout.user_detail,useradd)
        listuser.adapter=adapter
        floatingActionButton.setOnClickListener{
            showDialog()
        }
    }

    private fun showDialog() {
val inflat=LayoutInflater.from(this)
        val showview=inflat.inflate(R.layout.dialog_box,null)
        val name=showview.findViewById<EditText>(R.id.etFirstname)
        val phone=showview.findViewById<EditText>(R.id.etLastname)
        val adduserDialog=AlertDialog.Builder(this)
        adduserDialog.setView(showview)
        adduserDialog.setPositiveButton("add"){
            dialog,which->
            useradd.add(User("${name.text.toString()}",
                "${phone.text.toString()}"

            ))
            adapter.notifyDataSetChanged()


        }
        adduserDialog.setNegativeButton("Cancel"){
            diallog,which->
            diallog.dismiss()
            Toast.makeText(this,"Fail",Toast.LENGTH_LONG).show()
        }
        adduserDialog.create()
        adduserDialog.show()
    }
}