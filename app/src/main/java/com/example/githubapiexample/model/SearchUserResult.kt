package com.example.githubapiexample.model

data class SearchUserResult (
    var totalCount: Long,
    var isIncompleteResults: Boolean,
    var items: List<Item>
) {
    data class Item(
        var login: String,
        var id: Long?,
        var nodeId: String?,
        var avatarUrl: String?,
        var gravatarId: String?,
        var url: String?,
        var htmlUrl: String?,
        var followersUrl: String?,
        var followingUrl: String?,
        var gistsUrl: String?,
        var starredUrl: String?,
        var subscriptionsUrl: String?,
        var organizationsUrl: String?
    )
}
