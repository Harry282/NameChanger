package namechanger.config

import java.io.File
import java.io.IOException

class NameChangerConfig(configDir: File) {
    private val configFile = File(configDir, "namechanger.txt")
    var name: String? = null
        set(value) {
            field = value
            saveConfig()
        }

    init {
        readConfig()
    }

    private fun saveConfig() {
        try {
            configFile.bufferedWriter().use {
                it.write(name ?: "")
            }
        } catch (_: IOException) {
        }

    }

    private fun readConfig() {
        try {
            configFile.bufferedReader().use {
                name = it.readLine()
                if (name == "") name = null
            }
        } catch (_: IOException) {
        }
    }
}
