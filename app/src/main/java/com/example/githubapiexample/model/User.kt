package com.example.githubapiexample.model

import java.util.*

data class User (
    var login: String,
    var id: Long?,
    var nodeId: String?,
    var avatarUrl: String,
    var gravatarId: String?,
    var url: String?,
    var htmlUrl: String?,
    var followersUrl: String?,
    var followingUrl: String?,
    var gistsUrl: String?,
    var starredUrl: String?,
    var subscriptionsUrl: String?,
    var organizationsUrl: String?,
    var reposUrl: String?,
    var eventsUrl: String?,
    var receivedEventsUrl: String?,
    var type: String?,
    var isSiteAdmin: Boolean?,
    var name: String?,
    var company: String?,
    var blog: String?,
    var location: String?,
    var email: String?,
    var isHireable: Boolean?,
    var bio: String?,
    var privateRepos: Int?,
    var privateGists: Int?,
    var followers: Int?,
    var following: Int?,
    var createdAt: Date?,
    var updatedAt: Date?
)
