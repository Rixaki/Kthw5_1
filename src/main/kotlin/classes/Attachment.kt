package ru.netology.classes

abstract class Attachment {
    abstract var type: String
}

class Photo: Attachment() {
    override var type: String = "photo"
    var id: Long = 0
    var albumId: Long = 0
    var ownerId: Long = 0
    var userId: Long = 0
    var message: String = "none message"
    var data: Long = 1
    var width: Long = 0
    var height: Long = 0

    var sizes = emptyArray<SinglePhotoClass>()
}

class SinglePhotoClass {
    var typeCopy: String = "none type"
    var url: String = "none url"
    var width: Long = 0
    var height: Long = 0
}

class PhotoList: Attachment() {
    override var type: String = "photos_list"

    var photoes = emptyArray<Photo>()
}

class Link: Attachment() {
    override var type: String = "link"
    var url: String = "none url"
    var caption: String = "none caption"
    var description: String = "none description"
}

class Sticker: Attachment() {
    override var type: String = "sticker"
    var stickerId: Long = 0
    var isAllowed: Boolean = true
    var animationUrl: String = "none url"

    var images = emptyArray<SinglePhotoClass>()
}

class Event: Attachment() {
    override var type: String = "event"
    var id: Long = 0
    var time: Long = 0
    var isFavorite: Boolean = false
    var address: String = "none address"
    var text: String = "none text"
    var buttonText: String = "none button text"

    var allMembers = HashMap<Long, Long>()//id,status
    var friends = emptyArray<Long>()

    fun add(id: Long, status: Long){
        if (!allMembers.containsKey(id) && (status in 1..2)){
            allMembers[id] = status
        }
    }
}

