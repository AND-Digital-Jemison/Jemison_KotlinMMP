package and.jemison.kotlinmmp

import kotlin.test.Test
import kotlin.test.assertEquals

class TaskListTest {


    @Test
    fun getAllTasksMatchesTasksAdded() {
        val taskList = TaskList(InMemoryRepository())
        taskList.addTask("strings")
        taskList.addTask("dave")
        val expected = taskList.getAllTasks()
        assertEquals(listOf("strings", "dave"), expected)
    }

    @Test
    fun emptyTasksReturnsEmpty() {
        val taskList = TaskList(InMemoryRepository())
        val expected = taskList.getAllTasks().size
        assertEquals(0, expected)
    }

    @Test
    fun whenReopenAnApp_TasksAreAvailable() {
        val taskRepository = InMemoryRepository()
        val taskList = TaskList(taskRepository)
        taskList.addTask("strings")
        taskList.addTask("dave")
        val taskList2 = TaskList(taskRepository)
        val expected = taskList2.getAllTasks()
        assertEquals(listOf("strings", "dave"), expected)
    }

    @Test
    fun removeTask() {
        val taskList = TaskList(InMemoryRepository())
        taskList.addTask("strings")
        taskList.addTask("dave")
        taskList.removeTask("dave")
        val expected = taskList.getAllTasks()
        assertEquals(listOf("strings"), expected)
    }

    @Test
    fun markTaskAsDone() {
        val taskList = TaskList(InMemoryRepository())
        taskList.addTask("strings")
        taskList.addTask("dave")
        taskList.markTaskAsDone("dave")
        val expected = taskList.getAllTasks()
        assertEquals(listOf("strings"), expected)
    }

    @Test
    fun viewDoneTasks() {
        val taskList = TaskList(InMemoryRepository())
        taskList.addTask("strings")
        taskList.addTask("dave")
        taskList.markTaskAsDone("dave")
        val expected = taskList.getDoneTasks()
        assertEquals(listOf("dave"), expected)
    }

}

