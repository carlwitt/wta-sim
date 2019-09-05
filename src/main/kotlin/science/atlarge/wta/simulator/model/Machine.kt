package science.atlarge.wta.simulator.model

typealias MachineId = Int

class Machine(
        val id: MachineId,
        val name: String,
        val cluster: Cluster,
        val numberOfCpus: Int,
        val memoryBytes: Long
) {

    init {
        cluster.addMachine(this)
    }

    override fun equals(other: Any?): Boolean {
        return this === other
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "Machine(id=$id, name='$name', cluster=${cluster.id}, cpus=$numberOfCpus ram=${memoryBytes / 1e9})"
    }

    fun idString(): String {
        return "Machine(id=$id, name='$name', cluster=${cluster.id})"
    }

}