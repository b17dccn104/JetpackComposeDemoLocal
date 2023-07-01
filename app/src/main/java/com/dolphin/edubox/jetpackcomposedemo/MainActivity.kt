package com.dolphin.edubox.jetpackcomposedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dolphin.edubox.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Column(modifier = Modifier.padding(10.dp)) {
        BannerSecond()
        Spacer(modifier = Modifier.height(10.dp))
        Banner()
        Spacer(modifier = Modifier.height(10.dp))
        GreetingText()
        Spacer(modifier = Modifier.height(10.dp))
//        MultipleStylesText()
//        ImageVector()
        ButtonCompose()
    }
}

@Composable
fun GreetingText() {
    Text(
        text = stringResource(id = R.string.test),
        color = colorResource(id = R.color.teal_700),
        fontSize = 20.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = FontFamily.Cursive,
        textAlign = TextAlign.Start,
        maxLines = 6,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun MultipleStylesText() {
    Text(text = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Red)) {
            append("H")
        }
        append("ello")
        withStyle(style = SpanStyle(color = Color.Green)) {
            append("W")
        }
        append("orld")
    })
}

@Composable
fun ButtonCompose() {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.DarkGray,
            disabledContainerColor = Color.Gray
        ),
        enabled = true,
        shape = RoundedCornerShape(topEnd = 20.dp, bottomStart = 20.dp),
        border = BorderStroke(width = 1.dp, color = Color.Cyan),
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 5.dp,
            pressedElevation = 10.dp
        )
    ) {
        Icon(Icons.Default.AccountCircle, contentDescription = null)
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "Fashion", fontFamily = FontFamily.Monospace)
    }
}

@Composable
fun Banner() {
    Surface(
        modifier = Modifier
            .border(
                BorderStroke(
                    1.dp,
                    color = Color.Gray
                ),
                shape = CircleShape
            )
            .clip(shape = CircleShape)
    ) {
        // test commit phat
        Image(
            painterResource(id = R.drawable.banner),
            contentDescription = "Banner test, có thể đặt bằng null",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .size(100.dp)
                .clickable {
                    // click
                }
                .pointerInput(Unit) {
                    detectTapGestures(
                        onDoubleTap = {
                            //double tab
                        },
                        onLongPress = {
                            //long press
                        },
                        onPress = {
                            //press
                        }
                    )
                }
        )
    }
}

@Composable
fun BannerSecond() {
    Image(
        painterResource(id = R.drawable.banner),
        contentDescription = "Banner test, có thể đặt bằng null",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(size = 10.dp)
            )
            .aspectRatio(2f)
    )
}

@Composable
fun ImageVector() {
    Image(
        imageVector = Icons.Filled.Person,
        modifier = Modifier.size(50.dp, 50.dp),
        contentDescription = "Vector test, có thể đặt bằng null"
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    JetpackComposeDemoTheme {
        HomeScreen()
    }
}
