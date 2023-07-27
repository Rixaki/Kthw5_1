package ru.netology.classes

data class Post(
    var id: Long = 0,
    val ownerId: Long = 0,
    val fromId: Long = 0,
    val createdById: Long = 0,
    val date: Int = 1,
    var message: String = "default message",
    val replyOwnerId: Long = 0,
    val replyPostId: Long = 0,
    var isFriendsOnly: Boolean = true,
    var comments: CommentsClass = CommentsClass(),
    var copyright: CopyrightClass? = CopyrightClass(),
    var likes: LikeClass? = LikeClass(),
    var views: ViewClass? = ViewClass(),
    var reports: ReportClass = ReportClass(),
    var geo: GeoClass = GeoClass()
)

class LikeClass {
    private var likesIds = emptyList<Int>()

    fun add(id: Int) {
        if (isLikedById(id)) likesIds else likesIds += id
    }

    fun remove(id: Int): Boolean {
        val isThere = likesIds.contains(id)
        likesIds = likesIds.filter { it != id }
        return isThere
    }

    fun count(): Int {
        return likesIds.size
    }

    fun isLikedById(checkId: Int): Boolean {
        return checkId in likesIds
    }

    override fun toString() = this.likesIds.toString()
}

object OneCommentObj {
    private var id = 0
    private var message: String? = null
    var answers = emptyArray<OneCommentObj>()

    fun edit(newMessage: String) {
        message = newMessage
    }

    fun showAnswers(): Array<OneCommentObj> {
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

    fun answer(
        comment: OneCommentObj,
        commentTo: OneCommentObj
    ) {
        if (isCommentable) {
            commentTo.answers += comment
        }
    }

    fun count(): Int {
        if (isCommentable) {
            var result = 0
            for (comment in comments) {
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

    fun count(): Int {
        return reportsIds.size
    }

    fun isLikedById(checkId: Int): Boolean {
        return checkId in reportsIds
    }
}

class GeoClass {
    private var geo2d = IntArray(2) { 0 }
    private var geoStr = geo2d.toString()

    fun renameGeoStr(msg: String) {
        geoStr = msg
    }

    fun setGeo2d(
        latitude: Int,
        longitude: Int
    ) {
        geo2d = intArrayOf(latitude, longitude)
    }

    fun showGeo2d(): IntArray {
        return geo2d
    }

    fun showGeoStr(): String {
        return geoStr
    }
}

class CopyrightClass {
    private var id: Long = 0
        set(idNew) {
            field = if(idNew > 0) idNew else field
        }
    private var link: String? = "default String"
        set(linkNew: String?) {
            field = linkNew ?: "undefined link"
        }

}

class ViewClass {
    private var viewsIds = emptyList<Int>()

    fun add(id: Int) {
        if (isLikedById(id)) viewsIds else viewsIds += id
    }

    fun count(): Int {
        return viewsIds.size
    }

    private fun isLikedById(checkId: Int): Boolean {
        return checkId in viewsIds
    }
}

