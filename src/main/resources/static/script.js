$(document).ready(function() {
    // Pobranie danych z endpointu /api/screenings
    $.get("http://localhost:8080/api/screenings", function(data) {
        // Wyświetlenie seansów na stronie
        renderScreenings(data);
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
