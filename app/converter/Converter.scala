package converter

import models.{Airport, Country, ReportResult, Runway}
import play.api.libs.json.{Json, Writes}

object JsonConverter {

  implicit val airportWrites = new Writes[Airport] {
    def writes(airport: Airport) = Json.obj(
      "name" -> airport.name,
      "atype" -> airport.atype,
      "id" -> airport.id,
      "ident" -> airport.ident,
      "iso_country" -> airport.iso_country
    )
  }

  implicit val runwayWrites = new Writes[Runway] {
    def writes(runway: Runway) = Json.obj(
      "airport_ident" -> runway.airport_ident,
      "airport_ref" -> runway.airport_ref,
      "id" -> runway.id,
      "length_ft" -> runway.length_ft,
      "width_ft" -> runway.width_ft,
      "surface" -> runway.surface
    )
  }

  implicit val countryWrites = new Writes[Country] {
    def writes(country: Country) = Json.obj(
      "name" -> country.name,
      "code" -> country.code,
      "keywords" -> country.keywords,
      "name" -> country.name,
      "wikipedia_link" -> country.wikipedia_link,
      "id" -> country.id

    )
  }

  implicit val reportWriter = new Writes[ReportResult] {
    def writes(place: ReportResult) = Json.obj(
      "commonRunway" -> place.commonRunway,
      "hAirport" -> place.hAirport,
      "lAirport" -> place.lAirport,
      "runwaysCountry" -> place.runwaysCountry
    )
  }
}
