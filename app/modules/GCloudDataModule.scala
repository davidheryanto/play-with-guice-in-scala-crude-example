package modules

import com.google.inject.AbstractModule
import util.{DataRepo, GCloudDataRepo, LocalDataRepo}

class GCloudDataModule extends AbstractModule {
  override def configure(): Unit = {
    bind(classOf[DataRepo]).to(classOf[GCloudDataRepo])
  }
}
