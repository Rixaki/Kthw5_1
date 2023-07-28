package ru.netology.classes

abstract class Attachment {
    abstract var type: String
}

class PhotoAttachment : Attachment() {
    override var type: String = "photo"
    var photo: Photo = Photo()

    class Photo {
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
}

class VideoAttachment : Attachment() {
    override var type: String = "video"
    var video: Video = Video()

    class Video {
        var id: Long = 0
        var ownerId: Long = 0
        var title: String = "none title"
        var startImage: Frame = Frame()
        var firstFrame: Frame = Frame()
        var duration: Long = 0
        var views: Long = 1
        var data: Long = 1
    }

    class Frame {
        var height: Long = 0
        var width: Long = 0
        var url: String = "none url"
    }
}

class AudioAttachment : Attachment() {
    override var type: String = "audio"
    var audio: Audio = Audio()

    class Audio {
        var id: Long = 0
        var ownerId: Long = 0
        var artist: String = "none artist"
        var title: String = "none title"
        var duration: Long = 0
        var url: String = "none url"
        var date: Long = 1
    }
}

class PhotoListAttachment : Attachment() {
    override var type: String = "photos_list"
    var photoList: PhotoList = PhotoList()

    class PhotoList {
        var photoes = emptyArray<PhotoAttachment>()
    }
}

class LinkAttachment : Attachment() {
    override var type: String = "link"
    var link: Link = Link()

    class Link {
        var url: String = "none url"
        var caption: String = "none caption"
        var description: String = "none description"
    }
}

class StickerAttachment : Attachment() {
    override var type: String = "sticker"
    var sticker: Sticker = Sticker()

    class Sticker {
        var stickerId: Long = 0
        var isAllowed: Boolean = true
        var animationUrl: String = "none url"

        var images = emptyArray<PhotoAttachment.SinglePhotoClass>()
    }
}

class EventAttachment : Attachment() {
    override var type: String = "event"
    var event: Event = Event()

    class Event {
        var id: Long = 0
        var time: Long = 0
        var isFavorite: Boolean = false
        var address: String = "none address"
        var text: String = "none text"
        var buttonText: String = "none button text"

        var allMembers = HashMap<Long, Long>()//id,status
        var friends = emptyArray<Long>()

        fun add(id: Long, status: Long) {
            if (!allMembers.containsKey(id) && (status in 1..2)) {
                allMembers[id] = status
            }
        }
    }
}

