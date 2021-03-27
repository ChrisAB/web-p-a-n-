package DataCollector

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.javadsl.model.headers.HttpCredentials
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.model.headers.{BasicHttpCredentials, RawHeader}
import akka.http.scaladsl.unmarshalling.{FromEntityUnmarshaller, Unmarshal}
import play.api.libs.json.{Format, JsValue, Json, Reads}

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt

object DataPool {

  def getAllData = {
    val covidVaccinations = Await.result(
      singleRequest(
        "https://prod.greatescape.co/api/travel/countries/PT/corona/",
        List(
          RawHeader(
            "Authorization",
            "310dec693cf7176b37c859f3ae6f596e7fc24ea8a58b580148754292c6e42590"
          )
        )
      ),
      10.seconds
    )

    //println(covidVaccinations)
    implicit val fjs: Reads[List[CovidVaccination]] =

    val jsonList: List[CovidVaccination] =
      Json.parse(covidVaccinations).as[List[CovidVaccination]]
    //val filteredList: List[JsValue] = jsonList.filter(json => (json \ "android").as[Boolean])

//    println(jsonList)

//    val hotels = Await.result(singleRequest(
//          "test.api.amadeus.com/v2"
//        ), 10.seconds)

  }

  private def singleRequest(givenUri: String, headers: Seq[HttpHeader]) = {
    implicit val system = ActorSystem(Behaviors.empty, "SingleRequest")
    implicit val executionContext = system.executionContext

    val request = HttpRequest(HttpMethods.GET, givenUri).withHeaders(headers)
    for {
      response <- Http().singleRequest(request)
      content <- Unmarshal(response.entity).to[String]
    } yield content
  }
}
