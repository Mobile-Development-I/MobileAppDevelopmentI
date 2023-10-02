package com.jaresi.wishlist

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val data = ArrayList<ItemsViewModel>()
    var adapter = CustomAdapter(data)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)
        // ArrayList of class ItemsViewModel

        // This loop will create 20 Views containing
        // the image with the count of view
        //for (i in 1..20) {
        //    data.add(ItemsViewModel(R.drawable.ic_baseline_folder_24, "Item " + i, "\$temp","example"))
        //}
        // This will pass the ArrayList to our Adapter
        //val adapter = CustomAdapter(data)
        // Setting the Adapter with the recyclerview
        //recyclerview.adapter = adapter

        showList(data, recyclerview)
        val submitButton = findViewById<Button>(R.id.submitButton)

        submitButton.setOnClickListener {
            data.add(ItemsViewModel(R.drawable.ic_baseline_folder_24,
                findViewById<EditText>(R.id.itemNameField).text.toString(),
                findViewById<EditText>(R.id.priceField).text.toString(),
                findViewById<EditText>(R.id.linkField).text.toString()))
            showList(data, recyclerview)
            hideKeyboard()
            clearData(findViewById<EditText>(R.id.itemNameField), findViewById<EditText>(R.id.priceField), findViewById<EditText>(R.id.linkField))
        }


    }

    fun showList(data: ArrayList<ItemsViewModel>, view: RecyclerView){
        adapter = CustomAdapter(data)
        view.adapter = adapter
    }

    fun hideKeyboard(){
        val view: View? = this.currentFocus
        val inputManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        if (view != null) {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0)
        }
    }

    fun clearData(itemET: EditText, priceET: EditText, linkET: EditText){
        itemET.text.clear()
        priceET.text.clear()
        linkET.text.clear()
    }
}