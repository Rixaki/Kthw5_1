package ru.netology.classes

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

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
}