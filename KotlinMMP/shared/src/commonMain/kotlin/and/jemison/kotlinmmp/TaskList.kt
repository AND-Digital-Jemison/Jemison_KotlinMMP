package and.jemison.kotlinmmp

class TaskList(var taskRepository: ITaskRepository) {


    fun addTask(s: String) {
        taskRepository.addTask(s)
    }

    fun getAllTasks(): List<String> {
        return taskRepository.getAllTasks()
    }

    fun removeTask(s: String) {
        return taskRepository.removeTask(s)
    }

    fun markTaskAsDone(s: String) {
        return taskRepository.markTaskAsDone(s)
    }

    fun getDoneTasks(): List<String> {
        return taskRepository.getDoneTasks()
    }

}