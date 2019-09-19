package com.android.sys.appdefault.activity;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.sys.appdefault.R;
import com.android.sys.appdefault.utils.StringUtils;
import com.android.sys.appdefault.utils.XSPUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_detail)
public class DetailActivity extends BaseActivity {


    @ViewInject(R.id.et_packagename)
    TextView tvPackagename;

    @ViewInject(R.id.btnOk)
    TextView btnOk;

    @Override
    protected void initView() {
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String packagename = tvPackagename.getText().toString();
                if (StringUtils.isBlank(packagename)) {
                    return;
                }
                XSPUtils.getInstance().set("packagename", packagename);
                Toast.makeText(mContext, "设置成功，设备需要重启！", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void initData() {
        String packagename = XSPUtils.getInstance().get("packagename");
        tvPackagename.setText(packagename);
    }

}
