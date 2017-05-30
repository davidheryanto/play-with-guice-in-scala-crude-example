import play.api.ApplicationLoader
import play.api.inject.guice.{GuiceApplicationBuilder, GuiceApplicationLoader}

class MyApplicationLoader extends GuiceApplicationLoader {
  override protected def builder(context: ApplicationLoader.Context): GuiceApplicationBuilder = {
    super.builder(context)

  }
}
