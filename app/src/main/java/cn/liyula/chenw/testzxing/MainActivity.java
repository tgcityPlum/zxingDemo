package cn.liyula.chenw.testzxing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;

public class MainActivity extends AppCompatActivity implements QRCodeView.Delegate {

    ZXingView mZxScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mZxScan = findViewById(R.id.zx_scan);

        mZxScan.setDelegate(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mZxScan != null){
            mZxScan.showScanRect();
            mZxScan.startCamera();
//            mZxScan.startSpot();
            mZxScan.startSpotDelay(300);
        }
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        // 扫描到结果后直接跳转到个人中心  成功的结果应该是uid=xxx 所以直接取等号后面的内容
        // 至于为什么是uid=xxx ios定的 我也不知道
        //好友
        Log.e("message",result+"--");
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        mZxScan.startSpotDelay(300);
//        mZxScan.startSpot();

    }

    @Override
    public void onScanQRCodeOpenCameraError() {

    }
}
