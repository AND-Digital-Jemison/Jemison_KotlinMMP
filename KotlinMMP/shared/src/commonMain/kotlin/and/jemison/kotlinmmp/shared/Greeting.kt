package and.jemison.kotlinmmp.shared

import and.jemison.kotlinmmp.shared.Platform

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}