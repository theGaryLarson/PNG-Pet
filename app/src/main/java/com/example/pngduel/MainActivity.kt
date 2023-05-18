package com.example.pngduel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pngduel.ui.theme.PNGPetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PNGPetTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.tertiaryContainer),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PetCare()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetCare() {

    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }
Scaffold(
    topBar = {
        CenterAlignedTopAppBar(title = {
                Text(
                    text = stringResource(id = R.string.app_name),
                    fontWeight = FontWeight.Bold
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        )


        }) {innerPadding ->
            Surface(modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background
            ) {
                when (currentStep) {
                    1 -> {
                        CorgiTextAndImage(
                            textLabelResourceId = R.string.sleepy_corgi_description,
                            drawableResourceId = R.drawable.sleepy_corgi,
                            contentDescriptionResourceId = R.string.sleepy_corgi,
                            drawableResourceId1 = R.drawable.bed,
                            contentDescriptionResourceId1 = R.string.bed_description,
                            drawableResourceId2 = R.drawable.chew_toy,
                            contentDescriptionResourceId2 = R.string.chew_toy_description,
                            drawableResourceId3 = R.drawable.food,
                            contentDescriptionResourceId3 = R.string.dog_food_description,
                            onImageClick = {
                                currentStep = 2
                                squeezeCount = (2..4).random()
                            }
                        )
                    }
                    2 -> {
                        CorgiTextAndImage(
                            textLabelResourceId = R.string.hungry_corgi_description,
                            drawableResourceId = R.drawable.hungry_corgi,
                            contentDescriptionResourceId = R.string.hungry_corgi,
                            drawableResourceId1 = R.drawable.bed,
                            contentDescriptionResourceId1 = R.string.bed_description,
                            drawableResourceId2 = R.drawable.chew_toy,
                            contentDescriptionResourceId2 = R.string.chew_toy_description,
                            drawableResourceId3 = R.drawable.food,
                            contentDescriptionResourceId3 = R.string.dog_food_description,
                            onImageClick = {
                                squeezeCount--
                                if (squeezeCount == 0) {
                                    currentStep = 3
                                }
                            }
                        )
                    }

                    3 -> {
                        CorgiTextAndImage(
                            textLabelResourceId = R.string.in_love_corgi_description,
                            drawableResourceId = R.drawable.in_love_corgi,
                            contentDescriptionResourceId = R.string.in_love_corgi,
                            drawableResourceId1 = R.drawable.bed,
                            contentDescriptionResourceId1 = R.string.bed_description,
                            drawableResourceId2 = R.drawable.chew_toy,
                            contentDescriptionResourceId2 = R.string.chew_toy_description,
                            drawableResourceId3 = R.drawable.food,
                            contentDescriptionResourceId3 = R.string.dog_food_description,
                            onImageClick = {
                                currentStep = 4
                            }
                        )
                    }
                    4 -> {
                        CorgiTextAndImage(
                            textLabelResourceId = R.string.sad_corgi_description,
                            drawableResourceId = R.drawable.sad_corgi,
                            contentDescriptionResourceId = R.string.sad_corgi,
                            drawableResourceId1 = R.drawable.bed,
                            contentDescriptionResourceId1 = R.string.bed_description,
                            drawableResourceId2 = R.drawable.chew_toy,
                            contentDescriptionResourceId2 = R.string.chew_toy_description,
                            drawableResourceId3 = R.drawable.food,
                            contentDescriptionResourceId3 = R.string.dog_food_description,
                            onImageClick = {
                                currentStep = 1
                            }
                        )
                    }
                    else -> {
                        currentStep = 1
                    }
            }

}

    }
}



@Composable
fun CorgiTextAndImage(
    textLabelResourceId: Int,
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    drawableResourceId1: Int,
    contentDescriptionResourceId1: Int,
    drawableResourceId2: Int,
    contentDescriptionResourceId2: Int,
    drawableResourceId3: Int,
    contentDescriptionResourceId3: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text( text= stringResource(id = contentDescriptionResourceId),
            fontWeight = FontWeight.ExtraBold)
            Button(
                onClick = onImageClick,
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.button_corner_radius)),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Image(
                    painter = painterResource(drawableResourceId),
                    contentDescription = stringResource(contentDescriptionResourceId),
                    modifier = Modifier
                        .wrapContentSize()
                        .size(300.dp)

                )
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_vertical)))
            Text(
                text = stringResource(textLabelResourceId),
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_vertical)))
            Row() {
                Image(
                    painter = painterResource(id = drawableResourceId1),
                    contentDescription = stringResource(id = contentDescriptionResourceId1),
                    modifier = Modifier.size(100.dp)
                )
                Image(
                    painter = painterResource(id = drawableResourceId2),
                    contentDescription = stringResource(id = contentDescriptionResourceId2),
                    modifier = Modifier.size(100.dp)
                )
                Image(
                    painter = painterResource(id = drawableResourceId3),
                    contentDescription = stringResource(id = contentDescriptionResourceId3),
                    modifier = Modifier.size(100.dp)
                )

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonTextAndImagePreview() {
    PNGPetTheme {
        PetCare()
    }
}