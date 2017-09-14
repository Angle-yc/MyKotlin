package com.angle.hshb.mykotlin.http

import android.util.Log
import com.angle.hshb.mykotlin.common.ForecaseResult
import com.google.gson.Gson
import java.net.URL

/**
 * 网络请求
 */
public class Request(var url: String) {
    public fun run():ForecaseResult {
        val forecaseJsonStr = URL(url).readText()
        Log.e(javaClass.simpleName, forecaseJsonStr)
        return Gson().fromJson(forecaseJsonStr, ForecaseResult::class.java)
    }

}