package com.example.eventbus;

import de.greenrobot.event.EventBus;
import android.app.Activity;
import android.os.Bundle;

public class TestActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().post(new SetTextEvent("SetTextEvent from TestActivity"));
        super.onStop();
    }
}
