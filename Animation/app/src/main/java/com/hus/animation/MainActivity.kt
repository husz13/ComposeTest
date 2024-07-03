package com.hus.animation

import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.ProgressBarRangeInfo
import androidx.compose.ui.unit.dp

import com.hus.animation.ui.theme.AnimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimationTheme {
                var clicked by remember {
                    mutableStateOf(1)
                }
                val progress by animateFloatAsState(
                    targetValue = clicked.toFloat(), animationSpec = tween(1000)
                )
                val colors = listOf(Color.Yellow,Color.LightGray,Color.Red,Color.Green)

                Box(
                    Modifier
                        .fillMaxSize()
                        .padding(horizontal = 12.dp, 12.dp)
                ) {
                    AnimatedContent(targetState = clicked, label = "Label",
                        transitionSpec = {
                            slideInHorizontally {
                                it/2
                            } togetherWith slideOutHorizontally {
                                -it/2
                            }
                        }) { progress ->

                             Box(
                                Modifier
                                    .fillMaxSize()
                                    .background(colors[progress-1])
                            ){
                                 Text("Hello Screen No.$progress",Modifier.align(Center))
                             }





                    }
                    Button(
                        onClick = {
                            if (clicked == 4) {
                                clicked = 1
                            } else clicked++
                        },
                        Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomEnd)
                    ) {
                        Text("Next")
                    }
                    LinearProgressIndicator(
                        progress = progress / 4f,
                        Modifier
                            .fillMaxWidth()
                            .height(12.dp)
                            .align(TopCenter)
                    )


                }
            }
        }
    }
}

