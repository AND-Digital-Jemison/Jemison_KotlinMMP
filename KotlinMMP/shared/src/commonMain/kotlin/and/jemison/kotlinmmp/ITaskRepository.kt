package and.jemison.kotlinmmp

interface ITaskRepository {
    fun addTask(s: String)
    fun getAllTasks(): List<String>
    fun removeTask(s: String)
    fun markTaskAsDone(s: String)
    fun getDoneTasks(): List<String>
}