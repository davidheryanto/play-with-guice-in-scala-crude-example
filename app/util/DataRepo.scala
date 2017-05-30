package util


/**
  * TODO
  */
trait DataRepo {
  /**
    *
    * @param filePath
    * @return
    */
  def read(filePath: String): Array[Byte]

  /**
    *
    * @param filePath
    * @param delimiter
    * @return
    */
  def readCsv(filePath: String, delimiter: Char = ','): Seq[Seq[String]]

  /**
    *
    * @param filePath
    * @param delimiter
    * @return
    */
  def readCsvAsMap(filePath: String, delimiter: Char = ','): Seq[Map[String, String]]

  /**
    *
    * @param filePath
    * @return
    */
  def readLines(filePath: String): Seq[String]

  /**
    *
    * @param data
    * @param filePath
    */
  def write(data: Array[Byte], filePath: String)

  /**
    *
    * @param data
    * @param filePath
    * @param delimiter
    */
  def writeCsv(data: Seq[Seq[Any]], filePath: String, delimiter: Char = ',')

  /**
    *
    * @param data
    * @param filePath
    */
  def writeLines(data: Seq[String], filePath: String)
}
