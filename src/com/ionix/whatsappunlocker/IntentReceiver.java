package com.ionix.whatsappunlocker;

import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;


public class IntentReceiver extends BroadcastReceiver {

	static final String TAG = "WhatsAppUnlocker";
	
	private static KeyguardLock m_klock = null;
	
	@Override
	public void onReceive(Context ctx, Intent intent) {
		String comp = intent.getStringExtra("comp");
		if (comp.equals("{com.whatsapp/com.whatsapp.Conversation}")) {
			// unlock lockscreen
			KeyguardManager km = (KeyguardManager) ctx.getSystemService(Context.KEYGUARD_SERVICE);
			if (km.inKeyguardRestrictedInputMode()) {
				Log.d(TAG, "Unlocking screen for WhatsApp");
				m_klock = km.newKeyguardLock(TAG);
				m_klock.disableKeyguard();
			}
		}
	}

}
