/*
$(document).ready(function() {
    // Pobranie danych z endpointu /api/screenings
    $.get("http://localhost:8080/api/screenings", function(data) {
        // Wyświetlenie seansów na stronie
        renderScreenings(data);
    });

    // Dodanie obsługi kliknięcia
    $("#screening-container").on("click", ".screening-card", function() {
        // Pobranie filmu z karty seansu
        var movieName = $(this).find("h3").text();

        // Przeniesienie na odpowiednią stronę
        window.location.href = "/" + encodeURIComponent(movieName);
    });
});

function createScreeningCard(screening) {
    var card = $("<div class='screening-card'>");
    card.append("<h3>" + screening.movieName + "</h3>");
    card.append("<p>Date: " + new Date(screening.date).toLocaleString() + "</p>");
    card.append("<p>Auditorium: " + screening.auditoriumName + "</p>");
    return card;
}

function renderScreenings(screenings) {
    var screeningContainer = $("#screening-container");

    // Iteracja przez seanse i dodanie do strony
    screenings.forEach(function(screening) {
        var card = createScreeningCard(screening);
        screeningContainer.append(card);
    });
}
*/
function exploreScreenings() {
    window.location.href = "/screenings"
}