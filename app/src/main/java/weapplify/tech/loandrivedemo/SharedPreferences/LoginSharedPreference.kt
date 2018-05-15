package weapplify.tech.loandrivedemo.SharedPreferences

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by omkar on 30-03-2017.
 */

class LoginSharedPreference(internal var context: Context) {
    internal var sharedPreferences: SharedPreferences
    internal var editor: SharedPreferences.Editor
    val clogin: Boolean
        get() = if (sharedPreferences.contains(LOGGEDIN_SHARED_PREF)) {
            sharedPreferences.getBoolean(LOGGEDIN_SHARED_PREF, false)

        } else false

    init {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }

    fun setClogin() {
        editor.putBoolean(LOGGEDIN_SHARED_PREF, true)
        editor.apply()
    }

    fun clearClogin() {
        editor.clear()
        editor.apply()
    }

    companion object {
        val SHARED_PREF_NAME = "custlogin"
        val LOGGEDIN_SHARED_PREF = "cloggedin"
    }
}
