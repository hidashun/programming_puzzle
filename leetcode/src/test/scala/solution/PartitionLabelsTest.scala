package solution

import org.scalatest.FunSuite

class PartitionLabelsTest extends FunSuite {
  test("1") {
    val result = PartitionLabels.Solution.partitionLabels(
      "ababcbacadefegdehijhklij"
    )
    assert(result == List(9, 7, 8))
  }

  test("2") {
    val result = PartitionLabels.Solution.partitionLabels(
      "eccbbbbdec"
    )
    assert(result == List(10))
  }


  test("3") {
    val result = PartitionLabels.Solution.partitionLabels(
      "caedbdedda"
    )
    assert(result == List(1, 9))
  }
}
