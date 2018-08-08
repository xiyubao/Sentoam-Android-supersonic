/*
 * Copyright (C) 2014 gujicheng
 * 鏈粡浣滆�呰鍙紝绂佹灏嗚绋嬪簭鐢ㄤ簬鍟嗕笟鐢ㄩ��
 * 
 * 璇ュ０娉㈤�氫俊绋嬪簭鍦ㄥ墠涓�涓紑婧愮増鏈紙SinVoice锛夌殑鍩虹涓婏紝鍋氫簡璁稿浼樺寲锛�
 * 浼樺寲濡備笅锛�
 * 1. 璇嗗埆鏁堢巼鏇撮珮锛屽嚑涔庤揪鍒�100%锛屽畬鍏ㄥ彲浠ヨ揪鍒板晢涓氱敤閫旀爣鍑嗭紝姣攃hirp锛屾敮浠樺疂锛岃寗瀛愬揩浼犵瓑杞欢鐨勮瘑鍒晥鐜囨洿楂樸��
 * 2. 鑳芥敮鎸佹洿澶氬鏉傚満鏅殑璇嗗埆锛屽湪鏈夊槇鏉傚ぇ澹扮殑鑳屾櫙闊充箰锛屽槇鏉傜殑浼氳瀹わ紝椋熷爞锛屽叕浜よ溅锛岄┈璺紝鏂藉伐鍦哄湴锛�
 *     灏忔苯杞︼紝KTV绛変竴浜涘鏉傜殑鐜涓嬶紝渚濈劧鑳戒繚鎸佸緢楂樼殑璇嗗埆鐜囥��
 * 3. 鑳芥敮鎸佹洿澶歵oken鐨勮瘑鍒紝閫氳繃缂栫爜鍙互浼犻�佹墍鏈夊瓧绗︺��
 * 4. 閫氳繃瀹氬埗鍙互瀹炵幇鐩稿悓瀛楃鐨勮繛缁紶閫�,姣斿鈥�234456鈥濄��
 * 5. 鏀寔鑷姩绾犻敊鍔熻兘锛屽湪鏈�3涓互鍐呭瓧绗﹁В鐮佸嚭閿欑殑鎯呭喌涓嬪彲浠ヨ嚜鍔ㄧ籂姝ｃ��
 * 6. 绋嬪簭杩愯鏁堢巼闈炲父楂橈紝鍙互鐢ㄤ簬鏅鸿兘鎵嬫満锛屽姛鑳芥墜鏈猴紝宓屽叆寮忚澶囷紝PC锛屽钩鏉跨瓑宓屽叆寮忕郴缁熶笂銆�
 * 7. 澹版尝鐨勯鐜囧０闊冲拰闊抽噺鍙畾鍒躲��
 * 
 * 姝emo绋嬪簭灞炰簬璇曠敤鎬ц川绋嬪簭锛屼粎鍏峰閮ㄥ垎鍔熻兘锛屽叾闄愬埗濡備笅锛�
 * 1. 浠呮敮鎸侀儴鍒嗗瓧绗﹁瘑鍒��
 * 2. 璇嗗埆鑻ュ共娆″悗锛岀▼搴忎細鑷姩鍋滄璇嗗埆銆傝嫢鎯崇户缁娇鐢紝璇峰仠姝㈣绋嬪簭锛岀劧鍚庨噸鏂板惎鍔ㄧ▼搴忋��
 * 3. 涓嶆敮鎸佽繛缁瓧绗︿紶閫掋��
 * 4. 涓嶆敮鎸佽嚜鍔ㄧ籂閿欏姛鑳姐��
 * 5. 绂佹鐢ㄤ簬鍟嗕笟鐢ㄩ�斻��
 * 
 * 鑻ユ偍瀵瑰畬鏁寸殑澹版尝閫氫俊绋嬪簭鎰熷叴瓒ｏ紝璇疯仈绯讳綔鑰呰幏鍙栧晢涓氭巿鏉冪増鏈紙浠呮敹鍙栬嫤閫肩殑鍔犵彮璐癸級銆�
 *************************************************************************
 **                   浣滆�呬俊鎭�                                                            **
 *************************************************************************
 ** Email: gujicheng197@126.com                                        **
 ** QQ   : 29600731                                                                 **
 ** Weibo: http://weibo.com/gujicheng197                          **
 *************************************************************************
 */
package com.example.sinvoicedemo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.libra.sinvoice.Common;
import com.libra.sinvoice.LogHelper;
import com.libra.sinvoice.SinVoicePlayer;
import com.libra.sinvoice.SinVoiceRecognition;

public class MainActivity extends Activity implements
        SinVoiceRecognition.Listener, SinVoicePlayer.Listener {
    private final static String TAG = "MainActivityxx";

    private final static int MSG_SET_RECG_TEXT = 1;
    private final static int MSG_RECG_START = 2;
    private final static int MSG_RECG_END = 3;
    private final static int MSG_PLAY_TEXT = 4;

//    private final static int[] TOKENS = null;
//    private final static String TOKENS_str = null;
//    private final static int TOKEN_LEN = 10;
    private final static int[] TOKENS = { 32, 32, 32, 32, 32, 32 };
    private final static String TOKENS_str = "Beeba20141";
    private final static int TOKEN_LEN = TOKENS.length;

    private final static String BAKCUP_LOG_PATH = "/sinvoice_backup";

    private Handler mHanlder;
    private SinVoicePlayer mSinVoicePlayer;
    private SinVoiceRecognition mRecognition;
    private boolean mIsReadFromFile;
    private String mSdcardPath;
    private PowerManager.WakeLock mWakeLock;
    private EditText mPlayTextView;
    private TextView mRecognisedTextView;
    // private TextView mRegState;
    private String mPlayText;
    private char mRecgs[] = new char[100];
    private int mRecgCount;

    static {
        System.loadLibrary("sinvoice");
        LogHelper.d(TAG, "sinvoice jnicall loadlibrary");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIsReadFromFile = false;

        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, TAG);

        mSdcardPath = Environment.getExternalStorageDirectory().getPath();

        mSinVoicePlayer = new SinVoicePlayer();
        mSinVoicePlayer.init(this);
        mSinVoicePlayer.setListener(this);

        mRecognition = new SinVoiceRecognition();
        mRecognition.init(this);
        mRecognition.setListener(this);

        mPlayTextView = (EditText) findViewById(R.id.playtext);
        mPlayTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
        mRecognisedTextView = (TextView) findViewById(R.id.regtext);
        mHanlder = new RegHandler(this);

        Button playStart = (Button) findViewById(R.id.start_play);
        playStart.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                try {
                    byte[] strs = mPlayTextView.getText().toString().getBytes("UTF8");
                    if ( null != strs ) {
                        int len = strs.length;
                        int []tokens = new int[len];
                        for ( int i = 0; i < len; ++i ) {
//                            tokens[i] = strs[i];
                            String xx = mPlayTextView.getText().toString();
                            tokens[i] = Common.DEFAULT_CODE_BOOK.indexOf(xx.charAt(i));
//                            tokens[i] = Common.DEFAULT_CODE_BOOK.indexOf(TOKENS_str.charAt(i));
                        }
                        mSinVoicePlayer.play(tokens, len, false, 2000);
                    } else {
                        mSinVoicePlayer.play(TOKENS, TOKEN_LEN, false, 2000);
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                
                /*final Handler mHandler = new Handler();
                Runnable r = new Runnable() {
               	 
                    @Override
                     public void run() {
                     
                    	OnReStart();
                    	
                     }
               };
                

               mHandler.postDelayed(r, 5000);//延时100毫秒
               */
            }
        });
        
        Button ReStart = (Button) findViewById(R.id.restart);
        ReStart.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				OnReStart();
			}
        	
        });

        Button playStop = (Button) findViewById(R.id.stop_play);
        playStop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                mSinVoicePlayer.stop();
            }
        });

        Button recognitionStart = (Button) findViewById(R.id.start_reg);
        recognitionStart.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                mRecognition.start(TOKEN_LEN, mIsReadFromFile);
            }
        });

        Button recognitionStop = (Button) findViewById(R.id.stop_reg);
        recognitionStop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                mRecognition.stop();
            }
        });

        CheckBox cbReadFromFile = (CheckBox) findViewById(R.id.fread_from_file);
        cbReadFromFile
                .setOnCheckedChangeListener(new OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton arg0,
                            boolean isChecked) {
                        mIsReadFromFile = isChecked;
                    }
                });

        Button btBackup = (Button) findViewById(R.id.back_debug_info);
        btBackup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                backup();
            }
        });

        Button btClearBackup = (Button) findViewById(R.id.clear_debug_info);
        btClearBackup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("information")
                        .setMessage("Sure to clear?")
                        .setPositiveButton("yes",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                            int whichButton) {
                                        clearBackup();
                                    }
                                })
                        .setNegativeButton("no",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                            int whichButton) {
                                    }
                                }).show();
            }
        });

        Button btNextEffect = (Button) findViewById(R.id.next_mix);
        btNextEffect.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                mSinVoicePlayer.stop();
                mSinVoicePlayer.uninit();
                mSinVoicePlayer.init(MainActivity.this);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

        mWakeLock.acquire();
    }

    @Override
    public void onPause() {
        super.onPause();

        mWakeLock.release();

        mSinVoicePlayer.stop();
        mRecognition.stop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mRecognition.uninit();
        mSinVoicePlayer.uninit();
    }

    private void clearBackup() {
        delete(new File(mSdcardPath + BAKCUP_LOG_PATH));

        Toast.makeText(this, "clear backup log info successful",
                Toast.LENGTH_SHORT).show();
    }

    private static void delete(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }

        if (file.isDirectory()) {
            File[] childFiles = file.listFiles();
            if (childFiles == null || childFiles.length == 0) {
                file.delete();
                return;
            }

            for (int i = 0; i < childFiles.length; i++) {
                delete(childFiles[i]);
            }
            file.delete();
        }
    }

    private void OnReStart(){
    	final Intent intent = getPackageManager().getLaunchIntentForPackage(getPackageName());  
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  
        startActivity(intent);  
        android.os.Process.killProcess(android.os.Process.myPid());
    }
    
    private void backup() {
        mRecognition.stop();

        String timestamp = getTimestamp();
        String destPath = mSdcardPath + BAKCUP_LOG_PATH + "/back_" + timestamp;
        try {
            copyDirectiory(destPath, mSdcardPath + "/sinvoice");
            copyDirectiory(destPath, mSdcardPath + "/sinvoice_log");

            FileOutputStream fout = new FileOutputStream(destPath + "/text.txt");

            String str = mPlayTextView.getText().toString();
            byte[] bytes = str.getBytes();
            fout.write(bytes);

            str = mRecognisedTextView.getText().toString();
            bytes = str.getBytes();
            fout.write(bytes);

            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "backup log info successful", Toast.LENGTH_SHORT)
                .show();
    }

    private static class RegHandler extends Handler {
        private StringBuilder mTextBuilder = new StringBuilder();
        private MainActivity mAct;

        public RegHandler(MainActivity act) {
            mAct = act;
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
            case MSG_SET_RECG_TEXT:
                char ch = (char) msg.arg1;
//                mTextBuilder.append(ch);
                mAct.mRecgs[mAct.mRecgCount++] = ch;
                break;

            case MSG_RECG_START:
//                mTextBuilder.delete(0, mTextBuilder.length());
                mAct.mRecgCount = 0;
                break;

            case MSG_RECG_END:
                LogHelper.d(TAG, "recognition end gIsError:" + msg.arg1);
                if ( mAct.mRecgCount > 0 ) {
                    byte[] strs = new byte[mAct.mRecgCount];
                    for ( int i = 0; i < mAct.mRecgCount; ++i ) {
                        strs[i] = (byte)mAct.mRecgs[i];
                    }
                    try {
                        String strReg = new String(strs, "UTF8");
                        if (msg.arg1 >= 0) {
                            Log.d(TAG, "reg ok!!!!!!!!!!!!");
                            if (null != mAct) {
                                mAct.mRecognisedTextView.setText(strReg);
                                // mAct.mRegState.setText("reg ok(" + msg.arg1 + ")");
                            }
                        } else {
                            Log.d(TAG, "reg error!!!!!!!!!!!!!");
                            mAct.mRecognisedTextView.setText(strReg);
                            // mAct.mRegState.setText("reg err(" + msg.arg1 + ")");
                            // mAct.mRegState.setText("reg err");
                        }
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                break;

            case MSG_PLAY_TEXT:
//                mAct.mPlayTextView.setText(mAct.mPlayText);
                break;
            }
            super.handleMessage(msg);
        }
    }

    @Override
    public void onSinVoiceRecognitionStart() {
        mHanlder.sendEmptyMessage(MSG_RECG_START);
    }

    @Override
    public void onSinVoiceRecognition(char ch) {
        mHanlder.sendMessage(mHanlder.obtainMessage(MSG_SET_RECG_TEXT, ch, 0));
    }

    @Override
    public void onSinVoiceRecognitionEnd(int result) {
        mHanlder.sendMessage(mHanlder.obtainMessage(MSG_RECG_END, result, 0));
    }

    @Override
    public void onSinVoicePlayStart() {
        LogHelper.d(TAG, "start play");
    }

    @Override
    public void onSinVoicePlayEnd() {
        LogHelper.d(TAG, "stop play");
    }

    private static String getTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        return sdf.format(new Date());
    }

    private static void copyFile(File targetFile, File sourceFile)
            throws IOException {
        FileInputStream input = new FileInputStream(sourceFile);
        BufferedInputStream inBuff = new BufferedInputStream(input);

        FileOutputStream output = new FileOutputStream(targetFile);
        BufferedOutputStream outBuff = new BufferedOutputStream(output);

        byte[] b = new byte[1024 * 5];
        int len;
        while ((len = inBuff.read(b)) != -1) {
            outBuff.write(b, 0, len);
        }
        outBuff.flush();

        inBuff.close();
        outBuff.close();
        output.close();
        input.close();
    }

    private static void copyDirectiory(String targetDir, String sourceDir)
            throws IOException {
        (new File(targetDir)).mkdirs();
        File[] file = (new File(sourceDir)).listFiles();
        if (null != file) {
            for (int i = 0; i < file.length; i++) {
                if (file[i].isFile()) {
                    File sourceFile = file[i];
                    File targetFile = new File(
                            new File(targetDir).getAbsolutePath()
                                    + File.separator + file[i].getName());
                    copyFile(targetFile, sourceFile);
                }
                if (file[i].isDirectory()) {
                    String srcPath = sourceDir + "/" + file[i].getName();
                    String targetPath = targetDir + "/" + file[i].getName();
                    copyDirectiory(targetPath, srcPath);
                }
            }
        }
    }

    @Override
    public void onSinToken(int[] tokens) {
//        if (null != tokens) {
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < tokens.length; ++i) {
//                sb.append(Common.DEFAULT_CODE_BOOK.charAt(tokens[i]));
//            }
//
//            mPlayText = sb.toString();
//            LogHelper.d(TAG, "onSinToken " + mPlayText);
//            mHanlder.sendEmptyMessage(MSG_PLAY_TEXT);
//        }
    }

}
