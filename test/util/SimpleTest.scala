package util

import java.io.File

import com.google.inject.{Guice, Injector}
import modules.{GCloudDataModule, LocalDataModule}
import org.scalatest.FlatSpec

class SimpleTest extends FlatSpec {
//  val injector: Injector = Guice.createInjector(new LocalDataModule)
  val injector: Injector = Guice.createInjector(new GCloudDataModule)
  val dataRepo: DataRepo = injector.getInstance(classOf[DataRepo])

  "LocalDataRepo" should "return the correct number of bytes" in {
    val data = dataRepo.read("data/classic-rock-raw-data.csv")
    val size = data.length
    println(s"Size of file is $size")
  }

  it should "return write the correct number of bytes" in {
    val data = dataRepo.read("data/classic-rock-raw-data.csv")
    val originalSize = data.length
    val outputPath = "data/out"
    dataRepo.write(data, outputPath)
    val writtenSize = new File(outputPath).length
    println(s"Original size vs written size: $originalSize vs $writtenSize")
  }

  it should "write the correct delimiter" in {
    val data = List(List(1, 2, 3), List(4, 5, 6))
    dataRepo.writeCsv(data, "data/out.csv", delimiter = '+')
  }

  it should "read the correct delimiter" in {
    println(dataRepo.readCsv("data/out.csv"))
    println(dataRepo.readCsv("data/out.csv", delimiter = '+'))
  }


  it should "read the correct number of lines" in {
    assertResult(6513) {
      dataRepo.readLines("data/agaricus.txt.train").length
    }
  }
}
