package com.hus.twitterclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hus.twitterclone.ui.theme.BlackTwitter
import com.hus.twitterclone.ui.theme.TwitterCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TwitterCloneTheme {

                //3 Screens
                //Main Search // profile
                Wrapper()
            }
        }
    }
}

@Composable
fun Wrapper(modifier: Modifier = Modifier) {
    Scaffold(
        modifier
            .fillMaxSize()
            .background(Color.Red),
        topBar = { Top() },
        bottomBar = { Bottom() },
        containerColor = BlackTwitter
    ) { padding ->
        val tweets = listOf(
            Post(
                "Name",
                "@username",
                "ContentContentContentContentContentContent\nContentContentContentContentContentContent\nContentContentContent",
                painterResource(id = R.drawable.hus)
            ), Post(
                "Name",
                "@username",
                "ContentContentContentContentContentContent\nContentContentContentContentContentContent\nContentContentContent",
                painterResource(id = R.drawable.hus)
            ), Post(
                "Name",
                "@username",
                "ContentContentContentContentContentContent\nContentContentContentContentContentContent\nContentContentContent",
                painterResource(id = R.drawable.hus)
            ), Post(
                "Name",
                "@username",
                "ContentContentContentContentContentContent\nContentContentContentContentContentContent\nContentContentContent",
                painterResource(id = R.drawable.hus)
            ), Post(
                "Name",
                "@username",
                "ContentContentContentContentContentContent\nContentContentContentContentContentContent\nContentContentContent",
                painterResource(id = R.drawable.hus)
            ), Post(
                "Hussein",
                "@husz13",
                "ContentContentContentContentContentContent\nContentContentContentContentContentContent\nContentContentContent",
                image = null
            ), Post(
                "husz13",
                "@husz13",
                "ContentContentContentContentContentContent\nContentContentContentContentContentContent\nContentContentContent",
                image = null
            )
        )
        //content : @Composable () -> Unit
        //        content()
        LazyColumn(
            // verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            state = rememberLazyListState()
        ) {
            items(tweets) { item ->
                Tweet(
                    post = item
                )

            }


        }

    }
}

@Composable
fun Top() {
    Row(
        Modifier
            .fillMaxWidth()
            .background(BlackTwitter)
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.hus),
            contentDescription = "Xlogo",
            modifier = Modifier
                .size(25.dp)
                .clip(CircleShape)
                .clickable {
                    // TODO("Show Profile")
                }
        )
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Xlogo",
            modifier = Modifier.size(25.dp)
        )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Outlined.Settings,
                contentDescription = "Settings",
                tint = Color.White
            )
        }

    }
}

@Composable
fun Bottom() {

    Row(
        Modifier
            .fillMaxWidth()

            .background(BlackTwitter)
            .border(width = 1.dp, color = Color.White,
                shape = RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp))
            .padding(7.dp),

        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "Home",
            tint = Color.White,
            modifier = Modifier.size(35.dp)
        )
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Home",
            tint = Color.White,
            modifier = Modifier.size(35.dp)
        )
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Home",
            tint = Color.White,
            modifier = Modifier.size(35.dp)
        )


    }

}


@Composable
fun Tweet(modifier: Modifier = Modifier, post: Post) {
    Row(
        modifier
            .background(BlackTwitter)
            .padding(start = 5.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.hus), contentDescription = "",
            Modifier
                .size(40.dp)
                .clip(
                    CircleShape
                )
        )
        Spacer(modifier = Modifier.width(6.dp))
        Column(
            Modifier
                .weight(1f)
                .padding(top = 10.dp)
        ) {
            Row(
                Modifier.fillMaxHeight(),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(text = post.author,color = Color.White)
                Text(post.username,color = Color.White)
            }
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = post.content,color = Color.White)
            if (post.image != null)
                Image(
                    painter = painterResource(id = R.drawable.hus),
                    contentDescription = "",
                    modifier = Modifier
                        .size(300.dp)
                        .clip(
                            RoundedCornerShape(20.dp)
                        )
                )
            TweetAction()

        }
    }
}

@Composable
fun TweetAction(modifier: Modifier = Modifier) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(id = R.drawable.chat), contentDescription = "Home",
            tint = Color.White,
            modifier = Modifier.size(20.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.repost),
            contentDescription = "Home",
            tint = Color.White,
            modifier = Modifier.size(20.dp)
        )
        Icon(
            imageVector = Icons.Default.FavoriteBorder,
            contentDescription = "Home",
            tint = Color.White,
            modifier = Modifier.size(20.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.bookmark),
            contentDescription = "Home",
            tint = Color.White,
            modifier = Modifier.size(20.dp)
        )

    }
}