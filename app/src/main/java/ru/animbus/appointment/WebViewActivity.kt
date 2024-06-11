package ru.animbus.appointment

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView


class WebViewActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                intent.getStringExtra("url")?.let { MainContent(url = it) }
            }
        }
        onBackPressedDispatcher.addCallback(
            this /* lifecycle owner */,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    val intent = Intent(this@WebViewActivity, MainActivity::class.java)
                    startActivity(intent)
                }
            })
    }

    // Creating a composable
// function to display Top Bar
    @Composable
    fun MainContent(url: String) {
        Scaffold(
            content = { MyContent(url) }
        )
    }


    // Creating a composable
// function to create WebView
// Calling this function as
// content in the above function
    @Composable
    fun MyContent(url: String) {

        // Declare a string that contains a url
        val mUrl = url
        Column {
            // Adding a WebView inside AndroidView
            // with layout as full screen
            Row(modifier = Modifier.padding(all = 16.dp)) {
                Image(
                    painter = painterResource(R.drawable.ic_back),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable { onBackPressedDispatcher.onBackPressed() }
                        .size(40.dp)
                        .clip(CircleShape)
                        .border(1.5.dp, colorResource(id = R.color.teal_200), CircleShape)
                )
                Text(
                    text = getString(R.string.app_name),
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(16.dp, 0.dp,0.dp,0.dp).align(alignment = Alignment.CenterVertically)
                )
            }
            Spacer(
                modifier = Modifier
                    .height(height = 1.dp)
                    .fillMaxWidth()
                    .background(Color(getColor(R.color.teal_200))),
            )
            AndroidView(factory = {
                WebView(it).apply {
                    settings.javaScriptEnabled = true
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    webViewClient = WebViewClient()
                    loadUrl(mUrl)
                }
            }, update = {
                it.loadUrl(mUrl)
            })
        }
    }
}