package com.example.eventbus;

import de.greenrobot.event.EventBus;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
    private TextView mTVLabel;
    private Button mBtnPostEvent;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mTVLabel = (TextView) findViewById(R.id.tv);
        mBtnPostEvent = (Button) findViewById(R.id.btn);
        mBtnPostEvent.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(SetTextEvent event) {
        if (event.getText() != null) {
            mTVLabel.setText(event.getText());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.btn:
            EventBus.getDefault().post(new SetTextEvent("SetTextEvent"));
            break;
        }
    }
}
