package com.walle.controlself.controlsu

import android.app.Activity
import android.os.Bundle
import android.speech.SpeechRecognizer
import com.baidu.speech.VoiceRecognitionService
import android.content.ComponentName
import android.speech.RecognitionListener
import android.util.Log
import android.widget.ScrollView
import android.widget.TextView
import android.speech.RecognizerIntent.EXTRA_LANGUAGE
import android.preference.PreferenceManager
import android.content.SharedPreferences
import android.content.Intent
import android.widget.Button
import org.json.JSONException
import org.json.JSONArray
import org.json.JSONObject










class MainActivity : Activity() ,RecognitionListener {
    val  TAG="MainActivity";
    var bt:Button?=null
    override fun onReadyForSpeech(params: Bundle?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        print("onReadyForSpeech")
    }

    override fun onRmsChanged(rmsdB: Float) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        print("onRmsChanged")
    }

    override fun onBufferReceived(buffer: ByteArray?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        print("onBufferReceived")
    }

    override fun onPartialResults(partialResults: Bundle?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        print("onPartialResults")
    }

    override fun onEvent(eventType: Int, params: Bundle?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        print("onEvent")
    }

    override fun onBeginningOfSpeech() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        print("onBeginningOfSpeech")
    }

    override fun onEndOfSpeech() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        print("onEndOfSpeech")
    }

    override fun onError(error: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        print("onError" +error)
    }

    override fun onResults(results: Bundle?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        print("onResults")
    }
    var  speech:SpeechRecognizer ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt= findViewById(R.id.bt_control) as Button?;
         speech=  SpeechRecognizer.createSpeechRecognizer(this, ComponentName(this, VoiceRecognitionService::class.java))
        speech?.setRecognitionListener(this)
        bt?.setOnClickListener {
            Log.d(TAG,"Onclick")
            val intent = Intent()
            bindParams(intent)
            intent.putExtra("args", "");
            speech?.startListening(intent)
//            intent.setAction("com.baidu.action.RECOGNIZE_SPEECH");
//            startActivityForResult(intent, 1);
        }
    }

    fun bindParams(intent: Intent) {
        val sp = PreferenceManager.getDefaultSharedPreferences(this)
            intent.putExtra(Constant.EXTRA_SOUND_START, R.raw.bdspeech_recognition_start)
            intent.putExtra(Constant.EXTRA_SOUND_END, R.raw.bdspeech_speech_end)
            intent.putExtra(Constant.EXTRA_SOUND_SUCCESS, R.raw.bdspeech_recognition_success)
            intent.putExtra(Constant.EXTRA_SOUND_ERROR, R.raw.bdspeech_recognition_error)
            intent.putExtra(Constant.EXTRA_SOUND_CANCEL, R.raw.bdspeech_recognition_cancel)
            val tmp = sp.getString(Constant.EXTRA_INFILE, "")!!.replace(",.*".toRegex(), "").trim { it <= ' ' }
            intent.putExtra(Constant.EXTRA_INFILE, tmp)
            intent.putExtra(Constant.EXTRA_OUTFILE, "sdcard/outfile.pcm")
            intent.putExtra(Constant.EXTRA_GRAMMAR, "assets:///baidu_speech_grammar.bsg")
        if (sp.contains(Constant.EXTRA_SAMPLE)) {
            val tmp = sp.getString(Constant.EXTRA_SAMPLE, "")!!.replace(",.*".toRegex(), "").trim { it <= ' ' }
            if (null != tmp && "" != tmp) {
                intent.putExtra(Constant.EXTRA_SAMPLE, Integer.parseInt(tmp))
            }
        }
        if (sp.contains(Constant.EXTRA_LANGUAGE)) {
            val tmp = sp.getString(Constant.EXTRA_LANGUAGE, "")!!.replace(",.*".toRegex(), "").trim { it <= ' ' }
            if (null != tmp && "" != tmp) {
                intent.putExtra(Constant.EXTRA_LANGUAGE, tmp)
            }
        }
        if (sp.contains(Constant.EXTRA_NLU)) {
            val tmp = sp.getString(Constant.EXTRA_NLU, "")!!.replace(",.*".toRegex(), "").trim { it <= ' ' }
            if (null != tmp && "" != tmp) {
                intent.putExtra(Constant.EXTRA_NLU, tmp)
            }
        }

        if (sp.contains(Constant.EXTRA_VAD)) {
            val tmp = sp.getString(Constant.EXTRA_VAD, "")!!.replace(",.*".toRegex(), "").trim { it <= ' ' }
            if (null != tmp && "" != tmp) {
                intent.putExtra(Constant.EXTRA_VAD, tmp)
            }
        }
        var prop: String? = null
        if (sp.contains(Constant.EXTRA_PROP)) {
            val tmp = sp.getString(Constant.EXTRA_PROP, "")!!.replace(",.*".toRegex(), "").trim { it <= ' ' }
            if (null != tmp && "" != tmp) {
                intent.putExtra(Constant.EXTRA_PROP, Integer.parseInt(tmp))
                prop = tmp
            }
        }

        // offline asr
        run {
            intent.putExtra(Constant.EXTRA_OFFLINE_ASR_BASE_FILE_PATH, "/sdcard/easr/s_1")
            if (null != prop) {
                val propInt = Integer.parseInt(prop)
                if (propInt == 10060) {
                    intent.putExtra(Constant.EXTRA_OFFLINE_LM_RES_FILE_PATH, "/sdcard/easr/s_2_Navi")
                } else if (propInt == 20000) {
                    intent.putExtra(Constant.EXTRA_OFFLINE_LM_RES_FILE_PATH, "/sdcard/easr/s_2_InputMethod")
                }
            }
            intent.putExtra(Constant.EXTRA_OFFLINE_SLOT_DATA, buildTestSlotData())
        }
    }

    private fun buildTestSlotData(): String {
        val slotData = JSONObject()
        val name = JSONArray().put("李涌泉").put("郭下纶")
        val song = JSONArray().put("七里香").put("发如雪")
        val artist = JSONArray().put("周杰伦").put("李世龙")
        val app = JSONArray().put("手机百度").put("百度地图")
        val usercommand = JSONArray().put("关灯").put("开门")
        try {
            slotData.put(Constant.EXTRA_OFFLINE_SLOT_NAME, name)
            slotData.put(Constant.EXTRA_OFFLINE_SLOT_SONG, song)
            slotData.put(Constant.EXTRA_OFFLINE_SLOT_ARTIST, artist)
            slotData.put(Constant.EXTRA_OFFLINE_SLOT_APP, app)
            slotData.put(Constant.EXTRA_OFFLINE_SLOT_USERCOMMAND, usercommand)
        } catch (e: JSONException) {

        }

        return slotData.toString()
    }

    private fun print(msg: String) {
        Log.d(TAG, "----" + msg)
    }
}
