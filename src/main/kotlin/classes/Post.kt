package ru.netology.classes

data class Post(
    var id: Long = 0,
    var idCounterNext: Long = 1,
    val fromId: Long = 0,
    val ownerId: Long = 0,
    val date: Int = 1,
    val message: String = "default message",
    var isFriendsOnly: Boolean = true,
    //var likes: LikeObj,
    //var comments: CommentsObj,
    //var reports: ReportObj,
    //var geo: GeoObj
)

object LikeObj {
    private var likesIds = emptyArray<Int>()

    fun add(id: Int) {
        likesIds += id
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

object CommentsObj {
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

object ReportObj {
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

object GeoObj {
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
