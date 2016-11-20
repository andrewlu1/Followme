package andrewlu.cn.followme

import android.app.Application
import org.xutils.x

/**
 * Created by Andrewlu on 2016/11/21.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        x.Ext.init(this)
    }
}