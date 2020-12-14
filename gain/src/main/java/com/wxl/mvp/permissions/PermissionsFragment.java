package com.wxl.mvp.permissions;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class PermissionsFragment extends DialogFragment {

    private OnPermissionResultCallback onPermissionResultCallback;

    private PermissionReq.Builder builder;


    public void setBuilder(PermissionReq.Builder builder) {
        this.builder = builder;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(builder != null){
            requestPermissions(getContext(),builder.getPers(),builder.getReqCode(),builder.getOnPermissionResultCallback());
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        boolean allGranted = isAllGranted(permissions, grantResults);
        if(allGranted){
            onRequestPermissionsSuccess(requestCode);
        } else {
            onRequestPermissionsFailed(requestCode);
        }
    }

    /**
     * 请求权限
     * @param permissions
     * @param requestCode
     * @param callback
     */
    public void requestPermissions(Context context, String[] permissions, int requestCode, OnPermissionResultCallback callback){
        onPermissionResultCallback = callback;
        if(PermissionReq.checkPermissions(context,permissions)){
            onRequestPermissionsSuccess(requestCode);
        } else {
            requestPermissions(permissions,requestCode);
        }
    }

    /**
     * 请求权限成功回调
     * @param requestCode
     */
    private void onRequestPermissionsSuccess(int requestCode){
        if(onPermissionResultCallback != null){
            onPermissionResultCallback.onRequestPermissionSuccess(requestCode);
            dismissAllowingStateLoss();
        }
    }


    /**
     * 请求权限失败回调
     * @param requestCode
     */
    private void onRequestPermissionsFailed(int requestCode){
        if(onPermissionResultCallback != null){
            onPermissionResultCallback.onRequestPermissionFailed(requestCode);
            dismissAllowingStateLoss();
        }
    }



    /**
     * 判断申请的权限有没有被允许
     */
    private boolean isAllGranted(String[] permissions, int[] grantResults) {
        for (int i = 0; i < grantResults.length; i++) {
            if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(builder != null){
            builder.release();
        }
        onPermissionResultCallback = null;
    }
}
