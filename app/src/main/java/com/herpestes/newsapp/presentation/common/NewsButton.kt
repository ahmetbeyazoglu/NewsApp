package com.herpestes.newsapp.presentation.common

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun NewsButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            //containerColor = MaterialTheme.colors.primary,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(size = 6.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.SemiBold),
        )
    }
}


@Composable
fun NewsTextButton(
    text: String,
    onClick: () -> Unit
){
    TextButton(onClick = onClick) {
        Text(
            text = text,
            style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.SemiBold),
            color = Color.White
        )
    }

}
