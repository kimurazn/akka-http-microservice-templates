package io.github.gabfssilva.features

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.testkit.ScalatestRouteTest
import io.github.gabfssilva.modules.AllModules
import org.scalatest.{FeatureSpec, Matchers}

class HealthCheckEndpointFeature
  extends FeatureSpec
    with Matchers
    with ScalatestRouteTest {

  val modules = new AllModules
  val route = modules.endpoints.routes

  feature("health check api") {
    scenario("successful get") {
      Get(s"/api/health-check") ~> route ~> check {
        status shouldBe StatusCodes.OK
        responseAs[String] shouldBe "ok"
      }
    }
  }
}