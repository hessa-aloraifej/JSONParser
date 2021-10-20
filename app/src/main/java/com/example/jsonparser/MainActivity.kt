package com.example.jsonparser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    private var arr = arrayListOf<DataItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myRV = findViewById<RecyclerView>(R.id.myRV)
        var json: String? = null
        try {
            val inputStream: InputStream = assets.open("data.json")
            json = inputStream.bufferedReader().use { it.readText() }

            var jsonarr = JSONArray(json)
            println(jsonarr.getJSONObject(0).getString("copyright"))

            for (i in 0..jsonarr.length()-1) {
                var jsonobj = jsonarr.getJSONObject(i)

                arr.add(DataItem(jsonobj.getString("title"), jsonobj.getString("url")))
            }
            myRV.adapter = RVAdapter(arr)
            myRV.layoutManager = LinearLayoutManager(this)
            // tv.text=json
        } catch (e: IOException) {

        }

    }
}