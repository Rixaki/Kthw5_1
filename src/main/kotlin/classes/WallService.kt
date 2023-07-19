package ru.netology.classes

import java.util.*

object WallService {
    private var posts = emptyArray<Post>()

    /*
    fun likeById(id: Int,
                 post: Post) {
        post.likes.add(id)
    }
    */

    fun clear() {
        posts = emptyArray<Post>()
    }

    fun add (post: Post) {
        post.id = post.idCounterNext
        post.idCounterNext += 1
        posts += post
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
}