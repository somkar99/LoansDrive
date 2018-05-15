package weapplify.tech.loandrivedemo.SharedPreferences

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by omkar on 30-03-2017.
 */

class LogindetailsSharedPreference(internal var context: Context) {
    internal var sharedPreferences: SharedPreferences
    internal var editor: SharedPreferences.Editor

    init {
        sharedPreferences = context.getSharedPreferences(PRE_NAME, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }

    fun Logindetails(key: String, `val`: String) {
        editor.putString(key, `val`)
        editor.apply()
    }

    fun clearLogin() {
        editor.clear()
        editor.apply()

    }

    companion object {
        val PRE_NAME = "logindetails"
    }


}
