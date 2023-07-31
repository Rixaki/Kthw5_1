package ru.netology

import ru.netology.classes.PhotoAttachment
import ru.netology.classes.Post
import ru.netology.classes.WallService

fun main(args: Array<String>) {

    val service = WallService()
    service.add(Post())
    service.add(Post())
    service.printAllPosts()

    val testComment: WallService.Comment = WallService.Comment(text = "test comment")
    service.createComment(2, testComment)
    service.createComment(2, WallService.Comment(text = "second comment"))

    service.printAllComments()

    val service2 = WallService()

    service2.add(Post())
    service2.add(Post())
    service2.getLast().likes?.add(55)
    service2.getLast().likes?.add(83)
    service2.getLast().likes?.add(83)
    service2.getLast().likes?.remove(55)
    service2.getLast().likes?.remove(14)
    service2.add(Post())
    service2.printAllPosts()

    val testPost = Post(id = 2, message = "updated msg of id#2")
    service2.update(testPost)
    service2.printAllPosts()

    println()
    val photo = PhotoAttachment.Photo()
    photo.message = "photo description"
    println(photo)

    val service3 = WallService()

    service3.add(Post())//1
    service3.add(Post())//2
    service3.add(Post())//3
    service3.add(Post())//4
    service3.add(Post())//5
    service3.add(Post())//6
    service3.printAllPosts()

    //val testComment2: WallService.Comment = WallService.Comment(text = "test comment")
    //service3.createComment(10, testComment2)
    //service3.printAllComments()
}