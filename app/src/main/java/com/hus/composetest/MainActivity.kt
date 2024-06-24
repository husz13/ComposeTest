package com.hus.composetest

import android.content.Context
import android.os.Bundle
import android.text.style.StyleSpan
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hus.composetest.ui.theme.ComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 30.dp, vertical = 20.dp),
                //  verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                MyTextView(text = "Welcome Back")
                Box(modifier = Modifier.height(10.dp))

                Text(text = "We're excited to have you back, can't wait to see what you've been up to since you last logged in.")
                Box(modifier = Modifier.height(60.dp))

                Text(text = "Email", modifier = Modifier.padding(horizontal = 15.dp))
                MyTextField(holder = "Email")
                Box(modifier = Modifier.height(20.dp))
                Text(
                    text = "Password", modifier = Modifier
                        .padding(horizontal = 15.dp)
                        .fillMaxWidth()
                )
                MyTextField(holder = "Password")
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        CheckedBox()
                        Text(text = "Remember Me")
                    }
                    Text(text = "Forgot Password ? ")

                }
                val ctx = LocalContext.current
                Button(shape = AbsoluteRoundedCornerShape(16.dp),
                    onClick = { /*TODO*/
                        val toast = Toast.makeText(ctx, "YePPI", Toast.LENGTH_SHORT)
                        toast.show()
                    }, modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "LogIn")

                }
                Box(modifier = Modifier.height(30.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    //horizontalArrangement =  Arrangement.SpaceBetween,
                ) {
                    Divider(modifier = Modifier.weight(1f))
                    Text(
                        "Social Media",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(1f)
                    )
                    Divider(modifier = Modifier.weight(1f))
                }
                Box(modifier = Modifier.height(30.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "HellNo"
                    )
                    Image(
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = "HellNo"
                    )
                    Image(
                        painter = painterResource(id = R.drawable.apple),
                        contentDescription = "HellNo"
                    )

                }
                Text(
                    text = buildAnnotatedString {
                        append( "By logging, you agree to our ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
                            append("Terms & Conditions ")
                        }
                        append("and")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
                            append(" PrivacyPolicy .")
                        }


                    },
                    textAlign = TextAlign.Center

                )

            }

        }
    }
}

@Composable
fun CheckedBox() {
    val box = remember {
        mutableStateOf(false)
    }
    Checkbox(checked = box.value, onCheckedChange = { box.value = !box.value })
}

@Composable
fun MyTextView(text: String) {
    Text(
        text = text, color = Color.Blue, fontSize = 30.sp, fontWeight = FontWeight.Bold
    )

}

@Composable
fun MyTextField(holder: String) {
    val fieldValue = remember {
        mutableStateOf(value = "")
    }
    OutlinedTextField(value = fieldValue.value,
        shape = RoundedCornerShape(corner = CornerSize(size = 16.dp)),
        onValueChange = { textString ->
            fieldValue.value = textString
        },
        placeholder = {
            Text(text = holder)
        }
    )
}

