package com.angle.hshb.mykotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.angle.hshb.mykotlin.http.Request
import kotlinx.android.synthetic.main.activity_second.*
import one.hundred.experimental.*
import org.jetbrains.anko.async
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        requestService("http://app.hshb.cn/hz/RentApi/RentContractList.ashx?memberid=533877")
    }

    /**
     * 左上点击
     * == 协程按代码顺序执行
     */
    fun first(view: View) {
        clearText()
        tvText.append("1:顺序协程执行开始\n")
        taskBlockOnMainThread {
            taskOrder {
                val threadName = Thread.currentThread().name
                tvText.append("2:顺序协程1====在线程“$threadName”中执行\n")
            }
            taskOrder {
                val threadName = Thread.currentThread().name
                tvText.append("3:顺序协程1====在线程“$threadName”中执行\n")
            }
        }
        tvText.append("4:顺序线程执行会阻塞当前代码执行\n")
        toast("Hello Anko")
    }

    /**
     * 右上点击
     * == 两个协程并发执行
     */
    fun second(view: View) {
        clearText()
        tvText.append("1:并发协程执行开始\n")
        taskAsync(1000) {
            val threadName = Thread.currentThread().name
//            taskRunOnUiThread {
//                tvText.append("3:并发协程1=====在线程“$threadName”中执行\n")
//            }
            runOnUiThread {
                tvText.append("3:并发协程1=====在线程“$threadName”中执行\n")
            }
        }
        taskAsync(3000) {
            val threadName = Thread.currentThread().name
//            taskRunOnUiThread {
//                tvText.append("4:并发协程1=====在线程“$threadName”中执行\n")
//            }
            runOnUiThread {
                tvText.append("3:并发协程1=====在线程“$threadName”中执行\n")
            }
        }
        tvText.append("2：并发协程执行未阻塞执行\n")
    }


    /**
     * 左下点击
     * == 另个异步协程，第二个需要等待第一个完成后执行
     */
    fun three(view: View) {
        clearText()
        tvText.append("1：并发协程执行后等待结果开始\n")

        val job1 = taskAsync {
            val threadName = Thread.currentThread().name
            taskRunOnUiThread {
                tvText.append("3：并发协程1=====在线程“$threadName”中执行\n")
            }
        }
        taskAsync {
            Thread.sleep(3000)
            taskRunOnUiThread {
                tvText.append("4：等待执行结果“${job1.await()}”")
            }
        }

        tvText.append("2：并发执行后未阻塞\n")
    }

    /**
     * 右下点击
     * == 执行心跳
     */
    fun four(view: View) {
        clearText()
        tvText.append("心跳开始\n")
        taskLaunch {
            var count = 0
            taskHeartbeat(10, 100) {
                taskRunOnUiThread {
                    tvText.append("心跳${count++}\n")
                }
            }
        }
    }

    /**
     *  清除Text
     */
    fun clearText() {
        tvText?.text = ""
    }

    /**
     * 网络请求
     */
    fun requestService(url:String){
        async {
            val forecaseResult = Request(url).run()
            /**
             * 返回到UI线程
             */
            uiThread {
                longToast("数据请求成功！==${Thread.currentThread().name}")
            }
        }
    }


}
