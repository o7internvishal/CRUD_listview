package com.example.crud_listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import org.w3c.dom.Text

class UserAdapter (var c: Context,var resourse :Int,var userList: List<User>):
ArrayAdapter<User>(c,resourse,userList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflate=LayoutInflater.from(c)
        val userview=inflate.inflate(resourse,null)
        val name=userview.findViewById<TextView>(R.id.tvFirstName)
        val phone=userview.findViewById<TextView>(R.id.tvLastName)
        val listuser=userList[position]
        name.text=listuser.userName
        phone.text=listuser.UserPhone
        return userview
    }
}