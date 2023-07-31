package ru.netology.classes

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import ru.netology.classes.WallService.*
import ru.netology.classes.WallService.PostNotFoundException

class MainKtTest {

    @Before
    fun clearBeforeTest() {
        WallService().clear()
    }

    @Test
    fun addIdTest() {
        val service = WallService()
        service.add(Post())
        service.add(Post())
        assertTrue(service.getLast().id != 0.toLong())
    }

    @Test
    fun updateWithExist() {
        val service = WallService()

        service.add(Post())
        service.add(Post())
        service.add(Post())

        val testPost = Post(id = 2, message = "updated msg of id#2")

        assertTrue(service.update(testPost))
    }

    @Test
    fun updateWithNoExist() {
        val service = WallService()

        service.add(Post())
        service.add(Post())
        service.add(Post())

        val testPost = Post(id = 10, message = "updated msg of id#10")

        assertFalse(service.update(testPost))
    }

    @Test
    fun validAddingPost(){
        val service = WallService()

        service.add(Post())//1
        service.add(Post())//2
        service.add(Post())//3
        service.add(Post())//4
        service.add(Post())//5
        service.add(Post())//6

        val testComment: Comment = Comment(text = "test comment")
        assertFalse(service.createComment(6, testComment) == null)
    }

    @Test(expected = PostNotFoundException::class)
    fun exceptionalAddingPost(){
        val service = WallService()

        service.add(Post())//1
        service.add(Post())//2
        service.add(Post())//3
        service.add(Post())//4
        service.add(Post())//5
        service.add(Post())//6

        val testComment: Comment = Comment(text = "test comment")
        service.createComment(10, testComment)
    }

    @Test
    fun validReport(){
        val service = WallService()
        val wallreport = WallReport()

        service.add(Post())//1
        service.add(Post())//2
        service.add(Post())//3
        service.add(Post())//4
        service.add(Post())//5

        val testComment: Comment = Comment(text = "test comment")
        service.createComment(3, testComment)
        service.createComment(3, Comment(text = "second comment with violence"))

        val report: Report = Report(reason = 6, commentId = 2, ownerId = 0)
        assertTrue(wallreport.add(report, service))
    }

    @Test(expected = RuntimeException::class)
    fun exceptionalReportDueReasonCode(){
        val service = WallService()
        val wallreport = WallReport()

        service.add(Post())//1
        service.add(Post())//2
        service.add(Post())//3
        service.add(Post())//4
        service.add(Post())//5

        val testComment: Comment = Comment(text = "test comment")
        service.createComment(3, testComment)
        service.createComment(3, Comment(text = "second comment"))

        val report: Report = Report(reason = -1, commentId = 2, ownerId = 0)
        wallreport.add(report, service)
    }

    @Test(expected = RuntimeException::class)
    fun exceptionalReportDueCommentId(){
        val service = WallService()
        val wallreport = WallReport()

        service.add(Post())//1
        service.add(Post())//2
        service.add(Post())//3
        service.add(Post())//4
        service.add(Post())//5

        val testComment: Comment = Comment(text = "test comment")
        service.createComment(3, testComment)
        service.createComment(3, Comment(text = "second comment with violence"))

        val report: Report = Report(reason = 6, commentId = 20, ownerId = 0)
        wallreport.add(report, service)
    }
}