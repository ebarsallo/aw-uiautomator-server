package com.github.uiautomator.stub;

import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.test.FlakyTest;
import android.test.suitebuilder.annotation.LargeTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.jsonrpc4j.JsonRpcServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

/**
 * Created by zhanhail on 8/1/16.
 */

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class Stub {
    int PORT = 9008;
    AutomatorHttpServer server =  new AutomatorHttpServer(PORT);

    @Before
    public void setUp() throws IOException, RemoteException {
        Log.i("hailong : Start...");
        JsonRpcServer jrpcserver = new JsonRpcServer(new ObjectMapper(), new AutomatorServiceImpl(), AutomatorService.class);
        server.route("/jsonrpc/0", jrpcserver);
        server.start();
        UiDevice.getInstance(InstrumentationRegistry.getInstrumentation()).wakeUp();
    }

    @After
    public void tearDown() {
        Log.i("hailong : End...");
        server.stop();
    }

    @Test
    @LargeTest
    @FlakyTest(tolerance = 3)
    public void testUIAutomatorStub()  throws InterruptedException  {
        Log.i("hailong : Run...");
        while (server.isAlive())
            Thread.sleep(100);
    }
}
