package ru.netology.classes

class WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

    init {
        idCounterNext = 1
        Comment.commentCounterNext = 1
    }

    companion object { //static count
        @JvmField
        var idCounterNext: Long = 1
    }

    data class Comment (
        var id: Long = 0,
        var fromId: Long = 0,
        var date: Long = 1,
        var text: String = "none text"
    ) {
        companion object { //static count
            @JvmField
            var commentCounterNext: Long = 1
        }

        override fun toString(): String {
            return "id:$id, text:$text"
        }

        var donut: Donut = Donut()
        class Donut {
            var isDon: Boolean = false
            var placeHolder: String = "placeholder"
        }
        var replyToUser: Long = 0
        var replyToComment: Long = 0
        var attachment: Attachment? = null
        private var parentsStack = emptyArray<Comment>()
        var thread: Thread = Thread()
        class Thread {
            var count: Long = 0
            var items = emptyArray<Comment>()
            var canPost: Boolean = false
            var showReplyButton: Boolean = false
            var groupsCanPost: Boolean = false
        }
    }

    fun clear() {
        posts = emptyArray<Post>()
    }

    fun add(post: Post) {
        val postCopy = post.copy(id = idCounterNext)
        idCounterNext += 1
        posts += postCopy
    }

    fun getLast(): Post {
        return posts.last()
    }

    fun update(updatedPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == updatedPost.id) {
                posts[index] = updatedPost.copy()
                return true
            }
        }
        return false
    }

    fun printAllPosts() {
        println("List of posts:")
        for (post in posts) {
            println(post)
        }
    }

    fun printAllComments() {
        println("List of comments:")
        for (comment in comments) {
            println(comment)
        }
    }

    fun createComment(postId: Int, comment: Comment): Comment? {
        for ((index, post) in posts.withIndex()) {
            if (post.id.toInt() == postId) {
                val commentCopy = comment.copy(id = Comment.commentCounterNext)
                Comment.commentCounterNext += 1
                comments += commentCopy
                return commentCopy
            }
        }
        throw PostNotFoundException("post id #$postId was not founded")
    }

    fun isThereComment(idComment: Long): Boolean{
        for (comment in comments) {
            if (comment.id == idComment) {
                return true
            }
        }
        return false
    }

    class PostNotFoundException(msg: String): RuntimeException(msg)

}