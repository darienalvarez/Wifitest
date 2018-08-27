package com.traveltab.wifitest.view

import android.support.test.runner.AndroidJUnit4
import org.junit.runner.RunWith
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.*
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import com.traveltab.wifitest.R
import org.junit.Rule
import org.junit.Test


/**
 * @author Darien
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun test_showsTheButton() {
        onView(withId(R.id.connectBtn)).check(matches(isDisplayed()))
    }

    @Test
    fun test_buttonText() {
        onView(withId(R.id.connectBtn)).check(matches(withText("CONNECT TO WIFI")))
    }
}