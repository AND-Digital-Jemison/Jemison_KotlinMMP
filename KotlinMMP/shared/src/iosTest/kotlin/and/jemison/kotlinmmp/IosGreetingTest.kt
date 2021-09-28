package and.jemison.kotlinmmp

import kotlin.test.Test
import kotlin.test.assertTrue

class IosGreetingTest {

    @Test
    fun greetingContainsIos() {
        assertTrue(Greeting().greeting().contains("iOS"), "Check iOS is mentioned")
    }
}