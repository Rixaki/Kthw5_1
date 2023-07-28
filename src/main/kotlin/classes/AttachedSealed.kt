package ru.netology.classes

sealed class AttachmentSealed(val type: String)


class PhotoSealed : AttachmentSealed("photo") {
    var photo: PhotoSealed = PhotoSealed()

    class Photo {
        var id: Long = 0
        var albumId: Long = 0
        var ownerId: Long = 0
        var userId: Long = 0
        var message: String = "none message"
        var data: Long = 1
        var width: Long = 0
        var height: Long = 0

        var sizes = emptyArray<SinglePhotoClassSealed>()
    }

    class SinglePhotoClassSealed {
        var typeCopy: String = "none type"
        var url: String = "none url"
        var width: Long = 0
        var height: Long = 0
    }
}

class PhotoListSealed : AttachmentSealed("photos_list") {

    var photoList: PhotoListSealed = PhotoListSealed()

    class PhotoList {
        var photoes = emptyArray<PhotoSealed.Photo>()
    }
}

class LinkSealed : AttachmentSealed("link") {

    var link: LinkSealed = LinkSealed()

    class Link {
        var url: String = "none url"
        var caption: String = "none caption"
        var description: String = "none description"
    }
}

class StickerSealed : AttachmentSealed("sticker") {

    var sticker: StickerSealed = StickerSealed()

    class Sticker {
        var stickerId: Long = 0
        var isAllowed: Boolean = true
        var animationUrl: String = "none url"

        var images = emptyArray<PhotoSealed.SinglePhotoClassSealed>()
    }
}

class EventSealed : AttachmentSealed("event") {

    var event: EventSealed = EventSealed()

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

