package com.example.githubapiexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import com.example.githubapiexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtUserInput : EditText
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        edtUserInput = binding.editQuery

        val btnViewUserInfo = binding.btnFetchUserInfo
        btnViewUserInfo.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
       if (v != null){
           when(v.id){
               R.id.btnFetchUserInfo -> {
                   passEditTextData()
               }
           }
       }
    }

    private fun passEditTextData(){
        val intent = Intent(this,DetailActivity::class.java).apply {
            putExtra("USER_NAME",edtUserInput.text)
        }
        startActivity(intent)
    }
}
