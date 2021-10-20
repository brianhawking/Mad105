/**
 * Class - MainActivity2
 * @author - Brian Veitch
 * date - 10/16
 * @param
 * None
 * @description
 * Display name and profile
 * Uses strings.xml to store name,profile
 *
 * mods
 * BV
 */

package com.example.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }
}