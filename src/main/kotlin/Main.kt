package ru.netology

import ru.netology.classes.Post
import ru.netology.classes.WallService

fun main(args: Array<String>) {

    val service = WallService()
    service.add(Post())
    service.add(Post())
    service.printAll()

    val service2 = WallService()

    service2.add(Post())
    service2.add(Post())
    service2.add(Post())
    service2.printAll()

    val testPost = Post(id = 2, message = "updated msg of id#2")
    service2.update(testPost)
    service2.printAll()

}