package com.example.githubapiexample

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.githubapiexample.databinding.ActivityDetailBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {
    private val githubServiceProvider = GithubServiceProvider()
    lateinit var user : User
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val detailBinding : ActivityDetailBinding = DataBindingUtil
            .setContentView(this,R.layout.activity_detail)

        val userID = intent.getStringExtra("USER_NAME")
        loadGithubUserData(userID)
    }
    private fun loadGithubUserData(userID : String?) {
        githubServiceProvider.githubAPIService.getUser(userID).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                user.bio = response.body()?.bio.toString()
                user.company = response.body()?.company.toString()

            }
            override fun onFailure(call: Call<User>, t: Throwable) {

            }
        })
    }
}