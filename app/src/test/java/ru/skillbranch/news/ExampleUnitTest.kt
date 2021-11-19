package ru.skillbranch.news

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.news.model.model

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun parsing_title(){
     val   model = model()
        print(model.getHtmlFromWeb().get(0).title!!)
    }
}