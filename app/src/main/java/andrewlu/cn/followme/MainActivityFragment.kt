package andrewlu.cn.followme

import android.content.DialogInterface
import android.support.v4.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*
import org.xutils.common.Callback
import org.xutils.common.Callback.CommonCallback
import org.xutils.http.RequestParams
import org.xutils.x

/**
 * A placeholder fragment containing a simple view.
 */
class MainActivityFragment : Fragment(), View.OnClickListener {
    companion object {
        val TAG = "MainActivityFragment"
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rankList.setOnClickListener(this)
        dynamicsList.setOnClickListener(this)
        openedOrdersList.setOnClickListener(this)
        closedOrdersList.setOnClickListener(this);

        ordersList.setOnClickListener(this)
        postList.setOnClickListener(this)
        financialCalendarDataList.setOnClickListener(this)
        symbolTodayOpenPriceList.setOnClickListener(this);
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.rankList -> {
                getRankList()
            }
            R.id.dynamicsList -> {
                getDynamicsList()
            }
            R.id.openedOrdersList -> {
                getOpenedOrderList()
            }
            R.id.closedOrdersList -> {
                getClosedOrderList()
            }
            R.id.ordersList -> {
                getOrderList()
            }
            R.id.postList -> {
                getPostList()
            }
            R.id.financialCalendarDataList -> {
                getFunancialList()
            }
            R.id.symbolTodayOpenPriceList -> {
                getSymbolPriceList()
            }
        }
    }

    fun getRankList() {
        println("getRankList")
        var params = RequestParams("http://www.followme.com/Report/Trader/GetRankJson")
        params.addBodyParameter("OrderBy", "")
        params.addBodyParameter("timeRange", "0")
        params.addBodyParameter("PageSize", "15")
        params.addBodyParameter("PageIndex", "0")
        params.addBodyParameter("IsPublish", "1")
        params.addBodyParameter("ScreeningTime", "1")
        params.addBodyParameter("ScreeningBroker", "0")
        params.addBodyParameter("PageOrderyFeild", "BizROI")
        params.addBodyParameter("PageOrderyType", "sort_down")
        x.http().post(params, object : GeneralCallback() {
            override fun onSuccess(result: String?) {
                Log.e(TAG, "data:$result")
            }
        })
    }

    fun getDynamicsList() {
        println("getDynamicsList")
        var params = RequestParams("http://www.followme.com/Report/Dynamic/GetDynamics")
        params.addBodyParameter("OrderBy", "")
        params.addBodyParameter("PageSize", "15")
        params.addBodyParameter("PageIndex", "1")
        params.addBodyParameter("NickName", "")
        params.addBodyParameter("profit", "0")
        params.addBodyParameter("BrokerId", "")
        x.http().post(params, object : GeneralCallback() {
            override fun onSuccess(result: String?) {
                Log.e(TAG, "data:$result")
            }
        })
    }

    fun getOpenedOrderList() {
        println("getOpenedOrderList")
        var params = RequestParams("http://www.followme.com/Report/Customer/GetOpenedOrders")
        params.addBodyParameter("OrderBy", "")
        params.addBodyParameter("PageSize", "15")
        params.addBodyParameter("PageIndex", "1")
        params.addBodyParameter("followAccountIndex", "74732_2")
        params.addBodyParameter("id", "74732")
        params.addBodyParameter("symbolType", "")
        params.addBodyParameter("openTime", "")
        params.addBodyParameter("Cmd", "")
        x.http().post(params, object : GeneralCallback() {
            override fun onSuccess(result: String?) {
                Log.e(TAG, "data:$result")
            }
        })
    }

    fun getClosedOrderList() {
        println("getClosedOrderList")
        var params = RequestParams("http://www.followme.com/Report/Customer/GetClosedOrders")
        params.addBodyParameter("OrderBy", "")
        params.addBodyParameter("PageSize", "15")
        params.addBodyParameter("PageIndex", "1")
        params.addBodyParameter("followAccountIndex", "74732_2")
        params.addBodyParameter("id", "74732")
        params.addBodyParameter("symbolType", "")
        params.addBodyParameter("openTime", "")
        params.addBodyParameter("Cmd", "")
        x.http().post(params, object : GeneralCallback() {
            override fun onSuccess(result: String?) {
                Log.e(TAG, "data:$result")
            }
        })
    }

    fun getOrderList() {
        println("getOrderList")
        var params = RequestParams("http://www.followme.com/Report/Trader/GetOrders")
        params.addBodyParameter("OrderBy", "")
        params.addBodyParameter("PageSize", "15")
        params.addBodyParameter("PageIndex", "1")
        params.addBodyParameter("followAccountIndex", "74732_2")
        params.addBodyParameter("id", "74732")
        params.addBodyParameter("symbolType", "")
        params.addBodyParameter("openTime", "")
        params.addBodyParameter("Cmd", "")
        params.addBodyParameter("closeTime","")
        x.http().post(params, object : GeneralCallback() {
            override fun onSuccess(result: String?) {
                Log.e(TAG, "data:$result")
            }
        })
    }

    fun getPostList() {
        println("getPostList")
        var params = RequestParams("http://www.followme.com/Post/GetPostJsonList")
        params.addBodyParameter("pageIndex", "1")
        params.addBodyParameter("pageSize", "6")
        params.addBodyParameter("categoryId", "49")
        x.http().post(params, object : GeneralCallback() {
            override fun onSuccess(result: String?) {
                Log.e(TAG, "data:$result")
            }
        })
    }

    fun getFunancialList() {
        println("getFunancialList")
        var params = RequestParams("http://www.followme.com/News/GetLastFinancialCalendarData")
        params.addBodyParameter("beginDate", "2016-11-20")
        params.addBodyParameter("categories", "[]")
        params.addBodyParameter("countries", "[]")
        params.addBodyParameter("countryCode", "")
        params.addBodyParameter("importances", "[]")
        params.addBodyParameter("keyWord", "")
        params.isAsJsonContent = true;

        x.http().post(params, object : GeneralCallback() {
            override fun onSuccess(result: String?) {
                Log.e(TAG, "data:$result")
            }
        })
    }

    fun getSymbolPriceList() {
        println("getSymbolPriceList")
        var params = RequestParams("http://www.followme.com/Report/Symbol/GetSymbolTodayOpenPrice")
        params.addBodyParameter("brokerid", "3")
        params.addBodyParameter("symbols", ";GOLD;SILVER")
        x.http().post(params, object : GeneralCallback() {
            override fun onSuccess(result: String?) {
                Log.e(TAG, "data:$result")
            }
        })
    }

}

abstract class GeneralCallback() : CommonCallback<String> {
    override fun onSuccess(result: String?) {
    }

    override fun onError(ex: Throwable?, isOnCallback: Boolean) {
        ex!!.printStackTrace();
    }

    override fun onCancelled(cex: Callback.CancelledException?) {
    }

    override fun onFinished() {
    }

}

