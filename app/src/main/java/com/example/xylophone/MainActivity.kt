package com.example.xylophone

import android.media.SoundPool
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.xylophone.ui.theme.XylophoneTheme

class MainActivity : ComponentActivity() {
    private val simultaneousSoundStreams = 7
    private val leftVolume = 1.0f
    private val rightVolume = 1.0f
    private val loop = 0
    private val priority = 0
    private val NORMAL_PLAY_RATE = 1.0f

    private lateinit var mSoundPool: SoundPool
    private var mCSoundId1: Int = 0
    private var mDSoundId2: Int = 0
    private var mESoundId3: Int = 0
    private var mFSoundId4: Int = 0
    private var mGSoundId5: Int = 0
    private var mASoundId6: Int = 0
    private var mBSoundId7: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mSoundPool = SoundPool.Builder().setMaxStreams(simultaneousSoundStreams).build()

        mCSoundId1 = mSoundPool.load(this, R.raw.note1_c, 1)
        mDSoundId2 = mSoundPool.load(this, R.raw.note2_d, 1)
        mESoundId3 = mSoundPool.load(this, R.raw.note3_e, 1)
        mFSoundId4 = mSoundPool.load(this, R.raw.note4_f, 1)
        mGSoundId5 = mSoundPool.load(this, R.raw.note5_g, 1)
        mASoundId6 = mSoundPool.load(this, R.raw.note6_a, 1)
        mBSoundId7 = mSoundPool.load(this, R.raw.note7_b, 1)

        setContent {
            XylophoneTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        Text(
                            text = stringResource(R.string.main_screen_title),
                            modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth(),
                            style = MaterialTheme.typography.titleLarge,
                            textAlign = TextAlign.Center,
                        )
                    }
                ) { innerPadding ->
                    MainScreen(
                        playNote = {
                            when (it) {
                                "C" -> mSoundPool.play(mCSoundId1, leftVolume, rightVolume, priority, loop, NORMAL_PLAY_RATE)
                                "D" -> mSoundPool.play(mDSoundId2, leftVolume, rightVolume, priority, loop, NORMAL_PLAY_RATE)
                                "E" -> mSoundPool.play(mESoundId3, leftVolume, rightVolume, priority, loop, NORMAL_PLAY_RATE)
                                "F" -> mSoundPool.play(mFSoundId4, leftVolume, rightVolume, priority, loop, NORMAL_PLAY_RATE)
                                "G" -> mSoundPool.play(mGSoundId5, leftVolume, rightVolume, priority, loop, NORMAL_PLAY_RATE)
                                "A" -> mSoundPool.play(mASoundId6, leftVolume, rightVolume, priority, loop, NORMAL_PLAY_RATE)
                                "B" -> mSoundPool.play(mBSoundId7, leftVolume, rightVolume, priority, loop, NORMAL_PLAY_RATE)
                            }
                        },
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    playNote: (String) -> Unit,
    modifier: Modifier = Modifier,
) {

    val buttonHeight = 200.dp
    val buttonPadding = 8.dp

    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Button(
            modifier = Modifier
                .height(buttonHeight + 60.dp)
                .padding(buttonPadding)
                .weight(1f),
            onClick = { playNote("C") },
            shape = RectangleShape,
        ) {
            Text(text = "C")
        }

        Button(
            modifier = Modifier
                .height(buttonHeight + 50.dp)
                .padding(buttonPadding)
                .weight(1f),
            onClick = { playNote("D") },
            shape = RectangleShape,
        ) {
            Text(text = "D")
        }

        Button(
            modifier = Modifier
                .height(buttonHeight + 40.dp)
                .padding(buttonPadding)
                .weight(1f),
            onClick = { playNote("E") },
            shape = RectangleShape,
        ) {
            Text(text = "E")
        }

        Button(
            modifier = Modifier
                .height(buttonHeight + 30.dp)
                .padding(buttonPadding)
                .weight(1f),
            onClick = { playNote("F") },
            shape = RectangleShape,
        ) {
            Text(text = "F")
        }

        Button(
            modifier = Modifier
                .height(buttonHeight + 20.dp)
                .padding(buttonPadding)
                .weight(1f),
            onClick = { playNote("G") },
            shape = RectangleShape,
        ) {
            Text(text = "G")
        }

        Button(
            modifier = Modifier
                .height(buttonHeight + 10.dp)
                .padding(buttonPadding)
                .weight(1f),
            onClick = { playNote("A") },
            shape = RectangleShape,
        ) {
            Text(text = "A")
        }

        Button(
            modifier = Modifier
                .height(buttonHeight)
                .padding(buttonPadding)
                .weight(1f),
            onClick = { playNote("B") },
            shape = RectangleShape,
        ) {
            Text(text = "B")
        }
    }

}


