package ru.netology.classes

data class Post(
    var id: Long = 0,
    val fromId: Long = 0,
    val ownerId: Long = 0,
    val date: Int = 1,
    val message: String = "default message",
    var isFriendsOnly: Boolean = true,
    //var likes: LikeClass,
    //var comments: CommentsClass,
    //var reports: ReportClass,
    //var geo: GeoClass
)

private class LikeClass {
    private var likesIds = emptyArray<Int>()

    fun add(id: Int) {
        likesIds += id
    }

    fun remove(id: Int): Boolean {
        val isThere = likesIds.contains(id)
        likesIds
            .filter { it != id }
            .toIntArray()
        return isThere
    }

    fun count (): Int {
        return likesIds.size
    }

    fun isLikedById (checkId: Int): Boolean {
        return checkId in likesIds
    }
}

object OneCommentObj {
    private var id = 0
    private var message: String? = null
    var answers = emptyArray<OneCommentObj>()

    fun edit (newMessage: String) {
        message = newMessage
    }

    fun showAnswers (): Array<OneCommentObj> {
        return answers
    }
}

class CommentsClass {
    private var isCommentable = true
    private var comments = emptyArray<OneCommentObj>()

    fun commentsOff() {
        isCommentable = false
        comments = emptyArray<OneCommentObj>()
    }

    fun add(comment: OneCommentObj) {
        if (isCommentable) {
            comments += comment
        }
    }

    fun answer(comment: OneCommentObj,
               commentTo: OneCommentObj){
        if (isCommentable) {
            commentTo.answers += comment
        }
    }

    fun count (): Int {
        if (isCommentable) {
            var result = 0
            for (comment in comments){
               result += 1 + comment.answers.size
            }
            return result
        }
        return -1
    }
}

class ReportClass {
    private var reportsIds = emptyArray<Int>()

    fun add(id: Int) {
        reportsIds += id
    }

    fun count (): Int {
        return reportsIds.size
    }

    fun isLikedById (checkId: Int): Boolean {
        return checkId in reportsIds
    }
}

class GeoClass {
    private val geo2d = IntArray(2) { 0 }
    private var geoStr = geo2d.toString()

    fun renameGeoStr (msg: String) {
        geoStr = msg
    }

    fun showGeo2d (): IntArray {
        return geo2d
    }

    fun showGeoStr (): String {
        return geoStr
    }
}

