package util

class GCloudDataRepo extends LocalDataRepo {
  override def read(filePath: String): Array[Byte] = {
    println("This is GCloud")
    super.read(filePath)
  }

  override def readCsv(filePath: String, delimiter: Char): Seq[Seq[String]] = {
    println("This is GCloud")
    super.readCsv(filePath, delimiter)
  }

  override def readCsvAsMap(filePath: String, delimiter: Char): Seq[Map[String, String]] = super.readCsvAsMap(filePath, delimiter)

  override def readLines(filePath: String): Seq[String] = super.readLines(filePath)

  override def write(data: Array[Byte], filePath: String): Unit = super.write(data, filePath)

  override def writeCsv(data: Seq[Seq[Any]], filePath: String, delimiter: Char): Unit = super.writeCsv(data, filePath, delimiter)

  override def writeLines(data: Seq[String], filePath: String): Unit = super.writeLines(data, filePath)
}
