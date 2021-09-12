package cowby.rncho.cows.beatbox

import android.content.res.AssetManager
import android.util.Log
import java.lang.Exception


private const val TAG = "Beatbox"
private const val SOUNDS_FOLDER = "sample_sounds"

class Beatbox(private val assets: AssetManager) {
    val sounds: List<Sound>

    init {
        sounds = loadSounds()
    }

    private fun loadSounds(): List<Sound> {
        val soundNames: Array<String>

        return try {
            soundNames = assets.list(SOUNDS_FOLDER)!!
            val sounds = mutableListOf<Sound>()
            soundNames.forEach {
                val assetPath = "$SOUNDS_FOLDER/$it"
                val sound = Sound(assetPath)
                sounds.add(sound)
            }
            return sounds
        } catch (e: Exception) {
            Log.d(TAG, "Could not list assets", e)
            emptyList()
        }
    }
}