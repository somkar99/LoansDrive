package weapplify.tech.loandrivedemo.Services


import android.util.Log

object Debugger {
    private val debug = true

    fun debug(TAG: String, ls_msg: String) {
        if (debug) {
            Log.v(TAG, ls_msg)
        }
    }
}
