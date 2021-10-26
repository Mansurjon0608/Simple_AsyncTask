package com.example.asynctaskprogress

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var handler : Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        handler = Handler()

        btn_download.setOnClickListener {
       MyAsyncTask().execute()
        }

    }

    inner class MyAsyncTask : AsyncTask<Void, Void, Void>(){

        override fun onPreExecute() {
            super.onPreExecute()
            progress.visibility = View.VISIBLE
            handler.postDelayed({
                progress.visibility = View.GONE
                image.setImageResource(R.drawable.iiii)
                Toast.makeText(this@MainActivity, "Saqlandi", Toast.LENGTH_SHORT).show()
                btn_download.setImageResource(R.drawable.ic_baseline_done_24)
            }, 3000)

        }

        override fun doInBackground(vararg params: Void): Void? {
            return null
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            btn_download.isClickable = false
        }

    }

}