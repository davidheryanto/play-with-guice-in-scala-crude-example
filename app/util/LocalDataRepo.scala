package util

import java.io.{BufferedWriter, File, FileOutputStream, FileWriter}
import java.nio.file.{Files, Paths}

import com.github.tototoshi.csv.{CSVReader, CSVWriter, DefaultCSVFormat}
import com.google.inject.Singleton

import scala.io.Source

@Singleton
class LocalDataRepo extends BaseDataRepo {

  class CSVFormat(_delimiter: Char) extends DefaultCSVFormat {
    override val delimiter: Char = _delimiter
  }

  override def read(filePath: String): Array[Byte] = {
    Files.readAllBytes(Paths.get(filePath))
  }

  override def readCsv(filePath: String, delimiter: Char): Seq[Seq[String]] = {
    CSVReader.open(new File(filePath))(new CSVFormat(delimiter)).all()
  }

  override def readCsvAsMap(filePath: String, delimiter: Char): Seq[Map[String, String]] = {
    CSVReader.open(new File(filePath))(new CSVFormat(delimiter)).allWithHeaders()
  }

  override def readLines(filePath: String): Seq[String] = {
    Source.fromFile(filePath).getLines().toList
  }

  override def write(data: Array[Byte], filePath: String): Unit = {
    new FileOutputStream(new File(filePath)).write(data)
  }

  override def writeCsv(data: Seq[Seq[Any]], filePath: String, delimiter: Char): Unit = {
    CSVWriter.open(new File(filePath))(new CSVFormat(delimiter)).writeAll(data)
  }

  override def writeLines(data: Seq[String], filePath: String): Unit = {
    new BufferedWriter(new FileWriter(filePath)).write(data.mkString(scala.util.Properties.lineSeparator))
  }

}
