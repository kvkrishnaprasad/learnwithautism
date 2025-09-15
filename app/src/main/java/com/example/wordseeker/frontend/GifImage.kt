import android.media.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import android.os.Build
import coil.decode.ImageDecoderDecoder
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.wordseeker.R
import coil.decode.GifDecoder

@Composable
fun GifImage(pecsImage: Int) {
    val context = LocalContext.current
    // Explicit ImageLoader with GIF decoder
    val imageLoader = ImageLoader.Builder(context)
        .components {
            add(ImageDecoderDecoder.Factory())
        }
        .build()

    AsyncImage(
        model = ImageRequest.Builder(context)
            //ImageRequest.Builder(LocalContext.current)
            // Local GIF
            .data(pecsImage)
            .allowHardware(false)

            // Or remote GIF
//            .data("https://media.giphy.com/media/Ju7l5y9osyymQ/giphy.gif")
            .crossfade(true)
            .build(),
        contentDescription = "Animated GIF",
        modifier = Modifier.size(200.dp),
        contentScale = ContentScale.Crop,
        imageLoader = imageLoader
    )
}