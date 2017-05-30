package modules

import com.google.inject.AbstractModule
import util.{DataRepo,LocalDataRepo}

class LocalDataModule extends AbstractModule {
  override def configure(): Unit = {
    bind(classOf[DataRepo]).to(classOf[LocalDataRepo])
  }
}
