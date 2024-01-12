$(document).ready(function() {
    // Pobranie danych z endpointu /api/movies
    $.get("/api/movies", function(data) {
        // Wyświetlenie filmów na stronie
        displayMovies(data);
    });
});

function displayMovies(movies) {
    var moviesListDiv = $("#movies-list");

    // Iteracja przez filmy i dodanie do strony
    movies.forEach(function(movie) {
        var movieDiv = $("<div class='movie' data-movie-name='" + movie.movie_name + "'>");
        movieDiv.append("<h3>" + movie.movie_name + "</h3>");
        movieDiv.append("<p>Date: " + formatDate(movie.date) + "</p>");
        moviesListDiv.append(movieDiv);

        // Dodanie obsługi kliknięcia
        movieDiv.click(function() {
            var movieName = $(this).data("movie-name");
            window.location.href = "/" + encodeURIComponent(movieName) + "/ticket";
        });
    });
}

function formatDate(dateString) {
    var options = { year: 'numeric', month: 'long', day: 'numeric', hour: 'numeric', minute: 'numeric', second: 'numeric', timeZoneName: 'short' };
    return new Date(dateString).toLocaleDateString('en-US', options);
}
