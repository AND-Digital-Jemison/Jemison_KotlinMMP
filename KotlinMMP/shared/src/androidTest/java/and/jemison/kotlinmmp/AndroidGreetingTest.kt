package and.jemison.kotlinmmp

import org.junit.Assert.assertTrue
import org.junit.Test

class AndroidGreetingTest {

    @Test
    fun greetingContainsAndroid() {
        assertTrue("Check Android is mentioned", Greeting().greeting().contains("Android") )
    }
}