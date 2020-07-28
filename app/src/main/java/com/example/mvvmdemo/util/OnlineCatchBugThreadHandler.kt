package com.example.mvvmdemo.util
import android.content.Context
import java.io.PrintWriter
import java.io.StringWriter

class OnlineCatchBugThreadHandler private constructor(): Thread.UncaughtExceptionHandler {

    private lateinit var context: Context
    private lateinit var fileDir: String
    private lateinit var packageName: String
    private lateinit var activityName: String

    fun init(context: Context, fileDir: String, packageName: String, activityName: String) {

        this.context = context.applicationContext
        this.fileDir = fileDir
        this.packageName = packageName
        this.activityName = activityName

        Thread.setDefaultUncaughtExceptionHandler(this)
    }

    override fun uncaughtException(thread: Thread, throwable: Throwable) {

        val writer = StringWriter()
        val printWriter = PrintWriter(writer)
        throwable.printStackTrace(printWriter)
        var mThrowable = throwable.cause

        while (mThrowable != null) {

            mThrowable.printStackTrace(printWriter)
            mThrowable = mThrowable.cause
        }

        val errorMessage: String = writer.toString()

        //关闭流
        printWriter.close()
        writer.close()

        if (errorMessage != null) {
            val byteArray: ByteArray = errorMessage.toByteArray(charset("GBK"))
            //执行以下操作
            //1.把字节数组转String之后保存
        }

        //执行以下操作
        //1.退出所有Activity
        //2.重启Activity
        //3.销毁当前进程

    }

    //双重检索线程安全模式单例
    companion object {
        val instance by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            OnlineCatchBugThreadHandler()
        }
    }

}