package com.example.githubapiexample

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.githubapiexample.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {

    private val githubServiceProvider = GithubServiceProvider()
    lateinit var detailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = DataBindingUtil.setContentView(this,R.layout.activity_detail)
        val userID = intent.getStringExtra("TOKEN")
        loadGithubUserData(userID)
    }

    private fun loadGithubUserData(userID : String?) {
        githubServiceProvider.githubAPIService.getUser(userID).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                loadGithubValues(response,detailBinding)
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                println(t.message)
            }
        })
    }

    @SuppressLint("SetTextI18n")
    private fun loadGithubValues(response: Response<User>, detailBinding: ActivityDetailBinding) {
        val picasso = Picasso.get()
        Log.d("TEST",response.body()?.Title)
        /*picasso.load(response.body()?.avatar_url.toString()).into(detailBinding.imgUserImage)
        detailBinding.txtUserBio.text = getString(R.string.bio) + response.body()?.bio.toString()
        detailBinding.txtUserCompany.text = "Company : " + response.body()?.company.toString()
        detailBinding.txtPublicRepos.text = "Public Repos : " + response.body()?.public_repos.toString()
        detailBinding.txtLoginName.text = "Login Name : " + response.body()?.login.toString()
        detailBinding.txtName.text = "Name : " + response.body()?.name.toString()
        detailBinding.txtUserCity.text = "Location : " +response.body()?.location.toString()
        detailBinding.txtFollowings.text =  "Following : " + response.body()?.following.toString()
        detailBinding.txtFollowers.text = "Followers : " + response.body()?.followers.toString()
        detailBinding.txtUserID.text = "ID : " + response.body()?.id.toString()*/
    }
}