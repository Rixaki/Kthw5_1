package ru.netology.classes

import java.util.*

class WallService {
    private var posts = emptyArray<Post>()

    init {
        idCounterNext = 1
    }

    /*
    fun likeById(id: Int,
                 post: Post) {
        post.likes.add(id)
    }
    */
    companion object { //static count
        @JvmField
        var idCounterNext: Long = 1
    }

    fun clear() {
        posts = emptyArray<Post>()
    }

    fun add (post: Post) {
	    val postCopy = post.copy(id = WallService.idCounterNext)
        WallService.idCounterNext += 1
        posts += postCopy
    }

    fun getLast (): Post {
        return posts.last()
    }

    fun update(updatedPost: Post): Boolean {
        for ((index,post) in posts.withIndex()) {
            if (post.id == updatedPost.id){
                posts[index] = updatedPost.copy()
                return true
            }
        }
        return false
    }

    fun printAll() {
        println("List of posts:")
        for (post in posts) {
            println(post)
        }
    }

}