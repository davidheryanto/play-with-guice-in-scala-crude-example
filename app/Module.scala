import com.google.inject.AbstractModule
import com.google.inject.name.Names
import util.{DataRepo, GCloudDataRepo, LocalDataRepo}

class Module extends AbstractModule {
  def configure(): Unit = {

    bind(classOf[DataRepo])
      .annotatedWith(Names.named("local"))
      .to(classOf[LocalDataRepo])

    bind(classOf[DataRepo])
      .annotatedWith(Names.named("gcloud"))
      .to(classOf[GCloudDataRepo])
  }
}