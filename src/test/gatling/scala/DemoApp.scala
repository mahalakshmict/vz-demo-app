
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class DemoApp extends Simulation {

	val httpProtocol = http
		.baseUrl("http://localhost:8080")
		.inferHtmlResources()
		.doNotTrackHeader("1")
		.userAgentHeader("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.11 Safari/537.36")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "en-US,en;q=0.9,nl;q=0.8",
		"Cache-Control" -> "max-age=0",
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "none",
		"Sec-Fetch-User" -> "?1",
		"Upgrade-Insecure-Requests" -> "1",
		"sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_1 = Map(
		"Origin" -> "http://localhost:8080",
		"sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_2 = Map(
		"Accept" -> "text/css,*/*;q=0.1",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "en-US,en;q=0.9,nl;q=0.8",
		"Sec-Fetch-Dest" -> "style",
		"Sec-Fetch-Mode" -> "no-cors",
		"Sec-Fetch-Site" -> "same-origin",
		"sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_7 = Map(
		"Accept" -> "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "en-US,en;q=0.9,nl;q=0.8",
		"Sec-Fetch-Dest" -> "image",
		"Sec-Fetch-Mode" -> "no-cors",
		"Sec-Fetch-Site" -> "same-origin",
		"sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
		"sec-ch-ua-mobile" -> "?0")

    val uri2 = "https://fonts.gstatic.com/s/roboto/v20"
    val uri3 = "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0"

	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0)
			.resources(http("request_1")
			.get(uri3 + "/css/all.min.css")
			.headers(headers_1),
            http("request_2")
			.get("/styles/main.css")
			.headers(headers_2),
            http("request_3")
			.get(uri3 + "/webfonts/fa-brands-400.woff2")
			.headers(headers_1),
            http("request_4")
			.get(uri3 + "/webfonts/fa-solid-900.woff2")
			.headers(headers_1),
            http("request_5")
			.get(uri2 + "/KFOlCnqEu92Fr1MmSU5fBBc4.woff2")
			.headers(headers_1),
            http("request_6")
			.get(uri2 + "/KFOmCnqEu92Fr1Mu4mxK.woff2")
			.headers(headers_1),
            http("request_7")
			.get("/images/suriname.jpg")
			.headers(headers_7),
            http("request_8")
			.get("/images/suriname.jpg")
			.headers(headers_7)))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}