package science.atlarge.wta.simulator.state

import science.atlarge.wta.simulator.model.Machine
import science.atlarge.wta.simulator.model.Task

class MachineState internal constructor(
        val machine: Machine,
        freeCpus: Int//, freeMemoryBytes: Long
) {

    var freeCpus = freeCpus
        private set
//    var freeMemoryBytes = freeMemoryBytes
//        private set

    private val _runningTasks = mutableSetOf<Task>()
    val runningTasks: Set<Task>
        get() = _runningTasks

    //constructor(machine: Machine) : this(machine, machine.numberOfCpus, machine.memoryBytes)
    constructor(machine: Machine) : this(machine, machine.numberOfCpus)

    fun submitTask(task: Task) {
        require(task.cpuDemand <= freeCpus) {
            "Not enough CPUs available on ${machine.idString()} to start ${task.idString()} " +
                    "($freeCpus < ${task.cpuDemand})"
        }
//        require(task.memoryDemandBytes <= freeMemoryBytes) {
//            "Not enough Memory available on ${machine.idString()} to start ${task.idString()} " +
//                    "($freeMemoryBytes < ${task.memoryDemandBytes})"
//        }

        freeCpus -= task.cpuDemand
//        freeMemoryBytes -= task.memoryDemandBytes
        _runningTasks.add(task)
    }

    fun completeTask(task: Task) {
        require(_runningTasks.remove(task)) {
            "${task.idString()} was not running on ${machine.idString()}"
        }
        freeCpus += task.cpuDemand
//        freeMemoryBytes += task.memoryDemandBytes
    }

}