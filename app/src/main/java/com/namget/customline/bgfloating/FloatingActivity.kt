package com.namget.customline.bgfloating

import android.annotation.TargetApi
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.provider.Settings
import android.util.Log
import androidx.appcompat.app.AppCompatActivity




class FloatingActivity  :  AppCompatActivity(){


    private val ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE = 1
    var floatingService: FloatingService? = null

    private val floatingServiceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
            floatingService = null
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.e("myLog","onServiceConntected")
            val binder = service as FloatingService.LocalBinder
            floatingService = binder.getService()
            //init
            floatingService?.init()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkPermission()
    }

    fun checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {   // 마시멜로우 이상일 경우
            if (!Settings.canDrawOverlays(this)) {              // 체크
                val intent = Intent(
                    Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:$packageName")
                )
                startActivityForResult(intent, ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE);
            } else {
                Log.e("myLog","bindService")
                bindService(Intent(this, FloatingService::class.java), floatingServiceConnection, Context.BIND_AUTO_CREATE)
            }
        } else {
            bindService(Intent(this, FloatingService::class.java), floatingServiceConnection, Context.BIND_AUTO_CREATE)
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE) {
            if (!Settings.canDrawOverlays(this)) {
                // TODO 동의를 얻지 못했을 경우의 처리
            } else {
                bindService(Intent(this, FloatingService::class.java), floatingServiceConnection, Context.BIND_AUTO_CREATE)
            }
        }
    }


}