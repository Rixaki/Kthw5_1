package ru.netology

import ru.netology.classes.Post
import ru.netology.classes.WallService
import ru.netology.classes.Attachment
import ru.netology.classes.Photo

fun main(args: Array<String>) {

    val service = WallService()
    service.add(Post())
    service.add(Post())
    service.printAll()

    val service2 = WallService()

    service2.add(Post())
    service2.add(Post())
    service2.getLast().likes?.add(55)
    service2.getLast().likes?.add(83)
    service2.getLast().likes?.add(83)
    service2.getLast().likes?.remove(55)
    service2.getLast().likes?.remove(14)
    service2.add(Post())
    service2.printAll()

    val testPost = Post(id = 2, message = "updated msg of id#2")
    service2.update(testPost)
    service2.printAll()

    println()
    val photo = Photo()
    photo.message = "photo description"
    println(photo)
}