package com.waleed.cariad

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.waleed.cariad.ui.MovieViewModel
import com.waleed.cariad.ui.model.Movie
import com.waleed.cariad.ui.theme.CariadTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CariadTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {

                    val viewModel : MovieViewModel = hiltViewModel()
                    MovieListScreen(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CariadTheme {
        Greeting("Android")
    }
}

@Composable
fun MovieListScreen (viewModel: MovieViewModel){
    val movies = viewModel.movies.collectAsState().value
    LazyColumn(modifier= Modifier.fillMaxSize()){
        items(movies) { movie ->
            MovieItem(movie)
        }
    }
}

@Composable
fun MovieItem(movie: Movie) {
    Card (modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()) {
        Column (){
            Text(text = movie.title)
            Text (text = "Rating: ${movie.rating}"  )
            Text (text = "Year : ${movie.year}")
        }
    }

}


/*
[
  { "title": "Inception", "rating": 8.8, "year": 2010 },
  { "title": "The Dark Knight", "rating": 9.0, "year": 2008 },
  { "title": "Interstellar", "rating": 8.6, "year": 2014 },
  { "title": "Dunkirk", "rating": 7.9, "year": 2017 },
  { "title": "Memento", "rating": 8.4, "year": 2000 },
  { "title": "The Prestige", "rating": 8.5, "year": 2006 },
  { "title": "Batman Begins", "rating": 8.2, "year": 2005 },
  { "title": "Avatar", "rating": 7.5, "year": 2009 },
  { "title": "Up", "rating": 8.3, "year": 2009 },
  { "title": "The Matrix", "rating": 8.7, "year": 1999 },
  { "title": "Toy Story 3", "rating": 8.3, "year": 2010 }
]
 */