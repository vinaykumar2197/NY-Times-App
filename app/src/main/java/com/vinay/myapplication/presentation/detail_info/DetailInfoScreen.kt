package com.vinay.myapplication.presentation.detail_info

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.vinay.myapplication.ui.theme.DarkBlue
import com.vinay.myapplication.util.DEFAULT_RECIPE_IMAGE
import com.vinay.myapplication.util.loadPicture

@Composable
@Destination
fun DetailInfoScreen(
    url : String?,
    title: String?,
    author : String?,
    source : String?,
    publishDate : String?,
    description : String?
) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkBlue)
                .padding(16.dp)
        ) {

            val image = url?.let {
                loadPicture(
                    url = it,
                    defaultImage = DEFAULT_RECIPE_IMAGE
                ).value
            }
            image?.let { img ->
                Image(
                    bitmap = img.asImageBitmap(),
                    "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .clip(RectangleShape)
                        .border(0.5.dp, Color.Gray, RectangleShape),
                    contentScale = ContentScale.Crop,
                )
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
            )
            title?.let {
                Text(
                    text = it,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            author?.let {
                Text(
                    text = it,
                    fontStyle = FontStyle.Italic,
                    fontSize = 14.sp,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            source?.let {
                Text(
                    text = it,
                    fontSize = 14.sp,
                    modifier = Modifier.fillMaxWidth(),
                    overflow = TextOverflow.Ellipsis
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            publishDate?.let {
                Text(
                    text = it,
                    fontSize = 14.sp,
                    modifier = Modifier.fillMaxWidth(),
                    overflow = TextOverflow.Ellipsis
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            description?.let {
                Text(
                    text = it,
                    fontSize = 12.sp,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
    }
}