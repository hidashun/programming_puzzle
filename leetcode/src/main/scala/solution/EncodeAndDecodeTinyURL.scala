package solution

import java.io.ByteArrayOutputStream
import java.nio.charset.Charset
import java.util.zip.GZIPOutputStream

import scala.collection.mutable

object EncodeAndDecodeTinyURL {

  class Codec {
    val urlMap: mutable.Map[String, String] = scala.collection.mutable.Map()

    // Encodes a URL to a shortened URL.
    def encode(longURL: String): String = {
      val key = java.util.UUID.randomUUID.toString
      urlMap(key) = longURL
      key
    }

    // Decodes a shortened URL to its original URL.
    def decode(shortURL: String): String = {
      urlMap.getOrElse(shortURL, "")
    }
  }

  def solve(longURL: String): String = {
    val obj = new Codec()
    val s = obj.encode(longURL)
    val ans = obj.decode(s)
    ans
  }
}
