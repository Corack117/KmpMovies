package com.corack.kmpmovies.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.corack.shared.models.Movie
import kmpmovies.composeapp.generated.resources.Res
import kmpmovies.composeapp.generated.resources.original_language
import kmpmovies.composeapp.generated.resources.original_title
import kmpmovies.composeapp.generated.resources.popularity
import kmpmovies.composeapp.generated.resources.release_date
import kmpmovies.composeapp.generated.resources.vote_average
import org.jetbrains.compose.resources.stringResource

@Composable
fun MovieDetail(
    modifier: Modifier = Modifier,
    movie: Movie
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        AsyncImage(
            model = movie.backdrop,
            contentDescription = movie.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16 / 9f)
        )

        Text(
            text = movie.overview,
            modifier = Modifier.padding(16.dp)
        )

        Text(
            text = buildAnnotatedString {
                property(stringResource(Res.string.original_language), movie.originalLanguage)
                property(stringResource(Res.string.original_title), movie.originalTitle)
                property(stringResource(Res.string.release_date), movie.releaseDate)
                property(stringResource(Res.string.popularity), movie.popularity.toString())
                property(stringResource(Res.string.vote_average), movie.voteAverage.toString())
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.onSecondary)
                .padding(16.dp)
        )
    }
}

private fun AnnotatedString.Builder.property(name: String, value: String, end: Boolean = false) {
    withStyle(ParagraphStyle(lineHeight = 18.sp)) {
        withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
            append("$name: ")
        }
        append(value)
        if (!end) {
            append("\n")
        }
    }
}