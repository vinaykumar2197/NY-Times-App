package com.vinay.myapplication.presentation.entry_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vinay.myapplication.util.DEFAULT_RECIPE_IMAGE
import com.vinay.myapplication.util.loadPicture
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import com.vinay.myapplication.R
import com.vinay.myapplication.domain.model.Results

@Composable
fun CompanyItem(
    company: Results,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (company?.media?.size > 0 && (company?.media?.get(0)?.mediaMetadata?.size ?: 0) > 0) {
            company?.media?.get(0)?.mediaMetadata?.get(0)?.url?.let { url ->
                val image = loadPicture(url = url, defaultImage = DEFAULT_RECIPE_IMAGE).value
                image?.let { img ->
                    Image(
                        bitmap = img.asImageBitmap(),
                        "",
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .border(0.5.dp, Color.Gray, CircleShape),
                        contentScale = ContentScale.Crop,
                    )
                }
            }
        } else {
            val image = loadPicture(url = "", defaultImage = DEFAULT_RECIPE_IMAGE).value
            image?.let { img ->
                Image(
                    bitmap = img.asImageBitmap(),
                    "",
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .border(0.5.dp, Color.Gray, CircleShape),
                    contentScale = ContentScale.Crop,
                )
            }
        }
        Column(
            modifier = Modifier
                .padding(16.dp)
                .weight(2.5f)
        ) {
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "${company.title}",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = MaterialTheme.colors.onBackground,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "${company.byline}",
                fontWeight = FontWeight.Light,
                color = MaterialTheme.colors.onBackground,
                maxLines = 2,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${company.publishedDate}",
                    fontStyle = FontStyle.Italic,
                    color = MaterialTheme.colors.onBackground
                )
                Spacer(modifier = Modifier.height(16.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_right),
                    "",
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}