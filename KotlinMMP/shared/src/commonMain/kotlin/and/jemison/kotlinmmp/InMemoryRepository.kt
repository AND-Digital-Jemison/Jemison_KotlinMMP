package and.jemison.kotlinmmp

class InMemoryRepository : ITaskRepository {
    class Task(var taskName: String) {
        var done = false
        fun markDone() {
            done = true
        }
    }

    private var tasks = mutableListOf<Task>()
    override fun addTask(s: String) {
        tasks.add(Task(s))
    }

    override fun getAllTasks(): List<String> {
        return tasks.filter { t -> !t.done }.map { t -> t.taskName }
    }

    override fun removeTask(s: String) {
        tasks.removeAll { t->t.taskName==s }
    }

    override fun markTaskAsDone(s: String) {
        val dave: Task = tasks.find { t -> t.taskName == s } ?: throw IllegalArgumentException()
        dave.markDone()
    }

    override fun getDoneTasks(): List<String> {
        return tasks.filter { t -> t.done }.map { t -> t.taskName }
    }
}
